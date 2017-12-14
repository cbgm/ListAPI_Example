package cbgm.myapplication;

import android.content.Context;
import android.view.ViewGroup;

import cbgm.de.listapi.basic.CBAdapter;
import cbgm.de.listapi.basic.CBBaseView;
import cbgm.myapplication.base.BaseItem;
import cbgm.myapplication.base.MyHolder;
import cbgm.myapplication.base.MyMenuListener;

public class MyAdapter extends CBAdapter<MyHolder, BaseItem> {

    private MyMenuListener myMenuListener;

    public MyAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        Object temp = this.data.get(position);

        if (temp instanceof FirstItem)
            return 0;
        else
            return 1;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new MyViewHolder(CBBaseView.getView(context), context, parent, R.layout.backitem_standard, myMenuListener);
            case 1:
                return new MyViewHolder2(MyBaseView.getView(context), context, parent, R.layout.backitem_standard2);
            default:
                break;
        }
       return null;
    }

    public void setCustomMenuListener(final MyMenuListener myMenuListener) {
        this.myMenuListener = myMenuListener;
    }
}
