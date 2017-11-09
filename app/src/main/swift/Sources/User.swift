//
//  User.swift
//  libprojects.so
//
//  Created by Evgeny Kalashnikov on 08.11.2017.
//
import java_swift
import GithubSDK


struct User: ProjectsTypes_UserListener {
    
    var user : GHUser!
    
    init(user: GHUser) {
        self.user = user
    }
    
    func getAvatarUrl() -> String! {
        return self.user.avatarUrl?.absoluteString
    }
    
    func getBio() -> String! {
        return self.user.bio
    }
    
    func getEmail() -> String! {
        return self.user.email
    }
    
    func getId() -> String! {
        return self.user.id
    }
    
    func getLocation() -> String! {
        return self.user.location
    }
    
    func getLogin() -> String! {
        return self.user.login
    }
    
    func getName() -> String! {
        return self.user.name
    }
    
    func getUrl() -> String! {
        return self.user.url?.absoluteString
    }
}
