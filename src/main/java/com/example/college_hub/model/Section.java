package com.example.college_hub.model;

import java.io.Serializable;
import java.util.List;

public class Section implements Serializable {
    private static final long serialVersionUID = 4882979714239832572L;
    private Long sectionId;
    private SectionList section;
    private List<Faculty> facultyList;

    private enum SectionList {
        A, B, C, D, E
    }
}
