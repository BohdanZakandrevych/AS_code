package pl.as.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RaportNaDrugieSpotkanie {
    @NotBlank
    private String tresc;

    @NotNull
    private Projekt projekt;

    @NotNull
    private Asesor asesor;

    public RaportNaDrugieSpotkanie(String tresc, Asesor asesor, Projekt projekt) {
        setTresc(tresc);
        setProjekt(ValidationUtils.requireNotNull(projekt, "projekt"));
        setAsesor(ValidationUtils.requireNotNull(asesor, "asesor"));
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
            this.projekt.usunOceneIndywidualna(this);
        }
        this.projekt = ValidationUtils.requireNotNull(projekt, "projekt");
        projekt.dodajOceneIndywidualna(this);
    }

    public Asesor getAsesor() {
        return asesor;
    }

    void setAsesor(Asesor asesor) {
        if (this.asesor == asesor) {
            return;
        }
        if (this.asesor != null) {
            this.asesor.usunRaportNaDrugieSpotkanie(this);
        }
        this.asesor = ValidationUtils.requireNotNull(asesor, "asesor");
        asesor.dodajRaportNaDrugieSpotkanie(this);
    }
}
