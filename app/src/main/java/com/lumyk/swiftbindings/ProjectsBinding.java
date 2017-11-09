
package com.lumyk.swiftbindings;

import com.lumyk.swiftbindings.ProjectsTypes.*;

public interface ProjectsBinding {

    // Messages from JavaActivity to Swift
    public interface Listener {

        public void setCacheDir(String cacheDir);

        public void createOauthURL();

        public void handleAccessTokenURL(String url);

        public void setupAccessToken(String accessToken);

        public void getUser();
    }

    // Messages from Swift back to Activity
    public interface Responder {

        public void oauthURL(String url);

        public void receiveAccessToken(String accessToken, String error);

        public void getUserResult(UserListener user);
    }

}
