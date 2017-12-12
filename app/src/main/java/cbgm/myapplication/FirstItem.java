package cbgm.myapplication;

import cbgm.myapplication.base.BaseItem;

/**
 * Created by SA_Admin on 30.11.2017.
 */

public class FirstItem implements BaseItem {
   private String test;

   public FirstItem(String test) {
       this.test = test;
   }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
