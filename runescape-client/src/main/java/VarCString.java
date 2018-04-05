import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("VarCString")
public class VarCString extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field3481;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public static NodeCache field3480;
   @ObfuscatedName("t")
   public boolean field3479;

   static {
      field3480 = new NodeCache(64);
   }

   public VarCString() {
      this.field3479 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-1483814143"
   )
   public void method4787(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4788(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "-26927667"
   )
   void method4788(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3479 = true;
      }

   }
}
