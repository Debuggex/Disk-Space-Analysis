package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public int FindMax(int x, List<Integer> space){

        int temp=0;
        int [] segments=new int[x];
        List<Integer>AllMinValues=new ArrayList<>();
        for (int i = 0; i < space.size()-x; i+=x) {

            //Making small segments based on value of "x"
            for (int j = 0; j < segments.length; j++) {
                segments[j]=space.get(j+i);
            }

            //sorting the segment values to get minimum in the list
            for (int j = 0; j < segments.length; j++) {
                for (int k = 0; k < segments.length-1; k++) {
                    if (segments[j]>segments[j+1]){
                        temp=segments[j];
                        segments[j]=segments[j+1];
                        segments[j+1]=temp;
                    }
                }

            }
            //Putting min value in current segment in new array.
            AllMinValues.add(segments[0]);
        }

        //Sorting all Min Values to get maximum value in the List

        for (int i = 0; i < AllMinValues.size(); i++) {
            for (int j = 0; j < AllMinValues.size()-1; j++) {
                if(AllMinValues.get(j)>AllMinValues.get(j+1)){
                    temp=AllMinValues.get(j);
                    AllMinValues.set(j,AllMinValues.get(j+1));
                    AllMinValues.set(j+1,temp);
                }
            }
        }

        //Getting maxium value in Minum values List
        int ans=AllMinValues.get(AllMinValues.size()-1);

        //Returning Maximum Value.
        return ans;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
