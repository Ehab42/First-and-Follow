
public class TestFirstnFollow {

	public static void main(String[] args) {

		/*
		 * Notes: -CFG input format is {"A,B,C,D"} meaning (A->B|C|D). -The String "eps"
		 * means "epsilon". -To test the testcases just uncomment each testCase alone
		 * for duplicate variables, then run the code and the output will be printed in
		 * the console.
		 */

		// // Lecture 4, example 1
		// String[] setOfVariables = { "S", "T" };
		// String[] setOfTerminals = { "a", "b" };
		// String[] nonEmptyProductions = { "S,aSb,T", "T,aT,eps" };
		// char startVariable = 'S';
		//
		// CFG C = new CFG(setOfVariables, setOfTerminals, nonEmptyProductions,
		// startVariable);
		//
		// FirstnFollow.computeFirst(C);
		// FirstnFollow.computeFollow(C);
		
		
		

		// // Lecture 4, example 2
		// String[] setOfVariables = { "E", "E'", "T", "T'", "F" };
		// String[] setOfTerminals = { "+", "*", "(", ")", "id" };
		// String[] nonEmptyProductions = { "E,TE'", "E',+TE',eps", "T,FT'",
		// "T',*FT',eps", "F,(E),id" };
		// char startVariable = 'E';
		//
		// CFG C = new CFG(setOfVariables, setOfTerminals, nonEmptyProductions,
		// startVariable);
		//
		// FirstnFollow.computeFirst(C);
		// FirstnFollow.computeFollow(C);
		
		
		

		// // Practice Assignment 4, problem 4-3 100%
		// String[] setOfVariables = { "S", "T" };
		// String[] setOfTerminals = { "0", "1" };
		// String[] nonEmptyProductions = { "S,0T1S,eps", "T,0T1,eps" };
		// char startVariable = 'S';
		//
		// CFG C = new CFG(setOfVariables, setOfTerminals, nonEmptyProductions,
		// startVariable);
		//
		// FirstnFollow.computeFirst(C);
		// FirstnFollow.computeFollow(C);
		
		
		

		// // Practice Assignment 4, problem 4-4 100%
		// String[] setOfVariables = { "S", "A", "B", "C" };
		// String[] setOfTerminals = { "a", "b", "c" };
		// String[] nonEmptyProductions = { "S,SAB,SBC,eps", "A,aAa,eps", "B,bB,eps",
		// "C,cC,eps" };
		// char startVariable = 'S';
		//
		// CFG C = new CFG(setOfVariables, setOfTerminals, nonEmptyProductions,
		// startVariable);
		//
		// FirstnFollow.computeFirst(C);
		// FirstnFollow.computeFollow(C);
		
		
		

		// // Practice Assignment 4, problem 4-5 /* I replaced ',' with ';' for
		// String.split(",") */ 100%
		// String[] setOfVariables = { "S", "L" };
		// String[] setOfTerminals = { "(", ")", "a", ";" };
		// String[] nonEmptyProductions = { "S,(L),a", "L,L;S,S" };
		// char startVariable = 'S';
		//
		// CFG C = new CFG(setOfVariables, setOfTerminals, nonEmptyProductions,
		// startVariable);
		//
		// FirstnFollow.computeFirst(C);
		// FirstnFollow.computeFollow(C);
		
		
		

		// // Practice Assignment 4, problem 4-6 100%
		// String[] setOfVariables = { "S" };
		// String[] setOfTerminals = { "a", "+", "*" };
		// String[] nonEmptyProductions = { "S,SS+,SS*,a" };
		// char startVariable = 'S';
		//
		// CFG C = new CFG(setOfVariables, setOfTerminals, nonEmptyProductions,
		// startVariable);
		//
		// FirstnFollow.computeFirst(C);
		// FirstnFollow.computeFollow(C);

	}

}
