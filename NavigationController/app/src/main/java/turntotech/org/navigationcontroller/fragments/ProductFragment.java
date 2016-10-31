package turntotech.org.navigationcontroller.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import turntotech.org.navigationcontroller.R;
import turntotech.org.navigationcontroller.utilities.CustomListAdapter;


public class ProductFragment extends ListFragment {

    Fragment webFragment;

    public ProductFragment() {
        webFragment = new WebFragment();
    }

    //TODO: Make a method that changes the array into an arraylist

    private String[] appleList = new String[]{"iPhone", "iPad", "Apple Watch"};
    private int[] appleLogoList = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};

    private String[] lglist = new String[]{"LG G", "LG G Pad", "LG Urbane"};
    private int[] lgLogoList = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};

    ArrayList<String> products = new ArrayList<>();
    ArrayList<Integer> logo = new ArrayList<>();

    public void deleteFromList() {
        //TODO: Make a delete method for the arraylist
    }

    public void updateList() {

    }

    public void initialRun(int companyPosition){
        if (companyPosition == 0) {
            products = new ArrayList<>();
            products.add("iPhone");
            products.add("iPad");
            products.add("Apple Watch");
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
        }

        if (companyPosition == 1) {
            products = new ArrayList<>();
            products.add("Galaxy Note");
            products.add("Galaxy S");
            products.add("Galaxy Gear");
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
        }

        if (companyPosition == 2) {
            products = new ArrayList<>();
            products.add("LG G");
            products.add("LG G Pad");
            products.add("LG Urbane");
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
        }

        if (companyPosition == 3) {
            products = new ArrayList<>();
            products.add("Honor");
            products.add("Mate");
            products.add("Huawei Watch");
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
            logo.add(R.drawable.apple_logo);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView) mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);

        Bundle bundle = this.getArguments();
        int companyPosition = bundle.getInt("CompanyIndex");
        title.setText(bundle.getString("CompanyTitle") + " Products");

        initialRun(companyPosition);

        CustomListAdapter customListAdapter = new CustomListAdapter(getActivity(), products, logo);
        setListAdapter(customListAdapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bundle = this.getArguments();
        bundle.putString("ProductName", products.get(position));
        bundle.putInt("ProductIndex", position);

        webFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, webFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getTitle().toString()){
            case "Add Product":
                Log.i("Menu position 0", "Adding Product");
                break;
            case "Select Product":
                Log.i("Menu position 1", "Selecting Product");
                break;
        }

        return true;
    }


}
