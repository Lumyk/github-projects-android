
import java_swift
import java_lang

/// generated by: genswift.java 'java/lang|java/util|java/sql' 'Sources' '../java' ///

/// interface com.lumyk.swiftbindings.ProjectsBinding$Responder ///

public protocol ProjectsBinding_Responder: JavaProtocol {

    /// public abstract void com.lumyk.swiftbindings.ProjectsBinding$Responder.getUserResult(com.lumyk.swiftbindings.ProjectsTypes$UserListener)

    func getUserResult( user: ProjectsTypes_UserListener? )

    /// public abstract void com.lumyk.swiftbindings.ProjectsBinding$Responder.receiveAccessToken(java.lang.String,java.lang.String)

    func receiveAccessToken( accessToken: String?, error: String? )

    /// public abstract void com.lumyk.swiftbindings.ProjectsBinding$Responder.validateAccessTokenResult(java.lang.Boolean)

    func validateAccessTokenResult( isValid: java_lang.Boolean? )

}


open class ProjectsBinding_ResponderForward: JNIObjectForward, ProjectsBinding_Responder {

    private static var ProjectsBinding_ResponderJNIClass: jclass?

    /// public abstract void com.lumyk.swiftbindings.ProjectsBinding$Responder.getUserResult(com.lumyk.swiftbindings.ProjectsTypes$UserListener)

    private static var getUserResult_MethodID_4: jmethodID?

    open func getUserResult( user: ProjectsTypes_UserListener? ) {
        var __locals = [jobject]()
        var __args = [jvalue]( repeating: jvalue(), count: 1 )
        __args[0] = JNIType.toJava( value: user, locals: &__locals )
        JNIMethod.CallVoidMethod( object: javaObject, methodName: "getUserResult", methodSig: "(Lcom/lumyk/swiftbindings/ProjectsTypes$UserListener;)V", methodCache: &ProjectsBinding_ResponderForward.getUserResult_MethodID_4, args: &__args, locals: &__locals )
    }

    open func getUserResult( _ _user: ProjectsTypes_UserListener? ) {
        getUserResult( user: _user )
    }

    /// public abstract void com.lumyk.swiftbindings.ProjectsBinding$Responder.receiveAccessToken(java.lang.String,java.lang.String)

    private static var receiveAccessToken_MethodID_5: jmethodID?

    open func receiveAccessToken( accessToken: String?, error: String? ) {
        var __locals = [jobject]()
        var __args = [jvalue]( repeating: jvalue(), count: 2 )
        __args[0] = JNIType.toJava( value: accessToken, locals: &__locals )
        __args[1] = JNIType.toJava( value: error, locals: &__locals )
        JNIMethod.CallVoidMethod( object: javaObject, methodName: "receiveAccessToken", methodSig: "(Ljava/lang/String;Ljava/lang/String;)V", methodCache: &ProjectsBinding_ResponderForward.receiveAccessToken_MethodID_5, args: &__args, locals: &__locals )
    }

    open func receiveAccessToken( _ _accessToken: String?, _ _error: String? ) {
        receiveAccessToken( accessToken: _accessToken, error: _error )
    }

    /// public abstract void com.lumyk.swiftbindings.ProjectsBinding$Responder.validateAccessTokenResult(java.lang.Boolean)

    private static var validateAccessTokenResult_MethodID_6: jmethodID?

    open func validateAccessTokenResult( isValid: java_lang.Boolean? ) {
        var __locals = [jobject]()
        var __args = [jvalue]( repeating: jvalue(), count: 1 )
        __args[0] = JNIType.toJava( value: isValid, locals: &__locals )
        JNIMethod.CallVoidMethod( object: javaObject, methodName: "validateAccessTokenResult", methodSig: "(Ljava/lang/Boolean;)V", methodCache: &ProjectsBinding_ResponderForward.validateAccessTokenResult_MethodID_6, args: &__args, locals: &__locals )
    }

    open func validateAccessTokenResult( _ _isValid: java_lang.Boolean? ) {
        validateAccessTokenResult( isValid: _isValid )
    }

}

