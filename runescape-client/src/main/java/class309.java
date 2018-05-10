import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
public class class309 implements Comparator {
   @ObfuscatedName("w")
   final boolean field3747;

   public class309(boolean var1) {
      this.field3747 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljn;Ljn;I)I",
      garbageValue = "1482542953"
   )
   int method5717(Nameable var1, Nameable var2) {
      return this.field3747?var1.getRsName().compareCleanName(var2.getRsName()):var2.getRsName().compareCleanName(var1.getRsName());
   }

   public int compare(Object var1, Object var2) {
      return this.method5717((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lec;",
      garbageValue = "-2034638643"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = SceneTilePaint.method2899(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
