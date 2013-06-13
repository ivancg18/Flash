package org.ivan.flash;




import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	
	public static Camera cam = null;
	android.hardware.Camera.Parameters param;
	private Button Flash;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Flash = (Button)findViewById(R.id.flashcontrol);
		Flash.setText("Enciende Linterna");
		
		
		Flash.setOnClickListener(new Button.OnClickListener(){

			   @Override
			   public void onClick(View arg0) {
			    // TODO Auto-generated method stub
			   
				   
				 if(cam == null){
			try{
			     cam = Camera.open();
			     param = cam.getParameters();
			     param.setFlashMode(Parameters.FLASH_MODE_TORCH);
			     cam.setParameters(param);
			     
			     Flash.setText("Apaga Linterna");
		   }catch(Exception e){	 
			   Toast.makeText(getBaseContext(), "Exception flashLightOn()" +e,
		                Toast.LENGTH_SHORT).show();		 
				 }
			    }else{
			     param.setFlashMode(Parameters.FLASH_MODE_OFF);
			     cam.setParameters(param);
			     cam.release();
			     cam = null;
			     Flash.setText("Enciende Linterna");
			    }
			    
			   }});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	


}//class
