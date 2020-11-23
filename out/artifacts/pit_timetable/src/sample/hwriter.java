package sample;

import java.io.*;

import static sample.Chromosome.*;

public class hwriter {

    public static void mprint() {
        String pt = null;
        try {
            pt = new File(".").getCanonicalPath();
            // pt.replace("\","\\")
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = new File(pt+"\\tst.html");
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(f));
            b.write("<html><head><style>\n" +
                    "table, th, td {\n" +
                    "  border: 1px solid ;\n" +
                    "}\n" +
                    "</style></head><body>");
            for (int i = 0; i < nostgrp; i++) {

                //status used to get name of student grp because in case first class is free it will throw error
                boolean status = false;
                int l = 0;
                while (!status) {

                    //printing name of batch
                    if (TimeTable.slot[SchedulerMain.finalson.gene[i].slotno[l]] != null) {
                        b.write("Batch " + TimeTable.slot[SchedulerMain.finalson.gene[i].slotno[l]].studentgroup.name + " Timetable-<br><br>");

                        status = true;
                    }
                    l++;

                }
                b.write("<table>");
                //looping for each day
                for (int j = 0; j < days; j++) {
                    b.write("<tr>");

                    //looping for each hour of the day
                    for (int k = 0; k < hours; k++) {

                        //checking if this slot is free otherwise printing it
                        if (TimeTable.slot[SchedulerMain.finalson.gene[i].slotno[k + j * hours]] != null)

                            b.write("<td>" + TimeTable.slot[SchedulerMain.finalson.gene[i].slotno[k + j * hours]].subject + "</td>");

                        else b.write("<td>free</td>");

                    }

                    b.write("</tr>");
                }
                b.write("</table>");
                b.write("<br><br><br>");

            }
            b.write("<script>\n" +
                    "function myFunction() {\n" +
                    "  window.print();\n" +
                    "}\n" +
                    "</script></body></html>");
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
