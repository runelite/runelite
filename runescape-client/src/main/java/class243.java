import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class243 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3287;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3286;
   @ObfuscatedName("i")
   public boolean field3289;

   static {
      field3287 = new NodeCache(64);
   }

   class243() {
      this.field3289 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "2130374377"
   )
   void method4205(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3289 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-107370927"
   )
   void method4206(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4205(var1, var2);
      }
   }
}
