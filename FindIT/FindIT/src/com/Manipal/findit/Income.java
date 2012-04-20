package com.Manipal.findit;

public class Income {

	private float income;
	private int sex;
	private int age;
	private float incomeTax;
	private float salLeft;

	Income(float i, int s, int a) {
		this.income = i;
		this.age = a;
		this.sex = s;
	}

	public void calc_slab() {
		if ((this.age > 65 && this.income <= 240000)
				|| (this.sex == 0 && this.income <= 160000)
				|| (this.sex == 1 && this.income <= 190000)) {
			this.salLeft = this.income;
			this.incomeTax = 0;
		}
		else if (this.income < 500000) {
			this.incomeTax = (float) (0.1 * this.income);
			this.salLeft = this.income - this.incomeTax;
		}
		else if (this.income < 800000) {
			this.incomeTax = (float) (0.2 * this.income);
			this.salLeft = this.income - this.incomeTax;
		} else {
			this.incomeTax = (float) (0.3 * this.income);
			this.salLeft = this.income - this.incomeTax;
		}
	}

	public float getIncomeTax() {
		return incomeTax;
	}

	public float getSalLeft() {
		return salLeft;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setAge(int age) {
		this.age = age;
	}
}