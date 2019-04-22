package com.example.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;

public class TestMongoMR3 {
	public static void main(String[] args) {
		
		Mongo mongo;

        try {
        	
            mongo = new Mongo("localhost", 27017);
            
            DB db = mongo.getDB("library");

            DBCollection books = db.getCollection("books");
            
            BasicDBObject query = new BasicDBObject();
            
            query.put("pages", new BasicDBObject("$gte", 200));
            
            String map = "function(){ emit(this.name, this.pages); }";

            String reduce = "function( key, values ){ return Array.sum(values); }";

            MapReduceCommand cmd = new MapReduceCommand(books, map, reduce,
            		
                    null, MapReduceCommand.OutputType.INLINE,query );

            MapReduceOutput out = books.mapReduce(cmd);

            for (DBObject o : out.results()) {
            	
                System.out.println(o.toString());
                
            }
        } catch (Exception e) {
        	
            e.printStackTrace();

        }
		
		
		
	}

}
