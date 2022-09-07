BEGIN;


CREATE TABLE IF NOT EXISTS public.employee
(
    employee_id serial NOT NULL DEFAULT nextval('employee_employee_id_seq'::regclass),
    employee_email character varying(15) COLLATE pg_catalog."default",
    profile_id smallint,
    employee_role character(1) COLLATE pg_catalog."default",
    enterprise_id smallint,
    transaction_id smallint,
    "employee_createAt" date,
    "employee_updateAt" date,
    PRIMARY KEY (employee_id),
    UNIQUE (employee_email)
);

CREATE TABLE IF NOT EXISTS public.enterprise
(
    enterprise_id serial NOT NULL DEFAULT nextval('enterprise_enterprise_id_seq'::regclass),
    enterprise_name character varying(50) COLLATE pg_catalog."default",
    enterprise_document character varying(10) COLLATE pg_catalog."default",
    enterprise_phone character varying(10) COLLATE pg_catalog."default",
    enterprise_address character varying(30) COLLATE pg_catalog."default",
    "enterprise_createAt" date,
    "enterprise_updatedAt" date,
    CONSTRAINT enterprise_pk_01 PRIMARY KEY (enterprise_id),
    CONSTRAINT enterprise_02_unk UNIQUE (enterprise_name),
    CONSTRAINT enterprise_03_unk UNIQUE (enterprise_document)
);

CREATE TABLE IF NOT EXISTS public.profile
(
    profile_id integer NOT NULL DEFAULT nextval('profile_profile_id_seq'::regclass),
    profile_image bytea,
    profile_phone character varying(10) COLLATE pg_catalog."default",
    "profile_createAt" date,
    "profile_updatedAt" date,
    CONSTRAINT profile_pkey PRIMARY KEY (profile_id)
);

CREATE TABLE IF NOT EXISTS public.transaction
(
    transaction_id integer NOT NULL DEFAULT nextval('transaction_transaction_id_seq'::regclass),
    transaction_concept character varying(15) COLLATE pg_catalog."default",
    transaction_amount numeric,
    employee_id smallint,
    "transaction_createAt" date,
    "transaction_updatedAt" date,
    enterprise_id smallint,
    CONSTRAINT transaction_pkey PRIMARY KEY (transaction_id)
);

ALTER TABLE IF EXISTS public.employee
    ADD FOREIGN KEY (profile_id)
    REFERENCES public.profile (profile_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.transaction
    ADD FOREIGN KEY (enterprise_id)
    REFERENCES public.enterprise (enterprise_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
END;