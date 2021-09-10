package com.tbse.cryptoinfo.services.client.assets

import com.tbse.cryptoinfo.services.client.ApiConstants
import com.tbse.cryptoinfo.services.models.Asset
import com.tbse.cryptoinfo.services.models.GetAssetResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Created by toddsmith on 9/4/21.
 * Copyright TBSE 2017
 */
class GetAssetsController {

    interface AssetsApi {
        @GET(ApiConstants.serviceUrl + "assets")
        fun assets(): Call<GetAssetResponse>?
    }

    fun execute(): Response<GetAssetResponse>? {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.serviceUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val assetsApi = retrofit.create(AssetsApi::class.java)

        val assetsListCall: Call<GetAssetResponse>? = assetsApi.assets()

        return assetsListCall?.execute()

    }

}