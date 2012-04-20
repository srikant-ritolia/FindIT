package com.Manipal.findit;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class FindIT extends Activity{

	private ArrayList<Income> arrayIncomeList;
	private ListView list;
	private EditText income;
	private EditText age_value;
	private Button calculate;
	private Spinner spinnerSex;
	private IncomeAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		arrayIncomeList = new ArrayList<Income>();
		list = (ListView) findViewById(R.id.ListView01);
		adapter = new IncomeAdapter(this, arrayIncomeList);
		list.setAdapter(adapter);

		viewInit();
		setListener();
	}

	public void viewInit() {
		calculate = (Button) findViewById(R.id.Button01);
		income = (EditText) findViewById(R.id.EditText01);
		age_value = (EditText) findViewById(R.id.EditText02);

		spinnerSex = (Spinner) findViewById(R.id.Spinner01);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.sex, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerSex.setAdapter(adapter);
	}

	private void setListener() {

		calculate.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Income incomeObj = null;
				String _income = income.getText().toString();
				int sex = spinnerSex.getSelectedItemPosition();
				String _age = age_value.getText().toString();

				if (!_income.equals("") && !_age.equals("")) {

					incomeObj = new Income(Float.parseFloat(_income), sex, Integer
							.parseInt(_age));
					incomeObj.calc_slab();
					
					arrayIncomeList.add(incomeObj);
					adapter.notifyDataSetChanged();
				} else {
					final AlertDialog alertDialog = new AlertDialog.Builder(
							FindIT.this).create();
					alertDialog.setTitle("Error");
					alertDialog.setMessage("Please enter data.");
					alertDialog.setButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									alertDialog.dismiss();
								}
							});
					alertDialog.show();
				}
			}
		});
	}

}