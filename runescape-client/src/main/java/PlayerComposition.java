import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("m")
   static final int[] field2792;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static NodeCache field2796;
   @ObfuscatedName("d")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("z")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("n")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 710552615
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 2972833358194507815L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -3891232184698795415L
   )
   long field2797;

   static {
      field2792 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2796 = new NodeCache(260);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "1962240749"
   )
   public void method4512(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3508; ++var6) {
               KitDefinition var7 = class304.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2792[var5]] = var6 + 256;
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1656688785"
   )
   public void method4518(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2792[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3508 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3508) {
                     var3 = 0;
                  }
               }

               var4 = class304.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2792[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "29"
   )
   public void method4515(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class236.colorsToReplace[var1].length - 1;
            }
         } while(!class171.method3362(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class236.colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!class171.method3362(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "93"
   )
   public void method4513(boolean var1) {
      if(this.isFemale != var1) {
         this.method4512((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1085204920"
   )
   public void method4531(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2792[var2]];
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
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
         field2796.remove(var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lki;ILki;II)Lel;",
      garbageValue = "2110594523"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class255.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var8 = (Model)field2796.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class304.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class251.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2797 != -1L) {
                  var8 = (Model)field2796.get(this.field2797);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class304.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class251.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class236.colorsToReplace[var13].length) {
                     var18.recolor(GrandExchangeOffer.colorsToFind[var13], class236.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class195.field2580[var13].length) {
                     var18.recolor(class71.field821[var13], class195.field2580[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2796.put(var8, var5);
               this.field2797 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method5288(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method5285(var8, var2);
            } else {
               var17 = var3.method5285(var8, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldf;",
      garbageValue = "100"
   )
   ModelData method4545() {
      if(this.transformedNpcId != -1) {
         return class255.getNpcDefinition(this.transformedNpcId).method5262();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class304.getKitDefinition(var3 - 256).method4979()) {
               var1 = true;
            }

            if(var3 >= 512 && !class251.getItemDefinition(var3 - 512).method5168(this.isFemale)) {
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
                  var6 = class304.getKitDefinition(var5 - 256).method4972();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class251.getItemDefinition(var5 - 512).method5167(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class236.colorsToReplace[var5].length) {
                  var8.recolor(GrandExchangeOffer.colorsToFind[var5], class236.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class195.field2580[var5].length) {
                  var8.recolor(class71.field821[var5], class195.field2580[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "694234533"
   )
   public int method4519() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class255.getNpcDefinition(this.transformedNpcId).id;
   }
}
