import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class251 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field3392;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static NodeCache field3391;
   @ObfuscatedName("k")
   public boolean field3390;

   static {
      field3391 = new NodeCache(64);
   }

   public class251() {
      this.field3390 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "223696815"
   )
   public void method4486(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4480(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;IS)V",
      garbageValue = "-26883"
   )
   void method4480(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3390 = true;
      }

   }
}
