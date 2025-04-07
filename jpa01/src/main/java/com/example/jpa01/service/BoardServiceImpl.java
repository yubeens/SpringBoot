package com.example.jpa01.service;

import com.example.jpa01.domain.Board;
import com.example.jpa01.dto.BoardDTO;
import com.example.jpa01.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public void registerBoard(BoardDTO boardDTO) {
        Board board = dtoToEntity(boardDTO);
        boardRepository.save(board);
    }

    @Override
    public void registerBoard(Board boardDTO) {

    }

    @Override
    public BoardDTO readBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        board.updateReadcount();
        boardRepository.save(board);
        BoardDTO boardDTO = entityToDto(board);
        return boardDTO;
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) {
        Board board1 = boardRepository.findById(boardDTO.getBno()).get();
        /* change 함수 활용법*/
        board1.change(boardDTO.getTitle(), boardDTO.getContent());
        /* 따로 함수를 안만들었을때 방법 */
//        board1.setContent(boardDTO.getContent());
//        board1.setAuthor(boardDTO.getAuthor());
//        board1.setTitle(boardDTO.getTitle());
        boardRepository.save(board1);
    }

    @Override
    public void updateBoard(Board board) {

    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public List<BoardDTO> readAllBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDTO> boardDTOs = boards.stream()
                .map(board -> entityToDto(board))
                .collect(Collectors.toList());
//        List<BoardDTO> boardDTOList=new ArrayList<>();
//        for (Board board : boards) {
//            boardDTOList.add(boardToBoardDTO(board));
//        }
        return boardDTOs;
    }
}
