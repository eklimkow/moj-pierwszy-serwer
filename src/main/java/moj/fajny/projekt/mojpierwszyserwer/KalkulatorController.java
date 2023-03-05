package moj.fajny.projekt.mojpierwszyserwer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kalkulator")
public class KalkulatorController {

    //kalkulator/dodaj/1/2
    //kalkulator/odejmij/1/2
    //kalkulator/pomnoz/1/2
    //kalkulator/podziel/1/2

    @GetMapping("/dodaj/{a}/{b}")
    public int dodaj(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @GetMapping("/odejmij/{a}/{b}")
    public int odejmij(@PathVariable int a, @PathVariable int b) {
        return a - b;
    }

    @GetMapping("/pomnoz/{a}/{b}")
    public int pomnoz(@PathVariable int a, @PathVariable int b) {
        return a * b;
    }

    @GetMapping("/podziel/{a}/{b}")
    public float podziel(@PathVariable int a, @PathVariable int b) {
        return a / (float) b;
    }

}
