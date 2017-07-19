package cbgm.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cbgm.de.listapi.listener.IListMenuListener;
import cbgm.de.listapi.listener.IOneClickListener;
import cbgm.de.listapi.listener.SwipeListener;
import cbgm.myapplication.base.MyButton;
import cbgm.myapplication.base.MyHolder;
import cbgm.myapplication.base.MyMenuListener;
import cbgm.myapplication.base.ViewItem;

public class MyListViewItem extends ViewItem {

    @IdRes
    private int id = 220;

    private MyMenuListener myMenuListener;

    public MyListViewItem(String item, MyHolder holder, int itemResource, MyMenuListener myMenuListener) {
        super(item, holder, itemResource);
        this.addDelete = true;
        this.addEdit = true;
        this.customButtons.add(new MyButton(id, R.color.yellow, -1));
        this.myMenuListener = myMenuListener;
    }

    public MyViewHolder setUpView(final int position, View convertView, final ViewGroup parent, final boolean isSortMode, final IListMenuListener listMenuListener, final int highlightPos, final IOneClickListener oneClickListener, final LayoutInflater inflater, final SwipeListener swipeListener, Context context) {

        MyViewHolder test = (MyViewHolder)holder;
        test.name.setText(item);
        test.name.setEnabled(true);
        test.name.setTextColor(Color.GREEN);
        if (isSortMode) {
            test.name.setOnClickListener(null);
        } else {
            test.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listMenuListener.handleShow(item);
                }
            });
        }

        test.buttonContainer.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipeListener.rollback();
                myMenuListener.test(item);
            }
        });
        return test;
    }

    public MyViewHolder initView(View itemView, final Context context) {
        MyViewHolder test = (MyViewHolder)holder;
        test.name = (TextView) itemView.findViewById(R.id.txt_dynamic2);

        return test;
    }
}
