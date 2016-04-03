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