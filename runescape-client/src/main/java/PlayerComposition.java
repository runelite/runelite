import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 884466431
   )
   public int field2014;
   @ObfuscatedName("y")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("o")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("s")
   static final int[] field2017 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -3229877879417602785L
   )
   long field2019;
   @ObfuscatedName("q")
   public static short[] field2020;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -6783164593559849803L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("g")
   public static NodeCache field2022 = new NodeCache(260);
   @ObfuscatedName("cy")
   static class102 field2023;
   @ObfuscatedName("i")
   public static class60 field2024;
   @ObfuscatedName("k")
   @Export("equipmentIds")
   int[] equipmentIds;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-4"
   )
   ModelData method2732() {
      if(this.field2014 != -1) {
         return class45.getNpcDefinition(this.field2014).method3704();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class169.getKitDefinition(var3 - 256).method3499()) {
               var1 = true;
            }

            if(var3 >= 512 && !getItemDefinition(var3 - 512).method3694(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var8 = 0; var8 < 12; ++var8) {
               var5 = this.equipmentIds[var8];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class169.getKitDefinition(var5 - 256).method3496();
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = getItemDefinition(var5 - 512).method3643(this.isFemale);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class101.field1661[var5].length) {
                  var4.method1474(field2020[var5], class101.field1661[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class167.field2307[var5].length) {
                  var4.method1474(class227.field3231[var5], class167.field2307[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "2005392799"
   )
   public void method2733(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2810; ++var6) {
               KitDefinition var7 = class169.getKitDefinition(var6);
               if(null != var7 && !var7.field2811 && var7.field2804 == var5 + (var3?7:0)) {
                  var1[field2017[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2014 = var4;
      this.method2759();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1497232578"
   )
   public void method2735(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class101.field1661[var1].length - 1;
            }
         } while(!class171.method3248(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class101.field1661[var1].length) {
               var3 = 0;
            }
         } while(!class171.method3248(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method2759();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1886065116"
   )
   public void method2736(boolean var1) {
      if(var1 != this.isFemale) {
         this.method2733((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2137682424"
   )
   public int method2737() {
      return this.field2014 == -1?(this.equipmentIds[8] << 10) + (this.equipmentIds[0] << 15) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[11] << 5) + this.equipmentIds[1]:305419896 + class45.getNpcDefinition(this.field2014).id;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "2"
   )
   public Model method2739(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2014 != -1) {
         return class45.getNpcDefinition(this.field2014).method3703(var1, var2, var3, var4);
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

         Model var15 = (Model)field2022.get(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class169.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2019) {
                  var15 = (Model)field2022.get(this.field2019);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(null == var15) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class169.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class101.field1661[var13].length) {
                     var18.method1474(field2020[var13], class101.field1661[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class167.field2307[var13].length) {
                     var18.method1474(class227.field3231[var13], class167.field2307[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.method1491(64, 850, -30, -50, -30);
               field2022.put(var15, var5);
               this.field2019 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var15;
         } else {
            Model var16;
            if(null != var1 && null != var3) {
               var16 = var1.method3760(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method3757(var15, var2);
            } else {
               var16 = var3.method3757(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1597688053"
   )
   public void method2743(Buffer var1) {
      var1.method2912(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2017[var2]];
         if(var3 == 0) {
            var1.method2912(-1);
         } else {
            var1.method2912(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2912(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   void method2759() {
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
         field2022.remove(var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "85"
   )
   public void method2760(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2017[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2810 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2810) {
                     var3 = 0;
                  }
               }

               var4 = class169.getKitDefinition(var3);
            } while(null == var4 || var4.field2811 || (this.isFemale?7:0) + var1 != var4.field2804);

            this.equipmentIds[field2017[var1]] = 256 + var3;
            this.method2759();
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1689914753"
   )
   static void method2762(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "295679532"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2932.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class206.field3079.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3641();
         if(var1.notedTemplate != -1) {
            var1.method3679(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2968 != -1) {
            var1.method3645(getItemDefinition(var1.field2968), getItemDefinition(var1.field2938));
         }

         if(var1.field2952 != -1) {
            var1.method3667(getItemDefinition(var1.field2952), getItemDefinition(var1.field2978));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2975 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = 0;
         }

         ItemComposition.field2932.put(var1, (long)var0);
         return var1;
      }
   }
}
