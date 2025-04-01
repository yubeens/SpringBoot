package org.example.simpleboard.model;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private BoardMapper boardMapper;
    @Override
    public void dao_insert(BoardDTO board) {
        boardMapper.insert(board);

    }

    @Override
    public List<BoardDTO> dao_findAll(HashMap<String, Object> map) {
        return List.of();
    }

    @Override
    public BoardDTO dao_findByNum(int num) {
        return null;
    }

    @Override
    public void dao_update(BoardDTO board) {

    }

    @Override
    public void dao_delete(int num) {

    }

    @Override
    public int dao_getCount(HashMap<String, Object> map) {
        return 0;
    }
}
