package qthjen_dev.io.intentserviceresultreceive;

import android.annotation.SuppressLint;
import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

// defines a receiver used to pass data to activity from a service
public class MyTestReceiver extends ResultReceiver {

    private Receiver receiver;

    public MyTestReceiver(Handler handler) {
        super(handler);
    }

    // set receiver
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle resultData);
    }

    // this method passes the result to the receiver
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (receiver != null) {
            receiver.onReceiveResult(resultCode, resultData);
        }
    }
}
