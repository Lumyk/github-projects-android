package com.lumyk.gitpub_projets;

import android.content.Context;
import java.io.*;
import android.os.Handler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.lumyk.swiftbindings.ProjectsBinding.Listener;
import com.lumyk.swiftbindings.ProjectsBinding.Responder;

public class MainActivity extends AppCompatActivity {

    static Listener listener;

    @SuppressWarnings("JniMissingFunction")
    native Listener bind( Responder self );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void copyResource( InputStream in, String to ) {
        try {
            OutputStream out = new FileOutputStream( to );
            byte[] buffer = new byte[16*1024];
            int len;
            while ((len = in.read(buffer)) != -1)
                out.write(buffer, 0, len);
            out.close();
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(""+e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
