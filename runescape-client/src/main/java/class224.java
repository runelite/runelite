import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class224 {
   @ObfuscatedName("k")
   static Buffer field2849;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   static void method4069() {
      class61.field757 = 99;
      class61.underlayIds = new byte[4][104][104];
      class61.overlayIds = new byte[4][104][104];
      class61.overlayPaths = new byte[4][104][104];
      class13.overlayRotations = new byte[4][104][104];
      class47.field607 = new int[4][105][105];
      class47.field605 = new byte[4][105][105];
      Friend.field819 = new int[105][105];
      class61.field762 = new int[104];
      class61.field763 = new int[104];
      class215.field2637 = new int[104];
      class61.field764 = new int[104];
      class61.field756 = new int[104];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LIndexData;IIIBZI)V",
      garbageValue = "-1735421096"
   )
   static void method4072(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class234 var8 = (class234)class238.field3252.method3520(var6);
      if(var8 == null) {
         var8 = (class234)class238.field3266.method3520(var6);
         if(var8 == null) {
            var8 = (class234)class238.field3253.method3520(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3600();
                  class238.field3252.method3516(var8, var6);
                  --class238.field3258;
                  ++class238.field3259;
               }

            } else {
               if(!var5) {
                  var8 = (class234)class238.field3269.method3520(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class234();
               var8.field3214 = var0;
               var8.field3209 = var3;
               var8.field3210 = var4;
               if(var5) {
                  class238.field3252.method3516(var8, var6);
                  ++class238.field3259;
               } else {
                  class238.field3256.method3472(var8);
                  class238.field3253.method3516(var8, var6);
                  ++class238.field3258;
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "-6"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3601.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class164.method3070(Sequence.field3600, Sequence.field3610, var0, false);
         if(var1 != null) {
            Sequence.field3601.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
