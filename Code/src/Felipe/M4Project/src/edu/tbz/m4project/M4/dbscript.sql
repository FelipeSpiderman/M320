# Pull the latest PostgreSQL image from Docker Hub
docker pull postgres

# Create and run the container (replace 'financetrackerdb' with your preferred name)
docker run --name financetrackerdb -e POSTGRES_PASSWORD=postgres -d postgres

# Verify the container is running
docker ps

# Access the PostgreSQL container (replace 'financetrackerdb' with your container name)
docker exec -it financetrackerdb psql -U postgres


CREATE SCHEMA financetracker;
SET search_path TO financetracker;

CREATE TABLE users (
    userid SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(80) UNIQUE NOT NULL,
    admin BOOLEAN DEFAULT FALSE
);

CREATE TABLE categories (
    categoryid SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE budgets (
    budgetid SERIAL PRIMARY KEY,
    userid INT REFERENCES users(userid) ON DELETE CASCADE,
    categoryid INT REFERENCES categories(categoryid),
    income NUMERIC(12,2) DEFAULT 0,
    limit_amount NUMERIC(12,2) NOT NULL,
    spent NUMERIC(12,2) DEFAULT 0
);

CREATE TABLE expenses (
    expenseid SERIAL PRIMARY KEY,
    userid INT REFERENCES users(userid) ON DELETE CASCADE,
    categoryid INT REFERENCES categories(categoryid),
    amount NUMERIC(12,2) NOT NULL,
    date TIMESTAMP DEFAULT NOW(),
    description VARCHAR(250)
);

CREATE TABLE notifications (
    notificationid SERIAL PRIMARY KEY,
    userid INT REFERENCES users(userid) ON DELETE CASCADE,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);
