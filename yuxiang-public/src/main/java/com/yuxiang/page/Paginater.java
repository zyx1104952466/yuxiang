package com.yuxiang.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 10:46
 */
public class Paginater implements Serializable {

    public static final int PAGE_SIZE = 5;
    public static final Paginater EMPTY = new Paginater(0, 0);
    private long currentPage;

    private long maxPage;

    private long maxRowCount;

    private int pageSize = PAGE_SIZE;

    private int index;

    private Collection data;

    public Paginater() {

    }

    public Paginater(long maxRowCount, long currentPage) {
        this.maxRowCount = maxRowCount;
        this.countMaxPage();
        this.setCurrentPage(currentPage);
    }

    public Paginater(long maxRowCount, String currentPage) {
        this.maxRowCount = maxRowCount;
        this.countMaxPage();
        this.setCurrentPage(currentPage);
    }

    @SuppressWarnings("unchecked")
    public Paginater(long maxRowCount, String currentPage, Object dataObj) {
        this.maxRowCount = maxRowCount;
        this.countMaxPage();
        this.setCurrentPage(currentPage);

        this.data = new ArrayList();
        this.data.add(dataObj);
    }

    public Paginater(long maxRowCount, long currentPage, int pageSize) {
        this.maxRowCount = maxRowCount;
        this.pageSize = pageSize;
        this.countMaxPage();
        this.setCurrentPage(currentPage);
    }

    @SuppressWarnings("unchecked")
    public Paginater(int pageSize, Object dataObj) {
        this.maxRowCount = 1;
        this.pageSize = pageSize;
        this.countMaxPage();
        this.setCurrentPage(1);

        this.data = new ArrayList();
        this.data.add(dataObj);
    }

    public Paginater(long maxRowCount, String currentPage, int pageSize) {
        this.maxRowCount = maxRowCount;
        this.pageSize = pageSize;
        this.countMaxPage();
        this.setCurrentPage(currentPage);
    }

    public long getIndex() {
        return ++index + this.getOffsetIndex();
    }

    public void setCurrentPage(long currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
        } else if (currentPage > this.maxPage) {
            this.currentPage = this.maxPage;
        } else {
            this.currentPage = currentPage;
        }

        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
    }

    public void setCurrentPage(String currentPage) {
        try {
            setCurrentPage(Integer.parseInt(currentPage));
        } catch (NumberFormatException ex) {
            setCurrentPage(1);
        }
    }

    public long getCurrentPage() {
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }

        return this.currentPage;
    }

    public long getMaxPage() {
        return this.maxPage;
    }

    public long getMaxRowCount() {
        return this.maxRowCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getFirstPage() {
        return 1;
    }

    public long getPriorPage() {
        if (this.currentPage == 1) {
            return this.currentPage;
        }

        return (this.currentPage - 1);
    }

    public long getLastPage() {
        return this.maxPage;
    }

    public long getNextPage() {
        if (this.currentPage == this.maxPage) {
            return this.currentPage;
        }

        return (this.currentPage + 1);
    }

    public long getOffsetIndex() {
        if (currentPage > 0) {
            return (currentPage - 1) * pageSize;
        } else {
            return 0;
        }
    }

    public long getStartRow() {
        return getOffsetIndex();
    }

    public long getEndRow() {
        return currentPage > 0 ? Math.min(pageSize * currentPage, maxRowCount) : 0;
    }

    private void countMaxPage() {
        if (this.maxRowCount % this.pageSize == 0) {
            this.maxPage = this.maxRowCount / this.pageSize;
        } else {
            this.maxPage = this.maxRowCount / this.pageSize + 1;
        }
    }

    public List getBatchPages(int batchSize) {
        return new BatchPage(this, batchSize).getBatchPages();
    }

    @SuppressWarnings("unchecked")
    public List getCurrentPageData(List list) {
        if (list.size() < 1) {
            return null;
        }

        List result = new ArrayList();
        long curRow = (currentPage - 1) * pageSize + 1;

        for (long i = curRow; i < curRow + pageSize; i++) {
            if (i > maxRowCount) {
                break;
            }

            result.add(list.get((int) i - 1));
        }

        return result;
    }

    public Collection getData() {
        return data;
    }

    public void setData(Collection data) {
        this.data = data;
    }
}
