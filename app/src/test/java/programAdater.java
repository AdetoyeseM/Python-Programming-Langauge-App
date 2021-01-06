import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pythonproject.R;

public class programAdater extends ArrayAdapter<String> {


    String[] SV;
    Context tContext;

    public programAdater(@NonNull Context context, String[] data) {
        super(context, R.layout.listview_item2);
        this.SV = data;
        this.tContext = context;
    }
    @Override
    public int getCount() {
        return SV.length;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        myAdapter.ViewHolder mViewHolder = new myAdapter.ViewHolder();

        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) tContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item2, parent, false);

            mViewHolder.textView = (TextView) convertView.findViewById(R.id.textViewe);

            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (myAdapter.ViewHolder) convertView.getTag();
        }

        mViewHolder.textView.setText(SV[position]);

        return convertView;

    }

    static class ViewHolder{
        TextView textView;

    }

}
