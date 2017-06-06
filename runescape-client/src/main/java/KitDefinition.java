import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("n")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("c")
   static IndexDataBase field3348;
   @ObfuscatedName("f")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -937825039
   )
   public static int field3350;
   @ObfuscatedName("y")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("h")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("x")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("v")
   static NodeCache field3354;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1638058149
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("a")
   @Export("models")
   int[] models;
   @ObfuscatedName("o")
   @Export("nonSelectable")
   public boolean nonSelectable;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1942746338"
   )
   void method4371(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4384(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-72"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3348.method4111(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "46"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var4 = 0; var4 < this.modelIds.length; ++var4) {
            var1[var4] = ModelData.method2427(field3348, this.modelIds[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorToFind != null) {
            for(var3 = 0; var3 < this.recolorToFind.length; ++var3) {
               var2.method2409(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var2.method2450(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "917989112"
   )
   public boolean method4374() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3348.method4111(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   static {
      field3354 = new NodeCache(64);
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1029358524"
   )
   static final void method4378(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class33.field473.method4730(var0, 250);
      int var6 = class33.field473.method4765(var0, 250) * 13;
      Rasterizer2D.method4923(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.method4945(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      class33.field473.method4745(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class46.method689(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         class166.field2343.vmethod5008(0, 0);
      } else {
         class92.method1736(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "40505378"
   )
   public ModelData method4381() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2427(field3348, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorToFind != null) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var5.method2409(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(this.retextureToFind != null) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var5.method2450(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "25526"
   )
   void method4384(Buffer var1, int var2) {
      if(var2 == 1) {
         this.bodyPartId = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.modelIds = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.modelIds[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.nonSelectable = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorToFind = new short[var3];
            this.recolorToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorToFind[var4] = (short)var1.readUnsignedShort();
               this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureToFind = new short[var3];
            this.retextureToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureToFind[var4] = (short)var1.readUnsignedShort();
               this.retextureToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2098190381"
   )
   static final void method4395(int var0, int var1, int var2, int var3) {
      if(Client.field1083 == 0 && !Client.field1085) {
         class3.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class134.field2013; ++var6) {
         var7 = class134.field2014[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class1.region.method2835(FaceNormal.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class226.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.field1083 == 1) {
                  class3.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + WorldMapData.method337('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field1085) {
                  if((class64.field808 & 4) == 4) {
                     class3.addMenuEntry(Client.field1088, Client.field1089 + " " + "->" + " " + WorldMapData.method337('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var21 = var12.actions;
                  if(Client.field1101) {
                     var21 = Actor.method1518(var21);
                  }

                  if(var21 != null) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var21[var14] != null) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class3.addMenuEntry(var21[var14], WorldMapData.method337('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class3.addMenuEntry("Examine", WorldMapData.method337('\uffff') + var12.name, 1002, var12.field3439 << 14, var8, var9);
               }
            }

            int var13;
            Player var16;
            NPC var18;
            int var26;
            int[] var27;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3577 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.field968; ++var13) {
                     var18 = Client.cachedNPCs[Client.field950[var13]];
                     if(var18 != null && var23 != var18 && var18.composition.field3577 == 1 && var18.x == var23.x && var23.y == var18.y) {
                        class164.method3068(var18.composition, Client.field950[var13], var8, var9);
                     }
                  }

                  var13 = class96.field1507;
                  var27 = class96.field1508;

                  for(var26 = 0; var26 < var13; ++var26) {
                     var16 = Client.cachedPlayers[var27[var26]];
                     if(var16 != null && var23.x == var16.x && var16.y == var23.y) {
                        class13.method67(var16, var27[var26], var8, var9);
                     }
                  }
               }

               class164.method3068(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.field968; ++var13) {
                     var18 = Client.cachedNPCs[Client.field950[var13]];
                     if(var18 != null && var18.composition.field3577 == 1 && var18.x == var24.x && var24.y == var18.y) {
                        class164.method3068(var18.composition, Client.field950[var13], var8, var9);
                     }
                  }

                  var13 = class96.field1507;
                  var27 = class96.field1508;

                  for(var26 = 0; var26 < var13; ++var26) {
                     var16 = Client.cachedPlayers[var27[var26]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var24.y == var16.y) {
                        class13.method67(var16, var27[var26], var8, var9);
                     }
                  }
               }

               if(Client.field1059 != var11) {
                  class13.method67(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[FaceNormal.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.method3574(); var29 != null; var29 = (Item)var25.method3582()) {
                     ItemComposition var28 = Buffer.getItemDefinition(var29.id);
                     if(Client.field1083 == 1) {
                        class3.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + WorldMapData.method337(16748608) + var28.name, 16, var29.id, var8, var9);
                     } else if(Client.field1085) {
                        if((class64.field808 & 1) == 1) {
                           class3.addMenuEntry(Client.field1088, Client.field1089 + " " + "->" + " " + WorldMapData.method337(16748608) + var28.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var20 = var28.groundActions;
                        if(Client.field1101) {
                           var20 = Actor.method1518(var20);
                        }

                        for(int var19 = 4; var19 >= 0; --var19) {
                           if(var20 != null && var20[var19] != null) {
                              byte var17 = 0;
                              if(var19 == 0) {
                                 var17 = 18;
                              }

                              if(var19 == 1) {
                                 var17 = 19;
                              }

                              if(var19 == 2) {
                                 var17 = 20;
                              }

                              if(var19 == 3) {
                                 var17 = 21;
                              }

                              if(var19 == 4) {
                                 var17 = 22;
                              }

                              class3.addMenuEntry(var20[var19], WorldMapData.method337(16748608) + var28.name, var17, var29.id, var8, var9);
                           } else if(var19 == 2) {
                              class3.addMenuEntry("Take", WorldMapData.method337(16748608) + var28.name, 20, var29.id, var8, var9);
                           }
                        }

                        class3.addMenuEntry("Examine", WorldMapData.method337(16748608) + var28.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var22 = Client.cachedPlayers[Client.field1059];
         class13.method67(var22, Client.field1059, var6, var7);
      }

   }
}
