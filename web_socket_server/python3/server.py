#!/usr/bin/env python

# Requirements: Python 3.6
# pip install websockets
# https://websockets.readthedocs.io/en/stable/intro.html

import asyncio
import websockets

async def echo(websocket, path):
  async for message in websocket:
    print(f"Received {message}")

if __name__ == "__main__":
  start_server = websockets.serve(echo, "0.0.0.0", 9000)
  print("Listening on port 9000")

  asyncio.get_event_loop().run_until_complete(start_server)
  asyncio.get_event_loop().run_forever()
