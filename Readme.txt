reste plus q'un bug pour les collisions des mobiles.



une images explique le truc 
http://stackoverflow.com/questions/345838/ball-to-ball-collision-detection-and-handling




l. 387   de fenetre 

j'ai commenté 		//mobiles.get(i).Add_Collisioneur(mobiles.get(k));


cette ligne sert a memoriser quand un mobiles a deja ete cogné

par exemple si le mobile a cogne le mobile b pas besoin de refaire l'algo quand le mobile b cogne le mobile a.



