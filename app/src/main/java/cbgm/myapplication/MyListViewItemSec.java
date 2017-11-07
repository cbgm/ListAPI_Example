package cbgm.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cbgm.de.listapi.listener.CBListMode;
import cbgm.de.listapi.listener.ICBActionNotifier;
import cbgm.de.listapi.listener.CBSwipeListener;
import cbgm.myapplication.base.MyHolder;
import cbgm.myapplication.base.ViewItem;

public class MyListViewItemSec extends ViewItem {


    public MyListViewItemSec(String item, MyHolder holder, int itemResource, int firstSelectedPos) {
        super(item, holder, itemResource, firstSelectedPos);
        this.addDelete = true;
    }

    public MyViewHolder2 setUpView(final int position, View convertView, final ViewGroup parent, final CBListMode mode, final ICBActionNotifier listMenuListener, final int highlightPos, final LayoutInflater inflater, final CBSwipeListener swipeListener, Context context) {

        MyViewHolder2 test = (MyViewHolder2)holder;
        test.name.setText(item);
        test.name.setTextColor(Color.BLACK);
        test.name.setEnabled(true);

      /*  if (mode == CBListMode.SORT) {
            test.name.setOnClickListener(null);

        } else {
            test.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listMenuListener.handleShow(item);
                }
            });
        }*/
        return test;
    }

    public MyViewHolder2 initView(View itemView, final Context context) {
        MyViewHolder2 test = (MyViewHolder2)holder;
        test.name = (TextView) itemView.findViewById(R.id.txt_type);
        return test;
    }
}
