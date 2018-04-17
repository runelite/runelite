import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -905114669
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1716707329
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 355953863
   )
   @Export("height")
   int height;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -578308445
   )
   @Export("x")
   int x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -655554511
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1891180903
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1077887321
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1705717825
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2017876587
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1243283353
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1689595723
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1774788285
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2055602271
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2062036631
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(Lbz;III)V",
      garbageValue = "-841453657"
   )
   static void method3083(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = CombatInfo1.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.actionFrameCycle = 0;
            var0.actionAnimationDisable = var2;
            var0.field1193 = 0;
         }

         if(var3 == 2) {
            var0.field1193 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || CombatInfo1.getAnimation(var1).forcedPriority >= CombatInfo1.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.actionFrameCycle = 0;
         var0.actionAnimationDisable = var2;
         var0.field1193 = 0;
         var0.field1216 = var0.queueSize;
      }

   }
}
