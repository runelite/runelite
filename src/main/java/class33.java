import java.awt.Frame;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class33 {
   @ObfuscatedName("x")
   static final class33 field767 = new class33();
   @ObfuscatedName("t")
   static final class33 field768 = new class33();
   @ObfuscatedName("p")
   static final class33 field769 = new class33();
   @ObfuscatedName("cm")
   public static char field772;
   @ObfuscatedName("qk")
   protected static Frame field773;
   @ObfuscatedName("w")
   static final class33 field774 = new class33();
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1750642347
   )
   static int field778;
   @ObfuscatedName("v")
   static class80[] field779;

   @ObfuscatedName("w")
   public static int method729(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "987149267"
   )
   static final void method730(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class129.field2062[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field96[0][var5][var4] = class5.field96[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.field96[0][var5][var4] = class5.field96[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field96[0][var5][var4] = class5.field96[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class5.field96[0][var5][var4] = class5.field96[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
