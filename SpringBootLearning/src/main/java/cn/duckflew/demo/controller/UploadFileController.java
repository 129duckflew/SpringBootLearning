package cn.duckflew.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class UploadFileController
{
    private static final String UPLOAD_FOLDER=System.getProperty("user.dir")+"/src/main/resources/static/upload/";
    @RequestMapping("/file/index")
    public String index()
    {
        return "upload/index";
    }
    @RequestMapping("/file/uploadstatus")
    public String uploadStatus()
    {
        return "upload/uploadStatus";
    }
    @RequestMapping("/file/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException
    {
        System.out.println("进入upload 控制方法");
        if (file.isEmpty())
        {
            redirectAttributes.addFlashAttribute("message","文件为空 请选择你的文件上传");
            return "redirect:/file/uploadstatus";
        }
        String fName=file.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+"."+fName.substring(fName.lastIndexOf(".")+1);
        Path path= Paths.get(UPLOAD_FOLDER+newName);
        file.transferTo(path);
        redirectAttributes.addFlashAttribute("message","上传你文件"+fName+"成功");
        return "redirect:/file/uploadstatus";
    }
}
