package cn.pet.lin.realm;

import cn.pet.lin.domain.param.sys.UserParam;
import cn.pet.lin.domain.sys.User;
import cn.pet.lin.service.sys.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lin on 2016/1/13.
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    IUserService userService;

    /**
     * 用于授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    /**
     * 用于认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //取出身份信息
        String userCode = (String) token.getPrincipal();
        //数据查找是否存在用户，没有返回空
        User user = userService.findOne(UserParam.F_Code,userCode);
        if(user==null){
            return null;
        }
        String password = user.getPassword();

        //查询到就返回认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,password,this.getName());

        return simpleAuthenticationInfo;
    }
}
