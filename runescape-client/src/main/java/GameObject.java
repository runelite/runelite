import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1348482943
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1639834407
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1250418639
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -515129617
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 335509333
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1496584953
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -88415481
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -943111231
   )
   int field2169;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1119553957
   )
   int field2170;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 116027087
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -95297751
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 250399303
   )
   @Export("height")
   int height;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -361333291
   )
   @Export("relativeX")
   int relativeX;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1251408739"
   )
   static boolean method2938(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-121"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      CombatInfoListHolder.addChatMessage(var0, var1, var2, (String)null);
   }
}
