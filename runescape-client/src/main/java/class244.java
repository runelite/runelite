import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class244 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -814261035
   )
   static int field3321;
   @ObfuscatedName("w")
   static NodeCache field3322;
   @ObfuscatedName("a")
   public boolean field3323;
   @ObfuscatedName("i")
   static IndexDataBase field3324;
   @ObfuscatedName("p")
   static int[] field3326;
   @ObfuscatedName("ee")
   @Export("rssocket")
   static RSSocket rssocket;

   class244() {
      this.field3323 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1195020013"
   )
   void method4323(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4333(var1, var2);
      }
   }

   static {
      field3322 = new NodeCache(64);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-93085471"
   )
   void method4333(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3323 = true;
      }

   }
}
