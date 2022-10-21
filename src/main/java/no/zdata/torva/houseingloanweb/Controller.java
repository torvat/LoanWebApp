package no.zdata.torva.houseingloanweb;

import no.zdata.torva.houseingloanweb.objects.HouseingLoan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                                     @RequestParam(name = "duration") String duration,
                                     RedirectAttributes ra){
        try {
            int parsedAmount = Integer.parseInt(amount);
            int parsedDuration = Integer.parseInt(duration);

            if(parsedDuration <= 25) {
                loan = new HouseingLoan(parsedAmount, parsedDuration);
                ra.addFlashAttribute("monthlyPayment", "Monthly payment: " + loan.calculateMothlyBackpay());
            }else
                ra.addFlashAttribute("suit", "The duration is not suitable for the amount");


        }catch (NumberFormatException e){
            ra.addAttribute("nextinvalid", "Invalid-value");
            ra.addFlashAttribute("invalid", "Invalid Value");
            e.printStackTrace();
        }

        return "redirect:" + "calculator";
    }
}
