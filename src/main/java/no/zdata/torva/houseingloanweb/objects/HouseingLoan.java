package no.zdata.torva.houseingloanweb.objects;

import no.zdata.torva.houseingloanweb.objects.abstracts.Loan;

public class HouseingLoan extends Loan {

    private final double INTREST = 0.035;

    public HouseingLoan(){
    }

    public HouseingLoan(int amount, int duration) {
        super(amount, duration);
    }

    public double getINTREST() {
        return INTREST;
    }

    @Override
    public int getAmount(){
        return super.getAmount();
    }

    @Override
    public void setAmount(int amount){
        super.setAmount(amount);
    }

    @Override
    public int getDuration(){
        return super.getDuration();
    }
    @Override
    public void setDuration(int duration){
        super.setDuration(duration);
    }

    @Override
    public double calculateMothlyBackpay(){ //Renters rente er ikke tatt høyde for
        double periods = super.getDuration() * 12;
        double installments = super.getAmount() / periods;
        double interest = installments * INTREST;

        return installments + interest;
    }

    @Override
    public String toString() {
        return "Loan: " + "\nAmount: " + super.getAmount() + "\nDuration: " + super.getDuration();
    }

    public String printEstimate(){
        return "" + calculateMothlyBackpay();
    }
}
