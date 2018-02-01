import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("p")
   public static Applet field2101;
   @ObfuscatedName("i")
   public static String field2098;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 901072021
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("s")
   String field2100;
   @ObfuscatedName("j")
   Throwable field2097;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;I)V",
      garbageValue = "-1933326918"
   )
   public static void method3090(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      class3.NpcDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-2"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "(IIIILko;Lhu;I)V",
      garbageValue = "1693025659"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5546(var10 + var5.field2686 / 2 - var4.maxWidth / 2, var5.field2684 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2686, var5.field2684, var5.field2685, var5.field2683);
            } else {
               var4.drawAt(var0 + var10 + var5.field2686 / 2 - var4.maxWidth / 2, var5.field2684 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
