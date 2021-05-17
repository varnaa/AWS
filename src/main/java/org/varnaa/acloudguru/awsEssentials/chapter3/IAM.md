#IAM 

> IAM - Identity and Access Management

IAM stands for Identity and Access management, it is where you manage your AWS users, and their access to AWS accounts and services.

AWS IAM is used to create and manage user accounts and groups, and policies are used to grant access to AWS services and resources.

You can create a password policy that controls minimum password length and requirements for specific character types, i.e. upper case letters, lower case letters, numbers, non-alphanumeric, etc.

#### IAM is commonly used to manage:
- users
- Groups
- IAM Access Policies
- Roles 


#### IAM Best Practices
- Delete your root access keys
- Activate MFA (Multi-Factor Authentication)
- Create Individual IAM users
- Use groups to assign permissions
- Apply an IAM password policy


#### IAM Roles

An IAM role is an IAM identity that you can create in your account that has specific permissions. An IAM role is similar to an IAM user, in that it is an AWS identity with permission policies that determine what the identity can and cannot do in AWS. However, instead of being uniquely associated with one person, a role is intended to be assumable by anyone who needs it. Also, a role does not have standard long-term credentials such as a password or access keys associated with it. Instead, when you assume a role, it provides you with temporary security credentials for your role session.

You can use roles to delegate access to users, applications, or services that don't normally have access to your AWS resources. For example, you might want to grant users in your AWS account access to resources they don't usually have, or grant users in one AWS account access to resources in another account. Or you might want to allow a mobile app to use AWS resources, but not want to embed AWS keys within the app (where they can be difficult to rotate and where users can potentially extract them). Sometimes you want to give AWS access to users who already have identities defined outside of AWS, such as in your corporate directory. Or, you might want to grant access to your account to third parties so that they can perform an audit on your resources.

For these scenarios, you can delegate access to AWS resources using an IAM role. This section introduces roles and the different ways you can use them, when and how to choose among approaches, and how to create, manage, switch to (or assume), and delete roles.