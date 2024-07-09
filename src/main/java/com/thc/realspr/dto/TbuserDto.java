package com.thc.realspr.dto;

import com.thc.realspr.domain.Tbuser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class TbuserDto {

	/**/

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CreateReqDto {
		@Schema(description = "username", example="이메일 주소")
		@NotNull
		@Email
		@NotEmpty
		@Size(max=100)
		private String username;

		@Schema(description = "password", example="비밀번호")
		@NotNull
		@NotEmpty
		@Size(max=50)
		private String password;

		public Tbuser toEntity() {
			return Tbuser.of(username, password);
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

		@Schema(description = "name", example="")
		@Size(max=100)
		private String name;
		@Schema(description = "nick", example="")
		@Size(max=100)
		private String nick;
		@Schema(description = "phone", example="")
		@Size(max=100)
		private String phone;
	}

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SelectResDto {
		@Schema(description = "id", example="")
		private String id;
		@Schema(description = "username", example="이메일 주소")
		private String username;
		@Schema(description = "name", example="")
		private String name;
		@Schema(description = "nick", example="")
		private String nick;
		@Schema(description = "phone", example="")
		private String phone;
		@Schema(description = "createdAt", example="")
		private String createdAt;
		@Schema(description = "modifiedAt", example="")
		private String modifiedAt;
	}

	@Schema
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ListReqDto {
		@Schema(description = "username", example="이메일 주소")
		private String username;
		@Schema(description = "name", example="")
		private String name;
		@Schema(description = "nick", example="")
		private String nick;
		@Schema(description = "phone", example="")
		private String phone;
	}

}