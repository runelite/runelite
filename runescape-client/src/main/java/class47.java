import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class47 {
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 22189417
   )
   int field567;
   @ObfuscatedName("i")
   byte[][][] field570;

   class47(int var1) {
      this.field567 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-53"
   )
   void method699(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field567 != 0 && this.field570 != null) {
         var8 = this.method700(var8, var7);
         var7 = this.method701(var7);
         Rasterizer2D.method5747(var1, var2, var5, var6, var3, var4, this.field570[var7 - 1][var8], this.field567);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1759550487"
   )
   int method700(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-792514335"
   )
   int method701(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   void method740() {
      if(this.field570 == null) {
         this.field570 = new byte[8][4][];
         this.method723();
         this.method719();
         this.method705();
         this.method706();
         this.method707();
         this.method708();
         this.method736();
         this.method709();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "516463769"
   )
   void method723() {
      byte[] var1 = new byte[this.field567 * this.field567];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[0][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[0][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[0][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[0][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2055008837"
   )
   void method719() {
      byte[] var1 = new byte[this.field567 * this.field567];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[1][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field570[1][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[1][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[1][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-336561981"
   )
   void method705() {
      byte[] var1 = new byte[this.field567 * this.field567];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[2][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[2][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[2][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[2][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   void method706() {
      byte[] var1 = new byte[this.field567 * this.field567];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[3][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[3][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[3][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[3][3] = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   void method707() {
      byte[] var1 = new byte[this.field567 * this.field567];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[4][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[4][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[4][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var2 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field570[4][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-140861178"
   )
   void method708() {
      byte[] var1 = new byte[this.field567 * this.field567];
      boolean var2 = false;
      var1 = new byte[this.field567 * this.field567];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[5][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var3 <= this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[5][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[5][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var3 >= this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[5][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-394836092"
   )
   void method736() {
      byte[] var1 = new byte[this.field567 * this.field567];
      boolean var2 = false;
      var1 = new byte[this.field567 * this.field567];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[6][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 <= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[6][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[6][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[6][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   void method709() {
      byte[] var1 = new byte[this.field567 * this.field567];
      boolean var2 = false;
      var1 = new byte[this.field567 * this.field567];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[7][0] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field567; ++var4) {
            if(var4 >= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[7][1] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = this.field567 - 1; var3 >= 0; --var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[7][2] = var1;
      var1 = new byte[this.field567 * this.field567];
      var5 = 0;

      for(var3 = 0; var3 < this.field567; ++var3) {
         for(var4 = this.field567 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field567 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field570[7][3] = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-39889280"
   )
   static final void method743(String var0) {
      class189.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "87368901"
   )
   public static void method745() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Lib;II)I",
      garbageValue = "1673032722"
   )
   static final int method713(Widget var0, int var1) {
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
                  var10 = class3.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!GameObject.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class237.clientVarps[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class248.field2998[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class237.clientVarps[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = WorldComparator.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class248.field3000[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class3.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!GameObject.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class237.clientVarps[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class88.getVarbit(var9);
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
                  var7 = (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX;
               }

               if(var6 == 19) {
                  var7 = (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY;
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
