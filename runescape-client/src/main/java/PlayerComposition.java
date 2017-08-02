import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("r")
   static final int[] field2589;
   @ObfuscatedName("x")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field2593;
   @ObfuscatedName("s")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("k")
   public static short[][] field2591;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 902021373
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("o")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("i")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 2827668362585890635L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("c")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5788610615315993911L
   )
   long field2588;

   static {
      field2589 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2593 = new NodeCache(260);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-684633902"
   )
   public void method3876(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3323; ++var6) {
               KitDefinition var7 = class267.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2589[var5]] = var6 + 256;
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2428435"
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
      if(var1 != 0L && this.hash != var1) {
         field2593.remove(var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljc;ILjc;II)Leo;",
      garbageValue = "-1925106240"
   )
   public Model method3882(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return WorldMapType3.getNpcDefinition(this.transformedNpcId).method4514(var1, var2, var3, var4);
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

         Model var15 = (Model)field2593.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class267.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class10.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2588) {
                  var15 = (Model)field2593.get(this.field2588);
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
                     var14 = class267.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class10.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var18.recolor(colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2591[var13].length) {
                     var18.recolor(class244.field3296[var13], field2591[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2593.put(var15, var5);
               this.field2588 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4582(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4583(var15, var2);
            } else {
               var17 = var3.method4583(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ldj;",
      garbageValue = "635381113"
   )
   ModelData method3883() {
      if(this.transformedNpcId != -1) {
         return WorldMapType3.getNpcDefinition(this.transformedNpcId).method4515();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class267.getKitDefinition(var3 - 256).method4257()) {
               var1 = true;
            }

            if(var3 >= 512 && !class10.getItemDefinition(var3 - 512).method4496(this.isFemale)) {
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
                  var6 = class267.getKitDefinition(var5 - 256).method4260();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class10.getItemDefinition(var5 - 512).method4454(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < colorsToReplace[var5].length) {
                  var8.recolor(colorsToFind[var5], colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2591[var5].length) {
                  var8.recolor(class244.field3296[var5], field2591[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "92"
   )
   public void method3877(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2589[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3323 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3323) {
                     var3 = 0;
                  }
               }

               var4 = class267.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || (this.isFemale?7:0) + var1 != var4.bodyPartId);

            this.equipmentIds[field2589[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1406070048"
   )
   public void method3897(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = colorsToReplace[var1].length - 1;
            }
         } while(!class217.method3965(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!class217.method3965(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2141957012"
   )
   public void method3879(boolean var1) {
      if(this.isFemale != var1) {
         this.method3876((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1334697953"
   )
   public void method3880(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2589[var2]];
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "119629141"
   )
   public int method3891() {
      return this.transformedNpcId == -1?(this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + this.equipmentIds[1] + (this.bodyPartColours[0] << 25):305419896 + WorldMapType3.getNpcDefinition(this.transformedNpcId).id;
   }
}
