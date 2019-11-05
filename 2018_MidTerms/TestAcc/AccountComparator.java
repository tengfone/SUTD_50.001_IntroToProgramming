package com.example.TestAcc;

import java.util.Comparator;

//starting code
public class AccountComparator implements Comparator<Account>{
    // use method compare as it is an additional "un-natural sort"
    public int compare(Account a, Account b){
        return(a.getId().compareTo(b.getId()));
    }
}

