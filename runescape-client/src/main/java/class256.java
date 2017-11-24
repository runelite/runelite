import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class256 {
   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   static MachineInfo field3447;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lej;",
      garbageValue = "-18"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class33.method359(Sequence.skel_ref, class273.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
