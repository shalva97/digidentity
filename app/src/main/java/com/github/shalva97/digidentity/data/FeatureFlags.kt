package com.github.shalva97.digidentity.data

import javax.inject.Inject

class FeatureFlags @Inject constructor() {
    val useProxyServer: Boolean = true
}