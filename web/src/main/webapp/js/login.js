//初始化完成
avalon.ready(function () {
    var vm = avalon.define({
        $id: "login",
        username: "",        //用户名
        password: "",        //密码
        //回车登录
        enter: function (event) {
            if (event.keyCode == 13) {
                vm.login();
            }
        },
        //登录
        login: function () {
            if (vm.username == "") {
                layer.alert('请输入用户名');
                return;
            }
            if (vm.password == "") {
                layer.alert('请输入密码');
                return;
            }
            $.ajax({
                url: "/admin/login",
                cache: false,
                type: "post",
                dataType: "json",
                data: {code: vm.username, password: vm.password},
                beforeSend: function () {
                    layer.load(0);
                },
                complete: function () {
                    layer.closeAll('loading');
                },
                success: function (res) {
                    avalon.log('登录返回成功=', res);
                    if (res.success) {
                        sessionStorage.setItem("isLoad", true);
                        window.location = res.msg;
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
        //注册
        register: function(){
            console.log(1)
            window.location.href = "/register.html";
        }
    });

    avalon.scan();
})