package tech.nullpointerexception.conf.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.nullpointerexception.conf.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}
