import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class36 {
   @ObfuscatedName("p")
   static int[] field798;
   @ObfuscatedName("d")
   static int[] field800 = new int[5];
   @ObfuscatedName("u")
   static int[][] field801 = new int[5][5000];
   @ObfuscatedName("o")
   static int[] field802 = new int[1000];
   @ObfuscatedName("x")
   static String[] field803;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1607325253
   )
   static int field804 = 0;
   @ObfuscatedName("c")
   static class14[] field805 = new class14[50];
   @ObfuscatedName("i")
   static Calendar field806 = Calendar.getInstance();
   @ObfuscatedName("r")
   static final String[] field807 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("b")
   @Export("chatboxSegments")
   static String[] field808 = new String[1000];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2090891943
   )
   static int field810 = 0;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-2012391513"
   )
   public static int method715(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
