import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class56 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -827355575
   )
   public int field1218 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -186828433
   )
   public static int field1220;
   @ObfuscatedName("py")
   static class137 field1221;
   @ObfuscatedName("e")
   public static NodeCache field1223 = new NodeCache(64);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1509500960"
   )
   void method1169(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field1218 = var1.method2546();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "2047"
   )
   void method1170(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1169(var1, var2);
      }
   }
}
