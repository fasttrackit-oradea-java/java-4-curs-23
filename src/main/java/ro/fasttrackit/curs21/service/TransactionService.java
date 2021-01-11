package ro.fasttrackit.curs21.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    }

    public Transaction getOne(Integer transactionId) {
        return repository.findById(transactionId).orElse(null);
    }

    public Transaction add(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction replace(Integer transactionId, Transaction transaction) {
        transaction.setId(transactionId);
        return repository.save(transaction);
    }

    public Transaction delete(Integer transactionId) {
        Optional<Transaction> dbTransaction = repository.findById(transactionId);
        dbTransaction.ifPresent(repository::delete);
        return dbTransaction.orElse(null);
    }
}
