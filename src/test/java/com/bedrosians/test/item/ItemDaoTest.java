package com.bedrosians.test.item;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import com.bedrosians.bedlogic.dao.item.ItemDao;
import com.bedrosians.bedlogic.dao.item.ItemDetailDao;
import com.bedrosians.bedlogic.domain.item.Item;

import com.bedrosians.bedlogic.domain.item.ItemDetail;
import com.bedrosians.bedlogic.domain.item.SimplifiedItem;

import com.bedrosians.bedlogic.util.PatternMatchMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")
//@ContextConfiguration(locations = {"classpath*/appContext/bedlogic-context.xml", "classpath*/appContext/bedlogic-persistence.xml"})
//@ContextConfiguration(locations = {"classpath*/appContext/bedlogic-persistence.xml"})


public class ItemDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ItemDetailDao itemDetailDao;
	
	
	private static String testItemId = null;
	private static String testABCCode = null;
	private static String testDescription1 = null;
	private static String testDescription2 = null;
	private static String testFullDescription = null;
	private static String testColor = null;
    private static String testSeriesName = null;
    private static String testUpdateCode = null;
    private static String testItemTypeCode = null;
    private static String testCategory = null;
	
	
	@Before
	public void setup(){
		testItemId = /*"TRVMDBGSLAB2FH"; */"TCRBRE33B"; //"17884";//
		testABCCode = "D"; 
		testDescription1 = "13X13 Breccia Beige";
		testDescription2 = "Field Tile";
	    testFullDescription = "Field Tile 13x13 Breccia Beige";
	    testColor = "Beige";
	    testSeriesName = "Breccia";
	    testUpdateCode = "CERA-TCR";
	    testItemTypeCode = "#";
	    testCategory = "BRECCIA";
	}
	
	@Test
	public void testGetAllItems(){
		System.out.println("test if the item is returned by searching its ID...");
		List<Item> items = (List<Item>)itemDao.getAllItems();
		assertNotNull("should not be null", items);
		System.out.println("Total number of items retrieved = " + items.size());
		for(Item item : items){
		     //System.out.println("item Id = " + item.getItemId().toString());
		     assertNotNull("should not be null", item);
	 	}     
	}
	
	@Test
	public void testGetItemById(){
		System.out.println("test if the item is returned by searching its ID...");
		Item item = itemDao.getItemById(testItemId);
		System.out.println("item = " + item.toString());
		assertNotNull("should not be null", item);
		assertEquals("Item id should be " + testItemId, testItemId, item.getItemId());
	}
	
	@Test
	public void testGetItemByIdPatternMatch(){
		System.out.println("test if the item is returned by searching its ID...");
		List<Item> items = (List<Item>)itemDao.getItemsByIdPatternMatch(testItemId.substring(0, 4));
		assertNotNull("should not be null", items);
		for(Item item : items){
		     System.out.println("item Id = " + item.getItemId().toString());
		     assertNotNull("should not be null", item);
	  	     assertEquals("Item id should be " + testItemId, testItemId.substring(0, 3), item.getItemId().substring(0, 3));
		}     
	}
	
	@Test
	public void testGetItemDetailById(){
		System.out.println("test if the item is returned by searching its ID...");
		ItemDetail itemDetail = itemDetailDao.getItemById(testItemId);
		System.out.println("itemDetail = " + itemDetail.toString());
		//System.out.println("branches  = " + itemDetail.getItemBranches().size());
		assertNotNull("should not be null", itemDetail);
		assertEquals("Item id should be " + testItemId, testItemId, itemDetail.getItemId());
	}
	
	@Test
	@Transactional
	public void testCreateItem(){
		System.out.println("test create item ...");
		ItemDetail item = new ItemDetail();
		item.setItemId("bedlogic0001");
		item.setAbcCode(testABCCode);
		item.setStatus("Y");
		item.setColor(testColor);
		item.setSeriesName(testSeriesName);
		item.setDescription1(testDescription1);
		
		System.out.println("An new item created in memory");
		System.out.println("item = "+ item.toString());
		System.out.println("Now, save the item.");
		System.out.println("The newly created item ID = " + itemDetailDao.createItem(item));
       	Item newItem = itemDao.getItemById(item.getItemId());
       	//System.out.println("retrieved the saved item  = "+ newItem.toString());
		//assertNotEquals(testState, item.getAddressState());
	}    	
	
	@Test
	@Transactional
	//need to run more tests
	public void testUpdateItem(){
		System.out.println("test update item ...");
		ItemDetail item = itemDetailDao.getItemById(testItemId);
		System.out.println("An existing item retrieved");
		System.out.println("item = "+ item.toString());
		//assertEquals("CA", item.getState());
		System.out.printf("Now, set the description1 to %s, %s", "Test", " And save it to DB...");
        item.setDescription1("Test");
		itemDetailDao.update(item);
		item = itemDetailDao.getItemById(item.getItemId());
		System.out.println("Retrieved the upated item");
		System.out.println("item = "+ item.toString());
		//assertNotEquals("CA", item.getState());
		
	}
/*			
	//@Test
	public void testGetItemsByActivityStatus(){
		System.out.println("test if the item is returned by searching its status...");
		SimplifiedItem simplifiedItem = itemDao.getItemsByActivityStatus("inactive").get(0);
		assertNotNull("should not be null", simplifiedItem);
		System.out.println("item = " + simplifiedItem.toString());
		assertEquals("item should have inactive status ", "D", simplifiedItem.getActivityStatus());
	}
	
	//@Test
	public void testGetItemsByCityParameter(){
		System.out.println("test if the item is returned by searching its city...");
		Item item = itemDao.findByParameter("city", testCity).get(0);
		assertNotNull("should not be null", item);
		System.out.println("item = " + item.toString());
	//	assertEquals("item should have "+ testCity + " as item city ", testCity.toUpperCase(), item.getCity());
	}
	
	@Test
	public void testGetItemsByStateParameter(){
		System.out.println("test if the items are returned by searching its state...");
		Item item = itemDao.findByParameter("state", testState).get(0);
		assertNotNull("should not be null", item);
		System.out.println("item = " + item.toString());
		assertEquals("item should have "+ testState + " as item state ", testState.toUpperCase(), item.getState());
	}
	
	@Test
	public void testGetItemsByZipParameter(){
		System.out.println("test if the items are returned by searching its zip...");
		Item item = itemDao.findByParameter("zip", testZip).get(0);
		assertNotNull("should not be null", item);
		System.out.println("item = " + item.toString());
		assertEquals("item should have "+ testZip + " as item zip ", testZip, item.getZip().trim());
	}
	
	@Test
	public void testGetBranches(){
		System.out.println("test if the item branches are returned by searching item ID...");
		List<SimplifiedItemBranch> branches = (List<SimplifiedItemBranch>)itemBranchDao.getItemBranches(testItemId);
		
		assertNotNull("should not be null", branches);
		for(ItemBranch branch : branches){
			System.out.println("branch = " + branch.toString());
		    assertEquals("Item id should be " + testItemId, testItemId, branch.getItemId());
		}    
	}
	
	@Test
	public void testGetBrancheDetailByBranchId(){
		System.out.println("test if the item branches is returned by searching its ID...");
		ItemBranchDetail branch = itemBranchDetailDao.getItemBranchById(testItemId, testBranchId);
		System.out.println("item = " + branch.toString());
		assertNotNull("should not be null", branch);
		assertEquals("Item id should be " + testItemId, testItemId, branch.getItemId());
	}
	
	@Test
	public void testGetBrancheDetailByBranchPK(){
		System.out.println("test if the item branches is returned by searching its ID...");
		BranchPK branchPK = new BranchPK(testItemId, testBranchId);
		ItemBranchDetail branch = itemBranchDetailDao.getItemBranchByBranchPK(branchPK);
		System.out.println("item = " + branch.toString());
		assertNotNull("should not be null", branch);
		assertEquals("Item id should be " + testItemId, testItemId, branch.getItemId());
	}
	
	
		
	@Test
	public void testGetItemsByItemNameParameter(){
		System.out.println("test if the item is returned by searching its parameter's name...");
		SimplifiedItem simplifiedItem = itemDao.findByParameter("itemName", testItemName).get(0);
		assertNotNull("should not be null", simplifiedItem);
		System.out.println("item = " + simplifiedItem.toString());
		assertEquals("item should have 'THE RUG SHOPPE' as item name", testItemName, simplifiedItem.getItemName());
	}
	
	//@Test
	public void testGetItemsByItemNamePattern(){
		System.out.println("test if the item is returned by searching its parameter's name...");
		List<SimplifiedItem> simplifiedItems = itemDao.findByParameterPattern("itemName", "AB", PatternMatchMode.START);
		assertNotNull("should not be null", simplifiedItems);
		for(SimplifiedItem simplifiedItem : simplifiedItems) {
		   System.out.println("item name = " + simplifiedItem.getItemName());
		   //assertEquals("item should have 'THE RUG SHOPPE' as item name", testItemName, item.getItemName());
	
		}
	}	
	
	@Test
	public void testGetItemsByOwnerName(){
		System.out.println("test if the item is returned by searching its owner's name...");
		List<SimplifiedItem> simplifiedItems = itemDao.getItemsByOwnerName(testFirstName, testLastName);
		assertNotNull("should not be null", simplifiedItems);
		for(SimplifiedItem simplifiedItem : simplifiedItems) {
		   System.out.println("item = " + simplifiedItem.toString());
		   assertEquals("item should have 'THE RUG SHOPPE' as item name", testItemName, simplifiedItem.getItemName());
	    }
	
	}

	@Test
	@Transactional
	//need to run more tests
	public void testUpdateItem(){
		System.out.println("test update item ...");
		ItemDetail item = itemDetailDao.getItemById(testItemId);
		System.out.println("An existing item retrieved");
		System.out.println("item = "+ item.toString());
		//assertEquals("CA", item.getState());
		System.out.printf("Now, set the state to %s, %s", testState, " And save it to DB...");
        item.setItemName("Test");
		item.setState("NY");
		itemDetailDao.update(item);
		item = itemDetailDao.getItemById(item.getItemId());
		System.out.println("Retrieved the upated item");
		System.out.println("item = "+ item.toString());
		//assertNotEquals("CA", item.getState());
		
	}

		
	
	@Test
	@Transactional
	public void testCreateSimplifiedItem(){
		System.out.println("test create item ...");
		SimplifiedItem item = new SimplifiedItem();
		//item.setItemId("bedlogic0001");
		item.setItemName("TestItemName");
		item.setActivityStatus("Y");
		item.setCity(testCity);
		item.setCity(testCity);
		item.setZip(testZip);
		System.out.println("An new item created in memory");
		System.out.println("item = "+ item.toString());
		System.out.println("Now, save the item.");
       	itemDao.createItem(item);
       	Item newItem = itemDao.getItemById(item.getItemId());
       	System.out.println("retrieved the saved item  = "+ newItem.toString());
		//assertNotEquals(testState, item.getAddressState());
		
	}
	
	@Test
	@Transactional
	public void testCreateItem(){
		System.out.println("test create item ...");
		ItemDetail item = new ItemDetail();
		//item.setItemId("bedlogic0001");
		item.setItemName("TestItemName");
		item.setActivityStatus("Y");
		item.setCity(testCity);
		item.setState(testState);
		item.setZip(testZip);
		System.out.println("An new item created in memory");
		System.out.println("item = "+ item.toString());
		System.out.println("Now, save the item.");
		System.out.println("The newly created item ID = " + itemDetailDao.createItem(item));
       	Item newItem = itemDao.getItemById(item.getItemId());
       	//System.out.println("retrieved the saved item  = "+ newItem.toString());
		//assertNotEquals(testState, item.getAddressState());
		
	}
	*/
	 
}
