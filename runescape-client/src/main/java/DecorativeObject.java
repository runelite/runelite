import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2061814305
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -698917207
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 450495679
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1442680789
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 180143651
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 132619937
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 438325865
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1273591553
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1977494167
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1769847128"
   )
   public static boolean method3163(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
