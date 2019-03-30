import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FirstnFollow {

	public static void computeFirst(CFG C) {

		// saving Variables in an ArrayList "V"
		ArrayList<String> V = new ArrayList<>();
		for (int i = 0; i < C.setOfVariables.length; i++) {
			V.add(C.setOfVariables[i]);
		}

		// saving Terminals in an ArrayList "E"
		ArrayList<String> E = new ArrayList<>();
		for (int i = 0; i < C.setOfTerminals.length; i++) {
			E.add(C.setOfTerminals[i]);
		}

		ArrayList<ArrayList<String>> FirstofV = new ArrayList<>();
		ArrayList<String> FirstofE = new ArrayList<>();

		for (int i = 0; i < E.size(); i++) {
			FirstofE.add(E.get(i));
		}

		for (int i = 0; i < C.nonEmptyProductions.length; i++) {
			String[] ruleAnatomy = C.nonEmptyProductions[i].split(",");
			FirstofV.add(computeFirstH(ruleAnatomy[0], C));
		}

		for (int i = 0; i < FirstofE.size(); i++) {
			System.out.println("First" + "(" + E.get(i) + ") = " + FirstofE.get(i) + ".");
		}

		for (int i = 0; i < FirstofV.size(); i++) {
			System.out.println("First" + "(" + V.get(i) + ") = " + FirstofV.get(i) + ".");
		}

	}

	public static ArrayList<String> computeFirstH(String Var, CFG C) {

		String[] rule = {};
		ArrayList<String> First = new ArrayList<>();
		ArrayList<String> E = new ArrayList<>();
		for (int i = 0; i < C.setOfTerminals.length; i++) {
			E.add(C.setOfTerminals[i]);
		}

		for (int i = 0; i < C.nonEmptyProductions.length; i++) {
			String[] ruleAnatomy = C.nonEmptyProductions[i].split(",");
			if (ruleAnatomy[0].equals(Var)) {
				rule = ruleAnatomy;
			}
		}

		for (int i = 1; i < rule.length; i++) {
			if (Character.isUpperCase(rule[i].charAt(0))) {
				if (!(rule[0].equals(rule[i].charAt(0) + ""))) {
					ArrayList<String> temp = computeFirstH((rule[i].charAt(0) + ""), (C));
					First.addAll(temp);
				} else {
					if (rule[rule.length - 1].equals("eps")) {
						ArrayList<String> temp = computeFirstH((rule[i].charAt(1) + ""), (C));
						First.addAll(temp);

						if (temp.contains("eps")) {
							ArrayList<String> temp1 = computeFirstH((rule[i].charAt(2) + ""), (C));
							First.addAll(temp1);
						}
					}

				}
			}

			else {
				if (rule[i].equals("eps") || E.contains(rule[i])) {
					First.add(rule[i]);
				} else {
					First.add(rule[i].charAt(0) + "");
				}
			}
		}

		Set<String> hs = new HashSet<>();
		hs.addAll(First);
		First.clear();
		First.addAll(hs);

		return First;
	}

	public static void computeFollow(CFG C) {

		// saving Variables in an ArrayList "V"
		ArrayList<String> V = new ArrayList<>();
		for (int i = 0; i < C.setOfVariables.length; i++) {
			V.add(C.setOfVariables[i]);
		}

		ArrayList<ArrayList<String>> FollowofV = new ArrayList<>();

		for (int i = 0; i < V.size(); i++) {
			FollowofV.add(computeFollowH(V.get(i),C));
		}

		for (int i = 0; i < FollowofV.size(); i++) {
			System.out.println("Follow" + "(" + V.get(i) + ") = " + FollowofV.get(i) + ".");
		}

	}

	public static ArrayList<String> computeFollowH(String Var, CFG C) {

		ArrayList<String> Follow = new ArrayList<>();

		if (Var.equals(C.startVariable + "")) {
			Follow.add("$");
		}

		for (int i = 0; i < C.nonEmptyProductions.length; i++) {

			String[] ruleAnatomy = C.nonEmptyProductions[i].split(",");

			for (int j = 1; j < ruleAnatomy.length; j++) {

				for (int j2 = 0; j2 < ruleAnatomy[j].length(); j2++) {

					if ((ruleAnatomy[j].charAt(j2) + "").equals(Var) || (ruleAnatomy[j].charAt(j2) + "'").equals(Var)) {
						if (j2 == ruleAnatomy[j].length() - 1) {
							if (!(ruleAnatomy[0].equals(Var))) {
								Follow.addAll(computeFollowH(ruleAnatomy[0], C));
							}
						} else {

							for (int k = 0; k < ruleAnatomy[j2].length(); k++) {
								if (Var.equals("S'") || Var.equals("E'")) {
									Follow.add("$");
									break;
								}
							}

							if (Character.isUpperCase(ruleAnatomy[j].charAt(j2 + 1))) {

								ArrayList<String> First = new ArrayList<>();
								if (((ruleAnatomy[j].charAt(ruleAnatomy[j].length() - 1) + "").equals("'"))) {
									First = computeFirstH(ruleAnatomy[j].charAt(j2 + 1) + "'", C);
								} else {
									First = computeFirstH(ruleAnatomy[j].charAt(j2 + 1) + "", C);
								}
								for (int k = 0; k < First.size(); k++) {
									if (!((First.get(k)).equals("eps"))) {
										Follow.add(First.get(k));
									} else {
										if (j2 + 1 == ruleAnatomy[j].length() - 1 && !(ruleAnatomy[0].equals(Var))) {
											Follow.addAll(computeFollowH(ruleAnatomy[0], C));
										} else {
											if (j2 + 2 == ruleAnatomy[j].length() - 1
													&& !(ruleAnatomy[0].equals(Var))) {
												Follow.addAll(computeFollowH(ruleAnatomy[0], C));
											}
										}
									}
								}
										if (j2 + 2 == ruleAnatomy[j].length() - 1) {
											if (((ruleAnatomy[j].charAt(ruleAnatomy[j].length() - 1) + "")
													.equals("'"))) {
												First = computeFirstH(ruleAnatomy[j].charAt(j2 + 2) + "'", C);
											} else {
												First = computeFirstH(ruleAnatomy[j].charAt(j2 + 2) + "", C);
											}
										}
										First.remove("eps");
										Follow.addAll(First);

									
								

							} else {
								Follow.add(ruleAnatomy[j].charAt(j2 + 1) + "");
							}

						}
					}
				}
			}
		}

		Set<String> hs = new HashSet<>();
		hs.addAll(Follow);
		Follow.clear();
		Follow.addAll(hs);
		Follow.remove("'");

		return Follow;
	}
}
