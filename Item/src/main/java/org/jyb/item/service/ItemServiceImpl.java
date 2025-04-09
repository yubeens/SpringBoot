package org.jyb.item.service;

import org.jyb.item.domain.Item;
import org.jyb.item.dto.ItemDTO;
import org.jyb.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public void registerItem(ItemDTO itemDTO) {

    }

    @Override
    public List<ItemDTO> readAllItem() {
        List<Item> result = itemRepository.findAll();
        List<ItemDTO> dtoList = result.stream()
                .map(item -> entityToDto(item))
                .collect(Collectors.toList());/* item을 dto로 바꿔줌 */
        return dtoList;
    }

    @Override
    public ItemDTO readItem(Long id) {
        return null;
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(Long id) {

    }
}
