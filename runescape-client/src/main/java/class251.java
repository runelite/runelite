import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class251 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3376;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   static NodeCache field3375;
   @ObfuscatedName("i")
   public boolean field3377;

   static {
      field3375 = new NodeCache(64);
   }

   class251() {
      this.field3377 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;B)V",
      garbageValue = "-51"
   )
   void method4507(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4508(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "481868979"
   )
   void method4508(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3377 = true;
      }

   }
}
