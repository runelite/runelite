import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public final class class29 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   static IndexedSprite[] field400;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   final class41 this$0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -606741539
   )
   int field396;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2048766113
   )
   int field395;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1233560507
   )
   int field394;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1424848413
   )
   int field398;

   @ObfuscatedSignature(
      signature = "(Lay;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "-130818799"
   )
   static final boolean method237(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class134.field1964 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class134.field1964 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class134.field1967 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class134.field1967 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }
}
