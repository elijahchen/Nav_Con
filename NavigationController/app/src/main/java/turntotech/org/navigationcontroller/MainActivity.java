package turntotech.org.navigationcontroller;

//import android.support.v4.app.FragmentTransaction;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import turntotech.org.navigationcontroller.fragments.CompanyFragment;

public class MainActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//    ArrayList<Company> companyArrayList;
//    CompanyAdapter companyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = (RecyclerView) findViewById(R.id.thisRecyclerView);
//
//        Company[] CompanyArray = {
//                new Company(R.mipmap.apple_logo, "Apple"),
//                new Company(R.mipmap.apple_logo, "Samsung"),
//                new Company(R.mipmap.apple_logo, "Huawei"),
//                new Company(R.mipmap.apple_logo, "HTC")
//        };
//        companyArrayList = new ArrayList<>(Arrays.asList(CompanyArray));
//
//        companyAdapter = new CompanyAdapter(companyArrayList);
//        recyclerView.setAdapter(companyAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new CompanyFragment()).commit();

    }
}
