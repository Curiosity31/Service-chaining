# Microservices Architecture with Service Chain

This project is based on a microservices architecture, where microservices collaborate to provide a complete functionality to the user. Communication between microservices happens through an API and each microservice performs a specific functionality.

To handle requests, the project uses a Gateway-API that routes the request to the first microservice in the service chain. Each microservice is registered on Eureka and containerized using Docker; a network has been defined to connect the containers with each other.

To prevent network or service failure in microservices communication, the circuit-breaker design pattern has been implemented.

The project also includes monitoring of each microservice through the metrics exposed by Actuator. These metrics have been made compatible with Prometheus, which is used for aggregating metrics, through Micrometer.

Finally, the project uses Grafana for visualizing metrics on a dashboard.

## Used technologies

- Docker
- Eureka
- Grafana
- Prometheus
- Micrometer
- Actuator
- Spring Cloud Gateway
- Spring Cloud CircuitBreaker


## Configuration

1. Clone the repository
2. Run `docker-compose up -d` command to start the application
3. Access [Grafana](http://localhost:3000) to view metrics

## Useful links

- [Eureka](http://localhost:8761)
- [Send request to gateway](http://localhost:8080/serviceA/getIBM)
- [Prometheus](http://localhost:9090/)

## Authors

- Carmine Di Martino (carmine.dimartino@outlook.com)
- Emanuele Gregory Legrottaglie (legrottaglie.em@gmail.com)
