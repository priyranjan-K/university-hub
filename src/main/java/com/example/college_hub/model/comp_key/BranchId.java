package com.example.college_hub.model.comp_key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BranchId implements Serializable {

    @Serial
    private static final long serialVersionUID = -2390918662605206452L;

    private String branchName;
    private String branchCode;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchId branchId = (BranchId) o;
        return Objects.equals(branchName, branchId.branchName) &&
               Objects.equals(branchCode, branchId.branchCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchName, branchCode);
    }
}
