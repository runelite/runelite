import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class172 {
   @ObfuscatedName("e")
   public static final boolean[] field2356 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("f")
   public static int[] field2357 = new int[99];

   @ObfuscatedName("f")
   public static String method3177(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3082[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2357[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "6"
   )
   static final void method3178(int var0, int var1) {
      int var2 = class11.field119.method3774("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = class11.field119.method3774(method3179(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > ItemLayer.field1223) {
         var4 = ItemLayer.field1223 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class112.field1755) {
         var5 = class112.field1755 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      FileOnDisk.menuX = var4;
      XGrandExchangeOffer.menuY = var5;
      class20.menuWidth = var2;
      class101.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1941311058"
   )
   static String method3179(int var0) {
      return Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "123567494"
   )
   public static void method3180() {
      class138.field1913.method2466();
      class138.field1914 = 1;
      class145.field2014 = null;
   }
}
