CREATE TABLE IF NOT EXISTS employee (
    id uuid PRIMARY KEY,
    name text NOT NULL,
    monthly_salary numeric NOT NULL
);

CREATE TABLE IF NOT EXISTS payroll_record (
    employee_id uuid REFERENCES employee(id),
    payment_date timestamp with time zone NOT NULL default now(),
    amount numeric NOT NULL,
    CONSTRAINT payroll_pkey PRIMARY KEY(employee_id, payment_date)
);