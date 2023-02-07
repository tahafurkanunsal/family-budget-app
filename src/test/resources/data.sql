CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  username VARCHAR(255)
);

INSERT INTO users (id , first_name , last_name , username) VALUES (1 , 'taha furkan' , 'unsal' , 'tahafurkanunsal');
INSERT INTO users (id , first_name , last_name , username) VALUES (2 , 'zehra' , 'unsal' , 'zehraunsal');
INSERT INTO users (id , first_name , last_name , username) VALUES (3 , 'murat' , 'unsal' , 'muratunsal');

CREATE TABLE IF NOT EXISTS spendings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  date DATE,
  price INT,
  type INT,
  billing_type INT,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (106, '2001-06-15' , 100 ,  1, NULL , 1 );
INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (107, '2001-06-15' , 200 ,  0, NULL , 1 );
INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (108, '2001-06-15' , 300 ,  0, NULL , 1 );
INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (109, '2001-06-15' , 900 ,  0, NULL , 2 );
INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (110, '2001-06-15' , 400 ,  0, NULL , 1 );
INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (111, '2001-06-15' , 1200,  0, NULL , 3 );
INSERT INTO spendings (id,  date , price ,type ,billing_type ,user_id) VALUES (112, '2001-06-15' , 350 ,  1, NULL , 1 );
