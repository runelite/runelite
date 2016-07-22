import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class38 {
   @ObfuscatedName("e")
   static int[] field813;
   @ObfuscatedName("bs")
   static class171 field814;
   @ObfuscatedName("g")
   static int[] field815 = new int[5];
   @ObfuscatedName("y")
   static final String[] field816 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("l")
   static int[][] field817 = new int[5][5000];
   @ObfuscatedName("r")
   @Export("chatboxSegments")
   static String[] field818 = new String[1000];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 814456023
   )
   static int field819 = 0;
   @ObfuscatedName("k")
   static class14[] field820 = new class14[50];
   @ObfuscatedName("u")
   static Calendar field822 = Calendar.getInstance();
   @ObfuscatedName("j")
   static int[] field823 = new int[1000];
   @ObfuscatedName("h")
   static class176 field825;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 835433089
   )
   static int field826 = 0;
   @ObfuscatedName("cb")
   static class146 field829;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1454386548"
   )
   public static void method762(class170 var0) {
      class56.field1235 = var0;
      class56.field1239 = class56.field1235.method3317(16);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "10"
   )
   static final void method767(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field413; ++var4) {
         if(client.field478[var4] + client.field359[var4] > var0 && client.field478[var4] < var0 + var2 && client.field495[var4] + client.field479[var4] > var1 && client.field479[var4] < var1 + var3) {
            client.field476[var4] = true;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-84"
   )
   static int method768() {
      return 9;
   }
}
