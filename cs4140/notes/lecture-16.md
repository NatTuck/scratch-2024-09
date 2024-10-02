
# CRUD Resources

Idea: The core of the design of our application is the persistent data we're managing and how
we structure / decompose that data.

Phoenix provides support for a common data model:

 - Our persistent data is stored as a collection of "resources".
 - Each resource has:
   - A database table, each row is one record.
   - A schema, mapping database rows to Ecto structs. In an OO framework,
     these structures would be called "model objects".
   - One or more controllers, providing web paths to access and manipulate
     this kind of data.
   - Controllers have associated templates, to render web pages (or maybe something else).
 - This gives us a default application structure sometimes called CRUD.
   - Create
   - Retrieve
   - Update
   - Delete
 - Simple CRUD apps aren't very interesting. We could just us a database management tool.
   - Our unique application logic tends to be either in addition to CRUD operations or
     restrictions on those operations.
 - Phoenix provides generators to generate CRUD code for resources.
 - More specifically, this code follows a pattern called REST, with five operations:
   - List (index)
   - Show
   - Create
   - Update
   - Delete
 - In a traditional web interface, we need a route/path for those five operations, plus
   two more paths:
   - New (the form for create)
   - Edit (the form for update)
 - The REST structure isn't limited to web interfaces, the same five operations make a good
   structure for API endpoints.
   - A REST API typically uses JSON, but could be something else like XML.
   - We can use this to access a resource from JavaScript code on our website, like for
     a single-page application.
   - We could have a separate web site that accesses the API.
   - We could use a mobile app as our front end. Or, we could build a desktop app.
   - Or for a fully machine-to-machine API scenario.
   

Today's example code: https://github.com/NatTuck/party_animal/tree/add-invites-and-api
   
   

 
 
 
