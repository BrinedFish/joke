package com.ldw.joke;

import java.util.List;

import org.kymjs.kjframe.KJBitmap;

import android.content.Context;
import android.test.mock.MockApplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureAdapter extends BaseAdapter
{

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<Contentlist> list = null;
	public  PictureAdapter(Context mContext,List<Contentlist> list)
	{
		this.mContext = mContext;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.list = list;
		
	}
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		ViewHolder mViewHolder = null;
		if (null == convertView)
		{
			mViewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item, null);
			mViewHolder.timeTextView = (TextView) convertView.findViewById(R.id.textView_time);
			mViewHolder.titleTextView = (TextView) convertView.findViewById(R.id.textView_title);
			mViewHolder.mImageView = (ImageView) convertView.findViewById(R.id.imageView_pic);
			convertView.setTag(mViewHolder);
		}
		else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		if (list.size() > 0)
		{
			Contentlist mContentlist = list.get(position);
			String title = mContentlist.getTitle();
			String time = mContentlist.getCt();
			String imgUrl = mContentlist.getImg();
			mViewHolder.timeTextView.setText(time);
			mViewHolder.titleTextView.setText(title);
			KJBitmap mKjBitmap = new KJBitmap();
			mKjBitmap.display(mViewHolder.mImageView, imgUrl);
		}
		return convertView;
	}

	static class ViewHolder
	{
		TextView timeTextView = null;
		TextView titleTextView = null;
		ImageView mImageView = null;
	}
}
