package com.example.courseevents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CourseEventsReceiver extends BroadcastReceiver {

    public static final String ACTION_COURSE_EVENT = "com.example.faitha.notekeeper.action.COURSE_EVENT";
    private static final String EXTRA_COURSE_ID = "com.example.faitha.notekeeper.extra.COURSE_ID";
    private static final String EXTRA_COURSE_MESSAGE = "com.example.faitha.notekeeper.extra.COURSE_MESSAGE";

    private CourseEventsDisplayCallback mCourseEventsDisplayCallback;

    public void setCourseEventsDisplayCallback(CourseEventsDisplayCallback mCourseEventsDisplayCallback) {
        this.mCourseEventsDisplayCallback = mCourseEventsDisplayCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(ACTION_COURSE_EVENT.equals(intent.getAction())) {
            String courseId = intent.getStringExtra(EXTRA_COURSE_ID);
            String courseMessage = intent.getStringExtra(EXTRA_COURSE_MESSAGE);

            if(mCourseEventsDisplayCallback != null) {
                mCourseEventsDisplayCallback.onEventReceived(courseId, courseMessage);
            }
        }
    }
}
