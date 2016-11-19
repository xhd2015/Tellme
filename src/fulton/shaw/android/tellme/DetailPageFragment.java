package fulton.shaw.android.tellme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class DetailPageFragment extends Fragment {

	WebView mWeber;
	TextView mTitle;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.webdetail_fragment, container,false);
		initFields(view);
		return view;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}

	void initFields(View v)
	{
		mWeber=(WebView) v.findViewById(R.id.webView_detailed_1);
		mTitle=(TextView)v.findViewById(R.id.textView_detailed_1);
		
		WebSettings settings=mWeber.getSettings();
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setAppCacheEnabled(true);
		settings.setSaveFormData(true);
	}
	
	/*!not ui safe!*/
	public void openURL(String title,String url)
	{
		// TODO Auto-generated method stub

		mTitle.setText(title);
		mWeber.loadUrl(url);
		
		
	}
	
}
