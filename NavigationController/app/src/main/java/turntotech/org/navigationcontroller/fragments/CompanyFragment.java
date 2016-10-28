package turntotech.org.navigationcontroller.fragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import turntotech.org.navigationcontroller.R;
import turntotech.org.navigationcontroller.utilities.CustomListAdapter;


public class CompanyFragment extends ListFragment {

    ProductFragment productFragment;

    ArrayList<String> companies = new ArrayList<>();
    ArrayList<Integer> logo = new ArrayList<>();

    public CompanyFragment() {
        productFragment = new ProductFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //TODO: BUGFIX- duplicate entries
        companies.add("Apple");
        companies.add("Samsung");
        companies.add("LG");
        companies.add("Huawei");

        logo.add(R.drawable.apple_logo);
        logo.add(R.drawable.apple_logo);
        logo.add(R.drawable.apple_logo);
        logo.add(R.drawable.apple_logo);

        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView) mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setVisibility(View.INVISIBLE);
        mCustomView.findViewById(R.id.addButton).setVisibility(View.INVISIBLE);
        mCustomView.findViewById(R.id.deleteButton).setVisibility(View.INVISIBLE);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);
        title.setText("Watch List");

        CustomListAdapter customListAdapter = new CustomListAdapter(getActivity(), companies, logo);
        setListAdapter(customListAdapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bundle = new Bundle();
        bundle.putInt("CompanyIndex", position);
        bundle.putString("CompanyTitle", companies.get(position));

        productFragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_container, productFragment);
        transaction.commit();

    }


}
