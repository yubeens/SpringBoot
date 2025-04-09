package org.jyb.jpaboard.service;

import org.jyb.jpaboard.domain.BoardEntity;
import org.jyb.jpaboard.dto.BoardDTO;
import org.jyb.jpaboard.dto.PageRequestDTO;
import org.jyb.jpaboard.dto.PageResponseDTO;

public interface BoardService {
    void registerBoard(BoardDTO boardDTO);
    BoardDTO readBoard(Long id);
    void updateBoard(BoardDTO boardDTO);
    void deleteBoard(Long id);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

    default BoardEntity dtoToEntity(BoardDTO dto) {
        BoardEntity boardEntity = BoardEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();
        return boardEntity;
    }
    default BoardDTO entityToDto(BoardEntity boardEntity) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(boardEntity.getBno())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .author(boardEntity.getAuthor())
                .readcount(boardEntity.getReadcount())
                .regDate(boardEntity.getRegDate())
                .updateDate(boardEntity.getUpdateDate())
                .build();
        return boardDTO;
    }
}
