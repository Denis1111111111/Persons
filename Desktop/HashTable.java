public class HashTable 
{
	int size = 0;
	int length;
	NodePerson [] ar;

	public HashTable(int length)
	{
		this.length = length;
		NodePerson[] ar = new NodePerson[length];
		this.ar = ar;
	}

	public HashTable()
	{
		length = 7;
		NodePerson[] ar = new NodePerson[length];
		this.ar = ar;
	}

	private class NodePerson
	{
		Person p;
		NodePerson next;
		NodePerson back;

		public  NodePerson(Person p)
		{
			this.p = p;
			next = null;
			back = null;
		}
	}
	

	public int hashfunction(Person p)
	{
		int hash = (p.id * 100) /35 +76;
		return hash;
	}

	public int index(int hash)
	{
		int index = 0;
		index = hash % length;

		if(index > (length-1))
		{
			index = bigindex(index);
		}
		return index;
	}

	private int bigindex(int index)
	{
		index = index - 1;
		if(index > (length-1))
		{
			index = bigindex(index);
		}
		return index;
	}

	void init(Person[]arr)
	{
		if(arr.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		for(int i = 0; i < arr.length; i++)
		{
			add(arr[i]);
		}
	}



	void add(Person p)
	{
		if(p == null)
		{
			return;
		}

		int hash = hashfunction(p);
		int index = index(hash);
		NodePerson node = new NodePerson(p);

		if(ar[index] == null)
		{
			addPerson(node,index);	
			return;
		}

		if(equalsId(node,ar[index]) == true)
		{
			throw new IllegalArgumentException("such id already exists");
		}

		if(equalsId(node,ar[index]) == false)
		{
			addPerson(node,index);	
		} 

		resize();
	}

	private void addPerson(NodePerson p, int index)
	{
		if(ar[index] == null)
		{
			ar[index] = p;
		}

		else if(ar[index].next == null)
		{
			ar[index].next = p;
			p.back = ar[index];
		}

		else 
		{
			addPerson(ar[index].next,index);
		}
		size++;
	}

	int size()
	{
		return size;	
	}

	void del(int id,int hash)
	{
		int index = index(hash);
		NodePerson p = null;

		if(ar[index] != null)
		{
			p = ar[index];
		}

		if(ar[index] == null)
		{
			throw new IllegalArgumentException("No Person whith this ID");
		}
		delPerson(id,p);
	}

	private void  delPerson(int id, NodePerson p)
	{
		if(p.p.id == id )
		{
			if(p.next == null && p.back == null)
			{
				p = null;
				size--;
				return;
			}

			else if(p.next == null && p.back != null)
			{
				p.back.next = null;
				p = null;
				size--;
				return;
			}

			else if(p.next != null && p.back == null)
			{
				p.next.back = null;
				p = p.next;
				size--;
				return;
			}

			else if(p.next != null && p.back != null)
			{
				p.back.next = p.next;
				p.next.back = p.back;
				p = null;
				size--;
				return;
			}
		}

		if(p.p.id != id )
		{
			if(p.next != null)
			{
				delPerson(id, p.next);
			}

			else if( p.next == null) 
			{
				throw new IllegalArgumentException("No Person whith this ID");
			}
		}
	}

	Person get(int id,int hash)
	{
		int index = index(hash);
		NodePerson p = null;

		if(ar[index] != null)
		{
			p = ar[index];
		}

		if(ar[index] == null)
		{
			throw new IllegalArgumentException("No Person whith this ID");
		}
		return getPerson(id,p);
	}

	private Person  getPerson(int id, NodePerson p)
	{
		Person res = null;
		if(p.p.id == id )
		{
			res = p.p;
			return res;
		}

		if(p.p.id != id )
		{
			if(p.next != null)
			{
				res = getPerson(id, p.next);
			}

			if( p.next == null) 
			{
				throw new IllegalArgumentException("No Person whith this ID");
			}
		}

		return res;
	}

	private boolean equalsId(NodePerson p, NodePerson p2)
	{		
		if (p.p.id == p2.p.id)
		{
			return true;
		}
		if(p.p.id != p2.p.id && p.next != null)
		{
			equalsId(p,p2.next);
		}
		return false;
	}

	boolean equals(NodePerson [] ar, NodePerson [] ar2)
	{
		if(ar.length != ar2.length)
		{
			return false;
		}

		for(int i = 0; i < ar.length; i++)
		{
			if( equalsNode(ar[i], ar2[i]) == false)
			{
				return false;
			}
			if( equalsNode(ar[i], ar2[i]) == true && i+1 == ar.length)
			{
				return true;
			}
		}
		return false;
	}

	private boolean equalsNode(NodePerson p, NodePerson p2)
	{
		if(p == null && p2 == null )
		{
			return true;
		}

		if(p != null && p2 == null || p == null && p2 != null )
		{
			return false;
		}

		if(p.p.id == p2.p.id && p.p.fname == p2.p.fname && p.p.lname == p2.p.lname && p.p.age == p2.p.age && p.next  == null && p2.next == null)
		{
			return true;
		}

		if(p.p.id != p2.p.id || p.p.fname != p2.p.fname || p.p.lname != p2.p.lname || p.p.age != p2.p.age)
		{
			return false;
		}

		if(p.p.id == p2.p.id && p.p.fname == p2.p.fname && p.p.lname == p2.p.lname && p.p.age == p2.p.age && p.next  != null && p2.next != null)
		{
			equalsNode(p.next,p2.next);
		}
		return true;
	}

	public int[] primeNumber()
	{
		int n = 300;
		if(size() + 50 > n)
		{
			n = n + 50;
		}
		int[] full = new int[n];

		for (int i = 0; i < n; i++) 
		{
			full[i] = i;
		}
		full[1] = 0; 

		for (int s = 2; s < n; s++) 
		{
			if (full[s] != 0) 
			{
				for (int w = s * 2; w < n; w += s) 
				{
					full[w] = 0;
				}
			}
		}
		int count = 0;
		for(int i = 0;i < full.length; i++)
		{
			if(full[i] != 0)
			{
				count++;	
			}
		}

		int prime [] = new int [count];
		for (int i = 0,ind = 0; i < n; i++) 
		{
			if (full[i] != 0) 
			{   	
				prime[ind] = full[i];
				ind++;
			}
		}
		return prime;
	}


	void clear()
	{
		size = 0;
		for(int i = 0; i < ar.length; i++)
		{
			ar[i] = null;
		}
		ar = new NodePerson[length];
	}


	private void resize()
	{
		float balans  = length * 0.7f;
		if(size() > Math.round(balans))
		{
			Person[]tmp = new Person[size()];
			for(int i = 0; i<tmp.length;i++)
			{
				tmp[i]= null;
			}

			int possibleLength = length + 6;
			int[] prime = primeNumber(); 

			for(int i = 0; i < prime.length; i++)
			{
				if(prime[i] == possibleLength  )
				{
					length = possibleLength;
					break;
				}

				if(prime[i] < possibleLength && possibleLength < prime[i+1]  && i != prime.length -1)
				{
					length = prime[i+1];
					break;
				}
			}



			for(int i = 0; i < ar.length; i++)
			{
				if(ar[i] == null)
				{
					continue;
				}

				if(ar[i] != null)
				{
					tmp = saveHashTable(ar[i],tmp);
				}
			}
			clear();
			init(tmp);
			return;
		}
	}


	private Person[] saveHashTable(NodePerson node, Person [] tmp)   
	{
		if(node.next == null)
		{
			for(int i = 0; i < tmp.length; i++)
			{
				if(tmp[i] == null)
				{
					tmp[i] = node.p;	
					return tmp;
				}
			}
		}

		if(node.next != null)
		{
			for(int i = 0; i < tmp.length; i++)
			{
				if(tmp[i] == null)
				{
					tmp[i] = node.p;
					saveHashTable(node.next,tmp);
					break;
				}
			}
		}
		return tmp;
	}	
}
