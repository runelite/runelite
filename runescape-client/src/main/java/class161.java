import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class161 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1662140617
   )
   static int field2138;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2084309480"
   )
   static void method3178(int var0) {
      if(var0 == -1 && !Client.field439) {
         class138.field1919.method2672();
         class138.field1921 = 1;
         class138.field1924 = null;
      } else if(var0 != -1 && var0 != Client.field528 && Client.field544 != 0 && !Client.field439) {
         Renderable.method1971(2, Client.field306, var0, 0, Client.field544, false);
      }

      Client.field528 = var0;
   }

   class161() throws Throwable {
      throw new Error();
   }
}
