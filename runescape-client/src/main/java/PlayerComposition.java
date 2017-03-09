import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("j")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("c")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -8341243796978140431L
   )
   long field2162;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 1445424957776506923L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1813219375
   )
   public int field2164;
   @ObfuscatedName("e")
   static final int[] field2165 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("x")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("q")
   public static NodeCache field2168 = new NodeCache(260);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1187801697"
   )
   public void method3161(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2165[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field918 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field918) {
                     var3 = 0;
                  }
               }

               var4 = class181.getKitDefinition(var3);
            } while(null == var4 || var4.field2822 || var4.field2821 != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2165[var1]] = var3 + 256;
            this.method3165();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "747949366"
   )
   public void method3162(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class6.field62[var1].length - 1;
            }
         } while(!class160.method3101(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class6.field62[var1].length) {
               var3 = 0;
            }
         } while(!class160.method3101(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3165();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "69"
   )
   public void method3164(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3183((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-144845487"
   )
   void method3165() {
      long var1 = this.hash;
      int var3 = this.equipmentIds[5];
      int var4 = this.equipmentIds[9];
      this.equipmentIds[5] = var4;
      this.equipmentIds[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.equipmentIds[var5] >= 256) {
            this.hash += (long)(this.equipmentIds[var5] - 256);
         }
      }

      if(this.equipmentIds[0] >= 256) {
         this.hash += (long)(this.equipmentIds[0] - 256 >> 4);
      }

      if(this.equipmentIds[1] >= 256) {
         this.hash += (long)(this.equipmentIds[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.equipmentIds[5] = var3;
      this.equipmentIds[9] = var4;
      if(var1 != 0L && var1 != this.hash) {
         field2168.remove(var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "70370705"
   )
   public Model method3166(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2164 != -1) {
         return VertexNormal.getNpcDefinition(this.field2164).method3708(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(null != var1 && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.equipmentIds[var15];
            }

            if(var1.leftHandItem >= 0) {
               var5 += (long)(var1.leftHandItem - this.equipmentIds[5] << 40);
               var7[5] = var1.leftHandItem;
            }

            if(var1.rightHandItem >= 0) {
               var5 += (long)(var1.rightHandItem - this.equipmentIds[3] << 48);
               var7[3] = var1.rightHandItem;
            }
         }

         Model var8 = (Model)field2168.get(var5);
         if(var8 == null) {
            boolean var16 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class181.getKitDefinition(var11 - 256).ready()) {
                  var16 = true;
               }

               if(var11 >= 512 && !class154.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(this.field2162 != -1L) {
                  var8 = (Model)field2168.get(this.field2162);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class181.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class154.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class6.field62[var13].length) {
                     var18.method1555(class164.field2145[var13], class6.field62[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class138.field1921[var13].length) {
                     var18.method1555(class15.field187[var13], class138.field1921[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.method1543(64, 850, -30, -50, -30);
               field2168.put(var8, var5);
               this.field2162 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var9;
            if(null != var1 && null != var3) {
               var9 = var1.method3777(var8, var2, var3, var4);
            } else if(var1 != null) {
               var9 = var1.method3763(var8, var2);
            } else {
               var9 = var3.method3763(var8, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1949849781"
   )
   ModelData method3167() {
      if(this.field2164 != -1) {
         return VertexNormal.getNpcDefinition(this.field2164).method3709();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class181.getKitDefinition(var3 - 256).method3506()) {
               var1 = true;
            }

            if(var3 >= 512 && !class154.getItemDefinition(var3 - 512).method3667(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class181.getKitDefinition(var5 - 256).method3527();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class154.getItemDefinition(var5 - 512).method3658(this.isFemale);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class6.field62[var5].length) {
                  var8.method1555(class164.field2145[var5], class6.field62[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class138.field1921[var5].length) {
                  var8.method1555(class15.field187[var5], class138.field1921[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-308081188"
   )
   public int method3168() {
      return this.field2164 == -1?this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.equipmentIds[0] << 15) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + VertexNormal.getNpcDefinition(this.field2164).id;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "377685174"
   )
   public void method3174(Buffer var1) {
      var1.method2843(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2165[var2]];
         if(var3 == 0) {
            var1.method2843(-1);
         } else {
            var1.method2843(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2843(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-847257336"
   )
   public void method3183(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field918; ++var6) {
               KitDefinition var7 = class181.getKitDefinition(var6);
               if(null != var7 && !var7.field2822 && var7.field2821 == (var3?7:0) + var5) {
                  var1[field2165[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2164 = var4;
      this.method3165();
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "750823099"
   )
   static final void method3184(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod782()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.configs) {
               var6 = var6.method3719();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class45.field934;
         int[] var7 = class45.field925;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2414()) {
            class160.method3110(var0, var0.field654 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2411(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method2423()) {
               CombatInfo1 var10 = var9.method767(Client.gameCycle);
               if(null == var10) {
                  if(var9.method768()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3534();
                  SpritePixels var13 = var11.method3533();
                  int var15 = 0;
                  if(null != var12 && var13 != null) {
                     if(var11.field2841 * 2 < var13.width) {
                        var15 = var11.field2841;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var75 = Client.gameCycle - var10.field689;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var76;
                  int var88;
                  if(var10.field690 > var75) {
                     var76 = var11.field2836 == 0?0:var75 / var11.field2836 * var11.field2836;
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var88 = var21 + var76 * (var19 - var21) / var10.field690;
                  } else {
                     var88 = var19;
                     var76 = var11.field2829 + var10.field690 - var75;
                     if(var11.field2835 >= 0) {
                        var16 = (var76 << 8) / (var11.field2829 - var11.field2835);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var76 = var2 + Client.field355 - (var14 >> 1);
                  var21 = var3 + Client.field339 - var8;
                  if(var12 != null && null != var13) {
                     var76 -= var15;
                     if(var88 == var14) {
                        var88 += 2 * var15;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4165(var76, var21, var16);
                        Rasterizer2D.method3999(var76, var21, var88 + var76, var22 + var21);
                        var13.method4165(var76, var21, var16);
                     } else {
                        var12.method4149(var76, var21);
                        Rasterizer2D.method3999(var76, var21, var88 + var76, var22 + var21);
                        var13.method4149(var76, var21);
                     }

                     Rasterizer2D.method4016(var2, var3, var4 + var2, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field355 > -1) {
                        Rasterizer2D.method4028(var76, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4028(var76 + var88, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.field290) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class160.method3110(var0, var0.field654 + 15);
               if(Client.field355 > -1) {
                  if(var85.skullIcon != -1) {
                     class15.field194[var85.skullIcon].method4149(Client.field355 + var2 - 12, var3 + Client.field339 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class149.field2037[var85.overheadIcon].method4149(var2 + Client.field355 - 12, var3 + Client.field339 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field458 == 10 && Client.field362 == var7[var1]) {
               class160.method3110(var0, var0.field654 + 15);
               if(Client.field355 > -1) {
                  class15.field189[1].method4149(var2 + Client.field355 - 12, Client.field339 + var3 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(null != var86.configs) {
               var86 = var86.method3719();
            }

            if(var86.field3030 >= 0 && var86.field3030 < class149.field2037.length) {
               class160.method3110(var0, 15 + var0.field654);
               if(Client.field355 > -1) {
                  class149.field2037[var86.field3030].method4149(Client.field355 + var2 - 12, Client.field339 + var3 - 30);
               }
            }

            if(Client.field458 == 1 && Client.field570[var1 - var74] == Client.field329 && Client.gameCycle % 20 < 10) {
               class160.method3110(var0, var0.field654 + 15);
               if(Client.field355 > -1) {
                  class15.field189[0].method4149(var2 + Client.field355 - 12, Client.field339 + var3 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var74 || !var0.inSequence && (Client.field307 == 4 || !var0.field639 && (Client.field307 == 0 || Client.field307 == 3 || Client.field307 == 1 && MessageNode.method228(((Player)var0).name, false))))) {
            class160.method3110(var0, var0.field654);
            if(Client.field355 > -1 && Client.field352 < Client.field326) {
               Client.field370[Client.field352] = BufferProvider.field3198.method3876(var0.overhead) / 2;
               Client.field410[Client.field352] = BufferProvider.field3198.field3120;
               Client.field485[Client.field352] = Client.field355;
               Client.field493[Client.field352] = Client.field339;
               Client.field412[Client.field352] = var0.field642;
               Client.field413[Client.field352] = var0.field643;
               Client.field459[Client.field352] = var0.field641;
               Client.field501[Client.field352] = var0.overhead;
               ++Client.field352;
            }
         }

         for(int var77 = 0; var77 < 4; ++var77) {
            int var81 = var0.field677[var77];
            int var82 = var0.field645[var77];
            class196 var87 = null;
            int var83 = 0;
            if(var82 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = class171.method3266(var0.field645[var77]);
               var83 = var87.field2876;
               if(null != var87 && null != var87.field2864) {
                  var87 = var87.method3585();
                  if(var87 == null) {
                     var0.field677[var77] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field681[var77];
            class196 var79 = null;
            if(var14 >= 0) {
               var79 = class171.method3266(var14);
               if(null != var79 && null != var79.field2864) {
                  var79 = var79.method3585();
               }
            }

            if(var81 - var83 <= Client.gameCycle) {
               if(null == var87) {
                  var0.field677[var77] = -1;
               } else {
                  class160.method3110(var0, var0.field654 / 2);
                  if(Client.field355 > -1) {
                     if(var77 == 1) {
                        Client.field339 -= 20;
                     }

                     if(var77 == 2) {
                        Client.field355 -= 15;
                        Client.field339 -= 10;
                     }

                     if(var77 == 3) {
                        Client.field355 += 15;
                        Client.field339 -= 10;
                     }

                     SpritePixels var78 = null;
                     SpritePixels var18 = null;
                     SpritePixels var84 = null;
                     SpritePixels var20 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var78 = var87.method3602();
                     int var80;
                     if(null != var78) {
                        var21 = var78.width;
                        var80 = var78.height;
                        if(var80 > var41) {
                           var41 = var80;
                        }

                        var25 = var78.offsetX;
                     }

                     var18 = var87.method3588();
                     if(null != var18) {
                        var22 = var18.width;
                        var80 = var18.height;
                        if(var80 > var41) {
                           var41 = var80;
                        }

                        var26 = var18.offsetX;
                     }

                     var84 = var87.method3589();
                     if(null != var84) {
                        var23 = var84.width;
                        var80 = var84.height;
                        if(var80 > var41) {
                           var41 = var80;
                        }

                        var27 = var84.offsetX;
                     }

                     var20 = var87.method3590();
                     if(null != var20) {
                        var24 = var20.width;
                        var80 = var20.height;
                        if(var80 > var41) {
                           var41 = var80;
                        }

                        var28 = var20.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method3602();
                        if(var29 != null) {
                           var33 = var29.width;
                           var80 = var29.height;
                           if(var80 > var41) {
                              var41 = var80;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method3588();
                        if(null != var30) {
                           var34 = var30.width;
                           var80 = var30.height;
                           if(var80 > var41) {
                              var41 = var80;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method3589();
                        if(null != var31) {
                           var35 = var31.width;
                           var80 = var31.height;
                           if(var80 > var41) {
                              var41 = var80;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method3590();
                        if(var32 != null) {
                           var36 = var32.width;
                           var80 = var32.height;
                           if(var80 > var41) {
                              var41 = var80;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var42 = var87.method3591();
                     if(var42 == null) {
                        var42 = class31.field727;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method3591();
                        if(null == var43) {
                           var43 = class31.field727;
                        }
                     } else {
                        var43 = class31.field727;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3586(var0.field646[var77]);
                     int var89 = var42.method3876(var44);
                     if(var79 != null) {
                        var45 = var79.method3586(var0.field649[var77]);
                        var47 = var43.method3876(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var84 && null == var20) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
                        }
                     }

                     if(null != var79 && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var47 / var34;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(null != var79) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var34 * var49;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field677[var77] - Client.gameCycle;
                     int var62 = var87.field2881 - var87.field2881 * var61 / var87.field2876;
                     int var63 = -var87.field2882 + var61 * var87.field2882 / var87.field2876;
                     int var64 = var2 + Client.field355 - (var50 >> 1) + var62;
                     int var65 = var3 + Client.field339 - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = 15 + var65 + var87.field2886;
                     int var69 = var68 - var42.field3114;
                     int var70 = var42.field3115 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var79) {
                        var71 = var79.field2886 + 15 + var65;
                        var72 = var71 - var43.field3114;
                        var73 = var71 + var43.field3115;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2872 >= 0) {
                        var72 = (var61 << 8) / (var87.field2876 - var87.field2872);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var78 != null) {
                           var78.method4165(var64 + var51 - var25, var65, var72);
                        }

                        if(null != var84) {
                           var84.method4165(var52 + var64 - var27, var65, var72);
                        }

                        if(null != var18) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4165(var22 * var73 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(null != var20) {
                           var20.method4165(var64 + var55 - var28, var65, var72);
                        }

                        var42.method3882(var44, var54 + var64, var68, var87.field2875, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method4165(var56 + var64 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method4165(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4165(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4165(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3882(var45, var64 + var60, var71, var79.field2875, 0, var72);
                        }
                     } else {
                        if(var78 != null) {
                           var78.method4149(var64 + var51 - var25, var65);
                        }

                        if(var84 != null) {
                           var84.method4149(var52 + var64 - var27, var65);
                        }

                        if(null != var18) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4149(var22 * var73 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(null != var20) {
                           var20.method4149(var55 + var64 - var28, var65);
                        }

                        var42.method3881(var44, var64 + var54, var68, var87.field2875 | -16777216, 0);
                        if(var79 != null) {
                           if(null != var29) {
                              var29.method4149(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4149(var57 + var64 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4149(var34 * var73 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method4149(var59 + var64 - var40, var65);
                           }

                           var43.method3881(var45, var60 + var64, var71, var79.field2875 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
