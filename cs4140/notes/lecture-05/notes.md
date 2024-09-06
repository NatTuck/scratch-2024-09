
# Github and the Standard Github Workflow

 - Create a user account on Github (e.g. "bob")
 - Then you can create repos (e.g. "myapp")
 - You keep your project git repo at https://github.com/bob/myapp

Steps:

 - Make a personal fork of the upstream project
   - If the repo is on your account, that repo is your personal fork.
   - For more advanced situation, an org account should own the repo.
 - Clone to local workstation
 - Create feature branch
 - Make change locally
 - (Run any tests)
 - Commit
 - Push
 - Make pull request
 - Somebody else merges the pull request
   - If the repo is on your account, you need to give someone
     else permissions on the repo to do the merge.

To resolve a conflict:

 - The user who submitted the pull request that caused the conflict should fix it.
 - They should pull from upstream to their feature branch.
   - Most usefully, press the sync with upstream button on github, then
   - git checkout main
   - git pull
   - git checkout feature-branch
   - git merge main
   - Then it's broken.
   - Then they fix the file locally.
   - Then they commit and push to the feature branch again.
   - Then it's possible to merge without the conflict 




