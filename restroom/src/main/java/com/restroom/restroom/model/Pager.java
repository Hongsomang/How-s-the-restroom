package com.restroom.restroom.model;

import java.util.ArrayList;
import java.util.List;

public class Pager {
    private int page=1;
    private int perPage=10;
    private int perGroup=5;
    private float total;
    private int search=0;
    private String keyword;
    private int subCategoryCode;

    public int getPrev(){return page <=perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup * 1;}

    public int getNext(){
        int next=((page -1)/perGroup+1)*perGroup+1;
        int last=getLast();

        return next < 1 ? 1 : next <last ? next : last;
    }

    public List<Integer> getList(){
        ArrayList<Integer> list=new ArrayList<>();

        int startPage= ((page -1)/perGroup)*perGroup+1;

        for(int index=startPage; index<startPage+perGroup && index <= getLast();index++){
            list.add(index);
        }
        return list;
    }


    public int getLast(){
        int last=(int) Math.ceil(total/perPage);

        return last < 1 ? 1: last;
    }

    public int getoffset(){return (page -1)*perPage;}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPerGroup() {
        return perGroup;
    }

    public void setPerGroup(int perGroup) {
        this.perGroup = perGroup;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getSearch() {
        return search;
    }

    public void setSearch(int search) {
        this.search = search;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(int subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }
}
