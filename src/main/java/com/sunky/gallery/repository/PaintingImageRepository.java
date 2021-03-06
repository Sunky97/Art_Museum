package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.PaintingImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingImageRepository extends JpaRepository<PaintingImage, Long> {
}
