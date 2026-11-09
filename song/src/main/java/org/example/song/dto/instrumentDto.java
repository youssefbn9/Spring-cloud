package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrumentDto {
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
