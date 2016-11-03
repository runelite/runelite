import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class14 {
   @ObfuscatedName("f")
   int[] field204;
   @ObfuscatedName("k")
   class23 field207;
   @ObfuscatedName("v")
   static ModIcon[] field209;
   @ObfuscatedName("c")
   String[] field210;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -448968341
   )
   int field211 = -1;
   @ObfuscatedName("pl")
   static GarbageCollectorMXBean field213;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-928651067"
   )
   static final void method150(class125 var0) {
      for(int var1 = 0; var1 < class34.field779; ++var1) {
         int var2 = class34.field767[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.method2571();
         if((var4 & 32) != 0) {
            var4 += var0.method2571() << 8;
         }

         class158.method3192(var0, var2, var3, var4);
      }

   }
}
