package com.vlad.deeplinks

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_deep_link.*

class DeepLinkActivity : AppCompatActivity() {

    val TAG = "DeepLinkActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)

        val data: Uri? = intent?.data


        val txtDeepLink = findViewById<TextView>(R.id.txt_from_deep_link)

        if(data != null){

            txtDeepLink.text = data.path
            var text = data.pathSegments
            Log.d(TAG, "deep link intent received ${text[0]}")
            DeepLinksCallbacks.deepChangeRegion(data.path.toString())

        }



    }

}

