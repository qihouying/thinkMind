package com.qhy.practice_01.zigZag;

/**
 * Created by dream on 2017/10/8.
 */
public class BestSolution {
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
        String re="";
        for(int i=0;i<sb.length;i++){
            re+=sb[i];
        }
        return re.toString();
    }

    public static void main(String[] args) {
        String str = "AB";
        BestSolution bestSolution = new BestSolution();
        System.out.println(bestSolution.convert(str, 1));
    }
}
