import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("d")
   static final int[] field2624;
   @ObfuscatedName("b")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field2627;
   @ObfuscatedName("s")
   public static short[][] field2629;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1558301751
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("j")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -8156824576555598861L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("a")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("i")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -7290649988719158771L
   )
   long field2622;

   static {
      field2624 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2627 = new NodeCache(260);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "57449544"
   )
   public void method3994(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3361; ++var6) {
               KitDefinition var7 = class222.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && (var3?7:0) + var5 == var7.bodyPartId) {
                  var1[field2624[var5]] = var6 + 256;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljw;ILjw;II)Lem;",
      garbageValue = "-1040370082"
   )
   public Model method4011(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class171.getNpcDefinition(this.transformedNpcId).method4619(var1, var2, var3, var4);
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

         Model var15 = (Model)field2627.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class222.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class169.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2622 != -1L) {
                  var15 = (Model)field2627.get(this.field2622);
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
                     var14 = class222.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class169.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var18.recolor(class8.colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2629[var13].length) {
                     var18.recolor(class64.field798[var13], field2629[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2627.put(var15, var5);
               this.field2622 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4670(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4667(var15, var2);
            } else {
               var17 = var3.method4667(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
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
      if(0L != var1 && this.hash != var1) {
         field2627.remove(var1);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lde;",
      garbageValue = "-287797910"
   )
   ModelData method4001() {
      if(this.transformedNpcId != -1) {
         return class171.getNpcDefinition(this.transformedNpcId).method4620();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class222.getKitDefinition(var3 - 256).method4372()) {
               var1 = true;
            }

            if(var3 >= 512 && !class169.getItemDefinition(var3 - 512).method4559(this.isFemale)) {
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
                  var6 = class222.getKitDefinition(var5 - 256).method4373();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class169.getItemDefinition(var5 - 512).method4564(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < colorsToReplace[var5].length) {
                  var8.recolor(class8.colorsToFind[var5], colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2629[var5].length) {
                  var8.recolor(class64.field798[var5], field2629[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1743259210"
   )
   public int method4002() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class171.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "8"
   )
   public void method4005(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2624[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3361 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3361) {
                     var3 = 0;
                  }
               }

               var4 = class222.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2624[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-86"
   )
   public void method3997(int var1, boolean var2) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "49"
   )
   public void method4004(boolean var1) {
      if(this.isFemale != var1) {
         this.method3994((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1593619447"
   )
   public void method3996(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2624[var2]];
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;III)Ljm;",
      garbageValue = "-1227033995"
   )
   public static Font method4019(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      return !class178.method3474(var0, var2, var3)?null:Occluder.method2939(var1.getConfigData(var2, var3));
   }
}
