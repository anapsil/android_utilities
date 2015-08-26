package net.anapsil.droidfolio.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import net.anapsil.droidfolio.R;

/**
 * Created by anapsil on 22/08/15.
 */
public class FragmentUtils {
    public static void replaceFragment(FragmentManager fm, Fragment fragment) {
        fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    public static void addFragment(FragmentManager fm, Fragment fragment, String tag) {
        fm.beginTransaction().add(R.id.content_frame, fragment).addToBackStack(tag).commit();
    }
}
