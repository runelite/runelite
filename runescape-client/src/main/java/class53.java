import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class53 extends CacheableNode {
   @ObfuscatedName("h")
   public static NodeCache field1146 = new NodeCache(64);
   @ObfuscatedName("i")
   public static class170 field1147;
   @ObfuscatedName("e")
   public boolean field1151 = false;
   @ObfuscatedName("is")
   static Widget field1153;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "37529934"
   )
   void method1087(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1151 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "45"
   )
   public void method1090(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1087(var1, var2);
      }
   }
}
