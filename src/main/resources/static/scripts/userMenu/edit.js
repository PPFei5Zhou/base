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
        let levelCode = $.getUrlParam('levelCode');
        hiddenId.val(id);
        inputMenuLevel.val(levelCode);

        if (id) {
            $.ajax({
                url: prefixUrl + '/SelectEntityByID',
                type: 'get',
                data: {id: id},
                dataType: 'json',
                beforeSend: function () {
                    renderSelect();
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
                        form.render('select');
                        form.render('checkbox');
                    }
                },
                complete: function () {
                    layer.close(layerIndex);
                }
            })
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

        // TODO 要解决: 1级菜单编辑时, 父级菜单下拉框应该不显示, 新增2级菜单时, 父级菜单应该显示所有1级菜单
        function renderSelect() {
            if (levelCode > 0) {
                $.ajax({
                    url: prefixUrl + '/SelectEntities',
                    type: 'get',
                    data: {
                        page: 1,
                        limit: 100,
                        levelCode: levelCode - 1
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
        }

        form.render();
    });
});