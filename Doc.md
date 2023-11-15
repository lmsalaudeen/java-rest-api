# Blog Manager API
I have a blog class which defines the attributes of a blog:
- id
- date
- author
- title
- content

I have a blogService class which has the methods that can be carried out on the blog. 

The blogController calls the service to do stuff to the blog and create mappings to different endpoints.

I have a JSONHandler which handles serialisation and deserialization of my json file (the in-memory repository).

I have an Algorithm class that has methods to search terms in blog content and blog author and sort blog posts by date.

## The Endpoints
- /blog/blogs: returns all blogs
- /blog/blogs/author=author: return blogs with specified authors
- /blog/blogs/orderByOldest: returns all blogs ordered from oldest to most recent
- /blog/blogs/orderByLatest: returns all blogs ordered from most recent to oldest
- /blog/id: returns a blog with specified id
- /blog: create a blog post
- /blog/id: update a blog with specified id
- /blog/id: delete a blog with specified id
- /blog/blogs/keyword=keyword: return blogs with specified keyword in content

