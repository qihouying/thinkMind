package com.qhy.practice.history.array.h.h20181022;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 22, 2018 17:49
 */
public class NestedInteger {
      int value;
      NestedInteger nestedInteger;
      List<NestedInteger> nestedIntegers;
     public NestedInteger() {
     }
     public NestedInteger(int value){
           this.value = value;
           if (this.nestedInteger == null) {
                 nestedInteger = new NestedInteger();
                 nestedInteger.value = value;
           }
     }
     public void add(NestedInteger ni) {
           if (null == nestedInteger) {
                 nestedInteger = new NestedInteger();
           }
           nestedInteger=ni;
           nestedIntegers.add(nestedInteger);
     }
     /*public List<NestedInteger> getList() {
           List<NestedInteger> nestedIntegers = new ArrayList<>();
           while (null != nestedIntegers) {
                 nestedIntegers.add(nestedInteger);
                 nestedInteger = nestedInteger.nestedInteger;
           }
           return nestedIntegers;
     }*/
}
