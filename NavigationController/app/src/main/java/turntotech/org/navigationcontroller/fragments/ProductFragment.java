package turntotech.org.navigationcontroller.fragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;


public class ProductFragment extends ListFragment {

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView)mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);


        Bundle bundle = this.getArguments();
        int companyPosition = bundle.getInt("CompanyIndex");
        title.setText(bundle.getString("CompanyTitle") + " Products");



        String[] products = null;

        if(companyPosition==0){
            products = new String[] { "iPhone", "iPAD" };
        }
        if(companyPosition==1){
            products = new String[] { "Galaxy Note", "Galaxy Tab" };
        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, products);
        setListAdapter(arrayAdapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }



}
