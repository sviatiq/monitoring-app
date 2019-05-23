DROP TABLE IF EXISTS url_monitor;

CREATE TABLE url_monitor(

    site_name varchar(20) not null,
    site_status varchar(8) not null,
    monitoring_period time not null,
    http_response_code integer not null,
    http_response_line varchar(25) not null,
    http_response_size integer not null

);