package com.easy.base.utils;

import java.util.List;

import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmbUtil {
    @Value("${smb.name}")
    private String name;

    @Value("${smb.password}")
    private String password;

    @Value("${smb.ip}")
    private String ip;

    @Value("${smb.folder}")
    private String folder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void connect() {
        SMBClient smbClient = null;
        Connection connection = null;
        Session session = null;
        DiskShare diskShare = null;

        try {
            smbClient = new SMBClient();
            connection = smbClient.connect(ip);
            AuthenticationContext auth = new AuthenticationContext(name, password.toCharArray(), "");
            session = connection.authenticate(auth);
            diskShare = (DiskShare) session.connectShare(folder);
            List<FileIdBothDirectoryInformation> list = diskShare.list("");
            for(FileIdBothDirectoryInformation item : list) {
                logger.info(item.getFileName());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (diskShare != null) {
                    diskShare.close();
                }

                if (session != null) {
                    session.close();
                }

                if (connection != null) {
                    connection.close();
                }

                if (smbClient != null) {
                    smbClient.close();
                }
            } catch (Exception e) {
                logger.error("Close resource failed, %s", e.getMessage());
            }
        }
    }
}