-- CPU
INSERT INTO cpus (id, model) VALUES
(1, 'Intel i3-9100'), (2, 'Intel i5-12400'), (3, 'AMD Ryzen 3 3100'), (4, 'AMD Ryzen 5 5600X'),
(5, 'Intel i7-10700'), (6, 'Intel i9-12900K'), (7, 'AMD Ryzen 7 3700X'), (8, 'AMD Ryzen 9 5900X'),
(9, 'Intel i5-10400'), (10, 'Intel i7-11700'), (11, 'AMD Ryzen 5 3500'), (12, 'AMD Ryzen 7 5800X'),
(13, 'Intel i9-9900K'), (14, 'Intel i7-13700K'), (15, 'AMD Ryzen 9 3950X'), (16, 'AMD Ryzen 9 7950X'),
(17, 'Intel i3-8100'), (18, 'Intel i5-9600K'), (19, 'AMD Ryzen 3 2200G'), (20, 'AMD Ryzen 5 1600');

-- GPU
INSERT INTO gpus (id, model) VALUES
 (1, 'NVIDIA GTX 1050 Ti'), (2, 'NVIDIA RTX 3060'), (3, 'AMD RX 560'), (4, 'AMD RX 6700 XT'),
 (5, 'NVIDIA GTX 1660 Super'), (6, 'NVIDIA RTX 3080'), (7, 'AMD RX 590'), (8, 'AMD RX 6800'),
 (9, 'NVIDIA RTX 2070'), (10, 'NVIDIA RTX 4080'), (11, 'AMD RX 5700'), (12, 'AMD RX 7900 XT'),
 (13, 'NVIDIA GTX 1080'), (14, 'NVIDIA RTX 2080 Ti'), (15, 'AMD RX Vega 64'), (16, 'AMD RX 6900 XT'),
 (17, 'NVIDIA GTX 970'), (18, 'NVIDIA RTX 3050'), (19, 'AMD RX 460'), (20, 'AMD RX 5500 XT');

-- RAM
INSERT INTO rams (id, size_in_gb) VALUES
(1, 8), (2, 16), (3, 4), (4, 32), (5, 8), (6, 16), (7, 12), (8, 24), (9, 16), (10, 32),
(11, 8), (12, 64), (13, 16), (14, 48), (15, 32), (16, 128), (17, 4), (18, 8), (19, 12), (20, 16);

-- STORAGE
INSERT INTO storages (id, size_in_gb) VALUES
(1, 256), (2, 512), (3, 128), (4, 1024), (5, 256), (6, 2048), (7, 512), (8, 4096), (9, 512), (10, 8192),
(11, 256), (12, 16384), (13, 512), (14, 2048), (15, 1024), (16, 4096), (17, 128), (18, 256), (19, 1024), (20, 2048);

-- SPECS
INSERT INTO specs (id, cpu_id, gpu_id, ram_id, storage_id) VALUES
(1, 1, 1, 1, 1),
(2, 2, 2, 2, 2),
(3, 3, 3, 3, 3),
(4, 4, 4, 4, 4),
(5, 5, 5, 5, 5),
(6, 6, 6, 6, 6),
(7, 7, 7, 7, 7),
(8, 8, 8, 8, 8),
(9, 9, 9, 9, 9),
(10, 10, 10, 10, 10),
(11, 11, 11, 11, 11),
(12, 12, 12, 12, 12),
(13, 13, 13, 13, 13),
(14, 14, 14, 14, 14),
(15, 15, 15, 15, 15),
(16, 16, 16, 16, 16),
(17, 17, 17, 17, 17),
(18, 18, 18, 18, 18),
(19, 19, 19, 19, 19),
(20, 20, 20, 20, 20);
