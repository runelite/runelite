import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class55 {
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "Lcg;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ljq;",
      garbageValue = "12"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
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
