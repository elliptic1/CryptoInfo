package com.tbse.cryptoinfo.domain.repositories.assets.mapper

import com.tbse.cryptoinfo.services.models.Asset

/**
 * Created by toddsmith on 9/9/21.
 * Copyright TBSE 2017
 */
class MapAssets {
    fun map(
        serviceAsset: Asset
    ): com.tbse.cryptoinfo.domain.repositories.assets.models.Asset {
        return com.tbse.cryptoinfo.domain.repositories.assets.models.Asset(
            id = serviceAsset.id,
            rank = serviceAsset.rank,
            symbol = serviceAsset.symbol,
            name = serviceAsset.name,
            supply = serviceAsset.supply,
            maxSupply = serviceAsset.maxSupply,
            marketCapUsd = serviceAsset.marketCapUsd,
            volumeUsd24Hr = serviceAsset.volumeUsd24Hr,
            priceUsd = serviceAsset.priceUsd,
            changePercent24Hr = serviceAsset.changePercent24Hr,
            vwap24Hr = serviceAsset.vwap24Hr
        )
    }
}