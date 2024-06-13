#include <iostream>
using namespace std;

namespace foo {
    namespace bar {

        auto baz() {
            return [](string a) {
                cout << "inner\n" << a << "\n";
            };
        }
    }
}

int main() {
    auto baz = foo::bar::baz();
    baz("teste");
    return 0;
}
