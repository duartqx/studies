package duartqx.com.github.viacep;

import com.google.gson.JsonSyntaxException;
import duartqx.com.github.viacep.exceptions.InvalidCepException;
import duartqx.com.github.viacep.records.ViaCepRecord;
import duartqx.com.github.viacep.service.ViaCepService;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cep;
        String action = "";
        Scanner scanner = new Scanner(System.in);
        ViaCepService<ViaCepRecord> service =
            new ViaCepService<ViaCepRecord>(ViaCepRecord.class);

        while (true) {

            System.out.print("What you want to do? (s) Search by CEP / (q) Quit ");
            action = scanner.next();

            if (action.equalsIgnoreCase("q")) {
                break;
            }

            if (action.equalsIgnoreCase("s")) {

                System.out.print("Please give me the CEP you want to search: ");
                cep = scanner.next();

                if (cep.strip().length() > 4) {
                    try {
                        System.out.println(service.getSingle(cep.strip()));
                    } catch (InvalidCepException e) {
                        System.out.println("The cep you've said is invalid");
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Something probably went wrong");
                        break;
                    } catch (JsonSyntaxException e) {
                        System.out.println(
                            "Looks like the api is experiencing some problems"
                        );
                    }
                }
            }
        }
        System.out.println("Finishing up");
    }
}