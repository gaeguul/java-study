package org.scoula.ex03.controller;

import java.io.*;
import java.util.*;
import lombok.extern.log4j.*;
import org.scoula.ex03.dto.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
  @RequestMapping("") // url : /sample
  public void basic() {
    log.info("basic............");
  }

  /// url: /sample/basic
  @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
  public void basicGet() {
    log.info("basic get");
  }

  /// url: /sample/basic
  @RequestMapping(value = "/basicOnlyGet")
  public void basicGet2() {
    log.info("basic get");
  }

  //  @GetMapping("/ex01")
  //  public String ex01(SampleDTO dto) {
  //    log.info("" + dto);
  //    return "ex01";
  //  }

  @GetMapping("/input_page")
  public String inputPage() {
    log.info("input page");
    return "sample/input_page";
  }

  @PostMapping("/ex01")
  public String ex01(SampleDTO dto) {
    log.info("" + dto);
    return "sample/ex01";
  }

  @GetMapping("/ex02")
  public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
    log.info("name: " + name);
    log.info("age: " + age);
    return "sample/ex02";
  }

  // @RequestParam 옵션 활용 - 파라미터 누락 및 기본값 처리
  @GetMapping("/ex02-advanced")
  public String ex02Advanced(
      @RequestParam(value = "name", required = false, defaultValue = "익명") String name,
      @RequestParam(value = "age", required = false, defaultValue = "10") int age) {
    // required=false: 파라미터가 없어도 에러 발생하지 않음
    // defaultValue: 파라미터가 없을 때 사용할 기본값 (문자열로 지정, 자동 형변환)

    log.info("name : " + name + ", age : " + age);

    return "sample/ex02";
  }

  @GetMapping("/ex02List")
  public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
    log.info("ids: " + ids);
    return "ex02List";
  }

  @GetMapping("/ex02Array")
  public String ex02Array(@RequestParam("ids") String[] ids) {
    log.info("array ids: " + Arrays.toString(ids));
    return "ex02Array";
  }

  @GetMapping("/ex04")
  public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
    log.info("dto: " + dto);
    log.info("page: " + page);
    return "sample/ex04";
  }

  @GetMapping("/ex07")
  public @ResponseBody SampleDTO ex07() {
    log.info("/ex07........");
    SampleDTO dto = new SampleDTO();
    dto.setAge(10);
    dto.setName("홍길동");
    return dto;
  }

  @GetMapping("/ex08")
  public ResponseEntity<String> ex08() {
    log.info("/ex08..........");
    // {"name": "홍길동"}
    String msg = "{\"name\": \"홍길동\"}";
    HttpHeaders header = new HttpHeaders();
    header.add("Content-Type", "application/json;charset=UTF-8");
    return new ResponseEntity<>(msg, header, HttpStatus.OK);
  }

  @GetMapping("/exUpload")
  public void exUpload() {
    log.info("/exUpload..........");
  }

  @PostMapping("/exUploadPost")
  public void exUploadPost(ArrayList<MultipartFile> files) {
    // MultipartFile: Spring이 제공하는 업로드 파일 래퍼 클래스
    for (MultipartFile file : files) {
      log.info("----------------------------------");
      log.info("name:" + file.getOriginalFilename());  // 원본 파일명
      log.info("size:" + file.getSize());              // 파일 크기 (바이트)
      log.info("contentType:" + file.getContentType()); // MIME 타입

      // 파일이 실제로 선택되었는지 확인
      if (!file.isEmpty()) {
        try {
          // 파일을 지정된 위치에 저장
          File saveFile = new File("/Users/jiham/Desktop" + file.getOriginalFilename());
          file.transferTo(saveFile);  // 임시 파일을 최종 위치로 이동
        } catch (IOException e) {
          log.error("파일 저장 실패", e);
        }
      }
    }
  }

  //
  //  @PostMapping("/exUploadPost")
  //  public void exUploadPost(ArrayList<MultipartFile> files) {
  //    for (MultipartFile file : files) {
  //      log.info("----------------------------------");
  //      log.info("name:" + file.getOriginalFilename()); // 윈도우 OS: 한글 파일명인 경우 깨짐
  //      log.info("size:" + file.getSize());
  //    }
  //  }


}
