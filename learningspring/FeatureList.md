1. Edit and Delete posts & comments, UnLike posts (group 2)
1. List all Posts, create a NavBar (group 1)
1. Sort and filter through all Posts (group 1)
1. User homepage/feed (group 1, 2)
1. Tagging and searching through posts (group 1)
1. Liking comments 
1. Admin interface & user roles(?) (group 2)
1. Mark posts as favourite/muted & view favourite posts (group 3)
1. User Profile, mark authors as favourites/muted (group 3)
1. Notifications (for likes & comments on your posts)
1. Email 2-factor authentication for registration, email confirmation for password reset
1. Scheduling posts & deletion
1. Attaching pictures to posts, having a profile picture for the user.

How to collaborate by depending on abstractions rather than concrete implementations?

1. Agree on a common interface
1. Make a dummy implementation
1. Program to the interface by creating a bean of the dummy implementation
1. Once the other group is done implementing the interface, replace your bean with the real implementation
1. Test Everything!

I've attached a way to do it. My handler won't work because there's no template associated with the template name I'm returning, but it illustrates the idea.