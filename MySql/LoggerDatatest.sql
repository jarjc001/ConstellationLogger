USE constellationloggertest;

-- add into the constellations table
INSERT INTO constellations (Abbr,latinName,englishName,conMonth,maxLat,minLat,brightStar,extraInfo,image)
VALUES 
ROW ("And","Andromeda","Princess of Ethiopia",11,90,-40,"Alpheratz","","Placeholder.jpg"),
ROW ("Ant","Antlia","Air pump",4,45,-90,"Alpha Antliae","","Placeholder.jpg"),
ROW ("Aps","Apus","Bird of Paradise",7,5,-90,"Alpha Apodis","","Placeholder.jpg"),
ROW ("Aql","Aquila","Eagle",8,90,-75,"Altair","","Placeholder.jpg"),
ROW ("Aqr","Aquarius","Water bearer",10,65,-90,"Sadalsuud","","Placeholder.jpg"),
ROW ("Ara","Ara","Altar",7,25,-90,"Beta Arae","","Placeholder.jpg"),
ROW ("Ari","Aries","Ram",12,90,-60,"Hamal","","Placeholder.jpg"),
ROW ("Aur","Auriga","Charioteer",2,90,-40,"Capella","","Placeholder.jpg"),
ROW ("Boo","Bootes","Herdsman",6,90,-50,"Arcturus","","Placeholder.jpg"),
ROW ("Cae","Caelum","Graving tool",1,40,-90,"Alpha Caeli","","Placeholder.jpg"),
ROW ("Cam","Camelopardalis","Giraffe",2,90,-10,"Beta Camelopardalis","","Placeholder.jpg"),
ROW ("Cap","Capricornus","Sea goat",9,60,-90,"Deneb Algedi","","Placeholder.jpg"),
ROW ("Car","Carina","Keel of Argonauts ship",3,20,-90,"Canopus","","Placeholder.jpg"),
ROW ("Cas","Cassiopeia","Queen of Ethiopia",11,90,-20,"Schedar","","Placeholder.jpg"),
ROW ("Cen","Centaurus","Centaur",5,25,-90,"Rigil Kentaurus","","Placeholder.jpg"),
ROW ("Cep","Cepheus","King of Ethiopia",11,90,-10,"Alderamin","","Placeholder.jpg"),
ROW ("Cet","Cetus","Sea monster",11,70,-90,"Diphda","","Placeholder.jpg"),
ROW ("Cha","Chamaeleon","Chameleon",4,0,-90,"Alpha Chamaeleontis","","Placeholder.jpg"),
ROW ("Cir","Circinus","Compasses",7,30,-90,"Alpha Circini","","Placeholder.jpg"),
ROW ("CMa","Canis Major","Big dog",2,60,-90,"Sirius","","Placeholder.jpg"),
ROW ("CMi","Canis Minor","Little dog",3,90,-75,"Procyon","","Placeholder.jpg"),
ROW ("Cnc","Cancer","Crab",3,90,-60,"Tarf","","Placeholder.jpg"),
ROW ("Col","Columba","Dove",2,45,-90,"Phact","","Placeholder.jpg"),
ROW ("Com","Coma Berenices","Berenices hair",5,90,-70,"Beta Comae Berenices","","Placeholder.jpg"),
ROW ("CrA","Corona Australis","Southern crown",8,40,-90,"Meridiana","","Placeholder.jpg"),
ROW ("CrB","Corona Borealis","Northern crown",7,90,-50,"Alphecca","","Placeholder.jpg"),
ROW ("Crt","Crater","Cup",4,65,-90,"? Crateris","","Placeholder.jpg"),
ROW ("Cru","Crux","Southern Cross",5,20,-90,"Acrux","","Placeholder.jpg"),
ROW ("Crv","Corvus","Crow",5,60,-90,"Gienah","","Placeholder.jpg"),
ROW ("CVn","Canes Venatici","Hunting dogs",5,90,-40,"Cor Caroli","","Placeholder.jpg"),
ROW ("Cyg","Cygnus","Swan",9,90,-40,"Deneb","","Placeholder.jpg"),
ROW ("Del","Delphinus","Porpoise",9,90,-70,"Rotanev","","Placeholder.jpg"),
ROW ("Dor","Dorado","Swordfish",1,20,-90,"Alpha Doradus","","Placeholder.jpg"),
ROW ("Dra","Draco","Dragon",7,90,-15,"Eltanin","","Placeholder.jpg"),
ROW ("Equ","Equuleus","Little horse",9,90,-80,"Kitalpha","","Placeholder.jpg"),
ROW ("Eri","Eridanus","River",12,32,-90,"Achernar","","Placeholder.jpg"),
ROW ("For","Fornax","Furnace",12,50,-90,"Dalim","","Placeholder.jpg"),
ROW ("Gem","Gemini","Twins",2,90,-60,"Pollux","","Placeholder.jpg"),
ROW ("Gru","Grus","Crane",10,34,-90,"Alnair","","Placeholder.jpg"),
ROW ("Her","Hercules","Hercules",7,90,-50,"Kornephoros","","Placeholder.jpg"),
ROW ("Hor","Horologium","Clock",12,30,-90,"Alpha Horologii","","Placeholder.jpg"),
ROW ("Hya","Hydra","Sea serpent",4,54,-83,"Alphard","","Placeholder.jpg"),
ROW ("Hyi","Hydrus","Water snake",11,8,-90,"Beta Hydri","","Placeholder.jpg"),
ROW ("Ind","Indus","Indian",9,15,-90,"Alpha Indi","","Placeholder.jpg"),
ROW ("Lac","Lacerta","Lizard",10,90,-40,"Alpha Lacertae","","Placeholder.jpg"),
ROW ("Leo","Leo","Lion",4,90,-65,"Regulus","","Placeholder.jpg"),
ROW ("Lep","Lepus","Hare",1,63,-90,"Arneb","","Placeholder.jpg"),
ROW ("Lib","Libra","Balance",6,65,-90,"Zubeneschamali","","Placeholder.jpg"),
ROW ("LMi","Leo Minor","Little lion",4,90,-45,"Praecipua","","Placeholder.jpg"),
ROW ("Lup","Lupus","Wolf",6,35,-90,"Alpha Lupi","","Placeholder.jpg"),
ROW ("Lyn","Lynx","Lynx",3,90,-55,"Alpha Lyncis","","Placeholder.jpg"),
ROW ("Lyr","Lyra","Lyre or harp",8,90,-40,"Vega","","Placeholder.jpg"),
ROW ("Men","Mensa","Table mountain",1,4,-90,"Alpha Mensae","","Placeholder.jpg"),
ROW ("Mic","Microscopium","Microscope",9,45,-90,"Gamma Microscopii","","Placeholder.jpg"),
ROW ("Mon","Monoceros","Unicorn",2,75,-90,"Beta Monocerotis","","Placeholder.jpg"),
ROW ("Mus","Musca","Fly",5,10,-90,"Alpha Muscae","","Placeholder.jpg"),
ROW ("Nor","Norma","Carpenter Level",7,30,-90,"Gamma2 Normae","","Placeholder.jpg"),
ROW ("Oct","Octans","Octant",10,0,-90,"Nu Octantis","","Placeholder.jpg"),
ROW ("Oph","Ophiuchus","Holder of serpent",7,80,-80,"Rasalhague","","Placeholder.jpg"),
ROW ("Ori","Orion","Orion the hunter",1,85,-75,"Rigel","","Placeholder.jpg"),
ROW ("Pav","Pavo","Peacock",8,30,-90,"Peacock","","Placeholder.jpg"),
ROW ("Peg","Pegasus","Pegasus the winged horse",10,90,-60,"Enif","","Placeholder.jpg"),
ROW ("Per","Perseus","Perseus hero who saved Andromeda",12,90,-35,"Mirfak","","Placeholder.jpg"),
ROW ("Phe","Phoenix","Phoenix",11,32,-90,"Ankaa","","Placeholder.jpg"),
ROW ("Pic","Pictor","Easel",1,26,-90,"Alpha Pictoris","","Placeholder.jpg"),
ROW ("PsA","Piscis Austrinus","Southern fish",10,55,-90,"Fomalhaut","","Placeholder.jpg"),
ROW ("Psc","Pisces","Fishes",11,90,-65,"Alpherg","","Placeholder.jpg"),
ROW ("Pup","Puppis","Stern of the Argonauts ship",2,40,-90,"Naos","","Placeholder.jpg"),
ROW ("Pyx","Pyxis","Compass on the Argonauts ship",3,50,-90,"Alpha Pyxidis","","Placeholder.jpg"),
ROW ("Ret","Reticulum","Net",1,23,-90,"Alpha Reticuli","","Placeholder.jpg"),
ROW ("Scl","Sculptor","Sculptors tools",11,50,-90,"Alpha Sculptoris","","Placeholder.jpg"),
ROW ("Sco","Scorpius","Scorpion",7,40,-90,"Antares","","Placeholder.jpg"),
ROW ("Sct","Scutum","Shield",8,80,-90,"Alpha Scuti","","Placeholder.jpg"),
ROW ("Ser","Serpens","Serpent",7,80,-80,"Unukalhai","","Placeholder.jpg"),
ROW ("Sex","Sextans","Sextant",4,80,-90,"Alpha Sextantis","","Placeholder.jpg"),
ROW ("Sge","Sagitta","Arrow",8,90,-70,"Gamma Sagittae","","Placeholder.jpg"),
ROW ("Sgr","Sagittarius","Archer",8,55,-90,"Kaus Australis","","Placeholder.jpg"),
ROW ("Tau","Taurus","Bull",1,90,-65,"Aldebaran","","Placeholder.jpg"),
ROW ("Tel","Telescopium","Telescope",8,40,-90,"Alpha Telescopii","","Placeholder.jpg"),
ROW ("TrA","Triangulum Australe","Southern triangle",7,25,-90,"Atria","","Placeholder.jpg"),
ROW ("Tri","Triangulum","Triangle",12,90,-60,"Beta Trianguli","","Placeholder.jpg"),
ROW ("Tuc","Tucana","Toucan",11,25,-90,"Alpha Tucanae","","Placeholder.jpg"),
ROW ("UMa","Ursa Major","Big bear",4,90,-30,"Alioth","","Placeholder.jpg"),
ROW ("UMi","Ursa Minor","Little bear",6,90,-10,"Polaris","","Placeholder.jpg"),
ROW ("Vel","Vela","Sail of the Argonauts ship",3,30,-90,"Gamma2 Velorum","","Placeholder.jpg"),
ROW ("Vir","Virgo","Virgin",5,80,-80,"Spica","","Placeholder.jpg"),
ROW ("Vol","Volans","Flying fish",3,15,-90,"Beta Volantis","","Placeholder.jpg"),
ROW ("Vul","Vulpecula","Fox",9,90,-55,"Anser","","Placeholder.jpg");



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







