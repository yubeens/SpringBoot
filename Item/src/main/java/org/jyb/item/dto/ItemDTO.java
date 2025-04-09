package org.jyb.item.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jyb.item.domain.ItemSellStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;

    @NotEmpty
    private String itemName;

    @NotEmpty
    private int price;

    @NotEmpty
    private int stockNumber;

    private String itemDetail;
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    private String memo;
    private String remark;
}
