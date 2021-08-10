Gróf András

Vizsga project leírás

E-kéta alkalmazás . Tanárok, diákok, jegyek és osztályok tárolása H2-adatbázisban.

------------------------------------------------------------------------------

Osztály :

Osztály létrehozása JSON-objektumon keresztül /class/addClass (POST)

Osztály törlése /class/deleteClass/{id} (DELETE)

Osztály frissítése JSON-objektumon keresztül /class/updateClass/{id} (PUT)

Osztályok lekérdezése /class/getAllClass (GET)

Osztály lekérése név alapján /class/getClassByName/{name} (GET)

Osztály lekérése id alapján /class/getClassById/{id} (GET)

------------------------------------------------------------------------------

Tanár :

Tanár hozzáadása JSON-objektumon keresztül /teacher/addTeacher (Post)

Tanárok lekérése /teacher/getAllTeacher (GET)

Tanár frissítése id alapján /teacher/updateTeacher/{id} (PUT)

Tanár törlése /teacher/deleteTeacher/{id} "csak akkor lehet ha már nincs függősége jegyekre" (DELETE)

------------------------------------------------------------------------------

Diák :

Diák hozzáadása JSON-objektumon keresztül /student/addStudent (GET)

Diák frissítése JSON-objektumon keresztül /student/update (POST)

Diák Törlése /student/delete/{id} csak akkor lehet ha már nincs függősége jegyekre (DELETE)

Diákok lekérése /student/getAllStudent (GET)

Diákok lekérése osztály id alapján /student/byClass/{id} (GET)

Diákok lekérése nem alapján /student/byGenre/{gender} (GET)

------------------------------------------------------------------------------

Osztályzat :

Osztályzatok lekérése /mark/getAllMark (GET)

Osztályzat hozzáadása /mark/addMark(POST)

Osztályzat lekérése id alapján /mark/getMarkById/{id} (GET)

Osztályzat törlése id alapján /mark/deleteMarkById/{id}

Osztályzat frissítése id alapján JSON-objektummal /mark/updateMarkById/{id} (PUT)

Átlag lekérése diák id alapján /mark/getAverage/{id} (GET)

Átlag lekérése diák id alapján és tárgy alapján /mark/getAverage/{id}/{subject} (GET)


