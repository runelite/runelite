import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("d")
   boolean field1885;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 509272557
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -70650453
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 966477479
   )
   int field1888;
   @ObfuscatedName("v")
   class128 field1889;
   @ObfuscatedName("g")
   class137 field1890;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -86577299
   )
   int field1891;
   @ObfuscatedName("p")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("l")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("r")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1464921991
   )
   int field1895;
   @ObfuscatedName("a")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("b")
   int[] field1897;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -670251893
   )
   int field1898;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2110195345
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   boolean field1900;
   @ObfuscatedName("m")
   boolean field1901;
   @ObfuscatedName("w")
   Tile field1902;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 906047659
   )
   int field1903;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1904394923
   )
   int field1904;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1235445247
   )
   int field1905;
   @ObfuscatedName("t")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 292919483
   )
   int field1907;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public static void method2530() {
      if(class50.keyboard != null) {
         class50 var0 = class50.keyboard;
         synchronized(class50.keyboard) {
            class50.keyboard = null;
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "272494502"
   )
   static void method2531() {
      class98.chatLineMap.clear();
      class98.field1519.method3561();
      class98.field1518.method3722();
      class98.field1520 = 0;
   }

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.field1897 = new int[5];
      this.field1898 = 0;
      this.field1888 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
