package no.zdata.torva.houseingloanweb.objects;

import no.zdata.torva.houseingloanweb.objects.abstracts.Loan;

public class HouseingLoan extends Loan {

    private final double INTREST = 0.035;

    public HouseingLoan(int amount, int duration) {
        super(amount, duration);
    }

    @Override
    public double calculateMonthlyPayment(){
        double periods = getDuration() * getMONTHS();
        double interest = INTREST/getMONTHS();

        return getAmount()*((interest*(Math.pow(1 + interest, periods)))/(Math.pow(1 + interest, periods)-1));
    }

    //for debugging
    public String printEstimate(){
        return "" + calculateMonthlyPayment();
    }
}
