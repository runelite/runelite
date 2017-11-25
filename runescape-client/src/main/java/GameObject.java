import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1040235295
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1850709219
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2113350775
   )
   @Export("height")
   int height;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1222975009
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -498878787
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 920225325
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 958723559
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1282150425
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 520453821
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2130704747
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -800787599
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1899654925
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1801845417
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "4"
   )
   static final String method3018(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1952560282"
   )
   static final void method3019() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class70.method1129(var3, 1);
         }
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "297135502"
   )
   static String method3020(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
