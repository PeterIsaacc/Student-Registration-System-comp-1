### To run Docker-Compose follow these steps:
* Clone componentone repo 
* Clone componenttwo repo
* Put the repos into the same directory
* Run this command: docker-compose up -d
* then this command: docker ps
* then choose id of the required component
* open new terminal and run this command: docker attach 'id'


### To run the DockerFiles alone 
* build the image locally
* run this command: docker run -it --mount type=bind,source=/path/to/Data,target=/app/data/patch {image name}


## PS USE sudo before any command if using linux || winpty before any command if windows
