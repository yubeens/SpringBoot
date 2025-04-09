package org.jyb.jpaboard.repository;

import org.jyb.jpaboard.domain.BoardEntity;
import org.jyb.jpaboard.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> , BoardSearch {
}
