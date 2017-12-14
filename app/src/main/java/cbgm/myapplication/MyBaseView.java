package cbgm.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;

import cbgm.de.listapi.basic.CBBaseView;

/**
 * Created by SA_Admin on 13.12.2017.
 */

public class MyBaseView extends CBBaseView {

    public static View getView(Context context) {
        LinearLayout temp = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        temp.setLayoutParams(params);
        temp.setPadding(25, 25 ,25,25);

        CardView cardView = new CardView(context);
        // Set the CardView layoutParams
        params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardView.setLayoutParams(params);

        cardView.setRadius(15);

        cardView.setPadding(25, 25, 25, 25);

        cardView.setUseCompatPadding(true);

        cardView.setCardBackgroundColor(Color.MAGENTA);

        cardView.setMaxCardElevation(30);

        cardView.setMaxCardElevation(6);

        cardView.addView(CBBaseView.getView(context));
        temp.addView(cardView);
        return temp;
    }
}
