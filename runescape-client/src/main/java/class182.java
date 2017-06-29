import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class182 {
   @ObfuscatedName("go")
   static SpritePixels[] field2442;
   @ObfuscatedName("w")
   public static final String[] field2443;
   @ObfuscatedName("i")
   public static final String[][] field2444;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1086760671
   )
   public static int field2445;
   @ObfuscatedName("a")
   public static Calendar field2446;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-586816226"
   )
   static final void method3430(int var0) {
      class134.field2011[++class134.field2010 - 1] = var0;
   }

   static {
      field2444 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2443 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2446 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Lclass228;",
      garbageValue = "-1276316221"
   )
   public static class228[] method3431() {
      return new class228[]{class228.field3157, class228.field3163, class228.field3165, class228.field3164, class228.field3161, class228.field3158, class228.field3162, class228.field3160};
   }
}
