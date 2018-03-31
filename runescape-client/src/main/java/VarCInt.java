import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("VarCInt")
public class VarCInt extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3473;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3474;
   @ObfuscatedName("o")
   public boolean field3475;

   static {
      field3474 = new NodeCache(64);
   }

   VarCInt() {
      this.field3475 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-719711696"
   )
   void method4774(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4773(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;IB)V",
      garbageValue = "12"
   )
   void method4773(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3475 = true;
      }

   }
}
