package pkgCore;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
		public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}

	
	
	public double AmountToSave()
	{
		/*
		 * PMT(rate,nper,pv,fv,type)

	For a more complete description of the arguments in PMT, see the PV function.

	Rate is the interest rate for the loan.

	Nper is the total number of payments for the loan.

	Pv is the present value, or the total amount that a series of future payments is worth now; also known as the principal.
	
	Fv is the future value, or a cash balance you want to attain after the last payment is made. If fv is omitted, it is assumed to be 0 (zero), that is, the future value of a loan is 0.

	Type is the number 0 (zero) or 1 and indicates when payments are due.
	
	12 payments per year every year
	rate for each month
		 */
		return (double)FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, TotalAmountSaved(), false);
	}
	
	public double TotalAmountSaved()
	{
		//PV(rate, periods, payment, future, type)
		return (double)FinanceLib.pv(dAnnualReturnRetired / 12, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false);
	}
	public int getiYearsToWork() {
		return iYearsToWork;
	}



	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}



	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}



	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}



	public int getiYearsRetired() {
		return iYearsRetired;
	}



	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}



	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}



	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}



	public double getdRequiredIncome() {
		return dRequiredIncome;
	}



	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}



	public double getdMonthlySSI() {
		return dMonthlySSI;
	}



	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}



	
}
