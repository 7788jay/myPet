//qtip最顶部
$.fn.qtip.zindex = 99999999;
//角色列表
var roleMap = {
    1: '教师',
    2: '家长',
    4: '学生',
    8: '教育机构'
};
/**自定义过滤**/
avalon.filters.statusFilter = function (value, args, args2) {
    return value == 0 ? "<font color='green'>启用</font>" : "<font color='red'>停用</font>";
}
avalon.filters.accessTypeFilter = function (value, args, args2) {
    return value == 0 ? "内部" : "外部";
}
avalon.filters.deviceTypeFilter = function (value, args, args2) {
    var str = "";
    switch (value) {
        case 0:
            str = "PC";
            break;
        case  1:
            str = "APP";
            break;
    }
    return str;
}
avalon.filters.projectTypeFilter = function (value, args, args2) {
    var str = "";
    switch (value) {
        case 4:
            str = "校级";
            break;
        case  3:
            str = "县/区级";
            break;
        case  2:
            str = "市级";
            break;
        case  1:
            str = "省级";
            break;
    }
    return str;
}
avalon.filters.roleIdsFilter = function (value, args, args2) {
    var str = "";
    if (typeof(value) == "undefined") {
        return str;
    }
    var arr = value.split(",");
    $(arr).each(function (index) {
        str += roleMap[arr[index]] + "，";
    });
    str = str.substr(0, str.length - 1);
    return str;
}

/** 复选框是否全选 **/
function isSelectedAll(item) {
    if (item.status == 1) {
        return item.checked;
    } else {
        return true;
    }
}
/*********************************************************************
 *                    扩展方法                                  *
 **********************************************************************/
// js中String添加replaceAll 方法
String.prototype.replaceAll = function (a, b) {
    var reg = new RegExp(a, "g");
    return this.replace(reg, b);
};
// js中String添加startWith方法
String.prototype.startWith = function (str) {
    var reg = new RegExp("^" + str);
    return reg.test(this);
}
// js中String添加endWith方法
String.prototype.endWith = function (str) {
    var reg = new RegExp(str + "$");
    return reg.test(this);
}
/**通用方法**/
function isSuccess(result) {
    var rtnCode = result.rtnCode;
    if (rtnCode == '0100001' || rtnCode == '0000000' || rtnCode == '0100002')
        return true;
    return false;
}
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
//string（1，2）转换整型数组
function parseToIntArr(str) {
    var arr = [];
    if (typeof(str) == "undefined") return arr;
    $(str.split(",")).each(function (i, value) {
        arr.push(parseInt(value));
    })
    return arr;
}
//key值
var ROLEDATA = "roleData";
var APPCATEGORYDATA = "AppCategoryData";
//加载角色列表
function getRoleData(reload) {
    var isReload = arguments[0] || false;
    if (store.has(ROLEDATA) && !isReload) {
        return store.get(ROLEDATA);
    } else {
        $.ajax({
            url: "/admin/qky/common/getRoles",
            type: "GET",
            cache: false,
            dataType: 'json',
            success: function (result) {
                if (isSuccess(result)) {
                    store.set(ROLEDATA, result.bizData);
                }
            }
        })
    }
}
//加载子应用分类列表
function getAppCategoryData(reload) {
    var isReload = arguments[0] || false;
    if (store.has(APPCATEGORYDATA) && !isReload) {
        return store.get(APPCATEGORYDATA);
    } else {
        $.ajax({
            url: "/admin/qky/appCategory/getAll",
            type: "GET",
            cache: false,
            dataType: 'json',
            success: function (result) {
                if (isSuccess(result)) {
                    store.set(APPCATEGORYDATA, result.bizData);
                }
            }
        })
    }
}
//读取cookies
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}
//设置cookie
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
//清除cookie
function clearCookie(name) {
    setCookie(name, "", -1);
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

//应用代码（QKY+XX）
jQuery.validator.addMethod("isAppCode", function (value, element) {
    if (value.length < 4 || !value.startWith("QKY"))
        return false;
    return this.optional(element) || /^\w+$/.test(value);
}, "格式：QKY+字符（英文字母、数字、下划线）");