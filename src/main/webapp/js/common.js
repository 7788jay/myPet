//qtip最顶部
$.fn.qtip.zindex = 99999999;

/**自定义过滤**/
avalon.filters.statusFilter = function (value, args, args2) {
    return value == 0 ? "<font color='green'>正常</font>" : "<font color='red'>锁定</font>";
}
avalon.filters.OrderStatusFilter = function (value, args, args2) {
    var arr = ["未审核","已确认","已发货","完成","已取消"];
    return arr[value];
}
avalon.filters.payTypeFilter = function (value, args, args2) {
    return value == 0 ? "在线支付" : "货到付款";
}
avalon.filters.userTypeFilter = function (value, args, args2) {
    return value == 0 ? "普通用户" : "管理员";
}
avalon.filters.sexFilter = function (value, args, args2) {
    return value == 0 ? "母" : "公";
}
avalon.filters.petStatusFilter = function (value, args, args2) {
    return value == 1 ? "<font color='green'>上架中</font>" : "<font color='red'>已下架</font>";
}
/******************************************************************
 *                    扩展方法                                  *
 **********************************************************************/

/**是否空**/
function isNull(value) {
    return typeof(value) == "undefined";
}
/**错误显示**/
function errorPlacement(error, element) {
    if (element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox
        var eid = element.attr('name'); //获取元素的name属性
        element = $("input[name='" + eid + "']").last().parent(); //将错误信息添加当前元素的父结点后面
    }
    if (!error.is(':empty')) {
        $(element).not('.valid').qtip({
            overwrite: false,
            content: error,
            hide: false,
            show: {
                event: false,
                ready: true
            },
            style: {
                classes: 'qtip-cream qtip-shadow qtip-rounded'
            },
            position: {
                my: 'top left',
                at: 'bottom right'
            }
        }).qtip('option', 'content.text', error);
    }
    else {
        element.qtip('destroy');
    }
}
//关闭所有提示
function closeAllTip() {
    $('.qtip').each(function () {
        $(this).data('qtip').destroy();
    })
}

/*扩展验证规则*/
// 判断英文字符
jQuery.validator.addMethod("isEnglish", function (value, element) {
    return this.optional(element) || /^[A-Za-z]+$/.test(value);
}, "只能包含英文字符。");

// 字符验证
jQuery.validator.addMethod("isStringCheck", function (value, element) {
    return this.optional(element) || /^\w+$/.test(value);
}, "只能包括英文字母、数字和下划线");

//顶部菜单跳转URL验证中文
jQuery.validator.addMethod("isURL", function (value, element) {
    return !(this.optional(element) || /[\u4E00-\u9FA5\uF900-\uFA2D]/.test(value));
}, "跳转地址格式不正确");
