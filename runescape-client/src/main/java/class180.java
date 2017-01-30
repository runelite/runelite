import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class180 extends Node {
   @ObfuscatedName("q")
   class184 field2689;
   @ObfuscatedName("x")
   class116 field2690;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -207831159
   )
   int field2691;
   @ObfuscatedName("g")
   byte[] field2693;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "0"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3050.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class204.method3805(Sequence.field3045, Sequence.field3044, var0, false);
         if(var1 != null) {
            Sequence.field3050.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1043583457"
   )
   static final void method3267(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field410.method2412(); null != var10; var10 = (class25)Client.field410.method2426()) {
         if(var0 == var10.field565 && var1 == var10.field560 && var10.field562 == var2 && var3 == var10.field559) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field565 = var0;
         var9.field559 = var3;
         var9.field560 = var1;
         var9.field562 = var2;
         class33.method683(var9);
         Client.field410.method2407(var9);
      }

      var9.field572 = var4;
      var9.field568 = var5;
      var9.field567 = var6;
      var9.field569 = var7;
      var9.field570 = var8;
   }
}
