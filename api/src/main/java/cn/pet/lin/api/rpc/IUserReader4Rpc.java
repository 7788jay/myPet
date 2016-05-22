package cn.pet.lin.api.rpc;

import cn.pet.lin.domain.user.User;

/**
 * Created by lwt on 2016/5/21.
 */
public interface IUserReader4Rpc {

    User getUserByCode(String code);
}
