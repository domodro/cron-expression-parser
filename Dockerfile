FROM eclipse-temurin:21-alpine AS build
COPY . /source
WORKDIR /source
RUN ./gradlew test jlink

FROM alpine AS main
COPY --from=build /source/build/image /app
WORKDIR /app
ENTRYPOINT ["/app/bin/parser"]
