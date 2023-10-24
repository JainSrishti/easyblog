
DROP TABLE articles;
DROP TABLE userprofile;

CREATE TABLE IF NOT EXISTS userprofile (
        id INTEGER NOT NULL AUTO_INCREMENT,
        name VARCHAR(50),
        email_id VARCHAR(50),
        password VARCHAR(50),
        interests TEXT,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS articles (
        id INTEGER NOT NULL AUTO_INCREMENT,
        title VARCHAR(500),
        content VARCHAR(500),
        likes_count INTEGER,
        is_published BOOLEAN,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        user_id INTEGER,
        PRIMARY KEY (id)
);