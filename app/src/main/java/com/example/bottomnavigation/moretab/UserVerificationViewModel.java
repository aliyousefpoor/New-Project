package com.example.bottomnavigation.moretab;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.load.HttpException;
import com.example.bottomnavigation.data.datasource.DataSourceListener;
import com.example.bottomnavigation.data.datasource.VerificationSource;
import com.example.bottomnavigation.data.model.ResponseVerificationBody;

public class UserVerificationViewModel extends ViewModel {
    private static final String TAG = "UserVerificationViewMod";
    private VerificationSource verificationSource;

    public UserVerificationViewModel(VerificationSource verificationSource) {
        this.verificationSource = verificationSource;
    }

    private MutableLiveData<ResponseVerificationBody> _verificationLiveData = new MutableLiveData<>();
    public LiveData<ResponseVerificationBody> verificationLiveData = _verificationLiveData;

    public void postVerificationCode(String number, String androidId ,String code) {
        verificationSource.postCode( number ,androidId,code ,new DataSourceListener<ResponseVerificationBody>() {

            @Override
            public void onResponse(ResponseVerificationBody response) {
                _verificationLiveData.setValue(response);

                Log.d(TAG, "onResponse:Verification ");

            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d(TAG, "onFailure: " + throwable);


            }

        });

    }

}
