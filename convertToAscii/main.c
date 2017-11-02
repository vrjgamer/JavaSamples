#include <stdio.h>
#include <string.h>

int main()
{
    char *a;
    int c = 0,i = 0;

    gets(a);

    while(a[i] != '\0'){
        printf("%d-", a[i]);
        i++;
    }

    return 0;

}
