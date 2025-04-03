package org.example.simpleboard.mapper;

import org.apache.ibatis.annotations.*;
import org.example.simpleboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    //추가
    @Insert("insert into boards(title, writer, content) " +
            " values(#{title},#{writer},#{content})")
    void insert(BoardDTO board);
    //전체보기
    @Select("select * from boards")
    List<BoardDTO> findAll(HashMap<String, Object> map);
    //상세보기
    @Select("select * from boards where num=#{num}")
    BoardDTO findById(int num);
    //수정
    @Update("update boards set title=#{title}, " +
            "content=#{content} where num=#{num}")
    void update(BoardDTO board);
    //삭제
    @Delete("delete from boards where num=#{num}")
    void delete(int num);
    //개수
    @Select("select count(*) from boards")
    int count(HashMap<String, Object> map);
    //조회수 증가
    @Update("update boards set hitcount= hitcount+1 where num = #{num}")
    void upReadCount(int num);
    //////
    //replyCnt 증감
    @Update("update boards set replyCnt= replyCnt+ #{amount} where num=#{bnum}")
    void replyCnt(@Param("bnum") int bnum, @Param("amount") int amount);
}
