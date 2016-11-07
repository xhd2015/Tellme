
 /**
  * 手机问答系统的基本构成 
 * 
 */
package fulton.shaw.android.tellme;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity implements OnClickListener
{
	
	FrameLayout mContainer;
	SearchFragment mSearchPage;
	Button mSearchBtn,mPostQuestion,mDetails,mPersonal;
	
	Fragment mCurrentPage;
	Map<Integer, Fragment> mPages=new HashMap<Integer, Fragment>();;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initFileds();
		
		FragmentManager m=getFragmentManager();
		FragmentTransaction t = m.beginTransaction();
		
		/*
		 * 初始化为search 页面
		 */
		t.add(R.id.frameLayout1,mSearchPage);
		mCurrentPage=mSearchPage;
		
		t.commit();
		
		//设置button监听事件
		mSearchBtn.setOnClickListener(this);
		mPostQuestion.setOnClickListener(this);
		mDetails.setOnClickListener(this);
		mPersonal.setOnClickListener(this);
	}
	void initFileds()
	{
		mContainer=(FrameLayout)findViewById(R.id.frameLayout1);
		mSearchPage=new SearchFragment();
		mPages.put(R.id.button1, mSearchPage);
		
		mSearchBtn=(Button)findViewById(R.id.button1);
		mPostQuestion=(Button)findViewById(R.id.button2);
		mDetails=(Button)findViewById(R.id.button3);
		mPersonal=(Button)findViewById(R.id.button4);
		
		
	}
	/**
	 * 
	 *处理onclick事件, 切换页面
	 */
	void onChangeButton(Button which)
	{
		Fragment f=mPages.get(which.getId());
		if(f!=mCurrentPage)
		{
			changePage(f);
		}
	}
	void changePage(Fragment f)
	{
		FragmentManager m=getFragmentManager();
		FragmentTransaction t=m.beginTransaction();
		t.add(R.id.frameLayout1, f);
		t.commit();
		mCurrentPage=f;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v instanceof Button)
		{
			onChangeButton((Button)v);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
