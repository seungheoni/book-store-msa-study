FROM amazoncorretto:21

# 컨테이너 내부에서 애플리케이션 파일을 저장할 작업 디렉토리 생성
WORKDIR /app

# 호스트 시스템에서 애플리케이션의 JAR 파일을 컨테이너의 작업 디렉토리로 복사
COPY ../build/libs/bookstore-payment.jar /app/bookstore-payment.jar

# 컨테이너가 시작될 때 실행될 커맨드 지정
# JAR 파일을 실행하여 Java 애플리케이션 시작
CMD ["java", "-jar", "/app/bookstore-payment.jar"]