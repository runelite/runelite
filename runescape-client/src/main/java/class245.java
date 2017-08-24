import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class245 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field3321;
   @ObfuscatedName("q")
   static int[] field3324;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field3325;
   @ObfuscatedName("a")
   public boolean field3322;

   static {
      field3321 = new NodeCache(64);
   }

   class245() {
      this.field3322 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-863597769"
   )
   void method4322(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3322 = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "84"
   )
   void method4321(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4322(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Liu;",
      garbageValue = "-25"
   )
   public static CombatInfo2 method4329(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3366.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3370.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4397(new Buffer(var2));
         }

         CombatInfo2.field3366.put(var1, (long)var0);
         return var1;
      }
   }
}
