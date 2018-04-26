import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("s")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("i")
   static final int[] field2801;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static NodeCache field2802;
   @ObfuscatedName("g")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("e")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("b")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 977800233
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 8223052770255649411L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -3485298629962771897L
   )
   long field2800;

   static {
      field2801 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2802 = new NodeCache(260);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-867453379"
   )
   public void method4513(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3514; ++var6) {
               KitDefinition var7 = OwnWorldComparator.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2801[var5]] = var6 + 256;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2084585789"
   )
   public void method4489(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2801[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3514 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3514) {
                     var3 = 0;
                  }
               }

               var4 = OwnWorldComparator.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2801[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-453295164"
   )
   public void method4490(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class229.colorsToReplace[var1].length - 1;
            }
         } while(!class36.method543(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class229.colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!class36.method543(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-187017389"
   )
   public void method4487(boolean var1) {
      if(this.isFemale != var1) {
         this.method4513((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "1707436851"
   )
   public void method4492(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2801[var2]];
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
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
         field2802.remove(var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lkc;ILkc;IB)Lee;",
      garbageValue = "55"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return SceneTilePaint.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var8 = (Model)field2802.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !OwnWorldComparator.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !NetWriter.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2800 != -1L) {
                  var8 = (Model)field2802.get(this.field2800);
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
                     var14 = OwnWorldComparator.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = NetWriter.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class229.colorsToReplace[var13].length) {
                     var18.recolor(colorsToFind[var13], class229.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class153.field2121[var13].length) {
                     var18.recolor(class197.field2591[var13], class153.field2121[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2802.put(var8, var5);
               this.field2800 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.applyTransformations(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.transformActorModel(var8, var2);
            } else {
               var17 = var3.transformActorModel(var8, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Ldi;",
      garbageValue = "107"
   )
   ModelData method4495() {
      if(this.transformedNpcId != -1) {
         return SceneTilePaint.getNpcDefinition(this.transformedNpcId).method5198();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !OwnWorldComparator.getKitDefinition(var3 - 256).method4935()) {
               var1 = true;
            }

            if(var3 >= 512 && !NetWriter.getItemDefinition(var3 - 512).method5138(this.isFemale)) {
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
                  var6 = OwnWorldComparator.getKitDefinition(var5 - 256).method4936();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = NetWriter.getItemDefinition(var5 - 512).method5139(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class229.colorsToReplace[var5].length) {
                  var8.recolor(colorsToFind[var5], class229.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class153.field2121[var5].length) {
                  var8.recolor(class197.field2591[var5], class153.field2121[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "535901253"
   )
   public int method4496() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + SceneTilePaint.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "756916300"
   )
   public static int method4515(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
