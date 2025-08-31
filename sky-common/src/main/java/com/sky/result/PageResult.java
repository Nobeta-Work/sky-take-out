package com.sky.result;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total; // 总记录数
    private List<T> records;   // 当前页数据列表
}
