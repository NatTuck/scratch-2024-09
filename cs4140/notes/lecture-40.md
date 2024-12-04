
# Semester Review

## Final Presentations

 - Friday the 13th, 9am - 10:30am
   - Block starts at 8, we're coming in late because that's too early.
   - But be on time at 9.
 - Assignments are posted, due Thursday at midnight (hard deadline).
 
Next lecture: Final meeting 



## Today: Semester Review

### Software Development: Agile Methods

 - Kanban Board
   - Helps visualize process, to allow for process improvements
 
What Agile isn't: Upfront design

 - Upfront design reqires collecting complete requirements in advance.
 - You also need to know how to solve the problem you're solving.
 
Instead: Focus on iteration with changing / unknown requirements and a clueless customer.

 - You need to actually talk to the customer.
 - You want to deliver (partially) working software as quickly as possible for feedback.
 - Get feedback from the customer on new features.
 - Quickly iterate and do it again.

Another set of tools: Scrum


### Git & Github

 - Distributed version control
   - Every computer has a repository with versions, branches, etc.

We don't need a centralized server, but Github is convenient.

Github workflow:

 - fork, local clone, feature branch, changes, pull request, code review, merge



### Web Development

Server:

 - You're writing an HTTP server
 - Simple model: a function of request -> response
 - Response could be HTML, or JSON, or an image, or a redirect
 - Frequently we have a DB for persistent state
 - Frameworks

Browser:

 - HTML / CSS / JavaScript
 - JavaScript can be simple, enhancing HTML/CSS content.
 - Or complex, basically completely defining the app UI.
   - At that point we want a rendering / template library.
   - Or even a full framework. 


### Taiga.io

 - Gave us a Kanban Board
 
 

## User Stories

A scenario that can be enabled in software, implying a new feature or change to existing features, that:

 - Describe a plausble applicatoin user who wants to do something.
 - Describe how the functionality could be tested.
 - Optimally, is small enough to finish in one development iteration.
 
 
 
### Elixir / Phoenix

Elixir:

 - A functional programming language
 - Built on the Erlang VM
 - Good at I/O, string handling, concurrency, error recovery.
 - This is good for web apps, espeiclaly with real-time featurs through WebSockets.

Phoenix:

 - A web dev framework, providing all the basic stuff for a server-side web app.
 
 
 
### Web App Deployment 

 - Need a server to deploy to. Modern VPSes are nice.
 - Linux works pretty well on servers - get to practice systems administration. 
 - The app can use a whole server, or we can do multiple apps per server with
   some isolatoin mechanism. If isolaiton matters, it's worth thinking explicitly
   about threat models.
 - App is a web server running on a high port behind a reverse proxy (like Nginx).

Deployment process:

 - Where do we do the build step?
 - Assets?
 - Dev vs prod?
 


### CI / CD

Automated testing:
 
 - Check for regressions.
 - Verify that there aren't syntax errors and all the code can run, especially
   with dynamic languages.
  
Automated deployment:

 - Brave people automatically deploy to production.
 - Cowards get a separate testing server to deploy to.


### Functional programming

A programming style that focuses on data and transformatoins of data. This contrasts with OO style,
which models objects with both data and behavior.

Two core concpets: immutable data, pure functions

Immutable data:

 - Data is conceptually values. A variable holds a value.
 - Once a value is constructed, it can't be changed.
 - If you want a different value, build a new one.
 - This makes things easier ot reason about.
 - This sounds less efficinet, but can enable some optimization (e.g. caching) and generally
   when it does slow things down it's only by O(log n).







