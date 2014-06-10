package com.iesebre.DAM2.consolegeneration;

import java.util.ArrayList;
import java.util.HashMap;

import com.iesebre.DAM2.consolegeneration.DashBoardActivity;
import com.iesebre.DAM2.consolegeneration.R;
import com.iesebre.DAM2.consolegeneration.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class productos_json extends Activity{
	
	ListView list;
	TextView consola;
	TextView nom;
	TextView descripcio;
	TextView preu_stock;
	TextView preu_venta_public;
	TextView quantitat;
	Button Btngetdata;
	ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
	
	//URL to get JSON Array
	private static String url = "http://consolegeneration.esy.es/code/index.php/productos/json_productos";
	
	//JSON Node Names 
	private static final String TAG_OS = "Productes";
	private static final String TAG_CONSOLA = "consola";
	private static final String TAG_NOM = "nom";
	private static final String TAG_DESCRIPCIO = "descripcio";
	private static final String TAG_PREU_STOCK = "preu_stock";
	private static final String TAG_PREU_VENTA_PUBLIC = "preu_venta_public";
	private static final String TAG_QUANTITAT = "quantitat";
	
	JSONArray android = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.productos);
        oslist = new ArrayList<HashMap<String, String>>();

        
        
        Btngetdata = (Button)findViewById(R.id.getdata);
        Btngetdata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
		         new JSONParse().execute();

				
			}
		});
        
        
    }


    
    private class JSONParse extends AsyncTask<String, String, JSONObject> {
    	 private ProgressDialog pDialog;
    	@Override
        protected void onPreExecute() {
            super.onPreExecute();
			 consola = (TextView)findViewById(R.id.consola);
			 nom = (TextView)findViewById(R.id.nom);
			 descripcio = (TextView)findViewById(R.id.descripcio);
			 preu_stock = (TextView)findViewById(R.id.preu_stock);
			 preu_venta_public = (TextView)findViewById(R.id.preu_venta_public);
			 quantitat = (TextView)findViewById(R.id.quantitat);
            pDialog = new ProgressDialog(productos_json.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
            
            
            
    	}
    	
    	@Override
        protected JSONObject doInBackground(String... args) {
    		
    		JSONParser jParser = new JSONParser();

    		// Getting JSON from URL
    		JSONObject json = jParser.getJSONFromUrl(url);
    		return json;
    	}
    	 @Override
         protected void onPostExecute(JSONObject json) {
    		 pDialog.dismiss();
    		 try {
    				// Getting JSON Array from URL
    				android = json.getJSONArray(TAG_OS);
    				for(int i = 0; i < android.length(); i++){
    				JSONObject c = android.getJSONObject(i);
    				
    				// Storing  JSON item in a Variable
    				String consola = c.getString(TAG_CONSOLA);
    				String nom = c.getString(TAG_NOM);
    				String descripcio = c.getString(TAG_DESCRIPCIO);
    				String preu_stock = c.getString(TAG_PREU_STOCK);
    				String preu_venta_public = c.getString(TAG_PREU_VENTA_PUBLIC);
    				String quantitat = c.getString(TAG_QUANTITAT);
    				
    			
    				
    				
    				// Adding value HashMap key => value
    				

    				HashMap<String, String> map = new HashMap<String, String>();

    				map.put(TAG_CONSOLA, consola);
    				map.put(TAG_NOM, nom);
    				map.put(TAG_DESCRIPCIO, descripcio);
    				map.put(TAG_PREU_STOCK, preu_stock);
    				map.put(TAG_PREU_VENTA_PUBLIC, preu_venta_public);
    				map.put(TAG_QUANTITAT, quantitat);
    				
    				oslist.add(map);
    				list=(ListView)findViewById(R.id.list);
    				
    				ListAdapter adapter = new SimpleAdapter(productos_json.this, oslist,
    						R.layout.list_v,
    						new String[] { TAG_CONSOLA, TAG_NOM, TAG_DESCRIPCIO, TAG_PREU_STOCK, TAG_PREU_VENTA_PUBLIC, TAG_QUANTITAT }, new int[] {
    							R.id.consola, R.id.nom, R.id.descripcio, R.id.preu_stock, R.id.preu_venta_public, R.id.quantitat});

    				list.setAdapter(adapter);
    				list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    		            @Override
    		            public void onItemClick(AdapterView<?> parent, View view,
    		                                    int position, long id) {
    		                Toast.makeText(productos_json.this, "You Clicked at "+oslist.get(+position).get("name"), Toast.LENGTH_SHORT).show();

    		            }
    		        });

    				}
    		} catch (JSONException e) {
    			e.printStackTrace();
    		}

    		 
    	 }
    }
    
}


