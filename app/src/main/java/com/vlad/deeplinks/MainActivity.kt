package com.vlad.deeplinks

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val KEY = "SUB#@!DRAOB~!@TAOG123"
    val IV = "sdkf,jreo98549g,"

    private val TAG = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cryptLib = CryptLib()
        val keyHash = CryptLib.SHA256(KEY, 31)

        val text = "10.11.20 device = Android"

        val encrypdtedText = cryptLib.encrypt(text, keyHash, IV)

        Log.d(TAG, encrypdtedText)

        val decryptedText = cryptLib.decrypt(encrypdtedText, keyHash, IV)

        Log.d(TAG, decryptedText)

    }
}
