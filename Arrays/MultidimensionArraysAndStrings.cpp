#include <iostream>
using namespace std;

void displayMapping(string projectMapping[][2]);

int noOfProjects;

int main()
{
    cout << "\n\nStarting the application...\n\n";

    cout << "Enter the no. of projects in the company" << endl;
    cin >> noOfProjects;
    cin.ignore();

    // Create mapping of project and it's Manager
    string projectMapping[noOfProjects][2];

    for (int i = 0; i < noOfProjects; i++)
    {
        cout << "\nEnter the name of Project: " << endl;
        getline(cin, projectMapping[i][0]);

        cout << "Who is managing the project " << projectMapping[1][0] << ": " << endl;
        getline(cin, projectMapping[i][1]);
    }

    displayMapping(projectMapping);
    return 0;
}

void displayMapping(string projectMapping[][2])
{
    cout << "\n\nFollowing mapping of Project and it's Manager successfully registered: " << endl;

    for (int i = 0; i < noOfProjects; i++)
    {
        cout << "\n Project: " << projectMapping[i][0] << "  Manager: " << projectMapping[i][1] << endl;
    }
}
