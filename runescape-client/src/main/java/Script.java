import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   static NodeCache field1445;
   @ObfuscatedName("fs")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("p")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("i")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("j")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2037752291
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1605158983
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -596211317
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1932965255
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lgd;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1445 = new NodeCache(128);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)[Lgd;",
      garbageValue = "48"
   )
   IterableHashTable[] method1919(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lfi;",
      garbageValue = "1"
   )
   public static class169[] method1918() {
      return new class169[]{class169.field2412, class169.field2411, class169.field2410, class169.field2413, class169.field2414, class169.field2417, class169.field2416, class169.field2415, class169.field2418, class169.field2419};
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(IIIILkd;Lhm;I)V",
      garbageValue = "190302259"
   )
   static final void method1928(int var0, int var1, int var2, int var3, SpritePixels var4, class217 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2683 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class36.mapedge.method5365(var15 + (var0 + var5.field2683 / 2 - var17 / 2), var5.field2680 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class56.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
