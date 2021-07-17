package com.example.movieapplication.Fragments;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.movieapplication.DBHelper;
import com.example.movieapplication.R;

import java.util.ArrayList;


public class RetailerManageFragment extends Fragment {

    ListView listView;
    SearchView searchView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    DBHelper DB;
      @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_retailer_manage, container, false);
        listView=view.findViewById(R.id.mylist);
        searchView=view.findViewById(R.id.searchView);
        list=new ArrayList<String>();
        list.add("Johny Deep");
        list.add("pirates of caribbean");
        list.add("4");


        adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });



        return view;
    }
}