To configure mongodb, you need to update **values.yaml** located on chart directory.

Update **props:**  section to configure database credential and name

```yaml
props:
  mongoAdminPassword:
  mongoUserName: 
  mongoPassword:
  mongoDatabaseName: 
 ```
 
sample entry
```yaml
props:
  mongoAdminPassword:
  mongoUserName: app_user 
  mongoPassword:
  mongoDatabaseName: appdb 
 ```

> **Note:** we don't provide any password details in values.yaml, you need to work with ops team to setup the password through secretfiles.  See the next section about setting up secretfiles.

### How to use any DB catalog as embedded database in a Springboot application?

To use any of the db as embedded database, follow the below procedure.

Step 1.  Create **requirements.yaml** file in your API chart directory with following details.

```yaml
dependencies:
  - name: projectName-DBName
    version: DB Version
    repository: DB Repo URL
```

```yaml
Sample Values
dependencies:
  - name: devexp-mongodb
    version: "0.2.0"
    repository: "https://repo.east1.ncloud.netapp.com/helm-ngdc"
```

Step 2.  Update **values.yaml** with following database specific details.

Sample values
```yaml
devexp-mongodb:
  nameOverride: 'mongodb'
  props:
    mongoDatabaseName: 'apidb'
    mongoAdminUserName: admin
    mongoUserName: dbuser
 ```
> **Note:** we don't provide any password details in values.yaml, you need to work with ops team to setup the password through secretfiles.  See the next section about setting up secretfiles.

Step 3. Create secret file and send it to ops team.

Create the yaml format file with following details and update  application DB user password and send it to ops team.

```yaml
devexp-mongodb:
  props:
    mongoAdminPassword: superpassword
    mongoPassword: password
```

> **Note:** Admin password will be setup by ops team.

save the file with following name format.

  **values.\$chart.\$spacename.secret.yaml**

> **example:** values.jjj-dbaas-mongodb1.jjj-workspace.secret.yaml


![](chartname.jpg)

> **Note:** Replace \$spacename with openshift project/namespace name.

Step 4.  Send the secret files to ops team and request them to upload the files to pipeline library.

Step 5.  Once ops team completes uploading the file to pipeline library, you need to update the release pipeline to use the secret file during the deploy process.

**Click the below image to watch the video**  

[![Update rel pipeline](./images/update_rel_pipeline_logo.jpg)](https://netapp.sharepoint.com/:v:/s/DevExpTeam/EcV7ZH83P9lNnlnuxWGldtcBosbM86h4L19WLAw4sjeMGw?e=w0z7O9 "Update rel pipeline")


## How to change database user password?
	Step 1: Update the password in secret file and send it to ops team.
	
	Step 2: Ops team need to delete the existing secretfile in pipeline library secure file section.
	
	Step 3: Update the release pipeline and modify the download secret file task
	        and select the uploaded secret file from dropdown list.
	
	Step 4: Create the release to update the openshift secrets. Note this will not change the DB password.
	
	Step 5: Go to openshift console Click on Applications => Deployments => choose the DB deployment from the list => 
	        select the line with replica
	
	Step 6: Press the down arrow next to the circle to scale down the pod count 
	        to 0 and press the up arrow to bring the pod count back up.
	
	Step 7: Now the DB pod got recreated with new password. Login to database using new password and check.


**Click the below image to watch the video**

[![Change DB password](./images/change_password_logo.jpg)](https://netapp.sharepoint.com/:v:/s/DevExpTeam/ETkuqeNguO5HqsyVA4m-vRQB8exlS9EYe7YSjW3ZhV5-SQ?e=yErUAQ "Change DB password")




[mongo]: <https://www.mongodb.com/>