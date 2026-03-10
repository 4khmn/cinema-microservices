ALTER TABLE directors ADD COLUMN age INTEGER;

-- Устанавливаем дефолтное значение 50 для всех существующих записей
UPDATE directors SET age = 50 WHERE age IS NULL;