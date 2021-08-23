Gróf András

Vizsga project leírás

E-kéta alkalmazás . Tanárok, diákok, jegyek és osztályok tárolása H2-adatbázisban.

------------------------------------------------------------------------------

Osztály :

Osztály létrehozása JSON-objektumon keresztül /class/add (POST)

Osztály törlése /class/deleteClass/{id} (DELETE)

Osztály frissítése JSON-objektumon keresztül /class/updateClass/{id} (PUT)

Osztályok lekérdezése /class/getAllClass (GET)

Osztály lekérése név alapján /class/getClassByName/{name} (GET)

Osztály lekérése id alapján /class/getClassById/{id} (GET)

------------------------------------------------------------------------------

Tanár :

Tanár hozzáadása JSON-objektumon keresztül /teacher/add (Post)

Tanárok lekérése /teacher/getAll (GET)

Tanár frissítése id alapján /teacher/update/{id} (PUT)

Tanár törlése /teacher/delete/{id}   jegyekre" (DELETE)

------------------------------------------------------------------------------

Diák :

Diák hozzáadása JSON-objektumon keresztül /student/add (GET)

Diák frissítése JSON-objektumon keresztül /student/update (POST)

Diák Törlése /student/delete/{id} csak akkor lehet ha már nincs függősége jegyekre (DELETE)

Diákok lekérése /student/getAll (GET)

Diák lekérése /student/get (GET)

Diákok lekérése osztály id alapján /student/class/{id} (GET)

Diákok lekérése nem alapján /student/gender/{gender} (GET)

------------------------------------------------------------------------------

Osztályzat :

Osztályzatok lekérése /mark/getAll (GET)

Osztályzat hozzáadása /mark/add(POST) "A tanár Subject és Mark subject meg kell hogy egyezzen"

Osztályzat lekérése id alapján /mark/getMark/{id} (GET)

Osztályzat törlése id alapján /mark/delete/{id} 

Osztályzat frissítése id alapján JSON-objektummal /mark/update/{id} (PUT)

Átlag lekérése diák id alapján /mark/getAverage/{id} (GET)

Átlag lekérése diák id alapján és tárgy alapján /mark/getAverage/{id}/{subject} (GET)

Átlag lekérése diák id alapján és tárgy alapján adott hónapra /mark/getAverage/{id}/{subject}/{month} (GET)




