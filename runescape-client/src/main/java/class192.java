import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class192 {
   @ObfuscatedName("w")
   public static final String[][] field2417;
   @ObfuscatedName("m")
   public static final String[] field2414;
   @ObfuscatedName("q")
   public static Calendar field2418;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("n")
   @Export("indexSpriteWidths")
   static int[] indexSpriteWidths;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1298828229
   )
   @Export("plane")
   static int plane;

   static {
      field2417 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2414 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2418 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
