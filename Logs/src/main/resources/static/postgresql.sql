DROP TABLE IF EXISTS job_log;
DROP sequence IF EXISTS job_log_id_seq;

CREATE SEQUENCE job_log_id_seq MINVALUE 1 START 1;

CREATE TABLE job_log
(
    timestmp            int8 NOT NULL,
    message           text NOT NULL,
    level_string      varchar(254) NOT NULL,
    logger_name       varchar(254) NOT NULL,
    thread_name       varchar(254),
    caller_filename   varchar(254) NOT NULL,
    caller_class      varchar(254) NOT NULL,
    caller_method     varchar(254) NOT NULL,
    caller_line       bpchar(4) NOT null,
    executor_id			varchar(254) NOT NULL,
    executor_ip			varchar(254) NOT NULL,
    event_id int8 NOT NULL DEFAULT nextval('job_log_id_seq'::regclass),
    CONSTRAINT job_log_pkey PRIMARY KEY (event_id)
);