import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;
import java.util.List;

import static com.mongodb.client.model.Aggregates.*;


public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");

        MongoCollection<Document> cliente = mongoDatabase.getCollection("cliente");
        MongoCollection<Document> animal = mongoDatabase.getCollection("animal");

        //INSERT
        Document novoCliente = new Document("_id", 1)
                .append("nome", "Maria")
                .append("quantidade_pedidos", 3)
                .append("valor_pagamento", 22)
                .append("email", "teste@teste")
                .append("id_usuario", 1);

        Document novoCliente2 = new Document("_id", 2)
                .append("nome", "Gabriela")
                .append("quantidade_pedidos", 1)
                .append("valor_pagamento", 24)
                .append("email", "teste@teste")
                .append("id_usuario", 2);

        Document novoCliente3 = new Document("_id", 3)
                .append("nome", "Antônio")
                .append("quantidade_pedidos", 1)
                .append("valor_pagamento", 20)
                .append("email", "teste@teste")
                .append("id_usuario", 3);

        Document novoCliente4 = new Document("_id", 4)
                .append("nome", "Helenice")
                .append("quantidade_pedidos", 2)
                .append("valor_pagamento", 40)
                .append("email", "teste@teste")
                .append("id_usuario", 4);
        //1
        cliente.insertMany(List.of(novoCliente, novoCliente2, novoCliente3, novoCliente4));

        Document novoAnimal = new Document("_id", 1)
                .append("id_cliente", 1)
                .append("nome", "Whiskey")
                .append("tipo", "Gato")
                .append("raca", "Indefinido")
                .append("pelagem", 0)
                .append("porte", 2)
                .append("idade", 2);

        Document novoAnimal2 = new Document("_id", 2)
                .append("id_cliente", 2)
                .append("nome", "Rex")
                .append("tipo", "Cachorro")
                .append("raca", "Indefinido")
                .append("pelagem", 1)
                .append("porte", 0)
                .append("idade", 3);

        Document novoAnimal3 = new Document("_id", 3)
                .append("id_cliente", 3)
                .append("nome", "Jota")
                .append("tipo", "Gato")
                .append("raca", "Indefinido")
                .append("pelagem", 0)
                .append("porte", 0)
                .append("idade", 5);
        //2
        animal.insertMany(List.of(novoAnimal, novoAnimal2, novoAnimal3));


        //FIND
        //1
        Document findAnimal1 = animal.find(new Document("tipo", "Gato")
                .append("idade", new Document("$gt", 1))).first();
        System.out.println(findAnimal1);

        //2
        animal.find(new Document("$or", List.of(
                        new Document("porte", new Document("$gte", 1)),
                        new Document("pelagem", new Document("$gte", 1)))))
                .sort(Sorts.ascending("idade"))
                .iterator()
                .forEachRemaining(System.out::println);

        //3
        cliente.find()
                .sort(Sorts.descending("quantidade_pedidos", "valor_pagamento"))
                .iterator()
                .forEachRemaining(System.out::println);

        //4
        cliente.find()
                .sort(Sorts.ascending("nome"))
                .iterator()
                .forEachRemaining(System.out::println);


        //UPDATE
        //1
        animal.updateOne(Filters.eq("_id", 3), new Document("$set", new Document("pelagem", 1).append("idade", 6)));

        //2
        animal.updateMany(Filters.eq("tipo", "Gato"), new Document("$set", new Document("pelagem", 2)));


        //AGGREGATE
        //1
        animal.aggregate(List.of(
                group("$pelagem", Accumulators.sum("count", 1))
                )).forEach(System.out::println);

        //2
        animal.aggregate(List.of(
                match(Filters.eq("raca", "Indefinido")),
                group("$tipo", Accumulators.sum("count", 1))
        )).forEach(System.out::println);


        //PROJECTION
        //1
        animal.find()
                .projection(Projections.exclude("_id", "id_cliente", "pelagem", "porte", "raca"))
                .iterator()
                .forEachRemaining(System.out::println);

        //2
        cliente.find()
                .projection(Projections.exclude("_id", "email", "id_usuario"))
                .iterator()
                .forEachRemaining(System.out::println);


        //DELETE
        //1
        cliente.deleteOne(Filters.eq("nome", "Helenice"));

        //2
        animal.deleteMany(Filters.eq("tipo", "Gato"));

    }
}
