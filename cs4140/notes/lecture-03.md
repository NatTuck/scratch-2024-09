

## Scrum

Development is divided into "sprints", a week or two long each.

For each sprint:

 - The team starts with a working program.
 - Each team member is assigned a task to work on.
 - Each team member completes their assigned task.
 - That work is merged together into a new working program.
 - That new working program is used as the start of the next sprint.

Specific concepts and rituals:

 - Daily stand up meeting
 - Some people have specific roles:
   - "Scrum master"
   - "Project owner"
   - etc



## Git

Version control:

 - Once you two people on a team, you can get conflicts if they
   both try to make changes at the same time.

Plan A: Centralized Version Control

 - There's a server that stores the canonical version of the program.
 - People make local copies to edit.
 - They send their changes back to the server to update the canonical
   copy.


Plan B: Distributed Version Control

 - Git was the first major example of this
 - Same as centralized version control, just with no central server. 
 - Everyone gets their own source control repository, which means
   they have their own personal canonical copy of the program.
 - Concept: Branch
   - A different version of the program within a repository
     generally created to make some concrete change.
 - Concept: Fork
   - An entirely seperate repository, copying some set of
     branches from a parent repository and allowing new local branches.
 - Concept: Merging
   - A branch can be merged with another branch:
     - e.g. alice/feature-1 can be merged into alice/main
 - Merges can be done across repositories / forks.
 



