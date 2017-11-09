
package com.lumyk;

import android.app.Application;

public class ProjectsApp extends Application {

    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    private static void loadNativeDependencies() {
        // Load libraries
        System.loadLibrary("projects");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        loadNativeDependencies();
    }
}
