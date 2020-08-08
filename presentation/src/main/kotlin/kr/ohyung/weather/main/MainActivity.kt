package kr.ohyung.weather.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import com.google.android.gms.location.FusedLocationProviderClient
import kr.ohyung.weather.R
import kr.ohyung.weather.base.BaseActivity
import kr.ohyung.weather.databinding.ActivityMainBinding
import kr.ohyung.weather.utility.isPermissionGranted
import kr.ohyung.weather.utility.isShouldShowPermissionRationale
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    companion object {

        private const val REQUEST_CODE_GPS_ENABLE: Int = 2001
        private const val REQUEST_CODE_PERMISSIONS: Int = 100
        private val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        fun start(context: Context) =
            context.startActivity(
                context.intentFor<MainActivity>()
                    .singleTop()
            )
    }

    override val viewModel: MainViewModel by viewModel()
    private val fusedLocationClient by lazy { FusedLocationProviderClient(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        setLiveDataObserver()
        checkLocationPermission()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS && grantResults.size == REQUIRED_PERMISSIONS.size) {
            checkLocationPermission()
        } else {
            if (isShouldShowPermissionRationale(REQUIRED_PERMISSIONS[0]) || isShouldShowPermissionRationale(REQUIRED_PERMISSIONS[1]))
                toast(R.string.permission_location_should_show_rationale)

            else
                toast(R.string.permission_location_request_settings)
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    @SuppressLint("MissingPermission")
    private fun checkLocationPermission() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION) &&
            !isPermissionGranted(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            ActivityCompat
                .requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)

        } else {
            // already permission granted
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if(location != null) {
                    viewModel.getForecast(location.latitude, location.longitude)
                }
            }
        }
    }

    private fun setLiveDataObserver() {
        viewModel.uiState.observe(this, Observer(::updateUi))
    }

    private fun updateUi(state: MainUiState) {
        when(state) {
            MainUiState.Loading -> { /* explicitly empty */ }
            is MainUiState.Content -> {
                binding.textView.text = state.toString()
            }
            is MainUiState.Error -> toast(state.errorMessage)
        }
    }
}
