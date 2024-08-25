package com.bajaj.demo.Controller;
import com.bajaj.demo.Model.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class Controller {

    // Hardcoded values
    private final String USER_ID = "ayush_11102002";
    private final String COLLEGE_EMAIL_ID = "ayushyadav.b22@gmail.com";
    private final String COLLEGE_ROLL_NUMBER = "21BAI1141";

    @PostMapping("/process")
    public UserResponse processUserData(@RequestBody Map<String, Object> requestData) {
        List<String> dataList = (List<String>) requestData.get("data");

        // Initialize arrays
        List<Integer> numberArray = new ArrayList<>();
        List<String> alphabetArray = new ArrayList<>();

        // Logic to segregate numbers and alphabets
        for (String item : dataList) {
            if (item.matches("\\d+")) { // Check if it's a number
                numberArray.add(Integer.parseInt(item));
            } else if (item.matches("[a-zA-Z]")) { // Check if it's an alphabet
                alphabetArray.add(item);
            }
        }

        // Logic to find the highest lowercase alphabet
        String highestLowercaseAlphabet = alphabetArray.stream()
                .filter(ch -> ch.matches("[a-z]"))
                .max(Comparator.naturalOrder())
                .orElse(null);

        // Creating response
        UserResponse response = new UserResponse();
        response.setIs_success("true");
        response.setUser_id(USER_ID);
        response.setEmail(COLLEGE_EMAIL_ID);
        response.setRoll_number(COLLEGE_ROLL_NUMBER);
        response.setNumbers(numberArray);
        response.setAlphabets(alphabetArray);
        response.setHighest_lowercase_alphabet(highestLowercaseAlphabet);

        return response;
    }

    @GetMapping("/operation-code")
    public Map<String, Object> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        int ans = 1;
        response.put("operation_code", ans);
        return response;
    }
}
