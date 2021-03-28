let Height = (window.screen.height * 0.5) + 'px';
let Width = (window.screen.width * 0.5) + 'px';

// layui form verify验证逻辑
let FormVerify = {
    RoleCode: [/^ROLE_[A-Z]+$/, '必须以[ROLE_]开头, 全大写'],
    PositiveInteger: [/^(0|^[1-9]\d*)$/, '请输入正整数!']
}

// 将form表单的数据封装成json对象
$.fn.serializeObject = function() {
    let o = {};
    let a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

//获取url及url参数
$.getUrlParam = function (name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}