package com.example.sdm.xsztw_scenery.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.sdm.xsztw_scenery.R;
import com.example.sdm.xsztw_scenery.model.Image;
import com.example.sdm.xsztw_scenery.model.bean.Url_title;
import com.example.sdm.xsztw_scenery.ui.adapter.MyGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdm on 2015/8/14.
 */
public class AwardFragment extends Fragment {

    private MyGridViewAdapter mAdapter;
    private View view;
    private GridView awardGridView;
    private List awardImageList = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.award_fragment, container, false);
        awardGridView = (GridView) view.findViewById(R.id.award_GridView);
        setData();
        return view;
    }

    private void setData() {
        String message[][] = Url_title.getAward_Url_title();
        for (int i = 0; i < message.length; i++) {
            Image image = new Image();
            image.setTitle(message[i][1]);
            image.setUrl(message[i][0]);
            awardImageList.add(image);
        }
        mAdapter = new MyGridViewAdapter(getActivity(), R.layout.gridview_item,awardImageList);
        awardGridView.setAdapter(mAdapter);
    }

}
