package com.minto.myndk.zhy.utils;

/**
 * Created by zhy on 16/10/7.
 */
public class BsPatch {

    static {
//        System.loadLibrary("native-lib");
        System.loadLibrary("bspatch");
    }

    //public static native int bspatch(String oldApk, String newApk, String patch);
    public static native int patch(String oldApk, String newApk, String patch);

}
