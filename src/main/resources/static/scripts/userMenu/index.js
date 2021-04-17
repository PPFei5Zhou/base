let inputMenuName = $('#inputMenuName');
let selectMenuLevel = $('#selectMenuLevel');
let btnSearchMenu = $('#btnSearchMenu');

$(function (){
   layui.extend({
          dtree: 'dtree'
       }).use(['form', 'element', 'layer', 'dtree'], function (){
      let form = layui.form;
      let element = layui.element;
      let layer = layui.layer;
      let dtree = layui.dtree;
      let layerIndex = 0;
      let prefixUrl = '/UserMenu';

      $.ajax({
         url: prefixUrl + '/GetMenuLevel',
         method: 'get',
         dataType: 'json',
         success: function (result) {
            if (result) {
               let option = '';
               $.each(result, function (index, item) {
                  option += '<option value="' + item + '">' + item + '</option>'
               });
               selectMenuLevel.html(option);
               form.render('select');
            }
         }
      })

      dtree.render({
         elem: '#ulMenuTree',
         url: prefixUrl + '/GetDTree',
         method: 'get',
         dataType: 'json',
         request: {
            'level': 0,
            'page': 1,
            'limit': 200
         },
         skin: "diy",
         line: true,
         ficon: "-1",
         icon: "-1",
         checkbar: true,
         checkbarType: "p-casc",
         menubar: true,
         menubarTips: {
            freedom: [
                {menubarId: 'btnInsertMenu', handler:function (node) {
                  // 新增节点
                  let parentId = '';
                  let level = node.level;
                  let params = dtree.getCheckbarNodesParam("ulMenuTree");
                  if (params && params.length > 0) {
                     parentId = params[0].nodeId;
                     level = params[0].level;
                  }
                  layer.open({
                     type: 2,
                     area: ['500px', '500px'],
                     content: prefixUrl + '/Edit?parentId=' + parentId + '&levelCode=' + level + '&r=' + Math.random()
                  });
               }}, {menubarId: 'btnDeleteMenu', handler: function (node) {
                  // 删除节点
                  layer.confirm('是否要删除?', function (index) {
                     let ids = [];
                     let params = dtree.getCheckbarNodesParam("ulMenuTree");
                     $.each(params, function (index, item) {
                        ids.push(item.nodeId);
                     });

                     $.ajax({
                        url: '/UserMenu/RemoveEntity',
                        type: 'delete',
                        data: {ids: ids},
                        dataType: 'json',
                        beforeSend: function () {
                           layer.close(index);
                           layerIndex = layer.load();
                        },
                        statusCode: {
                           200: function () {
                              layer.msg('成功!');
                           }
                        },
                        error: function (XMLHttpRequest) {
                           if (XMLHttpRequest.responseText) {
                              let response = JSON.parse(XMLHttpRequest.responseText);
                              layer.alert(response ? response.message : '');
                           }
                        },
                        complete: function () {
                           let title = inputMenuName.val();
                           let level = selectMenuLevel.val();
                           layer.close(layerIndex);
                           dtree.reload('ulMenuTree', {
                              request: {
                                 'title': title,
                                 'level': level ? level : undefined,
                                 'page': 1,
                                 'limit': 200
                              }
                           });
                        }
                     });
                  });
               }
            }],
            group:["checkAll", "unCheckAll", "invertAll"] // 按钮组
         }
      });

      // 编辑节点
      dtree.on("node('ulMenuTree')", function (obj) {
         layer.open({
            type: 2,
            area: ['500px', '500px'],
            content: prefixUrl + '/Edit?id=' + obj.param.nodeId + '&levelCode=' + (Number(obj.param.level) - 1) + '&r=' + Math.random()
         });
      });

      btnSearchMenu.on('click', function() {
         let title = inputMenuName.val();
         let level = selectMenuLevel.val();
         dtree.reload('ulMenuTree', {
            request: {
               'title': title,
               'level': level ? level : undefined,
               'page': 1,
               'limit': 200
            }
         });
      });

      form.render();
      element.render();
   });
});