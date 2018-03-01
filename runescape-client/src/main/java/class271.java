import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class271 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field3475;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static NodeCache field3476;
   @ObfuscatedName("n")
   public boolean field3477;

   static {
      field3476 = new NodeCache(64);
   }

   class271() {
      this.field3477 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1884093876"
   )
   void method4920(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4921(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1825558500"
   )
   void method4921(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3477 = true;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljk;IB)Llv;",
      garbageValue = "-76"
   )
   public static IndexedSprite method4927(IndexDataBase var0, int var1) {
      return !GraphicsObject.method1846(var0, var1)?null:class19.method140();
   }
}
