#include <stdio.h>
#include<stdlib.h>
struct node {
    int data;
    struct node* next; //self Referencing
};

struct node* createLinkedList(int firstnode){
    struct  node* mList;
    mList->data = firstnode;
    mList->next = NULL;
    return mList;
}

void printList(struct node* mList){
     struct node* currentnode = mList;
     while(currentnode != NULL){
        printf("%d\n",currentnode->data);
        currentnode = currentnode->next;
     }
}

void insertElementInList(struct node* mList, int insert){
    struct node* temp;
    temp->data = insert;
    temp->next = mList;
    mList = temp;
}

void searchElementInList(struct node* mList, int search){
    struct node* temp;
    int position = 0;
    temp = mList;
    while(temp != NULL){
        if(temp->data == search){
            printf("The Value %d Exists in the List at %d",search,position);
            return;
        }else{
            temp = temp->next;
        }
        position++;
    }
    printf("The value was not found in the list");
    return;
}


void deleteElementInList(struct node* mList,int value){
    struct node* temp;
    temp = mList;

    while(temp != NULL){
        if(temp->next->data == value){
            temp->next = temp->next->next;
            temp = NULL;
            return;
        }else{
            temp = temp->next;
        }
    }
    printf("The value was not found in the list");

    return;
}




int main()
{
    struct node* mList = NULL;
    int choice,e = 0;
    printf("LinkedList Program:\nOperations\n");

    while(e != 1){
    printf("\t1. Create List\n\t2. InsertElement\n\t3. DeleteElement\n\t4. SearchElement\n\t5. Exit\nPlease Enter Your Choice:\t");
    scanf("%d",&choice);
    switch(choice){
        case 1:{
            int val;
            printf("Enter value:\t");
            scanf("%d",&val);
            mList = createLinkedList(val);
            printList(mList);
            break;
        }
        case 2:{
            int insertVal = 0;
            printf("Enter value to Insert:\t");
            scanf("%d",&insertVal);
            insertElementInList(mList,insertVal);
            printList(mList);
            break;
        }
        case 3:{
            int deleteVal = 0;
            printf("Enter to Delete:\t");
            scanf("%d",&deleteVal);
            deleteElementInList(mList,deleteVal);
            printList(mList);
            break;
        }
        case 4:{
            int searchVal =0;
            printf("Enter Value to be Searched:\t");
            scanf("%d",&searchVal);
            searchElementInList(mList,searchVal);
            printList(mList);
            break;
        }
        case 5:{
            e = 1;
        }
        default:printf("Case Not Available!!");
        }
    }
    return 0;
}
