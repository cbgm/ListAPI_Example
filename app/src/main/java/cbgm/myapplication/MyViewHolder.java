package cbgm.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cbgm.de.listapi.data.CBModeHelper;
import cbgm.de.listapi.listener.ICBActionNotifier;
import cbgm.myapplication.base.BaseItem;
import cbgm.myapplication.base.MyButton;
import cbgm.myapplication.base.MyHolder;
import cbgm.myapplication.base.MyMenuListener;


public class MyViewHolder extends MyHolder {
    private TextView name;

    private MyMenuListener myMenuListener;

    public MyViewHolder(View itemView, Context context, ViewGroup parent, int itemRessource, MyMenuListener myMenuListener) {
        super(itemView, context, parent, itemRessource, true, true);
        this.myMenuListener = myMenuListener;
    }

    @Override
    public void initPersonalView(View itemView, Context context) {
        this.name = (TextView) itemView.findViewById(R.id.txt_dynamic2);
    }

    @Override
    protected void initCustomButtons() {
        this.customButtons.add(new MyButton(CustomLayoutID.CUSTOMBUTTON_ID, R.color.yellow, -1));
    }

    @Override
    protected void setUpPersonalView(BaseItem listObject, final int position, ICBActionNotifier<BaseItem> actionNotifier, Context context) {
        final FirstItem temp = (FirstItem) listObject;
        this.name.setText(temp.getTest());
        this.name.setEnabled(true);
        this.name.setTextColor(Color.GREEN);

        this.buttonContainer.findViewById(CustomLayoutID.CUSTOMBUTTON_ID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBModeHelper.getInstance().isItemTouchCurrentItem(position))
                    myMenuListener.test(temp);
            }
        });
    }
}
