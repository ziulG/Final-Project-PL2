CREATE TABLE IF NOT EXISTS parking_spot (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            number VARCHAR(10) NOT NULL,
    location VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    vehicle_type VARCHAR(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS client (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL
    );
