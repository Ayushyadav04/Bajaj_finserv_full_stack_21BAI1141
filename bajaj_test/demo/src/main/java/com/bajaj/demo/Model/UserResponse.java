package com.bajaj.demo.Model;

import java.util.List;

public class UserResponse {
    private String is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<Integer> numbers;
    private List<String> alphabets;
    private String highest_lowercase_alphabet;

    // Getters and Setters


    public String getIs_success() {
        return is_success;
    }

    public void setIs_success(String is_success) {
        this.is_success = is_success;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public String getHighest_lowercase_alphabet() {
        return highest_lowercase_alphabet;
    }

    public void setHighest_lowercase_alphabet(String highest_lowercase_alphabet) {
        this.highest_lowercase_alphabet = highest_lowercase_alphabet;
    }
}
