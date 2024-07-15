For Schema And Data

CREATE TABLE IF NOT EXISTS claims (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(255) NOT NULL
);


INSERT INTO claims (status) VALUES ('Pending');
INSERT INTO claims (status) VALUES ('Approved');
INSERT INTO claims (status) VALUES ('Rejected');
