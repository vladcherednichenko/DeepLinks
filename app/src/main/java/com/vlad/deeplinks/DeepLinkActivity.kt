package com.vlad.deeplinks

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DeepLinkActivity : AppCompatActivity() {

    val TAG = "DeepLinkActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)

        val data: Uri? = intent?.data


        val txtDeepLink = findViewById<TextView>(R.id.txt_from_deep_link)

        if(data != null){

            txtDeepLink.text = data.path

            var region: String? = null

            try {

                region = data.getQueryParameter("region")

            } catch (e: Exception) {

                e.printStackTrace()

            }

            if(region == null) return

            Log.d(TAG, "deep link intent received $region")
            DeepLinksCallbacks.deepChangeRegion(region)

            data.getQueryParameter("region")

        }



    }

}

