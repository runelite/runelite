import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class243 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3310;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3311;
   @ObfuscatedName("e")
   public boolean field3312;

   static {
      field3310 = new NodeCache(64);
   }

   public class243() {
      this.field3312 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;IB)V",
      garbageValue = "-105"
   )
   void method4425(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3312 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "1951108438"
   )
   public void method4419(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4425(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "929162519"
   )
   public static void method4420() {
      class254.field3410.reset();
      class254.field3413.reset();
      class254.field3431.reset();
   }
}
