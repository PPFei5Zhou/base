let editForm = $('#editForm');
let hiddenId = $('#hiddenId');
let inputMenuLevel = $('#inputMenuLevel');
let selectParentId = $('#selectParentId');
let inputMenuUrl = $('#inputMenuUrl');
let inputMenuName = $('#inputMenuName');
let inputValid = $('#inputValid');
let btnSave = $('#btnSave');

$(function () {
    layui.use(['form', 'layer'], function () {
        let form = layui.form;
        let layer = layui.layer;
        let prefixUrl = '/UserMenu';
        let layerIndex;
        let id = $.getUrlParam("id");
        let parentId = $.getUrlParam("parentId");
        let levelCode = $.getUrlParam('levelCode');

        if (id) {
            hiddenId.val(id);
            inputMenuLevel.val(levelCode);
            $.ajax({
                url: prefixUrl + '/SelectEntityByID',
                type: 'get',
                data: {id: id},
                dataType: 'json',
                beforeSend: function () {
                    if (levelCode > 0) renderSelect(levelCode - 1);
                    layerIndex = layer.load();
                },
                success: function (data) {
                    if (data && data.result && data.obj) {
                        let obj = data.obj;
                        hiddenId.val(obj.id);
                        selectParentId.val(obj.parentId);
                        inputMenuUrl.val(obj.menuUrl);
                        inputMenuName.val(obj.menuName);
                        inputValid.prop("checked", obj.valid);
                    }
                },
                complete: function () {
                    layer.close(layerIndex);
                    form.render();
                }
            });
        } else {
            if (levelCode > 0) renderSelect(levelCode - 1);
            inputMenuLevel.val(levelCode);
            selectParentId.val(parentId);
        }

        btnSave.on('click', function () {
            let obj = editForm.serializeObject();
            let url;

            if (obj.id && obj.id !== '') {
                url = '/UpdateEntity';
            } else {
                url = '/InsertEntity'
            }

            $.ajax({
                url: prefixUrl + url,
                type: 'post',
                data: obj,
                dataType: 'json',
                beforeSend: function () {
                    layerIndex = layer.close();
                },
                success: function (data) {
                    if (data.result) {
                        layer.msg('保存成功');
                        hiddenId.val(data.message);
                    } else {
                        layer.msg(data.message);
                    }
                },
                complete: function () {
                    layer.close(layerIndex);
                }
            });
        });

        function renderSelect(levelCode) {
            $.ajax({
                url: prefixUrl + '/SelectEntities',
                type: 'get',
                async: false,
                data: {
                    page: 1,
                    limit: 100,
                    menuLevel: levelCode
                },
                dataType: 'json',
                beforeSend: function () {
                    layerIndex = layer.load();
                },
                success: function (data) {
                    let html = '';
                    if(data.result) {
                        $.each(data.obj, function (index, item) {
                            html += '<option value="' + item.id + '">' + item.menuName + '</option>'
                        });
                        selectParentId.html(html);
                    }
                },
                complete: function () {
                    layer.close(layerIndex);
                    form.render('select');
                }
            });
        }

        form.render();
    });
});