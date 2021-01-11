package ro.fasttrackit.curs21.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.service.TransactionService;

@Controller
@RequestMapping("transactions")
public class TransactionUIController {
    private final TransactionService transactionService;

    public TransactionUIController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    String getTransactionsPage(Model pageModel) {
        pageModel.addAttribute("transactions", transactionService.getAll());
        return "transactions";
    }

    @GetMapping("{transactionId}")
    String getTransactionPage(Model pageModel, @PathVariable Integer transactionId) {
        pageModel.addAttribute("showDetails", true);
        Transaction one = transactionService.getOne(transactionId);
        pageModel.addAttribute("selectedTransaction", one);
        pageModel.addAttribute("transactions", transactionService.getAll());
        if (one != null) {
            return "transactions";
        } else {
            return "redirect:/transactions";
        }
    }
}
