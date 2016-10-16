import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class56 extends CacheableNode {
   @ObfuscatedName("s")
   public static class170 field1198;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -631312065
   )
   public int field1199 = 0;
   @ObfuscatedName("t")
   public static NodeCache field1203 = new NodeCache(64);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-64"
   )
   void method1137(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method1138(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "255620902"
   )
   void method1138(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field1199 = var1.method2668();
      }

   }
}
