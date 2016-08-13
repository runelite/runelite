import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class162 implements class115 {
   @ObfuscatedName("pv")
   static class224 field2659;
   @ObfuscatedName("g")
   public static final class162 field2660 = new class162(1, 1);
   @ObfuscatedName("r")
   public static final class162 field2661 = new class162(2, 2);
   @ObfuscatedName("e")
   public static final class162 field2662 = new class162(3, 3);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -509824033
   )
   public final int field2663;
   @ObfuscatedName("l")
   public static final class162 field2664 = new class162(0, 0);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 923561967
   )
   final int field2665;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1633970528"
   )
   public int vmethod3316() {
      return this.field2665;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2663 = var1;
      this.field2665 = var2;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1222081853"
   )
   static final void method3319() {
      for(class16 var0 = (class16)Client.field427.method3980(); null != var0; var0 = (class16)Client.field427.method3970()) {
         if(var0.field237 > 0) {
            --var0.field237;
         }

         if(var0.field237 == 0) {
            if(var0.field232 < 0 || class53.method1150(var0.field232, var0.field228)) {
               class20.method572(var0.field239, var0.field229, var0.field238, var0.field231, var0.field232, var0.field233, var0.field228);
               var0.unlink();
            }
         } else {
            if(var0.field241 > 0) {
               --var0.field241;
            }

            if(var0.field241 == 0 && var0.field238 >= 1 && var0.field231 >= 1 && var0.field238 <= 102 && var0.field231 <= 102 && (var0.field235 < 0 || class53.method1150(var0.field235, var0.field230))) {
               class20.method572(var0.field239, var0.field229, var0.field238, var0.field231, var0.field235, var0.field236, var0.field230);
               var0.field241 = -1;
               if(var0.field232 == var0.field235 && var0.field232 == -1) {
                  var0.unlink();
               } else if(var0.field235 == var0.field232 && var0.field233 == var0.field236 && var0.field228 == var0.field230) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
