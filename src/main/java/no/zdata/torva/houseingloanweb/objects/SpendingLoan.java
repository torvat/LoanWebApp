package no.zdata.torva.houseingloanweb.objects;

import no.zdata.torva.houseingloanweb.objects.abstracts.Loan;

public class SpendingLoan extends Loan {
    private final double INTREST = 0.22;

    public SpendingLoan(int amount, int duration) {
        super(amount, duration);
    }

    @Override
    public double calculateMonthlyPayment() {
        double interest = INTREST/getMONTHS();
        return super.calculate(((amount, periods) ->
                amount * ((interest * Math.pow(1 + interest, periods)) / (Math.pow(1 + interest, periods) - 1))));
    }
}
