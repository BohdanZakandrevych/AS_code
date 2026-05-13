package pl.as.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RaportNaPierwszeSpotkanie {
    @NotBlank
    private String tresc;

    @NotNull
    private Projekt projekt;

    @NotNull
    private CzlonekJury czlonekJury;

    public RaportNaPierwszeSpotkanie(String tresc, CzlonekJury czlonekJury, Projekt projekt) {
        setTresc(tresc);
        setProjekt(ValidationUtils.requireNotNull(projekt, "projekt"));
        setCzlonekJury(ValidationUtils.requireNotNull(czlonekJury, "czlonekJury"));
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = ValidationUtils.requireNotBlank(tresc, "tresc");
    }

    public Projekt getProjekt() {
        return projekt;
    }

    void setProjekt(Projekt projekt) {
        if (this.projekt == projekt) {
            return;
        }
        if (this.projekt != null) {
            this.projekt.usunRaportNaPierwszeSpotkanie(this);
        }
        this.projekt = ValidationUtils.requireNotNull(projekt, "projekt");
        projekt.dodajRaportNaPierwszeSpotkanie(this);
    }

    public CzlonekJury getCzlonekJury() {
        return czlonekJury;
    }

    void setCzlonekJury(CzlonekJury czlonekJury) {
        if (this.czlonekJury == czlonekJury) {
            return;
        }
        if (this.czlonekJury != null) {
            this.czlonekJury.usunRaportNaPierwszeSpotkanie(this);
        }
        this.czlonekJury = ValidationUtils.requireNotNull(czlonekJury, "czlonekJury");
        czlonekJury.dodajRaportNaPierwszeSpotkanie(this);
    }
}
