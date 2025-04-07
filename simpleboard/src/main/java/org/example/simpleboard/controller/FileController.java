package org.example.simpleboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class FileController {
    //파일추가폼
    @GetMapping("uploadFile")
    public void  uploadFile() {

    }
    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("uploads") MultipartFile[] uploads,
                             Model model ) {
        String uploadFolder="C://Spring_Work//uploads";
        ArrayList<String> arr = new ArrayList<>();
        for (MultipartFile multipartFile : uploads) {
            //파일 이름 중복 피하기 위해 이름 수정
            UUID uuid=UUID.randomUUID();
            String uploadFileName=uuid.toString()+"_"+multipartFile.getOriginalFilename();
            File saveFile=new File(uploadFolder,uploadFileName);
            try {
                multipartFile.transferTo(saveFile);
                arr.add(multipartFile.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("fileArr", arr);
        return "fileResult";

    }

}