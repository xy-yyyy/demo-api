FROM java:8
RUN echo "Asia/Shanghai" > /etc/timezone
CMD ["--server.port=8501"]
EXPOSE 8501
COPY *.jar /industrial.jar
ENTRYPOINT ["java","-jar","/industrial.jar","--Dspring.config.location=/home/industrial/industrial-jar/jar/application.yml"]
CMD ["/bin/bash"]
MAINTAINER sunYF
