DROP TABLE tasks if exists;

CREATE TABLE tasks (
    id INT PRIMARY KEY,
    description VARCHAR(250) NOT NULL,
    done BIT NOT NULL
);