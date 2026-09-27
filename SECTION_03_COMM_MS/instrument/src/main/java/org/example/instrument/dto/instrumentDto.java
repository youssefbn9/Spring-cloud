package org.example.instrument.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class instrumentDto {
    private Long id;
    private String instrumentName;
    private String instrumentCode;
}
