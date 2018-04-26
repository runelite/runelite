import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class236 extends CacheableNode {
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -720108327
   )
   static int field2783;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1489685915
   )
   public final int field2780;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -856704949
   )
   public final int field2782;
   @ObfuscatedName("b")
   public final int[] field2781;
   @ObfuscatedName("z")
   public final int[] field2779;

   class236(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2780 = var1;
      this.field2782 = var2;
      this.field2781 = var3;
      this.field2779 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "60"
   )
   public boolean method4466(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2779.length) {
         int var3 = this.field2779[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2781[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Leu;",
      garbageValue = "-1905056126"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = Enum.method5042(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
