package com.example.board01.service;

import com.example.board01.dto.BoardDTO;
import com.example.board01.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        return boardMapper.selectAll();

    }

    @Override
    public BoardDTO getById(int bno) {
        return null;
    }

    @Override
    public BoardDTO getBoard(int bno) {
        boardMapper.updateReadCount(bno);
        return boardMapper.selectByBno(bno);
    }

    @Override
    public void register(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public void modify(BoardDTO board) {
        boardMapper.updateByBno(board);
    }

    @Override
    public void remove(int bno) {
        boardMapper.deleteByBno(bno);

    }
}