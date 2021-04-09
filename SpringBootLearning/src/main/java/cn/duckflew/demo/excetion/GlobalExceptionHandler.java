package cn.duckflew.demo.excetion;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(MultipartException.class)
    public String handle(MultipartException e, RedirectAttributes redirectAttributes)
    {
        System.out.println("异常函数");
        e.printStackTrace();
        redirectAttributes.addFlashAttribute("message","上传失败");
        return "redirect:/file/uploadstatus";
    }
}
