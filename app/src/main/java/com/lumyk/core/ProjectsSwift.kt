package com.lumyk.core

import com.lumyk.ProjectsApp
import com.lumyk.gitpub_projets.R
import com.lumyk.swiftbindings.ProjectsBinding.Listener
import com.lumyk.swiftbindings.ProjectsBinding.Responder
import com.lumyk.swiftbindings.ProjectsTypes
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

/**
 * Created by lumyk on 07.11.2017.
 */
class ProjectsSwift : Responder {

    var listener: Listener

    private var oauth_url_complition: ((URL: String) -> Unit)? = null

    private var handleAccessTokenURLComplition: ((error: String?) -> Unit)? = null

    @SuppressWarnings("JniMissingFunction")
    external fun bind(self: Responder): Listener

    init {
        this.listener = bind(this)
        val context = ProjectsApp.getApplication().applicationContext
        val cacheDir = context.cacheDir.path
        val pemfile = cacheDir + "/cacert.pem"
        val pemStream = context.resources.openRawResource(R.raw.cacert)
        this.copyResource(pemStream, pemfile)
        this.listener.setCacheDir(cacheDir)
    }

    private fun copyResource(`in`: InputStream?, to: String) {
        try {
            val out = FileOutputStream(to)
            `in`?.copyTo(out)
            `in`?.close()
            out.close()
        } catch (e: IOException) {
            e.printStackTrace()
            System.out.println("" + e)
        }
    }

    fun getOauthURL(completion: (String?) -> Unit) {
        this.oauth_url_complition = completion
        this.listener.createOauthURL()

    }

    fun handleAccessTokenURL(url: String?, completion: (String?) -> Unit) {
        if (url != null) {
            this.handleAccessTokenURLComplition = completion
            this.listener.handleAccessTokenURL(url)
        }
    }

    fun getUser() {
        this.listener.getUser()
    }

    //  Responder

    override fun oauthURL(url: String?) {
        val oauth_url_complition = this.oauth_url_complition
        if (url != null && oauth_url_complition != null) {
            oauth_url_complition(url)
        }
    }

    override fun receiveAccessToken(accessToken: String?, error: String?) {
        if (accessToken != null) {
            this.listener.setupAccessToken(accessToken)

            val complition = this.handleAccessTokenURLComplition
            if (complition != null) {
                complition(null)
            }
        } else {
            val complition = this.handleAccessTokenURLComplition
            if (complition != null) {
                if (error != null ) {
                    complition(error)
                } else {
                    complition("unnown error")
                }
            }
        }
    }

    override fun getUserResult(user: ProjectsTypes.UserListener?) {
        println("\nuser ")
        println(user?.name)
        println(user?.id)
        user?.id != null
    }
}