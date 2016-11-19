package fulton.shaw.android.tellme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import fulton.shaw.android.tellme.adapter.ResAdapter;
import fulton.shaw.android.tellme.provider.SearchContentProvide;
import fulton.util.android.searcher.ContentManager;

public class SearchFragment extends Fragment implements View.OnClickListener,Serializable{
	public static final String TAG="fulton.shaw.android.tellme.SearchFragment";
	
	Button mSearchBtn;
	ListView mListRes;
	TextView mPrompt;
	EditText mWord;
	Spinner mType;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		return super.onCreateView(inflater, container, savedInstanceState);
		View v=inflater.inflate(R.layout.search_fragment, container,false);
		initFileds(v,inflater);
		mSearchBtn.setOnClickListener(this);
		restoreInstanceState(savedInstanceState);
		return v;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("word", mWord.getText().toString());
	}
	public void restoreInstanceState(Bundle inState)
	{
		final Bundle fstate=inState;
		if(fstate!=null)
		{
			getActivity().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					mWord.setText(fstate.getString("word"));
				}
			});
		}
	}
	void initFileds(View v,LayoutInflater inflater)
	{
		mSearchBtn=(Button) v.findViewById(R.id.button1);
		mListRes=(ListView) v.findViewById(R.id.listView1);
		mPrompt=(TextView) v.findViewById(R.id.textView1);
		mWord=(EditText) v.findViewById(R.id.editText1);
		mType=(Spinner)v.findViewById(R.id.spinner1);
		
		
		
		mListRes.setAdapter(new ResAdapter(getActivity()));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==mSearchBtn)
		{
			doSearch();
		}
	}
	void doSearch()
	{
		Log.v(TAG, "do search");
		setPrompt("Searching");
		final HashMap<String, String> table=new HashMap<String, String>();
		table.put("Yahoo", "yahoo");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String type=table.get(mType.getSelectedItem().toString());
				String word=mWord.getText().toString();
				String prompt="";
				ArrayList<HashMap<String, String>> res = ContentManager.searchFor(word, type);
				setSearchRes(res);

				prompt="Search Finished";
				if(res.size()<10)
				{
					prompt=prompt+" ,"+res.size()+" Results.";
				}
				setPrompt(prompt);
			}
		}).start();
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
	//For list view
	void setSearchRes(ArrayList<HashMap<String, String>> res)
	{
		final ResAdapter adapter=(ResAdapter) mListRes.getAdapter();
		adapter.setRes(res);
		getActivity().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				adapter.notifyDataSetInvalidated();
			}
		});
//		
	}
	


	
}
