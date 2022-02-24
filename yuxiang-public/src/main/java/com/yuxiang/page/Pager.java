package com.yuxiang.page;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 10:43
 */
public class Pager {

    private long pageNumber;
    private int pageSize;

    public Pager() {
    }

    public Pager(long pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
