package cdictv.disantao.bean;

import java.util.List;

public class HongLvdengBean {
    /**
     * code : 1
     * data : [{"id":1,"red":10,"green":3,"yellow":5},{"id":2,"red":9,"green":11,"yellow":17},{"id":3,"red":18,"green":14,"yellow":12},{"id":4,"red":2,"green":19,"yellow":17},{"id":5,"red":9,"green":19,"yellow":6}]
     */

    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * red : 10
         * green : 3
         * yellow : 5
         */

        public int id;
        public int red;
        public int green;
        public int yellow;
    }
}
