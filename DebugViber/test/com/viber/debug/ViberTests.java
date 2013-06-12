package com.viber.debug;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

@SuppressWarnings("rawtypes")
public class ViberTests extends ActivityInstrumentationTestCase2 {

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.viber.voip.WelcomeActivity";

	private static Class<?> launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public ViberTests() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCanOpenSettings() {
		solo.pressMenuItem(0);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();

	}
}
