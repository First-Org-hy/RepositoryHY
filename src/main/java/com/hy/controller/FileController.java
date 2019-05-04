package com.hy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
  public String fileUpload(
      @RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
    if (file.isEmpty()) {
      System.out.println("文件为空");
    }
    String fileName = file.getOriginalFilename(); // 文件名
    String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
    String filePath = imgPath; // "D://home//housecd//img//"; // 上传后的路径

    fileName = UUID.randomUUID() + suffixName; // 新文件名
    File dest = new File(filePath + fileName);
    if (!dest.getParentFile().exists()) {
      dest.getParentFile().mkdirs();
    }
    try {
      file.transferTo(dest);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String filename = imgfilename + fileName; // /home/housecd/img/
    model.addAttribute("filename", filename);
    model.addAttribute("name", "housecd");
    return "file";
  }
}
