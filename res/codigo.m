#import <Foundation.h>

int main(int argc, const char argv[]) {

        NSString *figura = @"Triangulo";
        metodo();
        NSLog(@"%@", figura);

        int base = 15

        int altura = 20;

        float area ;

        int codigoColor = 0;

        NSString *color;

        if (area < 120) {

            NSLog(3);

        } else {

            NSLog(555);

        }

        while (area / 2 > 0 && true) {

            if (area / 2 > 15 && area / 2 < 30) {

                area++;

                codigoColor = 1;

            } else if (area / 2 > 1 && area / 2 < 15) {

                area--;

                codigoColor = 2;

            } else if (area / 2 > 30 && area / 2 < 45) {

                area -= 2;

                codigoColor = 3;

            }

        }

        switch (codigoColor) {

            case 1:

                color = @"Rojo";

                break;

            case 2:

                color = @"Azul";

                break;

            case 3:

                color = @"Verde";

                break;

            default:

                color = @"Negro";

                break;

        }

        NSLog(@"La figura es un %@, y su color definido es %@", figura, color);

    //}

    return 0;

} 