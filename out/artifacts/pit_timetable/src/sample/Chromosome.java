package sample;

import java.io.*;
import java.util.*;

import static javafx.application.Platform.exit;
import static sample.SchedulerMain.finalson;

//Chromosome represents array of genes as complete timetable (looks like gene[0]gene[1]gene[2]...)
public class Chromosome implements Comparable<Chromosome>,Serializable{
	
	static double crossoverrate=inputdata.crossoverrate;
	static double mutationrate=inputdata.mutationrate;
	static int hours=inputdata.hoursperday,days=inputdata.daysperweek;
	static int nostgrp=inputdata.nostudentgroup;
	double fitness;
	List<Integer> def= new ArrayList<>();
	int point;
	
	public Gene[] gene;



	Chromosome(){
		
		gene=new Gene[nostgrp];
		
		for(int i=0;i<nostgrp;i++){
			
			gene[i]=new Gene(i);
			
			//System.out.println("");
		}
		fitness=getFitness();
		def=getDef();
		//System.out.println(fitness);
	}
	
	public Chromosome deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Chromosome) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public double getFitness(){
		point=0;



			for (int i = 0; i < hours * days; i++) {

				List<Integer> teacherlist = new ArrayList<>();

				for (int j = 0; j < nostgrp; j++) {


					Slot slot;
					//System.out.println("i="+i+" j="+j);
					if (TimeTable.slot[gene[j].slotno[i]] != null) {
						//slot=TimeTable.slot[gene[j].slotno[i]];
						if (teacherlist.contains(TimeTable.slot[gene[j].slotno[i]].teacherid)) {
							point++;
						} else {
							teacherlist.add(TimeTable.slot[gene[j].slotno[i]].teacherid);
						}
					}

				}


			}

		fitness=1-(point/((nostgrp-1.0)*hours*days));
		point=0;
		return fitness;
	}


	public List<Integer> getDef() {
		def.clear();
		for (int i = 0; i < hours * days; i++) {

			List<Integer> teacherlist = new ArrayList<>();

			for (int j = 0; j < nostgrp; j++) {


				Slot slot;
				//System.out.println("i="+i+" j="+j);
				if (TimeTable.slot[gene[j].slotno[i]] != null) {
					//slot=TimeTable.slot[gene[j].slotno[i]];
					if (teacherlist.contains(TimeTable.slot[gene[j].slotno[i]].teacherid)) {

						def.add(gene[j].slotno[i]);

					} else {
						teacherlist.add(TimeTable.slot[gene[j].slotno[i]].teacherid);
					}
				}

			}


		}

		return def;
	}

	public void mka(){

		double of=getFitness();
		List<Integer> ldef=getDef();
		System.out.println(ldef);
		for (int n=0;n<nostgrp;n++){
			ArrayList<Integer> tex=new ArrayList<>();
			int s,e;
			s=n*hours*days;
			e=((n+1)*hours*days)-1;
			System.out.println(s+" "+e);
			for (int t=s;t<=e;t++){

				if (ldef.contains(t)){
					System.out.println("t="+t);

					for (int j=s;j<=e;j++){
						int ni=findIndex(gene[n].slotno,j);
						int oi=findIndex(gene[n].slotno,t);
						if (TimeTable.slot[gene[n].slotno[ni]]!=null) {
							if (TimeTable.slot[gene[n].slotno[ni]].subject.length() >= 3) {
								if (TimeTable.slot[gene[n].slotno[ni]].subject.substring(TimeTable.slot[gene[n].slotno[ni]].subject.length() - 3).equals("lab")) {
									continue;

								}

							}
						}
						sp(gene[n].slotno,ni,oi);
						//System.out.println("sp "+gene[n].slotno[ni]);
						double lf=getFitness();
						System.out.println("--"+oi);
						/*if (TimeTable.slot[gene[n].slotno[ni]].subject.length()>=3)
						{
							if (TimeTable.slot[gene[n].slotno[ni]].subject.substring(TimeTable.slot[gene[n].slotno[ni]].subject.length()-3).equals("lab")){
								sp(gene[n].slotno,ni,oi);
								mkla(n,t,oi,of);
								continue;

							}

						}*/
						if (lf<=of){
							sp(gene[n].slotno,ni,oi);
							System.out.println("sp "+gene[n].slotno[ni]);
							continue;
						}else{
							of=getFitness();
							System.out.println(getDef());
							if (getDef().contains(t)){
								continue;
							}
							System.out.println(getFitness());
							System.out.println("br");
							break;
						}
					}
				}

			}
			if (n==nostgrp-1&&getFitness()==1.0)

				{
					printChromosome();
				//	printTimeTable();*/

			}else if(n==nostgrp-1&&getFitness()<1.0){
				new sample.SchedulerMain();

			}
		}

		/*double ff=getFitness();
		if(ff==1){
			//double ff=getFitness();
			System.out.println("-----"+ff+"-----");
		}else{
			ldef.clear();
			//mka();
		}*/
	}


	public boolean mkla(int n,int t,int oi,double of){
		ArrayList<Integer> li=new ArrayList<>();
		li.add(0);
		li.add(5);
		li.add(8);
		li.add(13);
		li.add(16);
		li.add(21);
		li.add(24);
		li.add(29);
		li.add(32);
		li.add(37);
		double lf=of;
		int ooi=oi;
		if (li.contains(oi)){
			System.out.println("oi"+oi);
		}else{
			oi=oi-1;
			if (li.contains(oi)){System.out.println("oi"+oi);}
			else {
				oi=oi-1;
			}
		}
		int s=n*hours*days;
		int e=((n+1)*hours*days)-1;
		boolean suc=false;
		for (int r=0;r<nostgrp;r++){
			if(n==r){
				continue;
			}
			for (int a=s;a<=e;a++){
				int ni=findIndex(gene[n].slotno,a);
				if (li.contains(ni)) {
					sp(gene[n].slotno, ni, oi);
					sp(gene[n].slotno, ni+1, oi+1);
					sp(gene[n].slotno, ni+2, oi+2);
					 double lff = getFitness();
					if (lff<=of){
						sp(gene[n].slotno, ni, oi);
						sp(gene[n].slotno, ni+1, oi+1);
						sp(gene[n].slotno, ni+2, oi+2);

						continue;
					}else{
						lf=getFitness();
						System.out.println("success");
						break;
					}
				}
			}
			if (r==nostgrp-1&&lf<=of){
				System.out.println("failed");
				java.lang.System.exit(0);
			}
		}

		return suc;
	}

	/*boolean ts=false;
				ArrayList<Integer> tex=new ArrayList<>();
				if(ldef.contains(t)){
					System.out.println("def slot "+t+" start/end "+s+" "+e);
					tex.add(t-s);
					lb:
					{
						//System.out.println(s+" "+e);
						int rd = generateRandom(s, e, tex);
						System.out.println("rnd "+rd);
						int os = findIndex(gene[n].slotno, rd);
						int ds = findIndex(gene[n].slotno, t);
						System.out.println("old "+os+" def "+ds);
						//System.out.println(os+" "+ds+" "+rd+" "+n);
						for (int u = 0; u < nostgrp; u++) {
							System.out.println("checking "+u);
							if (u==n){
								continue ;
							}
							if(TimeTable.slot[rd]==null){
								if (TimeTable.slot[gene[u].slotno[os]]==null){
									ts=true;
								}else if(TimeTable.slot[gene[u].slotno[os]].teacherid != TimeTable.slot[t].teacherid){
									ts=true;
								}else{
									ts=false;
									tex.add(rd-s);
									u=-1;
									System.out.println(tex);
									if(tex.size()==40){
										System.out.println(ldef);
										System.out.println(t);
										printChromosome();
										printTimeTable();
										return;
									}
									rd=generateRandom(s, e, tex);
									System.out.println(tex);
									continue ;
								}
							}else if(TimeTable.slot[gene[u].slotno[os]]==null){
								if (TimeTable.slot[gene[u].slotno[ds]]==null){
									ts=true;
								}else if (TimeTable.slot[gene[u].slotno[ds]].teacherid != TimeTable.slot[rd].teacherid){
									ts=true;
								}else{
									System.out.println(TimeTable.slot[gene[u].slotno[ds]].teacherid +" "+TimeTable.slot[ds].teacherid);
									ts=false;
									tex.add(rd-s);
									u=-1;
									System.out.println(tex);
									if(tex.size()==40){
										System.out.println(ldef);
										System.out.println(t);
										printChromosome();
										printTimeTable();
										return;
									}
									rd=generateRandom(s, e, tex);
									System.out.println(tex);
									continue ;
								}
							}else if (TimeTable.slot[gene[u].slotno[ds]]==null){
								if (TimeTable.slot[gene[u].slotno[os]].teacherid != TimeTable.slot[t].teacherid){
									ts=true;
								}else {
									ts=false;
									tex.add(rd-s);
									u=-1;
									System.out.println(tex);
									if(tex.size()==40){
										System.out.println(ldef);
										System.out.println(t);
										printChromosome();
										printTimeTable();
										return;
									}
									rd=generateRandom(s, e, tex);
									System.out.println(tex);
									continue ;
								}
							}else if (TimeTable.slot[gene[u].slotno[os]].teacherid != TimeTable.slot[t].teacherid&& TimeTable.slot[gene[u].slotno[ds]].teacherid != TimeTable.slot[rd].teacherid) {
								ts=true;
							} else {
								System.out.println(TimeTable.slot[gene[u].slotno[ds]].teacherid +" "+TimeTable.slot[ds].teacherid);
								ts=false;
								tex.add(rd-s);
								u=-1;
								System.out.println(tex);
								if(tex.size()==40){
									System.out.println(ldef);
									System.out.println(t);
									printChromosome();
									printTimeTable();
									return;
								}
								rd=generateRandom(s, e, tex);
								System.out.println(tex);
								continue ;
							}
							System.out.println("ts "+ts);
						}
						if (ts){
							System.out.println("swaped");
							sp(gene[n].slotno,os,ds);
							ldef.remove(Integer.valueOf(t));

						}
					}

				}
				tex.clear();*/


	public void sp(int arr[], int a, int b){
		int tmp;
		tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}

	public static int findIndex(int arr[], int t)
	{

		// if array is Null
		if (arr == null) {
			return -1;
		}

		// find length of array
		int len = arr.length;
		int i = 0;

		// traverse in the array
		while (i < len) {

			// if the i-th element is t
			// then return the index
			if (arr[i] == t) {
				return i;
			}
			else {
				i = i + 1;
			}
		}
		return -1;
	}

	public int generateRandom(int start, int end, ArrayList<Integer> excludeRows) {
		Random rand = new Random();
		int range = (end - start)+1;

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
		return random+start;
	}

	//printing final timetable
	public void printTimeTable(){
		
		//for each student group separate time table
		for(int i=0;i<nostgrp;i++){
			
			//status used to get name of student grp because in case first class is free it will throw error
			boolean status=false;
			int l=0;
			while(!status){
				
				//printing name of batch
				if(TimeTable.slot[gene[i].slotno[l]]!=null){
					System.out.println("Batch "+TimeTable.slot[gene[i].slotno[l]].studentgroup.name+" Timetable-");
					
					status=true;
				}
				l++;
			
			}
			
			//looping for each day
			for(int j=0;j<days;j++){
				
				//looping for each hour of the day
				for(int k=0;k<hours;k++){
				
					//checking if this slot is free otherwise printing it
					if(TimeTable.slot[gene[i].slotno[k+j*hours]]!=null)
						
						System.out.print(TimeTable.slot[gene[i].slotno[k+j*hours]].teacherid+"   "+TimeTable.slot[gene[i].slotno[k+j*hours]].subject+"            ");
				
					else System.out.print("     *FREE*            ");
				
				}
				
				System.out.println("");
			}
			
			System.out.println("\n\n\n");
		
		}

	}
	
	
	
	public void printChromosome(){
		
		for(int i=0;i<nostgrp;i++){
			for(int j=0;j<hours*days;j++){
				System.out.print(gene[i].slotno[j]+" ");
			}
			System.out.println("");
		}
		
	}



	public int compareTo(Chromosome c) {
		
		if(fitness==c.fitness) return 0;
		else if(fitness>c.fitness) return -1;
		else return 1;
	
	}
	
	
	
}

//new sample.SchedulerMain();
								/*ArrayList<Integer> li=new ArrayList<>();
								li.add(0);
								li.add(5);
								li.add(8);
								li.add(13);
								li.add(16);
								li.add(21);
								li.add(24);
								li.add(29);
								li.add(32);
								li.add(37);
								sp(gene[n].slotno,ni,oi);
								if(li.contains(oi)){
								}else {
									oi=oi-1;
									if(li.contains(oi)){}else {
										oi=oi-1;
										if (li.contains(oi)){}
									}
								}
								if (li.contains(ni)) {
									System.out.println(ni);
									System.out.println(oi);
									sp(gene[n].slotno, ni, oi);
									sp(gene[n].slotno, ni + 1, oi + 1);
									sp(gene[n].slotno, ni + 2, oi + 2);
									lf = getFitness();
									if (lf <= of) {
										sp(gene[n].slotno, ni, oi);
										sp(gene[n].slotno, ni + 1, oi + 1);
										sp(gene[n].slotno, ni + 2, oi + 2);
										System.out.println("sp " + gene[n].slotno[ni]);
										continue;
									} else {
										of = getFitness();
										System.out.println(getDef());

										System.out.println(getFitness());
										System.out.println("br");
										break;
									}
								}
								*//*if(oi==0){
								}else if (TimeTable.slot[gene[n].slotno[oi-1]]==null){
								}else if (TimeTable.slot[gene[n].slotno[oi-1]].subject.length()<=3){
								}else if (TimeTable.slot[gene[n].slotno[oi-1]].subject.substring(TimeTable.slot[gene[n].slotno[oi-1]].subject.length()-3).equals("lab")){
									oi=oi-1;
									if(oi==0){
									}else if (TimeTable.slot[gene[n].slotno[oi-1]]==null){
									}else if (TimeTable.slot[gene[n].slotno[oi-1]].subject.length()<=3){
									}else if (TimeTable.slot[gene[n].slotno[oi-1]].subject.substring(TimeTable.slot[gene[n].slotno[oi-1]].subject.length()-3).equals("lab")){
										oi=oi-1;
									}
								}
								if (li.contains(ni)){
									System.out.println(ni);
									System.out.println(oi);
									sp(gene[n].slotno,ni,oi);
									sp(gene[n].slotno,ni+1,oi+1);
									sp(gene[n].slotno,ni+2,oi+2);
									lf=getFitness();
									if (lf<=of){
										sp(gene[n].slotno,ni,oi);
										sp(gene[n].slotno,ni+1,oi+1);
										sp(gene[n].slotno,ni+2,oi+2);
										System.out.println("sp "+gene[n].slotno[ni]);
										continue;
									}else{
										of=getFitness();
										System.out.println(getDef());
										if (getDef().contains(t)){
											continue;
										}
										System.out.println(getFitness());
										System.out.println("br");
										break;
									}
								}*/
//li.clear();