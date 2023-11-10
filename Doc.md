# Content Manager API
I have a blog class which defines the attributes of a blog:
- id
- date
- author
- title
- content

I have a blogService class which has the methods that can be carried out on the blog. Also has a collection of blog (not anymore).

The blogController calls the service to do stuff to the blog and create mappings to different endpoints.

03/11/2023, So far:
I've created the blog class, blogService and the CRUD methods, BlogController and endpoints

07/11/2023, So far
I've just created a ContentManager interface cos I wanted to be able to create a BlogStub, so a lot of rewiring.
I've managed to use response entities which return 404 when id is not found for get and delete endpoints, put returns a 500 status code when invalid id is used. 

10/11/2023, So far
- I've created JSON File Handler class with methods to serialise and deserialise json files.
- - Questions Questions (What's a no args constructor. My blog class was not deserializing without the no args constructor)
- - I had to define a constructor with no arguments in my Blog class before I was able to read my .json file
- - Explored using @JsonDeserialize(using = InstantSerializer.class) and @JsonDeserialize(using = InstantDeserializer.class); my methods worked without them 
- I created a ContentManager interface, because I wanted to create a BlogStub in my test. Blog now implements the ContentManager interface. The issue with this is that I may have to fully define my methods in ContentManager as delete and createBlog are not working as is. OR rather than have a blogStub object, have a blogStubRepository.json which I can convert to java objects with JSONHandler
- I've created a JSON repository. In figuring out how to serialise and deserialize my JSON, I explored GSON and Jackson. I've presently decided to stick with Jackson as I found how to parse Instant.


I need to:
- Write tests for the methods and endpoints.


Further TO DO
- Sorting the blog posts by date (I could use/convert to timestamp format for a sorting algo)
- Handling exceptions - make sure string is entered, valid date etc..
- Build my JSON database 
- ... JSON issues

