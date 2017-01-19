import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class162 {
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1146461923
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("u")
   static byte[][][] field2157;
   @ObfuscatedName("f")
   public static Calendar field2158;
   @ObfuscatedName("c")
   public static final String[] field2159 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("s")
   public static final String[][] field2160 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-937129238"
   )
   static int method2999(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var0);
      return null == var2?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2158 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
