package com.market.orders_service.util;

public class Util {
    public enum Status{
        PENDING_SUPLIER_APPROVAL(1),
        IN_PROGRESS(2),
        PENDING_ACCEPTANCE(3),
        ACCEPTED(4);

        int code;
        Status(int code){
            this.code=code;
        }

        public int getCode(){
            return code;
        }
    }
}
