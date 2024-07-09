package com.thc.realspr.dto;

import com.thc.realspr.domain.Tbpost;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class TbpostDto {

	/**/

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CreateReqDto {
		@Schema(description = "title", example="제목")
		@NotNull
		@NotEmpty
		@Size(max=200)
		private String title;

		@Schema(description = "cate", example="구분")
		@NotNull
		@NotEmpty
		@Size(max=50)
		private String cate;
		@Schema(description = "mpic", example="대표사진")
		@NotNull
		@NotEmpty
		@Size(max=400)
		private String mpic;
		@Schema(description = "content", example="내용")
		@NotNull
		@NotEmpty
		@Size(max=40000)
		private String content;

		public Tbpost toEntity() {
			return Tbpost.of(title, cate, mpic, content);
		}
	}

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class CreateResDto {
		@Schema(description = "id", example="length32textnumber")
		private String id;
	}

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class UpdateReqDto {
		@Schema(description = "id", example="")
		@NotNull
		@NotEmpty
		@Size(max=100)
		private String id;

		@Schema(description = "deleted", example="")
		private String deleted;

		@Schema(description = "title", example="제목")
		@Size(max=200)
		private String title;
		@Schema(description = "cate", example="구분")
		@Size(max=50)
		private String cate;
		@Schema(description = "mpic", example="대표사진")
		@Size(max=400)
		private String mpic;
		@Schema(description = "content", example="내용")
		@Size(max=40000)
		private String content;
	}

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SelectResDto extends CommonDto.SelectResDto {
		@Schema(description = "title", example="")
		private String title;
		@Schema(description = "cate", example="")
		private String cate;
		@Schema(description = "mpic", example="")
		private String mpic;
		@Schema(description = "content", example="")
		private String content;
	}

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ListReqDto {
		@Schema(description = "deleted", example="")
		private String deleted;
		@Schema(description = "title", example="")
		private String title;
	}
	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MoreListReqDto extends CommonDto.MoreListReqDto {
		@Schema(description = "title", example="")
		private String title;
		@Schema(description = "cate", example="")
		private String cate;
	}
	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PagedListReqDto extends CommonDto.PagedListReqDto {
		@Schema(description = "title", example="")
		private String title;
		@Schema(description = "cate", example="")
		private String cate;
	}
	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PagedListServDto extends CommonDto.PagedListServDto {
		@Schema(description = "title", example="")
		private String title;
		@Schema(description = "cate", example="")
		private String cate;
	}
	/*
	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PagedListResDto {

		@Schema(description = "요청 페이지", example="1")
		private int callpage;
		@Schema(description = "마지막 페이지", example="100")
		private int lastpage;
		@Schema(description = "한번에 조회할 갯수", example="100")
		private int perpage;
		@Schema(description = "전체 갯수", example="1")
		private int listsize;

		@Schema(description = "리스트", example="상세정보가 담긴 리스트")
		private List<SelectResResDto> list;

	}
	*/

}