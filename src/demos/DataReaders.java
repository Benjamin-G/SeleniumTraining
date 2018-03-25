package demos;

import utilities.Excel;

import java.util.List;

public class DataReaders {
    public static void main(String[] args) { readXLS(); }

    public static void readCSV() {
        String filename;
        List <String[]> records;

        filename = "C:\\Users\\brgey\\SDET\\UserAccounts.csv";
        records = utilities.CSV.get(filename);

        for (String[] record : records) {
            for (String field : record) System.out.println(field);
        }
    }

    public static void readXLS() {
        String filename;
        String[][] data;

        filename = "C:\\Users\\brgey\\SDET\\UserLogin.xls";
        for (String[] record : data = Excel.get(filename)) {
            System.out.println("\nNEW RECORD");
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
        ;

    }
}
