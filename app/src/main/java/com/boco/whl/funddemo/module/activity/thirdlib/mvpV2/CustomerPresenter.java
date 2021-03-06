package com.boco.whl.funddemo.module.activity.thirdlib.mvpV2;


import com.boco.whl.funddemo.module.activity.thirdlib.mvp.model.IUserModel;
import com.boco.whl.funddemo.module.activity.thirdlib.mvp.model.UserBean;
import com.boco.whl.funddemo.module.activity.thirdlib.mvp.model.UserModel;

/**
 * <pre>
 *  author : honglei92
 *  desc :
 *  blog :
 *  createtime : 2017/5/22 0022 10:51
 *  updatetime : 2017/5/22 0022 10:51
 * </pre>
 */
public class CustomerPresenter implements CustomerContract.Presenter {
    private CustomerContract.View mView;
    private IUserModel mUserModel;

    public CustomerPresenter(CustomerContract.View mView) {
        this.mView = mView;
        mUserModel = new UserModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void saveUser(String id, String firstName, String lastName) {
        mUserModel.setId(id);
        mUserModel.setUsername(firstName);
        mUserModel.setPassword(lastName);
    }

    @Override
    public void loadUser(String id) {
        UserBean user = mUserModel.loadUser(id);
        mView.setUsername(user.getUsername());//通过调用IUserView的方法来更新显示
        mView.setPassword(user.getPassword());
    }

    @Override
    public void loadImage(String url) {
        mView.showImage(url);
    }
}
