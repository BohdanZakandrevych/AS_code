package pl.as.domain;

import jakarta.validation.constraints.NotNull;

public class OcenaIndywidualna {
    private String tresc_Oceny_Indywidualnej;

    @NotNull
    private Projekt projekt;

    public OcenaIndywidualna(Projekt projekt, String tresc_Oceny_Indywidualnej) {
        setProjekt(ValidationUtils.requireNotNull(projekt, "projekt"));
        setTresc_Oceny_Indywidualnej(tresc_Oceny_Indywidualnej);
    }

    public String getTresc_Oceny_Indywidualnej() {
        return tresc_Oceny_Indywidualnej;
    }

    public void setTresc_Oceny_Indywidualnej(String tresc_Oceny_Indywidualnej) {
        this.tresc_Oceny_Indywidualnej = tresc_Oceny_Indywidualnej;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    void setProjekt(Projekt projekt) {
        Projekt nowyProjekt = ValidationUtils.requireNotNull(projekt, "projekt");
        if (this.projekt == nowyProjekt) {
            return;
        }
        if (this.projekt != null) {
            throw new IllegalStateException("projekt jest już ustawiony");
        }

        this.projekt = nowyProjekt;
        if (nowyProjekt.getOcenaIndywidualna() != this) {
            nowyProjekt.setOcenaIndywidualna(this);
        }
    }
}
