//初始化完成
avalon.ready(function () {
    var vm = avalon.define({
        $id: "register",
        code: "",            //账号
        username: "",        //用户名
        phone: "",           //手机号
        password: "",        //密码
        password1: "",       //确认密码
        //回车登录
        enter: function (event) {
            if (event.keyCode == 13) {
                vm.register();
            }
        },
        //登录
        register: function () {
            if (vm.code == "") {
                layer.alert('请输入账号！');
                return;
            }
            if (vm.username == "") {
                layer.alert('请输入用户名！');
                return;
            }
            if (vm.phone == "" || vm.phone.length < 11) {
                layer.alert('请输入正确手机号！');
                return;
            }
            if (vm.password == "") {
                layer.alert('请输入密码');
                return;
            }
            if (vm.password != vm.password1) {
                layer.alert('两次密码不一致！');
                return;
            }
            $.ajax({
                url: "/admin/user/user/register",
                cache: false,
                type: "post",
                dataType: "json",
                data: {
                    code: vm.code,
                    userName: vm.username,
                    phone:vm.phone,
                    password: vm.password
                },
                beforeSend: function () {
                    layer.load(0);
                },
                complete: function () {
                    layer.closeAll('loading');
                },
                success: function (res) {
                    if (res.success) {
                        sessionStorage.setItem("isLoad", true);
                        layer.alert("注册成功,请登录！",function(){
                            window.location = "/login.html";
                        });
                    } else {
                        layer.alert(res.msg);
                    }
                },
                error: function (res) {
                    avalon.log("登录返回失败", res);
                    layer.alert('您输入的密码有误，请重新输入。');
                }
            });
        },
        //登录
        login: function(){
            window.location.href = "/login.html";
        }
    });

    avalon.scan();
})