TRUNCATE TABLE owners;

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487') ON CONFLICT DO NOTHING;

SELECT pg_catalog.setval(
  'owners_id_seq',
  COALESCE((SELECT MAX(id) + 1 FROM owners) , 1),
  false);
