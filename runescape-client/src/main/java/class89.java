import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class89 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1796124861
   )
   int field1379;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2087937887
   )
   int field1377;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 525111815
   )
   int field1378;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -883226139
   )
   int field1380;
   @ObfuscatedName("g")
   String field1381;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "1932656632"
   )
   static final boolean method1657(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class134.field1948 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class134.field1948 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class134.field1953 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class134.field1953 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }
}
