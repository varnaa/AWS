# Virtual Private Cloud (VPC)

---

- VPC can be defined as private sub-section of AWS that you control, in which you can place AWS resources like EC2 instances and databases.

---

#### AWS Definition:
VPC lets you provision a logically isolated section of the AWS cloud, where you can launch AWS resources in a virtual network that you define. You have complete control over your virtual networking environment, including selection of your own IP address, range, creation of subnets and configuration of route tables and network gateways.


----

### AWS Global Infrastructure

### Regions
- Grouping of AWS resources located in a specific geographically location
- Comprised of multiple availability zones

### Availability Zones
- Geographically isolated zones within a region that house AWS resources
- Where physical AWS data centers are situated

### Data centers
- Physical data centers.

---

![Graphical representation](https://github.com/varnaa/AWS/blob/master/src/main/java/org/varnaa/acloudguru/awsEssentials/chapter4/screenshots/vpc_1.png)


---

### Standard Components that are need to make a VPC functional:
- Internet Gateway (IGW)
- A route table ( with predefined routes to the default subnets)
- A network Access control List ( with predefined rules for access )
- Subnets to provision AWS resources in (such as EC2 instances)

---
