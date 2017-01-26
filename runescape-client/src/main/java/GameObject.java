import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -476245549
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -347666479
   )
   @Export("height")
   int height;
   @ObfuscatedName("d")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -640105555
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1235532091
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 952629845
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1893916709
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 501345255
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1010420433
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -765188891
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1500262413
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 63953377
   )
   int field1621;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -739510581
   )
   int field1622;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 813624143
   )
   @Export("flags")
   int flags = 0;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-307136958"
   )
   static final void method1915() {
      if(Friend.field152 != null) {
         Friend.field152.method2059();
         Friend.field152 = null;
      }

      class63.method1132();
      Renderable.region.method1796();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2264();
      }

      System.gc();
      class138.field1921 = 1;
      Item.field887 = null;
      class181.field2695 = -1;
      Frames.field1569 = -1;
      class105.field1721 = 0;
      class138.field1922 = false;
      class138.field1926 = 2;
      Client.field515 = -1;
      Client.field516 = false;
      ItemComposition.method3701();
      class212.setGameState(10);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1303059927"
   )
   static boolean method1916(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
