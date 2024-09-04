
# Lecture 4: Web App Concepts

The Web?

 - A bunch of web sites.
 - A set of standards for making a global, interconnected set web sites
   - Data formats recognized by web browsers
   - A protocol: HTTP, Hyper Text Transfer Protocol
 
Web site?

 - A bunch of web pages.
 - Typically served by an HTTP server program running on a computer, called a server.
 - A traditional HTTP server gets pointed at a directory with files in it and sends
   those files on request:
   - The directory is called the document root. e.g. /home/nat/Code/scratch-2024-09/cs4140/notes/lecture-04
   - The server accepts requests with paths relative to the docroot and sends those files in response.
     - GET /notes.md HTTP/1.0   => /home/nat/Code/scratch-2024-09/cs4140/notes/lecture-04/notes.md
 
Web page?

 - An HTML document
   - Rendered in a Web Browser
 - + CSS, JavaScript
 - + Images (JPEG, PNG, WEBP, GIF)
 - + Multimedia Stuff
 - + Random Stuff (like PDF)

Web Application?

**On the Server**

 - Looks like a traditional website.
 - But the server doesn't nessisarily just send files on request.
 - We can write our own web server, and we can respond to requests however we want.
   - Since the server program just has to speak HTTP and send valid web content, it can
     be in any programming language, etc. 

**In the Browser**

 - The browser can run JavaScript code.
 - We can do lots of stuff on the user's computer.
 - Our JavaScript code can make HTTP requests to our server code. 
 

Web application framework?

 - Web server programs aren't innately constrained in structure or function.
 - But they all have some pretty typical problems to solve.
 - A Web App Framework is:
   - A collection of libraries
   - Typically for some programming language
   - And a project template / structure for building a server app
 - Common problems to solve:
   - Routing: How do we get from a request to the code to handle the request?
     - e.g. In PHP, we send a request to "/hello.php" to code in a file called "hello.php"
   - Controller: When a request is made, what code actually gets executed to decide how
       to respond.
   - Database interface: Provides an abstraction over database access so you aren't typing
       SQL manually all the time to do everything.
       (e.g. An ORM (object-relational mapping) library.)
   - Templates: Code that generates HTML for a web page to show the user.
   - Asset Pipeline: Manage shared CSS / JavaScript / Images / Fonts / etc for your
       application. 


