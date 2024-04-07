CREATE SCHEMA IF NOT EXISTS usr;

CREATE TABLE IF NOT EXISTS usr.user_account
(
    web_id bigint NOT NULL,
    version integer NOT NULL DEFAULT 0,
    created_date timestamp with time zone NOT NULL DEFAULT now(),
    updated_date timestamp with time zone DEFAULT now(),
    external_id character varying COLLATE pg_catalog."default",
    first_name character varying COLLATE pg_catalog."default",
    last_name character varying COLLATE pg_catalog."default",
    pin_code bigint NOT NULL,
    status integer,
    phone_number text COLLATE pg_catalog."default",
    last_login timestamp without time zone,
    deleted boolean DEFAULT false,
    fcm_token character varying COLLATE pg_catalog."default",
    gender character varying COLLATE pg_catalog."default",
    device_id character varying COLLATE pg_catalog."default"
)