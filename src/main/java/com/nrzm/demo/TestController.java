package com.nrzm.demo;

import com.nrzm.demo.dto.TestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class TestController {

   @GetMapping
    public ResponseEntity<List<Object>> hello() {
       List<Object> tmpList = new ArrayList<>();

       tmpList.add("안녕1");
       tmpList.add("안녕2");
       tmpList.add("안녕3");
       tmpList.add("안녕4");

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
