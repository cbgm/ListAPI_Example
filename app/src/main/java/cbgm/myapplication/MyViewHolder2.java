package cbgm.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cbgm.de.listapi.listener.ICBActionNotifier;
import cbgm.myapplication.base.BaseItem;
import cbgm.myapplication.base.MyHolder;


public class MyViewHolder2 extends MyHolder {
    private TextView name;

    public MyViewHolder2(View itemView, Context context, ViewGroup parent, int itemRessource) {
        super(itemView, context, parent, itemRessource, true, false);
    }

    @Override
    protected void initCustomButtons() {

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void setUpPersonalView(BaseItem listObject, int position, ICBActionNotifier<BaseItem> actionNotifier, Context context) {
        SecondItem temp = (SecondItem) listObject;
        this.name.setText(temp.getNumber()+"");
        this.name.setEnabled(true);
        this.name.setTextColor(Color.BLACK);
    }

    @Override
    public void initPersonalView(View itemView, Context context) {
        this.name = (TextView) itemView.findViewById(R.id.txt_type);
    }
}
