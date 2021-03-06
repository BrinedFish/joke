package com.ldw.joke;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;  
import com.ldw.joke.parsexml.ParseXstream;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

//api 地址http://apistore.baidu.com/apiworks/servicedetail/864.html
public class MainActivity extends Activity implements OnClickListener
{

	//ldw
	// 笑话大全
	String httpUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_pic";
	String httpArg = "page=1";
	private TextView showTextView = null;
	// 自己申请到apikey ce876cabe660d4db2bb0c6019f9211b3
	// 笑话大全的apikey ce876cabe660d4db2bb0c6019f9211b3
	public static final String TAG = "ldw ********joke";

	private String jsonResult = null;
	
	private Button toJsonButton = null;
	private Button fromJsonButton = null;
	private Button toXMLButton = null;
	private Button fromXMLButton = null;
	private GridView mGridView = null;
	private PictureAdapter mPictureAdapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		start();
		
		

	}

	private void init()
	{
		showTextView = (TextView) findViewById(R.id.textView1);
		fromJsonButton = (Button) findViewById(R.id.button1);
		toJsonButton = (Button) findViewById(R.id.button2);
		fromJsonButton.setOnClickListener(this);
		toJsonButton.setOnClickListener(this);
		fromXMLButton = (Button) findViewById(R.id.button_fromxml);
		fromXMLButton.setOnClickListener(this);
		toXMLButton = (Button) findViewById(R.id.button_toxml);
		toXMLButton.setOnClickListener(this);
		mGridView = (GridView) findViewById(R.id.gridView_pic);
	}
	private void start()
	{
		new Thread()
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				super.run();
				jsonResult = request(httpUrl, httpArg);
				if (null != jsonResult)
				{
					Log.v(TAG, jsonResult);
					//showTextView.setText(jsonResult);
					mHandler.sendEmptyMessage(7);
				}
				else
				{
					Log.v(TAG, "jsonResult***空");
				}
			}
			
		}.start();
	}

	Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg)
		{
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 7)
			{
				if (null != jsonResult)
				{
					showTextView.setText(jsonResult);
				}
				
			}
		}
		
	};
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String request(String httpUrl, String httpArg)
	{
		BufferedReader reader = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;
		String result = null;
		try
		{
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			// connection.setRequestProperty("apikey", "您自己的apikey");
			connection.setRequestProperty("apikey",
					"ce876cabe660d4db2bb0c6019f9211b3");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null)
			{
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id)
		{
		case R.id.button1:
			@SuppressWarnings("rawtypes")

			Gson mGson = new Gson();
			//List<JokePicture> mList = new ArrayList<JokePicture>();
			
			Log.i(TAG, jsonResult);
			if (!TextUtils.isEmpty(jsonResult))
			{
				//JokePicture mJokePicture = mGson.fromJson(jsonResult, JokePicture.class);
				
				//Log.i(TAG, mJokePicture.toString());
				//List<JokePicture> mList = mGson.fromJson(jsonResult, new TypeToken<List<JokePicture>>(){}.getType());
				//Log.i(TAG, "mList 长度" + mList.size());
				
				//List<JsonBean> mList = mGson.fromJson(jsonResult, new TypeToken<List<JsonBean>>(){}.getType());
				//Log.i(TAG, "mList 长度" + mList.size());
				//JsonBean mJsonBean = mGson.fromJson(jsonResult, JsonBean.class);
				//Log.i(TAG, "showapi_res_code = " + mJsonBean.showapi_res_code);
				//Log.i(TAG, "JsonBean.Body.allNum = " + JsonBean.Body.allNum );
				JokePicture mJokePicture = mGson.fromJson(jsonResult, JokePicture.class);
				Log.i(TAG, "showapi_res_code = " + mJokePicture.getShowapi_res_code());
				Log.i(TAG, "mJokePicture.getShowapi_res_body().getAllNum() = " + mJokePicture.getShowapi_res_body().getAllNum());
				List<Contentlist> list = mJokePicture.getShowapi_res_body().getContentlist();
				/*for (int i = 0; i < list.size(); i++)
				{
					Contentlist mContentlist = list.get(i);
					String title = mContentlist.getTitle();
					String time = mContentlist.getCt();
					String imgUrl = mContentlist.getImg();
					//Log.i(TAG, "title = " + title);
				}*/
				if (list.size() > 0)
				{
					mPictureAdapter = new PictureAdapter(this, list);
					//mGridView.setNumColumns(list.size());
					//mGridView.setVerticalSpacing(100);
					mGridView.setAdapter(mPictureAdapter);
				}
				
			}
			
			break;
		case R.id.button2:
			List testList = new ArrayList(); 
			testList.add("first"); 
			testList.add("second"); 
			Gson gson = new Gson();
			String listToJson = gson.toJson(testList); 
			Log.v(TAG, listToJson);
			
			break;
		case R.id.button_fromxml:
			ParseXstream mFromParseXstream = new ParseXstream(this);
			mFromParseXstream.parseXmlToJava();
			break;
		case R.id.button_toxml:
			ParseXstream mParseXstream = new ParseXstream(this);
			mParseXstream.parseJavaToXml();
			break;
		default:
			break;
		}
	}

}
