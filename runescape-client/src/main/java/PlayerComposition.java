import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("f")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("e")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("p")
   public static NodeCache field2175 = new NodeCache(260);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 925990061
   )
   public int field2176;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 3532591132925349727L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -4174197803001895903L
   )
   long field2178;
   @ObfuscatedName("i")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("h")
   static final int[] field2180 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("v")
   public static short[][] field2183;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1926966161"
   )
   public Model method3063(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2176 != -1) {
         return TextureProvider.getNpcDefinition(this.field2176).method3634(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
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

         Model var8 = (Model)field2175.get(var5);
         if(var8 == null) {
            boolean var16 = false;

            int var11;
            for(int var17 = 0; var17 < 12; ++var17) {
               var11 = var7[var17];
               if(var11 >= 256 && var11 < 512 && !Renderable.getKitDefinition(var11 - 256).ready()) {
                  var16 = true;
               }

               if(var11 >= 512 && !class7.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(-1L != this.field2178) {
                  var8 = (Model)field2175.get(this.field2178);
               }

               if(null == var8) {
                  return null;
               }
            }

            if(null == var8) {
               ModelData[] var10 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var18 = 0; var18 < 12; ++var18) {
                  var13 = var7[var18];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = Renderable.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var10[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class7.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var10[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var10, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class217.field3169[var13].length) {
                     var12.method1483(FileOnDisk.field1195[var13], class217.field3169[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2183[var13].length) {
                     var12.method1483(class0.field4[var13], field2183[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var12.method1480(64, 850, -30, -50, -30);
               field2175.put(var8, var5);
               this.field2178 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var9;
            if(var1 != null && null != var3) {
               var9 = var1.method3684(var8, var2, var3, var4);
            } else if(var1 != null) {
               var9 = var1.method3681(var8, var2);
            } else {
               var9 = var3.method3681(var8, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "779585224"
   )
   public void method3064(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2817; ++var6) {
               KitDefinition var7 = Renderable.getKitDefinition(var6);
               if(var7 != null && !var7.field2829 && var7.field2819 == var5 + (var3?7:0)) {
                  var1[field2180[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2176 = var4;
      this.method3069();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-183220953"
   )
   public void method3065(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2180[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2817 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2817) {
                     var3 = 0;
                  }
               }

               var4 = Renderable.getKitDefinition(var3);
            } while(var4 == null || var4.field2829 || var4.field2819 != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2180[var1]] = var3 + 256;
            this.method3069();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2005871191"
   )
   public void method3066(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class217.field3169[var1].length - 1;
            }
         } while(!class13.method164(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class217.field3169[var1].length) {
               var3 = 0;
            }
         } while(!class13.method164(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3069();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1465206913"
   )
   public void method3067(boolean var1) {
      if(this.isFemale != var1) {
         this.method3064((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2119789654"
   )
   public void method3068(Buffer var1) {
      var1.method2932(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2180[var2]];
         if(var3 == 0) {
            var1.method2932(-1);
         } else {
            var1.method2932(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2932(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "999932290"
   )
   void method3069() {
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
      if(0L != var1 && var1 != this.hash) {
         field2175.remove(var1);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "183405669"
   )
   ModelData method3071() {
      if(this.field2176 != -1) {
         return TextureProvider.getNpcDefinition(this.field2176).method3654();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !Renderable.getKitDefinition(var3 - 256).method3442()) {
               var1 = true;
            }

            if(var3 >= 512 && !class7.getItemDefinition(var3 - 512).method3587(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var8 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var7 = 0; var7 < 12; ++var7) {
               var5 = this.equipmentIds[var7];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = Renderable.getKitDefinition(var5 - 256).method3443();
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class7.getItemDefinition(var5 - 512).method3623(this.isFemale);
                  if(null != var6) {
                     var8[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class217.field3169[var5].length) {
                  var4.method1483(FileOnDisk.field1195[var5], class217.field3169[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2183[var5].length) {
                  var4.method1483(class0.field4[var5], field2183[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;IB)Z",
      garbageValue = "52"
   )
   static boolean method3074(class182 var0, int var1) {
      byte[] var2 = var0.method3216(var1);
      if(null == var2) {
         return false;
      } else {
         class204.method3735(var2);
         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "904067777"
   )
   static void method3086(GameEngine var0) {
      if(class115.field1802 == 1 || !class103.field1662 && class115.field1802 == 4) {
         int var1 = 280 + class41.field824;
         if(class115.field1803 >= var1 && class115.field1803 <= 14 + var1 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(0, 0);
            return;
         }

         if(class115.field1803 >= 15 + var1 && class115.field1803 <= var1 + 80 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(0, 1);
            return;
         }

         int var2 = class41.field824 + 390;
         if(class115.field1803 >= var2 && class115.field1803 <= var2 + 14 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(1, 0);
            return;
         }

         if(class115.field1803 >= var2 + 15 && class115.field1803 <= 80 + var2 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(1, 1);
            return;
         }

         int var3 = class41.field824 + 500;
         if(class115.field1803 >= var3 && class115.field1803 <= 14 + var3 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(2, 0);
            return;
         }

         if(class115.field1803 >= 15 + var3 && class115.field1803 <= 80 + var3 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(2, 1);
            return;
         }

         int var4 = 610 + class41.field824;
         if(class115.field1803 >= var4 && class115.field1803 <= 14 + var4 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(3, 0);
            return;
         }

         if(class115.field1803 >= 15 + var4 && class115.field1803 <= 80 + var4 && class115.field1804 >= 4 && class115.field1804 <= 18) {
            class114.method2163(3, 1);
            return;
         }

         if(class115.field1803 >= class41.field824 + 708 && class115.field1804 >= 4 && class115.field1803 <= 50 + class41.field824 + 708 && class115.field1804 <= 20) {
            class41.worldSelectShown = false;
            class16.field172.method4071(class41.field824, 0);
            class41.field861.method4071(class41.field824 + 382, 0);
            class101.field1639.method3979(class41.field824 + 382 - class101.field1639.originalWidth / 2, 18);
            return;
         }

         if(class41.field858 != -1) {
            World var5 = class107.worldList[class41.field858];
            class47.selectWorld(var5);
            class41.worldSelectShown = false;
            class16.field172.method4071(class41.field824, 0);
            class41.field861.method4071(class41.field824 + 382, 0);
            class101.field1639.method3979(class41.field824 + 382 - class101.field1639.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "13075353"
   )
   public int method3087() {
      return this.field2176 == -1?(this.equipmentIds[11] << 5) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[0] << 15) + (this.equipmentIds[8] << 10) + this.equipmentIds[1]:305419896 + TextureProvider.getNpcDefinition(this.field2176).id;
   }
}
