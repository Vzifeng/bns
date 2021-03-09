package com.meimeiv.bns.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author   ：yangyunlong.
 * @ Date     ：Created in 15:35 2021/03/09
 * @Version ： 1.0
 */
@Data
public class Pager {

    private Integer curPage;

    private Integer pageSize;

    private Integer totalRow;

    private Integer totalPage;

    private List list = new ArrayList();
}
