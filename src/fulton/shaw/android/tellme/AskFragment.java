package fulton.shaw.android.tellme;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AskFragment extends Fragment{
	View mRootView;
	Button mAskButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mRootView=inflater.inflate(R.layout.ask_fragment_choose_type, container,false);
		initFileds(mRootView);
		return mRootView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	/*
	 * 
	 * https://answers.yahoo.com/#ask=y&r=1543
	 */
	void initFileds(View v)
	{
		mAskButton=(Button)v.findViewById(R.id.button1);
		
		mAskButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String packageName = "com.android.browser"; 
				String className = "com.android.browser.BrowserActivity"; 
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.addCategory(Intent.CATEGORY_LAUNCHER); 
				intent.setClassName(packageName, className); 
				
				intent.setData(Uri.parse("http://answers.yahoo.com/#ask=y&r=1543"));
				
				
				startActivity(Intent.createChooser(intent, "Open..."));
				
			}
		});
	}

}
