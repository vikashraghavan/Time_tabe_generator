package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sample.*;

public class setdet {
    public static int k=0;

    static public int nocl;
    static public List<String> studentgroup = new ArrayList<>() ;
    static public List<List<String>> fdet = new ArrayList<>() ;
    static public List<List<String>> ldet = new ArrayList<>() ;
    static public List<String> nosubject = new ArrayList<>() ;
    static public List<String> stgrpsubject = new ArrayList<>() ;
    static public List<String> subjecttime = new ArrayList<>() ;
    // nosubject, stgrpsubject, subjecttime;
    static public List<String> teacher = new ArrayList<>() ;
    static public List<ArrayList<String>> teachersubject = new ArrayList<>() ;
    static public List<ArrayList<String>> tcls = new ArrayList<>() ;
    static public List<ArrayList<String>> tsubcnt = new ArrayList<>() ;

    //static public List<String> teacher, teachersubject;
    static public String hoursperday, daysperweek="5";
    int cumusubcount = 0;

    public void mf(){

      //  new inputdata().takeinput();


        new SchedulerMain();


        Chromosome finalson =SchedulerMain.finalson;


    }

    public void putdata() {

        //for(int i=0;i<fdet.size();i++){
        //    for (int j=0;j<fdet.get(i).size();j++){
        //        System.out.println(fdet.get(i).get(j));
        //    }
        //}

        /*for(int u=0;u<stgrpsubject.size();u++){
            if(stgrpsubject.get(u).length()>=3) {
                if (stgrpsubject.get(u).substring(stgrpsubject.get(u).length() - 3).equals("lab")) {
                    if (Integer.parseInt(subjecttime.get(u))==6){
                        stgrpsubject
                    }
                }
            }
        }*/
        inputdata id = new inputdata();

        inputdata.daysperweek = Integer.parseInt(daysperweek);
        inputdata.hoursperday = Integer.parseInt(hoursperday);

        //tcls.get(0)[2]="ncls";
        System.out.println("");
        studentgroup.add(tcls.get(0).get(0));
        for (int p=0;p<teacher.size();p++){
            for (int l=0;l<tcls.get(p).size();l++) {
                boolean b=false;
                for (int y = 0; y < studentgroup.size(); y++) {
                    //System.out.println(studentgroup.get(y)+" "+tcls.get(p)[l]);
                    if (studentgroup.get(y).equals(tcls.get(p).get(l))){
                        b=true;/*System.out.println("breaked");*/break;}else{b=false;}


                }
                if (!b){
                    studentgroup.add(tcls.get(p).get(l));}
            }
        }

       // for (int u=0;u<studentgroup.size();u++){
       //     System.out.println(studentgroup.get(u));
        //}
        inputdata.nostudentgroup = studentgroup.size();
        //stgrpsubject.add(teachersubject.get(0)[0]);
        for (int r=0;r<studentgroup.size();r++){
            int sc=0;
            for(int e=0;e<tcls.size();e++){
                for (int f=0;f<tcls.get(e).size();f++) {
                  //  System.out.println(studentgroup.get(r)+" "+tcls.get(e)[f]);
                    if (studentgroup.get(r).equalsIgnoreCase(tcls.get(e).get(f))){
                        //for (int m=0;m<)
                        if(teachersubject.get(e).get(f)!=null) {
                           // System.out.println("added");
                           // System.out.println(teachersubject.get(e)[f]);
                            stgrpsubject.add(teachersubject.get(e).get(f));
                            subjecttime.add(tsubcnt.get(e).get(f));
                            sc++;
                        }
                    }
                }
            }
            nosubject.add(Integer.toString(sc));
        }
       // for (int u=0;u<stgrpsubject.size();u++){
           // if(stgrpsubject.get(u)==" "){stgrpsubject.remove(u);}
        //    System.out.println(stgrpsubject.get(u));
       // }
       // for (int u=0;u<subjecttime.size();u++){
            // if(stgrpsubject.get(u)==" "){stgrpsubject.remove(u);}
         //   System.out.println(subjecttime.get(u));
       // }
        /*for(int p=0;p<teacher.size();p++){
            if(studentgroup.isEmpty()){
                for (int g=0;g<tcls.get(p).length;g++) {
                    studentgroup.add(tcls.get(p)[g]);
                    break;
                }
            }
            for (int g=0;g<tcls.get(p).length;g++) {
                for (int t=0;t<studentgroup.size();t++) {
                    if(studentgroup.get(0).equalsIgnoreCase(tcls.get(p)[g])){continue;}
                    studentgroup.add(tcls.get(p)[g]);
                }
            }
        }
*/
        for (int i = 0; i < studentgroup.size(); i++) {

            inputdata.studentgroup[i] = new StudentGroup();
            StudentGroup temp = inputdata.studentgroup[i];

            temp.setId(i);
            temp.setName(studentgroup.get(i));
            temp.setNosubject(nosubject.get(i));
            ArrayList<String> tas=new ArrayList<>();
            ArrayList<Integer> tah=new ArrayList<>();
            int nosub = Integer.parseInt(nosubject.get(i));


            ArrayList<String> sub =new ArrayList<>();
            ArrayList<Integer> hrs =new ArrayList<>();

            for (int j = 0; j < nosub; j++) {

                sub.add(stgrpsubject.get(cumusubcount)) ;
                hrs.add(Integer.parseInt(subjecttime.get(cumusubcount)));

                if(sub.get(j).length()>=3){
                    if(sub.get(j).substring(sub.get(j).length()-3).equals("lab")){
                        System.out.println(sub.get(j));
                        ldet.add(new ArrayList<>());
                       // System.out.println(ldet.get(i));
                        ldet.get((ldet.size()-1)).add(Integer.toString(i));
                        //fdet.get(i).add(t.day.get());
                        ldet.get((ldet.size()-1)).add(sub.get(j));
                        ldet.get((ldet.size()-1)).add(Integer.toString(Integer.parseInt(subjecttime.get(cumusubcount))));
                    }
                }






                cumusubcount++;
            }

            temp.setSubject(sub);
            temp.setHours(hrs);

        }

        inputdata.noteacher = teacher.size();
        for (int i = 0; i < teacher.size(); i++) {

            inputdata.teacher[i] = new Teacher();
            Teacher tmp = inputdata.teacher[i];
            //String[] la=new String[teachersubject.get(i).size()];
            tmp.setId(i);
            //int t=i;
            tmp.setName(teacher.get(i));
            //for (int t=0;t<teachersubject.get(i).size();t++) {

            //    la[t]=teachersubject.get(i).get(t);
            //}
            tmp.setSubject(teachersubject.get(i));
            tmp.setCn(tcls.get(i));
            tmp.setSubc(tsubcnt.get(i));
            /*if (i!=teacher.size()-1) {
                while (teacher.get(i).equals(teacher.get(i + 1))) {
                    inputdata.teacher[i+1] = new Teacher();
                    Teacher tp = inputdata.teacher[i+1];
                    tp.setId(t);
                    tp.setName(teacher.get(t));
                    tp.setSubject(teachersubject.get(i + 1));
                    i++;
                    if(i==teacher.size()-1){
                        break;
                    }
                }
            }*/
        }

        for (int q=0;q<ldet.size();q++){
            for (int r=0;r<ldet.get(q).size();r++){
                System.out.println(ldet.get(q).get(r));
            }
        }
        id.assignTeacher();

        new sample.SchedulerMain();

        //Chromosome finalson = scheduler.SchedulerMain.finalson;
       // getServletRequest().setAttribute("son", finalson);
       // return SUCCESS;
    }

}
