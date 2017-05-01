import java.util.*;

/** Container class to different classes, that makes the whole
 * set of classes one class formally.
 */
public class GraphTask {

   /** Main method. 
 * @throws CloneNotSupportedException */
   public static void main (String[] args) throws CloneNotSupportedException {
      GraphTask a = new GraphTask();
      a.run();
 
   }
   
   public void test1() throws CloneNotSupportedException {
	   
	   	  System.out.println ("--------TEST1 #Create Random Simple Graph------------ ");
	      Graph original = new Graph ("G");
	   	  original.createRandomSimpleGraph(5, 4); //
	   	  System.out.println ("---------original-----------");
	      System.out.println (original);
	     
	   
	      Graph clone =  (Graph) original.clone();
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	      
	   	    
	      original.createRandomSimpleGraph(2, 1);
	      System.out.println ("-------modified original------------- ");
	      System.out.println (original);
	      
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	      
}
   
   
   public void test2() throws CloneNotSupportedException {
	   
	  	System.out.println ("--------TEST2 # Create Vertex------------ ");
	      Graph original = new Graph ("G");
	   	  original.createVertex("Original0");
	   	 System.out.println ("-------original------------- ");
	      System.out.println (original);
	     
	      Graph clone =  (Graph) original.clone();
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	     
	   	    
	      original.first.id("Modified1");
	      System.out.println ("-------modified original------------- ");
	      System.out.println (original);
	   
	      
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
   }
   
   public void test3() throws CloneNotSupportedException {
	   
	  	System.out.println ("--------TEST3 # Create Arc------------ ");
	      Graph original = new Graph ("G");
	      Vertex v = original.createVertex("ov1");
	      Vertex v1 = original.createVertex("ov2");
	   	  original.createArc("o0", v, v1);
	   	 System.out.println ("-------original------------- ");
	      System.out.println (original);
	     
	      Graph clone =  (Graph) original.clone();
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	     
	   	    
	      original.createArc("o1", v, v1);
	      System.out.println ("-------modified original------------- ");
	      System.out.println (original);
	   
	      
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
  }
   public void test4() throws CloneNotSupportedException {
	   //Here I used the Random simple graph again, but before in Test 1 it clone the original object and modify it but in this test 4 clones the Original object and modify the cloned object.
		System.out.println ("--------TEST4 # Create Random Simple Graph 2 ------------ ");
	      Graph original = new Graph ("G");
	   	  original.createRandomSimpleGraph(2, 1); //
	   	 System.out.println ("---------original-----------");
	      System.out.println (original);
	     
	   
	      Graph clone =  (Graph) original.clone();
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	      
	   	    
	      clone.createRandomSimpleGraph(6, 9);
	      System.out.println ("-------modified clone------------- ");
	      System.out.println (clone);
	      
	      System.out.println ("----------original---------- ");
	      System.out.println (original);
 }
   public void test5() throws CloneNotSupportedException {
	   
	  	System.out.println ("--------TEST5 # Create Random Tree------------ ");
	      Graph original = new Graph ("G");
	   	  original.createRandomTree(2);
	   	 System.out.println ("-------original------------- ");
	      System.out.println (original);
	     
	      Graph clone =  (Graph) original.clone();
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	     
	   	    
	      original.createRandomTree(5);
	      System.out.println ("-------modified original------------- ");
	      System.out.println (original);
	   
	      
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
}
   
   public void test6() throws CloneNotSupportedException {
	   
	  	System.out.println ("--------TEST6 # Create AdjMatrix------------ ");
	      Graph original = new Graph ("G");
	   	  original.createAdjMatrix();
	   	 System.out.println ("-------original------------- ");
	      System.out.println (original);
	     
	      Graph clone =  (Graph) original.clone();
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
	     
	   	    
	      original.createAdjMatrix();
	      System.out.println ("-------modified original------------- ");
	      System.out.println (original);
	   
	      
	      System.out.println ("----------clone---------- ");
	      System.out.println (clone);
}


   /** Actual main method to run examples and everything. 
 * @throws CloneNotSupportedException */
   public void run() throws CloneNotSupportedException {
      test1();
      test2();
      test3();
      test4();
      test5();
      test6();
   }
   
   

   // TODO!!! add javadoc relevant to your problem
   class Vertex {

      private String id;
      private Vertex next;
      private Arc first;
      private int info = 0;
      // You can add more fields, if needed

      Vertex (String s, Vertex v, Arc e) {
         id = s;
         next = v;
         first = e;
      }
      
      
      public void id(String s){
          this.id = s;
       }

      Vertex (String s) {
         this (s, null, null);
      }

      @Override
      public String toString() {
         return id;
      }
   }


   /** Arc represents one arrow in the graph. Two-directional edges are
    * represented by two Arc objects (for both directions).
    */
   class Arc {

      private String id;
      private Vertex target;
      private Arc next;
      private int info = 0;
      // You can add more fields, if needed

      Arc (String s, Vertex v, Arc a) {
         id = s;
         target = v;
         next = a;
      }

      Arc (String s) {
         this (s, null, null);
      }

      @Override
      public String toString() {
         return id;
      }

   } 


   class Graph implements Cloneable {

      private String id;
      private Vertex first;
      private int info = 0;
      // You can add more fields, if needed

      Graph (String s, Vertex v) {
         id = s;
         first = v;
      }

      Graph (String s) {
         this (s, null);
      }

      @Override
      public String toString() {
         String nl = System.getProperty ("line.separator");
         StringBuffer sb = new StringBuffer (nl);
         sb.append (id);
         sb.append (nl);
         Vertex v = first;
         while (v != null) {
            sb.append (v.toString());
            sb.append (" -->");
            Arc a = v.first;
            while (a != null) {
               sb.append (" ");
               sb.append (a.toString());
               sb.append (" (");
               sb.append (v.toString());
               sb.append ("->");
               sb.append (a.target.toString());
               sb.append (")");
               a = a.next;
            }
            sb.append (nl);
            v = v.next;
         }
         return sb.toString();
      }

      public Vertex createVertex (String vid) {
         Vertex res = new Vertex (vid);
         res.next = first;
         first = res;
         return res;
      }

      public Arc createArc (String aid, Vertex from, Vertex to) {
         Arc res = new Arc (aid);
         res.next = from.first;
         from.first = res;
         res.target = to;
         return res;
      }

      /**
       * Create a connected undirected random tree with n vertices.
       * Each new vertex is connected to some random existing vertex.
       * @param n number of vertices added to this graph
       */
      public void createRandomTree (int n) {
         if (n <= 0)
            return;
         Vertex[] varray = new Vertex [n];
         for (int i = 0; i < n; i++) {
            varray [i] = createVertex ("v" + String.valueOf(n-i));
            if (i > 0) {
               int vnr = (int)(Math.random()*i);
               createArc ("a" + varray [vnr].toString() + "_"
                  + varray [i].toString(), varray [vnr], varray [i]);
               createArc ("a" + varray [i].toString() + "_"
                  + varray [vnr].toString(), varray [i], varray [vnr]);
            } else {}
         }
      }

      /**
       * Create an adjacency matrix of this graph.
       * Side effect: corrupts info fields in the graph
       * @return adjacency matrix
       */
      public int[][] createAdjMatrix() {
         info = 0;
         Vertex v = first;
         while (v != null) {
            v.info = info++;
            v = v.next;
         }
         int[][] res = new int [info][info];
         v = first;
         while (v != null) {
            int i = v.info;
            Arc a = v.first;
            while (a != null) {
               int j = a.target.info;
               res [i][j]++;
               a = a.next;
            }
            v = v.next;
         }
         return res;
      }

      /**
       * Create a connected simple (undirected, no loops, no multiple
       * arcs) random graph with n vertices and m edges.
       * @param n number of vertices
       * @param m number of edges
       */
      public void createRandomSimpleGraph (int n, int m) {
         if (n <= 0)
            return;
         if (n > 2500)
            throw new IllegalArgumentException ("Too many vertices: " + n);
         if (m < n-1 || m > n*(n-1)/2)
            throw new IllegalArgumentException 
               ("Impossible number of edges: " + m);
         first = null;
         createRandomTree (n);       // n-1 edges created here
         Vertex[] vert = new Vertex [n];
         Vertex v = first;
         int c = 0;
         while (v != null) {
            vert[c++] = v;
            v = v.next;
         }
         int[][] connected = createAdjMatrix();
         int edgeCount = m - n + 1;  // remaining edges
         while (edgeCount > 0) {
            int i = (int)(Math.random()*n);  // random source
            int j = (int)(Math.random()*n);  // random target
            if (i==j) 
               continue;  // no loops
            if (connected [i][j] != 0 || connected [j][i] != 0) 
               continue;  // no multiple edges
            Vertex vi = vert [i];
            Vertex vj = vert [j];
            createArc ("a" + vi.toString() + "_" + vj.toString(), vi, vj);
            connected [i][j] = 1;
            createArc ("a" + vj.toString() + "_" + vi.toString(), vj, vi);
            connected [j][i] = 1;
            edgeCount--;  // a new edge happily created
         }
      }

   // Overriding clone() method to create a deep copy of an object.
  	protected Object clone() throws CloneNotSupportedException {
  		Vertex v = first;  
  		HashMap<Vertex, Vertex> vertexMap = new HashMap<Vertex, Vertex>();//here HashMap has two parameters original and the cloned. // that is original valune of the vertex is mapped to the clone value 
  		HashMap<Arc, Arc> arcMap = new HashMap<Arc, Arc>();
  		
        while (v != null) { // while vertex v  is not equal to null. 
        	if(!vertexMap.containsKey(v)){ //if the vertexmap does not contain any cloned key value of the vertex previousl. 
          	  vertexMap.put(v, new Vertex(v.id));// then vertexmap clone a original vertex v and set a new cloned key value of the vertex 
            }
        	Arc a = v.first; // here  variavle 'a' of the Arc is assigened to the vertex 'v.first'
          while (a != null) { //while 'a' is not equals to 'null'
              if(!arcMap.containsKey(a)){ //if arcmap doesnt contain a key of the arc 'a',
            	  arcMap.put(a, new Arc(a.id)); //then arcMap clones a original arc 'a' and returns a new cloned  key value of the arc.
              }
              if(a.target != null && !vertexMap.containsKey(a.target)){ //if a.traget is not equal to null and the vertexmap doesnt contain any cloned key value for 'a.target'
            	  vertexMap.put(a.target, new Vertex(a.target.id)); //then vertexMap clones a original 'a.target' and assign a new cloned key value of vertex 'a.target'.
              }
              a = a.next; // 'a' is set to 'a.next'
           }
          v = v.next; //and 'v' is set to 'v.next'
        }
        
       // here i am tracing the vertex and the arc
        v = first; // v is assigned to first;
        while (v != null) { //while v is not equal to null
           Arc a = v.first; // set 'v.first' equal to Arc variable 'a'
           Vertex cv= vertexMap.get(v); // here it returns the cloned key value and assigned it to cv(cloned vertex)
           Arc ca= arcMap.get(a); // here it returns the cloned key value and assigned it to ca(cloned arc)
           cv.first = ca; // then cv.first is assigned to ca 
           while (a != null) { // while a is not equal to null
        	 ca = arcMap.get(a); // then retun the cloned key value of 'a' and assigns it to ca(cloned arc)
             ca.target = vertexMap.get(a.target); // here it returns theccloned key value of 'a.target' and assigns it to 'ca.target'
             ca.next = arcMap.get(a.next); // here it returns the cloned key value of 'a.next' and assigns it to 'ca.next'
             a = a.next; // and assigned 'a' to 'a.next'
           }
           cv.next = vertexMap.get(v.next); // here it returns the cloned key value of 'v.next' and assigns it to 'cv.next'
           v = v.next; // and assigned 'v.next' to the 'v'
        }
        
        return new Graph(id, vertexMap.get(first)); //here it retruns the Graphs 
  	}
  	
   }

} 
