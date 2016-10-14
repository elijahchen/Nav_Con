package turntotech.org.navigationcontroller.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;
import turntotech.org.navigationcontroller.utilities.CustomListAdapter;


public class ProductFragment extends ListFragment {

    public ProductFragment() {
        // Required empty public constructor
    }

    String[] products;
    int[] logo;

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
        actionBar.setDisplayShowCustomEnabled(true);


        Bundle bundle = this.getArguments();
        int companyPosition = bundle.getInt("CompanyIndex");
        title.setText(bundle.getString("CompanyTitle") + " Products");

        if (companyPosition == 0) {
            products = new String[]{"iPhone", "iPad", "Apple Watch"};
            logo = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};
        }
        if (companyPosition == 1) {
            products = new String[]{"Galaxy Note", "Galaxy S", "Galaxy Tab"};
            logo = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};
        }
        if (companyPosition == 2) {
            products = new String[]{"LG G", "LG G Pad", "LG Urbane"};
            logo = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};
        }
        if (companyPosition == 3) {
            products = new String[]{"Honor", "MatePad", "Huawei Watch"};
            logo = new int[]{R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo, R.drawable.apple_logo};
        }

        //TODO: put Bundle to pass onto WebFragment

        CustomListAdapter customListAdapter = new CustomListAdapter(getActivity(), products, logo);
        setListAdapter(customListAdapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }


}
