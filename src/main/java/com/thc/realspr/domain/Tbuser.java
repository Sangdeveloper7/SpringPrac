package com.thc.realspr.domain;

import com.thc.realspr.dto.TbuserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

// 2024-05-21 추가 시작
//이것으로 인해 createdAt 이랑 modifiedAt 에 제대로된 값 넣어줄 수 있음
@EntityListeners(AuditingEntityListener.class)
// 2024-05-21 추가 종료
@Getter
@Entity
public class Tbuser {
    @Id private String id;
    @Setter @Column(nullable = false) private String deleted; // 삭제여부

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt; // 생성일시

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt; // 수정일시

    @Setter @Column(nullable = false) private String username; // 사용자아이디
    @Setter @Column(nullable = false) private String password; // 비번
    @Setter @Column(nullable = false) private String name;
    @Setter @Column(nullable = false) private String nick;
    @Setter @Column(nullable = false) private String phone;
    @Setter @Column(nullable = false) private String mpic; // 프로필 사진
    @Setter @Column(nullable = false, length=2000000) @Lob private String content; // 본문
    protected Tbuser(){}
    private Tbuser(String username, String password, String name, String nick, String phone, String mpic, String content) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nick = nick;
        this.phone = phone;
        this.mpic = mpic;
        this.content = content;
    }
    public static Tbuser of(String username, String password){
        return new Tbuser(username, password, "", "", "", "", "");
    }

    @PrePersist
    public void onPrePersist() {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.deleted = "N";
    }

    public TbuserDto.CreateResDto toTbuserAfterCreateDto() {
        return TbuserDto.CreateResDto.builder().id(getId()).build();
        /*
        TbuserDto.TbuserAfterCreateDto a =  new TbuserDto.TbuserAfterCreateDto();
        a.setId(getId());
        return a;
        */
    }
}
