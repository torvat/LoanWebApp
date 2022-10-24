package no.zdata.torva.houseingloanweb.objects.abstracts;

@FunctionalInterface
public interface Calculate {
    double monthlyPayment(int amount, int periods);
}
