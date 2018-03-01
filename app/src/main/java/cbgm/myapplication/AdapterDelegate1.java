package cbgm.myapplication;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cbgm.de.listapi.basic.CBAdapterDelegate;
import cbgm.de.listapi.basic.CBBaseView;
import cbgm.de.listapi.data.CBModeHelper;
import cbgm.myapplication.base.BaseItem;
import cbgm.myapplication.base.MyButton;
import cbgm.myapplication.base.MyMenuListener;

/**
 * Created by SA_Admin on 15.01.2018.
 */

public class AdapterDelegate1 extends CBAdapterDelegate<BaseItem> {

    private MyMenuListener myMenuListener;

    AdapterDelegate1(MyMenuListener myMenuListener) {
        super();
        this.myMenuListener = myMenuListener;
    }

    @Override
    protected MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(CBBaseView.getView(parent.getContext()), parent, R.layout.backitem_standard);
    }

    @Override
    protected void onBindDelegateViewHolder(final CBAdapterDelegate.CBViewHolder holder, final int position, final List<BaseItem> data) {
        final FirstItem item = (FirstItem) data.get(position);
        final MyViewHolder holderFinal = (MyViewHolder) holder;
        holderFinal.name.setText(item.getTest());
        holderFinal.name.setEnabled(true);
        holderFinal.name.setTextColor(Color.GREEN);
        holderFinal.getButtonContainer().findViewById(CustomLayoutID.CUSTOMBUTTON_ID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBModeHelper.getInstance().isItemTouchCurrentItem(position))
                    myMenuListener.test(item);
            }
        });
        holderFinal.itemView.setTag(holderFinal);
    }

    @Override
    protected boolean isTypeOf(List<BaseItem> data, int position) {
        return data.get(position) instanceof FirstItem;
    }

    public class MyViewHolder extends CBAdapterDelegate.CBViewHolder {
        private TextView name;

        MyViewHolder(View itemView, ViewGroup parent, int itemRessource) {
            super(itemView, parent, itemRessource, true, true);
            this.addCustomButton(new MyButton(CustomLayoutID.CUSTOMBUTTON_ID, R.color.colorAccent, -1), parent.getContext());
            this.name = itemView.findViewById(R.id.txt_dynamic2);
        }
    }
}
