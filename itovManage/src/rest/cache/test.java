package rest.cache;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
         Cache c=new Cache();
         c.setKey("cache_info");
         c.setExpired(false);
         c.setTimeOut(0);
         c.setValue("赵生华");
         CacheManager.putContent("cache_infoA", c, 0);
         
       
         
         Cache cache=  CacheManager.getContent("cache_infoA");
         if(cache!=null)
         {
         Object a=cache.getValue();
         }
	}

}
