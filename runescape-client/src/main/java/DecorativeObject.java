import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1051141917
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -708225337
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1227970919
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1948265495
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("l")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1592622403
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -228390625
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("p")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -684859115
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -106029819
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -939056445
   )
   @Export("y")
   int y;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -72892583
   )
   static int field2158;

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1779752853"
   )
   static final void method2937(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class215.menuAction(var1, var2, var3, var4, var5, var6, class59.field717, class59.field729);
      }
   }

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }
}
