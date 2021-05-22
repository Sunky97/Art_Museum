package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.PaintingImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class PaintingRepositoryTests {

    @Autowired
    private  PaintingRepository paintingRepository;

    @Autowired
    private PaintingImageRepository imageRepository;

    @Commit
    @Transactional
    @Test
    public void 그림_등록(){

        IntStream.rangeClosed(1,100).forEach(i -> {
            Painting painting = Painting.builder().title("Painting..."+i).build();

            System.out.println("---------------------------------------");

            paintingRepository.save(painting);

            int count = (int)(Math.random()*5) +1;

            for(int j = 0; j < count; j++){
                PaintingImage paintingImage = PaintingImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .painting(painting)
                        .imgName("test"+j+".jpg").build();

                imageRepository.save(paintingImage);
            }
        });
    }
}
