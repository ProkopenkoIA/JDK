package com.example.MontyHallParadox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
public class MontyHallParadoxApplication {

	static Random random;
	static Map<Integer, Boolean> results1;       // Статистика для игрока, не меняющего свой выбор.
	static Map<Integer, Boolean> results2;       // Статистика для игрока, изменяющего свой выбор.
	static int doorsCnt;                      // Количество дверей.
	static int games;                         // Количество попыток.

	public static void main(String[] args) {

		//SpringApplication.run(MontyHallParadoxApplication.class, args);

		random = new Random();
		results1 = new HashMap<>();
		results2 = new HashMap<>();
		doorsCnt= 3;
		games = 1000;

		for (int i = 0; i < games; i++) {     // Розыгрыш (1000 попыток).
			trial(i);
		}

		int win1 = 0;                             // Статистика для первого игрока, не меняющего свой выбор.
		for (Map.Entry<Integer, Boolean> entry: results1.entrySet()){
			if (entry.getValue()){
				win1++;
			}
		}


		int win2 = 0;                                  // Статистика для второго игрока, изменяющего свой выбор.
		for (Map.Entry<Integer, Boolean> entry: results2.entrySet()){
			if (entry.getValue()){
				win2++;
			}
		}

		System.out.println("\nПарадокс Монти Холла");
		System.out.println("\nСтатистика выигрышей для игрока, не меняющего свой выбор:");
		System.out.println("Количество побед: " + win1 + " раз из " + games + " попыток.");

		System.out.println("\nСтатистика выигрышей для игрока, меняющего свой выбор:");
		System.out.println("Количество побед: " + win2 + " раз из " + games + " попыток.");

	}

	private static void trial(int numRound) {
		int car = random.nextInt(doorsCnt);
		int firstChoice = random.nextInt(doorsCnt);
		int freeOpenDoor = -1;
		int secondChoice = -1;

		for (int i = 0; i < doorsCnt; i++) {
			if (i != car && i != firstChoice){
				freeOpenDoor = i;
			}
		}

		for (int i = 0; i < doorsCnt; i++) {            // Игрок не изменяет свой выбор.
			if (i != freeOpenDoor && i != firstChoice){
				secondChoice = firstChoice;
			}
		}
		results1.put(numRound, car == secondChoice);   // Статистика для первого игрока.

		for (int i = 0; i < doorsCnt; i++) {            // Игрок изменяет свой выбор.
			if (i != freeOpenDoor && i != firstChoice){
				secondChoice = i;
			}
		}
		results2.put(numRound, car == secondChoice);   // Статистика для второго игрока.
	}

}
