package no.zdata.torva.houseingloanweb.objects.abstracts;

public abstract class Loan {

    private int amount;
    private int duration;
    private final int MONTHS = 12;
    public Loan() {
    }
    public Loan(int amount, int duration) {
        this.amount = amount;
        setDuration(duration);
    }
    public int getAmount() {
        return this.amount;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration){
        if(duration <= 0) {
            throw new RuntimeException("Duration cannot be 0 or less");
        }else{
            this.duration = duration;
        }
    }
    public int getMONTHS(){
        return this.MONTHS;
    }
    public double calculateMonthlyPayment(){
        return 0;
    }
    @Override
    public String toString() {
        return "Loan: " + "\nAmount: " + this.amount + "\nDuration: " + this.duration;
    }
}
