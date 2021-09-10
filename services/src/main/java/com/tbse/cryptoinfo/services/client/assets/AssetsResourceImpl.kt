package com.tbse.cryptoinfo.services.client.assets

class AssetsResourceImpl : AssetsResource {
    private val getAssetsController = GetAssetsController()

    override fun getAssets() = getAssetsController.execute()
}