import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -371844743
   )
   int field151;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -810644023
   )
   int field149;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -801785305
   )
   int field150;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1875344279
   )
   int field148;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1505412507
   )
   int field158;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -982476941
   )
   int field153;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1493586109
   )
   int field154;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1127711415
   )
   int field155;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1071123955
   )
   int field152;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2016816929
   )
   int field157;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Li;I)V",
      garbageValue = "-1657983190"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.minX > this.field154) {
         var1.minX = this.field154;
      }

      if(var1.field177 < this.field152) {
         var1.field177 = this.field152;
      }

      if(var1.minY > this.field155) {
         var1.minY = this.field155;
      }

      if(var1.field179 < this.field157) {
         var1.field179 = this.field157;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1329615536"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field151 && var1 < this.field149 + this.field151?var2 >> 6 >= this.field150 && var2 >> 6 <= this.field158 && var3 >> 6 >= this.field148 && var3 >> 6 <= this.field153:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1150064833"
   )
   public boolean vmethod694(int var1, int var2) {
      return var1 >> 6 >= this.field154 && var1 >> 6 <= this.field152 && var2 >> 6 >= this.field155 && var2 >> 6 <= this.field157;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1657440355"
   )
   public int[] vmethod712(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field154 * 64 - this.field150 * 64 + var2, var3 + (this.field155 * 64 - this.field148 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhh;",
      garbageValue = "2126255726"
   )
   public Coordinates vmethod707(int var1, int var2) {
      if(!this.vmethod694(var1, var2)) {
         return null;
      } else {
         int var3 = this.field150 * 64 - this.field154 * 64 + var1;
         int var4 = this.field148 * 64 - this.field155 * 64 + var2;
         return new Coordinates(this.field151, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgy;S)V",
      garbageValue = "255"
   )
   public void vmethod697(Buffer var1) {
      this.field151 = var1.readUnsignedByte();
      this.field149 = var1.readUnsignedByte();
      this.field150 = var1.readUnsignedShort();
      this.field148 = var1.readUnsignedShort();
      this.field158 = var1.readUnsignedShort();
      this.field153 = var1.readUnsignedShort();
      this.field154 = var1.readUnsignedShort();
      this.field155 = var1.readUnsignedShort();
      this.field152 = var1.readUnsignedShort();
      this.field157 = var1.readUnsignedShort();
      this.method198();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
   )
   void method198() {
   }

   @ObfuscatedName("w")
   public static final void method218(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            WorldMapData.method293(var0 - 1L);
            WorldMapData.method293(1L);
         } else {
            WorldMapData.method293(var0);
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfu;Lfm;I)Z",
      garbageValue = "-1973918780"
   )
   public static final boolean method219(int var0, int var1, int var2, class166 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class165.field2059[var7][var8] = 99;
      class165.field2058[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class165.field2061[var11] = var0;
      int var20 = var11 + 1;
      class165.field2060[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label318:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label295:
                     do {
                        if(var20 == var12) {
                           Bounds.field3748 = var5;
                           ScriptState.field463 = var6;
                           return false;
                        }

                        var5 = class165.field2061[var12];
                        var6 = class165.field2060[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3457(var2, var5, var6, var4)) {
                           Bounds.field3748 = var5;
                           ScriptState.field463 = var6;
                           return true;
                        }

                        var16 = class165.field2058[var18][var19] + 1;
                        if(var18 > 0 && class165.field2059[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class165.field2061[var20] = var5 - 1;
                                 class165.field2060[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class165.field2059[var18 - 1][var19] = 2;
                                 class165.field2058[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class165.field2059[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class165.field2061[var20] = var5 + 1;
                                 class165.field2060[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class165.field2059[var18 + 1][var19] = 8;
                                 class165.field2058[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class165.field2059[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class165.field2061[var20] = var5;
                                 class165.field2060[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class165.field2059[var18][var19 - 1] = 1;
                                 class165.field2058[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class165.field2059[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class165.field2061[var20] = var5;
                                 class165.field2060[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class165.field2059[var18][var19 + 1] = 4;
                                 class165.field2058[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class165.field2059[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class165.field2061[var20] = var5 - 1;
                                 class165.field2060[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class165.field2059[var18 - 1][var19 - 1] = 3;
                                 class165.field2058[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class165.field2059[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class165.field2061[var20] = var5 + 1;
                                 class165.field2060[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class165.field2059[var18 + 1][var19 - 1] = 9;
                                 class165.field2058[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class165.field2059[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label295;
                              }
                           }

                           class165.field2061[var20] = var5 - 1;
                           class165.field2060[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class165.field2059[var18 - 1][var19 + 1] = 6;
                           class165.field2058[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class165.field2059[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label318;
               }
            }

            class165.field2061[var20] = var5 + 1;
            class165.field2060[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class165.field2059[var18 + 1][var19 + 1] = 12;
            class165.field2058[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
