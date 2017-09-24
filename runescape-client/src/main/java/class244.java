import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class244 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3315;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3317;
   @ObfuscatedName("t")
   static int[] field3318;
   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      intValue = 45619665
   )
   static int field3319;
   @ObfuscatedName("a")
   public boolean field3316;

   static {
      field3315 = new NodeCache(64);
   }

   public class244() {
      this.field3316 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-1789751322"
   )
   void method4318(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3316 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1883339833"
   )
   public void method4316(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4318(var1, var2);
      }
   }
}
