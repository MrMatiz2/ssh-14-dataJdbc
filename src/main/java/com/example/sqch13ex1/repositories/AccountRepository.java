package com.example.sqch13ex1.repositories;

import com.example.sqch13ex1.entities.Account;
import com.example.sqch13ex1.models.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

}
