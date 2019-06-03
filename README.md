Stack trace:

```
org.springframework.web.client.ResourceAccessException: I/O error on GET request for "https://17fbd0e1.ngrok.io:9443/api/websocket/info": sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target; nested exception is javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:696) ~[spring-web-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.client.RestTemplate.execute(RestTemplate.java:662) ~[spring-web-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport.executeInfoRequestInternal(RestTemplateXhrTransport.java:137) ~[spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.sockjs.client.AbstractXhrTransport.executeInfoRequest(AbstractXhrTransport.java:129) ~[spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.sockjs.client.SockJsClient.getServerInfo(SockJsClient.java:296) ~[spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.sockjs.client.SockJsClient.doHandshake(SockJsClient.java:262) ~[spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.messaging.WebSocketStompClient.connect(WebSocketStompClient.java:274) [spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.messaging.WebSocketStompClient.connect(WebSocketStompClient.java:255) [spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.messaging.WebSocketStompClient.connect(WebSocketStompClient.java:235) [spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.socket.messaging.WebSocketStompClient.connect(WebSocketStompClient.java:219) [spring-websocket-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at com.example.demo.SocketRunnable.run(SocketRunnable.java:31) [classes/:na]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_212]
Caused by: javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	at sun.security.ssl.Alerts.getSSLException(Alerts.java:192) ~[na:1.8.0_212]
	at sun.security.ssl.SSLSocketImpl.fatal(SSLSocketImpl.java:1946) ~[na:1.8.0_212]
	at sun.security.ssl.Handshaker.fatalSE(Handshaker.java:316) ~[na:1.8.0_212]
	at sun.security.ssl.Handshaker.fatalSE(Handshaker.java:310) ~[na:1.8.0_212]
	at sun.security.ssl.ClientHandshaker.serverCertificate(ClientHandshaker.java:1639) ~[na:1.8.0_212]
	at sun.security.ssl.ClientHandshaker.processMessage(ClientHandshaker.java:223) ~[na:1.8.0_212]
	at sun.security.ssl.Handshaker.processLoop(Handshaker.java:1037) ~[na:1.8.0_212]
	at sun.security.ssl.Handshaker.process_record(Handshaker.java:965) ~[na:1.8.0_212]
	at sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:1064) ~[na:1.8.0_212]
	at sun.security.ssl.SSLSocketImpl.performInitialHandshake(SSLSocketImpl.java:1367) ~[na:1.8.0_212]
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1395) ~[na:1.8.0_212]
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1379) ~[na:1.8.0_212]
	at sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:559) ~[na:1.8.0_212]
	at sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:185) ~[na:1.8.0_212]
	at sun.net.www.protocol.https.HttpsURLConnectionImpl.connect(HttpsURLConnectionImpl.java:162) ~[na:1.8.0_212]
	at org.springframework.http.client.SimpleBufferingClientHttpRequest.executeInternal(SimpleBufferingClientHttpRequest.java:76) ~[spring-web-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.http.client.AbstractBufferingClientHttpRequest.executeInternal(AbstractBufferingClientHttpRequest.java:48) ~[spring-web-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.http.client.AbstractClientHttpRequest.execute(AbstractClientHttpRequest.java:53) ~[spring-web-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:687) ~[spring-web-5.0.9.RELEASE.jar:5.0.9.RELEASE]
	... 11 common frames omitted
Caused by: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	at sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:397) ~[na:1.8.0_212]
	at sun.security.validator.PKIXValidator.engineValidate(PKIXValidator.java:302) ~[na:1.8.0_212]
	at sun.security.validator.Validator.validate(Validator.java:262) ~[na:1.8.0_212]
	at sun.security.ssl.X509TrustManagerImpl.validate(X509TrustManagerImpl.java:324) ~[na:1.8.0_212]
	at sun.security.ssl.X509TrustManagerImpl.checkTrusted(X509TrustManagerImpl.java:229) ~[na:1.8.0_212]
	at sun.security.ssl.X509TrustManagerImpl.checkServerTrusted(X509TrustManagerImpl.java:124) ~[na:1.8.0_212]
	at sun.security.ssl.ClientHandshaker.serverCertificate(ClientHandshaker.java:1621) ~[na:1.8.0_212]
	... 25 common frames omitted
Caused by: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	at sun.security.provider.certpath.SunCertPathBuilder.build(SunCertPathBuilder.java:141) ~[na:1.8.0_212]
	at sun.security.provider.certpath.SunCertPathBuilder.engineBuild(SunCertPathBuilder.java:126) ~[na:1.8.0_212]
	at java.security.cert.CertPathBuilder.build(CertPathBuilder.java:280) ~[na:1.8.0_212]
	at sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:392) ~[na:1.8.0_212]
	... 31 common frames omitted
```
