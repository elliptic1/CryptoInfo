package com.tbse.cryptoinfo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.tbse.cryptoinfo.databinding.FragmentDashboardBinding
import com.tbse.cryptoinfo.domain.repositories.assets.models.Asset
import com.tbse.cryptoinfo.ui.dashboard.DashboardViewModel.UIState.AssetsRetrieved

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.refresh.setOnClickListener {
            dashboardViewModel.getAssets()
        }
        

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onResume() {
        super.onResume()
        dashboardViewModel.getStateChanges().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is AssetsRetrieved -> {
                    binding.listOfAssets.setContent {
                        AssetList(state.assets)
                    }
                }
            }
        })
        dashboardViewModel.getAssets()
    }

    @Composable
    fun AssetList(assets: List<Asset>) {
        AppCompatTheme {
            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                items(
                    assets.size,
                    { it },
                    { AssetRow(assets[it]) }
                )
            }
        }
    }

    @Composable
    fun AssetRow(asset: Asset) {
        AppCompatTheme {
            Text(asset.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}