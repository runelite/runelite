import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("t")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("d")
   static final int[] field2694;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field2695;
   @ObfuscatedName("b")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("s")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("r")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -379361125
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 1979643396248585181L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -5325364583960365397L
   )
   long field2689;

   static {
      field2694 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2695 = new NodeCache(260);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "0"
   )
   public void method3982(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class210.field2591; ++var6) {
               KitDefinition var7 = Coordinates.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var5 + (var3?7:0) == var7.bodyPartId) {
                  var1[field2694[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.transformedNpcId = var4;
      this.setHash();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IZS)V",
      garbageValue = "18103"
   )
   public void method3983(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2694[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class210.field2591 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class210.field2591) {
                     var3 = 0;
                  }
               }

               var4 = Coordinates.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2694[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1534875609"
   )
   public void method3984(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = colorsToReplace[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= colorsToReplace[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "328"
   )
   public void method3985(boolean var1) {
      if(this.isFemale != var1) {
         this.method3982((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "1433172144"
   )
   public void method3986(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2694[var2]];
         if(var3 == 0) {
            var1.putByte(-1);
         } else {
            var1.putByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.putByte(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1881440672"
   )
   @Export("setHash")
   void setHash() {
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
         field2695.remove(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljh;ILjh;II)Lev;",
      garbageValue = "1828920169"
   )
   public Model method3999(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class211.getNpcDefinition(this.transformedNpcId).method4636(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.equipmentIds[var8];
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

         Model var15 = (Model)field2695.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !Coordinates.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class139.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2689) {
                  var15 = (Model)field2695.get(this.field2689);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = Coordinates.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class139.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var18.recolor(class91.colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class5.field26[var13].length) {
                     var18.recolor(VertexNormal.field1910[var13], class5.field26[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2695.put(var15, var5);
               this.field2689 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4704(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4699(var15, var2);
            } else {
               var17 = var3.method4699(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lda;",
      garbageValue = "-2073517684"
   )
   ModelData method3989() {
      if(this.transformedNpcId != -1) {
         return class211.getNpcDefinition(this.transformedNpcId).method4637();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !Coordinates.getKitDefinition(var3 - 256).method4359()) {
               var1 = true;
            }

            if(var3 >= 512 && !class139.getItemDefinition(var3 - 512).method4580(this.isFemale)) {
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
                  var6 = Coordinates.getKitDefinition(var5 - 256).method4360();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class139.getItemDefinition(var5 - 512).method4581(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < colorsToReplace[var5].length) {
                  var8.recolor(class91.colorsToFind[var5], colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class5.field26[var5].length) {
                  var8.recolor(VertexNormal.field1910[var5], class5.field26[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1485971678"
   )
   public int method3990() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class211.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lbv;II)V",
      garbageValue = "-1701179426"
   )
   static void method3988(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field785;
      Script var3;
      int var28;
      if(class150.method2926(var0.field786)) {
         class25.field342 = (class47)var2[0];
         Area var4 = Area.field3345[class25.field342.field559];
         var3 = class153.method2949(var0.field786, var4.field3348, var4.field3365);
      } else {
         var28 = ((Integer)var2[0]).intValue();
         Script var6 = (Script)Script.field1436.get((long)var28);
         Script var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var50 = class29.indexScripts.getConfigData(var28, 0);
            if(var50 == null) {
               var5 = null;
            } else {
               var6 = class96.method1822(var50);
               Script.field1436.put(var6, (long)var28);
               var5 = var6;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class82.intStackSize = 0;
         class259.scriptStringStackSize = 0;
         var28 = -1;
         int[] var55 = var3.instructions;
         int[] var56 = var3.intOperands;
         byte var7 = -1;
         class82.scriptStackCount = 0;

         int var10;
         try {
            GZipDecompressor.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class82.scriptLocalStrings = new String[var3.localStringCount];
            int var9 = 0;

            int var11;
            String var29;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var11 = ((Integer)var2[var10]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field778;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field775;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field783;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field781 != null?var0.field781.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field781 != null?var0.field781.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field782;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field780;
                  }

                  GZipDecompressor.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var29 = (String)var2[var10];
                  if(var29.equals("event_opbase")) {
                     var29 = var0.field784;
                  }

                  class82.scriptLocalStrings[var9++] = var29;
               }
            }

            var10 = 0;
            class82.field1266 = var0.field779;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label3385:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var28;
                                                                                          int var57 = var55[var28];
                                                                                          int var12;
                                                                                          int var14;
                                                                                          int var15;
                                                                                          int var16;
                                                                                          int var34;
                                                                                          int var35;
                                                                                          String var67;
                                                                                          String var87;
                                                                                          String var111;
                                                                                          int[] var119;
                                                                                          if(var57 < 100) {
                                                                                             if(var57 != 0) {
                                                                                                if(var57 != 1) {
                                                                                                   if(var57 != 2) {
                                                                                                      if(var57 != 3) {
                                                                                                         if(var57 != 6) {
                                                                                                            if(var57 != 7) {
                                                                                                               if(var57 != 8) {
                                                                                                                  if(var57 != 9) {
                                                                                                                     if(var57 != 10) {
                                                                                                                        if(var57 != 21) {
                                                                                                                           if(var57 != 25) {
                                                                                                                              if(var57 != 27) {
                                                                                                                                 if(var57 != 31) {
                                                                                                                                    if(var57 != 32) {
                                                                                                                                       if(var57 != 33) {
                                                                                                                                          if(var57 != 34) {
                                                                                                                                             if(var57 != 35) {
                                                                                                                                                if(var57 != 36) {
                                                                                                                                                   if(var57 != 37) {
                                                                                                                                                      if(var57 != 38) {
                                                                                                                                                         if(var57 != 39) {
                                                                                                                                                            if(var57 != 40) {
                                                                                                                                                               if(var57 != 42) {
                                                                                                                                                                  if(var57 != 43) {
                                                                                                                                                                     if(var57 == 44) {
                                                                                                                                                                        var11 = var56[var28] >> 16;
                                                                                                                                                                        var12 = var56[var28] & 65535;
                                                                                                                                                                        int var128 = class82.intStack[--class82.intStackSize];
                                                                                                                                                                        if(var128 >= 0 && var128 <= 5000) {
                                                                                                                                                                           class82.field1258[var11] = var128;
                                                                                                                                                                           byte var118 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var118 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var15 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var15 >= var128) {
                                                                                                                                                                                 continue label3385;
                                                                                                                                                                              }

                                                                                                                                                                              class82.SHAPE_VERTICES[var11][var15] = var118;
                                                                                                                                                                              ++var15;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var57 == 45) {
                                                                                                                                                                        var11 = var56[var28];
                                                                                                                                                                        var12 = class82.intStack[--class82.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class82.field1258[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class82.SHAPE_VERTICES[var11][var12];
                                                                                                                                                                     } else if(var57 == 46) {
                                                                                                                                                                        var11 = var56[var28];
                                                                                                                                                                        class82.intStackSize -= 2;
                                                                                                                                                                        var12 = class82.intStack[class82.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class82.field1258[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.SHAPE_VERTICES[var11][var12] = class82.intStack[class82.intStackSize + 1];
                                                                                                                                                                     } else if(var57 == 47) {
                                                                                                                                                                        var29 = Renderable.chatMessages.getVarcString(var56[var28]);
                                                                                                                                                                        if(var29 == null) {
                                                                                                                                                                           var29 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var29;
                                                                                                                                                                     } else if(var57 == 48) {
                                                                                                                                                                        Renderable.chatMessages.putVarcString(var56[var28], class82.scriptStringStack[--class259.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var57 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var83 = var3.switches[var56[var28]];
                                                                                                                                                                        IntegerNode var113 = (IntegerNode)var83.get((long)class82.intStack[--class82.intStackSize]);
                                                                                                                                                                        if(var113 != null) {
                                                                                                                                                                           var28 += var113.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Renderable.chatMessages.putVarc(var56[var28], class82.intStack[--class82.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Renderable.chatMessages.getVarc(var56[var28]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var56[var28];
                                                                                                                                                               Script var92 = (Script)Script.field1436.get((long)var11);
                                                                                                                                                               Script var102;
                                                                                                                                                               if(var92 != null) {
                                                                                                                                                                  var102 = var92;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var127 = class29.indexScripts.getConfigData(var11, 0);
                                                                                                                                                                  if(var127 == null) {
                                                                                                                                                                     var102 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var92 = class96.method1822(var127);
                                                                                                                                                                     Script.field1436.put(var92, (long)var11);
                                                                                                                                                                     var102 = var92;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var92 = var102;
                                                                                                                                                               var119 = new int[var102.localIntCount];
                                                                                                                                                               String[] var123 = new String[var102.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var92.intStackCount; ++var16) {
                                                                                                                                                                  var119[var16] = class82.intStack[var16 + (class82.intStackSize - var92.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var92.stringStackCount; ++var16) {
                                                                                                                                                                  var123[var16] = class82.scriptStringStack[var16 + (class259.scriptStringStackSize - var92.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class82.intStackSize -= var92.intStackCount;
                                                                                                                                                               class259.scriptStringStackSize -= var92.stringStackCount;
                                                                                                                                                               ScriptState var114 = new ScriptState();
                                                                                                                                                               var114.invokedFromScript = var3;
                                                                                                                                                               var114.invokedFromPc = var28;
                                                                                                                                                               var114.savedLocalInts = GZipDecompressor.scriptLocalInts;
                                                                                                                                                               var114.savedLocalStrings = class82.scriptLocalStrings;
                                                                                                                                                               class82.scriptStack[++class82.scriptStackCount - 1] = var114;
                                                                                                                                                               var3 = var92;
                                                                                                                                                               var55 = var92.instructions;
                                                                                                                                                               var56 = var92.intOperands;
                                                                                                                                                               var28 = -1;
                                                                                                                                                               GZipDecompressor.scriptLocalInts = var119;
                                                                                                                                                               class82.scriptLocalStrings = var123;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class259.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class82.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var56[var28];
                                                                                                                                                      class259.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var90 = class82.scriptStringStack;
                                                                                                                                                      var14 = class259.scriptStringStackSize;
                                                                                                                                                      String var36;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var36 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         var87 = var90[var14];
                                                                                                                                                         if(var87 == null) {
                                                                                                                                                            var36 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var36 = var87.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var15 = var11 + var14;
                                                                                                                                                         var16 = 0;

                                                                                                                                                         for(var34 = var14; var34 < var15; ++var34) {
                                                                                                                                                            var67 = var90[var34];
                                                                                                                                                            if(var67 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var67.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var79 = new StringBuilder(var16);

                                                                                                                                                         for(var35 = var14; var35 < var15; ++var35) {
                                                                                                                                                            var111 = var90[var35];
                                                                                                                                                            if(var111 == null) {
                                                                                                                                                               var79.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var79.append(var111);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var36 = var79.toString();
                                                                                                                                                      }

                                                                                                                                                      class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var36;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class82.scriptLocalStrings[var56[var28]] = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class82.scriptStringStack[++class259.scriptStringStackSize - 1] = class82.scriptLocalStrings[var56[var28]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             GZipDecompressor.scriptLocalInts[var56[var28]] = class82.intStack[--class82.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = GZipDecompressor.scriptLocalInts[var56[var28]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class82.intStackSize -= 2;
                                                                                                                                       if(class82.intStack[class82.intStackSize] >= class82.intStack[class82.intStackSize + 1]) {
                                                                                                                                          var28 += var56[var28];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class82.intStackSize -= 2;
                                                                                                                                    if(class82.intStack[class82.intStackSize] <= class82.intStack[class82.intStackSize + 1]) {
                                                                                                                                       var28 += var56[var28];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var56[var28];
                                                                                                                                 var12 = class82.intStack[--class82.intStackSize];
                                                                                                                                 Varbit var33 = KeyFocusListener.method715(var11);
                                                                                                                                 var14 = var33.configId;
                                                                                                                                 var15 = var33.leastSignificantBit;
                                                                                                                                 var16 = var33.mostSignificantBit;
                                                                                                                                 var34 = class218.field2680[var16 - var15];
                                                                                                                                 if(var12 < 0 || var12 > var34) {
                                                                                                                                    var12 = 0;
                                                                                                                                 }

                                                                                                                                 var34 <<= var15;
                                                                                                                                 class218.widgetSettings[var14] = class218.widgetSettings[var14] & ~var34 | var12 << var15 & var34;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var56[var28];
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = class18.method131(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class82.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var81 = class82.scriptStack[--class82.scriptStackCount];
                                                                                                                           var3 = var81.invokedFromScript;
                                                                                                                           var55 = var3.instructions;
                                                                                                                           var56 = var3.intOperands;
                                                                                                                           var28 = var81.invokedFromPc;
                                                                                                                           GZipDecompressor.scriptLocalInts = var81.savedLocalInts;
                                                                                                                           class82.scriptLocalStrings = var81.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class82.intStackSize -= 2;
                                                                                                                        if(class82.intStack[class82.intStackSize] > class82.intStack[class82.intStackSize + 1]) {
                                                                                                                           var28 += var56[var28];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     if(class82.intStack[class82.intStackSize] < class82.intStack[class82.intStackSize + 1]) {
                                                                                                                        var28 += var56[var28];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  if(class82.intStack[class82.intStackSize] == class82.intStack[class82.intStackSize + 1]) {
                                                                                                                     var28 += var56[var28];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class82.intStackSize -= 2;
                                                                                                               if(class82.intStack[class82.intStackSize] != class82.intStack[class82.intStackSize + 1]) {
                                                                                                                  var28 += var56[var28];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var28 += var56[var28];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var3.stringOperands[var28];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var56[var28];
                                                                                                      class218.widgetSettings[var11] = class82.intStack[--class82.intStackSize];
                                                                                                      class36.method476(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var56[var28];
                                                                                                   class82.intStack[++class82.intStackSize - 1] = class218.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class82.intStack[++class82.intStackSize - 1] = var56[var28];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var59;
                                                                                             if(var3.intOperands[var28] == 1) {
                                                                                                var59 = true;
                                                                                             } else {
                                                                                                var59 = false;
                                                                                             }

                                                                                             byte var13;
                                                                                             Widget var17;
                                                                                             int var19;
                                                                                             Widget var30;
                                                                                             Widget var32;
                                                                                             if(var57 < 1000) {
                                                                                                if(var57 == 100) {
                                                                                                   class82.intStackSize -= 3;
                                                                                                   var14 = class82.intStack[class82.intStackSize];
                                                                                                   var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                   var16 = class82.intStack[class82.intStackSize + 2];
                                                                                                   if(var15 == 0) {
                                                                                                      throw new RuntimeException();
                                                                                                   }

                                                                                                   var17 = class64.method1017(var14);
                                                                                                   if(var17.children == null) {
                                                                                                      var17.children = new Widget[var16 + 1];
                                                                                                   }

                                                                                                   if(var17.children.length <= var16) {
                                                                                                      Widget[] var18 = new Widget[var16 + 1];

                                                                                                      for(var19 = 0; var19 < var17.children.length; ++var19) {
                                                                                                         var18[var19] = var17.children[var19];
                                                                                                      }

                                                                                                      var17.children = var18;
                                                                                                   }

                                                                                                   if(var16 > 0 && var17.children[var16 - 1] == null) {
                                                                                                      throw new RuntimeException("" + (var16 - 1));
                                                                                                   }

                                                                                                   Widget var61 = new Widget();
                                                                                                   var61.type = var15;
                                                                                                   var61.parentId = var61.id = var17.id;
                                                                                                   var61.index = var16;
                                                                                                   var61.hasScript = true;
                                                                                                   var17.children[var16] = var61;
                                                                                                   if(var59) {
                                                                                                      class234.field3210 = var61;
                                                                                                   } else {
                                                                                                      class82.field1253 = var61;
                                                                                                   }

                                                                                                   ScriptEvent.method1038(var17);
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 101) {
                                                                                                   var30 = var59?class234.field3210:class82.field1253;
                                                                                                   Widget var31 = class64.method1017(var30.id);
                                                                                                   var31.children[var30.index] = null;
                                                                                                   ScriptEvent.method1038(var31);
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 102) {
                                                                                                   var30 = class64.method1017(class82.intStack[--class82.intStackSize]);
                                                                                                   var30.children = null;
                                                                                                   ScriptEvent.method1038(var30);
                                                                                                   var13 = 1;
                                                                                                } else if(var57 != 200) {
                                                                                                   if(var57 == 201) {
                                                                                                      var30 = class64.method1017(class82.intStack[--class82.intStackSize]);
                                                                                                      if(var30 != null) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = 1;
                                                                                                         if(var59) {
                                                                                                            class234.field3210 = var30;
                                                                                                         } else {
                                                                                                            class82.field1253 = var30;
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }
                                                                                                } else {
                                                                                                   class82.intStackSize -= 2;
                                                                                                   var14 = class82.intStack[class82.intStackSize];
                                                                                                   var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                   var32 = DecorativeObject.method2896(var14, var15);
                                                                                                   if(var32 != null && var15 != -1) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = 1;
                                                                                                      if(var59) {
                                                                                                         class234.field3210 = var32;
                                                                                                      } else {
                                                                                                         class82.field1253 = var32;
                                                                                                      }
                                                                                                   } else {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                   }

                                                                                                   var13 = 1;
                                                                                                }

                                                                                                var12 = var13;
                                                                                             } else if(var57 < 1100) {
                                                                                                var12 = Signlink.method2955(var57, var3, var59);
                                                                                             } else if(var57 < 1200) {
                                                                                                var12 = WorldMapData.method250(var57, var3, var59);
                                                                                             } else if(var57 < 1300) {
                                                                                                var12 = class47.method662(var57, var3, var59);
                                                                                             } else if(var57 < 1400) {
                                                                                                var12 = class168.method3095(var57, var3, var59);
                                                                                             } else if(var57 < 1500) {
                                                                                                var12 = class45.method623(var57, var3, var59);
                                                                                             } else if(var57 < 1600) {
                                                                                                var17 = var59?class234.field3210:class82.field1253;
                                                                                                if(var57 == 1500) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.relativeX;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1501) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.relativeY;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1502) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.width;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1503) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.height;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1504) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.isHidden?1:0;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1505) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.parentId;
                                                                                                   var13 = 1;
                                                                                                } else {
                                                                                                   var13 = 2;
                                                                                                }

                                                                                                var12 = var13;
                                                                                             } else if(var57 < 1700) {
                                                                                                var30 = var59?class234.field3210:class82.field1253;
                                                                                                if(var57 == 1600) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.scrollX;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1601) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.scrollY;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1602) {
                                                                                                   class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var30.text;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1603) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.scrollWidth;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1604) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.scrollHeight;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1605) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.modelZoom;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1606) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.rotationX;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1607) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.rotationY;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1608) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.rotationZ;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1609) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.opacity;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1610) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.field2745;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1611) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.textColor;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1612) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.field2834;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1613) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var30.field2743.rsOrdinal();
                                                                                                   var13 = 1;
                                                                                                } else {
                                                                                                   var13 = 2;
                                                                                                }

                                                                                                var12 = var13;
                                                                                             } else if(var57 < 1800) {
                                                                                                var17 = var59?class234.field3210:class82.field1253;
                                                                                                if(var57 == 1700) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.itemId;
                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1701) {
                                                                                                   if(var17.itemId != -1) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var17.itemQuantity;
                                                                                                   } else {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                   }

                                                                                                   var13 = 1;
                                                                                                } else if(var57 == 1702) {
                                                                                                   class82.intStack[++class82.intStackSize - 1] = var17.index;
                                                                                                   var13 = 1;
                                                                                                } else {
                                                                                                   var13 = 2;
                                                                                                }

                                                                                                var12 = var13;
                                                                                             } else {
                                                                                                int[] var82;
                                                                                                if(var57 < 1900) {
                                                                                                   var30 = var59?class234.field3210:class82.field1253;
                                                                                                   if(var57 == 1800) {
                                                                                                      var82 = class82.intStack;
                                                                                                      var16 = ++class82.intStackSize - 1;
                                                                                                      var35 = class12.getWidgetConfig(var30);
                                                                                                      var34 = var35 >> 11 & 63;
                                                                                                      var82[var16] = var34;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 != 1801) {
                                                                                                      if(var57 == 1802) {
                                                                                                         if(var30.name == null) {
                                                                                                            class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                         } else {
                                                                                                            class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var30.name;
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else {
                                                                                                         var13 = 2;
                                                                                                      }
                                                                                                   } else {
                                                                                                      var15 = class82.intStack[--class82.intStackSize];
                                                                                                      --var15;
                                                                                                      if(var30.actions != null && var15 < var30.actions.length && var30.actions[var15] != null) {
                                                                                                         class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var30.actions[var15];
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var57 < 2000) {
                                                                                                   var12 = class115.method2126(var57, var3, var59);
                                                                                                } else if(var57 < 2100) {
                                                                                                   var12 = Signlink.method2955(var57, var3, var59);
                                                                                                } else if(var57 < 2200) {
                                                                                                   var12 = WorldMapData.method250(var57, var3, var59);
                                                                                                } else if(var57 < 2300) {
                                                                                                   var12 = class47.method662(var57, var3, var59);
                                                                                                } else if(var57 < 2400) {
                                                                                                   var12 = class168.method3095(var57, var3, var59);
                                                                                                } else if(var57 < 2500) {
                                                                                                   var12 = class45.method623(var57, var3, var59);
                                                                                                } else if(var57 < 2600) {
                                                                                                   var12 = class86.method1669(var57, var3, var59);
                                                                                                } else if(var57 < 2700) {
                                                                                                   var30 = class64.method1017(class82.intStack[--class82.intStackSize]);
                                                                                                   if(var57 == 2600) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.scrollX;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2601) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.scrollY;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2602) {
                                                                                                      class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var30.text;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2603) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.scrollWidth;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2604) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.scrollHeight;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2605) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.modelZoom;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2606) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.rotationX;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2607) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.rotationY;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2608) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.rotationZ;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2609) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.opacity;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2610) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.field2745;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2611) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.textColor;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2612) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.field2834;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2613) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.field2743.rsOrdinal();
                                                                                                      var13 = 1;
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var57 < 2800) {
                                                                                                   if(var57 == 2700) {
                                                                                                      var30 = class64.method1017(class82.intStack[--class82.intStackSize]);
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var30.itemId;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2701) {
                                                                                                      var30 = class64.method1017(class82.intStack[--class82.intStackSize]);
                                                                                                      if(var30.itemId != -1) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var30.itemQuantity;
                                                                                                      } else {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2702) {
                                                                                                      var14 = class82.intStack[--class82.intStackSize];
                                                                                                      WidgetNode var84 = (WidgetNode)Client.componentTable.get((long)var14);
                                                                                                      if(var84 != null) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = 1;
                                                                                                      } else {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   } else if(var57 == 2706) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = Client.widgetRoot;
                                                                                                      var13 = 1;
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var57 < 2900) {
                                                                                                   var30 = class64.method1017(class82.intStack[--class82.intStackSize]);
                                                                                                   if(var57 == 2800) {
                                                                                                      var82 = class82.intStack;
                                                                                                      var16 = ++class82.intStackSize - 1;
                                                                                                      var35 = class12.getWidgetConfig(var30);
                                                                                                      var34 = var35 >> 11 & 63;
                                                                                                      var82[var16] = var34;
                                                                                                      var13 = 1;
                                                                                                   } else if(var57 != 2801) {
                                                                                                      if(var57 == 2802) {
                                                                                                         if(var30.name == null) {
                                                                                                            class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                         } else {
                                                                                                            class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var30.name;
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else {
                                                                                                         var13 = 2;
                                                                                                      }
                                                                                                   } else {
                                                                                                      var15 = class82.intStack[--class82.intStackSize];
                                                                                                      --var15;
                                                                                                      if(var30.actions != null && var15 < var30.actions.length && var30.actions[var15] != null) {
                                                                                                         class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var30.actions[var15];
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else if(var57 < 3000) {
                                                                                                   var12 = class115.method2126(var57, var3, var59);
                                                                                                } else {
                                                                                                   PacketNode var21;
                                                                                                   boolean var58;
                                                                                                   PacketNode var60;
                                                                                                   PacketNode var85;
                                                                                                   String var86;
                                                                                                   PacketNode var88;
                                                                                                   String var89;
                                                                                                   if(var57 < 3200) {
                                                                                                      if(var57 == 3100) {
                                                                                                         var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                         class3.sendGameMessage(0, "", var89);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3101) {
                                                                                                         class82.intStackSize -= 2;
                                                                                                         Ignore.method1045(class275.localPlayer, class82.intStack[class82.intStackSize], class82.intStack[class82.intStackSize + 1]);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3103) {
                                                                                                         class39.method509();
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3104) {
                                                                                                         var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                         var15 = 0;
                                                                                                         if(Frames.method2880(var89)) {
                                                                                                            var16 = class61.parseInt(var89, 10, true);
                                                                                                            var15 = var16;
                                                                                                         }

                                                                                                         var88 = class18.method133(ClientPacket.field2375, Client.field905.field1460);
                                                                                                         var88.packetBuffer.putInt(var15);
                                                                                                         Client.field905.method1855(var88);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3105) {
                                                                                                         var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                         var85 = class18.method133(ClientPacket.field2314, Client.field905.field1460);
                                                                                                         var85.packetBuffer.putByte(var89.length() + 1);
                                                                                                         var85.packetBuffer.putString(var89);
                                                                                                         Client.field905.method1855(var85);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3106) {
                                                                                                         var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                         var85 = class18.method133(ClientPacket.field2356, Client.field905.field1460);
                                                                                                         var85.packetBuffer.putByte(var89.length() + 1);
                                                                                                         var85.packetBuffer.putString(var89);
                                                                                                         Client.field905.method1855(var85);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3107) {
                                                                                                         var14 = class82.intStack[--class82.intStackSize];
                                                                                                         var87 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                         var16 = class94.playerIndexesCount;
                                                                                                         int[] var63 = class94.playerIndices;
                                                                                                         boolean var97 = false;

                                                                                                         for(var19 = 0; var19 < var16; ++var19) {
                                                                                                            Player var38 = Client.cachedPlayers[var63[var19]];
                                                                                                            if(var38 != null && var38 != class275.localPlayer && var38.name != null && var38.name.equalsIgnoreCase(var87)) {
                                                                                                               if(var14 == 1) {
                                                                                                                  var21 = class18.method133(ClientPacket.field2350, Client.field905.field1460);
                                                                                                                  var21.packetBuffer.method3220(0);
                                                                                                                  var21.packetBuffer.putShortLE(var63[var19]);
                                                                                                                  Client.field905.method1855(var21);
                                                                                                               } else if(var14 == 4) {
                                                                                                                  var21 = class18.method133(ClientPacket.field2298, Client.field905.field1460);
                                                                                                                  var21.packetBuffer.method3220(0);
                                                                                                                  var21.packetBuffer.putShortLE(var63[var19]);
                                                                                                                  Client.field905.method1855(var21);
                                                                                                               } else if(var14 == 6) {
                                                                                                                  var21 = class18.method133(ClientPacket.field2306, Client.field905.field1460);
                                                                                                                  var21.packetBuffer.putShort(var63[var19]);
                                                                                                                  var21.packetBuffer.putByte(0);
                                                                                                                  Client.field905.method1855(var21);
                                                                                                               } else if(var14 == 7) {
                                                                                                                  var21 = class18.method133(ClientPacket.field2384, Client.field905.field1460);
                                                                                                                  var21.packetBuffer.putByte(0);
                                                                                                                  var21.packetBuffer.putShortLE(var63[var19]);
                                                                                                                  Client.field905.method1855(var21);
                                                                                                               }

                                                                                                               var97 = true;
                                                                                                               break;
                                                                                                            }
                                                                                                         }

                                                                                                         if(!var97) {
                                                                                                            class3.sendGameMessage(4, "", "Unable to find " + var87);
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3108) {
                                                                                                         class82.intStackSize -= 3;
                                                                                                         var14 = class82.intStack[class82.intStackSize];
                                                                                                         var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                         var16 = class82.intStack[class82.intStackSize + 2];
                                                                                                         var17 = class64.method1017(var16);
                                                                                                         class44.method595(var17, var14, var15);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3109) {
                                                                                                         class82.intStackSize -= 2;
                                                                                                         var14 = class82.intStack[class82.intStackSize];
                                                                                                         var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                         var32 = var59?class234.field3210:class82.field1253;
                                                                                                         class44.method595(var32, var14, var15);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3110) {
                                                                                                         Signlink.field2142 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3111) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = class70.preferences.hideRoofs?1:0;
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3112) {
                                                                                                         class70.preferences.hideRoofs = class82.intStack[--class82.intStackSize] == 1;
                                                                                                         GameEngine.method925();
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3113) {
                                                                                                         var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                         var58 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                         if(var58) {
                                                                                                            label3287: {
                                                                                                               if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                                                                                                  try {
                                                                                                                     Desktop.getDesktop().browse(new URI(var89));
                                                                                                                     break label3287;
                                                                                                                  } catch (Exception var53) {
                                                                                                                     ;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(class56.field629.startsWith("win")) {
                                                                                                                  World.method1561(var89, 0);
                                                                                                               } else if(class56.field629.startsWith("mac")) {
                                                                                                                  ScriptState.method1000(var89, 1, "openjs");
                                                                                                               } else {
                                                                                                                  World.method1561(var89, 2);
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            World.method1561(var89, 3);
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3115) {
                                                                                                         var14 = class82.intStack[--class82.intStackSize];
                                                                                                         var85 = class18.method133(ClientPacket.field2315, Client.field905.field1460);
                                                                                                         var85.packetBuffer.putShort(var14);
                                                                                                         Client.field905.method1855(var85);
                                                                                                         var13 = 1;
                                                                                                      } else if(var57 == 3116) {
                                                                                                         var14 = class82.intStack[--class82.intStackSize];
                                                                                                         class259.scriptStringStackSize -= 2;
                                                                                                         var87 = class82.scriptStringStack[class259.scriptStringStackSize];
                                                                                                         var86 = class82.scriptStringStack[class259.scriptStringStackSize + 1];
                                                                                                         if(var87.length() > 500) {
                                                                                                            var13 = 1;
                                                                                                         } else if(var86.length() > 500) {
                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            var60 = class18.method133(ClientPacket.field2311, Client.field905.field1460);
                                                                                                            var60.packetBuffer.putShort(1 + class23.getLength(var87) + class23.getLength(var86));
                                                                                                            var60.packetBuffer.putString(var86);
                                                                                                            var60.packetBuffer.putString(var87);
                                                                                                            var60.packetBuffer.method3212(var14);
                                                                                                            Client.field905.method1855(var60);
                                                                                                            var13 = 1;
                                                                                                         }
                                                                                                      } else if(var57 == 3117) {
                                                                                                         Client.field995 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                         var13 = 1;
                                                                                                      } else {
                                                                                                         var13 = 2;
                                                                                                      }

                                                                                                      var12 = var13;
                                                                                                   } else if(var57 < 3300) {
                                                                                                      var12 = class10.method57(var57, var3, var59);
                                                                                                   } else if(var57 < 3400) {
                                                                                                      var12 = TextureProvider.method2415(var57, var3, var59);
                                                                                                   } else {
                                                                                                      int var20;
                                                                                                      if(var57 < 3500) {
                                                                                                         if(var57 == 3400) {
                                                                                                            class82.intStackSize -= 2;
                                                                                                            var14 = class82.intStack[class82.intStackSize];
                                                                                                            var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                            Enum var64 = (Enum)Enum.field3456.get((long)var14);
                                                                                                            Enum var91;
                                                                                                            if(var64 != null) {
                                                                                                               var91 = var64;
                                                                                                            } else {
                                                                                                               byte[] var65 = Enum.field3453.getConfigData(8, var14);
                                                                                                               var64 = new Enum();
                                                                                                               if(var65 != null) {
                                                                                                                  var64.decode(new Buffer(var65));
                                                                                                               }

                                                                                                               Enum.field3456.put(var64, (long)var14);
                                                                                                               var91 = var64;
                                                                                                            }

                                                                                                            var64 = var91;
                                                                                                            if(var91.valType != 's') {
                                                                                                               ;
                                                                                                            }

                                                                                                            for(var35 = 0; var35 < var64.size; ++var35) {
                                                                                                               if(var15 == var64.keys[var35]) {
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var64.stringVals[var35];
                                                                                                                  var64 = null;
                                                                                                                  break;
                                                                                                               }
                                                                                                            }

                                                                                                            if(var64 != null) {
                                                                                                               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var64.defaultString;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var57 == 3408) {
                                                                                                            class82.intStackSize -= 4;
                                                                                                            var14 = class82.intStack[class82.intStackSize];
                                                                                                            var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                            var16 = class82.intStack[class82.intStackSize + 2];
                                                                                                            var34 = class82.intStack[class82.intStackSize + 3];
                                                                                                            Enum var37 = (Enum)Enum.field3456.get((long)var16);
                                                                                                            Enum var62;
                                                                                                            if(var37 != null) {
                                                                                                               var62 = var37;
                                                                                                            } else {
                                                                                                               byte[] var107 = Enum.field3453.getConfigData(8, var16);
                                                                                                               var37 = new Enum();
                                                                                                               if(var107 != null) {
                                                                                                                  var37.decode(new Buffer(var107));
                                                                                                               }

                                                                                                               Enum.field3456.put(var37, (long)var16);
                                                                                                               var62 = var37;
                                                                                                            }

                                                                                                            var37 = var62;
                                                                                                            if(var14 == var62.keyType && var15 == var62.valType) {
                                                                                                               for(var20 = 0; var20 < var37.size; ++var20) {
                                                                                                                  if(var34 == var37.keys[var20]) {
                                                                                                                     if(var15 == 115) {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var37.stringVals[var20];
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = var37.intVals[var20];
                                                                                                                     }

                                                                                                                     var37 = null;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(var37 != null) {
                                                                                                                  if(var15 == 115) {
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var37.defaultString;
                                                                                                                  } else {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var37.defaultInt;
                                                                                                                  }
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               if(var15 == 115) {
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "null";
                                                                                                               } else {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var13 = 2;
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else {
                                                                                                         int var22;
                                                                                                         int var23;
                                                                                                         int var39;
                                                                                                         char var41;
                                                                                                         String var112;
                                                                                                         if(var57 < 3700) {
                                                                                                            if(var57 == 3600) {
                                                                                                               if(Client.field1114 == 0) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = -2;
                                                                                                               } else if(Client.field1114 == 1) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                               } else {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.friendCount;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var57 == 3601) {
                                                                                                               var14 = class82.intStack[--class82.intStackSize];
                                                                                                               if(Client.field1114 == 2 && var14 < Client.friendCount) {
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Client.friends[var14].name;
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Client.friends[var14].previousName;
                                                                                                               } else {
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var57 == 3602) {
                                                                                                               var14 = class82.intStack[--class82.intStackSize];
                                                                                                               if(Client.field1114 == 2 && var14 < Client.friendCount) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.friends[var14].world;
                                                                                                               } else {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var57 == 3603) {
                                                                                                               var14 = class82.intStack[--class82.intStackSize];
                                                                                                               if(Client.field1114 == 2 && var14 < Client.friendCount) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.friends[var14].rank;
                                                                                                               } else {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var57 == 3604) {
                                                                                                               var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                               var15 = class82.intStack[--class82.intStackSize];
                                                                                                               class11.method62(var89, var15);
                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               Ignore var70;
                                                                                                               Friend var71;
                                                                                                               if(var57 == 3605) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  if(var89 != null) {
                                                                                                                     if((Client.friendCount < 200 || Client.field969 == 1) && Client.friendCount < 400) {
                                                                                                                        var87 = class226.method4078(var89, class189.field2529);
                                                                                                                        if(var87 != null) {
                                                                                                                           var16 = 0;

                                                                                                                           label3035:
                                                                                                                           while(true) {
                                                                                                                              if(var16 >= Client.friendCount) {
                                                                                                                                 for(var16 = 0; var16 < Client.ignoreCount; ++var16) {
                                                                                                                                    var70 = Client.ignores[var16];
                                                                                                                                    var67 = class226.method4078(var70.name, class189.field2529);
                                                                                                                                    if(var67 != null && var67.equals(var87)) {
                                                                                                                                       class3.sendGameMessage(30, "", "Please remove " + var89 + " from your ignore list first");
                                                                                                                                       break label3035;
                                                                                                                                    }

                                                                                                                                    if(var70.previousName != null) {
                                                                                                                                       var111 = class226.method4078(var70.previousName, class189.field2529);
                                                                                                                                       if(var111 != null && var111.equals(var87)) {
                                                                                                                                          class3.sendGameMessage(30, "", "Please remove " + var89 + " from your ignore list first");
                                                                                                                                          break label3035;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class226.method4078(class275.localPlayer.name, class189.field2529).equals(var87)) {
                                                                                                                                    class3.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                                                                                                 } else {
                                                                                                                                    var88 = class18.method133(ClientPacket.field2346, Client.field905.field1460);
                                                                                                                                    var88.packetBuffer.putByte(class23.getLength(var89));
                                                                                                                                    var88.packetBuffer.putString(var89);
                                                                                                                                    Client.field905.method1855(var88);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var71 = Client.friends[var16];
                                                                                                                              var67 = class226.method4078(var71.name, class189.field2529);
                                                                                                                              if(var67 != null && var67.equals(var87)) {
                                                                                                                                 class3.sendGameMessage(30, "", var89 + " is already on your friend list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var71.previousName != null) {
                                                                                                                                 var111 = class226.method4078(var71.previousName, class189.field2529);
                                                                                                                                 if(var111 != null && var111.equals(var87)) {
                                                                                                                                    class3.sendGameMessage(30, "", var89 + " is already on your friend list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var16;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class3.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3606) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  if(var89 != null) {
                                                                                                                     var87 = class226.method4078(var89, class189.field2529);
                                                                                                                     if(var87 != null) {
                                                                                                                        for(var16 = 0; var16 < Client.friendCount; ++var16) {
                                                                                                                           var71 = Client.friends[var16];
                                                                                                                           var67 = var71.name;
                                                                                                                           var111 = class226.method4078(var67, class189.field2529);
                                                                                                                           boolean var68;
                                                                                                                           if(var89 != null && var67 != null) {
                                                                                                                              if(!var89.startsWith("#") && !var67.startsWith("#")) {
                                                                                                                                 var68 = var87.equals(var111);
                                                                                                                              } else {
                                                                                                                                 var68 = var89.equals(var67);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var68 = false;
                                                                                                                           }

                                                                                                                           if(var68) {
                                                                                                                              --Client.friendCount;

                                                                                                                              for(var39 = var16; var39 < Client.friendCount; ++var39) {
                                                                                                                                 Client.friends[var39] = Client.friends[var39 + 1];
                                                                                                                              }

                                                                                                                              Client.field1040 = Client.cycleCntr;
                                                                                                                              var21 = class18.method133(ClientPacket.field2379, Client.field905.field1460);
                                                                                                                              var21.packetBuffer.putByte(class23.getLength(var89));
                                                                                                                              var21.packetBuffer.putString(var89);
                                                                                                                              Client.field905.method1855(var21);
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3607) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  if(var89 != null) {
                                                                                                                     if((Client.ignoreCount < 100 || Client.field969 == 1) && Client.ignoreCount < 400) {
                                                                                                                        var87 = class226.method4078(var89, class189.field2529);
                                                                                                                        if(var87 != null) {
                                                                                                                           var16 = 0;

                                                                                                                           label3097:
                                                                                                                           while(true) {
                                                                                                                              if(var16 >= Client.ignoreCount) {
                                                                                                                                 for(var16 = 0; var16 < Client.friendCount; ++var16) {
                                                                                                                                    var71 = Client.friends[var16];
                                                                                                                                    var67 = class226.method4078(var71.name, class189.field2529);
                                                                                                                                    if(var67 != null && var67.equals(var87)) {
                                                                                                                                       class3.sendGameMessage(31, "", "Please remove " + var89 + " from your friend list first");
                                                                                                                                       break label3097;
                                                                                                                                    }

                                                                                                                                    if(var71.previousName != null) {
                                                                                                                                       var111 = class226.method4078(var71.previousName, class189.field2529);
                                                                                                                                       if(var111 != null && var111.equals(var87)) {
                                                                                                                                          class3.sendGameMessage(31, "", "Please remove " + var89 + " from your friend list first");
                                                                                                                                          break label3097;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class226.method4078(class275.localPlayer.name, class189.field2529).equals(var87)) {
                                                                                                                                    class3.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                                                                                                                 } else {
                                                                                                                                    var88 = class18.method133(ClientPacket.field2331, Client.field905.field1460);
                                                                                                                                    var88.packetBuffer.putByte(class23.getLength(var89));
                                                                                                                                    var88.packetBuffer.putString(var89);
                                                                                                                                    Client.field905.method1855(var88);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var70 = Client.ignores[var16];
                                                                                                                              var67 = class226.method4078(var70.name, class189.field2529);
                                                                                                                              if(var67 != null && var67.equals(var87)) {
                                                                                                                                 class3.sendGameMessage(31, "", var89 + " is already on your ignore list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var70.previousName != null) {
                                                                                                                                 var111 = class226.method4078(var70.previousName, class189.field2529);
                                                                                                                                 if(var111 != null && var111.equals(var87)) {
                                                                                                                                    class3.sendGameMessage(31, "", var89 + " is already on your ignore list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var16;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class3.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3608) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  class268.method4744(var89);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3609) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  Permission[] var94 = new Permission[]{Permission.field3237, Permission.field3235, Permission.field3234, Permission.field3233, Permission.field3240, Permission.field3232};
                                                                                                                  Permission[] var93 = var94;

                                                                                                                  for(var34 = 0; var34 < var93.length; ++var34) {
                                                                                                                     Permission var66 = var93[var34];
                                                                                                                     if(var66.field3238 != -1 && var89.startsWith(Client.method1489(var66.field3238))) {
                                                                                                                        var89 = var89.substring(6 + Integer.toString(var66.field3238).length());
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class82.intStack[++class82.intStackSize - 1] = class82.isFriended(var89, false)?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  long var42;
                                                                                                                  String var69;
                                                                                                                  String[] var95;
                                                                                                                  if(var57 == 3611) {
                                                                                                                     if(Client.clanChatOwner != null) {
                                                                                                                        var95 = class82.scriptStringStack;
                                                                                                                        var15 = ++class259.scriptStringStackSize - 1;
                                                                                                                        var69 = Client.clanChatOwner;
                                                                                                                        var42 = 0L;
                                                                                                                        var22 = var69.length();

                                                                                                                        for(var23 = 0; var23 < var22; ++var23) {
                                                                                                                           var42 *= 37L;
                                                                                                                           var41 = var69.charAt(var23);
                                                                                                                           if(var41 >= 'A' && var41 <= 'Z') {
                                                                                                                              var42 += (long)(var41 + 1 - 65);
                                                                                                                           } else if(var41 >= 'a' && var41 <= 'z') {
                                                                                                                              var42 += (long)(var41 + 1 - 97);
                                                                                                                           } else if(var41 >= '0' && var41 <= '9') {
                                                                                                                              var42 += (long)(var41 + 27 - 48);
                                                                                                                           }

                                                                                                                           if(var42 >= 177917621779460413L) {
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        while(0L == var42 % 37L && var42 != 0L) {
                                                                                                                           var42 /= 37L;
                                                                                                                        }

                                                                                                                        var112 = class251.method4317(var42);
                                                                                                                        if(var112 == null) {
                                                                                                                           var112 = "";
                                                                                                                        }

                                                                                                                        var95[var15] = var112;
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3612) {
                                                                                                                     if(Client.clanChatOwner != null) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class34.clanChatCount;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3613) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.clanChatOwner != null && var14 < class34.clanChatCount) {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Varcs.clanMembers[var14].username;
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3614) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.clanChatOwner != null && var14 < class34.clanChatCount) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Varcs.clanMembers[var14].world;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3615) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.clanChatOwner != null && var14 < class34.clanChatCount) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Varcs.clanMembers[var14].rank;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3616) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class41.field517;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3617) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     if(Varcs.clanMembers != null) {
                                                                                                                        var85 = class18.method133(ClientPacket.field2319, Client.field905.field1460);
                                                                                                                        var85.packetBuffer.putByte(class23.getLength(var89));
                                                                                                                        var85.packetBuffer.putString(var89);
                                                                                                                        Client.field905.method1855(var85);
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3618) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class111.clanChatRank;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3619) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     if(!var89.equals("")) {
                                                                                                                        var85 = class18.method133(ClientPacket.field2329, Client.field905.field1460);
                                                                                                                        var85.packetBuffer.putByte(class23.getLength(var89));
                                                                                                                        var85.packetBuffer.putString(var89);
                                                                                                                        Client.field905.method1855(var85);
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3620) {
                                                                                                                     Buffer.method3403();
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3621) {
                                                                                                                     if(Client.field1114 == 0) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.ignoreCount;
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3622) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.field1114 != 0 && var14 < Client.ignoreCount) {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Client.ignores[var14].name;
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Client.ignores[var14].previousName;
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3623) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     if(var89.startsWith(Client.method1489(0)) || var89.startsWith(Client.method1489(1))) {
                                                                                                                        var89 = var89.substring(7);
                                                                                                                     }

                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class13.isIgnored(var89)?1:0;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3624) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Varcs.clanMembers != null && var14 < class34.clanChatCount && Varcs.clanMembers[var14].username.equalsIgnoreCase(class275.localPlayer.name)) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 1;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 != 3625) {
                                                                                                                     var13 = 2;
                                                                                                                  } else {
                                                                                                                     if(Client.clanChatName != null) {
                                                                                                                        var95 = class82.scriptStringStack;
                                                                                                                        var15 = ++class259.scriptStringStackSize - 1;
                                                                                                                        var69 = Client.clanChatName;
                                                                                                                        var42 = 0L;
                                                                                                                        var22 = var69.length();

                                                                                                                        for(var23 = 0; var23 < var22; ++var23) {
                                                                                                                           var42 *= 37L;
                                                                                                                           var41 = var69.charAt(var23);
                                                                                                                           if(var41 >= 'A' && var41 <= 'Z') {
                                                                                                                              var42 += (long)(var41 + 1 - 65);
                                                                                                                           } else if(var41 >= 'a' && var41 <= 'z') {
                                                                                                                              var42 += (long)(var41 + 1 - 97);
                                                                                                                           } else if(var41 >= '0' && var41 <= '9') {
                                                                                                                              var42 += (long)(var41 + 27 - 48);
                                                                                                                           }

                                                                                                                           if(var42 >= 177917621779460413L) {
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        while(0L == var42 % 37L && var42 != 0L) {
                                                                                                                           var42 /= 37L;
                                                                                                                        }

                                                                                                                        var112 = class251.method4317(var42);
                                                                                                                        if(var112 == null) {
                                                                                                                           var112 = "";
                                                                                                                        }

                                                                                                                        var95[var15] = var112;
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var12 = var13;
                                                                                                         } else {
                                                                                                            boolean var77;
                                                                                                            if(var57 < 4000) {
                                                                                                               if(var57 == 3903) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var14].method101();
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3904) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var14].itemId;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3905) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var14].price;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3906) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var14].totalQuantity;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3907) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var14].quantitySold;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3908) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var14].spent;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3910) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  var15 = Client.grandExchangeOffers[var14].method100();
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = var15 == 0?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3911) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  var15 = Client.grandExchangeOffers[var14].method100();
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = var15 == 2?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3912) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  var15 = Client.grandExchangeOffers[var14].method100();
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = var15 == 5?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3913) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  var15 = Client.grandExchangeOffers[var14].method100();
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = var15 == 1?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3914) {
                                                                                                                  var77 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  if(ClanMember.field855 != null) {
                                                                                                                     ClanMember.field855.method78(class13.field261, var77);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3915) {
                                                                                                                  var77 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  if(ClanMember.field855 != null) {
                                                                                                                     ClanMember.field855.method78(class13.field265, var77);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3916) {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  var77 = class82.intStack[class82.intStackSize] == 1;
                                                                                                                  var58 = class82.intStack[class82.intStackSize + 1] == 1;
                                                                                                                  if(ClanMember.field855 != null) {
                                                                                                                     Client.field1123.field847 = var58;
                                                                                                                     ClanMember.field855.method78(Client.field1123, var77);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3917) {
                                                                                                                  var77 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  if(ClanMember.field855 != null) {
                                                                                                                     ClanMember.field855.method78(class13.field259, var77);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3918) {
                                                                                                                  var77 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  if(ClanMember.field855 != null) {
                                                                                                                     ClanMember.field855.method78(class13.field262, var77);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 3919) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = ClanMember.field855 == null?0:ClanMember.field855.field260.size();
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  class14 var99;
                                                                                                                  if(var57 == 3920) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var99.field277;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3921) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var99.method83();
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3922) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var99.method84();
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3923) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     long var48 = ChatLineBuffer.currentTimeMs() - ClanMember.field860 - var99.field270;
                                                                                                                     var35 = (int)(var48 / 3600000L);
                                                                                                                     var19 = (int)((var48 - (long)(var35 * 3600000)) / 60000L);
                                                                                                                     var20 = (int)((var48 - (long)(var35 * 3600000) - (long)(var19 * 60000)) / 1000L);
                                                                                                                     String var75 = var35 + ":" + var19 / 10 + var19 % 10 + ":" + var20 / 10 + var20 % 10;
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var75;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3924) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var99.field276.totalQuantity;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3925) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var99.field276.price;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 3926) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var99 = (class14)ClanMember.field855.field260.get(var14);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var99.field276.itemId;
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     var13 = 2;
                                                                                                                  }
                                                                                                               }

                                                                                                               var12 = var13;
                                                                                                            } else if(var57 < 4100) {
                                                                                                               var12 = ItemContainer.method1003(var57, var3, var59);
                                                                                                            } else if(var57 < 4200) {
                                                                                                               if(var57 == 4100) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  var15 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89 + var15;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4101) {
                                                                                                                  class259.scriptStringStackSize -= 2;
                                                                                                                  var89 = class82.scriptStringStack[class259.scriptStringStackSize];
                                                                                                                  var87 = class82.scriptStringStack[class259.scriptStringStackSize + 1];
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89 + var87;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4102) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  var15 = class82.intStack[--class82.intStackSize];
                                                                                                                  String[] var96 = class82.scriptStringStack;
                                                                                                                  var34 = ++class259.scriptStringStackSize - 1;
                                                                                                                  if(var15 < 0) {
                                                                                                                     var111 = Integer.toString(var15);
                                                                                                                  } else {
                                                                                                                     var39 = var15;
                                                                                                                     if(var15 < 0) {
                                                                                                                        var112 = Integer.toString(var15, 10);
                                                                                                                     } else {
                                                                                                                        var22 = 2;

                                                                                                                        for(var23 = var15 / 10; var23 != 0; ++var22) {
                                                                                                                           var23 /= 10;
                                                                                                                        }

                                                                                                                        char[] var24 = new char[var22];
                                                                                                                        var24[0] = '+';

                                                                                                                        for(int var25 = var22 - 1; var25 > 0; --var25) {
                                                                                                                           int var26 = var39;
                                                                                                                           var39 /= 10;
                                                                                                                           int var27 = var26 - var39 * 10;
                                                                                                                           if(var27 >= 10) {
                                                                                                                              var24[var25] = (char)(var27 + 87);
                                                                                                                           } else {
                                                                                                                              var24[var25] = (char)(var27 + 48);
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var112 = new String(var24);
                                                                                                                     }

                                                                                                                     var111 = var112;
                                                                                                                  }

                                                                                                                  var96[var34] = var89 + var111;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4103) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89.toLowerCase();
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4104) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  long var46 = (11745L + (long)var14) * 86400000L;
                                                                                                                  class82.field1267.setTime(new Date(var46));
                                                                                                                  var34 = class82.field1267.get(5);
                                                                                                                  var35 = class82.field1267.get(2);
                                                                                                                  var19 = class82.field1267.get(1);
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var34 + "-" + class82.field1263[var35] + "-" + var19;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4105) {
                                                                                                                  class259.scriptStringStackSize -= 2;
                                                                                                                  var89 = class82.scriptStringStack[class259.scriptStringStackSize];
                                                                                                                  var87 = class82.scriptStringStack[class259.scriptStringStackSize + 1];
                                                                                                                  if(class275.localPlayer.composition != null && class275.localPlayer.composition.isFemale) {
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var87;
                                                                                                                  } else {
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4106) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Integer.toString(var14);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 4107) {
                                                                                                                  class259.scriptStringStackSize -= 2;
                                                                                                                  var119 = class82.intStack;
                                                                                                                  var15 = ++class82.intStackSize - 1;
                                                                                                                  var34 = class48.method687(class82.scriptStringStack[class259.scriptStringStackSize], class82.scriptStringStack[class259.scriptStringStackSize + 1], Client.languageId);
                                                                                                                  byte var80;
                                                                                                                  if(var34 > 0) {
                                                                                                                     var80 = 1;
                                                                                                                  } else if(var34 < 0) {
                                                                                                                     var80 = -1;
                                                                                                                  } else {
                                                                                                                     var80 = 0;
                                                                                                                  }

                                                                                                                  var119[var15] = var80;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  Font var73;
                                                                                                                  byte[] var76;
                                                                                                                  if(var57 == 4108) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var15 = class82.intStack[class82.intStackSize];
                                                                                                                     var16 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     var76 = DecorativeObject.field2071.getConfigData(var16, 0);
                                                                                                                     var73 = new Font(var76);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var73.method4768(var89, var15);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4109) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var15 = class82.intStack[class82.intStackSize];
                                                                                                                     var16 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     var76 = DecorativeObject.field2071.getConfigData(var16, 0);
                                                                                                                     var73 = new Font(var76);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var73.method4824(var89, var15);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4110) {
                                                                                                                     class259.scriptStringStackSize -= 2;
                                                                                                                     var89 = class82.scriptStringStack[class259.scriptStringStackSize];
                                                                                                                     var87 = class82.scriptStringStack[class259.scriptStringStackSize + 1];
                                                                                                                     if(class82.intStack[--class82.intStackSize] == 1) {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89;
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var87;
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4111) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = FontTypeFace.appendTags(var89);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4112) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     var15 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89 + (char)var15;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4113) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Signlink.method2968((char)var14)?1:0;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4114) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class149.method2922((char)var14)?1:0;
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     char var104;
                                                                                                                     if(var57 == 4115) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        var82 = class82.intStack;
                                                                                                                        var16 = ++class82.intStackSize - 1;
                                                                                                                        var104 = (char)var14;
                                                                                                                        boolean var100 = var104 >= 'A' && var104 <= 'Z' || var104 >= 'a' && var104 <= 'z';
                                                                                                                        var82[var16] = var100?1:0;
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4116) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class276.method4884((char)var14)?1:0;
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4117) {
                                                                                                                        var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                        if(var89 != null) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var89.length();
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4118) {
                                                                                                                        var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                        class82.intStackSize -= 2;
                                                                                                                        var15 = class82.intStack[class82.intStackSize];
                                                                                                                        var16 = class82.intStack[class82.intStackSize + 1];
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89.substring(var15, var16);
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 != 4119) {
                                                                                                                        if(var57 == 4120) {
                                                                                                                           var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                           var15 = class82.intStack[--class82.intStackSize];
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var89.indexOf(var15);
                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 4121) {
                                                                                                                           class259.scriptStringStackSize -= 2;
                                                                                                                           var89 = class82.scriptStringStack[class259.scriptStringStackSize];
                                                                                                                           var87 = class82.scriptStringStack[class259.scriptStringStackSize + 1];
                                                                                                                           var16 = class82.intStack[--class82.intStackSize];
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var89.indexOf(var87, var16);
                                                                                                                           var13 = 1;
                                                                                                                        } else {
                                                                                                                           var13 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                        StringBuilder var108 = new StringBuilder(var89.length());
                                                                                                                        boolean var72 = false;

                                                                                                                        for(var34 = 0; var34 < var89.length(); ++var34) {
                                                                                                                           var104 = var89.charAt(var34);
                                                                                                                           if(var104 == '<') {
                                                                                                                              var72 = true;
                                                                                                                           } else if(var104 == '>') {
                                                                                                                              var72 = false;
                                                                                                                           } else if(!var72) {
                                                                                                                              var108.append(var104);
                                                                                                                           }
                                                                                                                        }

                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var108.toString();
                                                                                                                        var13 = 1;
                                                                                                                     }
                                                                                                                  }
                                                                                                               }

                                                                                                               var12 = var13;
                                                                                                            } else if(var57 < 4300) {
                                                                                                               if(var57 == 4200) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = class139.getItemDefinition(var14).name;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  ItemComposition var98;
                                                                                                                  if(var57 == 4201) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var14 = class82.intStack[class82.intStackSize];
                                                                                                                     var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     var98 = class139.getItemDefinition(var14);
                                                                                                                     if(var15 >= 1 && var15 <= 5 && var98.groundActions[var15 - 1] != null) {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var98.groundActions[var15 - 1];
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4202) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var14 = class82.intStack[class82.intStackSize];
                                                                                                                     var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     var98 = class139.getItemDefinition(var14);
                                                                                                                     if(var15 >= 1 && var15 <= 5 && var98.inventoryActions[var15 - 1] != null) {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var98.inventoryActions[var15 - 1];
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4203) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class139.getItemDefinition(var14).price;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 4204) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class139.getItemDefinition(var14).isStackable == 1?1:0;
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     ItemComposition var115;
                                                                                                                     if(var57 == 4205) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        var115 = class139.getItemDefinition(var14);
                                                                                                                        if(var115.notedTemplate == -1 && var115.note >= 0) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var115.note;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var14;
                                                                                                                        }

                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4206) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        var115 = class139.getItemDefinition(var14);
                                                                                                                        if(var115.notedTemplate >= 0 && var115.note >= 0) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var115.note;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var14;
                                                                                                                        }

                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4207) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class139.getItemDefinition(var14).isMembers?1:0;
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4208) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        var115 = class139.getItemDefinition(var14);
                                                                                                                        if(var115.field3558 == -1 && var115.field3592 >= 0) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var115.field3592;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var14;
                                                                                                                        }

                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4209) {
                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                        var115 = class139.getItemDefinition(var14);
                                                                                                                        if(var115.field3558 >= 0 && var115.field3592 >= 0) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var115.field3592;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var14;
                                                                                                                        }

                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 4210) {
                                                                                                                        var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                        var15 = class82.intStack[--class82.intStackSize];
                                                                                                                        class8.method38(var89, var15 == 1);
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class60.field696;
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 != 4211) {
                                                                                                                        if(var57 == 4212) {
                                                                                                                           WorldMapType1.field407 = 0;
                                                                                                                           var13 = 1;
                                                                                                                        } else {
                                                                                                                           var13 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        if(ChatLineBuffer.field1454 != null && WorldMapType1.field407 < class60.field696) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = ChatLineBuffer.field1454[++WorldMapType1.field407 - 1] & '\uffff';
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                        }

                                                                                                                        var13 = 1;
                                                                                                                     }
                                                                                                                  }
                                                                                                               }

                                                                                                               var12 = var13;
                                                                                                            } else if(var57 < 5100) {
                                                                                                               if(var57 == 5000) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.field1063;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5001) {
                                                                                                                  class82.intStackSize -= 3;
                                                                                                                  Client.field1063 = class82.intStack[class82.intStackSize];
                                                                                                                  FloorUnderlayDefinition.field3397 = class217.method3960(class82.intStack[class82.intStackSize + 1]);
                                                                                                                  if(FloorUnderlayDefinition.field3397 == null) {
                                                                                                                     FloorUnderlayDefinition.field3397 = class285.field3783;
                                                                                                                  }

                                                                                                                  Client.field1064 = class82.intStack[class82.intStackSize + 2];
                                                                                                                  PacketNode var124 = class18.method133(ClientPacket.field2316, Client.field905.field1460);
                                                                                                                  var124.packetBuffer.putByte(Client.field1063);
                                                                                                                  var124.packetBuffer.putByte(FloorUnderlayDefinition.field3397.field3785);
                                                                                                                  var124.packetBuffer.putByte(Client.field1064);
                                                                                                                  Client.field905.method1855(var124);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5002) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  var15 = class82.intStack[class82.intStackSize];
                                                                                                                  var16 = class82.intStack[class82.intStackSize + 1];
                                                                                                                  var60 = class18.method133(ClientPacket.field2330, Client.field905.field1460);
                                                                                                                  var60.packetBuffer.putByte(class23.getLength(var89) + 2);
                                                                                                                  var60.packetBuffer.putString(var89);
                                                                                                                  var60.packetBuffer.putByte(var15 - 1);
                                                                                                                  var60.packetBuffer.putByte(var16);
                                                                                                                  Client.field905.method1855(var60);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5003) {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  var14 = class82.intStack[class82.intStackSize];
                                                                                                                  var15 = class82.intStack[class82.intStackSize + 1];
                                                                                                                  ChatLineBuffer var78 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var14));
                                                                                                                  MessageNode var101 = var78.method1847(var15);
                                                                                                                  if(var101 != null) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var101.id;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var101.tick;
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var101.name != null?var101.name:"";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var101.sender != null?var101.sender:"";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var101.value != null?var101.value:"";
                                                                                                                  } else {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5004) {
                                                                                                                  var14 = class82.intStack[--class82.intStackSize];
                                                                                                                  MessageNode var117 = (MessageNode)class96.field1425.get((long)var14);
                                                                                                                  if(var117 != null) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var117.type;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var117.tick;
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var117.name != null?var117.name:"";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var117.sender != null?var117.sender:"";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var117.value != null?var117.value:"";
                                                                                                                  } else {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5005) {
                                                                                                                  if(FloorUnderlayDefinition.field3397 == null) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = FloorUnderlayDefinition.field3397.field3785;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5008) {
                                                                                                                  var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                  var15 = class82.intStack[--class82.intStackSize];
                                                                                                                  var86 = var89.toLowerCase();
                                                                                                                  byte var105 = 0;
                                                                                                                  if(var86.startsWith("yellow:")) {
                                                                                                                     var105 = 0;
                                                                                                                     var89 = var89.substring("yellow:".length());
                                                                                                                  } else if(var86.startsWith("red:")) {
                                                                                                                     var105 = 1;
                                                                                                                     var89 = var89.substring("red:".length());
                                                                                                                  } else if(var86.startsWith("green:")) {
                                                                                                                     var105 = 2;
                                                                                                                     var89 = var89.substring("green:".length());
                                                                                                                  } else if(var86.startsWith("cyan:")) {
                                                                                                                     var105 = 3;
                                                                                                                     var89 = var89.substring("cyan:".length());
                                                                                                                  } else if(var86.startsWith("purple:")) {
                                                                                                                     var105 = 4;
                                                                                                                     var89 = var89.substring("purple:".length());
                                                                                                                  } else if(var86.startsWith("white:")) {
                                                                                                                     var105 = 5;
                                                                                                                     var89 = var89.substring("white:".length());
                                                                                                                  } else if(var86.startsWith("flash1:")) {
                                                                                                                     var105 = 6;
                                                                                                                     var89 = var89.substring("flash1:".length());
                                                                                                                  } else if(var86.startsWith("flash2:")) {
                                                                                                                     var105 = 7;
                                                                                                                     var89 = var89.substring("flash2:".length());
                                                                                                                  } else if(var86.startsWith("flash3:")) {
                                                                                                                     var105 = 8;
                                                                                                                     var89 = var89.substring("flash3:".length());
                                                                                                                  } else if(var86.startsWith("glow1:")) {
                                                                                                                     var105 = 9;
                                                                                                                     var89 = var89.substring("glow1:".length());
                                                                                                                  } else if(var86.startsWith("glow2:")) {
                                                                                                                     var105 = 10;
                                                                                                                     var89 = var89.substring("glow2:".length());
                                                                                                                  } else if(var86.startsWith("glow3:")) {
                                                                                                                     var105 = 11;
                                                                                                                     var89 = var89.substring("glow3:".length());
                                                                                                                  } else if(Client.languageId != 0) {
                                                                                                                     if(var86.startsWith("yellow:")) {
                                                                                                                        var105 = 0;
                                                                                                                        var89 = var89.substring("yellow:".length());
                                                                                                                     } else if(var86.startsWith("red:")) {
                                                                                                                        var105 = 1;
                                                                                                                        var89 = var89.substring("red:".length());
                                                                                                                     } else if(var86.startsWith("green:")) {
                                                                                                                        var105 = 2;
                                                                                                                        var89 = var89.substring("green:".length());
                                                                                                                     } else if(var86.startsWith("cyan:")) {
                                                                                                                        var105 = 3;
                                                                                                                        var89 = var89.substring("cyan:".length());
                                                                                                                     } else if(var86.startsWith("purple:")) {
                                                                                                                        var105 = 4;
                                                                                                                        var89 = var89.substring("purple:".length());
                                                                                                                     } else if(var86.startsWith("white:")) {
                                                                                                                        var105 = 5;
                                                                                                                        var89 = var89.substring("white:".length());
                                                                                                                     } else if(var86.startsWith("flash1:")) {
                                                                                                                        var105 = 6;
                                                                                                                        var89 = var89.substring("flash1:".length());
                                                                                                                     } else if(var86.startsWith("flash2:")) {
                                                                                                                        var105 = 7;
                                                                                                                        var89 = var89.substring("flash2:".length());
                                                                                                                     } else if(var86.startsWith("flash3:")) {
                                                                                                                        var105 = 8;
                                                                                                                        var89 = var89.substring("flash3:".length());
                                                                                                                     } else if(var86.startsWith("glow1:")) {
                                                                                                                        var105 = 9;
                                                                                                                        var89 = var89.substring("glow1:".length());
                                                                                                                     } else if(var86.startsWith("glow2:")) {
                                                                                                                        var105 = 10;
                                                                                                                        var89 = var89.substring("glow2:".length());
                                                                                                                     } else if(var86.startsWith("glow3:")) {
                                                                                                                        var105 = 11;
                                                                                                                        var89 = var89.substring("glow3:".length());
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var86 = var89.toLowerCase();
                                                                                                                  byte var110 = 0;
                                                                                                                  if(var86.startsWith("wave:")) {
                                                                                                                     var110 = 1;
                                                                                                                     var89 = var89.substring("wave:".length());
                                                                                                                  } else if(var86.startsWith("wave2:")) {
                                                                                                                     var110 = 2;
                                                                                                                     var89 = var89.substring("wave2:".length());
                                                                                                                  } else if(var86.startsWith("shake:")) {
                                                                                                                     var110 = 3;
                                                                                                                     var89 = var89.substring("shake:".length());
                                                                                                                  } else if(var86.startsWith("scroll:")) {
                                                                                                                     var110 = 4;
                                                                                                                     var89 = var89.substring("scroll:".length());
                                                                                                                  } else if(var86.startsWith("slide:")) {
                                                                                                                     var110 = 5;
                                                                                                                     var89 = var89.substring("slide:".length());
                                                                                                                  } else if(Client.languageId != 0) {
                                                                                                                     if(var86.startsWith("wave:")) {
                                                                                                                        var110 = 1;
                                                                                                                        var89 = var89.substring("wave:".length());
                                                                                                                     } else if(var86.startsWith("wave2:")) {
                                                                                                                        var110 = 2;
                                                                                                                        var89 = var89.substring("wave2:".length());
                                                                                                                     } else if(var86.startsWith("shake:")) {
                                                                                                                        var110 = 3;
                                                                                                                        var89 = var89.substring("shake:".length());
                                                                                                                     } else if(var86.startsWith("scroll:")) {
                                                                                                                        var110 = 4;
                                                                                                                        var89 = var89.substring("scroll:".length());
                                                                                                                     } else if(var86.startsWith("slide:")) {
                                                                                                                        var110 = 5;
                                                                                                                        var89 = var89.substring("slide:".length());
                                                                                                                     }
                                                                                                                  }

                                                                                                                  PacketNode var116 = class18.method133(ClientPacket.field2321, Client.field905.field1460);
                                                                                                                  var116.packetBuffer.putByte(0);
                                                                                                                  var20 = var116.packetBuffer.offset;
                                                                                                                  var116.packetBuffer.putByte(var15);
                                                                                                                  var116.packetBuffer.putByte(var105);
                                                                                                                  var116.packetBuffer.putByte(var110);
                                                                                                                  ISAACCipher.method3499(var116.packetBuffer, var89);
                                                                                                                  var116.packetBuffer.method3197(var116.packetBuffer.offset - var20);
                                                                                                                  Client.field905.method1855(var116);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 5009) {
                                                                                                                  class259.scriptStringStackSize -= 2;
                                                                                                                  var89 = class82.scriptStringStack[class259.scriptStringStackSize];
                                                                                                                  var87 = class82.scriptStringStack[class259.scriptStringStackSize + 1];
                                                                                                                  var88 = class18.method133(ClientPacket.field2308, Client.field905.field1460);
                                                                                                                  var88.packetBuffer.putShort(0);
                                                                                                                  var34 = var88.packetBuffer.offset;
                                                                                                                  var88.packetBuffer.putString(var89);
                                                                                                                  PacketBuffer var74 = var88.packetBuffer;
                                                                                                                  var19 = var74.offset;
                                                                                                                  var39 = var87.length();
                                                                                                                  byte[] var40 = new byte[var39];
                                                                                                                  var23 = 0;

                                                                                                                  while(true) {
                                                                                                                     if(var23 >= var39) {
                                                                                                                        var74.putShortSmart(var40.length);
                                                                                                                        var74.offset += class272.field3707.compress(var40, 0, var40.length, var74.payload, var74.offset);
                                                                                                                        var88.packetBuffer.method3182(var88.packetBuffer.offset - var34);
                                                                                                                        Client.field905.method1855(var88);
                                                                                                                        var13 = 1;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     var41 = var87.charAt(var23);
                                                                                                                     if(var41 > 0 && var41 < 128 || var41 >= 160 && var41 <= 255) {
                                                                                                                        var40[var23] = (byte)var41;
                                                                                                                     } else if(var41 == 8364) {
                                                                                                                        var40[var23] = -128;
                                                                                                                     } else if(var41 == 8218) {
                                                                                                                        var40[var23] = -126;
                                                                                                                     } else if(var41 == 402) {
                                                                                                                        var40[var23] = -125;
                                                                                                                     } else if(var41 == 8222) {
                                                                                                                        var40[var23] = -124;
                                                                                                                     } else if(var41 == 8230) {
                                                                                                                        var40[var23] = -123;
                                                                                                                     } else if(var41 == 8224) {
                                                                                                                        var40[var23] = -122;
                                                                                                                     } else if(var41 == 8225) {
                                                                                                                        var40[var23] = -121;
                                                                                                                     } else if(var41 == 710) {
                                                                                                                        var40[var23] = -120;
                                                                                                                     } else if(var41 == 8240) {
                                                                                                                        var40[var23] = -119;
                                                                                                                     } else if(var41 == 352) {
                                                                                                                        var40[var23] = -118;
                                                                                                                     } else if(var41 == 8249) {
                                                                                                                        var40[var23] = -117;
                                                                                                                     } else if(var41 == 338) {
                                                                                                                        var40[var23] = -116;
                                                                                                                     } else if(var41 == 381) {
                                                                                                                        var40[var23] = -114;
                                                                                                                     } else if(var41 == 8216) {
                                                                                                                        var40[var23] = -111;
                                                                                                                     } else if(var41 == 8217) {
                                                                                                                        var40[var23] = -110;
                                                                                                                     } else if(var41 == 8220) {
                                                                                                                        var40[var23] = -109;
                                                                                                                     } else if(var41 == 8221) {
                                                                                                                        var40[var23] = -108;
                                                                                                                     } else if(var41 == 8226) {
                                                                                                                        var40[var23] = -107;
                                                                                                                     } else if(var41 == 8211) {
                                                                                                                        var40[var23] = -106;
                                                                                                                     } else if(var41 == 8212) {
                                                                                                                        var40[var23] = -105;
                                                                                                                     } else if(var41 == 732) {
                                                                                                                        var40[var23] = -104;
                                                                                                                     } else if(var41 == 8482) {
                                                                                                                        var40[var23] = -103;
                                                                                                                     } else if(var41 == 353) {
                                                                                                                        var40[var23] = -102;
                                                                                                                     } else if(var41 == 8250) {
                                                                                                                        var40[var23] = -101;
                                                                                                                     } else if(var41 == 339) {
                                                                                                                        var40[var23] = -100;
                                                                                                                     } else if(var41 == 382) {
                                                                                                                        var40[var23] = -98;
                                                                                                                     } else if(var41 == 376) {
                                                                                                                        var40[var23] = -97;
                                                                                                                     } else {
                                                                                                                        var40[var23] = 63;
                                                                                                                     }

                                                                                                                     ++var23;
                                                                                                                  }
                                                                                                               } else if(var57 != 5015) {
                                                                                                                  if(var57 == 5016) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.field1064;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 5017) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = ItemContainer.method1016(var14);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 5018) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = BaseVarType.method9(var14);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 5019) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = KeyFocusListener.method701(var14);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 5020) {
                                                                                                                     var89 = class82.scriptStringStack[--class259.scriptStringStackSize];
                                                                                                                     if(var89.equalsIgnoreCase("toggleroof")) {
                                                                                                                        class70.preferences.hideRoofs = !class70.preferences.hideRoofs;
                                                                                                                        GameEngine.method925();
                                                                                                                        if(class70.preferences.hideRoofs) {
                                                                                                                           class3.sendGameMessage(99, "", "Roofs are now all hidden");
                                                                                                                        } else {
                                                                                                                           class3.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var89.equalsIgnoreCase("displayfps")) {
                                                                                                                        Client.displayFps = !Client.displayFps;
                                                                                                                     }

                                                                                                                     if(Client.rights >= 2) {
                                                                                                                        if(var89.equalsIgnoreCase("aabb")) {
                                                                                                                           if(!class7.field219) {
                                                                                                                              class7.field219 = true;
                                                                                                                              class7.field218 = class11.field250;
                                                                                                                           } else if(class11.field250 == class7.field218) {
                                                                                                                              class7.field219 = true;
                                                                                                                              class7.field218 = class11.field251;
                                                                                                                           } else {
                                                                                                                              class7.field219 = false;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        if(var89.equalsIgnoreCase("fpson")) {
                                                                                                                           Client.displayFps = true;
                                                                                                                        }

                                                                                                                        if(var89.equalsIgnoreCase("fpsoff")) {
                                                                                                                           Client.displayFps = false;
                                                                                                                        }

                                                                                                                        if(var89.equalsIgnoreCase("gc")) {
                                                                                                                           System.gc();
                                                                                                                        }

                                                                                                                        if(var89.equalsIgnoreCase("clientdrop")) {
                                                                                                                           ScriptEvent.method1036();
                                                                                                                        }

                                                                                                                        if(var89.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                                                                                                           throw new RuntimeException();
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var85 = class18.method133(ClientPacket.field2307, Client.field905.field1460);
                                                                                                                     var85.packetBuffer.putByte(var89.length() + 1);
                                                                                                                     var85.packetBuffer.putString(var89);
                                                                                                                     Client.field905.method1855(var85);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 5021) {
                                                                                                                     Client.field1065 = class82.scriptStringStack[--class259.scriptStringStackSize].toLowerCase().trim();
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 5022) {
                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = Client.field1065;
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     var13 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  if(class275.localPlayer != null && class275.localPlayer.name != null) {
                                                                                                                     var89 = class275.localPlayer.name;
                                                                                                                  } else {
                                                                                                                     var89 = "";
                                                                                                                  }

                                                                                                                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var89;
                                                                                                                  var13 = 1;
                                                                                                               }

                                                                                                               var12 = var13;
                                                                                                            } else if(var57 < 5400) {
                                                                                                               var12 = ScriptEvent.method1039(var57, var3, var59);
                                                                                                            } else if(var57 < 5600) {
                                                                                                               var12 = class56.method773(var57, var3, var59);
                                                                                                            } else if(var57 < 5700) {
                                                                                                               var12 = class14.method92(var57, var3, var59);
                                                                                                            } else if(var57 < 6300) {
                                                                                                               if(var57 == 6200) {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  Client.field1100 = (short)class82.intStack[class82.intStackSize];
                                                                                                                  if(Client.field1100 <= 0) {
                                                                                                                     Client.field1100 = 256;
                                                                                                                  }

                                                                                                                  Client.field1101 = (short)class82.intStack[class82.intStackSize + 1];
                                                                                                                  if(Client.field1101 <= 0) {
                                                                                                                     Client.field1101 = 205;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 6201) {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  Client.field1102 = (short)class82.intStack[class82.intStackSize];
                                                                                                                  if(Client.field1102 <= 0) {
                                                                                                                     Client.field1102 = 256;
                                                                                                                  }

                                                                                                                  Client.field1103 = (short)class82.intStack[class82.intStackSize + 1];
                                                                                                                  if(Client.field1103 <= 0) {
                                                                                                                     Client.field1103 = 320;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 6202) {
                                                                                                                  class82.intStackSize -= 4;
                                                                                                                  Client.field1104 = (short)class82.intStack[class82.intStackSize];
                                                                                                                  if(Client.field1104 <= 0) {
                                                                                                                     Client.field1104 = 1;
                                                                                                                  }

                                                                                                                  Client.field1105 = (short)class82.intStack[class82.intStackSize + 1];
                                                                                                                  if(Client.field1105 <= 0) {
                                                                                                                     Client.field1105 = 32767;
                                                                                                                  } else if(Client.field1105 < Client.field1104) {
                                                                                                                     Client.field1105 = Client.field1104;
                                                                                                                  }

                                                                                                                  Client.field1106 = (short)class82.intStack[class82.intStackSize + 2];
                                                                                                                  if(Client.field1106 <= 0) {
                                                                                                                     Client.field1106 = 1;
                                                                                                                  }

                                                                                                                  Client.field1107 = (short)class82.intStack[class82.intStackSize + 3];
                                                                                                                  if(Client.field1107 <= 0) {
                                                                                                                     Client.field1107 = 32767;
                                                                                                                  } else if(Client.field1107 < Client.field1106) {
                                                                                                                     Client.field1107 = Client.field1106;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 6203) {
                                                                                                                  if(Client.field1019 != null) {
                                                                                                                     FileOnDisk.method2387(0, 0, Client.field1019.width, Client.field1019.height, false);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.viewportHeight;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.viewportWidth;
                                                                                                                  } else {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 6204) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.field1102;
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.field1103;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var57 == 6205) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.field1100;
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = Client.field1101;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  var13 = 2;
                                                                                                               }

                                                                                                               var12 = var13;
                                                                                                            } else if(var57 < 6600) {
                                                                                                               var12 = class39.method518(var57, var3, var59);
                                                                                                            } else if(var57 < 6700) {
                                                                                                               if(var57 == 6600) {
                                                                                                                  var14 = class28.plane;
                                                                                                                  var15 = (class275.localPlayer.x >> 7) + class13.baseX;
                                                                                                                  var16 = (class275.localPlayer.y >> 7) + ClanMember.baseY;
                                                                                                                  class64.method1018().method5246(var14, var15, var16, true);
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  WorldMapData var103;
                                                                                                                  if(var57 == 6601) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     var87 = "";
                                                                                                                     var103 = class64.method1018().method5262(var14);
                                                                                                                     if(var103 != null) {
                                                                                                                        var87 = var103.method259();
                                                                                                                     }

                                                                                                                     class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var87;
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 6602) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class64.method1018().method5276(var14);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 6603) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5280();
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 6604) {
                                                                                                                     var14 = class82.intStack[--class82.intStackSize];
                                                                                                                     class64.method1018().method5256(var14);
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var57 == 6605) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5419()?1:0;
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     Coordinates var125;
                                                                                                                     if(var57 == 6606) {
                                                                                                                        var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                        class64.method1018().method5263(var125.worldX, var125.worldY);
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 6607) {
                                                                                                                        var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                        class64.method1018().method5264(var125.worldX, var125.worldY);
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 6608) {
                                                                                                                        var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                        class64.method1018().method5395(var125.plane, var125.worldX, var125.worldY);
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 6609) {
                                                                                                                        var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                        class64.method1018().method5266(var125.plane, var125.worldX, var125.worldY);
                                                                                                                        var13 = 1;
                                                                                                                     } else if(var57 == 6610) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5415();
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5268();
                                                                                                                        var13 = 1;
                                                                                                                     } else {
                                                                                                                        WorldMapData var120;
                                                                                                                        if(var57 == 6611) {
                                                                                                                           var14 = class82.intStack[--class82.intStackSize];
                                                                                                                           var120 = class64.method1018().method5262(var14);
                                                                                                                           if(var120 == null) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var120.method269().method3966();
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 6612) {
                                                                                                                           var14 = class82.intStack[--class82.intStackSize];
                                                                                                                           var120 = class64.method1018().method5262(var14);
                                                                                                                           if(var120 == null) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = (var120.method312() - var120.method255() + 1) * 64;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = (var120.method310() - var120.method264() + 1) * 64;
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 6613) {
                                                                                                                           var14 = class82.intStack[--class82.intStackSize];
                                                                                                                           var120 = class64.method1018().method5262(var14);
                                                                                                                           if(var120 == null) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var120.method255() * 64;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var120.method264() * 64;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var120.method312() * 64 + 64 - 1;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var120.method310() * 64 + 64 - 1;
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 6614) {
                                                                                                                           var14 = class82.intStack[--class82.intStackSize];
                                                                                                                           var120 = class64.method1018().method5262(var14);
                                                                                                                           if(var120 == null) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var120.method263();
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 6615) {
                                                                                                                           var125 = class64.method1018().method5269();
                                                                                                                           if(var125 == null) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var125.worldX;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var125.worldY;
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 6616) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5248();
                                                                                                                           var13 = 1;
                                                                                                                        } else if(var57 == 6617) {
                                                                                                                           var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                           var120 = class64.method1018().method5249();
                                                                                                                           if(var120 == null) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                              var13 = 1;
                                                                                                                           } else {
                                                                                                                              int[] var106 = var120.method253(var125.plane, var125.worldX, var125.worldY);
                                                                                                                              if(var106 == null) {
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = var106[0];
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = var106[1];
                                                                                                                              }

                                                                                                                              var13 = 1;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           Coordinates var109;
                                                                                                                           if(var57 == 6618) {
                                                                                                                              var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                              var120 = class64.method1018().method5249();
                                                                                                                              if(var120 == null) {
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                 var13 = 1;
                                                                                                                              } else {
                                                                                                                                 var109 = var120.method254(var125.worldX, var125.worldY);
                                                                                                                                 if(var109 == null) {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = var109.method3966();
                                                                                                                                 }

                                                                                                                                 var13 = 1;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              Coordinates var121;
                                                                                                                              if(var57 == 6619) {
                                                                                                                                 class82.intStackSize -= 2;
                                                                                                                                 var14 = class82.intStack[class82.intStackSize];
                                                                                                                                 var121 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                                                                                                                 class5.method16(var14, var121, false);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6620) {
                                                                                                                                 class82.intStackSize -= 2;
                                                                                                                                 var14 = class82.intStack[class82.intStackSize];
                                                                                                                                 var121 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                                                                                                                 class5.method16(var14, var121, true);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6621) {
                                                                                                                                 class82.intStackSize -= 2;
                                                                                                                                 var14 = class82.intStack[class82.intStackSize];
                                                                                                                                 var121 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                                                                                                                 var103 = class64.method1018().method5262(var14);
                                                                                                                                 if(var103 == null) {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                                    var13 = 1;
                                                                                                                                 } else {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = var103.method274(var121.plane, var121.worldX, var121.worldY)?1:0;
                                                                                                                                    var13 = 1;
                                                                                                                                 }
                                                                                                                              } else if(var57 == 6622) {
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5270();
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5330();
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6623) {
                                                                                                                                 var125 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                                                                                                                 var120 = class64.method1018().method5245(var125.plane, var125.worldX, var125.worldY);
                                                                                                                                 if(var120 == null) {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = var120.method256();
                                                                                                                                 }

                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6624) {
                                                                                                                                 class64.method1018().method5272(class82.intStack[--class82.intStackSize]);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6625) {
                                                                                                                                 class64.method1018().method5417();
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6626) {
                                                                                                                                 class64.method1018().method5255(class82.intStack[--class82.intStackSize]);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6627) {
                                                                                                                                 class64.method1018().method5275();
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6628) {
                                                                                                                                 var77 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                                 class64.method1018().method5327(var77);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6629) {
                                                                                                                                 var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                 class64.method1018().method5317(var14);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6630) {
                                                                                                                                 var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                 class64.method1018().method5278(var14);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6631) {
                                                                                                                                 class64.method1018().method5326();
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6632) {
                                                                                                                                 var77 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                                 class64.method1018().method5237(var77);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6633) {
                                                                                                                                 class82.intStackSize -= 2;
                                                                                                                                 var14 = class82.intStack[class82.intStackSize];
                                                                                                                                 var58 = class82.intStack[class82.intStackSize + 1] == 1;
                                                                                                                                 class64.method1018().method5281(var14, var58);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6634) {
                                                                                                                                 class82.intStackSize -= 2;
                                                                                                                                 var14 = class82.intStack[class82.intStackSize];
                                                                                                                                 var58 = class82.intStack[class82.intStackSize + 1] == 1;
                                                                                                                                 class64.method1018().method5331(var14, var58);
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6635) {
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5396()?1:0;
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6636) {
                                                                                                                                 var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5284(var14)?1:0;
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6637) {
                                                                                                                                 var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                 class82.intStack[++class82.intStackSize - 1] = class64.method1018().method5370(var14)?1:0;
                                                                                                                                 var13 = 1;
                                                                                                                              } else if(var57 == 6638) {
                                                                                                                                 class82.intStackSize -= 2;
                                                                                                                                 var14 = class82.intStack[class82.intStackSize];
                                                                                                                                 var121 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                                                                                                                 var109 = class64.method1018().method5373(var14, var121);
                                                                                                                                 if(var109 == null) {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class82.intStack[++class82.intStackSize - 1] = var109.method3966();
                                                                                                                                 }

                                                                                                                                 var13 = 1;
                                                                                                                              } else {
                                                                                                                                 class39 var126;
                                                                                                                                 if(var57 == 6639) {
                                                                                                                                    var126 = class64.method1018().method5332();
                                                                                                                                    if(var126 == null) {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = var126.field498;
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = var126.field492.method3966();
                                                                                                                                    }

                                                                                                                                    var13 = 1;
                                                                                                                                 } else if(var57 == 6640) {
                                                                                                                                    var126 = class64.method1018().method5383();
                                                                                                                                    if(var126 == null) {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = var126.field498;
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = var126.field492.method3966();
                                                                                                                                    }

                                                                                                                                    var13 = 1;
                                                                                                                                 } else {
                                                                                                                                    Area var122;
                                                                                                                                    if(var57 == 6693) {
                                                                                                                                       var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                       var122 = Area.field3345[var14];
                                                                                                                                       if(var122.name == null) {
                                                                                                                                          class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                                                                                                                                       } else {
                                                                                                                                          class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var122.name;
                                                                                                                                       }

                                                                                                                                       var13 = 1;
                                                                                                                                    } else if(var57 == 6694) {
                                                                                                                                       var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                       var122 = Area.field3345[var14];
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = var122.field3359;
                                                                                                                                       var13 = 1;
                                                                                                                                    } else if(var57 == 6695) {
                                                                                                                                       var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                       var122 = Area.field3345[var14];
                                                                                                                                       if(var122 == null) {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = var122.field3365;
                                                                                                                                       }

                                                                                                                                       var13 = 1;
                                                                                                                                    } else if(var57 == 6696) {
                                                                                                                                       var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                       var122 = Area.field3345[var14];
                                                                                                                                       if(var122 == null) {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = var122.spriteId;
                                                                                                                                       }

                                                                                                                                       var13 = 1;
                                                                                                                                    } else if(var57 == 6697) {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = class25.field342.field559;
                                                                                                                                       var13 = 1;
                                                                                                                                    } else if(var57 == 6698) {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = class25.field342.field560.method3966();
                                                                                                                                       var13 = 1;
                                                                                                                                    } else if(var57 == 6699) {
                                                                                                                                       class82.intStack[++class82.intStackSize - 1] = class25.field342.field556.method3966();
                                                                                                                                       var13 = 1;
                                                                                                                                    } else {
                                                                                                                                       var13 = 2;
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }
                                                                                                               }

                                                                                                               var12 = var13;
                                                                                                            } else {
                                                                                                               var12 = 2;
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var12) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var54) {
            StringBuilder var52 = new StringBuilder(30);
            var52.append("").append(var3.hash).append(" ");

            for(var10 = class82.scriptStackCount - 1; var10 >= 0; --var10) {
               var52.append("").append(class82.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var52.append("").append(var7);
            class48.method690(var52.toString(), var54);
         }
      }
   }
}
