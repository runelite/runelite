import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class95 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 970235237
   )
   int field1617;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1367961001
   )
   int field1618;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1953540393
   )
   public static int field1619;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 340263647
   )
   int field1620;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2139858105
   )
   int field1622;
   @ObfuscatedName("ch")
   static class223 field1627;

   @ObfuscatedName("s")
   public static int method2212(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   class95(class95 var1) {
      this.field1617 = var1.field1617;
      this.field1622 = var1.field1622;
      this.field1620 = var1.field1620;
      this.field1618 = var1.field1618;
   }

   class95() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-525982426"
   )
   public static void method2213(int var0) {
      if(var0 != -1) {
         if(class172.field2733[var0]) {
            class172.field2782.method3331(var0);
            if(class172.field2850[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class172.field2850[var0].length; ++var2) {
                  if(null != class172.field2850[var0][var2]) {
                     if(class172.field2850[var0][var2].field2764 != 2) {
                        class172.field2850[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class172.field2850[var0] = null;
               }

               class172.field2733[var0] = false;
            }
         }
      }
   }
}
