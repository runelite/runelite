import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static class232 field452;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   static IndexedSprite[] field438;
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -333902201
   )
   int field444;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1213657445
   )
   int field447;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1295949911
   )
   int field440;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1478621425
   )
   int field439;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -521167555
   )
   int field445;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1029040305
   )
   int field450;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1713890983
   )
   int field441;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1503012511
   )
   int field453;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1085610451
   )
   int field442;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1277519197
   )
   int field443;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2005574810"
   )
   public boolean vmethod700(int var1, int var2) {
      return var1 >> 6 >= this.field444 && var1 >> 6 <= this.field440 && var2 >> 6 >= this.field445 && var2 >> 6 <= this.field441;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2147483647"
   )
   public boolean vmethod699(int var1, int var2, int var3) {
      return var1 >= this.field447 && var1 < this.field447 + this.field439?var2 >> 6 >= this.field450 && var2 >> 6 <= this.field453 && var3 >> 6 >= this.field442 && var3 >> 6 <= this.field443:false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "1123585680"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field464 > this.field444) {
         var1.field464 = this.field444;
      }

      if(var1.field468 < this.field440) {
         var1.field468 = this.field440;
      }

      if(var1.field469 > this.field445) {
         var1.field469 = this.field445;
      }

      if(var1.field461 < this.field441) {
         var1.field461 = this.field441;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhg;",
      garbageValue = "-1413226110"
   )
   public Coordinates vmethod702(int var1, int var2) {
      if(!this.vmethod700(var1, var2)) {
         return null;
      } else {
         int var3 = this.field450 * 64 - this.field444 * 64 + var1;
         int var4 = this.field442 * 64 - this.field445 * 64 + var2;
         return new Coordinates(this.field447, var3, var4);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "880778915"
   )
   public int[] vmethod709(int var1, int var2, int var3) {
      if(!this.vmethod699(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field444 * 64 - this.field450 * 64 + var2, var3 + (this.field445 * 64 - this.field442 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "15"
   )
   public void vmethod703(Buffer var1) {
      this.field447 = var1.readUnsignedByte();
      this.field439 = var1.readUnsignedByte();
      this.field450 = var1.readUnsignedShort();
      this.field442 = var1.readUnsignedShort();
      this.field453 = var1.readUnsignedShort();
      this.field443 = var1.readUnsignedShort();
      this.field444 = var1.readUnsignedShort();
      this.field445 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field441 = var1.readUnsignedShort();
      this.method257();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1517425253"
   )
   void method257() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILfc;Lfw;Z[I[IB)I",
      garbageValue = "1"
   )
   public static int method274(int var0, int var1, int var2, class163 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class162.field2302[var8][var9] = 0;
            class162.field2295[var8][var9] = 99999999;
         }
      }

      boolean var27;
      if(var2 == 1) {
         var27 = ClanMember.method1138(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var27 = Signlink.method2991(var0, var1, var3, var4);
      } else {
         var27 = class85.method1712(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      int var10 = var1 - 64;
      int var11 = class162.field2296;
      int var12 = class162.field2292;
      int var13;
      int var14;
      int var16;
      if(!var27) {
         var13 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var15 = 10;
         var16 = var3.field2307;
         int var17 = var3.field2306;
         int var18 = var3.field2309;
         int var19 = var3.field2308;

         for(int var20 = var16 - var15; var20 <= var16 + var15; ++var20) {
            for(int var21 = var17 - var15; var21 <= var15 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class162.field2295[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var16) {
                     var24 = var16 - var20;
                  } else if(var20 > var16 + var18 - 1) {
                     var24 = var20 - (var16 + var18 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var13 || var13 == var26 && class162.field2295[var22][var23] < var14) {
                     var13 = var26;
                     var14 = class162.field2295[var22][var23];
                     var11 = var20;
                     var12 = var21;
                  }
               }
            }
         }

         if(var13 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var12 == var1) {
         return 0;
      } else {
         byte var28 = 0;
         class162.field2298[var28] = var11;
         var13 = var28 + 1;
         class162.field2299[var28] = var12;

         int var29;
         for(var14 = var29 = class162.field2302[var11 - var9][var12 - var10]; var0 != var11 || var12 != var1; var14 = class162.field2302[var11 - var9][var12 - var10]) {
            if(var29 != var14) {
               var29 = var14;
               class162.field2298[var13] = var11;
               class162.field2299[var13++] = var12;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var12;
            } else if((var14 & 4) != 0) {
               --var12;
            }
         }

         var16 = 0;

         while(var13-- > 0) {
            var6[var16] = class162.field2298[var13];
            var7[var16++] = class162.field2299[var13];
            if(var16 >= var6.length) {
               break;
            }
         }

         return var16;
      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1182563306"
   )
   static final void method275(int var0, int var1) {
      if(Client.field940 == 2) {
         class148.method2941(Client.field946 + (Client.hintArrowX - class22.baseX * 411265 << 7), (Client.hintArrowY - class273.baseY << 7) + Client.field1139, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class14.pkIcons[0].drawAt(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-896154779"
   )
   public static char method267(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }
}
