package com.tbse.cryptoinfo.services.client

import com.tbse.cryptoinfo.services.client.assets.AssetsResource
import com.tbse.cryptoinfo.services.client.candles.CandlesResource
import com.tbse.cryptoinfo.services.client.exchanges.ExchangesResource
import com.tbse.cryptoinfo.services.client.markets.MarketsResource
import com.tbse.cryptoinfo.services.client.rates.RatesResource

/**
 * Created by toddsmith on 9/4/21.
 * Copyright TBSE 2017
 */
interface ApiClient {
    fun assetResource(): AssetsResource
    fun ratesResource(): RatesResource
    fun exchangesResource(): ExchangesResource
    fun marketsResource(): MarketsResource
    fun candlesResource(): CandlesResource
}