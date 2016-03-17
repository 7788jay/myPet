/**自定义过滤**/
avalon.filters.imgFilter = function (value, args, args2) {
    return value;
}
avalon.filters.OrderStatusFilter = function (value, args, args2) {
    var arr = ["未审核","已确认","已发货","完成","已取消"];
    return arr[value];
}

/**方法**/
function getQueryCode(){
    var reg = new RegExp("(^|&)code=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    return r[2];
}