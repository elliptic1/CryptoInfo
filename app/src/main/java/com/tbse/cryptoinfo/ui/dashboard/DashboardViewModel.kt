package com.tbse.cryptoinfo.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbse.cryptoinfo.domain.repositories.assets.AssetsRepository
import com.tbse.cryptoinfo.domain.repositories.assets.AssetsRepositoryImpl
import com.tbse.cryptoinfo.domain.repositories.assets.models.Asset
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardViewModel : ViewModel() {

    private val assetsRepository: AssetsRepository = AssetsRepositoryImpl()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _stateLiveData = MutableLiveData<UIState>()
    fun getStateChanges(): LiveData<UIState> = _stateLiveData

    sealed class UIState {
        object Loading: UIState()
        data class AssetsRetrieved(
            val assets: List<Asset>
        ): UIState()
    }

    fun getAssets() {
        viewModelScope.launch {
            val assets = assetsRepository.getAssets()
            _stateLiveData.value = UIState.AssetsRetrieved(assets)
        }
    }

}