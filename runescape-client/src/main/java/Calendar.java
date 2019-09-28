import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("Calendar")
public class Calendar {
	@ObfuscatedName("z")
	@Export("MONTH_NAMES_ENGLISH_GERMAN")
	public static final String[][] MONTH_NAMES_ENGLISH_GERMAN;
	@ObfuscatedName("n")
	@Export("DAYS_OF_THE_WEEK")
	public static final String[] DAYS_OF_THE_WEEK;
	@ObfuscatedName("v")
	@Export("Calendar_calendar")
	public static java.util.Calendar Calendar_calendar;

	static {
		MONTH_NAMES_ENGLISH_GERMAN = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}, {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"}};
		DAYS_OF_THE_WEEK = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		java.util.Calendar.getInstance();
		Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lho;I[B[BB)V",
		garbageValue = "-75"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2552 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2552 = new byte[11][];
			var0.field2621 = new byte[11][];
			var0.field2586 = new int[11];
			var0.field2548 = new int[11];
		}

		var0.field2552[var1] = var2;
		if (var2 != null) {
			var0.field2619 = true;
		} else {
			var0.field2619 = false;

			for (int var4 = 0; var4 < var0.field2552.length; ++var4) {
				if (var0.field2552[var4] != null) {
					var0.field2619 = true;
					break;
				}
			}
		}

		var0.field2621[var1] = var3;
	}
}
