### How to configure secretfiles for sensitive data.

To setup secretfile, you need to create the yaml fo### How to configure secretfiles for sensitive data.

To setup secretfile, you need to create the yaml format file with following details and update  application DB user password and send it to ops team.

```yaml
props:
  mongoAdminPassword: 
  mongoPassword: secretpassword
 ```

> **Note:** Admin password will be setup by ops team.

save the file with following name format.

  **values.\$chart.\$spacename.secret.yaml**

> **example:** values.jjj-dbaas-mongodb1.jjj-workspace.secret.yaml


![](./images/chartname.jpg)

> **Note:** Replace \$spacename with openshift project/namespace name.

### Add secretfile to pipeline library

Send the secret files to ops team and ask them to upload to pipeline library. 

**Click the below image to watch the video**

[![Add secretfile](./images/add_secretfile_logo.jpg)](https://netapp.sharepoint.com/:v:/s/DevExpTeam/ERfGuNiavr9OkqHO0tydyt4BeFbrYj3YmJjtkbmllTyLLw?e=vQmErc "Add secretfile")


### Update release pipeline to use the secretfile.

Once secret files added to pipeline library by ops team, you need to update the release pipeline to make use of those secret files.  

**Click the below image to watch the video**  

[![Update rel pipeline](./images/update_rel_pipeline_logo.jpg)](https://netapp.sharepoint.com/:v:/s/DevExpTeam/EcV7ZH83P9lNnlnuxWGldtcBosbM86h4L19WLAw4sjeMGw?e=w0z7O9 "Update rel pipeline")

