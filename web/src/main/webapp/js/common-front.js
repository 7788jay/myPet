
/**自定义过滤**/
avalon.filters.imgFilter = function (value, args, args2) {
    return value;
}
avalon.filters.OrderStatusFilter = function (value, args, args2) {
    var arr = ["未审核","已确认","已发货","完成","已取消"];
    return arr[value];
}
avalon.filters.sexFilter = function (value, args, args2) {
    return value == 0 ? "母" : "公";
}

/**方法**/
/**
 * 获取链接中指定参数值
 * @param name
 * @returns {*}
 */
function getQueryString(name){
    var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if(r != null && r.length>=3){
        return r[2];
    }else{
        return "";
    }
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