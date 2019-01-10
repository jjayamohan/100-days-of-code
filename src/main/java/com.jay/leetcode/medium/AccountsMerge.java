package com.jay.leetcode.medium;

import java.util.*;

/**
 *
 * Source : https://leetcode.com/problems/accounts-merge/
 *
 * 721. Accounts Merge
 *  Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a
 *  name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of accounts initially, but all of their
 * accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
 *              ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 *
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 *              ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 *
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'],
 * ['John', 'johnnybravo@mail.com'], * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 *
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 *
 */
public class AccountsMerge {

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();

        List<String> account1 = Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"});
        List<String> account2 = Arrays.asList(new String[]{"John", "johnnybravo@mail.com"});
        List<String> account3 = Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"});
        List<String> account4 = Arrays.asList(new String[]{"Mary", "mary@mail.com"});

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        List<List<String>> results = new AccountsMerge().accountsMerge(accounts);
        for (List<String> result : results)
            System.out.println(result);

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Account> lookupMap = new HashMap<>();
        List<List<String>> out = new ArrayList<>();

        for (List<String> each : accounts) {
            Account account = new Account(each);

            for (String email : account.emails) {
                System.out.println(email);
                if (lookupMap.containsKey(email)) {
                    lookupMap.get(email).mergeAccount(account);
                    break;
                } else {
                    lookupMap.put(email, account);
                }
            }
        }

        // Remove duplicate
        Map<Account, String> maps = new HashMap<>();
        for (Account each : lookupMap.values())
            maps.putIfAbsent(each, "");

        for (Account each : maps.keySet())
            out.add(each.toOriginalArray());

        return out;
    }

    class Account {

        String name = "";
        java.util.SortedSet<String> emails = new java.util.TreeSet<>();

        public Account(List<String> input) {
            name = input.get(0);
            for (int i = 1; i < input.size(); i++)
                emails.add(input.get(i));
        }

        public List<String> toOriginalArray() {
            java.util.List<String> out = new java.util.ArrayList<>();
            out.add(name);
            out.addAll(emails);

            return out;
        }

        public void mergeAccount (Account account) {
            if (this.name.equals(account.name))
                this.emails.addAll(account.emails);
        }



        public boolean equals(Object obj) {
            Account eqlobj = (Account) obj;
            return name.equals(eqlobj.name) && emails.equals(eqlobj.emails);
        }
    }


}
