```sql

CREATE TABLE IF NOT EXISTS `LinkCategory` (
  `category_id` INTEGER NOT NULL,
  `link_id` INTEGER NOT NULL,
  PRIMARY KEY(`link_id`, `category_id`),
  FOREIGN KEY(`link_id`) REFERENCES `Link`(`link_id`) ON UPDATE NO ACTION ON DELETE CASCADE ,
  FOREIGN KEY(`category_id`) REFERENCES `Category`(`category_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE  INDEX `index_LinkCategory_category_id` ON `${LinkCategory}` (`category_id`
);

CREATE  INDEX `index_LinkCategory_link_id` ON `${LinkCategory}` (`link_id`
);

CREATE TABLE IF NOT EXISTS Category (
`category_id` INTEGER PRIMARY KEY
 AUTOINCREMENT NOT NULL, `name` TEXT
);

CREATE TABLE IF NOT EXISTS user (`user_id`
  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` TEXT, `email` TEXT, `user_name` TEXT, `phone_number` TEXT
);

CREATE TABLE IF NOT EXISTS Link (
  `link_id` INTEGER PRIMARY KEY
  AUTOINCREMENT NOT NULL, `user_id`
  INTEGER NOT NULL, `url` TEXT, `descriptor` TEXT, `timestamp` TEXT
);
```