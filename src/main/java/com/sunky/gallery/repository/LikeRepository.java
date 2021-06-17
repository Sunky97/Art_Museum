package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Likes;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findByMemberAndPainting(Long id, Long pno);
}
