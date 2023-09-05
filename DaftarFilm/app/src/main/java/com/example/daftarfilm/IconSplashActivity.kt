package com.example.daftarfilm

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateInterpolator
import android.widget.Toast
import androidx.core.animation.doOnEnd

class IconSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_splash)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                val slideUp = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.TRANSLATION_Y,
                    0f,
                    -splashScreenView.height.toFloat()
                )
                slideUp.interpolator = AccelerateDecelerateInterpolator()
                slideUp.duration = 1000L
                slideUp.doOnEnd { splashScreenView.remove() }
                slideUp.start()
            }
        }

        val mainActivity = Intent(this@IconSplashActivity, MainActivity::class.java)
        startActivity(mainActivity)
    }
}