////////////////////// Programare Orientata pe Obiecte  - Tema 2 /////////////////////////////
////////////////////////// Ciuciu Ioan- Dionisie - 323 CA ////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////


	Pentru structurarea proiectului care implementeaza masina Enigma, am ales sa folosesc cate
o clasa pentru fiecare componenta. In plus, am adaugat clasa Alphabet, care reprezinta alfabetul
primit ca input pentru Enigma, clasa CollectionOfRotors, clasa Plug, si de asemenea interfata 
Cryptography. In toate clasele am agregat clasa Alphabet, pentru a o folosi in constructor 
ulterior, deoarece am considerat ca toate elementele masinii contin un alfabet, adica cel 
corespunzator masinii Enigma. De altfel, folosesc interfata Cryptography, deoarece in aproape
toate clasele se folosesc 2 metode comune, convertLetter si revertLetter. Acestea au rolul de
a prelucra o litera primita ca input si de a o transforma in alta litera intr-un mod corespun-
zator componentei in care se face conversia. In clasa Reflector, nu s-a putut aplica acelasi 
principiu, pentru ca in aceasta componenta litera nu ar trece decat o data, deci nu ar fi nevoie
de un 'revertLetter' si astfel rolul interfetei nu mai exista.

	Motivul pentru care am ales aceasta ierarhie de clase, in special CollectionOfRotors si Rotors,
este posibilitatea de a extinde modelul, cat si crearea unui model de pipeline al functionarii 
masinii.

	Clasa Plugboard contine un ArrayList de plug-uri, acestea fiind reprezentate de clasa Plug.
Astfel, un plug reprezinta o grupare din doua litere prin care se specifica cum trebuie schimbata
maparea corespunzatoare din plugboard.

	Clasa Rotor contine caracteristicile unui rotor din masina Enigma, si metode pentru a afla 
daca pozitia rotorului este pe notch, de rotire cu o pozitie, cat si settere si gettere pentru
doua variabile de tip boolean care vor ajuta la metoda de trecere prin toate rotoarele, si 
respectarea conditiei de double-stepping.

	Clasa CollectionOfRotors contine o lista de obiecte de tip Rotor, cu dimensiune nespecificata,
in care se face practic trecerea prin toate rotoarele masinii, indiferent de numarul acestora.
Aici, diferenta fundamentala intre metodele de conversie intr-un sens si in altul a fost ca la
conversia in sens invers, rotoarele nu se mai roteau.

	In Reflector, se formeaza cu ajutorul unei metode vectorul in care se face maparea in functie 
de tipul reflectorului, B sau C. Functionalitatea e oferita de metoda convertLetter care convertes-
te o litera primita ca input, in functie de mapare.
	
	Clasa Enigma reprezinta clasa in care se agrega clasele reprezentand rotoarele, plugboard-ul, 
reflectorul, si alfabetul masinii. Astfel, aici am gandit practic implementarea masinii Enigma, 
in care metoda de conversie apeleaza toate celelalte metode de conversie din fiecare componenta,
in mod inlantuit. Intrucat metoda de conversie in sens invers nu aduce modificari, aceasta doar
apeleaza cealalta metoda si intoarce rezultatul.

	Pentru citire din fisier, am folosit clasa FileParser, aceeasi pe care am folosit-o si la 
prima tema, iar in clasa Main am citit linie cu linie si am pastrat datele in vectori pentru ca
apoi sa le folosesc pentru initializarea componentelor masinii si efectuarea operatiei cerute
in fisierul de input.

//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////

	

