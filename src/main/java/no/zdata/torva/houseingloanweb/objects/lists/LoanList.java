package no.zdata.torva.houseingloanweb.objects.lists;

import no.zdata.torva.houseingloanweb.objects.HouseingLoan;

import java.util.ArrayList;
import java.util.List;


public class LoanList {

    private List<HouseingLoan> loans;

    public LoanList() {
        this.loans = new ArrayList<>();
    }
    public void add(HouseingLoan loan){
        this.loans.add(loan);
    }
    public String print(){
        StringBuilder sb = new StringBuilder();

        for(HouseingLoan loan : loans){
            sb.append(loan).append("\n");
            sb.append("------------------").append("\n");
        }
        return sb.toString();
    }
}
