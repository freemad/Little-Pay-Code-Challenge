package org.emad.interviews.littlepay.repositories;

import org.emad.interviews.littlepay.entities.Company;

import java.util.HashMap;

public class CompanyRepository {

    public static HashMap<String, Company> COMPANIES = new HashMap<>();
    static {
        COMPANIES.put("Company1", new Company(1, "Company1"));
        COMPANIES.put("Company2", new Company(2, "Company2"));
    }
}
