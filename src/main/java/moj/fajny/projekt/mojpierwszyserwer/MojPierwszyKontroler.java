package moj.fajny.projekt.mojpierwszyserwer;


import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/test")
public class MojPierwszyKontroler {

    @GetMapping("/pierwsza")
    public String pierwsza() {
        return "Hello World";
    }

    @GetMapping("/druga")
    public String druga() {
        return "Hello World2";
    }

    //test/czesc/MAteusz -> "czesc MAteusz"
    @GetMapping("/czesc/{imie}")
    public String czesc(@PathVariable String imie) {
        return "Czesc " + imie;
    }

    // /test/upper?wartosc=Mateusz -> "MATEUSZ"
    //http://localhost:8080/test/upper?wartosc=ewa
    @GetMapping("/upper")
    public String upper(@RequestParam String wartosc) {
        return wartosc.toUpperCase();
    }

    //http://localhost:8080/test/concat?pierwszy=ASDF&drugi=123
    @GetMapping("/concat")
    public String upper(@RequestParam String pierwszy, @RequestParam String drugi) {
        return pierwszy + drugi;
    }

    //http://localhost:8080/test/najwiekszy?liczby=1&liczby=2&liczby=-5
    @GetMapping("/najwiekszy")
    public int najwiekszy(@RequestParam List<Integer> liczby) {
        liczby.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        return liczby.get(0);
    }

    @GetMapping("/autoryzacja")
    public String autoryzacja(@RequestHeader("NaszaAutoryzacja") String header) {
        if (header.equals("Secret123")) {
            return "jestes zalogowany";
        } else {
            return "unautorized";
        }
    }

    @PostMapping("/odwroc")
    public String odwroc(@RequestBody String wartosc) {
        StringBuilder sb = new StringBuilder();
        return sb.append(wartosc)
                .reverse()
                .toString();
    }

    public static class User {
        private String imie;
        private String nazwisko;

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }
    }

    @PostMapping("/user")
    public String user(@RequestBody User user) {
        return user.imie + " " + user.nazwisko;
    }

}