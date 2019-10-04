package foodsqlitedemo.quocnguyen.com.foodsqlitedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;


public class SendMoney extends AppCompatActivity {

    Button SendMessageBT;
    EditText PhoneNumber;
    EditText MessageBody;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        MessageBody = (EditText) findViewById(R.id.MessageBody);
        SendMessageBT = (Button) findViewById(R.id.SendMessageBT);
        mTextView = (TextView) findViewById(R.id.mTextView);

        SendMessageBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMS();
            }
        });


    }

    protected void sendSMS() {

       // Toast.makeText(getApplicationContext(),"Hello its all fine now",Toast.LENGTH_LONG).show();
        mTextView.setText("Hello This goes here now".toString());

try{

    String url = "http://my-json-feed";

    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                public void onResponse(JSONObject response) {
                    mTextView.setText("Response: " + response.toString());
                }
            }, new Response.ErrorListener() {


                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error

                }
            });

// Access the RequestQueue through your singleton class.
// MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
}
catch (Exception e){

    Toast.makeText(getApplicationContext(),
            "Sending SMS failed.",
            Toast.LENGTH_LONG).show();
    e.printStackTrace();
}



    }

}
