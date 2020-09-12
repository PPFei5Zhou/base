$(function() {
    layui.use(['form', 'layer', 'element'], function() {
        let form = layui.form;
        let layer = layui.layer;
        let element = layui.element;

        RenderUserInfo();

        var active={
            tabAdd:function(url,id,name){
                element.tabAdd('contentnav',{
                    title:name,
                    content:'<iframe data-frameid="'+id+'" scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;"></iframe>',
                    id:id
                });
                iframeWH();
            },
            tabChange:function(id){
                element.tabChange('contentnav',id);
            },
            tabDelete:function(id){
                element.tabDelete('contentnav',id);
            },
            tabDeleteAll:function(ids){
                $.each(ids,function(index,item){
                    element.tabDelete('contentnav',item);
                });
            }
        };

        $(".site-url").on('click',function(){
            var nav=$(this);
            var length = $("ul.layui-tab-title li").length;
            if(length<=0){
                active.tabAdd(nav.attr("data-url"),nav.attr("data-id"),nav.attr("data-title"));
            }else{
                var isData=false;
                $.each($("ul.layui-tab-title li"),function(){
                    if($(this).attr("lay-id")==nav.attr("data-id")){
                        isData=true;
                    }
                });
                if(isData==false){
                    active.tabAdd(nav.attr("data-url"),nav.attr("data-id"),nav.attr("data-title"));
                }
                active.tabChange(nav.attr("data-id"));
            }
        });

        function iframeWH(){
            var H = $(window).height()-80;
            $("iframe").css("height",H+"px");
        }

        $(window).resize(function(){
            iframeWH();
        });

        element.init();
        form.render();
    });
});

function RenderUserInfo() {
    $.ajax({
        url: '/base/User/GetSessionUser',
        type: 'get',
        dataType: 'json',
        success: function(data) {
            if (data.result) {
                $('#labelUserName').text(data.obj.username);
            }
        }
    });
}