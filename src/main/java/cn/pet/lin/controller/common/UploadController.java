package cn.pet.lin.controller.common;

import cn.pet.lin.domain.common.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by lwt on 2016/2/14.
 */
@Controller
@RequestMapping("/common/upload")
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "/img")
    public ResultDTO img(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            System.out.println(file.getOriginalFilename());
            String sep = System.getProperty("file.separator");
            String uploadDir = request.getServletContext().getRealPath("/") + "upload";
            File dirPath = new File(uploadDir);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            File uploadedFile = new File(uploadDir + sep + file.getOriginalFilename());
            FileCopyUtils.copy(bytes, uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultDTO(true, "/upload/" + file.getOriginalFilename());
    }
}
