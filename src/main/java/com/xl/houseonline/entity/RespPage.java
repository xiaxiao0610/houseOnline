package com.xl.houseonline.entity;

import java.util.List;

public class RespPage {

        private Integer total;
        private List<?> data;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }

}
