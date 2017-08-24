import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public enum class150 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2210(0, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2213(3, 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2206(2, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2207(1, 3);

   @ObfuscatedName("d")
   @Export("blendedSaturation")
   static int[] blendedSaturation;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -195133697
   )
   final int field2209;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1944729461
   )
   public final int field2211;

   class150(int var3, int var4) {
      this.field2211 = var3;
      this.field2209 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field2209;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "906741009"
   )
   public static void method2975(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Leg;",
      garbageValue = "660549024"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class24.method204(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
