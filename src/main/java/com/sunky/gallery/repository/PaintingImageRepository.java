package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingImageRepository extends JpaRepository<Painting, Long> {
}
