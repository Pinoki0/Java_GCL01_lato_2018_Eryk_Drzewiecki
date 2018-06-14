package com.example.demo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private GlobalProperties global;

    private List<Photo> photos;
//    private static PhotoService instance = null;
//    public static PhotoService getInstance() {
//        if(instance == null)
//        {
//            try {
//                instance = new PhotoService();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return instance;
//    }

    @PostConstruct
    public void initialize() throws IOException
    {
        photos = new ArrayList<>();
       // File folder = new File("C:\\Users\\Eryk\\Desktop\\ćwiczenia Java\\Lab10\\demo\\src\\main\\resources\\images");
        File folder = new File(global.getImagesPath());

        File[] listOfFiles = folder.listFiles();
        if(listOfFiles !=null){
            for (File file : listOfFiles) {
                BufferedImage img = ImageIO.read(file);
                BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                FileTime creationTime = attributes.creationTime();
                long creation = creationTime.toMillis();
                photos.add(new Photo(photos.size(),file.getName(),img.getHeight()+"x"+img.getWidth(),
                        (int) file.length(),creation));

            }}
    }
    public List<Photo> getPhotos()
    {
        return photos;
    }
    public Photo getPhotoByIndex(int index)
    {
        for(Photo photo : photos)
        {
            if(photo.getIndex() == index)
                return photo;
        }
        return null;
    }
    public boolean deletePhotoByIndex(int index)
    {
        int photoIndex = -1;
        for(Photo photo : photos)
        {
            if(photo.getIndex() == index)
            {
                photoIndex = photos.indexOf(photo);
                break;
            }
        }
        if(photoIndex > -1)
        {
            photos.remove(photoIndex);
        }
        else
        {
            return false;
        }
        return true;
    }
}
