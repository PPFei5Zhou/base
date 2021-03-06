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
      let prefixUrl = '/UserMenu';

      $.ajax({
         url: prefixUrl + '/GetMenuLevel',
         method: 'get',
         dataType: 'json',
         success: function (data) {
            if (data.result) {
               let option = '';
               $.each(data.obj, function (index, item) {
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
            freedom: [{menubarId: 'btnInsertMenu', handler:function (node) {
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
            }}],
            group:[] // 按钮组制空
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