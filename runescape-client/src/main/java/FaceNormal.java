import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("nm")
   static class59 field1492;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1532902221
   )
   int field1493;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -694829337
   )
   int field1494;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 984115225
   )
   int field1495;
   @ObfuscatedName("qz")
   protected static java.awt.Frame field1496;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 292663601
   )
   public static int field1499;
   @ObfuscatedName("pp")
   static class137 field1501;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZB)LFrames;",
      garbageValue = "10"
   )
   public static Frames method1938(class170 var0, class170 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3289(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3295(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3295(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
