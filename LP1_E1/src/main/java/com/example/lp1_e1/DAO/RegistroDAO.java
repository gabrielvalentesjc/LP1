package com.example.lp1_e1.DAO;

import com.example.lp1_e1.Model.Registravel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroDAO {

    public void salvar(Registravel registro) throws IOException {
        String filename = "registro" + registro.getClass().getSimpleName() + ".csv";
        File file = new File(filename);
        boolean writeHeader = !file.exists() || file.length() == 0;

        try (FileWriter writer = new FileWriter(file, true)) {
            if (writeHeader) {
                writer.append(registro.getCsvHeader() + "\n");
            }
            String linhaCompleta = registro.toCsvRow() + "\n";
            writer.append(linhaCompleta);
            System.out.println("Salvo com sucesso em " + filename + ": " + linhaCompleta.trim());
        }
    }
}
