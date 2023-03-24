USE constellationlogger;

-- add into the constellations table
INSERT INTO constellations (Abbr,latinName,englishName,conMonth,maxLat,minLat,brightStar)
VALUES 
ROW ("And","Andromeda","Princess of Ethiopia",11,90,-40,"Alpheratz"),
ROW ("Ant","Antlia","Air pump",4,45,-90,"Alpha Antliae"),
ROW ("Aps","Apus","Bird of Paradise",7,5,-90,"Alpha Apodis"),
ROW ("Aql","Aquila","Eagle",8,90,-75,"Altair"),
ROW ("Aqr","Aquarius","Water bearer",10,65,-90,"Sadalsuud"),
ROW ("Ara","Ara","Altar",7,25,-90,"Beta Arae"),
ROW ("Ari","Aries","Ram",12,90,-60,"Hamal"),
ROW ("Aur","Auriga","Charioteer",2,90,-40,"Capella"),
ROW ("Boo","Bootes","Herdsman",6,90,-50,"Arcturus"),
ROW ("Cae","Caelum","Graving tool",1,40,-90,"Alpha Caeli"),
ROW ("Cam","Camelopardalis","Giraffe",2,90,-10,"Beta Camelopardalis"),
ROW ("Cap","Capricornus","Sea goat",9,60,-90,"Deneb Algedi"),
ROW ("Car","Carina","Keel of Argonauts ship",3,20,-90,"Canopus"),
ROW ("Cas","Cassiopeia","Queen of Ethiopia",11,90,-20,"Schedar"),
ROW ("Cen","Centaurus","Centaur",5,25,-90,"Rigil Kentaurus"),
ROW ("Cep","Cepheus","King of Ethiopia",11,90,-10,"Alderamin"),
ROW ("Cet","Cetus","Sea monster",11,70,-90,"Diphda"),
ROW ("Cha","Chamaeleon","Chameleon",4,0,-90,"Alpha Chamaeleontis"),
ROW ("Cir","Circinus","Compasses",7,30,-90,"Alpha Circini"),
ROW ("Cma","Canis Major","Big dog",2,60,-90,"Sirius"),
ROW ("Cmi","Canis Minor","Little dog",3,90,-75,"Procyon"),
ROW ("Cnc","Cancer","Crab",3,90,-60,"Tarf"),
ROW ("Col","Columba","Dove",2,45,-90,"Phact"),
ROW ("Com","Coma Berenices","Berenices hair",5,90,-70,"Beta Comae Berenices"),
ROW ("Cra","Corona Australis","Southern crown",8,40,-90,"Meridiana"),
ROW ("Crb","Corona Borealis","Northern crown",7,90,-50,"Alphecca"),
ROW ("Crt","Crater","Cup",4,65,-90,"? Crateris"),
ROW ("Cru","Crux","Southern Cross",5,20,-90,"Acrux"),
ROW ("Crv","Corvus","Crow",5,60,-90,"Gienah"),
ROW ("Cvn","Canes Venatici","Hunting dogs",5,90,-40,"Cor Caroli"),
ROW ("Cyg","Cygnus","Swan",9,90,-40,"Deneb"),
ROW ("Del","Delphinus","Porpoise",9,90,-70,"Rotanev"),
ROW ("Dor","Dorado","Swordfish",1,20,-90,"Alpha Doradus"),
ROW ("Dra","Draco","Dragon",7,90,-15,"Eltanin"),
ROW ("Equ","Equuleus","Little horse",9,90,-80,"Kitalpha"),
ROW ("Eri","Eridanus","River",12,32,-90,"Achernar"),
ROW ("For","Fornax","Furnace",12,50,-90,"Dalim"),
ROW ("Gem","Gemini","Twins",2,90,-60,"Pollux"),
ROW ("Gru","Grus","Crane",10,34,-90,"Alnair"),
ROW ("Her","Hercules","Hercules",7,90,-50,"Kornephoros"),
ROW ("Hor","Horologium","Clock",12,30,-90,"Alpha Horologii"),
ROW ("Hya","Hydra","Sea serpent",4,54,-83,"Alphard"),
ROW ("Hyi","Hydrus","Water snake",11,8,-90,"Beta Hydri"),
ROW ("Ind","Indus","Indian",9,15,-90,"Alpha Indi"),
ROW ("Lac","Lacerta","Lizard",10,90,-40,"Alpha Lacertae"),
ROW ("Leo","Leo","Lion",4,90,-65,"Regulus"),
ROW ("Lep","Lepus","Hare",1,63,-90,"Arneb"),
ROW ("Lib","Libra","Balance",6,65,-90,"Zubeneschamali"),
ROW ("Lmi","Leo Minor","Little lion",4,90,-45,"Praecipua"),
ROW ("Lup","Lupus","Wolf",6,35,-90,"Alpha Lupi"),
ROW ("Lyn","Lynx","Lynx",3,90,-55,"Alpha Lyncis"),
ROW ("Lyr","Lyra","Lyre or harp",8,90,-40,"Vega"),
ROW ("Men","Mensa","Table mountain",1,4,-90,"Alpha Mensae"),
ROW ("Mic","Microscopium","Microscope",9,45,-90,"Gamma Microscopii"),
ROW ("Mon","Monoceros","Unicorn",2,75,-90,"Beta Monocerotis"),
ROW ("Mus","Musca","Fly",5,10,-90,"Alpha Muscae"),
ROW ("Nor","Norma","Carpenter Level",7,30,-90,"Gamma2 Normae"),
ROW ("Oct","Octans","Octant",10,0,-90,"Nu Octantis"),
ROW ("Oph","Ophiuchus","Holder of serpent",7,80,-80,"Rasalhague"),
ROW ("Ori","Orion","Orion the hunter",1,85,-75,"Rigel"),
ROW ("Pav","Pavo","Peacock",8,30,-90,"Peacock"),
ROW ("Peg","Pegasus","Pegasus the winged horse",10,90,-60,"Enif"),
ROW ("Per","Perseus","Perseus hero who saved Andromeda",12,90,-35,"Mirfak"),
ROW ("Phe","Phoenix","Phoenix",11,32,-90,"Ankaa"),
ROW ("Pic","Pictor","Easel",1,26,-90,"Alpha Pictoris"),
ROW ("Psa","Piscis Austrinus","Southern fish",10,55,-90,"Fomalhaut"),
ROW ("Psc","Pisces","Fishes",11,90,-65,"Alpherg"),
ROW ("Pup","Puppis","Stern of the Argonauts ship",2,40,-90,"Naos"),
ROW ("Pyx","Pyxis","Compass on the Argonauts ship",3,50,-90,"Alpha Pyxidis"),
ROW ("Ret","Reticulum","Net",1,23,-90,"Alpha Reticuli"),
ROW ("Scl","Sculptor","Sculptors tools",11,50,-90,"Alpha Sculptoris"),
ROW ("Sco","Scorpius","Scorpion",7,40,-90,"Antares"),
ROW ("Sct","Scutum","Shield",8,80,-90,"Alpha Scuti"),
ROW ("Ser","Serpens","Serpent",7,80,-80,"Unukalhai"),
ROW ("Sex","Sextans","Sextant",4,80,-90,"Alpha Sextantis"),
ROW ("Sge","Sagitta","Arrow",8,90,-70,"Gamma Sagittae"),
ROW ("Sgr","Sagittarius","Archer",8,55,-90,"Kaus Australis"),
ROW ("Tau","Taurus","Bull",1,90,-65,"Aldebaran"),
ROW ("Tel","Telescopium","Telescope",8,40,-90,"Alpha Telescopii"),
ROW ("Tra","Triangulum Australe","Southern triangle",7,25,-90,"Atria"),
ROW ("Tri","Triangulum","Triangle",12,90,-60,"Beta Trianguli"),
ROW ("Tuc","Tucana","Toucan",11,25,-90,"Alpha Tucanae"),
ROW ("Uma","Ursa Major","Big bear",4,90,-30,"Alioth"),
ROW ("Umi","Ursa Minor","Little bear",6,90,-10,"Polaris"),
ROW ("Vel","Vela","Sail of the Argonauts ship",3,30,-90,"Gamma2 Velorum"),
ROW ("Vir","Virgo","Virgin",5,80,-80,"Spica"),
ROW ("Vol","Volans","Flying fish",3,15,-90,"Beta Volantis"),
ROW ("Vul","Vulpecula","Fox",9,90,-55,"Anser");


SELECT * FROM constellations;

INSERT INTO users(username, password, userFirstName, userLastName, email, premium) 
VALUES 
Row ("premiumUser","password","premiumfirstname","premiumLastname","premiumUser@mail.com",true),
Row ("normalUser","password","normalfirstname","normalLastname","normalUser@mail.com",false);

SELECT * FROM users;

insert INTO log(logDate, Lat, extraInfo, username)
VALUES 
ROW ('1982-12-12', 50, "premiumUser log" ,"premiumUser"),
Row('1983-01-01', -30, "normalUser log" ,"normalUser");

SELECT * FROM log;

SELECT LAST_INSERT_ID();

select * from users WHERE username= "booby";

SELECT cl.* FROM constellationslog cl ; 

UPDATE users SET username = ?, password = ?, userFirstName = ?, userLastName = ?, email = ?, premium =?;


SELECT * FROM constellations WHERE 70 BETWEEN minLat AND maxLat



