/*
 * Requirements: nodejs v6+
 * npm install ws
 * node web_socket_server/node/server.js
 */

const WebSocket = require("ws");

const wss = new WebSocket.Server({ port: 9000 });
console.log("Listening on port 9000");

wss.on("connection", ws => {
  ws.on("message", message => {
    console.log("Received %s", message);
  });
});
