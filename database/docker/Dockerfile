# PostgreSQL 공식 이미지를 베이스 이미지로 사용합니다.
FROM postgres:latest

# 환경변수 설정
# 데이터베이스 이름, 사용자 이름, 비밀번호를 설정합니다.
ENV POSTGRES_DB=bookstore
ENV POSTGRES_USER=seungheon
ENV POSTGRES_PASSWORD=qwer1234

# 초기화 스크립트 추가
COPY init.sql /docker-entrypoint-initdb.d/
# 포트 설정
# PostgreSQL 기본 포트인 5432를 외부에 노출합니다.
EXPOSE 5432
