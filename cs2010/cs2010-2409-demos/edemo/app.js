
let express = require('express');
let app = express();
let port = 3000;

function rootPath(req, res) {
  res.send(`
  <!doctype html>
  <form action="/hello" method="post">
  <p><input type="text" name="name"></p>
  <p><button>Send</button></p>
  </form>
  `);
}

app.get('/', rootPath);

function getHello(req, res) {
  let name = req.query.name;
  console.log(name);
  res.send(`
  <!doctype html>
  <p>You sent a GET request to /hello</p>
  <p>The query was ${name}</p>
  `);
}

app.get('/hello', getHello);

let bodyParser = require('body-parser');
let parser = bodyParser.urlencoded({ extended: false });

function postHello(req, res) {
  let name = req.body.name;
  console.log(req);
  res.send(`
  <!doctype html>
  <p>You sent a POST request to /hello</p>
  <p>The query was ${name}</p>
  `);
}

app.post('/hello', parser, postHello);

function startup() {
  console.log("Web app is started, connect on http://localhost:3000/");
}

app.listen(port, startup);
