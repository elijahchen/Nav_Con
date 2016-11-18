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
import java.util.Collections;

import turntotech.org.navigationcontroller.R;
import turntotech.org.navigationcontroller.utilities.CustomListAdapter;


public class ProductFragment extends ListFragment {

    Fragment webFragment;

    public ProductFragment() {
        webFragment = new WebFragment();
    }

    private String[] appleList = new String[]{"iPhone", "iPad", "Apple Watch"};
    private int[] appleLogoList = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};

    private String[] samsungList = new String[]{"Galaxy Note", "Galaxy S", "Gear S"};
    private int[] samsungLogoList = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};

    private String[] lglist = new String[]{"LG G", "LG G Pad", "LG Urbane"};
    private int[] lgLogoList = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};

    private String[] huaweiList = new String[]{"Honor", "Mate", "Huawei Watch"};
    private int[] huaweiLogoList = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};

    ArrayList<String> products;
    ArrayList<Integer> logo;

    Bundle bundle;

    public void deleteFromList(int deleteFromPosition, int companyIndex) {
        updateList(companyInQuestion(bundle.getInt("CompanyIndex")),
                companyLogoInQuestion(bundle.getInt("CompanyIndex")),
                bundle.getInt("CompanyIndex"),
                deleteFromPosition,
                companyInQuestion(bundle.getInt("CompanyIndex")).length - 1);
    }

    public String[] companyInQuestion(int position){
        switch(position){
            case 0:
                return appleList;
            case 1:
                return samsungList;
            case 2:
                return lglist;
            case 3:
                return huaweiList;
        }
        return null;
    }

    public int[] companyLogoInQuestion(int position){
        switch(position){
            case 0:
                return appleLogoList;
            case 1:
                return samsungLogoList;
            case 2:
                return lgLogoList;
            case 3:
                return huaweiLogoList;
        }
        return null;
    }

    public void updateList(String[] company, int[] companyLogo, int companyIndex, int changeFromPosition, int newLength) {

        int newLengthOfArray = 0;
        if (company.length < newLength) {
            newLengthOfArray -= 1;
        } else {
            newLengthOfArray += 1;
        }

        String[] tempList = new String[newLengthOfArray];
        int[] tempLogoList = new int[newLengthOfArray];

        for (int i = 0; i < company.length; i++) {
            int counter = 0;
            if (i == changeFromPosition && company.length > newLength) {
                counter++;
            }
            tempList[i] = company[i + counter];
            tempLogoList[i] = companyLogo[i + counter];
        }

        switch (companyIndex) {
            case 0:
                appleList = tempList;
                appleLogoList = tempLogoList;
                break;
            case 1:
                samsungList = tempList;
                samsungLogoList = tempLogoList;
                break;
            case 2:
                lglist = tempList;
                lgLogoList = tempLogoList;
                break;
            case 3:
                huaweiList = tempList;
                huaweiLogoList = tempLogoList;
                break;
        }
    }

    public void onRun(int companyPosition) {
        if (companyPosition == 0) {
            products = new ArrayList<>();
            logo = new ArrayList<>();

            Collections.addAll(products, appleList);

            for (int i = 0; i < appleList.length; i++) {
                logo.add(appleLogoList[i]);
            }
        }

        if (companyPosition == 1) {
            products = new ArrayList<>();
            logo = new ArrayList<>();

            Collections.addAll(products, samsungList);

            for (int i = 0; i < samsungLogoList.length; i++) {
                logo.add(samsungLogoList[i]);
            }
        }

        if (companyPosition == 2) {
            products = new ArrayList<>();
            logo = new ArrayList<>();

            Collections.addAll(products, lglist);

            for (int i = 0; i < lgLogoList.length; i++) {
                logo.add(lgLogoList[i]);
            }
        }

        if (companyPosition == 3) {
            products = new ArrayList<>();
            logo = new ArrayList<>();

            Collections.addAll(products, huaweiList);

            for (int i = 0; i < huaweiLogoList.length; i++) {
                logo.add(huaweiLogoList[i]);
            }
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

        bundle = this.getArguments();
        int companyPosition = bundle.getInt("CompanyIndex");
        title.setText(bundle.getString("CompanyTitle") + " Products");

        onRun(companyPosition);

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

        switch (item.getTitle().toString()) {
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
