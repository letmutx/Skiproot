package com.example.rohit.hdfcskiproot;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class SkipCheck implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals("com.snapwork.hdfc")) {
            return;
        }

        XposedBridge.log("Skip root hook app loaded");

        findAndHookMethod("com.bugclipper.android.utils.c", lpparam.classLoader, "b", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("called b() returning false");
                return false;
            }
        });

        findAndHookMethod("com.bugclipper.android.utils.c", lpparam.classLoader, "j", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("called j() returning false");
                return false;
            }
        });

        findAndHookMethod("com.backbase.a.b", lpparam.classLoader, "a", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("called a() returning false");
                return false;
            }
        });

        findAndHookMethod("com.backbase.a.b", lpparam.classLoader, "a", String.class, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("params: a(String) - " + Arrays.toString(param.args));
                return false;
            }
        });

        findAndHookMethod("com.backbase.a.b", lpparam.classLoader, "d", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("called d() returning false");
                return false;
            }
        });

        findAndHookMethod("com.backbase.a.b", lpparam.classLoader, "a", List.class, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("params: a(List) - " + Arrays.toString(param.args));
                return false;
            }
        });

        findAndHookMethod("com.hdfc.retail.netbanking.HDFCBank", lpparam.classLoader, "e", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("called e() returning false");
                return false;
            }
        });

        findAndHookMethod("com.hdfc.retail.netbanking.utils.h", lpparam.classLoader, "c", Context.class, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                XposedBridge.log("called c(Context) returning false");
                return false;
            }
        });
    }
}
