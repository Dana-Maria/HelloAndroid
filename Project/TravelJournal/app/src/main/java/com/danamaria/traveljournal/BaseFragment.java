package com.danamaria.traveljournal;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class BaseFragment extends Fragment {

    public void setToolbarTitle(String title) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setToolbarTitle(title);
        }
    }

    public static void addFragment(@NonNull Activity activity,
                                   @IdRes int containerViewId,
                                   @NonNull Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(containerViewId, fragment, fragment.getClass().getCanonicalName());
        transaction.addToBackStack(fragment.getClass().getCanonicalName());
        transaction.setReorderingAllowed(true);
        transaction.commit();
    }
}
