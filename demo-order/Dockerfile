FROM java:8
RUN echo "Asia/Shanghai" > /etc/timezone
CMD ["--server.port=8501"]
EXPOSE 8501
COPY *.jar /demo-order.jar
ENTRYPOINT ["java","-jar","/demo-order.jar","--Dspring.config.location=/home/demo/demo-order/jar/application.yml"]
CMD ["/bin/bash"]
MAINTAINER sunYF
