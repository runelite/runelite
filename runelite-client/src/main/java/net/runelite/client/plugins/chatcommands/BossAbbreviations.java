package net.runelite.client.plugins.chatcommands;

import java.util.HashMap;
import java.util.Map;

public class BossAbbreviations {
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("corp", "Corporeal Beast");
		MAP.put("jad", "TzTok-Jad");
		MAP.put("kq", "Kalphite Queen");
		MAP.put("chaos ele", "Chaos Elemental");
		MAP.put("dusk", "Grotesque Guardians");
		MAP.put("dawn", "Grotesque Guardians");
		MAP.put("gargs", "Grotesque Guardians");
		MAP.put("crazy arch", "Crazy Archaeologist";
		MAP.put("deranged arch", "Deranged Archaeologist");
		MAP.put("mole", "Giant Mole");
		MAP.put("vetion", "Vet'ion");
		MAP.put("vene", "Venenatis");
		MAP.put("kbd", "King Black Dragon");
		MAP.put("vork", "Vorkath");
		MAP.put("sire", "Abyssal Sire");
		MAP.put("smoke devil", "Thermonuclear Smoke Devil");
		MAP.put("thermy", "Thermonuclear Smoke Devil");
		MAP.put("cerb", "Cerberus");
		MAP.put("zuk", "TzKal-Zuk");
		MAP.put("inferno", "TzKal-Zuk");

		// gwd
		case "sara":
		case "saradomin":
		case "zilyana":
		case "zily":
			return "Commander Zilyana";
		case "zammy":
		case "zamorak":
		case "kril":
		case "kril trutsaroth":
			return "K'ril Tsutsaroth";
		case "arma":
		case "kree":
		case "kreearra":
		case "armadyl":
			return "Kree'arra";
		case "bando":
		case "bandos":
		case "graardor":
			return "General Graardor";

		// dks
		case "supreme":
			return "Dagannoth Supreme";
		case "rex":
			return "Dagannoth Rex";
		case "prime":
			return "Dagannoth Prime";

		case "wt":
			return "Wintertodt";
		case "barrows":
			return "Barrows Chests";

		case "cox":
		case "xeric":
		case "chambers":
		case "olm":
		case "raids":
			return "Chambers of Xeric";

		case "tob":
		case "theatre":
		case "verzik":
		case "verzik vitur":
		case "raids 2":
			return "Theatre of Blood";

		default:
			return boss;
	}
	/**
	 * Takes a string representing the name of a boss, and if abbreviated,
	 * expands it into its full canonical name. Case-insensitive.
	 *
	 * @param abbrev Skill name that may be abbreviated.
	 * @return Full skill name if recognized, else the original string.
	 */
	static String getFullName(String abbrev)
	{
		return MAP.getOrDefault(abbrev.toUpperCase(), abbrev);
	}
}