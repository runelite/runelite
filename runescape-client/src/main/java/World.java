import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("World")
public class World {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 233222155
   )
   @Export("worldsCount")
   static int worldsCount;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1143875805
   )
   @Export("__bt_g")
   static int __bt_g;
   @ObfuscatedName("l")
   @Export("sortOption2")
   static int[] sortOption2;
   @ObfuscatedName("e")
   @Export("sortOption1")
   static int[] sortOption1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -144265493
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 956991319
   )
   @Export("properties")
   int properties;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1863464125
   )
   @Export("population")
   int population;
   @ObfuscatedName("i")
   @Export("host")
   String host;
   @ObfuscatedName("a")
   @Export("activity")
   String activity;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1942858323
   )
   @Export("location")
   int location;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1147427427
   )
   @Export("index")
   int index;

   static {
      worldsCount = 0;
      __bt_g = 0;
      sortOption2 = new int[]{1, 1, 1, 1};
      sortOption1 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1059414592"
   )
   @Export("isMembersOnly")
   boolean isMembersOnly() {
      return (1 & this.properties) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("__x_145")
   boolean __x_145() {
      return (2 & this.properties) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-354931924"
   )
   @Export("isPvp")
   boolean isPvp() {
      return (4 & this.properties) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1662622660"
   )
   @Export("__a_147")
   boolean __a_147() {
      return (8 & this.properties) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   @Export("isDeadman")
   boolean isDeadman() {
      return (0x20000000 & this.properties) != 0; // 1 << 29
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2033779841"
   )
   @Export("isBeta")
   boolean isBeta() {
      return (0x2000000 & this.properties) != 0; // 1 << 25
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1569234522"
   )
   public static int method1759(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
