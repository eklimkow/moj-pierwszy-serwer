package moj.fajny.projekt.mojpierwszyserwer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compare")
public class ComparatorController {

    // /compare?left=ASDF2&right=ZZZZ + -H COMPARE_MODE=ASC/DESC
    // left=ASDF2&right=ZZZZ +COMPARE_MODE=ASC -> "Right"
    // left=ASDF2&right=ZZZZ +COMPARE_MODE=DEC -> "Left"

    public String helper(String left, String right) {
        int result = left.compareToIgnoreCase(right);

        if (result < 0) {
            return "LEFT";
        } else if ( result > 0) {
            return "RIGHT";
        } else {
            return "EQUAL";
        }
    }

    @GetMapping
    public String compare (@RequestParam String left, @RequestParam String right, @RequestHeader("COMPARE_MODE") String header ) {
        if (header.equals("ASC")) {
            return helper(left, right);
        } else if (header.equals("DESC")) {
            return helper(right, left);
        } else {
            return "Error";
        }
    }
}