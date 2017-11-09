
// Shared types/interfaces between Java and Swift in example applications

package com.lumyk.swiftbindings;

import java.util.Map;
import java.util.HashMap;

public interface ProjectsTypes {

    // An example of publishing an object to Java.
    // Add the associated protocol to an class and
    // objects can be passed to a responder message.

    public interface TextListener {
        public String getText2();
        public String getText3();
        public String getText4();
        public String getText5();
    }

    public interface UserListener {
        public String getId();
        public String getLogin();
        public String getName();
        public String getUrl();
        public String getEmail();
        public String getBio();
        public String getAvatarUrl();
        public String getLocation();
    }

//    // These are required because of type erasure in Java jars
//    public static class GHUserMap extends HashMap<String,GHUser> {
//        public static Class<?> valueClass() {
//            return GHUser.class;
//        }
//    }
//
//    public static class GHUserList extends HashMap<String,GHUser[]> {
//        public static Class<?> valueClass() {
//            return (new GHUser [] {}).getClass();
//        }
//    }
}


