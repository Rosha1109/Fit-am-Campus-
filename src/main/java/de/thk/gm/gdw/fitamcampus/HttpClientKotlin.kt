package de.thk.gm.gdw.fitamcampus

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(){
    val client = HttpClient.newBuilder().build()
    val uniUri = "https://www.gm.th-koeln.de/~inf3127/"
    val request = HttpRequest.newBuilder().GET().uri(URI.create(uniUri)).build()
    val response: HttpResponse<*> = client.send(request, HttpResponse.BodyHandlers.ofString())
    System.out.println(response.body())
}