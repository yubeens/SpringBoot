package org.example.simpleboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.model.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;
    @GetMapping("insert")
    public String insert() {
        return "board/boardWrite";
    }
    @PostMapping("insert")
    public String insert(BoardDTO board) {
        boardService.insert(board);
        return  "board/boardWrite";
    }
    @GetMapping("list")
    public String list(Model model) {
        HashMap<String,Object> map = new HashMap<>();
        List<BoardDTO> lists =  boardService.findAll(map);
        int total = boardService.getCount(map);
        model.addAttribute("barr",lists);
        model.addAttribute("count",total);
        return "board/boardList";
    }
    @GetMapping("view")
    public String view(@RequestParam("num") int num,
                       Model model) {
        BoardDTO board =  boardService.findByNum(num);
        model.addAttribute("board",board);
        return "board/boardView";
    }
    //삭제
    @DeleteMapping("delete/{num}")
    @ResponseBody
    public int delete(@PathVariable("num") int num) {
        boardService.delete(num);
        return num;
    }
    //수정폼
    @GetMapping("update/{num}")
    public String update(@PathVariable("num") int num,
                         Model model) {
        BoardDTO board =  boardService.update(num);
        model.addAttribute("board",board);
        return "board/boardUpdate";
    }
    //수정
    @PutMapping("update")
    @ResponseBody
    public int update(@RequestBody BoardDTO board) {
        boardService.update(board);
        return board.getNum();
    }


}
