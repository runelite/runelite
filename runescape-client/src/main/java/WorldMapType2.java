import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field492;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1736955763
   )
   int field495;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -805871261
   )
   int field485;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1637387201
   )
   int field487;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -583171105
   )
   int field489;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1347037819
   )
   int field494;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1507303041
   )
   int field490;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "-2145049745"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field424 > this.field494) {
         var1.field424 = this.field494;
      }

      if(var1.field417 < this.field494) {
         var1.field417 = this.field494;
      }

      if(var1.field425 > this.field490) {
         var1.field425 = this.field490;
      }

      if(var1.field431 < this.field490) {
         var1.field431 = this.field490;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1120247978"
   )
   public boolean vmethod708(int var1, int var2, int var3) {
      return var1 >= this.field495 && var1 < this.field495 + this.field485?var2 >> 6 == this.field487 && var3 >> 6 == this.field489:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1865125342"
   )
   public boolean vmethod698(int var1, int var2) {
      return var1 >> 6 == this.field494 && var2 >> 6 == this.field490;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1197920526"
   )
   public int[] vmethod700(int var1, int var2, int var3) {
      if(!this.vmethod708(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field494 * 64 - this.field487 * 64 + var2, var3 + (this.field490 * 64 - this.field489 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Lhc;",
      garbageValue = "-879620257"
   )
   public Coordinates vmethod714(int var1, int var2) {
      if(!this.vmethod698(var1, var2)) {
         return null;
      } else {
         int var3 = this.field487 * 64 - this.field494 * 64 + var1;
         int var4 = this.field489 * 64 - this.field490 * 64 + var2;
         return new Coordinates(this.field495, var3, var4);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1638498953"
   )
   public void vmethod701(Buffer var1) {
      this.field495 = var1.readUnsignedByte();
      this.field485 = var1.readUnsignedByte();
      this.field487 = var1.readUnsignedShort();
      this.field489 = var1.readUnsignedShort();
      this.field494 = var1.readUnsignedShort();
      this.field490 = var1.readUnsignedShort();
      this.method516();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-800660046"
   )
   void method516() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1090796653"
   )
   static void method526(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1203[var5] != var0) {
            var2[var4] = World.field1203[var5];
            var3[var4] = World.field1197[var5];
            ++var4;
         }
      }

      World.field1203 = var2;
      World.field1197 = var3;
      FontName.method4874(ItemContainer.worldList, 0, ItemContainer.worldList.length - 1, World.field1203, World.field1197);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2001543290"
   )
   static synchronized void method534(byte[] var0) {
      if(var0.length == 100 && class185.field2521 < 1000) {
         class185.field2524[++class185.field2521 - 1] = var0;
      } else if(var0.length == 5000 && class185.field2519 < 250) {
         class185.field2522[++class185.field2519 - 1] = var0;
      } else if(var0.length == 30000 && class185.field2520 < 50) {
         class185.field2523[++class185.field2520 - 1] = var0;
      } else {
         if(class21.field324 != null) {
            for(int var1 = 0; var1 < CombatInfo1.field1189.length; ++var1) {
               if(var0.length == CombatInfo1.field1189[var1] && class185.field2518[var1] < class21.field324[var1].length) {
                  class21.field324[var1][class185.field2518[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2032046999"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + class61.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] + class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
