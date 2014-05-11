/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tufel
 */
public class test2 {
    private int IdProduct;
   private String title;
   private int price;
   private int weight;
   private String description;
   private int IdProductCategory;
   private String Title;
   
   private static final String URL = "jdbc:derby://localhost:1527/IST411";
   private static final String USERNAME = "banana";
   private static final String PASSWORD = "banana";

   private Connection connection = null; // manages connection
   private PreparedStatement selectAllProducts = null; 
   private PreparedStatement selectAllProducts1 = null;
   private PreparedStatement selectAllProducts2 = null;
   private PreparedStatement selectAllProducts3 = null;
   private PreparedStatement selectAllProducts4 = null;
   private PreparedStatement selectAllProducts5 = null;
   private PreparedStatement selectProductByID = null; 
   private PreparedStatement selectProductCategory = null;
   private PreparedStatement selectProductCategory2 = null;
   
   
   public test2()
   {
       try 
      {
         connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );

         // create query that selects all entries in the AddressBook
      selectAllProducts = 
         connection.prepareStatement( "SELECT * FROM PRODUCT WHERE IDPRODUCT = 1" );
      selectAllProducts1 = 
         connection.prepareStatement( "SELECT * FROM PRODUCT WHERE IDPRODUCT = 2" );
      selectAllProducts2 = 
         connection.prepareStatement( "SELECT * FROM PRODUCT WHERE IDPRODUCT = 3" );
      selectAllProducts3 = 
         connection.prepareStatement( "SELECT * FROM PRODUCT WHERE IDPRODUCT = 4" );
      selectAllProducts4 = 
         connection.prepareStatement( "SELECT * FROM PRODUCT WHERE IDPRODUCT = 5" );
      selectAllProducts5 = 
         connection.prepareStatement( "SELECT * FROM PRODUCT WHERE IDPRODUCT = 6" );
      selectProductCategory = connection.prepareStatement("SELECT * FROM PRODUCTCATEGORY WHERE IDPRODUCTCATEGORY = 1");
      selectProductCategory2 = connection.prepareStatement("SELECT * FROM PRODUCTCATEGORY WHERE IDPRODUCTCATEGORY = 2");
      
      selectProductByID = 
                 connection.prepareStatement("SELECT * FROM PRODUCT WHERE IDPRODUCT = ?");
      }
       catch( SQLException sqlException ){
           sqlException.printStackTrace();
         System.exit( 1 );
       }
    
}
   public test2(int pcID, String pcTitle){
       setpcID2(pcID);
       setpcTitle(pcTitle);
       
   }
   
   public void setpcID2(int pcID)
   {
       IdProductCategory = pcID;
   }
   public int getpcID2()
   {
       return IdProductCategory;
   }
   
   public void setpcTitle(String pcTitle)
   {
       Title = pcTitle;
   }
   public String getpcTitle()
   {
       return Title;
   }
   
   public test2(int id,String first, int last, int third,String forth){ //int cat){
       
       setID(id);
       setTitle(first);
       setPrice(last);
       //setCategoryID(cat);
       setWeight(third); 
       setDescription(forth);
  }
   public void setID( int id)
   {
       IdProduct = id;
   }
    public long getID()
   {
      return IdProduct;
   } // end method getAddressID
   
   // sets the firstName
   public void setTitle( String first )
   {
      title = first;
   } // end method setFirstName

   // returns the first name 
   public String getTitle()
   {
      return title;
   } // end method getFirstName
   
   // sets the lastName
   public void setPrice( int last )
   {
      price = last;
   } // end method setLastName

   // returns the last name 
   public int getPrice()
   {
      return price;
   } // end method getLastName
   
   /*public void setCategoryID(int cat)
   {
       IdProductCategory = cat;
   }
   
   public int getCategoryID()
   {
       return IdProductCategory;
   }*/
   
   public void setWeight(int third)
   {
       weight = third;
   }
   
   public int getWeight()
   {
       return weight;
   }
   
   public void setDescription(String forth)
   {
       description = forth;
   }
   
   public String getDescription()
   {
       return description;
   }
   
   
   public void getProductByID( int ID )
   {
      List< test2 > results = null;
      ResultSet resultSet = null;

      try 
      {
          selectProductByID.setInt( 1, ID ); 
         
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectProductByID.executeQuery(); 
         results = new ArrayList< test2 >();

         while ( resultSet.next() )
         {
            results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
          // end while
         //System.out.print(results.get(0).getCategoryID());
         System.out.print("ProductID"+" "+"Title"+"\t"+"Price"+"\t"+"Weight"+"\t"+"Description"+"\n");
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         }
         } // end try
      
      
      catch ( SQLException sqlException )
      {
         //System.out.print("errrorrr");
          sqlException.printStackTrace();
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getPeopleByName
   
   public void getProductCategory()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectProductCategory2.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProductCategory" ),
               resultSet.getString( "Title" )) );
          // end while
               
         }
         System.out.print("ProductCategory"+"\n");
         System.out.print(results.get(0).getpcID2()+"\t");
         System.out.print(results.get(0).getpcTitle());
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   
   public List < test2 > getAllProducts()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectAllProducts.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
          // end while
               System.out.print("\n"+"ProductID"+" "+"Title"+"\t"+"Price"+"\t"+"Weight"+"\t"+"Description"+"\n");
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         }
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getAllPeople
   public void getProduct1()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectAllProducts1.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
          // end while
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         }
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   public void getProduct2()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectAllProducts2.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
          // end while
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         }
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   
   public void getProductCategory1()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectProductCategory.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProductCategory" ),
               resultSet.getString( "Title" )) );
          // end while
               
         }
         System.out.print("ProductCategory"+"\n");
         System.out.print(results.get(0).getpcID2()+"\t");
         System.out.print(results.get(0).getpcTitle());
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   
   public void getProduct3()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectAllProducts3.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
          // end while
               System.out.print("\n"+"ProductID"+" "+"Title"+"\t"+"Price"+"\t"+"Weight"+"\t"+"Description"+"\n");
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         }
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   public void getProduct4()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectAllProducts4.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
         }// end while
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   public void getProduct5()
   {
      List< test2 > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = selectAllProducts5.executeQuery(); 
         
         results = new ArrayList< test2 >();
         
         while ( resultSet.next() )
         {
            
               results.add( new test2( resultSet.getInt( "IDProduct" ),
               resultSet.getString( "title" ),
               resultSet.getInt( "price" ),
               resultSet.getInt("weight"),
               resultSet.getString("description")) );
         }// end while
         System.out.print(results.get(0).getID());
         System.out.print("\t");
         System.out.print(results.get(0).getTitle());
         System.out.printf("\t");
         System.out.print(results.get(0).getPrice()+"\t");
         System.out.print(results.get(0).getWeight()+"\t");
         System.out.print(results.get(0).getDescription());
         System.out.printf("\t"+"\n");
         
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      //return results;
   } // end method getAllPeople
   
   public void close()
   {
      try 
      {
         connection.close();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
   } // end method close
   
    }
