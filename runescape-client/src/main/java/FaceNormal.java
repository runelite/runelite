import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 457884979
   )
   @Export("z")
   int z;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -744396141
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 65656505
   )
   @Export("x")
   int x;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "8"
   )
   public static byte[] method1906(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class130.method2605(var3):var3;
      } else if(var0 instanceof class132) {
         class132 var2 = (class132)var0;
         return var2.vmethod2615();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "-356794397"
   )
   static void method1907(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field698 = var0;
      var5.field699 = var1 * 128;
      var5.field700 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field701 = (var6 + var1) * 128;
      var5.field702 = (var2 + var7) * 128;
      var5.field704 = var3.ambientSoundId;
      var5.field703 = var3.field2969 * 128;
      var5.field713 = var3.field2923;
      var5.field707 = var3.field2971;
      var5.field708 = var3.field2959;
      if(var3.impostorIds != null) {
         var5.field711 = var3;
         var5.method653();
      }

      class31.field709.method2824(var5);
      if(var5.field708 != null) {
         var5.field712 = var5.field713 + (int)(Math.random() * (double)(var5.field707 - var5.field713));
      }

   }
}
