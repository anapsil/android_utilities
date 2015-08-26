package net.anapsil.droidfolio.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by ana.silva on 26/08/15.
 */
public class AndroidUtils {
    public static boolean isAppInstaled(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);

            return true;
        } catch (PackageManager.NameNotFoundException e) {

            return false;
        }
    }
}
