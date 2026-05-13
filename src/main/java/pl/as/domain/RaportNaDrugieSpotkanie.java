package pl.as.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RaportNaDrugieSpotkanie {
    @NotBlank
    private String tresc;

    @NotNull
    private Projekt projekt;

    @NotNull
    private Assesor assesor;

    public RaportNaDrugieSpotkanie(String tresc, Assesor assesor, Projekt projekt) {
        setTresc(tresc);
        setProjekt(ValidationUtils.requireNotNull(projekt, "projekt"));
        setAssesor(ValidationUtils.requireNotNull(assesor, "assesor"));
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
            this.projekt.usunRaportNaDrugieSpotkanie(this);
        }
        this.projekt = ValidationUtils.requireNotNull(projekt, "projekt");
        projekt.dodajRaportNaDrugieSpotkanie(this);
    }

    public Assesor getAssesor() {
        return assesor;
    }

    void setAssesor(Assesor assesor) {
        if (this.assesor == assesor) {
            return;
        }
        if (this.assesor != null) {
            this.assesor.usunRaportNaDrugieSpotkanie(this);
        }
        this.assesor = ValidationUtils.requireNotNull(assesor, "assesor");
        assesor.dodajRaportNaDrugieSpotkanie(this);
    }
}
