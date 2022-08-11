package sg.edu.rp.c346.id20026955.democarpark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    AsyncHttpClient client;
    ArrayList<Carpark> alCarpark;
    CarparkAdapter aaCarpark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        client = new AsyncHttpClient();
    }
    @Override
    protected void onResume() {
        super.onResume();

        alCarpark = new ArrayList<Carpark>();
        aaCarpark = new CarparkAdapter(MainActivity.this, R.layout.row, alCarpark);
        lv.setAdapter(aaCarpark);

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String carpark_num;
            String total_lots;
            String type;
            String left;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCarInfo = firstObj.getJSONArray("carpark_data");
                    for(int i = 0; i < jsonArrCarInfo.length(); i++) {
                        JSONObject jsonObjCarInfo = jsonArrCarInfo.getJSONObject(i);
                        carpark_num = jsonObjCarInfo.getString("carpark_number");
                        JSONArray jsonExCar = jsonObjCarInfo.getJSONArray("carpark_info");
                        JSONObject json1 = jsonExCar.getJSONObject(0);
                        total_lots = json1.getString("total_lots");
                        type = json1.getString("lot_type");
                        left = json1.getString("lots_available");
                        Carpark carpark = new Carpark( carpark_num,total_lots, type,left);
                        alCarpark.add(carpark);
                    }
                }
                catch(JSONException e){

                }
                lv.setAdapter(aaCarpark);
            }
        });
    }
}