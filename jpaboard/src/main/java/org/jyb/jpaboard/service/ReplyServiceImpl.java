package org.jyb.jpaboard.service;

import lombok.RequiredArgsConstructor;
import org.jyb.jpaboard.domain.BoardEntity;
import org.jyb.jpaboard.domain.ReplyEntity;
import org.jyb.jpaboard.dto.PageRequestDTO;
import org.jyb.jpaboard.dto.PageResponseDTO;
import org.jyb.jpaboard.dto.ReplyDTO;
import org.jyb.jpaboard.repository.BoardRepository;
import org.jyb.jpaboard.repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Override
    public void register(ReplyDTO replyDTO) {
        ReplyEntity replyEntity = dtoToEntity(replyDTO);
        BoardEntity boardEntity = boardRepository.findById(replyDTO.getBno()).get();
        replyEntity.setBoardEntity(boardEntity);
        replyRepository.save(replyEntity);
    }

    @Override
    public ReplyDTO read(Long rno) {
        return null;
    }

    @Override
    public void modify(ReplyDTO replyDTO) {

    }

    @Override
    public void remove(Long rno) {

    }

    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {
        return null;
    }
}
