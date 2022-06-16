# Employee Reimbursement

## Description
   An Employee Expense Reimbursement API. This application manages the process of reimbursing employees for expenses incurred while on company time. Employees can submit reimbursement requests, view their pending, denied, and approved requests. Finance managers can view all reimbursement requests, as well as approve or deny requests. The API implements a RESTful approach.

## Technologies

1. Java 8
2. Javalin (Jetty Server)
3. JDBC
4. PostgresSQL
5. Docker 
6. Docker Compose 
7. Prometheus 
8. Grafana 

## Features
* ERS
    * Rejects invalid requests
        * negative amounts
        * unauthenticated users cannot make requests or access anything

* Employees
  * Login
  * Logout
  * Submit reimbursement requests
    * lodging, travel, food, other
      amount
  * View past requests
  * View pending requests
  * View all requests

* F. Managers
  * login
  * logout
  * view all reimbursement requests by status
  * view request history for all employees by status
  * view particular user history
  * approve a request
  * deny a request

* Possible improvements:
  * Switch authentication to OAuth or API keys
  * Implement email alerts
  * Implement a web front end that accesses this API


## Getting Started

Install git.

Install docker.

git clone https://github.com/2205JavaSRE/expense-reimbursement-system-ooido.git

docker build . -t ers:v1

docker compose up -d

## Usage
At present the best way to demo this application is by accessing the endpoints using an API platform such as Postman.

## License

This project uses the following license: [GPL 3.0](https://www.gnu.org/licenses/gpl-3.0.html).
