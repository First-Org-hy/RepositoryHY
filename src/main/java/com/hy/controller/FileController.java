package com.hy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** 文件上传 */
@Controller
public class FileController {

  @Value("${img.path}")
  private String imgPath;

  @Value("${img.filename}")
  private String imgfilename;

  @GetMapping(value = "/file")
  public String file() {
    return "file";
  }

  @PostMapping(value = "/fileUpload")
  @ResponseBody
  public Map<String, String> fileUpload(
      @RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
    if (file.isEmpty()) {
      System.out.println("文件为空");
    }
    // 文件名
    String fileName = file.getOriginalFilename();
    // 后缀名
    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    // "D://home//housecd//img//"; // 上传后的路径
    String filePath = imgPath;
    System.out.println(filePath);
    // 新文件名
    fileName = UUID.randomUUID() + suffixName;
    File dest = new File(filePath + fileName);
    if (!dest.getParentFile().exists()) {
      dest.getParentFile().mkdirs();
    }
    try {
      file.transferTo(dest);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //   "/home/housecd/img/"
    String filename = imgfilename + fileName;
    model.addAttribute("filename", filename);
    model.addAttribute("name", "housecd");
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("filename", filename);

    return map;
  }
}
