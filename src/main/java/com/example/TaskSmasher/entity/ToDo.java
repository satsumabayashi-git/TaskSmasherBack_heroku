package com.example.TaskSmasher.entity;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //デフォルトコンストラクタを生成
@AllArgsConstructor //すべてのフィールドを引数として持つコンストラクタ生成
public class ToDo {
	private Integer id;
	private String todo;
	private String detail;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Tokyo")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Tokyo")
	private LocalDateTime updatedAt;
	private boolean isCompleted;

}
