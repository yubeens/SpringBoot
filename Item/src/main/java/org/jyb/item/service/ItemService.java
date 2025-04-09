package org.jyb.item.service;

import org.jyb.item.domain.Item;
import org.jyb.item.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void registerItem(ItemDTO itemDTO);
    List<ItemDTO> readAllItem();
    ItemDTO readItem(Long id);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(Long id);

    default Item dtoToEntity(ItemDTO itemDTO) {
        Item item = Item.builder()
                .id(itemDTO.getId())
                .itemName(itemDTO.getItemName())
                .price(itemDTO.getPrice())
                .stockNumber(itemDTO.getStockNumber())
                .itemDetail(itemDTO.getItemDetail())
                .itemSellStatus(itemDTO.getItemSellStatus())
                .memo(itemDTO.getMemo())
                .build();
        return item;
    }

    default ItemDTO entityToDto(Item item) {
        ItemDTO itemDTO = ItemDTO.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .price(item.getPrice())
                .stockNumber(item.getStockNumber())
                .itemDetail(item.getItemDetail())
                .itemSellStatus(item.getItemSellStatus())
                .memo(item.getMemo())
                .build();
        return itemDTO;
    }
}
