#### What is the default permission assigned for AWS IAM users to all AWS resources?
All AWS IAM users are denied access to all AWS resources by default.  All permissions must be explicitly set to deny access to any AWS resources. This meets the requirement for granting only the permissions necessary for completing the required task.

#### AWS IAM user accounts are applied at what level?
All AWS IAM accounts are global. Once created, the AWS IAM users access any service or resource that AWS offers globally, as along as security permissions allow access to that resource.

#### Which of the following does MFA use to provide additional security to an AWS account?
MFA uses time-based codes to provide additional security to your AWS account. There are both virtual hardware MFA device (Google Authenticator), and hardware MFA devices such as a Gemalto token.

#### As a best practice, what is the best way to assign the same permissions to an AWS resource for multiple users?
Assign the user accounts to the appropriate group, and apply the AWS IAM policy to the group. This is the correct answer. By putting the IAM user account into a group and applying the AWS IAM policy to the group, you'll only have to set permissions once, instead of on each individual user.
