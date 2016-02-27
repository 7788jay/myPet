package cn.pet.lin.controller.common;

import cn.pet.lin.domain.common.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lwt on 2016/2/14.
 */
@Controller
@RequestMapping("/common/upload")
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "/img")
    public ResultDTO img(HttpServletRequest request, @RequestParam(value = "file", required = true) MultipartFile file) {
        int width = 100;
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            width = bufferedImage.getWidth();
            System.out.println(file.getOriginalFilename());
            String sep = System.getProperty("file.separator");
            String uploadDir = request.getServletContext().getRealPath("/") + "upload";
            File dirPath = new File(uploadDir);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            File uploadedFile = new File(uploadDir + sep + file.getOriginalFilename());
            FileCopyUtils.copy(file.getBytes(), uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultDTO(true, "/upload/" + file.getOriginalFilename(),width);
    }
    @ResponseBody
    @RequestMapping(value = "/editorImg")
    public void editorImg(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "wangEditorH5File", required = true) MultipartFile file) {
        try {
            System.out.println(file.getOriginalFilename());
            String sep = System.getProperty("file.separator");
            String uploadDir = request.getServletContext().getRealPath("/") + "upload";
            File dirPath = new File(uploadDir);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            File uploadedFile = new File(uploadDir + sep + file.getOriginalFilename());
            FileCopyUtils.copy(file.getBytes(), uploadedFile);
            PrintWriter out = response.getWriter();
            out.print("/upload/" + file.getOriginalFilename());  //返回url地址
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
