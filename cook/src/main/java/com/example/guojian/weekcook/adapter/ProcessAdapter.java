package com.example.guojian.weekcook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guojian.weekcook.R;
import com.example.guojian.weekcook.bean.ProcessBean;
import com.example.guojian.weekcook.utils.ImageLoaderUtil;

import java.util.List;

/**
 * Created by guojian on 11/17/16.
 */
public class ProcessAdapter extends BaseAdapter {

    private Context context;
    private List<ProcessBean> processBeanList;

    public ProcessAdapter(Context context, List<ProcessBean> processBeanList) {
        this.context = context;
        this.processBeanList = processBeanList;
    }

    @Override
    public int getCount() {
        return processBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return processBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProcessViewHolder holder;
        if (convertView == null) {
            holder = new ProcessViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.process_list_item, null);
            holder.pContent = (TextView) convertView.findViewById(R.id.tv_item_process_content);
            holder.pImageView = (ImageView) convertView.findViewById(R.id.iv_item_process_img);
            holder.pStep = (TextView) convertView.findViewById(R.id.tv_steps);
            convertView.setTag(holder);
        } else {
            holder = (ProcessViewHolder) convertView.getTag();
        }

        ProcessBean processBean = processBeanList.get(position);
        String steps = (position+1)+"";
        holder.pStep.setText(steps);
        String ProcessString = processBean.getProcess_pcontent().replace("<br />","");
        holder.pContent.setText(ProcessString);
        String img_url = processBean.getProcess_pic();
        ImageLoaderUtil.setPicBitmap2(holder.pImageView, img_url);

        return convertView;
    }

    class ProcessViewHolder {
        private TextView pContent,pStep;
        private ImageView pImageView;
    }

}
