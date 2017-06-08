import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("World")
public class World {
   @ObfuscatedName("h")
   static int[] field1294;
   @ObfuscatedName("f")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1326457781
   )
   static int field1297;
   @ObfuscatedName("z")
   static int[] field1299;
   @ObfuscatedName("p")
   public static Area[] field1300;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 957194697
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -910845355
   )
   @Export("index")
   int index;
   @ObfuscatedName("y")
   @Export("activity")
   String activity;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 499653957
   )
   @Export("location")
   int location;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 64786275
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1453230757
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("gm")
   static SpritePixels[] field1310;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1401279325
   )
   static int field1311;
   @ObfuscatedName("a")
   @Export("address")
   String address;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1256762219"
   )
   boolean method1518() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-63"
   )
   boolean method1519() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "95"
   )
   boolean method1521() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1176830075"
   )
   boolean method1522() {
      return (536870912 & this.mask) != 0;
   }

   static {
      field1297 = 0;
      field1311 = 0;
      field1299 = new int[]{1, 1, 1, 1};
      field1294 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2099288440"
   )
   boolean method1554() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "680765666"
   )
   boolean method1560() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "2122063009"
   )
   static final void method1563(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -class109.method2058(var2 + 932731 + var4, var3 + 556238 + var5) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class21.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class234.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
