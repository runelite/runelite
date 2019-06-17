import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("__ib_f")
   static EvictingDualNodeHashTable __ib_f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1358868971
   )
   @Export("size")
   public int size;

   InvDefinition() {
      this.size = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "628080573"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1763455566"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.__ag_302();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-121177696"
   )
   public static void method4754() {
      ParamKeyDefinition.ParamKeyDefinition_cached.clear();
   }

   static {
      __ib_f = new EvictingDualNodeHashTable(64);
   }
}
