package sample;


public class TimeTable {

	public static Slot[] slot;

	TimeTable() {

		int k = 0;
		int subjectno = 0;
		int hourcount = 1;
		int days = inputdata.daysperweek;
		int hours = inputdata.hoursperday;
		int nostgrp = inputdata.nostudentgroup;

		//System.out.println("\n\nno of slots\n\n"+hours * days * nostgrp);



		slot = new Slot[hours * days * nostgrp];


		for (int i = 0; i < nostgrp; i++) {
			//System.out.println(hours * days * nostgrp);

			subjectno = 0;

			for (int j = 0; j < hours * days; j++) {

				StudentGroup sg = inputdata.studentgroup[i];



				if (subjectno >= sg.nosubject) {
					slot[k++] = null;
				}


				else {

					slot[k++] = new Slot(sg, sg.teacherid[subjectno], sg.subject.get(subjectno));


					if (hourcount < sg.hours.get(subjectno)) {
						hourcount++;
					} else {
						hourcount = 1;
						subjectno++;
					}

				}

			}

		}

	}

	public static Slot[] returnSlots() {
		return slot;
	}
}