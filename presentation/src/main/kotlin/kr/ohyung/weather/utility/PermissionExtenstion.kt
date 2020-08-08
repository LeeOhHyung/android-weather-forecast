/*
 * Created by Lee Oh Hyoung on 2020/08/08 .. 
 */
package kr.ohyung.weather.utility

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun AppCompatActivity.isPermissionGranted(targetPermission: String): Boolean =
    ContextCompat.checkSelfPermission(this, targetPermission) == PackageManager.PERMISSION_GRANTED

fun AppCompatActivity.isShouldShowPermissionRationale(targetPermission: String): Boolean =
    ActivityCompat.shouldShowRequestPermissionRationale(this, targetPermission)
