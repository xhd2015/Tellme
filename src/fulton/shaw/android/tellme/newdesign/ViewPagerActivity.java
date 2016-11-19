package fulton.shaw.android.tellme.newdesign;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import fulton.shaw.android.tellme.R;
import fulton.shaw.android.tellme.adapter.CertainFragmentPagerAdapter;

public class ViewPagerActivity extends FragmentActivity{
	FragmentPagerAdapter mAdapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpagers);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        mAdapterViewPager = new CertainFragmentPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(mAdapterViewPager);
        
        
        
        vpPager.addOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }
}

/**Reference
 * https://github.com/codepath/android_guides/wiki/ViewPager-with-FragmentPagerAdapter
 */