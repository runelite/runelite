import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class270 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field3471;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static NodeCache field3474;
   @ObfuscatedName("n")
   public boolean field3472;

   static {
      field3474 = new NodeCache(64);
   }

   class270() {
      this.field3472 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "331983508"
   )
   void method4912(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4908(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "517940811"
   )
   void method4908(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3472 = true;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Lki;",
      garbageValue = "0"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }
}
