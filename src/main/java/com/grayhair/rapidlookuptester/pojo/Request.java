package com.grayhair.rapidlookuptester.pojo;

public class Request {
    private Query query;
    private Pagination pagination;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
