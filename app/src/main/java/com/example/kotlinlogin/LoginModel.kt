package com.example.kotlinlogin


import com.google.gson.annotations.SerializedName
//import android.support.annotation.Keep
import androidx.annotation.Keep

@Keep
data class LoginModel(
    @SerializedName("Customer") var customer: Customer,
    @SerializedName("Login_Result") var loginResult: LoginResult
) {
    @Keep
    data class Customer(
        @SerializedName("AccessToken") var accessToken: String,
        @SerializedName("AccessToken_Created_At") var accessTokenCreatedAt: String,
        @SerializedName("AccessToken_Expires_At") var accessTokenExpiresAt: String,
        @SerializedName("AccessToken_Id") var accessTokenId: Int,
        @SerializedName("AdminComment") var adminComment: String,
        @SerializedName("Customer_Active") var customerActive: Boolean,
        @SerializedName("Customer_Deleted") var customerDeleted: Boolean,
        @SerializedName("CustomerGuid") var customerGuid: String,
        @SerializedName("Customer_Id") var customerId: Int,
        @SerializedName("Customer_Phone") var customerPhone: String,
        @SerializedName("Email") var email: String,
        @SerializedName("fName") var fName: String,
        @SerializedName("FullName") var fullName: String,
        @SerializedName("HasShoppingCartItems") var hasShoppingCartItems: Boolean,
        @SerializedName("lName") var lName: String,
        @SerializedName("LanguageId") var languageId: Any,
        @SerializedName("Username") var username: String
    )

    @Keep
    data class LoginResult(
        @SerializedName("access_token") var accessToken: String,
        @SerializedName("access_token_expires_at") var accessTokenExpiresAt: String,
        @SerializedName("login_result") var loginResult: Boolean,
        @SerializedName("system_message") var systemMessage: String,
        @SerializedName("user_message") var userMessage: String
    )
}