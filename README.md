# GloomhavenClone
cs 401 project
Run GloomhavenClone/src/main/GloomhavenClone.java

Tasks for deadline 1: 11-21

    Join group of 3-4 students – tell me who is in the group, along with whatever username you will use on github so I know who is doing what. If you have more than one username there because of work/personal email, let me (and your group) know about that as well
    Share contact info with availability
    Set up a github project for the group:
        Someone who has more time and can get online to check for pull requests is probably best for this
        Students have told me that the repository organization that works best is to have the trunk (main branch), plus one branch per developer. This allows you to show you have been doing work even if that work does not get into the final project code
            You should still be only uploading code that compiles, but any mistakes that might break the build are localized to the developer’s branch
        Try to find one time a week when you can all meet on Zoom or something like that, even an old-fashioned conference call. Ideally, there should be a short
        Simultaneously, learn about Gloomhaven, but focus on what you need for one scenario rather than trying to read the whole manual.
        Each person should upload a different user story to a folder for this. It’s better if this folder is kept separate from the source code
            Write one epic and break it apart into smaller stories so your code will work together. Especially for this first sprint, do not expect too much code from everyone, but make sure everyone has one or two classes to write with some functionality.
            To get the right level of detail for this, imagine yourself writing the code for the story in a week.
            Some level of hard-coding is to be expected, but you want to make it easy to remove this.
                For example, it’s fine to start a character with a fixed inventory, but you still want to represent that a character has an inventory
                As another example, if you represent the store where you can buy more items, using a static list initially would let you implement buying and selling. Later on you can have the store keep things in a file – in which case the signatures for buying and selling should remain the same.
            My experience is that it is hard for students to make decisions – remember that you have a limited amount of time, so do not try to make optimal choices, just acceptable choices. The rulebook starts with a specific scenario, so you might try to imitate it, even if you are hard-coding parts.

Tasks for deadline 2: 12-1


    Have each person write the code to complete their story. The focus should be on getting functionality done for the project. Writing error-handling code should only be done after getting the main functionality to work.
        You do not have to wait until after the first deadline to start coding, but you do want to make sure your code fits
    Write unit tests to show which parts of the functionality of your code you have completed.
    Upload all code to github. Assuming you want things to work together, you need to do this early enough so that you can try to get things to work together.
        Your group might consider initially uploading stubs for your code so that you can see if the API’s of each of your code can work together to do the epic.
    Write stories to help develop the epic more.
        You can support more options within the scenario (ex: adding ranged characters, support for attacking multiple opponents with one attack)
        You can also support connected elements – adding a store if you do not have one yet, or supporting the creation of the party instead of hard-coding it
    Post issues with the current code – this should be for stuff that is supposed to work, not stuff that your team just left out on purpose


Tasks for deadline 3: 12-9

    The same as deadline 2, but for the new stories, but you may do some fixing of issues as well. Also, while in real life you would be setting up for the next sprint, you don’t have to worry about that here. 
