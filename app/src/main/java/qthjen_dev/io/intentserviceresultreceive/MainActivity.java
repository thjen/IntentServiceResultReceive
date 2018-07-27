package qthjen_dev.io.intentserviceresultreceive;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public MyTestReceiver receiverForTest = new MyTestReceiver(new Handler());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupServiceReceiver();
        onStartService();
    }

    // Starts the IntentService
    // and push data
    public void onStartService() {
        Intent i = new Intent(this, MyTestService.class);
        i.putExtra("val1", "qthjen");
        i.putExtra("receiver", receiverForTest);
        startService(i);
    }

    // Setup the callback for when data is received from the service
    public void setupServiceReceiver() {
        receiverForTest.setReceiver(new MyTestReceiver.Receiver() {
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == RESULT_OK) {
                    String resultVal = resultData.getString("resultValue");
                    Toast.makeText(MainActivity.this, resultVal + "", Toast.LENGTH_SHORT).show();
                    Log.d("haha", resultVal + "");
                }
            }
        });
    }
}
