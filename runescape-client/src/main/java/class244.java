import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class244 extends CacheableNode {
   @ObfuscatedName("e")
   public boolean field3318;
   @ObfuscatedName("i")
   public static IndexDataBase field3319;
   @ObfuscatedName("c")
   public static NodeCache field3320;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "3"
   )
   public void method4330(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4331(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method4331(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3318 = true;
      }

   }

   static {
      field3320 = new NodeCache(64);
   }

   public class244() {
      this.field3318 = false;
   }
}
