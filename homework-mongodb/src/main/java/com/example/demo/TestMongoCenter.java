package com.example.demo;

import static com.mongodb.client.model.Indexes.geo2d;
import static com.mongodb.client.model.Indexes.geo2dsphere;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

public class TestMongoCenter {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
	    MongoDatabase database = mongoClient.getDatabase("round");
	    MongoCollection<Document> mc = database.getCollection("position");
	    mc.drop();
	    
	    Document doc1 = new Document("name", "Aabbye").append("location", Arrays.asList(10, 10)).append("ip", new Point(new Position(10, 10)));
        Document doc2 = new Document("name", "Babs").append("location", Arrays.asList(11, 10)).append("ip", new Point(new Position(11, 10)));
        Document doc3 = new Document("name", "Cady").append("location", Arrays.asList(10, 12)).append("ip", new Point(new Position(10, 12)));
        Document doc4 = new Document("name", "Dahlia").append("location", Arrays.asList(9, 10)).append("ip", new Point(new Position(9, 10)));
        Document doc5 = new Document("name", "Earl").append("location", Arrays.asList(10, 13)).append("ip", new Point(new Position(10, 13)));
        Document doc6 = new Document("name", "Fabion").append("location", Arrays.asList(8, 10)).append("ip", new Point(new Position(8, 10)));
        Document doc7 = new Document("name", "Gabriel").append("location", Arrays.asList(14, 10)).append("ip", new Point(new Position(14, 10)));
        Document doc8 = new Document("name", "Haden").append("location", Arrays.asList(7, 10)).append("ip", new Point(new Position(7, 10)));
        Document doc9 = new Document("name", "Ianna").append("location", Arrays.asList(15, 10)).append("ip", new Point(new Position(15, 10)));
        Document doc10 = new Document("name", "Jack").append("location", Arrays.asList(16, 10)).append("ip", new Point(new Position(16, 10)));
        Document doc11 = new Document("name", "Kacie").append("location", Arrays.asList(6, 10)).append("ip", new Point(new Position(6, 10)));
        Document doc12 = new Document("name", "Lacey").append("location", Arrays.asList(5, 10)).append("ip", new Point(new Position(5, 10)));
        Document doc13 = new Document("name", "Mabel").append("location", Arrays.asList(4, 10)).append("ip", new Point(new Position(4, 10)));
        Document doc14 = new Document("name", "Nadia").append("location", Arrays.asList(17, 10)).append("ip", new Point(new Position(17, 10)));
        Document doc15 = new Document("name", "Obadiah").append("location", Arrays.asList(3, 10)).append("ip", new Point(new Position(3, 10)));
        Document doc16 = new Document("name", "Paddy").append("location", Arrays.asList(18, 10)).append("ip", new Point(new Position(18, 10)));
        mc.insertMany(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8, doc9,doc10,doc11,doc12,doc13,doc14,doc15,doc16));

        mc.createIndex(geo2d("location"));
        mc.createIndex(geo2dsphere("ip"));
	    
	  //$geoWithinCenter 在指定圆心和半径的圆形内搜索
	    FindIterable<Document> iterable = mc.find(Filters.geoWithinCenter("ip", 10d, 10d, 5));
	    printResult("Filters.geoWithinCenter ip", iterable);
		
		
	}
	public static void printResult(String doing, FindIterable<Document> iterable) {
        System.out.println(doing);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

}
