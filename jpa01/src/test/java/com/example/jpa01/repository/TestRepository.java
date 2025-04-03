package com.example.jpa01.repository;

import com.example.jpa01.domain.Item;
import com.example.jpa01.domain.ItemSellStatus;
import com.example.jpa01.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2
public class TestRepository {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testItemInsert() throws SQLException {
        Item item = Item.builder()
                .itemNm("찹쌀이")
                .price(1000)
                .stockNumber(10)
                .itemSellStatus(ItemSellStatus.판매중)
                .itemDetail("범일동 보안관")
                .build();
        itemRepository.save(item);
    }
    //findAll, findById, update(save), deleteById



    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info(connection);
    }
    @Test
    public void testInsert() throws SQLException {
        Member member = new Member();
        member.setName("test1");
        member.setPassword("123456");
        member.setEmail("test1@gmail.com");
        member.setAddr("부산");
        memberRepository.save(member);
    }
    @Test
    public void testFindAll() throws SQLException {
        List<Member> members = memberRepository.findAll();
        for(int i = 0; i < members.size(); i++) {
            log.info(members.get(i));
        }
    }
    @Test
    public void testFindById() throws SQLException {
        Member member = memberRepository.findById(1L).get();
        log.info(member);
    }
    @Test
    public void testUpdate() throws SQLException {
        Member member = memberRepository.findById(1L).get();
        member.setAddr("서울");
        member.setId(1L);
        memberRepository.save(member);
    }
    @Test
    public void testDelete() throws SQLException {
        memberRepository.deleteById(1L);

    }
}
