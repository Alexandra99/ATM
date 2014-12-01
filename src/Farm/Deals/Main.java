package Farm.Deals;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ImageView;

public class Main extends Activity implements DBConnectionListener, OnClickListener
{
    private Spinner categories_spinner , location_spinner , sort_spinner, spinnerArrayAdapter;
    private Dao dao;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
                
        dao = Dao.instance(this);
        dao.connect("b4tisp0t.ddns.net:1433", "projectpass", "projectuser", "projectdb;");
       
    }

    @Override
	public void onConnectionStatusInfo(final String status) {

		this.runOnUiThread(new Runnable() {

			@Override
			public void run() {

				

			}
		});

	}

	@Override
	public void onConnectionSuccessful() {
                
            
            
		this.runOnUiThread(new Runnable() {
                            
			@Override
			public void run() {

				loadUIComponents();

			}
		});
                
              
                
	}

	@Override
	public void onConnectionFailed() {

            this.runOnUiThread(new Runnable() {

			@Override
			public void run() {

				

			}
		});
		// May be retry or show some error, errors are usually reported in
		// onConnectionStatusInfo()

	}

    private void loadUIComponents() {
        setContentView(R.layout.main);
 
        String categories[] = dao.getCategories();
        String location[] = dao.getLocation();
        String products[][] = dao.getProducts();
        
        categories_spinner = (Spinner) findViewById(R.id.categories_spinner);
        ArrayAdapter<String> categories_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        categories_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories_adapter.notifyDataSetChanged();
        categories_spinner.setAdapter(categories_adapter);
        
        location_spinner = (Spinner) findViewById(R.id.location_spinner);
        ArrayAdapter<String> location_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, location);
        location_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location_adapter.notifyDataSetChanged();
        location_spinner.setAdapter(location_adapter);
        
        sort_spinner = (Spinner) findViewById(R.id.sort_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
        R.array.sort_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.notifyDataSetChanged();
        sort_spinner.setAdapter(adapter3);
        
        
       
        Button button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(this);
        
        
        
        //spinner.r
    }

     public void onClick(View v) {
       String[][] result = dao.getProducts();
   
    }

    
   
}