DROP TABLE IF EXISTS description;
DROP TABLE IF EXISTS monitoring;

CREATE TABLE monitoring(

      site_id SERIAL,
      site_url varchar(30) not null,
      site_status varchar not null,
      PRIMARY KEY(site_id)
);

CREATE TABLE description(
      site_id SERIAL,
      monitoring_period time not null,
      response_code char(3) not null,
      response_line varchar(30) not null,
      response_size varchar(10) not null,
      FOREIGN KEY(site_id) REFERENCES monitoring(site_id)
);
