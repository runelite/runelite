import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3280;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3281;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -135933061
   )
   public int field3279;

   static {
      field3280 = new NodeCache(64);
   }

   public InvType() {
      this.field3279 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "1728090237"
   )
   void method4223(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3279 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-389165341"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4223(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lii;",
      garbageValue = "1672639787"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3337.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }
}
