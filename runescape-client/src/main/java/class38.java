import java.util.Calendar;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ao")
public class class38 {
   @ObfuscatedName("u")
   @Export("chatboxSegments")
   static String[] field818 = new String[1000];
   @ObfuscatedName("r")
   static int[] field820;
   @ObfuscatedName("h")
   static int[] field821 = new int[5];
   @ObfuscatedName("s")
   static int[][] field822 = new int[5][5000];
   @ObfuscatedName("k")
   static int[] field823 = new int[1000];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2047441263
   )
   static int field825 = 0;
   @ObfuscatedName("w")
   static final String[] field826 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("p")
   static Calendar field827 = Calendar.getInstance();
   @ObfuscatedName("b")
   static class14[] field828 = new class14[50];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1833282851
   )
   static int field829 = 0;

   @ObfuscatedName("l")
   public static String method791(long var0) {
      class114.field2014.setTime(new Date(var0));
      int var2 = class114.field2014.get(7);
      int var3 = class114.field2014.get(5);
      int var4 = class114.field2014.get(2);
      int var5 = class114.field2014.get(1);
      int var6 = class114.field2014.get(11);
      int var7 = class114.field2014.get(12);
      int var8 = class114.field2014.get(13);
      return class114.field2015[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class114.field2017[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
