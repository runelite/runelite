import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class202 {
   @ObfuscatedName("b")
   static final String[][] field2583;
   @ObfuscatedName("q")
   static final String[] field2585;
   @ObfuscatedName("o")
   static Calendar field2584;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;

   static {
      field2583 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2585 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2584 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
