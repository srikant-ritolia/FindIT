package com.Manipal.findit;

import com.Manipal.findit.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IncomeView extends LinearLayout {

	private TextView tt;
	private TextView bt;

	public IncomeView(Context context, final float incomeTax, final float salary) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.incomeview, this, true);

		tt = (TextView) findViewById(R.id.toptext);
		bt = (TextView) findViewById(R.id.bottomtext);

		setIncome(incomeTax,salary);
	}

	public void setIncome(final float incomeTax, final float salary) {	

		tt.setText(""+incomeTax);
		bt.setText(""+salary);
	}
}
