import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 385040307
   )
   @Export("level")
   int level;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2008759881
   )
   @Export("type")
   int type;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1557662453
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 799939429
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1071753051
   )
   int field1140;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1004995705
   )
   int field1141;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1108987413
   )
   int field1142;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2048199829
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2140050245
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1483058037
   )
   int field1145;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1835930035
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1028985825
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1477168548"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var1 = class231.method4261(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class222.varpsMasks[var4 - var3];
      return class222.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIILeh;[Lfi;B)V",
      garbageValue = "-128"
   )
   static final void method1552(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class61.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               Ignore.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
