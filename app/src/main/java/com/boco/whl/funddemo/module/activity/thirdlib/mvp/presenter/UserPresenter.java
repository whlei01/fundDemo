package com.boco.whl.funddemo.module.activity.thirdlib.mvp.presenter;

import com.boco.whl.funddemo.module.activity.annndroid.mvp.view.IUserView;
import com.boco.whl.funddemo.module.activity.thirdlib.mvp.model.IUserModel;
import com.boco.whl.funddemo.module.activity.thirdlib.mvp.model.UserBean;
import com.boco.whl.funddemo.module.activity.thirdlib.mvp.model.UserModel;

/**
 * <pre>
 *  author : honglei92
 *  desc :
 *  blog :
 *  createtime : 2017/5/15 0015 10:39
 *  updatetime : 2017/5/15 0015 10:39
 * </pre>
 */
public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        this.mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser(String id, String firstName, String lastName) {
        mUserModel.setId(id);
        mUserModel.setUsername(firstName);
        mUserModel.setPassword(lastName);
    }

    public void loadUser(String id) {
        UserBean user = mUserModel.loadUser(id);
        mUserView.setUsername(user.getUsername());//通过调用IUserView的方法来更新显示
        mUserView.setPassword(user.getPassword());
    }

}
