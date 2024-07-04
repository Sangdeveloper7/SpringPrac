package com.thc.realspr.domain;


import com.thc.realspr.dto.TbpostDto;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Tbpost extends AuditingFields{
    @Setter
    @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String cate;
    @Setter @Column(nullable = false) private String mpic; // 프로필 사진
    @Setter @Column(nullable = false, length=2000000) @Lob
    private String content; // 본문
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
