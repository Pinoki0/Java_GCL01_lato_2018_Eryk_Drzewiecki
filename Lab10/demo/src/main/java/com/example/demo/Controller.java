package com.example.demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Base64;


@RestController
@RequestMapping("/gallery")
public class Controller {

//    @Autowired
//    private GlobalProperties global;

    @Autowired
    private PhotoService photoServiceData;


    //PhotoService photoServiceData = PhotoService.getInstance();
    @GetMapping("/pictures")
    public List<Photo> index()
    {
        return photoServiceData.getPhotos();
    }
    @DeleteMapping("/picture/{index}")
    public ResultMessage delete(@PathVariable int index) throws IOException
    {
        Photo photo = photoServiceData.getPhotoByIndex(index);
        if(photo!=null)
        Files.deleteIfExists(Paths.get("C:\\Users\\Eryk\\Desktop\\ćwiczenia Java\\Lab10\\demo\\src\\main\\resources\\images\\"+photo.getName()));
        boolean result = photoServiceData.deletePhotoByIndex(index);
        return new ResultMessage(result);
    }
    @GetMapping(value="/picture/{index}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable int index) throws IOException {
        Photo photo = photoServiceData.getPhotoByIndex(index);
        if(photo != null)
        {
            File initialFile = new File("C:\\Users\\Eryk\\Desktop\\ćwiczenia Java\\Lab10\\demo\\src\\main\\resources\\images\\"+photo.getName());

            InputStream targetStream = new FileInputStream(initialFile);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(targetStream));
        }
        return null;
    }

   /* @GetMapping(value="/picture/upload",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultMessage upload(Upload upload) {


        try
        {
            byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes());
            System.out.println("encodedBytes " + new String(encodedBytes));
            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
            System.out.println("decodedBytes " + new String(decodedBytes));
            return new ResultMessage(true);
        }
        catch(Exception e)
        {
            return new ResultMessage(false);
        }
    }*/
   //Save the uploaded file to this folder
   @GetMapping("/upload")
   public String indexx() {
       return "upload";
   }
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\Eryk\\Desktop\\ćwiczenia Java\\Lab10\\demo\\src\\main\\resources\\images\\" + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
