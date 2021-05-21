# Elastic Cloud Compute

---

### Simplified Definition

Think of EC2 as a basic desktop computer.


### AWS Definition:
"Amazon EC2 provides scalable computing capacity in the aws cloud." Launch as many as virtual servers as you need, configure security, networking and manage storage. EC2 enables you to scale up and down based on the change in requirements or spikes in popularity.


### Components Of EC2:
- Operating System
- CPU 
- Hard drive 
- Network Adapter
- Firewall
- RAM


---

### Most Common Purchasing Options:

#### On-Demand
Allows you to choose any instance type you like and provision / terminate it any time.
- Most expensive
- Most Flexible
- Charged only when the instance is running and billed by the hour.


#### Reserved
- Allows significant price discount
- Select and pay upfront or half upfront or no upfront.
- Once you buy the reserved instance, you own it for the selected time period and are responsible for the entire price - regardless how often you use it.


#### Spot
Spot pricing is way for you to "Bid" on an instance type, then only pay for and use that instance when the spot price is equal or below the amount of your "bid" price.

- Allows amazon to sell the use of unused instances for the short amount of time at a substantial discount.
- Spot prices fluctuate based on the supply and demand in the spot marketplace.
- Charged by the minute.
- Automatically terminates when the spot price is greater than your bid price.

---

### Types of Instances:
Instance Type determines the hardware present in the EC2 instance that is launched. They can differ in memory, storage and capabilities.
- General Purpose
- Accelerated Computing
- Compute Optimized
- Storage Optimized
- Memory Optimized


---

## AMI - Amazon Machine Images

### Simple definition:
An "Operating System"

### Amazon Definition:
Amazon machine image provides the information required to launch an instance, which is a virtual server in the cloud. One can launch as many instances from the AMI as they need. Or use different AMI for different servers.

- When you create an AMI, you are essentially creating a template that you can use to launch another EC2 instance that has the exact same components as the original.
