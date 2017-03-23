import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("i")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("u")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1149407505
   )
   public int field2187;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 7331348998609833799L
   )
   long field2189;
   @ObfuscatedName("l")
   public static short[] field2190;
   @ObfuscatedName("n")
   public static short[][] field2191;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -3640421321942717273L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("s")
   static NodeCache field2193 = new NodeCache(260);
   @ObfuscatedName("ez")
   static SpritePixels[] field2194;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -1597294617
   )
   static int field2195;
   @ObfuscatedName("j")
   static final int[] field2196 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("f")
   @Export("equipmentIds")
   int[] equipmentIds;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "2"
   )
   public void method3202(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2191[var1].length - 1;
            }
         } while(!class25.method561(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= field2191[var1].length) {
               var3 = 0;
            }
         } while(!class25.method561(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3205();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1639774817"
   )
   public void method3203(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3231((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1560002200"
   )
   public void method3204(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2196[var2]];
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
      signature = "(I)V",
      garbageValue = "685635119"
   )
   void method3205() {
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
         field2193.remove(var1);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1265034251"
   )
   public Model method3206(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2187 != -1) {
         return class15.getNpcDefinition(this.field2187).method3739(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(null != var1 && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
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

         Model var16 = (Model)field2193.get(var5);
         if(null == var16) {
            boolean var9 = false;

            int var11;
            for(int var17 = 0; var17 < 12; ++var17) {
               var11 = var7[var17];
               if(var11 >= 256 && var11 < 512 && !RSCanvas.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class196.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2189) {
                  var16 = (Model)field2193.get(this.field2189);
               }

               if(var16 == null) {
                  return null;
               }
            }

            if(null == var16) {
               ModelData[] var10 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = RSCanvas.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var10[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class196.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var10[var11++] = var14;
                     }
                  }
               }

               ModelData var15 = new ModelData(var10, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2191[var13].length) {
                     var15.method1509(field2190[var13], field2191[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < GroundObject.field1321[var13].length) {
                     var15.method1509(VertexNormal.field1446[var13], GroundObject.field1321[var13][this.bodyPartColours[var13]]);
                  }
               }

               var16 = var15.method1524(64, 850, -30, -50, -30);
               field2193.put(var16, var5);
               this.field2189 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var16;
         } else {
            Model var18;
            if(null != var1 && var3 != null) {
               var18 = var1.method3792(var16, var2, var3, var4);
            } else if(null != var1) {
               var18 = var1.method3789(var16, var2);
            } else {
               var18 = var3.method3789(var16, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "24734"
   )
   public int method3208() {
      return this.field2187 == -1?(this.equipmentIds[11] << 5) + (this.equipmentIds[0] << 15) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[8] << 10) + this.equipmentIds[1]:305419896 + class15.getNpcDefinition(this.field2187).id;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-808087871"
   )
   ModelData method3209() {
      if(this.field2187 != -1) {
         return class15.getNpcDefinition(this.field2187).method3740();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !RSCanvas.getKitDefinition(var3 - 256).method3554()) {
               var1 = true;
            }

            if(var3 >= 512 && !class196.getItemDefinition(var3 - 512).method3697(this.isFemale)) {
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
                  var6 = RSCanvas.getKitDefinition(var5 - 256).method3555();
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class196.getItemDefinition(var5 - 512).method3690(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2191[var5].length) {
                  var4.method1509(field2190[var5], field2191[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < GroundObject.field1321[var5].length) {
                  var4.method1509(VertexNormal.field1446[var5], GroundObject.field1321[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1038668266"
   )
   public void method3228(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2196[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2831 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2831) {
                     var3 = 0;
                  }
               }

               var4 = RSCanvas.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var1 + (this.isFemale?7:0) != var4.bodyPartId);

            this.equipmentIds[field2196[var1]] = 256 + var3;
            this.method3205();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "119"
   )
   public void method3231(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2831; ++var6) {
               KitDefinition var7 = RSCanvas.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2196[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2187 = var4;
      this.method3205();
   }
}
