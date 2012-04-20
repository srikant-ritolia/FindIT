package com.Manipal.findit;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class IncomeAdapter extends BaseAdapter {

	private Context context;
	private List<Income> incomeList;

	public IncomeAdapter(Context context, List<Income> incomeList) {
		this.context = context;
		this.incomeList = incomeList;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		IncomeView incomeView = null;

		if (convertView == null) {
			incomeView = new IncomeView(context, incomeList.get(position).getIncomeTax(),
					incomeList.get(position).getSalLeft());
		} else {
			incomeView = (IncomeView) convertView;
		}
		Income i = incomeList.get(position);
		incomeView.setIncome(i.getIncomeTax(), i.getSalLeft());

		return incomeView;
	}

	public int getCount() {
		return incomeList.size();
	}

	public Income getItem(int position) {
		return incomeList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

}