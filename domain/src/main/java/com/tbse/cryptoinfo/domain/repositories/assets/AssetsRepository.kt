package com.tbse.cryptoinfo.domain.repositories.assets

import com.tbse.cryptoinfo.domain.repositories.assets.mapper.MapAssets
import com.tbse.cryptoinfo.domain.repositories.assets.models.Asset
import com.tbse.cryptoinfo.services.client.ApiClient
import com.tbse.cryptoinfo.services.client.ApiClientImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by toddsmith on 9/4/21.
 * Copyright TBSE 2017
 */
interface AssetsRepository {
    suspend fun getAssets(): List<Asset>
}

class AssetsRepositoryImpl : AssetsRepository {
    override suspend fun getAssets(): List<Asset> {
        return withContext(Dispatchers.IO) {
            val apiClient: ApiClient = ApiClientImpl()
            val response = apiClient.assetResource().getAssets()
            response?.let {
                when (it.isSuccessful) {
                    true -> {
                        (it.body()?.data?.filterNotNull() ?: listOf())
                            .map { serviceAsset ->
                                MapAssets().map(serviceAsset)
                            }
                    }
                    false -> listOf()
                }
            } ?: listOf()
        }
    }
}