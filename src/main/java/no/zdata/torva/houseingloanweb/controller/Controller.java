package no.zdata.torva.houseingloanweb.controller;

import no.zdata.torva.houseingloanweb.database.Connect;
import no.zdata.torva.houseingloanweb.objects.HouseingLoan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@org.springframework.stereotype.Controller
@RequestMapping("calculator")
public class Controller {

    private HouseingLoan loan;

    @GetMapping
    public String viewCalculator(){
        return "calculator";
    }

    @PostMapping
    public String requestCalculation(@RequestParam(name = "amount") String amount,
                                     @RequestParam(name = "duration") String duration, RedirectAttributes ra){
        try {
            int parsedAmount = Integer.parseInt(amount);
            int parsedDuration = Integer.parseInt(duration);

            if(parsedDuration <= 30) {
                loan = new HouseingLoan(parsedAmount, parsedDuration);
                ra.addFlashAttribute("monthlyPayment", "Monthly payment: " + Math.round(loan.calculateMonthlyPayment()));
                requestDatabaseQuery(amount, duration);
            }else
                ra.addFlashAttribute("unsuitable", "The duration is not suitable for the amount");


        }catch (NumberFormatException e){
            ra.addAttribute("nextinvalid", "Invalid-value");
            ra.addFlashAttribute("invalid", "Invalid Value");
            e.printStackTrace();
        }catch (RuntimeException run){
            run.printStackTrace();
            ra.addFlashAttribute("durationisnull", "Duration cannot be 0 or less");
        }
        return "redirect:" + "calculator";
    }
    public void requestDatabaseQuery(String amount, String duration) {

        Connection con = Connect.connect();

        if (con != null) {
            try {
                Statement statement = con.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS loans(id INTEGER PRIMARY KEY AUTOINCREMENT, amount INTEGER," +
                        " duration INTEGER, monthlypayment DOUBLE)");

                int parsedDuration = Integer.parseInt(duration);
                int parsedAmount = Integer.parseInt(amount);
                loan = new HouseingLoan(parsedAmount, parsedDuration);

                statement.executeUpdate("INSERT INTO loans(amount, duration, monthlypayment)VALUES (" +
                        "'" + parsedAmount + "','" + parsedDuration + "'," + "'" + Math.round(loan.calculateMonthlyPayment()) + "')");

                System.out.println("Insert succsess");

                statement.close();
                con.close();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }
}
