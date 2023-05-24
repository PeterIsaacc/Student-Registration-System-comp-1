FROM openjdk:11
WORKDIR /app
COPY /src .
RUN javac StudentRegistrationApp.java
ENV FILES_BATCH=/app/data/patch/BatchFiles \
    DATA_BATCH=/app/data/patch/AppData/
VOLUME /app/data/patch
CMD ["java", "StudentRegistrationApp"]

#CMD ["bash"]
