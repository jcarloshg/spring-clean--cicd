FROM postgres:15.13

ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=123456
ENV POSTGRES_DB=main

COPY migrations/*.sql /docker-entrypoint-initdb.d/

EXPOSE 5432