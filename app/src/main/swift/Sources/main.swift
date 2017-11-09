
import java_swift
import Foundation

import GithubSDK

// responder variable moved to Statics.swift
// so it isn't reset when class is injected.
//// link back to Java side of Application
//var responder: SwiftHelloBinding_ResponderForward!

// kotlin's call to bind the Java and Swift sections of app
@_silgen_name("Java_com_lumyk_core_ProjectsSwift_bind")
public func bind_kotlin( __env: UnsafeMutablePointer<JNIEnv?>, __this: jobject?, __self: jobject? )-> jobject? {

    // This Swift instance forwards to Java through JNI
    responder = ProjectsBinding_ResponderForward( javaObject: __self )

    // This Swift instance receives native calls from Java
    var locals = [jobject]()
    return ProjectsListener().localJavaObject( &locals )
}



class ProjectsListener: ProjectsBinding_Listener {

    var handle: OpaquePointer? = nil
    
    let oauth = GithubSDK.Oauth(clientId: "edb3dc69829c9ff3c548", clientSecret: "ecfc85304bd344d09fd81e693dbfdb5860c932bf", redirectUri: "http://github_projects", scopes: ["user","repo"])
    let sdk = GithubSDK()

    func setCacheDir( cacheDir: String? ) {
        setenv( "TMPDIR", cacheDir!, 1 )

        // Required for SSL to work
        setenv( "URLSessionCertificateAuthorityInfoFile", cacheDir! + "/cacert.pem", 1 )

        // MyText Proxy object must be loaded
        // on main thread before it is used.
        User(user: GHUser(id: "", login: "", name: nil, url: nil, email: "", bio: nil, avatarUrl: nil, location: nil)).withJavaObject { _ in }
    }

    func createOauthURL() {
        if let url = oauth.authorizeURL() {
            NSLog("url \(url)")
            responder.oauthURL(url: url.absoluteString)
        }
    }

    func handleAccessTokenURL(url: String?) {
        if let urlString = url, let url = URL(string: urlString) {
            GithubSDK.handleAccessTokenURL(url: url, oauth: self.oauth, result: { [weak responder] (accessToken, error) in
                responder?.receiveAccessToken(accessToken: accessToken, error: error?.localizedDescription)
            })
        }
    }
    
    func setupAccessToken(accessToken: String?) {
        if let accessToken = accessToken {
            self.sdk.setup(accessToken: accessToken)
        }
    }
    
    func getUser() {
        sdk.usersInfo { [weak responder] (user, error) in
            if let user = user {
                DispatchQueue.main.async {
                    responder?.getUserResult(user: User(user: user))
                }
            }
        }
    }
}
