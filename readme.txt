a)
Opisany algorytm można zaleźć na: https://en.wikipedia.org/wiki/Readers%E2%80%93writers_problem
w rozwiązaniu jedyną różnicą jest dodanie dodatkowego semafora (readersLimit) pozwalającego na regulację maksymalnej
ilości wątków: 'reader'

b) włącz przez: java -jar /home/grzegorz/IdeaProjects/multi-module/main/target/main-1.0-jar-with-dependencies.jar


d) Pisarze spędzają zawsze 2s w bibliotece, a czytelnicy 1s. Po wykonaniu pracy każda z instancji czeka losowy czas od 0
do 5 s dla czytelników i od 0 do 10 s dla pisarzy.
Na standardowym wyjściu kolumna informuje o stanie każdej instancji co 0.5s, gdzie:
Q - instancja czeka w kolejce (queue)
W - instancja wykonuje swoją pracę (work)
R - instancja odpoczywa (rest)