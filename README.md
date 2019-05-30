# AlvicomTask

The small bank transaction management app. It reads messages from the standard input in the following forms:

If the message currency and account currency matches  
* 11111111-22222222  
HUF  
-30000


and if they are different
* 11111111-22222222  
USD  
49.99  
257.21

Every 10 account transactions it prints history to the standard output
