package org.example.instrument.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    public String getInstrumentName() {
        return name;
    }

    public void setInstrumentName(String instrumentName) {
        this.name = instrumentName;
    }

    public String getInstrumentCode() {
        return code;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.code = instrumentCode;
    }
}
