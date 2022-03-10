package com.yuxiang.file.page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 10:47
 */
public class BatchPage {
    private Paginater p;
    private int batchSize;

    BatchPage(Paginater p, int batchSize) {
        this.p = p;
        this.batchSize = batchSize;
    }

    public List getBatchPages() {
        List list = new ArrayList();

        appendPriorPages(list);
        appendCurrentPage(list);
        appendNextPages(list);

        return list;
    }

    /**
     * append next pages.
     *
     * @param list
     */
    private void appendNextPages(List list) {
        if (p.getCurrentPage() == p.getMaxPage()) {
            return;
        }

        int nextPageNum = this.batchSize - list.size();
        long remainPageNum = p.getMaxPage() - p.getCurrentPage();
        long appendPageNum = nextPageNum < remainPageNum ? nextPageNum : remainPageNum;

        for (long i = 0; i < appendPageNum; i++) {
            addOnePage(list, p.getCurrentPage() + (i + 1));
        }
    }

    /**
     * append current page.
     *
     * @param list
     */
    private void appendCurrentPage(List list) {
        addOnePage(list, p.getCurrentPage());
    }

    /**
     * append prior pages.
     *
     * @param list
     */
    private void appendPriorPages(List list) {
        if (p.getCurrentPage() == 1) {
            return;
        }

        long appendPageNum = 0;
        long currentPage = p.getCurrentPage();
        long remainPageNum = p.getMaxPage() - p.getCurrentPage();

        if (remainPageNum < this.batchSize / 2) {
            appendPageNum = this.batchSize - remainPageNum - 1;
            appendPageNum = appendPageNum < currentPage ? appendPageNum : (currentPage - 1);
        }
        else {
            long priorPageNum = this.batchSize / 2;
            appendPageNum = priorPageNum < currentPage ? priorPageNum : (currentPage - 1);
        }

        for (long i = 0; i < appendPageNum; i++) {
            addOnePage(list, currentPage - appendPageNum + i);
        }
    }

    /**
     * add one page.
     *
     * @param list
     * @param page
     */
    @SuppressWarnings("unchecked")
    private void addOnePage(List list, long page) {
        list.add(String.valueOf(page));
    }
}
