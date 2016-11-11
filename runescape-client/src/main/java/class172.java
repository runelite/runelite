import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class172 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -560183027
   )
   int field2747;
   @ObfuscatedName("h")
   public byte[] field2748;
   @ObfuscatedName("g")
   public class171 field2749;
   @ObfuscatedName("e")
   public class137 field2750;
   @ObfuscatedName("y")
   static int[] field2751;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1754114039"
   )
   public static int method3400(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1332032795"
   )
   static final boolean method3401(Widget var0) {
      if(var0.field2888 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2888.length; ++var1) {
            int var2 = class40.method801(var0, var1);
            int var3 = var0.field2916[var1];
            if(var0.field2888[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2888[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2888[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
