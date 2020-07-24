package com.example.paises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.paises.Adapter.AdaptadorPais;
import com.example.paises.Model.Pais;
import com.example.paises.WebService.Asynchtask;
import com.example.paises.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask{

    ArrayList<Pais> listaPaises;
    RecyclerView recyclerPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPaises = (RecyclerView) findViewById(R.id.rvPaises);
        recyclerPaises.setLayoutManager(new LinearLayoutManager(this));

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://restcountries.eu/rest/v2/all",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Pais> lstPaises = new ArrayList<Pais> ();

        try {
            JSONArray JSONlista =  new JSONArray(result);
            lstPaises = Pais.JsonObjectsBuild(JSONlista);
            AdaptadorPais adapator = new AdaptadorPais(lstPaises,MainActivity.this);
            recyclerPaises.setAdapter(adapator);
        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }


}
