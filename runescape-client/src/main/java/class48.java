import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 824451033
   )
   static int field605;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -382653861
   )
   int field613;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -812541569
   )
   int field608;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 110440781
   )
   int field612;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 95999197
   )
   int field604;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 28485849
   )
   int field606;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -854363033
   )
   int field615;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1259089425
   )
   int field609;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2066451499
   )
   int field611;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -110173959
   )
   int field607;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 54548825
   )
   int field610;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-39567884"
   )
   public boolean vmethod705(int var1, int var2) {
      return var1 >= (this.field608 << 6) + (this.field612 << 3) && var1 <= (this.field608 << 6) + (this.field612 << 3) + 7 && var2 >= (this.field609 << 6) + (this.field611 << 3) && var2 <= (this.field609 << 6) + (this.field611 << 3) + 7;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2062801574"
   )
   public boolean vmethod704(int var1, int var2, int var3) {
      return var1 >= this.field613 && var1 < this.field604 + this.field613?var2 >= (this.field606 << 6) + (this.field615 << 3) && var2 <= (this.field606 << 6) + (this.field615 << 3) + 7 && var3 >= (this.field607 << 6) + (this.field610 << 3) && var3 <= (this.field607 << 6) + (this.field610 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "-3"
   )
   public void vmethod703(WorldMapData var1) {
      if(var1.field457 > this.field608) {
         var1.field457 = this.field608;
      }

      if(var1.field460 < this.field608) {
         var1.field460 = this.field608;
      }

      if(var1.field453 > this.field609) {
         var1.field453 = this.field609;
      }

      if(var1.field462 < this.field609) {
         var1.field462 = this.field609;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "578346769"
   )
   public Coordinates vmethod728(int var1, int var2) {
      if(!this.vmethod705(var1, var2)) {
         return null;
      } else {
         int var3 = this.field606 * 64 - this.field608 * 64 + (this.field615 * 8 - this.field612 * 8) + var1;
         int var4 = this.field610 * 8 - this.field611 * 8 + this.field607 * 64 - this.field609 * 64 + var2;
         return new Coordinates(this.field613, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-670381390"
   )
   public int[] vmethod706(int var1, int var2, int var3) {
      if(!this.vmethod704(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field612 * 8 - this.field615 * 8 + this.field608 * 64 - this.field606 * 64 + var2, this.field609 * 64 - this.field607 * 64 + var3 + (this.field611 * 8 - this.field610 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "0"
   )
   public void vmethod716(Buffer var1) {
      this.field613 = var1.readUnsignedByte();
      this.field604 = var1.readUnsignedByte();
      this.field606 = var1.readUnsignedShort();
      this.field615 = var1.readUnsignedByte();
      this.field607 = var1.readUnsignedShort();
      this.field610 = var1.readUnsignedByte();
      this.field608 = var1.readUnsignedShort();
      this.field612 = var1.readUnsignedByte();
      this.field609 = var1.readUnsignedShort();
      this.field611 = var1.readUnsignedByte();
      this.method709();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "112"
   )
   void method709() {
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-83"
   )
   static final void method727(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class29.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class84.region.method2736(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class84.region.method2737(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class84.region.method2738(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class84.region.method2739(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class84.region.method2740(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class84.region.method2726(var0, var2, var3);
               var12 = WorldMapType1.getObjectDefinition(var13);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.field3433);
               }
            }

            if(var1 == 1) {
               class84.region.method2729(var0, var2, var3);
            }

            if(var1 == 2) {
               class84.region.method2730(var0, var2, var3);
               var12 = WorldMapType1.getObjectDefinition(var13);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field3433);
               }
            }

            if(var1 == 3) {
               class84.region.method2731(var0, var2, var3);
               var12 = WorldMapType1.getObjectDefinition(var13);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class45.method649(var0, var11, var2, var3, var4, var5, var6, class84.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-86"
   )
   static final int method729(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
