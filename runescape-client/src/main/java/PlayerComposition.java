import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("z")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("i")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("y")
   static final int[] field2796;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static NodeCache field2797;
   @ObfuscatedName("an")
   protected static boolean field2798;
   @ObfuscatedName("o")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("k")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("t")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -126966343
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6836462260935030465L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 5053308845801126739L
   )
   long field2793;

   static {
      field2796 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2797 = new NodeCache(260);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1588895343"
   )
   public void method4396(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3519; ++var6) {
               KitDefinition var7 = IndexFile.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2796[var5]] = var6 + 256;
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-84"
   )
   public void method4379(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2796[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3519 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3519) {
                     var3 = 0;
                  }
               }

               var4 = IndexFile.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || (this.isFemale?7:0) + var1 != var4.bodyPartId);

            this.equipmentIds[field2796[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1683887014"
   )
   public void method4406(int var1, boolean var2) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1910797346"
   )
   public void method4386(boolean var1) {
      if(this.isFemale != var1) {
         this.method4396((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "1546177492"
   )
   public void method4398(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2796[var2]];
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
      garbageValue = "-1456206240"
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
         field2797.remove(var1);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lke;ILke;II)Lei;",
      garbageValue = "1757698166"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class234.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var8 = (Model)field2797.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !IndexFile.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class47.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2793) {
                  var8 = (Model)field2797.get(this.field2793);
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
                     var14 = IndexFile.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class47.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
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

                  if(this.bodyPartColours[var13] < UrlRequest.field2135[var13].length) {
                     var18.recolor(BoundingBox2D.field246[var13], UrlRequest.field2135[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2797.put(var8, var5);
               this.field2793 = var5;
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ldg;",
      garbageValue = "586417004"
   )
   ModelData method4384() {
      if(this.transformedNpcId != -1) {
         return class234.getNpcDefinition(this.transformedNpcId).method5148();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !IndexFile.getKitDefinition(var3 - 256).method4839()) {
               var1 = true;
            }

            if(var3 >= 512 && !class47.getItemDefinition(var3 - 512).method5066(this.isFemale)) {
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
                  var6 = IndexFile.getKitDefinition(var5 - 256).method4837();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class47.getItemDefinition(var5 - 512).method5062(this.isFemale);
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

               if(this.bodyPartColours[var5] < UrlRequest.field2135[var5].length) {
                  var8.recolor(BoundingBox2D.field246[var5], UrlRequest.field2135[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1616094451"
   )
   public int method4385() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class234.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcr;ZS)I",
      garbageValue = "-13213"
   )
   static int method4409(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class81.field1285:Signlink.field2218;
      if(var0 == 1800) {
         class81.intStack[++WorldComparator.intStackSize - 1] = class250.method4502(GroundObject.getWidgetClickMask(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.opBase == null) {
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            } else {
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.opBase;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class81.intStack[--WorldComparator.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1010076986"
   )
   static final String method4408(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
