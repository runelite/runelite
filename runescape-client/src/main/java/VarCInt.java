import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("VarCInt")
public class VarCInt extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static IndexDataBase field3476;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static NodeCache field3475;
   @ObfuscatedName("t")
   public boolean field3474;

   static {
      field3475 = new NodeCache(64);
   }

   VarCInt() {
      this.field3474 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "1794549395"
   )
   void method4773(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4774(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "1325185739"
   )
   void method4774(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3474 = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "1535285612"
   )
   static String method4785(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
