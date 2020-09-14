package com.example.StreamApp.data.datasource.remote;

import com.example.StreamApp.ApiService;
import com.example.StreamApp.data.datasource.DataSourceListener;
import com.example.StreamApp.data.model.LoginStepTwoRequest;
import com.example.StreamApp.data.model.LoginStepTwoResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;

public class LoginStepTwoRemoteDataSource {
    private static final String TAG = "UserVerificationSource";
    private ApiService apiService;

    public LoginStepTwoRemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loginStepTwo(LoginStepTwoRequest loginStepTwo, final DataSourceListener<LoginStepTwoResponse> dataSourceListener) {
        LoginStepTwoRequest loginStepTwoRequest = new LoginStepTwoRequest(loginStepTwo.getMobile()
                , loginStepTwo.getDevice_id(), loginStepTwo.getVerification_code());

        apiService.loginStepTwo(loginStepTwoRequest).enqueue(new Callback<LoginStepTwoResponse>() {
            @Override
            public void onResponse(@NotNull Call<LoginStepTwoResponse> call, @NotNull Response<LoginStepTwoResponse> response) {
                dataSourceListener.onResponse(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<LoginStepTwoResponse> call, @NotNull Throwable t) {
                dataSourceListener.onFailure(t);
            }
        });
    }
}