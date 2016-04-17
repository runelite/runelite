import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class114 {
   @ObfuscatedName("d")
   public static class167 field1962;
   @ObfuscatedName("k")
   public static class167 field1965;
   @ObfuscatedName("bh")
   static class168 field1967;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   public static void method2543() {
      if(class136.field2096.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2105[186] = 57;
         class137.field2105[187] = 27;
         class137.field2105[188] = 71;
         class137.field2105[189] = 26;
         class137.field2105[190] = 72;
         class137.field2105[191] = 73;
         class137.field2105[192] = 58;
         class137.field2105[219] = 42;
         class137.field2105[220] = 74;
         class137.field2105[221] = 43;
         class137.field2105[222] = 59;
         class137.field2105[223] = 28;
      } else {
         class137.field2105[44] = 71;
         class137.field2105[45] = 26;
         class137.field2105[46] = 72;
         class137.field2105[47] = 73;
         class137.field2105[59] = 57;
         class137.field2105[61] = 27;
         class137.field2105[91] = 42;
         class137.field2105[92] = 74;
         class137.field2105[93] = 43;
         class137.field2105[192] = 28;
         class137.field2105[222] = 58;
         class137.field2105[520] = 59;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "221980190"
   )
   static final boolean method2544(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label86:
      while(true) {
         int var6 = var4.method2812();
         if(0 == var6) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2812();
               if(var9 == 0) {
                  continue label86;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2613() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class133.method2969(var5);
                  if(22 != var12 || !client.field302 || 0 != var15.field942 || var15.field940 == 1 || var15.field961) {
                     if(!var15.method913()) {
                        ++client.field333;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2812();
            if(var9 == 0) {
               break;
            }

            var4.method2613();
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-17967"
   )
   public static final boolean method2545() {
      class137 var0 = class137.field2117;
      synchronized(class137.field2117) {
         if(class137.field2126 == class137.field2124) {
            return false;
         } else {
            class18.field277 = class137.field2131[class137.field2124];
            class137.field2128 = class137.field2120[class137.field2124];
            class137.field2124 = 1 + class137.field2124 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1375726648"
   )
   static final int method2546(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & '\uff00') + (var1 & '\uff00') * var2 & 16711680) + ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) >> 8;
   }
}
