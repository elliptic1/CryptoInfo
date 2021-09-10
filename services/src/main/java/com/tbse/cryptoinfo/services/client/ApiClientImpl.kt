package com.tbse.cryptoinfo.services.client

import com.tbse.cryptoinfo.services.client.assets.AssetsResource
import com.tbse.cryptoinfo.services.client.assets.AssetsResourceImpl
import com.tbse.cryptoinfo.services.client.candles.CandlesResource
import com.tbse.cryptoinfo.services.client.exchanges.ExchangesResource
import com.tbse.cryptoinfo.services.client.markets.MarketsResource
import com.tbse.cryptoinfo.services.client.rates.RatesResource

class ApiClientImpl : ApiClient {

    private val assetsResource = AssetsResourceImpl()

    override fun assetResource() = assetsResource

    override fun ratesResource(): RatesResource {
        TODO("Not yet implemented")
    }

    override fun exchangesResource(): ExchangesResource {
        TODO("Not yet implemented")
    }

    override fun marketsResource(): MarketsResource {
        TODO("Not yet implemented")
    }

    override fun candlesResource(): CandlesResource {
        TODO("Not yet implemented")
    }
}