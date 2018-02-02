package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Primary activity class for the app.
 * Displays the list of currently extant Tweets and provides
 * interface for adding and removing them.
 *
 * @author dezfuli
 * @version 1.0
 */
public class LonelyTwitterActivity extends Activity {
	/** File to use for saving and restoring tweets. */
	private static final String FILENAME = "file.sav";
	
	/** View for typing in new tweets. */
	private EditText bodyText;
	
	/** View that lists the extant tweets. */
	private ListView oldTweetsList;
	
	/** List of currently extant tweets. */
	private ArrayList<Tweet> tweetList;
	
	/** Adapter for the list of currently extant tweets. */
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				
				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);
				
				adapter.notifyDataSetChanged();
				
				saveInFile();
			}
		});
		
		clearButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				setResult(RESULT_OK);
				
				tweetList.clear();
				adapter.notifyDataSetChanged();
				
				saveInFile();
			}
		});
	}

	/**
	 * Called when the activity is initialized.
	 */
	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();
		
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		
		oldTweetsList.setAdapter(adapter);
	}
	
	/**
	 * Loads tweets from save file into the list and updates the on screen display
	 * of tweets.
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			
			Gson gson = new Gson();
			
			// https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			// (2018-01-25)
			Type type = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, type);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Saves tweets to save file (from array of currently extant tweets).
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			
			Gson gson = new Gson();
			
			gson.toJson(tweetList, out);
			out.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Called when the activity is destroyed
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}