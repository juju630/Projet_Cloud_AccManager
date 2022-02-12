//Express

const express = require('express')
const app = express()
app.use(express.json())
app.use(express.urlencoded())
const port = 3000

//DB

const db = require('better-sqlite3')('user.db', {});

app.get('/user', (req, res) => {
  let users = db.prepare("SELECT * FROM user").all()

  res.send(users);
})

app.post('/user', (req, res) => {
    let body = req.body;

    console.log(body);

    if("name" in body && "surname" in body && "ammount" in body){
        db.exec("INSERT INTO user (name,surname,ammount) VALUES ('" + body.name + "','" + body.surname + "','" + body.ammount + "');");
        res.status(201).send("User added");
        return
    }
    else{
        res.sendStatus(422)
        return
    }

    
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})