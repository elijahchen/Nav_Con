package turntotech.org.navigationcontroller.utilities;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import turntotech.org.navigationcontroller.R;

import static android.content.ContentValues.TAG;

/**
 * Created by elijah on 9/23/2016.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyHolder> {

    ArrayList<Company> companyArrayList;

    public CompanyAdapter(ArrayList<Company> companyArrayList) {
        this.companyArrayList = companyArrayList;
    }

    @Override
    // Inflates layout from xml and returning the holder
    public CompanyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        return new CompanyHolder(itemView);
    }

    @Override
    // Returns the count of items within list
    public int getItemCount() {
        return companyArrayList.size();
    }

    @Override
    // Populate data into the item through` the holder
    public void onBindViewHolder(CompanyHolder holder, int position) {
        // Get data model based on position
        Company thisCompany = companyArrayList.get(position);
        // Set item views based on your views and data model
        Drawable drawThis = holder.companyLogo.getContext().getResources().getDrawable(thisCompany.getCompanyLogo());
        holder.companyLogo.setImageDrawable(drawThis);
        holder.companyName.setText(thisCompany.getCompanyName());
        Log.d(TAG,"onBindViewHolder: " + position);

    }

    public class CompanyHolder extends RecyclerView.ViewHolder {

        TextView companyName;
        ImageView companyLogo;

        public CompanyHolder(View itemView) {
            super(itemView);

            companyName = (TextView) itemView.findViewById(R.id.company_name);
            companyLogo = (ImageView) itemView.findViewById(R.id.company_logo);

        }
    }

}
