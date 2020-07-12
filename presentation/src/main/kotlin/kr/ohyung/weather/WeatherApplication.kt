package kr.ohyung.weather

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Lee Oh Hyoung on 2020/07/08.
 */
class WeatherApplication : Application() {

    companion object {
        private const val PRINT_STACK_COUNT: Int = 10
    }

    override fun onCreate() {
        super.onCreate()
        setKoin()
        setAndroidLogger()
    }

    private fun setKoin() {
        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(modules = kr.ohyung.weather.inject.modules)
        }
    }

    private fun setAndroidLogger() {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .methodCount(PRINT_STACK_COUNT)
            .build()

        Logger.addLogAdapter(object: AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean =
                // DEBUG 모드에서만 로그 출력
                BuildConfig.DEBUG
        })
    }
}
