package net.anapsil.droidfolio.utils;

import android.content.Context;

/**
 * Created by ana.silva on 17/06/15.
 */
public class UiUtil {
    private static UiUtil instance;
    private Context mContext;

    private UiUtil(Context context) {
        this.mContext = context;
    }

    public static UiUtil with(Context context) {
        if (instance == null) {
            synchronized (UiUtil.class) {
                if (instance == null) {
                    instance = new UiUtil(context);
                }
            }
        } else {
            instance.mContext = context;
        }

        return instance;
    }



    public float getDensity() {
        return mContext.getResources().getDisplayMetrics().density;
    }

    public ScreenDensity getScreenDensity() {
        float density = getDensity();

        if (density == 0.75f) {
            return ScreenDensity.LDPI;
        } else if (density == 1) {
            return ScreenDensity.MDPI;
        } else if (density == 1.5f) {
            return ScreenDensity.HDPI;
        } else if (density == 2) {
            return ScreenDensity.XHDPI;
        } else if (density == 3) {
            return ScreenDensity.XXHDPI;
        } else if (density == 4) {
            return ScreenDensity.XXXHDPI;
        } else {
            return ScreenDensity.XHDPI;
        }
    }

    private enum ScreenDensity {LDPI, MDPI, HDPI, XHDPI, XXHDPI, XXXHDPI}
}
