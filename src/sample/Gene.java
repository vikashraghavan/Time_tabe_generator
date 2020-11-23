package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static sample.setdet.fdet;
import static sample.setdet.ldet;


public class Gene implements Serializable{

	public int slotno[];
	int days=inputdata.daysperweek;
	int hours=inputdata.hoursperday;
	public ArrayList<Integer> tig=new ArrayList<Integer>();
	public ArrayList<Integer> rnda=new ArrayList<Integer>();
	public ArrayList<Integer> tigs=new ArrayList<Integer>();
	Random r=new Random();
	public List<List<String>> lfdet = new ArrayList<>() ;
	public List<List<String>> lldet = new ArrayList<>() ;
	public static List<String> li = new ArrayList<>();
	ArrayList<Integer> exa=new ArrayList<>();

	Gene(int i){
		lfdet.addAll(fdet);
		lldet.addAll(ldet);
		boolean[] flag=new boolean[days*hours];
		//flag[9]=true;

		li.add("0");
		li.add("5");
		li.add("8");
		li.add("13");
		li.add("16");
		li.add("21");
		li.add("24");
		li.add("29");
		li.add("32");
		li.add("37");
		slotno=new int[days*hours];
		int tmp;


		if (!lfdet.isEmpty()) {

			for (int p = 0; p < lfdet.size(); p++) {

				if (Integer.parseInt(lfdet.get(p).get(0)) == i) {
					if (!lldet.isEmpty()) {
						for (int r = 0; r < lldet.size(); r++) {
							if (lfdet.get(p).get(1).equals(lldet.get(r).get(1))) {
								lldet.remove(r);
								break;
							}
						}
					}
					//System.out.println(Integer.parseInt(lfdet.get(p).get(0)));
					for (int t = days * hours * i; t < (days * hours * (i + 1)); t++) {
						//System.out.println(TimeTable.slot[t].subject);
						if (TimeTable.slot[t].subject.equals(lfdet.get(p).get(1))) {
							tmp = t;
							slotno[Integer.parseInt(lfdet.get(p).get(2))] = tmp;
							//System.out.println("\n\n"+"slot["+Integer.parseInt(lfdet.get(p).get(2))+"]="+slotno[Integer.parseInt(lfdet.get(p).get(2))]+"\n\n");
							tig.add(Integer.parseInt(lfdet.get(p).get(2)));
							tigs.add(tmp);
							lfdet.remove(p);
							break;
						}
					}

				}

			}
		}
		ArrayList<Integer> ex=new ArrayList<Integer>();

		lbl:
		{
			if (!lldet.isEmpty()) {
				try {


					for (int p = 0; p < lldet.size(); p++) {

						if (Integer.parseInt(lldet.get(p).get(0)) == i) {
							//System.out.println(Integer.parseInt(lfdet.get(p).get(0)));
							for (int t = days * hours * i; t < (days * hours * (i + 1)); t++) {

								//	System.out.println(TimeTable.slot[t].subject + " " + lldet.get(p).get(1));

								if (TimeTable.slot[t].subject.equals(lldet.get(p).get(1))) {
									tmp = t;

									Random rand = new Random();
									int rn = generateRandomfra(exa);
									exa.add(rn);
									boolean tca=false;
									for (int h = 0; h < Integer.parseInt(lldet.get(p).get(2)); h++) {

											slotno[rn + h] = tmp+ h;
											ex.add((tmp+h) - (days * hours * i));
											tig.add(rn + h);
											tigs.add(tmp+h);
											//flag[(tmp+h)-(i*hours*days)]=true;
										if(h==2){
											tca=true;
											break ;
										}
									}
									if (tca){
										tmp=tmp+3;
										rn = generateRandomfra(exa);
										exa.add(rn);
										for (int s = 0; s < Integer.parseInt(lldet.get(p).get(2))-3; s++) {
											slotno[rn + s] = tmp + s;
											ex.add((tmp + s) - (days * hours * i));
											tig.add(rn + s);
											tigs.add(tmp + s);
										}
										//h=h+2;
									}
									if(Integer.parseInt(lldet.get(p).get(2))==3) {
										t = t + 2;
									}else{
										t=t+5;
									}
									//System.out.println("\n\n"+"slot["+Integer.parseInt(lfdet.get(p).get(2))+"]="+slotno[Integer.parseInt(lfdet.get(p).get(2))]+"\n\n");
									//tig.add(Integer.parseInt(lfdet.get(p).get(2)));
									lldet.remove(p);
									//System.out.println("nt");
									//break lbl;
								}
							}

						}

					}
				}
				catch (NullPointerException e)
				{
					lldet.clear();
					//System.out.println("jumped");
					break lbl;
				}

			}
		}

		//for(int u=0;u<tig.size();u++) {
		//	System.out.println(tig.get(u));
		//}

		//for(int z=0;z<ex.size();z++){
		//	System.out.println(ex.get(z));
		//}
		for(int j=0;j<(days*hours);j++){
			
			int rnd;
			//while(flag[rnd=r.nextInt(days*hours)]==true){}
			//flag[rnd]=true;
			//rnd=r.nextInt(days*hours);
			//int rnd;
			/*if(!tigs.isEmpty()) {
				for (int f = 0; f < tigs.size(); f++) {
					flag[tigs.get(f)] = true;
					tigs.remove(f);
				}
			}*/


			boolean ti=true;

			///for (int k=0;k<tig.size();k++){
			//	System.out.println(tig.get(k));
			//}
			if (tig.contains(j)){
				tig.remove(Integer.valueOf(j));
				//System.out.println("skp");
				continue;
			}
			//System.out.println("----\n"+j+"\n----");
			rnd=generateRandom(0,40,ex);
			if(ti) {


				ex.add(rnd);
				/*for (int t=0;t<ex.size();t++){
					System.out.println("a "+ex.get(t)+" ");
				}
				System.out.println("-----------");*/

				slotno[j] = i * days * hours + rnd;
				//System.out.println(j);

			}

				//System.out.println("\n\n"+"slot["+j+"]="+ (i * days * hours + rnd)+"\n\n");




				//slotno[j] = i * days * hours + rnd;




				//Slot[] slot=TimeTable.returnSlots();
			 	//if(slot[slotno[j]]!=null)System.out.print(slot[slotno[j]].subject+" ");
			 	//else System.out.print("break ");


		}
		//for (int p=0;p<flag.length;p++){
		//	if(flag[p]==false){
		//		System.out.println(flag[p]);
		//	}
		//}
		ex.clear();
		exa.clear();
		tigs.clear();
		tig.clear();
		rnda.clear();
		lfdet.clear();
		lldet.clear();
	//	System.out.println("exit sg "+i);
		//System.out.println("gn");
	}
	public int generateRandom(int start, int end, ArrayList<Integer> excludeRows) {
		Random rand = new Random();
		int range = (end - start);

		int random = rand.nextInt(range) ;
		//for (int t=0;t<excludeRows.size();t++){
		//	System.out.println(" "+excludeRows.get(t)+" ");
		//}
		//System.out.println("-----------");

		if(excludeRows.isEmpty()){}else {
			while (excludeRows.contains(random)) {
				random = rand.nextInt(range) ;
			}
		}
		return random;
	}
	public static int generateRandomfra( ArrayList<Integer> excludeRows) {
		Random rand = new Random();


		int random = Integer.parseInt(li.get(rand.nextInt(li.size())));
/*for (int t=0;t<excludeRows.size();t++){
			System.out.println(" "+excludeRows.get(t)+" ");
		}
		System.out.println("-----------");*/

		if(excludeRows.isEmpty()){}else {
			while (excludeRows.contains(random)) {
				random = Integer.parseInt(li.get(rand.nextInt(li.size()))); ;
			}
		}
		return random;
	}
	public Gene deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Gene) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}