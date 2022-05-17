#include <iostream>
using namespace std;

// Declare Global Variable
int num = 0;

// Function which returns reference of the variable
int &getNumReference()
{
    return num;
}

int main()
{
    // Using reference of the variable assigning value to it
    getNumReference() = 10;

    cout << "\n\nValue of Number num is: " << num << endl;

    return 0;
}
