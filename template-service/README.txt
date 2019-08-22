https://teamtreehouse.com/community/nested-loops-in-flask-how-to-iterate-and-make-nested-lists

/Users/Mrudul/Documents/workspace-github/cloud-template-poc/templates/

localhost:9092/api/template-service/templates

{
  "templateName":"ec2-template.yml",
  "templatePath":"/Users/Mrudul/Documents/workspace-github/cloud-template-poc/templates/",
  "environmentName":"dev",
  "ec2Count":4,
  "s3Count": 1,
  "ec2Resource":{
    "keyName":"tutorial",
    "vpcId":"vpc-123",
    "subnetId":"168.1.1.10",
    "instanceType":"t2.micro"
  }
}

  {% set ec2list= [['1', 'keyname1', 'instanceType1'], ['2', 'keyname2', 'instanceType2']] %}
  {% for ec2 in ec2list %}
    {% for elem in ec2 %}
      Ec2Instance-{{ elem }}
    {% endfor %}
  {% endfor %}
  
  {% for ec2 in ec2list %}
      Ec2Instance-{{ ec2[0] }}
  {% endfor %}
  
  
  {% set persons = [{"name":"Ram", "email":"Ram@gmail.com"},{"name":"Bob", "email":"bob32@gmail.com"}] %}
  {% for person in {{ persons }} %}
      Ec2Instance-{{ person.name }}
      Ec2Instance-{{ person.email }}
  {% endfor %}