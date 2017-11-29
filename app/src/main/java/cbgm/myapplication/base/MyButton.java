package cbgm.myapplication.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cbgm.de.listapi.basic.CBBaseButton;

public class MyButton extends CBBaseButton {
    public MyButton(int buttonId, int colorId, int imageId) {
        super(buttonId, colorId, imageId);
    }

    @Override
    public View customButtonView(final Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setText("button");
        return textView;
    }
}
