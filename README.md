# Microservices with SpringBoot

Features:
- This application interacts with a MySQL Database
- It has 2 services: User Service and Department Service
- Both services have their own endpoints, User Service can call department service to retrieve User + Department
- API Gateway that redirects all endpoints to port 9191
- Service Registry (using Eureka Server) to keep track of all services
- Actuator (for application health and metrics)
- Resiliance4j (circuit breaker, retry mechanism and rate limiter)
- Zipkin (in this case started from a jar file)
