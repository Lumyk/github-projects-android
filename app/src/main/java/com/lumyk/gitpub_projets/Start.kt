package com.lumyk.gitpub_projets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lumyk.core.ProjectsSwift
import android.content.Intent



class Start : AppCompatActivity() {
    val projects = ProjectsSwift()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val token = "fjndjskf"
        projects.validateAccessToken(token) {
            if (it == true) {

            } else {
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }
        }
    }
}
