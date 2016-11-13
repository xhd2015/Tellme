package fulton.shaw.android.tellme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
	}
	
	/*!not ui safe!*/
	public void openURL(String title,String url)
	{
		// TODO Auto-generated method stub

		mTitle.setText(title);
		mWeber.loadUrl(url);
		
		
	}
	
}
