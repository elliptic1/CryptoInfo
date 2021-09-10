package com.tbse.cryptoinfo.services.models

/**
 * Created by toddsmith on 9/4/21.
 * Copyright TBSE 2017
 */
data class Asset(
    val id: String,
    val rank: String,
    val symbol: String,
    val name: String,
    val supply: String,
    val maxSupply: String,
    val marketCapUsd: String,
    val volumeUsd24Hr: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val vwap24Hr: String
)
