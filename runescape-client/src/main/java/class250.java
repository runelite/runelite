import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public enum class250 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3366(1, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3363(2, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3364(0, 2);

   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1593602001
   )
   public final int field3365;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1530608881
   )
   final int field3362;

   class250(int var3, int var4) {
      this.field3365 = var3;
      this.field3362 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field3362;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "1089959020"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "26961"
   )
   public static void method4401() {
      KitDefinition.identKits.reset();
   }
}
