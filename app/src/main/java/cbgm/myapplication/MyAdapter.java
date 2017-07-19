package cbgm.myapplication;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import cbgm.de.listapi.data.CBAdapter;
import cbgm.myapplication.base.ViewItem;

public class MyAdapter extends CBAdapter<ViewItem> {
    public MyAdapter(Context context, List<ViewItem> data) {
        super(context, data);
    }

    @Override
    public void handleSingleClick(final int position) {
        final String item = (String) this.data.get(position).getItem();
        //listMenuListener.handleEdit(item);
        Toast.makeText(context, "got to next view", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleLongClick(int position) {

    }
}
