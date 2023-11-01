package lab2;

import java.time.LocalDate;

public class Persoana {

    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCNP() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
    public int getVarsta(){
        int anNastere = Integer.parseInt(cnp.substring(1, 3));
        int lunaNastere = Integer.parseInt(cnp.substring(3, 5));
        int ziNastere = Integer.parseInt(cnp.substring(5, 7));

        int anCurent = LocalDate.now().getYear();
        int lunaCurenta = LocalDate.now().getMonthValue();
        int ziCurenta = LocalDate.now().getDayOfMonth();
        if (anNastere <= anCurent) {
            if (lunaNastere <= lunaCurenta) {
                if (ziNastere <= ziCurenta) {
                    return anCurent - (1900 + anNastere);
                } else {
                    return anCurent - (1900 + anNastere) - 1;
                }
            } else {
                return anCurent - (1900 + anNastere) - 1;
            }
        } else {
            return -1; // CNP-ul nu este valid
        }
    }
}
