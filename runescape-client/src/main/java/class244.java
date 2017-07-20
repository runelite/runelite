import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class244 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3292;
   @ObfuscatedName("p")
   public static short[] field3296;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3293;
   @ObfuscatedName("i")
   public boolean field3294;

   static {
      field3292 = new NodeCache(64);
   }

   public class244() {
      this.field3294 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "4"
   )
   void method4217(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3294 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-23"
   )
   public void method4215(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4217(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "2105124159"
   )
   public static int method4222(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
