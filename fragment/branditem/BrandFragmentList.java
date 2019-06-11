package com.example.water.marketplace.fragment.branditem;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.water.marketplace.R;
import com.example.water.marketplace.adapter.AdapterBrandList;
import com.example.water.marketplace.model.StatusBrand;

import java.util.List;


public class BrandFragmentList extends Fragment implements BrandContract.View {

    private static final String TAG = "NewsFragment";
    RecyclerView recyclerView;
    private BrandContract.Presenter presenter;

    public BrandFragmentList() {
        presenter = new BrandPresenter(this);    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brand_list, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*final CalendarFragment calendarFragment = new CalendarFragment();
                calendarFragment.setCaldroidListener(new CaldroidListener() {
                    @Override
                    public void onSelectDate(Date date, View view) {
                        calendarFragment.dismiss();
                        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
                        //Toast.makeText(getBaseContext(), df.format(date), Toast.LENGTH_SHORT).show();
                        fragment.setDate(df.format(date));
                    }
                });
                calendarFragment.show(getSupportFragmentManager(), "calendar");*/
                
                /*
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        BrandFragmentList.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
                */
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.latest_news_recyclerview);
      StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
       // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        presenter.getListBrand();

        return view;
    }

    @Override
    public void refreshRecyclerVew(List<StatusBrand.Brand> storiesList) {
        AdapterBrandList adapter = new AdapterBrandList(storiesList);
        recyclerView.setAdapter(adapter);
    }


   /* @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        //String date = "You picked the following date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        String date = String.format("%d%02d%02d", year, monthOfYear + 1, dayOfMonth);
        presenter.getBeforeNews(date);
    }
    */
}
