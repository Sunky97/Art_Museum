package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.PaintingImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaintingRepository extends JpaRepository<Painting, Long> {

    @Query("SELECT p, pi, avg(coalesce(r.grade,0)), count(distinct r) FROM Painting p " +
            "LEFT OUTER JOIN PaintingImage pi on pi.painting = p " +
            "LEFT OUTER JOIN Review r ON r.painting = p GROUP BY p")
    Page<Object[]> getListPage(Pageable pageable);
}
