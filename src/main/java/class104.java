import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public final class class104 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1523026305
   )
   int field1752;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 883972375
   )
   int field1753;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -701071919
   )
   int field1754;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 597203445
   )
   int field1755;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 656817795
   )
   int field1756;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1701995581
   )
   int field1757;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 169040005
   )
   int field1758;
   @ObfuscatedName("lo")
   static class130 field1759;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 336388635
   )
   int field1760;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1442369745
   )
   int field1761;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 885012975
   )
   int field1762;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1292411431
   )
   int field1763;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2113536973
   )
   int field1764;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -884943199
   )
   int field1765;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1504208699
   )
   int field1766;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 258028837
   )
   int field1767;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2062898311
   )
   int field1768;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 747706899
   )
   int field1769;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -393166407
   )
   int field1770;
   @ObfuscatedName("as")
   static class168 field1772;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "136"
   )
   static final void method2319() {
      for(class6 var0 = (class6)client.field412.method3825(); var0 != null; var0 = (class6)client.field412.method3827()) {
         if(var0.field103 == class48.field1063 && client.field289 <= var0.field109) {
            if(client.field289 >= var0.field108) {
               if(var0.field125 > 0) {
                  class34 var1 = client.field316[var0.field125 - 1];
                  if(var1 != null && var1.field804 >= 0 && var1.field804 < 13312 && var1.field814 >= 0 && var1.field814 < 13312) {
                     var0.method94(var1.field804, var1.field814, class59.method1263(var1.field804, var1.field814, var0.field103) - var0.field107, client.field289);
                  }
               }

               if(var0.field125 < 0) {
                  int var2 = -var0.field125 - 1;
                  class2 var3;
                  if(var2 == client.field401) {
                     var3 = class20.field572;
                  } else {
                     var3 = client.field387[var2];
                  }

                  if(null != var3 && var3.field804 >= 0 && var3.field804 < 13312 && var3.field814 >= 0 && var3.field814 < 13312) {
                     var0.method94(var3.field804, var3.field814, class59.method1263(var3.field804, var3.field814, var0.field103) - var0.field107, client.field289);
                  }
               }

               var0.method93(client.field355);
               class151.field2250.method1937(class48.field1063, (int)var0.field121, (int)var0.field124, (int)var0.field116, 60, var0, var0.field112, -1, false);
            }
         } else {
            var0.method3913();
         }
      }

   }

   @ObfuscatedName("e")
   static int method2320() {
      return 9;
   }

   @ObfuscatedName("y")
   static final int method2321(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
