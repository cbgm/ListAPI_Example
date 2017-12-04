package cbgm.myapplication;

import cbgm.myapplication.base.BaseItem;

/**
 * Created by SA_Admin on 30.11.2017.
 */

public class SecondItem extends BaseItem {
   private int number;

    public SecondItem(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
