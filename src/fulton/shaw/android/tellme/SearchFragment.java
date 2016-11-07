package fulton.shaw.android.tellme;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import fulton.shaw.android.tellme.provider.SearchContentProvide;
import fulton.util.java.Util;

public class SearchFragment extends Fragment implements View.OnClickListener{
	public static final String TAG="fulton.shaw.android.tellme.SearchFragment";
	
	Button mSearchBtn;
	ListView mListRes;
	TextView mPrompt;
	EditText mWord;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		return super.onCreateView(inflater, container, savedInstanceState);
		View v=inflater.inflate(R.layout.search_fragment, container,false);
		initFileds(v);
		mSearchBtn.setOnClickListener(this);
		return v;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	void initFileds(View v)
	{
		mSearchBtn=(Button) v.findViewById(R.id.button1);
		mListRes=(ListView) v.findViewById(R.id.listView1);
		mPrompt=(TextView) v.findViewById(R.id.textView1);
		mWord=(EditText) v.findViewById(R.id.editText1);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==mSearchBtn)
		{
			Log.v(TAG, "Search Clicked");
			setPrompt("Searching");
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String res=SearchContentProvide.getURL("http://www.baidu.com/s?wd="+mWord.getText().toString());
					setPrompt(res);
				}
				
				
			}).start();
			
		}
	}
	void setPrompt(String s)
	{
		final String fs=s;
		getActivity().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mPrompt.setText(fs);
			}
		});
	}

	
}
