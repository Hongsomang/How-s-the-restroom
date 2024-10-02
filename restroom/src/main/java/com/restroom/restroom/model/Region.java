package com.restroom.restroom.model;

public enum Region {
    SEOUL("6110000"),
    BUSAN("6260000"),
    DAEGU("6270000"),
    INCHEON("6280000"),
    DAEJEON("6300000"),
    GWANGJU("6290000"),
    ULSAN("6310000"),
    SEJONG("5690000"),
    GYEONGGI_DO("6410000"),
    CHUNGCHEONGNAM_DO("6440000"),
    CHUNGCHEONGBUK_DO("6430000"),
    JEOLLANAM_DO("6460000"),
    JEOLLABUK_DO("6540000"),
    GYEONGSANGNAM_DO("6480000"),
    GYEONGSANGBUK_DO("6470000"),
    GANGWON_DO("6530000"),
    JEJU_DO("6500000");

    private final String code;


    Region(String code){
        this.code=code;

    }

    public String getCode() {
        return code;
    }
}
