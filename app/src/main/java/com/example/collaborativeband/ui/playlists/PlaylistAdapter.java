package com.example.collaborativeband.ui.playlists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collaborativeband.R;

import java.util.List;

public class PlaylistAdapter extends BaseAdapter {

    private Context mContext;

    // For loading item_playlist 's layout
    private LayoutInflater mInflater;
    private List<Playlist> mDatas;

    public PlaylistAdapter(Context context, List<Playlist> datas) {

        // Assigning values.
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlaylistAdapter.ViewHolder viewHolder = null;

        if (convertView == null){

            convertView = mInflater.inflate(R.layout.item_playlist, parent, false);

            viewHolder = new PlaylistAdapter.ViewHolder();

            /**
             * 获取子布局中三个控件：ImageView TextView TextView
             */
            viewHolder.mIvImg = convertView.findViewById(R.id.item_playlist_image);
            viewHolder.mTvName = convertView.findViewById(R.id.item_playlist_name);
            viewHolder.mTvDate = convertView.findViewById(R.id.item_playlist_date);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (PlaylistAdapter.ViewHolder) convertView.getTag();
        }

        Playlist playlist = mDatas.get(position);
        viewHolder.mIvImg.setImageResource(playlist.getImgId());
        viewHolder.mTvName.setText(playlist.getName());
        viewHolder.mTvDate.setText(playlist.getDate());

        return convertView;
    }

    /**
     * 内部类：可省去findViewById的时间
     * Inner class: save the time of findViewById()
     */
    public static class ViewHolder {
        ImageView mIvImg;
        TextView mTvName;
        TextView mTvDate;
    }
}
