#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[10] = {1,2,3,4,5,6,7,8,9,0};
    printf("%d",peakFinder(a,10,0));

    return 0;
}

int peakFinder(int *x,int uplimit,int downlimit){

    if(x[uplimit/2]< x[uplimit/2 - 1]){
        peakFinder(x,uplimit/2 - 1,downlimit);
    }else if(x[uplimit/2] < x[uplimit/2 + 1]){
        peakFinder(x,uplimit,uplimit/2+1);
    }else {
        return x[uplimit/2];
    }
    return 0;
}
