package com.lumyk.gitpub_projets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import com.lumyk.core.ProjectsSwift
import android.webkit.WebViewClient
import com.lumyk.swiftbindings.ProjectsTypes


class Login : AppCompatActivity() {
    val projects = ProjectsSwift()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val webView : WebView = findViewById(R.id.webView) as WebView
        webView.settings.javaScriptEnabled = true
        webView.setWebViewClient(myWebViewClient())

        projects.getOauthURL {
            println(it)
            if (it != null) {
                webView.loadUrl(it)
            } else {
                println("ProjectsSwift.getOauthURL error")
            }
        }
    }

    inner class myWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url = request?.url.toString()
            projects.handleAccessTokenURL(url) {
                if (it != null) {
                    println(it)
                } else {
                    // new activiti
                }
            }
            view?.loadUrl(url)
            return true
        }
    }
}
