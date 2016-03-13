package mohsin.com.androidnavbar2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater lInflater;
    private List<ItemObject> listStorage;

    public CustomAdapter(Context context, List<ItemObject> customizedListView) {
        listStorage = customizedListView;
        this.context = context;

    }

    @Override
    public int getCount() {
        //Log.v("Size", String.valueOf(this.listStorage.size()));

       return this.listStorage.size();
    }

    @Override
    public Object getItem(int position) {
      //  Log.v("Size",listStorage.get(position).toString());
        return listStorage.get(position);

    }

    @Override
    public long getItemId(int position) {
        return listStorage.indexOf(getItem(position));
    }

        @Override
        public View getView ( int position, View convertView, ViewGroup parent){

            lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewHolder listViewHolder;
            if (convertView == null) {
                listViewHolder = new ViewHolder();
                convertView = lInflater.inflate(R.layout.listview_with_text_image, parent, false);

                listViewHolder.textInListView = (TextView) convertView.findViewById(R.id.textView);
                listViewHolder.imageInListView = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(listViewHolder);

            } else {
                listViewHolder = (ViewHolder) convertView.getTag();
            }

            listViewHolder.textInListView.setText(listStorage.get(position).getName());
            listViewHolder.imageInListView.setImageResource(listStorage.get(position).getImageId());
            Log.v("ImageId",String.valueOf(listStorage.get(position).getImageId()));

            return convertView;
        }

        static class ViewHolder{

            TextView textInListView;
            ImageView imageInListView;
        }

}
