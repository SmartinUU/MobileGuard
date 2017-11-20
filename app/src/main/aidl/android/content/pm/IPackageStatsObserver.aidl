// IPackageStatsObserver.aidl
package android.content.pm;

// Declare any non-default types here with import statements
import android.content.pm.PackageStats;
/*interface IPackageStatsObserver {
    *//**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     *//*
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}*/
oneway interface IPackageStatsObserver{
    void onGetStatsCompleted(in PackageStats pStats,boolean successed);
}