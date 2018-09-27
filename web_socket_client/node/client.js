/*
 * Requirements: nodejs v6+
 * npm install ws
 * node web_socket_client/node/client.js
 */

const WebSocket = require("ws");

const ws = new WebSocket("ws://localhost:9000");

ws.on("open", () => {
  let count = 0;
  setInterval(() => {
    console.log(`Sending ${count}`);
    ws.send(count.toString());
    count++;
  }, 1000);
});
