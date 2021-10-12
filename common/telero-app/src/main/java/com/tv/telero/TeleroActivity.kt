package com.tv.telero

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.airbnb.android.showkase.annotation.ShowkaseRoot
import com.airbnb.android.showkase.annotation.ShowkaseRootModule
import com.airbnb.android.showkase.models.Showkase

class TeleroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Showkase.getBrowserIntent(this))
    }
}

@ShowkaseRoot
class MyRootModule : ShowkaseRootModule
