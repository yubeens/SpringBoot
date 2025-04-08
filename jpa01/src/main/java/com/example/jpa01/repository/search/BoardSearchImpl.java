package com.example.jpa01.repository.search;

import com.example.jpa01.domain.Board;
import com.example.jpa01.domain.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(board.title.contains("11"));
        booleanBuilder.or(board.content.contains("11"));
        booleanBuilder.or(board.author.contains("11"));
        query.where(booleanBuilder);
        query.where(board.bno.gt(0L));
        this.getQuerydsl().applyPagination(pageable, query);
        List<Board> result = query.fetch();
        long count=query.fetchCount();
        return new PageImpl<Board>(result, pageable, count);
    }

    @Override
    public Page<Board> searchAll(String[] types, String Keyword, Pageable pageable) {
        return null;
    }
}
