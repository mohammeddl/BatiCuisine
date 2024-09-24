CREATE TABLE Client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(15),
    isProfessional BOOLEAN
);

CREATE TABLE Project (
    id SERIAL PRIMARY KEY,
    projectname VARCHAR(255) NOT NULL,
    totalCost INT,
    margeBeneficium INT,
    projectStatus VARCHAR(50),
    client_id INT REFERENCES Client(id) ON DELETE CASCADE
);

CREATE TABLE Component (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    typeComposant VARCHAR(50)
);


CREATE TABLE Material (
    texRate INT,
    quantity INT,
    transportCost INT
) INHERITS (Component);

CREATE TABLE Labor (
    hourlyRate INT,
    hoursWorked INT
) INHERITS (Component);

CREATE TABLE Quote (
    id SERIAL PRIMARY KEY,
    estimatedAmount INT,
    issueDate DATE,
    validityDate DATE,
    isAccepted BOOLEAN,
    project_id INT REFERENCES Project(id) ON DELETE CASCADE
);