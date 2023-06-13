package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.user.User;
import com.mifos.api.model.LoginData;
import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
/**
 * Created by Rajan Maurya on 19/02/17.
 */
@Singleton
public class DataManagerAuth {

    private final BaseApiManager baseApiManager;

    @Inject
    public DataManagerAuth(BaseApiManager baseApiManager) {
        this.baseApiManager = baseApiManager;
    }

    /**
     * @param username Username
     * @param password Password
     * @return Basic OAuth
     */
    public Observable<User> login(String username, String password) {
        LoginData loginData = new LoginData();
        loginData.username = username;
        loginData.password = password;
        return baseApiManager.getAuthApi().authenticate(loginData);
    }
}
