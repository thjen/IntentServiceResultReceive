package qthjen_dev.io.intentserviceresultreceive;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public class MyTestService extends IntentService {

    public MyTestService() {
        super("MyTestService");
    }

    /*public MyTestService(String name) {
        super(name);
    }*/

    @Override
    protected void onHandleIntent(Intent intent) {
        ResultReceiver resultReceiver = intent.getParcelableExtra("receiver");
        String val = intent.getStringExtra("val1");

        Bundle bundle = new Bundle();
        bundle.putString("resultValue", "My Result Value. Passed in: " + val);
        resultReceiver.send(Activity.RESULT_OK, bundle);
    }
}
