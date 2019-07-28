#include<iostream>
#include<string>
#include<cstdio>
#include<cstdlib>
using namespace std;

class Bank
{
	public:
    int bank_id;
	String name;
	String address;
	static int count = 0;
    Bank *next;
	
	Bank(String name, String address)
	{
		this.id = ++count;
		this.name = name;
		this.address = address;
	}
	
}*start;

class bank
{
    public:
        void insert();
        void search();
        void display();
        bank() 
        {
            start = NULL;
        }
};
 
main()
{
    int choice, nodes, element, position, i;
    bank sl;
    start = NULL;
    while (1)
    {
		cout<<"Enter choice : "<<endl;
        cout<<"1.Insert Node"<<endl;
        cout<<"2.Search Element"<<endl;
        cout<<"3.Display Linked List"<<endl;
        cout<<"4.Exit "<<endl;
        cout<<"Enter your choice : ";
        cin>>choice;
        switch(choice)
        {
        case 1:
            cout<<"Inserting Node :"<<endl;
            sl.insert();
            cout<<endl;
            break;
        case 2:
            cout<<"Search element in Link List: "<<endl;
            sl.search();
            cout<<endl;
            break;
        case 3:
            cout<<"Display elements of link list"<<endl;
            sl.display();
            cout<<endl;
            break;
        case 4:
            exit(1);
            break;  
        default:
            cout<<"Wrong choice"<<endl;
        }
    }
}
 

void bank::insert()
{
	String name, address ;
    cout<<"Enter name: ";
    cin>>name;
	cout<<"Enter address: ";
    cin>>address;
	Bank b = new Bank(name, address);
    Bank *temp, *s;
    temp = b;
    s = start;
    while (s->next != NULL)
    {         
        s = s->next;        
    }
    temp->next = NULL;
    s->next = temp;
    cout<<"Element Inserted at last"<<endl;  
}

void bank::search()
{
    int value, pos = 0;
    bool flag = false;
    if (start == NULL)
    {
        cout<<"List is empty"<<endl;
        return;
    }
    cout<<"Enter the value to be searched: ";
    cin>>value;
    Bank *s;
    s = start;
    while (s != NULL)
    {
        pos++;
        if (s->info == value)
        {
            flag = true;
            cout<<"Data is found at position "<<pos<<endl;
        }
        s = s->next;
    }
    if (!flag)
        cout<<"Data not found in the list"<<endl;  
}
 

void bank::display()
{
    Bank *temp;
    if (start == NULL)
    {
        cout<<"The List is Empty"<<endl;
        return;
    }
    temp = start;
    cout<<"Elements of list are: "<<endl;
    while (temp != NULL)
    {
        cout<<"id : "<<temp->id<<endl;
		cout<<"name : "<<temp->name<<endl;
		cout<<"address : "<<temp->address<<endl;
        temp = temp->next;
    }
    
}
