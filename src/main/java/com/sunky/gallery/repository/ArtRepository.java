package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Art;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtRepository extends JpaRepository<Art, Long> {
}
