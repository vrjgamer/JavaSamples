#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[20][20];
    return 0;
}


int findPeakHill(int **x,int columns_uplimit,int column_lowerlimit,int rows){

    int i =0 , k,j=columns_uplimit/2 , max = x[0][j];

    // finding global maximum in the column.
    for(k =0; k< rows; ++k ){
        if(max < x[k][j]){
            max = x[k][j];
            i=k;
        }
    }

    //getting peak point.
    if(x[i][j] < x[i][j-1]){
        findPeakHill(x,j-1,column_lowerlimit,rows);
    }else if(x[i][j]< x[i][j+1]){
        findPeakHill(x,columns_uplimit,j+1,rows);
    }else {
        return x[i][j];
    }
    return 0;
}
