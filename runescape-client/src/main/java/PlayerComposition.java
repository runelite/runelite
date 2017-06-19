import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("m")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("e")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("p")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -5657513230733480221L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 6655459924418754315L
   )
   long field2628;
   @ObfuscatedName("j")
   public static short[] field2629;
   @ObfuscatedName("f")
   public static short[] field2630;
   @ObfuscatedName("o")
   static final int[] field2631;
   @ObfuscatedName("q")
   public static NodeCache field2632;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 796886097
   )
   @Export("transformedNpcId")
   public int transformedNpcId;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1211180800"
   )
   public static void method3839() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-500845284"
   )
   public void method3840(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3359; ++var6) {
               KitDefinition var7 = class69.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && (var3?7:0) + var5 == var7.bodyPartId) {
                  var1[field2631[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.transformedNpcId = var4;
      this.method3844();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "15"
   )
   public void method3841(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class8.field249[var1].length - 1;
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
            if(var3 >= class8.field249[var1].length) {
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
      this.method3844();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2083129991"
   )
   public void method3842(boolean var1) {
      if(this.isFemale != var1) {
         this.method3840((int[])null, this.bodyPartColours, var1, -1);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1809485093"
   )
   public void method3843(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2631[var2]];
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   void method3844() {
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
         field2632.remove(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "-10"
   )
   public Model method3845(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class158.getNpcDefinition(this.transformedNpcId).method4514(var1, var2, var3, var4);
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

         Model var15 = (Model)field2632.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var10;
            for(int var11 = 0; var11 < 12; ++var11) {
               var10 = var7[var11];
               if(var10 >= 256 && var10 < 512 && !class69.getKitDefinition(var10 - 256).ready()) {
                  var9 = true;
               }

               if(var10 >= 512 && !class224.getItemDefinition(var10 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2628) {
                  var15 = (Model)field2632.get(this.field2628);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var17 = new ModelData[12];
               var10 = 0;

               int var12;
               for(int var13 = 0; var13 < 12; ++var13) {
                  var12 = var7[var13];
                  ModelData var14;
                  if(var12 >= 256 && var12 < 512) {
                     var14 = class69.getKitDefinition(var12 - 256).getModelData();
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }

                  if(var12 >= 512) {
                     var14 = class224.getItemDefinition(var12 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var10);

               for(var12 = 0; var12 < 5; ++var12) {
                  if(this.bodyPartColours[var12] < class8.field249[var12].length) {
                     var18.method2322(field2629[var12], class8.field249[var12][this.bodyPartColours[var12]]);
                  }

                  if(this.bodyPartColours[var12] < class7.field240[var12].length) {
                     var18.method2322(field2630[var12], class7.field240[var12][this.bodyPartColours[var12]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2632.put(var15, var5);
               this.field2628 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method4585(var15, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method4578(var15, var2);
            } else {
               var16 = var3.method4578(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1993869971"
   )
   ModelData method3846() {
      if(this.transformedNpcId != -1) {
         return class158.getNpcDefinition(this.transformedNpcId).method4520();
      } else {
         boolean var1 = false;

         int var2;
         for(int var3 = 0; var3 < 12; ++var3) {
            var2 = this.equipmentIds[var3];
            if(var2 >= 256 && var2 < 512 && !class69.getKitDefinition(var2 - 256).method4250()) {
               var1 = true;
            }

            if(var2 >= 512 && !class224.getItemDefinition(var2 - 512).method4448(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var2 = 0;

            int var4;
            for(int var5 = 0; var5 < 12; ++var5) {
               var4 = this.equipmentIds[var5];
               ModelData var6;
               if(var4 >= 256 && var4 < 512) {
                  var6 = class69.getKitDefinition(var4 - 256).method4251();
                  if(var6 != null) {
                     var7[var2++] = var6;
                  }
               }

               if(var4 >= 512) {
                  var6 = class224.getItemDefinition(var4 - 512).method4449(this.isFemale);
                  if(var6 != null) {
                     var7[var2++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var2);

            for(var4 = 0; var4 < 5; ++var4) {
               if(this.bodyPartColours[var4] < class8.field249[var4].length) {
                  var8.method2322(field2629[var4], class8.field249[var4][this.bodyPartColours[var4]]);
               }

               if(this.bodyPartColours[var4] < class7.field240[var4].length) {
                  var8.method2322(field2630[var4], class7.field240[var4][this.bodyPartColours[var4]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-25989246"
   )
   public void method3852(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2631[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               do {
                  do {
                     if(!var2) {
                        --var3;
                        if(var3 < 0) {
                           var3 = KitDefinition.field3359 - 1;
                        }
                     } else {
                        ++var3;
                        if(var3 >= KitDefinition.field3359) {
                           var3 = 0;
                        }
                     }

                     var4 = class69.getKitDefinition(var3);
                  } while(var4 == null);
               } while(var4.nonSelectable);
            } while(var1 + (this.isFemale?7:0) != var4.bodyPartId);

            this.equipmentIds[field2631[var1]] = var3 + 256;
            this.method3844();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "10790959"
   )
   public static void method3867(IndexDataBase var0) {
      class51.field669 = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1042926958"
   )
   public int method3868() {
      return this.transformedNpcId == -1?this.equipmentIds[1] + (this.equipmentIds[8] << 10) + (this.equipmentIds[11] << 5) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[0] << 15):class158.getNpcDefinition(this.transformedNpcId).id + 305419896;
   }

   static {
      field2631 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2632 = new NodeCache(260);
   }
}
