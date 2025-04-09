package org.jyb.item.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_item") //db이름
@Getter @Setter @ToString
@Builder //내가 원하는 형태의 함수(메소드)를 임의로 만들겠다.
@NoArgsConstructor //아무것도 없는 기본 생성자
@AllArgsConstructor //모든 변수를 파라미터로 자동으로 만드는 생성자
public class Item {
    @Id //primary key
    @Column(name = "item_id") //이름 정하기
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI(auto increment) 자동 지정됨
    private Long id; //entity일때는 primary key를 무조건 Long type으로

    @Column(nullable = false,length = 50)
    private String itemName;

    @Column(nullable = false)
    @ColumnDefault("1000")
    private int price;

    @Column(columnDefinition = "int default 10 not null")
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;


    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    @CreationTimestamp //날짜형태
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regTime;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String memo;
    private String remark;
}
