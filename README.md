# ViewModel
# It is helpfull to start adapting the jitpack framework in Android development.

#Add depenedencies in main build.gradle
{
#implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
}

# two way data binding work when in XML added "=" between "@={}"


#Navigation host, Graph and destination componant

# Android Coroutine Core, android both kotlin project required.

# CouroutineScope (Displaters.IO)/ (Displaters.MAIN)/ (Displaters.Default)/ (Displaters.Unconfind)

# Main: > Run in main thread , small task to run
#IO: Background thread
#Defualt: use for CPU intesive task like a sorting of larg intensive operation.
# Uncofnind>> is not recommeneded to use. and take the current thread to use. 
# Mostly will use the Main & iO 
# Launch> Create and build new countrin with blocking the current couroitne
# Launch doesn return any 

Async:

# in need invoke await() 
# allow to return value

Produce: 

#Produce on stream of channel to clock thread untill the execution completeed

Structured Concurrency:
# Set of lanugage to avoide the memory leak.


Unstructured Concurrency:

Might be not give the espected result as it return first but the task is running in backgroung.
deffered.await using async we can handled it but it is not in good practises
  

