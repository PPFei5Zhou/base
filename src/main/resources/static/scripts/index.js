let tab = $(".layui-tab-title li[lay-id]");

$(function() {
    layui.use(['form', 'layer', 'element', "jquery"], function() {
        let element = layui.element;
        let $ = layui.$;
        let form = layui.form;

        RenderUserInfo();
        renderUserMenu();

        // 配置tab实践在下面无法获取到菜单元素
        $(".site-demo-active").on("click", function () {
            let dataid = $(this);
            //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
            if (tab.length <= 0) {
                //如果比零小，则直接打开新的tab项
                active.tabAdd(
                    dataid.attr("data-url"),
                    dataid.attr("data-id"),
                    dataid.attr("data-title")
                );
            } else {
                //否则判断该tab项是否以及存在
                let isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"), function () {
                    //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                    if ($(this).attr("lay-id") === dataid.attr("data-id")) {
                        isData = true;
                    }
                });
                if (isData === false) {
                    //标志为false 新增一个tab项
                    active.tabAdd(
                        dataid.attr("data-url"),
                        dataid.attr("data-id"),
                        dataid.attr("data-title")
                    );
                }
            }
            //最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange(dataid.attr("data-id"));
        });
        let active = {
            //在这里给active绑定几项事件，后面可通过active调用这些事件
            tabAdd: function (url, id, name) {
                //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
                //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
                element.tabAdd("tabList", {
                    title: name,
                    content:
                        '<iframe data-frameid="' +
                        id +
                        '" frameborder="0" src="' +
                        url +
                        '" style="width:100%;height:99%;"></iframe>',
                    id: id, //规定好的id
                });
                FrameWH(); //计算iframe层的大小
            },
            tabChange: function (id) {
                //切换到指定Tab项
                element.tabChange("tabList", id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("tabList", id); //删除
            },
        };
        //刷新界面 所有元素
        element.init();
        form.render();

        function FrameWH() {
            let h = $(window).height() - 128;
            $("iframe").css("height", h + "px");
        }

        function renderUserMenu() {
            $.ajax({
                url: '/UserMenu/SelectEntities',
                async: false,
                type: 'get',
                data: {
                    menuLevel: 0,
                    page: 1,
                    limit: 100
                },
                dataType: 'json',
                success: function (result) {
                    if (result && result.length > 0) {
                        let _html = renderUserMenuHtml(result);
                        if (_html) {
                            $('#dlUserMenu').html(_html);
                        }
                    }
                },
                complete: function () {
                    form.render();
                }
            });
        }

        function renderUserMenuHtml(child) {
            let _html = '';
            if (child && child.length > 0) {
                $.each(child, function (index, item) {
                    if (item.childMenu && item.childMenu.length > 0) {
                        _html += '<li><a href="javascript:">' + item.menuName + '</a><dl class="layui-nav-child">';
                        _html += '';
                        _html += renderUserMenuHtml(item.childMenu);
                        _html += '</dl></li>';
                    } else {
                        _html += '<dd><a href="javascript:" class="site-demo-active" data-id="' + item.id + '" data-title="' + item.menuName + '" data-type="tabAdd" data-url="' + item.menuUrl + '">' + item.menuName + '</a></dd>';
                    }
                });
            }
            return _html;
        }
    });
});

function RenderUserInfo() {
    $.ajax({
        url: '/User/GetSessionUser',
        async: false,
        type: 'get',
        dataType: 'json',
        success: function(result) {
            if (result) {
                $('#labelUserName').text(result.userName);
            }
        }
    });
}