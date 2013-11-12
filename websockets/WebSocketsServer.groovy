import org.vertx.groovy.core.buffer.Buffer

def connections = []

vertx.createHttpServer().websocketHandler { websocket ->
	connections << websocket.textHandlerID
	
    websocket.dataHandler { data -> 
    	def message = data.getString(0, data.length)

    	for (id in connections) {
			println "id is $id and message is $data"			
			vertx.eventBus.send(id, message)
		}
    } 	
}.requestHandler { req ->
  	if (req.uri == "/") req.response.sendFile "web/ws.html"
}.listen(8080)