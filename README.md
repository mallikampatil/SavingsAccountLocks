# SavingsAccountLocks

## CS 554 Homework 2 SavingsAccount Implementation

### Problem: 

![image](https://user-images.githubusercontent.com/55963699/141663761-1770676b-933a-47a9-b07e-47e0834accbe.png)

### Implementaion: 

The implementation contains three functions in the SavingsAccount which are mainly deposit, withdraw, and transfer. All of them allow to do perform functions as per the problem description. Locks are implemented for all three functions. 

There is also the depositPreffered and savingsPreffered functions which are for addressing the second problem. The ordinary accounts wait until they preffered accounts are finished in both deposit and withdraw functions. This again only works if depositPreffered and withdrawPreffered functions are called. 
