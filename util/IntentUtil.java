package net.anapsil.droidfolio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by ana.silva on 20/08/15.
 */
public class IntentUtil {
    private static IntentUtil instance;
    private Context mContext;

    private IntentUtil(Context context) {
        this.mContext = context;
    }

    public static IntentUtil with(Context context) {
        if (instance == null) {
            synchronized (IntentUtil.class) {
                if (instance == null) {
                    instance = new IntentUtil(context);
                }
            }
        } else {
            instance.mContext = context;
        }

        return instance;
    }

    public void openActivity(Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        mContext.startActivity(intent);
    }

    public void openActivity(Bundle extras, Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtras(extras);
        mContext.startActivity(intent);
    }

    public void openActivity(String extraName, int extraValue, Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtra(extraName, extraValue);
        mContext.startActivity(intent);
    }

    public void openActivity(String extraName, String extraValue, Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtra(extraName, extraValue);
        mContext.startActivity(intent);
    }

    public void openActivity(String extraName, Serializable extraValue, Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtra(extraName, extraValue);
        mContext.startActivity(intent);
    }

    public void openActivityWithTransition(Activity activity, Class clazz, ImageView source, String transitionName) {
        Intent intent = new Intent(mContext, clazz);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, source, transitionName);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    public void openActivityWithTransition(Activity activity, Class clazz, Bundle bundle, ImageView source, String transitionName) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtras(bundle);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, source, transitionName);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    //FIXME
    public void openActivity(String[] extraName, int[] extraValue, Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtra(extraName[0], extraValue[0]);
        intent.putExtra(extraName[1], extraValue[1]);
        mContext.startActivity(intent);
    }

    public void openInstalledApp(String packageName) {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        mContext.startActivity(intent);
    }

    public void redirect(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        mContext.startActivity(intent);
    }
}
