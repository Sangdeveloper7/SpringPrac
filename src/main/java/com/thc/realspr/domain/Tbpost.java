package com.thc.realspr.domain;

import com.thc.realspr.dto.TbpostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
public class Tbpost extends AuditingFields{
    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String cate;
    @Setter @Column(nullable = false) private String mpic; // 프로필 사진
    @Setter @Column(nullable = false, length=2000000) @Lob private String content; // 본문
    protected Tbpost(){}
    private Tbpost(String title, String cate, String mpic, String content) {
        this.title = title;
        this.cate = cate;
        this.mpic = mpic;
        this.content = content;
    }
    public static Tbpost of(String title, String cate, String mpic, String content){
        return new Tbpost(title, cate, mpic, content);
    }

    public TbpostDto.CreateResDto toAfterCreateDto() {
        return TbpostDto.CreateResDto.builder().id(getId()).build();
    }
}
