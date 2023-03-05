package moj.fajny.projekt.mojpierwszyserwer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kalkulator20")
public class Kalkulator20Controller {

    // POST /kalkulator20/policz
    // "a" : 123
    // "b" : 90
    // "operacja" : "DODAJ" // dodaj, odejmij, pomnoz, podziel, potega

    enum Operacja {
        DODAJ,
        ODEJMIJ,
        POMNOZ,
        PODZIEL,
        POTEGA
    }

    public static class Dzialanie  {
        private int a;
        private int b;
        private Operacja operacja;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public Operacja getOperacja() {
            return operacja;
        }

        public void setOperacja(Operacja operacja) {
            this.operacja = operacja;
        }
    }

    @PostMapping("/policz")
    public int policz (@RequestBody Dzialanie dzialanie) {
        switch (dzialanie.operacja) {

            case DODAJ:
                return dzialanie.a + dzialanie.b;
            case ODEJMIJ:
                return dzialanie.a - dzialanie.b;
            case POMNOZ:
                return dzialanie.a * dzialanie.b;
            case PODZIEL:
                return dzialanie.a / dzialanie.b;
            case POTEGA:
                return (int) Math.pow(dzialanie.a, dzialanie.b);
            default:
                return 0;
        }
    }
}
