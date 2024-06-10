#include <iostream>
using namespace std;

int main() {
    string str;
    cout << "Olá! Qual seu nome? ";
    getline(cin, str);
    cout << "Olá, " << str << "! Qual sua cor favorita? ";
    getline(cin, str);
    cout << "Que legal! Também gosto muito de " << str << "!\n";
    return 0;
}
