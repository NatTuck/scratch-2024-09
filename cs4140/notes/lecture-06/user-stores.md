
# User Stores

A user story should be:

 * Something that the customer (and thus, hopefully, the end user) wants.
 * Something that a developer can complete reasonbly quickly (about a week of work, at most).
 * That work should be deployable, and th customer should be able to try it and confirm
   they got what they want.

Standard format:

    As a [what kind of user]
    I want to [action / task]
    So that [benefit]
    
    When I [action]
    This happens: [intended outcome]

For example, in a task tracking app:

    As a normal user
    I want to mark tasks as done
    So that I can focus on tasks I haven't done yet.
    
    When I click the task finished button
    This happens: The task is visually marked as done, and bumped down
        below incomplete tasks on the task list.

Points:

 - Each user story is worth some number of points.
 - This is an estimate of how much work it will take.
   - What they mean is vague.
   - Maybe 1 point is one hour of work, or the points for a story are log2(# of hours).
   - As long as point assignments are monotonic, it's probably fine.
   - Not intended to be perfect time quantities, because perfect estimations are impossible
     and pretending that it's possible with excess precision is misleading. 

Our Kanban Board tool calls *everthing* it tracks a user story.

Special cases:

 - A story that's too big to complete in a week should be split up into smaller stores.
 - Bugs produce issues on Github.
   - These generally translate fine into user stories ("As a user, I want the app to not break...")
 - Sometimes there are tasks that really need to get done but aren't user initiated. In that case,
   you might get a developer story ("As a developer, I want the app to not crash and restart when
   the database is slow...")
   

# Kanban Board

We're going to use a Kanban Board tool to manage user stores (taiga.io),

Columns:

 - NEW
   - New stories go in NEW
   - Stories that aren't actively being worked on and no longer meet the requirements
     to be READY go back in NEW.
 - READY
   - Criteria:
     - There's a benefit to actually doing this now.
     - It has clear acceptance critera:
       - What will be tested
       - Who will test (preferably the customer, not the developer who wrote the code)
     - External dependencies defined and met
     - Points are estimated 
 - IN PROGRESS
   - Somebody is working on this
   - Typically each developer has exactly one IN PROGRESS story.
 - READY FOR TEST
   - The assigned developer thinks this story is done (typically because they've
     manually tested it according to the acceptance critera and it seems fine).
   - When a story moves to READY FOR TEST, make sure to add a comment linking to
     the Github pull request that finished it.
   - The feature may or may not have been merged on Github and deployed to a server.
 - DONE
   - The code has been merged into the primary Git repo.
   - The code has been deployed to the server.
   - A person - not the developer who worked on it, optimally the customer - has manually
     gone through the acceptance test on the live instance and confirmed the story works.
  


# Github process

 - Developer works on personal fork of project checked out (cloned) to local machine.
 - To deal with a story from the Kanban board they start by creating a feature branch.
 - The write code locally to implement the feature.
 - They write automated tests to test the feature and confirm they pass.
 - They manually do the acceptance testing procedure locally.
 - They push to Github and do a pull request to main repository.
 - The feature is merged (by another developer).
 - The feature is deployed to a live server.
   - This could a dedicated test server.
   - It could be your live production server.
 - The feature is acceptance tested after initial deployment.
   - If it's not good, then it gets sent back for more work.
   - Don't delete the feature branch until after acceptance testing.
 - If there's a test environment, then there's an extra step of deploying to production
   after additional maual testing. 
 
 
According to @stahnma on Twitter:
 
  "Everyone has a testing environment. Some people are lucky enough to have a totally
   separate production enivironment to run production in."
   
 
