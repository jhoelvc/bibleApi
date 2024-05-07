package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.ItemDTO;
import com.bible.bibleApi.model.Item;
import com.bible.bibleApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ItemDTO> itemDTOS = itemService.findAll()
                .stream()
                .map(item -> ItemDTO.builder()
                        .code(item.getCode())
                        .name(item.getName())
                        .price(item.getPrice())
                        .itemPackageDetails(item.getItemPackageDetails())
                        .build())
                .toList();

        return ResponseEntity.ok(itemDTOS);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findById(@PathVariable("code") Integer code) {
        Item item = itemService.findById(code);

        if (item != null){
            ItemDTO itemDTO = ItemDTO.builder()
                    .code(item.getCode())
                    .name(item.getName())
                    .price(item.getPrice())
                    .itemPackageDetails(item.getItemPackageDetails())
                    .build();

            return ResponseEntity.ok(itemDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ItemDTO itemDTO) throws URISyntaxException {
        if (itemDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        itemService.create(Item.builder()
                        .name(itemDTO.getName())
                        .price(itemDTO.getPrice())
                .build());

        return ResponseEntity.created(new URI("/v1/api/item")).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ItemDTO itemDTO) {
        Item item = itemService.findById(itemDTO.getCode());

        if (item != null) {
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());

            return ResponseEntity.ok(itemService.update(item));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable("code") Integer code) {
        itemService.delete(code);
    }
}
