package com.yuxiang.page;

import java.util.Map;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 10:49
 */
public class PaginaterForTransaction extends Paginater {

    public PaginaterForTransaction(int pageSize, Object dataObj) {
        super(pageSize, dataObj);
        // TODO Auto-generated constructor stub
    }

    public PaginaterForTransaction(int size, int i, int j) {
        super(size, i, j);
    }

    public PaginaterForTransaction(int recordCount, long pageNumber,
                                   int pageSize) {
        super(recordCount, pageNumber, pageSize);
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Map<String, String> sum;

    public Map<String, String> getSum() {
        return sum;
    }

    public void setSum(Map<String, String> sum) {
        this.sum = sum;
    }

}
