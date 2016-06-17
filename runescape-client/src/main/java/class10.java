import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class10 extends class107 {
   @ObfuscatedName("ly")
   static class130 field156;
   @ObfuscatedName("y")
   @Export("isMembersWorld")
   public static boolean field157;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 952589441
   )
   public static int field158;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -1719145271
   )
   static int field159;
   @ObfuscatedName("z")
   static int[] field161;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "504031139"
   )
   public boolean vmethod2385(int var1, int var2, int var3, class108 var4) {
      return super.field1864 == var2 && var3 == super.field1861;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method127(boolean var0) {
      for(int var1 = 0; var1 < client.field449; ++var1) {
         class34 var2 = client.field326[client.field318[var1]];
         int var3 = 536870912 + (client.field318[var1] << 14);
         if(null != var2 && var2.vmethod760() && var2.field762.field876 == var0 && var2.field762.method769()) {
            int var4 = var2.field813 >> 7;
            int var5 = var2.field791 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field832 == 1 && (var2.field813 & 127) == 64 && (var2.field791 & 127) == 64) {
                  if(client.field393[var4][var5] == client.field565) {
                     continue;
                  }

                  client.field393[var4][var5] = client.field565;
               }

               if(!var2.field762.field892) {
                  var3 -= Integer.MIN_VALUE;
               }

               class150.field2230.method1936(class144.field2193, var2.field813, var2.field791, class108.method2413(var2.field832 * 64 - 64 + var2.field813, var2.field791 + (var2.field832 * 64 - 64), class144.field2193), 60 + (var2.field832 * 64 - 64), var2, var2.field792, var3, var2.field793);
            }
         }
      }

   }
}
