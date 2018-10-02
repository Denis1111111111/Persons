import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HashTest 
{
	Person [] pp = new Person[10];
	HashTable ht = new HashTable();
	
	

	//========================
	//	init
	//========================
	@Test
	public void init_1() 
	{
		Person init = new Person(12,"dima","jora",25);
		pp[0] = init;
		int hash = ht.hashfunction(pp[0]);
		ht.init(pp);
		int res = ht.get(12,hash).age;
		assertEquals(25, res);
	}


	@Test
	public void init_2() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(1,"bora","bora",50);


		int hash = ht.hashfunction(init);
		int hash2 = ht.hashfunction(init2);

		pp[0] = init;
		pp[1] = init2;

		ht.init(pp);

		int res = ht.get(12,hash).age;
		assertEquals(25, res);

		int res2 = ht.get(1,hash2).age;
		assertEquals(50, res2);
	}

	@Test ( expected = IllegalArgumentException.class)
	public void init_one_Id() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(12,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;
		ht.init(pp);
	}

	@Test
	public void init_many() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);
		Person init3 = new Person(22,"dima","jora",25);
		Person init4 = new Person(32,"bora","bora",50);
		Person init5 = new Person(42,"dima","jora",25);
		Person init6 = new Person(172,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;
		pp[3] = init3;
		pp[4] = init4;
		pp[5] = init5;
		pp[6] = init6;

		ht.init(pp);
		int res = ht.size();
		assertEquals(6, res);
	}

	@Test ( expected = IllegalArgumentException.class)
	public void init_nulll() 
	{
		Person[]pp2 = {};
		ht.init(pp2);
	}

	@Test 
	public void init_nol() 
	{
		for(int i=0;i<pp.length;i++)
		{
			pp[i] = null;
		}
		ht.init(pp);
		assertEquals(0,ht.size);
	}

	//========================
	//	size
	//========================
	@Test
	public void size_many() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);
		Person init3 = new Person(22,"dima","jora",25);
		Person init4 = new Person(32,"bora","bora",50);
		Person init5 = new Person(42,"dima","jora",25);
		Person init6 = new Person(172,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;
		pp[3] = init3;
		pp[4] = init4;
		pp[5] = init5;
		pp[6] = init6;

		ht.init(pp);
		int res = ht.size();
		assertEquals(6, res);
	}

	@Test
	public void size_1() 
	{
		Person init = new Person(12,"dima","jora",25);


		pp[0] = init;


		ht.init(pp);
		int res = ht.size();
		assertEquals(1, res);
	}

	@Test
	public void size_2() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);


		pp[0] = init;
		pp[1] = init2;


		ht.init(pp);
		int res = ht.size();
		assertEquals(2, res);
	}

	@Test ( expected = IllegalArgumentException.class)
	public void size_nulll() 
	{
		Person[]pp2 = {};
		ht.init(pp2);
	}

	@Test 
	public void size_nol() 
	{
		for(int i=0;i<pp.length;i++)
		{
			pp[i] = null;
		}
		ht.init(pp);
		assertEquals(0,ht.size);
	}


	//========================
	//	del
	//========================
	@Test
	public void del_many() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);
		Person init3 = new Person(22,"dima","jora",25);
		Person init4 = new Person(32,"bora","bora",50);
		Person init5 = new Person(42,"dima","jora",25);
		Person init6 = new Person(172,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;
		pp[3] = init3;
		pp[4] = init4;
		pp[5] = init5;
		pp[6] = init6;
		int hash = ht.hashfunction(init3);
		ht.init(pp);
		ht.del(22, hash);
		assertEquals(5, ht.size());
	}

	@Test
	public void del_2() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;

		int hash = ht.hashfunction(init2);
		ht.init(pp);
		ht.del(2, hash);
		assertEquals(1, ht.size());
	}

	@Test
	public void del_1() 
	{
		Person init = new Person(12,"dima","jora",25);

		pp[0] = init;
		int hash = ht.hashfunction(init);
		ht.init(pp);
		ht.del(12, hash);
		assertEquals(0, ht.size());
	}

	@Test ( expected = IllegalArgumentException.class)
	public void del_0() 
	{
		Person init = new Person(12,"dima","jora",25);

		pp[0] = init;
		int hash = ht.hashfunction(init);
		ht.init(pp);
		ht.del(11, hash);
	}



	//========================
	//	add
	//========================
	@Test
	public void add_many() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);
		Person init3 = new Person(22,"dima","jora",25);
		Person init4 = new Person(32,"bora","bora",50);
		Person init5 = new Person(42,"dima","jora",25);
		Person init6 = new Person(172,"bora","bora",50);
		Person init7 = new Person(173,"bora","bora",50);
		Person init8 = new Person(174,"bora","bora",50);

	
		
		
		ht.add(init);
		ht.add(init2);
		ht.add(init3);
		ht.add(init4);
		ht.add(init5);
		ht.add(init6);
		ht.add(init7);
	    ht.add(init8);
	    
		assertEquals(8, ht.size());
	}

	@Test
	public void add_1() 
	{
		Person init = new Person(12,"dima","jora",25);


		ht.add(init);

		assertEquals(1, ht.size());
	}

	@Test
	public void add_2() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);


		ht.add(init);
		ht.add(init2);

		assertEquals(2, ht.size());
	}

	@Test 
	public void add_nul() 
	{
		Person init = null;
		ht.clear();
		ht.add(init);
		assertEquals(0, ht.size());
	}


	//========================
	//	clear
	//========================
	@Test
	public void clear_many() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);
		Person init3 = new Person(22,"dima","jora",25);
		Person init4 = new Person(32,"bora","bora",50);
		Person init5 = new Person(42,"dima","jora",25);
		Person init6 = new Person(172,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;
		pp[3] = init3;
		pp[4] = init4;
		pp[5] = init5;
		pp[6] = init6;

		ht.init(pp);
		ht.clear();
		int res = ht.size();
		assertEquals(0, res);
	}


	//========================
	//	get
	//========================
	@Test
	public void get_many() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);
		Person init3 = new Person(22,"dima","jora",25);
		Person init4 = new Person(32,"bora","bora",50);
		Person init5 = new Person(42,"dima","jora",25);
		Person init6 = new Person(172,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;
		pp[3] = init3;
		pp[4] = init4;
		pp[5] = init5;
		pp[6] = init6;
		int hash = ht.hashfunction(init3);
		ht.init(pp);
		int res = ht.get(22, hash).age;
		assertEquals(25, res);
	}

	@Test
	public void get_2() 
	{
		Person init = new Person(12,"dima","jora",25);
		Person init2 = new Person(2,"bora","bora",50);

		pp[0] = init;
		pp[1] = init2;

		int hash = ht.hashfunction(init2);
		ht.init(pp);
		int res = ht.get(2, hash).age;
		assertEquals(50, res);
	}

	@Test
	public void get_1() 
	{
		Person init = new Person(12,"dima","jora",25);

		pp[0] = init;
		int hash = ht.hashfunction(init);
		ht.init(pp);
		int res = ht.get(12, hash).age;
		assertEquals(25, res);
	}

	@Test ( expected = IllegalArgumentException.class)
	public void get_0() 
	{
		Person init = new Person(12,"dima","jora",25);

		pp[0] = init;
		int hash = ht.hashfunction(init);
		ht.init(pp);
		ht.get(11, hash);
	}


	//========================
	//	equals
	//========================	
	@Test
	public void equals_true() 
	{
		HashTable ht1 = new HashTable();
		HashTable ht2 = new HashTable();

		Person[] arr1 = new Person[10];
		Person[] arr2 = new Person[10];

		Person init11 = new Person(132,"dima","jora",25);
		Person init12 = new Person(223,"bora","bora",50);
		Person init13 = new Person(2232,"dima","jora",25);
		Person init14 = new Person(3232,"bora","bora",50);
		Person init15 = new Person(4232,"dima","jora",25);
		Person init16 = new Person(12372,"bora","bora",50);

		arr1[0] = init11;
		arr1[1] = init12;
		arr1[3] = init13;
		arr1[4] = init14;
		arr1[5] = init15;
		arr1[6] = init16;

		arr2[0] = init11;
		arr2[1] = init12;
		arr2[3] = init13;
		arr2[4] = init14;
		arr2[5] = init15;
		arr2[6] = init16;

		ht1.init(arr1);
		ht2.init(arr2);

		assertEquals(true,ht.equals(ht1.ar, ht2.ar));
	}

	@Test
	public void equals_false() 
	{
		HashTable ht1 = new HashTable();
		HashTable ht2 = new HashTable();

		Person[] arr1 = new Person[10];
		Person[] arr2 = new Person[10];

		Person init11 = new Person(132,"dima","jora",25);
		Person init12 = new Person(223,"bora","bora",50);
		Person init13 = new Person(2232,"dima","jora",25);
		Person init14 = new Person(3232,"bora","bora",50);
		Person init15 = new Person(4232,"dima","jora",25);
		Person init16 = new Person(12372,"bora","bora",50);

		arr1[0] = init11;
		arr1[1] = init12;
		arr1[3] = init13;
		arr1[4] = init14;
		arr1[5] = init15;
		arr1[6] = init16;

		arr2[0] = init11;
		arr2[1] = init12;
		arr2[3] = init13;
		arr2[4] = init14;
		arr2[5] = init15;

		ht1.init(arr1);
		ht2.init(arr2);

		assertEquals(false,ht.equals(ht1.ar, ht2.ar));
	}
}
