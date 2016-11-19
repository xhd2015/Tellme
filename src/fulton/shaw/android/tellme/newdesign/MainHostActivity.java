package fulton.shaw.android.tellme.newdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;

public class MainHostActivity extends Activity {
	FragmentTabHost mTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
	}
	
}


/** Reference
 * public class TabsActivity extends FragmentActivity {
private FragmentTabHost mTabHost;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tabs);
    mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
    mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

    TabHost.TabSpec exploreSpec = mTabHost.newTabSpec("explore").setIndicator("Explore", getResources().getDrawable(R.drawable.exploreicon));
    mTabHost.addTab(exploreSpec);
}

}
 */

/** Reference 2
 * <android.support.v4.app.FragmentTabHost
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@android:id/tabhost"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical" >

        <TabWidget
            android:id="@android:id/tabs"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"/>

        <FrameLayout
            android:id="@android:id/tabcontent"
            android:layout_width="fill_parent"
            android:layout_height="0dp"
            android:layout_weight="1" />
    </LinearLayout>

</android.support.v4.app.FragmentTabHost>
 * 
 * 
 */






