package com.example.board01.mapper;

import com.example.board01.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectAll();
    void insertBoard(BoardDTO board);
    BoardDTO selectByBno(int bno);
    void deleteByBno(int bno);
    void updateByBno(BoardDTO board);
    void updateReadCount(int bno);
}
