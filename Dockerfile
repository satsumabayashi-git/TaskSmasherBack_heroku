# # spring bootで起動
# FROM eclipse-temurin:21-jdk-alpine
# WORKDIR /app

# # ビルド関連ファイルを先にコピーして依存取得
# COPY build.gradle settings.gradle gradlew ./
# COPY gradle ./gradle

# # 依存だけ先にダウンロードしてキャッシュを効かせる
# RUN ./gradlew build --no-daemon || return 0

# COPY . .
# CMD ["./gradlew", "bootRun", "--no-daemon"]


# Jarファイルで起動
FROM eclipse-temurin:21-jdk-alpine
ENV FRONTEND_URL=http://localhost:5173/
# ARG JAR_FILE=build/libs/TaskSmasherBack_heroku-0.0.4-SNAPSHOT.jar
ARG JAR_FILE=TaskSmasherBack_heroku-0.0.4-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} ./jar
# COPY build/libs/TaskSmasherBack_heroku-0.0.4-SNAPSHOT.jar ./jar
ENTRYPOINT ["java","-jar","./jar"]

# #ベースイメージ
# FROM tomcat:11.0-jdk21

# # ローカルからDockerにコピー
# COPY TaskSmasherBack.war /usr/local/tomcat/webapps/