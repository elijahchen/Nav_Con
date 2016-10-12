package turntotech.org.navigationcontroller.utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;

/**
 * Created by elijah on 10/11/2016.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;
    private final int[] icons;

    public CustomListAdapter(Context context, String[] values, int[] icons) {
        super(context, R.layout.item_company, values);
        this.context = context;
        this.values = values;
        this.icons = icons;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_company, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.company_name);
        textView.setText(values[position]);
        Drawable draw = context.getResources().getDrawable(icons[position]);
//        Bitmap bitmap = ((BitmapDrawable) draw).getBitmap();
//        int h = bitmap.getHeight();
//        int w = bitmap.getWidth();
//        Drawable newDraw = new BitmapDrawable(context.getResources(),
//                Bitmap.createScaledBitmap(bitmap, 40 * w / h, 40, true));

        textView.setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);

        return rowView;
    }
}
