#include <iostream>

using namespace std;

int sub(int a, int b) {
    return a - b;
}

int main() {
    int a = 5, b = 3, result;
    result = sub(a, b);
    cout << result;
    return 0;
}
