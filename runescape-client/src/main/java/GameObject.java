import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 266933475
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 599141107
   )
   @Export("height")
   int height;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 46362487
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1325697613
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1037185751
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 756850879
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("z")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2043310025
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 225441389
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1193165665
   )
   int field2198;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 325538583
   )
   int field2199;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 973085917
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -409014757
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 665329847
   )
   @Export("orientation")
   int orientation;

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2134850141"
   )
   static final void method2787(int var0) {
      int[] var1 = Actor.field1268.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class17.region.method2612(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class17.region.method2612(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = ((int)(Math.random() * 20.0D) + 238 - 10 << 16) + ((int)(Math.random() * 20.0D) + 238 - 10 << 8) + ((int)(Math.random() * 20.0D) + 238 - 10);
      var4 = (int)(Math.random() * 20.0D) + 238 - 10 << 16;
      Actor.field1268.method4932();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class22.method186(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class22.method186(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1134 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class17.region.method2659(Player.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class29.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var11 = Client.collisionMaps[Player.plane].flags;

                     for(int var12 = 0; var12 < 10; ++var12) {
                        int var13 = (int)(Math.random() * 4.0D);
                        if(var13 == 0 && var9 > 0 && var9 > var5 - 3 && (var11[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var13 == 1 && var9 < 103 && var9 < var5 + 3 && (var11[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var13 == 2 && var10 > 0 && var10 > var6 - 3 && (var11[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var13 == 3 && var10 < 103 && var10 < var6 + 3 && (var11[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field1137[Client.field1134] = Area.field3304[var8].method4189(false);
                  Client.field1180[Client.field1134] = var9;
                  Client.field900[Client.field1134] = var10;
                  ++Client.field1134;
               }
            }
         }
      }

      World.field1296.method4898();
   }

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }
}
