package com.vlad.deeplinks

import android.util.Log

object DeepLinksCallbacks {

    private val TAG = "DeepLinksCallbacks"

    interface onRegionChangeRequestCallback{

        fun onNewRegionChangeRequested(region: String)

    }

    private var onRegionRequestCallback : onRegionChangeRequestCallback? = null

    fun setOnRegionChangeRequestCallback(onRegionRequestCallback : onRegionChangeRequestCallback){

        this.onRegionRequestCallback = onRegionRequestCallback

    }

    fun deepChangeRegion(region: String){

        if(onRegionRequestCallback!= null){

            onRegionRequestCallback?.onNewRegionChangeRequested(region)

        }else{

            Log.d(TAG, "deepChangeRegion callback is null")

        }

    }



}