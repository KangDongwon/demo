package com.nrzm.demo.service;

import com.nrzm.demo.dto.ItemDTO;
import com.nrzm.demo.entity.Item;
import com.nrzm.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public ItemDTO getItemDTObyId(Long id) {
        Item item = getItemById(id);
        if (item == null) {
            throw new EntityNotFoundException("Item not found with id: " + id);
        }

        return convertToDTO(item);
    }

    private ItemDTO convertToDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setItemId(item.getId());
        dto.setItemName(item.getItemName());
        return dto;
    }
}
