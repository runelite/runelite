import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class255 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3380;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   public static NodeCache field3379;
   @ObfuscatedName("r")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("w")
   public boolean field3378;

   static {
      field3379 = new NodeCache(64);
   }

   public class255() {
      this.field3378 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "1952917597"
   )
   public void method4592(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4590(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "1693290455"
   )
   void method4590(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3378 = true;
      }

   }
}
