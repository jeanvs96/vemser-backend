db.alunos.insertOne(
    {nome: "Jean", 
    quantidade_pedidos: 7, 
    valor_pagamento: 110, 
    email: "teste@teste",
    id_usuario: 1}
 )

 db.alunos.insertMany([
    {nome: "Maria", 
    quantidade_pedidos: 3, 
    valor_pagamento: 22, 
    email: "teste@teste",
    id_usuario: 2},
    {nome: "Antônio",
    quantidade_pedidos: 1,
    valor_pagamento: 24,
    email: "teste@teste",
    id_usuario: 3}
 ])

 db.alunos.find({})

 db.alunos.find({quantidade_pedidos: {$gt: 5}})

 db.alunos.find({nome: "Jean"})

 db.alunos.find({$or: [{nome: "Maria"}, {quantidade_pedidos: {$gt: 1}}]})