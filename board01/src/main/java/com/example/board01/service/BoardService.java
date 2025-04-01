package com.example.board01.service;

import com.example.board01.dto.BoardDTO;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
    BoardDTO getById(int bno);

    BoardDTO getBoard(int bno);

    void register(BoardDTO board);
    void modify(BoardDTO board);
    void remove(int bno);


}
