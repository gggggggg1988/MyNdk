#include <jni.h>
#include <string>
#include "bspatch.c"

//extern "C"
//JNIEXPORT jint JNICALL
//Java_com_minto_myndk_zhy_utils_BsPatch_bspatch(JNIEnv *env, jclass type, jstring oldApk_,
//                                               jstring newApk_, jstring patch_) {
//    int argc = 4;
//    char * argv[argc];
//    argv[0] = "bspatch";
//    argv[1] = (char*) ((env)->GetStringUTFChars(oldApk_, 0));
//    argv[2] = (char*) ((env)->GetStringUTFChars(newApk_, 0));
//    argv[3] = (char*) ((env)->GetStringUTFChars(patch_, 0));
//
//
//    int ret = patchMethod(argc, argv);
//
//    (env)->ReleaseStringUTFChars( oldApk_, argv[1]);
//    (env)->ReleaseStringUTFChars( newApk_, argv[2]);
//    (env)->ReleaseStringUTFChars( patch_, argv[3]);
//    return ret;
//}



//extern "C"
//JNIEXPORT jstring JNICALL
//Java_com_minto_myndk_MainActivity_stringFromJNI(
//        JNIEnv *env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}
