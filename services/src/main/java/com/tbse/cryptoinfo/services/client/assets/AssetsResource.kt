package com.tbse.cryptoinfo.services.client.assets

import com.tbse.cryptoinfo.services.models.GetAssetResponse
import retrofit2.Response

/**
 * Created by toddsmith on 9/4/21.
 * Copyright TBSE 2017
 */
interface AssetsResource {
    fun getAssets(): Response<GetAssetResponse>?
}
