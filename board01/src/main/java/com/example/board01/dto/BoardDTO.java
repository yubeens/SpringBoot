package com.example.board01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private int bno;
    private String title;
    private String content;
    private String author;
    private Date postdate;
    private int readcount;

}
