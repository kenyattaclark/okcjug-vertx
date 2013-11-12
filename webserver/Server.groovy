vertx.createHttpServer().requestHandler { request ->
	def file = request.uri == "/" ? "index.html" : request.uri
	request.response.sendFile "web/$file"
}.listen(8080)