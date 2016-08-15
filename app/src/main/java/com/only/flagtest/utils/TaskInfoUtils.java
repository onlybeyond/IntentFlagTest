package com.only.flagtest.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;

import java.util.List;

import static com.only.flagtest.utils.LogUtils.*;

/**
 * Created by only on 16/8/15.
 * Email: onlybeyond99@gmail.com
 */
public class TaskInfoUtils {
    private static String TAG = makeLogTag(TaskInfoUtils.class);

    public static String getTopActivity(Activity context) {
        String ret = "";
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(10);


        if (runningTaskInfos != null) {
                String strTemp = (runningTaskInfos.get(0).topActivity).toString();
                LOGD(TAG, "--- task"+strTemp+"---size"+runningTaskInfos.get(0).numActivities);
                ret += strTemp;
            return ret;
        } else {
            return null;
        }
    }
}
