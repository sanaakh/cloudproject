# lsi1

### Coding rules

Exception HTTP Handler: https://github.com/charroux/st2scl/blob/main/rentalService/src/main/java/com/example/rentalService/web/CarNotFoundException.java

Logger: https://github.com/charroux/lsi1/blob/main/src/main/java/com/example/lsi1/web/RentalWebService.java

### Launch a workflow when the code is updated

The script is there: https://github.com/charroux/lsi1/blob/main/.github/workflows/action.yml
Create a new branch:
```
git branch newcarservice
```
Move to the new branch:
```
git checkout newcarservice
```
Update the code and commit changes:
```
git commit -a -m "newcarservice"
```
Push the changes to GitHub:
```
git push -u origin newcarservice
```
Create a Pull request on GitHub and follow the workflow.

Merge the branch on Github is everything is OK.

Then pull the new main version:

```
git checkout main
```
```
git pull origin main
```

If necessary delete the branch:

```
git branch -D newcarservice
```
```
git push origin --delete newcarservice
