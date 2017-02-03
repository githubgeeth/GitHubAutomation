Feature: 001_CreateRepository

Scenario Outline: Create repository and delete

Given Launch PwC GitHub URL and login to GitHub
And Click on Start a project to create a repository and verify Code tab is displayed "<scenario>"
And Navigate to Issues and create a new issue "<scenario>"
And Navigate to Pull requests and verify if New pull request is available
And Navigate to Projects and create a new project "<scenario>"
And Navigate to Wiki and verify Wiki icon
And Navigate to Pulse and verify header
And Navigate to Graphs and verify graph icon availability
And Navigate to settigns and Delete the repository

Examples:
|scenario|
|TC001|