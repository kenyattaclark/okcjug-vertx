def client = vertx.createHttpClient().setPort(8080)

client.connectWebsocket('/') { websocket ->
  websocket.dataHandler { data ->
    println "Received data $data"
    //client.close()
  }
  websocket << 'Hello world'
}