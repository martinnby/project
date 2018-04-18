# project

Backgound:
A Technical Assignment to cousme MAS Web API.

Technical Design and constraint:
1. Java 1.8 and Maven 3.3.9.

2. Use Jersey RESTful Framwork to build a simple REST adaptor API (Facade design Pattern and Adaptor) to access the "data" directly and transfer the data object from the Restful server to the client. The design is also losely coupled from other component such as communication handler and deserializer. Developer only need to focus on the business data structure and business process design. Another 
key point is that, Jersey can work with Jackson Json, a lightweight, fast library to serialize/desialize the message (RESTful/JSON) without coding effort. It is identify by annotation for all binding/unbinding of the message to java object.

object > "Rest Adaptor(Jersey) > object

3. The overall architecture adopt concept of MVC, although it is not strict follow the structure as lacking of using of web application technology. The key is for easier replacement of the components if change of technology to access via web application.

4. The data transfer object between RESTful server and client is a composist design pattern and the design for this app is also based on the same data structure. It consist of 1 single object of response and the response info and result is composist to it.

Response > Result > Records is a template for fata structure of different RESTful API.

4. Singleton Object on Rest Adaptor to support Object Pooling (In future).


How to build:
1. Download all the project files.
2. Make sure the internet connection is setup properly (and proxy etc).
3. Make sure your MVN is configured properly.
4. Open the command prompt. To build, under the project root folder ".", type "MVN package".
5. The builld process will copy the followig key component:
   - checkrates.jar to "."
   - CheckRates.cmd to "."
   - Other dependency jar files to ".\lib" 


How to run:
1. Under the ".\target", run CheckRate.cmd.
2. Follow the on-screen insructions.



