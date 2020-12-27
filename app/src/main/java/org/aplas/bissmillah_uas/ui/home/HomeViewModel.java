package org.aplas.bissmillah_uas.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.aplas.bissmillah_uas.models.User;
import org.aplas.bissmillah_uas.utils.Session;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<User> user = new MutableLiveData<>(Session.user);
}