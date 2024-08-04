package com.nrzm.demo.controller;

import com.nrzm.demo.dto.TestDTO;
import com.nrzm.demo.entity.Item;
import com.nrzm.demo.service.ItemService;
import com.nrzm.demo.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class TestController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/hello4/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id) {
        try{
            ItemDTO itemDTO = itemService.getItemDTObyId(id);
            return ResponseEntity.ok(itemDTO);
        } catch (RuntimeException e) {
            //return ResponseEntity.notFound().build();
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemId(1L);
            itemDTO.setItemName("깅치찌개");
            return ResponseEntity.ok(itemDTO);
        }
    }

   @GetMapping
    public ResponseEntity<List<Object>> hello() {
       List<Object> tmpList = new ArrayList<>();

       //tmpList.add("안녕1");
       //tmpList.add("안녕2");
       //tmpList.add("안녕3");
       //tmpList.add("안녕4");

//       Map<String, String> tmpMap = new HashMap<>();
//       tmpMap.put("title", "제목");
//       tmpMap.put("link", "http://");

//       List<Map<String, String>> mapList = new ArrayList<>();
       List<TestDTO> dtoList = new ArrayList<>();
       //mapList.add(tmpMap);

       TestDTO dto1 = new TestDTO();
       dto1.setTitle("dto 제목");
       dto1.setLink("dto 링크");
       dtoList.add(dto1);

//       tmpList.add(mapList);
       tmpList.add(dtoList);
       return ResponseEntity.ok(tmpList);
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> hello2() {

        return ResponseEntity.ok("안녕하세요2");
    }

    @PostMapping
    public ResponseEntity<String> hello3() {

        return ResponseEntity.ok("안녕하세요3");
    }
}
