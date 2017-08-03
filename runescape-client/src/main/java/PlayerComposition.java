import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("g")
   static final int[] field2603;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field2604;
   @ObfuscatedName("i")
   public static short[] field2602;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1630244429
   )
   static int field2605;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1808631789
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("q")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("x")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -8005268178549988111L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("d")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -9137743904044778483L
   )
   long field2601;

   static {
      field2603 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2604 = new NodeCache(260);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "205247549"
   )
   public void method3957(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3331; ++var6) {
               KitDefinition var7 = class164.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && (var3?7:0) + var5 == var7.bodyPartId) {
                  var1[field2603[var5]] = var6 + 256;
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
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
      if(var1 != 0L && var1 != this.hash) {
         field2604.remove(var1);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljj;ILjj;II)Lev;",
      garbageValue = "-2109070411"
   )
   public Model method3963(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class60.getNpcDefinition(this.transformedNpcId).method4627(var1, var2, var3, var4);
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

         Model var15 = (Model)field2604.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class164.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !Friend.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2601) {
                  var15 = (Model)field2604.get(this.field2601);
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
                     var14 = class164.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = Friend.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < SceneTilePaint.colorsToReplace[var13].length) {
                     var18.recolor(NPC.colorsToFind[var13], SceneTilePaint.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class5.field33[var13].length) {
                     var18.recolor(field2602[var13], class5.field33[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2604.put(var15, var5);
               this.field2601 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4685(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4682(var15, var2);
            } else {
               var17 = var3.method4682(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ldk;",
      garbageValue = "1225958301"
   )
   ModelData method3964() {
      if(this.transformedNpcId != -1) {
         return class60.getNpcDefinition(this.transformedNpcId).method4620();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class164.getKitDefinition(var3 - 256).method4344()) {
               var1 = true;
            }

            if(var3 >= 512 && !Friend.getItemDefinition(var3 - 512).method4549(this.isFemale)) {
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
                  var6 = class164.getKitDefinition(var5 - 256).method4345();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = Friend.getItemDefinition(var5 - 512).method4550(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < SceneTilePaint.colorsToReplace[var5].length) {
                  var8.recolor(NPC.colorsToFind[var5], SceneTilePaint.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class5.field33[var5].length) {
                  var8.recolor(field2602[var5], class5.field33[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "11"
   )
   public int method3968() {
      return this.transformedNpcId == -1?(this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + this.equipmentIds[1] + (this.bodyPartColours[0] << 25):305419896 + class60.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1709563376"
   )
   public void method3958(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2603[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3331 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3331) {
                     var3 = 0;
                  }
               }

               var4 = class164.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || (this.isFemale?7:0) + var1 != var4.bodyPartId);

            this.equipmentIds[field2603[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "201175524"
   )
   public void method3959(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = SceneTilePaint.colorsToReplace[var1].length - 1;
            }
         } while(!method3988(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= SceneTilePaint.colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!method3988(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-960227213"
   )
   public void method3960(boolean var1) {
      if(this.isFemale != var1) {
         this.method3957((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "-88"
   )
   public void method3961(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2603[var2]];
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1777337186"
   )
   static boolean method3988(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
