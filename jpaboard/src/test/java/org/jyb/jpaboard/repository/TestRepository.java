package org.jyb.jpaboard.repository;

import org.junit.jupiter.api.Test;
import org.jyb.jpaboard.domain.BoardEntity;
import org.jyb.jpaboard.domain.ReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRepository {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Test
    public void testReplySave(){
        ReplyEntity reply = new ReplyEntity();
        reply.setReplyText("This is a test reply");
        reply.setAuthor("author");
        BoardEntity board = boardRepository.findById(1L).get();
        reply.setBoardEntity(board);
        replyRepository.save(reply);
    }
}
