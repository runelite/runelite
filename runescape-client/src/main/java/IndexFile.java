import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1805007521
   )
   int field2301;
   @ObfuscatedName("e")
   class123 field2302;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1639414541
   )
   static int field2303;
   @ObfuscatedName("c")
   static byte[] field2304;
   @ObfuscatedName("v")
   class123 field2305;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 801275237
   )
   @Export("index")
   int index;
   @ObfuscatedName("f")
   public static byte[][] field2307;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1104666051"
   )
   public byte[] method3008(int var1) {
      class123 var2 = this.field2302;
      synchronized(this.field2302) {
         try {
            Object var10000;
            if(this.field2305.method2317() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2305.method2316((long)(var1 * 6));
               this.field2305.method2329(field2304, 0, 6);
               int var3 = ((field2304[1] & 255) << 8) + ((field2304[0] & 255) << 16) + (field2304[2] & 255);
               int var4 = ((field2304[4] & 255) << 8) + ((field2304[3] & 255) << 16) + (field2304[5] & 255);
               if(var3 < 0 || var3 > this.field2301) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2302.method2317() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2302.method2316((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2302.method2329(field2304, 0, var8 + 8);
                     int var9 = ((field2304[0] & 255) << 8) + (field2304[1] & 255);
                     int var10 = ((field2304[2] & 255) << 8) + (field2304[3] & 255);
                     int var11 = ((field2304[5] & 255) << 8) + ((field2304[4] & 255) << 16) + (field2304[6] & 255);
                     int var12 = field2304[7] & 255;
                     if(var1 == var9 && var10 == var7 && this.index == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2302.method2317() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2304[var13 + 8];
                           }

                           var4 = var11;
                           ++var7;
                           continue;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     var10000 = null;
                     return (byte[])var10000;
                  }

                  byte[] var18 = var5;
                  return var18;
               }
            }
         } catch (IOException var16) {
            return null;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "90"
   )
   public boolean method3009(int var1, byte[] var2, int var3) {
      class123 var4 = this.field2302;
      synchronized(this.field2302) {
         if(var3 >= 0 && var3 <= this.field2301) {
            boolean var5 = this.method3010(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3010(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1529806568"
   )
   boolean method3010(int var1, byte[] var2, int var3, boolean var4) {
      class123 var5 = this.field2302;
      synchronized(this.field2302) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2305.method2317() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2305.method2316((long)(var1 * 6));
               this.field2305.method2329(field2304, 0, 6);
               var6 = (field2304[5] & 255) + ((field2304[4] & 255) << 8) + ((field2304[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2302.method2317() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2302.method2317() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2304[0] = (byte)(var3 >> 16);
            field2304[1] = (byte)(var3 >> 8);
            field2304[2] = (byte)var3;
            field2304[3] = (byte)(var6 >> 16);
            field2304[4] = (byte)(var6 >> 8);
            field2304[5] = (byte)var6;
            this.field2305.method2316((long)(var1 * 6));
            this.field2305.method2321(field2304, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2302.method2316((long)(var6 * 520));

                        try {
                           this.field2302.method2329(field2304, 0, 8);
                        } catch (EOFException var16) {
                           break label144;
                        }

                        var14 = ((field2304[0] & 255) << 8) + (field2304[1] & 255);
                        int var11 = ((field2304[2] & 255) << 8) + (field2304[3] & 255);
                        var9 = ((field2304[4] & 255) << 16) + ((field2304[5] & 255) << 8) + (field2304[6] & 255);
                        int var12 = field2304[7] & 255;
                        if(var1 != var14 || var8 != var11 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2302.method2317() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2302.method2317() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var9 == var6) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2304[0] = (byte)(var1 >> 8);
                     field2304[1] = (byte)var1;
                     field2304[2] = (byte)(var8 >> 8);
                     field2304[3] = (byte)var8;
                     field2304[4] = (byte)(var9 >> 16);
                     field2304[5] = (byte)(var9 >> 8);
                     field2304[6] = (byte)var9;
                     field2304[7] = (byte)this.index;
                     this.field2302.method2316((long)(var6 * 520));
                     this.field2302.method2321(field2304, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2302.method2321(var2, var7, var14);
                     var7 += var14;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   static {
      field2304 = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILclass123;Lclass123;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class123 var2, class123 var3, int var4) {
      this.field2302 = null;
      this.field2305 = null;
      this.field2301 = '\ufde8';
      this.index = var1;
      this.field2302 = var2;
      this.field2305 = var3;
      this.field2301 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "3"
   )
   static int method3011(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class232.field3187:class2.field15;
      }

      if(var0 == 1927) {
         if(class83.field1368 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2760 == null) {
            return 0;
         } else {
            class69 var4 = new class69();
            var4.field852 = var3;
            var4.field849 = var3.field2760;
            var4.field857 = class83.field1368 + 1;
            Client.field955.method3571(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "0"
   )
   static final int method3012(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WorldMapType3.method199(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Buffer.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class211.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class222.field2835[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = World.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2834[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WorldMapType3.method199(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Buffer.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class211.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = FileOnDisk.method2363(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = class41.baseX + (World.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = (World.localPlayer.y >> 7) + WorldMapType3.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
