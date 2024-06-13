#include <array>
#include <iostream>
#include <string>
using namespace std;

int main() {
    array<string, 6> positions { "First", "Second", "Third", "Forth", "Fifth" };

    for (int i = 0; i < positions.size(); i++) {
        cout << positions[i] << "\n";
    }

    for (string p : positions) {
        cout << p << "\n";
    }

    return 0;
}
