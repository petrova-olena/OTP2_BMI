CREATE TABLE IF NOT EXISTS bmi_results (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           weight DOUBLE NOT NULL,
                                           height DOUBLE NOT NULL,
                                           bmi DOUBLE NOT NULL,
                                           language VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS localization_strings (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        language VARCHAR(10),
                        `key` VARCHAR(50),
                        value VARCHAR(255)
    );

INSERT INTO localization_strings(language, `key`, value)
VALUES
    ('en', 'weight', 'Weight'),
    ('en', 'height', 'Height'),
    ('en', 'calculate', 'Calculate'),
    ('fr', 'weight', 'Poids'),
    ('fr', 'height', 'Taille');