# backend-coding-challenge implementation

## Decisions
Following the Minimum Viable Product approach, I decided to start with the /properties/report endpoint.
For this it was necessary: 
- Fix database and MyBatis mappings
- Fix rest controller (dependency injection was missing)
- Fix search GET mapping (required for report)
- Fix report GET mapping

## What was done
- Working endpoints:
  - /properties/report
  - /properties/search
  - /properties/find/{id}
- Tests
  - Fixed initial Unit Tests
  - Fixed initial Integration Tests, load some sample data

## What is still pending
- Refactor to MVC pattern
- Define an interface for PropertyService
- Implement insert, update, delete endpoints
  - Asynchronous alert send in a confirmed delete
- Validate all incoming attributes on PropertyController
- Add more tests

## Test it now
Spin up MySQL 8.0:
```commandline
docker run -e "TZ=UTC" -e "MYSQL_ROOT_PASSWORD=secret" --name mysql -p 3306:3306 mysql:8.0.22
```
Initilize the database:
```commandline
mvn flyway:migrate
```
Run tests and load some sample data:
```commandline
mvn test
```
Run the SpringBoot API:
```commandline
mvn spring-boot:run
```
Test the implemented endpoints. For instance:
```commandline
> curl localhost:8080/properties/report 2>/dev/null | json_pp -json_opt pretty
{
   "averageRentPrice" : 3000.99,
   "illinoisQuantity" : 1,
   "quantityPerType" : {
      "Condominium" : 1,
      "Multi-family" : 1,
      "Single Family" : 1,
      "Townhouse" : 2
   },
   "totalQuantity" : 5
}
```
