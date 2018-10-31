package com.edgedevstudio.cliplistenertutorial

import android.content.ClipboardManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clipBoardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipBoardManager.addPrimaryClipChangedListener {
            val primaryClipData= clipBoardManager.primaryClip

            if (primaryClipData == null || primaryClipData.itemCount > 0 && primaryClipData.getItemAt(0).text == null)
                return@addPrimaryClipChangedListener  // ... whatever just don't go to next line

            val clip = primaryClipData.getItemAt(0).text.toString()

            Log.d("MainActivity","Copied Text = $clip")
        }
    }
}
