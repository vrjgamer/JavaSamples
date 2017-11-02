#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE *pFile;
    int frequency = 0, i =0;
    char *current, *check, *fileAddress;

    printf("Enter Address of the file with file extension :\t ");
    scanf("%s",fileAddress);

    pFile = fopen(fileAddress,"w");

    printf("Enter String To Count Occurrence of :\t");
    scanf("%s",check);

    do{
        fscanf(pFile,"%s",current);
        if(strcmp(check,current)==0){
            frequency++;
        }
    }while(current != EOF);

    fclose(pFile);

    return 0;
}
