#!/usr/bin/env python

# Requirements: Python 3.6
# pip install websockets
# https://websockets.readthedocs.io/en/stable/intro.html

import asyncio
import websockets

async def send():
  async with websockets.connect("ws://localhost:9000") as websocket:
    count = 0
    while True:
      print(f"Sending {count}")
      await websocket.send(bytes(str(count), "utf8"))
      count += 1
      await asyncio.sleep(1)

if __name__ == "__main__":
  asyncio.get_event_loop().run_until_complete(send())
