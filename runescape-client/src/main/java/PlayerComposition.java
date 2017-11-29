import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("b")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("t")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("r")
   public static short[][] field2692;
   @ObfuscatedName("l")
   static final int[] field2695;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field2702;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("d")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("x")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("k")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 432869533
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 67463743691277787L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -3780734730102732469L
   )
   long field2699;

   static {
      field2695 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2702 = new NodeCache(260);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-662732898"
   )
   public void method4125(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3419; ++var6) {
               KitDefinition var7 = class181.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2695[var5]] = var6 + 256;
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1365670963"
   )
   public void method4126(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2695[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3419 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3419) {
                     var3 = 0;
                  }
               }

               var4 = class181.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2695[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1742444363"
   )
   public void method4127(int var1, boolean var2) {
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1993578184"
   )
   public void method4152(boolean var1) {
      if(this.isFemale != var1) {
         this.method4125((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfr;B)V",
      garbageValue = "15"
   )
   public void method4129(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2695[var2]];
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2141142550"
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
      if(0L != var1 && var1 != this.hash) {
         field2702.remove(var1);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljj;ILjj;IB)Leh;",
      garbageValue = "80"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class1.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var15 = (Model)field2702.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class181.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !WorldMapType2.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2699) {
                  var15 = (Model)field2702.get(this.field2699);
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
                     var14 = class181.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = WorldMapType2.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var17 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var17.recolor(colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2692[var13].length) {
                     var17.recolor(class54.field635[var13], field2692[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var17.light(64, 850, -30, -50, -30);
               field2702.put(var15, var5);
               this.field2699 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var18;
            if(var1 != null && var3 != null) {
               var18 = var1.method4880(var15, var2, var3, var4);
            } else if(var1 != null) {
               var18 = var1.method4882(var15, var2);
            } else {
               var18 = var3.method4882(var15, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ldr;",
      garbageValue = "1733861007"
   )
   ModelData method4150() {
      if(this.transformedNpcId != -1) {
         return class1.getNpcDefinition(this.transformedNpcId).method4842();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class181.getKitDefinition(var3 - 256).method4539()) {
               var1 = true;
            }

            if(var3 >= 512 && !WorldMapType2.getItemDefinition(var3 - 512).method4759(this.isFemale)) {
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
                  var6 = class181.getKitDefinition(var5 - 256).method4528();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = WorldMapType2.getItemDefinition(var5 - 512).method4760(this.isFemale);
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

               if(this.bodyPartColours[var5] < field2692[var5].length) {
                  var8.recolor(class54.field635[var5], field2692[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1914232889"
   )
   public int method4141() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class1.getNpcDefinition(this.transformedNpcId).id;
   }
}
