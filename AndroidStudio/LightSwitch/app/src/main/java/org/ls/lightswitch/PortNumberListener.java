package org.ls.lightswitch;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by debios on 11/10/16.
 */

public class PortNumberListener implements TextView.OnEditorActionListener {
    MainActivity activity;

    public PortNumberListener(MainActivity activity){
        this.activity = activity;
    }

    private int getPortNumber(String str){
        int port = 0;
        try{
            port = new Integer(str);
        }
        catch(NumberFormatException e){
            return 0;
        }
        return port;
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
        if ((event != null && (event.getKeyCode() == event.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
            int port = getPortNumber(textView.getText().toString());

            if(port > 0)
                activity.setPortNumber(port);
            else
                textView.setError("Invalid port number");
        }
        return false;
    }
}
