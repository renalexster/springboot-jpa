FROM maven:alpine
MAINTAINER renato.campelo@ati.pe.gov.br

RUN mkdir /opt/app-backend \
&& mkdir /opt/app-backend/.m2 \
&& mkdir /opt/app-backend/.m2/repository \
&& mkdir /opt/app-backend/src

RUN addgroup app-backend && \
adduser -D -h /opt/app-backend -G app-backend app-backend

COPY . /opt/app-backend

WORKDIR /opt/app-backend

RUN chown -R app-backend:app-backend /opt/app-backend

USER app-backend

RUN mvn -T4 -Duser.home=/opt/app-backend clean package dependency:go-offline -DskipTests

EXPOSE 8080

CMD ["mvn", "-o", "-Duser.home=/opt/app-backend", "spring-boot:run"]
