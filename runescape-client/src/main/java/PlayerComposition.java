import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("l")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("y")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("g")
   public static short[] field2743;
   @ObfuscatedName("c")
   public static short[][] field2748;
   @ObfuscatedName("u")
   static final int[] field2749;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field2754;
   @ObfuscatedName("b")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("q")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("o")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1407778579
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -510123809776966985L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 1015641736679082705L
   )
   long field2747;

   static {
      field2749 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2754 = new NodeCache(260);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1323555696"
   )
   public void method4392(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3443; ++var6) {
               KitDefinition var7 = Buffer.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2749[var5]] = var6 + 256;
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
      signature = "(IZI)V",
      garbageValue = "-341015050"
   )
   public void method4393(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2749[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3443 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3443) {
                     var3 = 0;
                  }
               }

               var4 = Buffer.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2749[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "66"
   )
   public void method4401(int var1, boolean var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-88"
   )
   public void method4414(boolean var1) {
      if(this.isFemale != var1) {
         this.method4392((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1180978224"
   )
   public void method4396(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2749[var2]];
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-726652936"
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
         field2754.remove(var1);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljo;ILjo;II)Lee;",
      garbageValue = "741660664"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return Tile.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var18 = 0; var18 < 12; ++var18) {
               var7[var18] = this.equipmentIds[var18];
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

         Model var8 = (Model)field2754.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !Buffer.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !ContextMenuRow.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2747) {
                  var8 = (Model)field2754.get(this.field2747);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var15 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = Buffer.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var15[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = ContextMenuRow.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var15[var11++] = var14;
                     }
                  }
               }

               ModelData var17 = new ModelData(var15, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var17.recolor(colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2748[var13].length) {
                     var17.recolor(field2743[var13], field2748[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var17.light(64, 850, -30, -50, -30);
               field2754.put(var8, var5);
               this.field2747 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method5134(var8, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method5136(var8, var2);
            } else {
               var16 = var3.method5136(var8, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Ldy;",
      garbageValue = "32"
   )
   ModelData method4399() {
      if(this.transformedNpcId != -1) {
         return Tile.getNpcDefinition(this.transformedNpcId).method5073();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !Buffer.getKitDefinition(var3 - 256).method4827()) {
               var1 = true;
            }

            if(var3 >= 512 && !ContextMenuRow.getItemDefinition(var3 - 512).method5010(this.isFemale)) {
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
                  var6 = Buffer.getKitDefinition(var5 - 256).method4815();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = ContextMenuRow.getItemDefinition(var5 - 512).method5011(this.isFemale);
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

               if(this.bodyPartColours[var5] < field2748[var5].length) {
                  var8.recolor(field2743[var5], field2748[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2106572315"
   )
   public int method4400() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + Tile.getNpcDefinition(this.transformedNpcId).id;
   }
}
