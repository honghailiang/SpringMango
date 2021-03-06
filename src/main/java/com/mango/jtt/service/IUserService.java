/**
 *
 */
package com.mango.jtt.service;

import com.mango.jtt.po.MangoUser;

import java.util.List;

/**
 * @author HHL
 *
 * @date 2016年12月8日
 */
public interface IUserService {

    public MangoUser getUserByName(String name);

    List<MangoUser> getUserList();

    void saveUser(MangoUser mangoUser);
}
