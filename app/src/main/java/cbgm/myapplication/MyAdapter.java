package cbgm.myapplication;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import cbgm.de.listapi.data.CBAdapter;
import cbgm.de.listapi.listener.CBListMode;
import cbgm.myapplication.base.ViewItem;

public class MyAdapter extends CBAdapter<ViewItem> {
    public MyAdapter(Context context, List<ViewItem> data, CBListMode mode) {
        super(context, data, mode);
    }
}
