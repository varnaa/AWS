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


### IGW - Internet Gateway
AWS definition: An internet gateway is a horizontally scaled, redundant and highly available vpc component that allows communication between the instances in your VPC and the internet. Therefore imposes no availability risks or bandwidth constraints on the network traffic.

- A VPC can only have 1 Internet Gateway at any given time.
- An IGW cannot be detached from a VPC while there are active AWS resources in the VPC ( such as EC2 instance or RDS )


---

### Route Tables (RTs)
- Route tables contains a set of rules called routes, that are used to determine where the network traffic is directed.

![Route table](https://github.com/varnaa/AWS/blob/master/src/main/java/org/varnaa/acloudguru/awsEssentials/chapter4/screenshots/routeTable.png)


---

### Network Access Control Lists (NACLs)
AWS Definition - Optional layer of security to your VPC that acts as a firewall for controlling traffic in and out of one or more subnets.

![NACL](https://github.com/varnaa/AWS/blob/master/src/main/java/org/varnaa/acloudguru/awsEssentials/chapter4/screenshots/nacl.png)

---

### Subnets

#### Simplified Definition:
A subnet, shorthand for subnetwork, is sub-section of network. Generally, a subnet includes all the computers in a specific location.


### AWS Definition:
When you create a VPC, it spans all the availability Zones in the region. After creating a VPC, you can add one or more subnets in each availability Zone. Each subnet must reside entirely within one Availability Zone and cannot span Zones.


![subnets](https://github.com/varnaa/AWS/blob/master/src/main/java/org/varnaa/acloudguru/awsEssentials/chapter4/screenshots/subnets.png)

---

### Availability Zones

![NACL](https://github.com/varnaa/AWS/blob/master/src/main/java/org/varnaa/acloudguru/awsEssentials/chapter4/screenshots/az.png)


---
