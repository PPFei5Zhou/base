$(function(){
    layui.use(['layer'], function() {
        let layer = layui.layer;
        
        $('#btnLogin').click(function() {
            login();
        });

        $('#imgVerifyCode').bind("click", function() {
            refreshVerifyCode();
        });

        $('body').keydown(function(event) {
            if (event.which === 13) {
                login();
            }
        });

        function refreshVerifyCode() {
            $("#imgVerifyCode").attr('src', 'GetVerifyCode?random=' + Math.random());
            $('#inputVerifyCode').val('');
        }

        function login() {
            let useranme = $('#inputUsername').val();
            let password = $('#inputPassword').val();
            let verifyCode = $('#inputVerifyCode').val();
            let layerIndex = 0;
        
            if (!useranme) {
                layer.tips('输入账号', '#inputUsername');
                return;
            }
        
            if (!password) {
                layer.tips('输入密码', '#inputPassword');
                return;
            }
        
            if (!verifyCode) {
                layer.tips('输入验证码', '#inputVerifyCode');
                return;
            }
        
            $.ajax({
                url: 'Login',
                type: 'post',
                dataType: 'json',
                data: {
                    username: useranme,
                    password: password,
                    verifyCode: verifyCode
                },
                beforeSend: function() {
                    layerIndex = layer.load();
                },
                success: function(data) {
                    if (data.result) {
                        window.location.replace("Index");
                    } else {
                        layer.alert(data.message);
                    }
                },
                error: function(XMLHttpRequest) {
                    if (XMLHttpRequest.responseJSON) {
                        layer.alert(XMLHttpRequest.responseJSON.message);
                    }
                },
                complete: function() {
                    layer.close(layerIndex);
                }
            });
        };
    });
});