# Content Manager API
I have a blog class which defines the attributes of a blog:
- id
- date
- author
- title
- content

I have a blogService class which has the methods that can be carried out on the blog. Also has a collection of blog.

The blogController calls the service to do stuff to the blog and create mappings to different endpoints.

03/11/2023, So far:
I've created the blog class, blogService and the CRUD methods, BlogController and endpoints

I need to:
- Research Response Entities so my endpoints can return the right status codes (especially when id is not found, e.g. 404)
- Write tests for the methods and endpoints.


Further TO DO
- Sorting the blog posts by date
- Handling exceptions - make sure string is entered, valid date etc..
- Build my JSON database 
- ... JSON issues

