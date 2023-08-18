package pro.sky.collections;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
         List<String> employeeList = List.of(
                " иванов Иван",
                "Петров Петр",
                "Семенов Семен",
                "Степанов Степан",
                "Константинов константин",
                "иванов Константин",
                "петров Степан",
                "Семенов Петр",
                "Степанов Иван",
                "Константинов Семен");
        System.out.println(WordUtils.capitalizeFully(employeeList.toString()));
    }
}
