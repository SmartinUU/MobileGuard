package cn.edu.gdmec.android.mobileguard.m5virusscan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m5virusscan.entity.ScanAppInfo;


/**
 * Created by zhuang zhu on 2017-11-13.
 */

public class ScanVirusAdapter extends BaseAdapter {
    private List<ScanAppInfo> mScanAppInfo;
    private Context context;

    public ScanVirusAdapter(List<ScanAppInfo> mScanAppInfo, Context context) {
        this.mScanAppInfo = mScanAppInfo;
        this.context = context;
    }
    static class ViewHolder{
        ImageView mAppIconImgv;
        TextView mAppNameTv;
        ImageView mScanIconImgv;
    }

    @Override
    public int getCount() {
        return mScanAppInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return mScanAppInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = View.inflate(context, R.layout.item_list_applock,null);
            holder = new ViewHolder();
            holder.mAppIconImgv = (ImageView)view.findViewById(R.id.imgv_appicon);
            holder.mAppNameTv = (TextView)view.findViewById(R.id.tv_appname);
            holder.mScanIconImgv = (ImageView)view.findViewById(R.id.imgv_lock);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        ScanAppInfo scanAppInfo = mScanAppInfo.get(i);
        if(!scanAppInfo.isVirus){
            holder.mScanIconImgv.setBackgroundResource(R.drawable.blue_right_icon);
            holder.mAppNameTv.setTextColor(context.getResources().getColor(R.color.black));
            holder.mAppNameTv.setText(scanAppInfo.appName);
        }else{
            holder.mAppNameTv.setTextColor(context.getResources().getColor(R.color.bright_red));
            holder.mAppNameTv.setText(scanAppInfo.appName+"("+scanAppInfo.description);
        }
        holder.mAppIconImgv.setImageDrawable(scanAppInfo.appicon);
        return view;
    }
}
