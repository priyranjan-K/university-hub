package com.example.college_hub.model.comp_key;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollegeId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String collegeCode;
    private String collegeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeId collegeId = (CollegeId) o;
        return Objects.equals(collegeCode, collegeId.collegeCode) &&
               Objects.equals(collegeName, collegeId.collegeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collegeCode, collegeName);
    }
}
