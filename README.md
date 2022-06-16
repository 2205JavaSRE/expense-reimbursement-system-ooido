# Employee Reimbursement

## Description
   An Employee Expensivce Reimbursement API. This application manages the process of reimbursing employees for expenses incurred while on company time. Employees can submit reimbursement requests, view their pending, denied, and approved requests. Finance managers can view all reimbursement requests, as well as approve or deny requests. The API implements a RESTful approach.

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

(include git clone command)
(include all environment setup steps)

> Be sure to include BOTH Windows and Unix command  
> Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)

- All the `code` required to get started
- Images of what it should look like

## Usage

> Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

## Contributors

> Here list the people who have contributed to this project. (ignore this section, if its a solo project)

## License

This project uses the following license: [<license_name>](<link>).
