const db = require('better-sqlite3')('user.db', {});

db.exec(`CREATE TABLE IF NOT EXISTS user (
                person_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT, 
                surname TEXT,
                ammount REAL NOT NULL);`);

let stmt = db.prepare('INSERT INTO user (name,surname,ammount) VALUES(?,?,?)');

stmt.run("test1","test1",200.0)
stmt.run("test2","test2",300.0)
