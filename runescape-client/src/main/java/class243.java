import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class243 extends CacheableNode {
   @ObfuscatedName("i")
   public static IndexDataBase field3302;
   @ObfuscatedName("h")
   public static NodeCache field3303;
   @ObfuscatedName("u")
   public boolean field3304;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 91362615
   )
   public static int field3305;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2098860661"
   )
   public void method4389(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4390(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "11567"
   )
   void method4390(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3304 = true;
      }

   }

   public class243() {
      this.field3304 = false;
   }

   static {
      field3303 = new NodeCache(64);
   }
}
