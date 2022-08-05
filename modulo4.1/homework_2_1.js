db.cliente.insertMany([
    {_id: 1,
    nome: "Maria", 
    quantidade_pedidos: 3, 
    valor_pagamento: 22, 
    email: "teste@teste",
    id_usuario: 1
   },
    {_id: 2,
    nome: "Antônio",
    quantidade_pedidos: 1,
    valor_pagamento: 24,
    email: "teste@teste",
    id_usuario: 2
   },
   {_id: 3,
    nome: "Gabriela",
    quantidade_pedidos: 1,
    valor_pagamento: 20,
    email: "teste@teste",
    id_usuario: 3
   },
 ])

 db.cliente.insertOne(   
    {_id: 4,
    nome: "Helenice",
    quantidade_pedidos: 2,
    valor_pagamento: 40,
    email: "teste@teste",
    id_usuario: 4
    }
)

 db.animal.insertMany([
    {_id: 1,
    id_cliente: 1,
    nome: "Whiskey",
    tipo: "Gato",
    raca: "Indefinido",
    pelagem: 0,
    porte: 2,
    idade: 2
    },
    {_id: 2,
    id_cliente: 2,
    nome: "Rex",
    tipo: "Cachorro",
    raca: "Indefinido",
    pelagem: 1,
    porte: 0,
    idade: 3
    },
    {_id: 3,
    id_cliente: 3,
    nome: "Jota",
    tipo: "Gato",
    raca: "Indefinido",
    pelagem: 0,
    porte: 0,
    idade: 5
    }
])

//Find
db.animal.find({tipo: "Gato", idade: {$gt: 1}})
db.animal.find({$or: [{porte: {$gte: 1}}, {pelagem: {$gte: 1}}]}).sort({idade: 1})
db.cliente.find({}).sort({quantidade_pedidos: -1, valor_pagamento: -1})
db.cliente.find({}).sort({nome: 1})

//Update
db.animal.updateOne(
    {_id: 3},
    {$set: {pelagem: 1, idade: 6}}
)
db.animal.updateMany(
    {tipo: "Gato"},
    {$set: {pelagem: 2}}
)

//Projection
db.animal.find({}, {_id: 0, tipo: 1, nome: 1, idade: 1})
db.cliente.find({}, {_id: 0, nome: 1, quantidade_pedidos: 1, valor_pagamento: 1}).sort({valor_pagamento: -1})

//Agreggate
db.animal.aggregate([
    {$group: {_id: "$pelagem", countQuantity: {$count: {}}}}
])
db.animal.aggregate([
    {$match: {raca: "Indefinido"}},
    {$group: {_id: "$tipo", countQuantity: {$count: {}}}}
])

//Delete
db.cliente.deleteOne({nome: "Helenice"})
db.animal.deleteMany({tipo: "Gato"})
