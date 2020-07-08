package kr.ohyung.weather.inject

import kr.ohyung.weather.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */

private val appModules = module {
    /* explicitly empty */
}

private val viewModelModules = module {
    viewModel { MainViewModel() }
}

private val apiModule = module {
    /* explicitly empty */
}

val modules = listOf(appModules, viewModelModules, apiModule)
