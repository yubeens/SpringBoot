package org.jyb.jpaboard.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private Long rno;
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String author;
    @NotEmpty
    private Long bno;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
