import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3249;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static class13 field3251;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2038853075
   )
   public int field3248;

   static {
      field3249 = new NodeCache(64);
   }

   public InvType() {
      this.field3248 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "11"
   )
   void method4173(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3248 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-82"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4173(var1, var2);
      }
   }
}
