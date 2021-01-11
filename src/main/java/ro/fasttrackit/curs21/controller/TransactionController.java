package ro.fasttrackit.curs21.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.add(transaction);
    }

    @PutMapping("{transactionId}")
    Transaction addTransaction(@PathVariable Integer transactionId, @RequestBody Transaction transaction) {
        return transactionService.replace(transactionId, transaction);
    }

    @DeleteMapping("{transactionId}")
    Transaction deleteTransaction(@PathVariable Integer transactionId) {
        return transactionService.delete(transactionId);
    }
}
