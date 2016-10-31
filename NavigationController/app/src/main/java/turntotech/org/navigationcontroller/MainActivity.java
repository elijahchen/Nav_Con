package turntotech.org.navigationcontroller;

//import android.support.v4.app.FragmentTransaction;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import turntotech.org.navigationcontroller.fragments.CompanyFragment;

public class MainActivity extends AppCompatActivity {

    Menu thisMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new CompanyFragment()).commit();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Add Product");
        menu.add("Select Product(s)");

        thisMenu = menu;

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getTitle().toString()){
//            case "Add Product":
//
//                break;
//            case "Select Product":
//
//                break;
//        }
//
//        return true;
//    }
}
