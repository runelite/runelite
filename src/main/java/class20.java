import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class20 implements class112 {
   @ObfuscatedName("w")
   static final class20 field578 = new class20(0);
   @ObfuscatedName("x")
   static final class20 field579 = new class20(1);
   @ObfuscatedName("t")
   static final class20 field580 = new class20(2);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 492642527
   )
   final int field582;
   @ObfuscatedName("c")
   public static short[][] field584;
   @ObfuscatedName("p")
   static final class20 field586 = new class20(3);

   @ObfuscatedName("w")
   public int vmethod3196() {
      return this.field582;
   }

   class20(int var1) {
      this.field582 = var1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-1795019811"
   )
   static final void method580(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(0 == var0.field249) {
         var1 = class3.field75.method1927(var0.field243, var0.field238, var0.field239);
      }

      if(var0.field249 == 1) {
         var1 = class3.field75.method1935(var0.field243, var0.field238, var0.field239);
      }

      if(var0.field249 == 2) {
         var1 = class3.field75.method1936(var0.field243, var0.field238, var0.field239);
      }

      if(3 == var0.field249) {
         var1 = class3.field75.method1978(var0.field243, var0.field238, var0.field239);
      }

      if(0 != var1) {
         int var5 = class3.field75.method1938(var0.field243, var0.field238, var0.field239, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field240 = var2;
      var0.field242 = var3;
      var0.field241 = var4;
   }
}
