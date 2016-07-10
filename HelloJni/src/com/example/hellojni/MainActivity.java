package com.example.hellojni;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView tv;
	private EditText editText1;
	private EditText editText2;
	private Button operater;
	
	static {
		System.loadLibrary("HelloJni");

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1=(EditText)findViewById(R.id.num1);
		editText2=(EditText)findViewById(R.id.num2);
		operater=(Button)findViewById(R.id.operator);
		tv = (TextView) findViewById(R.id.tv);
		
		final ClientJni jni=new ClientJni();
		
		operater.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String num1=editText1.getText().toString().trim();
				String num2=editText2.getText().toString().trim();
				if (TextUtils.isEmpty(num1)&&TextUtils.isEmpty(num2)) {
					return;
				}else{
					int x=Integer.parseInt(num1);
					int y=Integer.parseInt(num2);
					int num=jni.AddInt(x, y);		
					tv.setText(x+"+"+y+"="+num);
					Toast.makeText(getApplicationContext(), x+"+"+y+"="+num, 1).show();
				}
			}
		});

	}

}
