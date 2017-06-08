import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("z")
   public static short[][] field2621;
   @ObfuscatedName("p")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("i")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("n")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 1238286972480753659L
   )
   long field2626;
   @ObfuscatedName("c")
   public static short[] field2627;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -130100147855709543L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("e")
   static final int[] field2629;
   @ObfuscatedName("o")
   static NodeCache field2630;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 457257085
   )
   public int field2631;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "104"
   )
   ModelData method3972() {
      if(this.field2631 != -1) {
         return class217.getNpcDefinition(this.field2631).method4675();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !XClanMember.getKitDefinition(var3 - 256).method4398()) {
               var1 = true;
            }

            if(var3 >= 512 && !ItemComposition.getItemDefinition(var3 - 512).method4606(this.isFemale)) {
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
                  var6 = XClanMember.getKitDefinition(var5 - 256).method4401();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = ItemComposition.getItemDefinition(var5 - 512).method4610(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2621[var5].length) {
                  var4.method2490(field2627[var5], field2621[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class266.field3671[var5].length) {
                  var4.method2490(class211.field2611[var5], class266.field3671[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1639641441"
   )
   public void method3973(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2629[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3353 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3353) {
                     var3 = 0;
                  }
               }

               var4 = XClanMember.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2629[var1]] = var3 + 256;
            this.method3977();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "124"
   )
   public void method3975(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3991((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1488265674"
   )
   public void method3976(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2629[var2]];
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
      signature = "(S)V",
      garbageValue = "256"
   )
   void method3977() {
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
         field2630.remove(var1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1944899848"
   )
   public Model method3978(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2631 != -1) {
         return class217.getNpcDefinition(this.field2631).method4665(var1, var2, var3, var4);
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

         Model var15 = (Model)field2630.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !XClanMember.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !ItemComposition.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2626) {
                  var15 = (Model)field2630.get(this.field2626);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var18 = 0; var18 < 12; ++var18) {
                  var13 = var7[var18];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = XClanMember.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = ItemComposition.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2621[var13].length) {
                     var12.method2490(field2627[var13], field2621[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class266.field3671[var13].length) {
                     var12.method2490(class211.field2611[var13], class266.field3671[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var12.method2437(64, 850, -30, -50, -30);
               field2630.put(var15, var5);
               this.field2626 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4721(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4718(var15, var2);
            } else {
               var17 = var3.method4718(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1381952753"
   )
   public int method3980() {
      return this.field2631 == -1?this.equipmentIds[1] + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[8] << 10) + (this.equipmentIds[11] << 5):class217.getNpcDefinition(this.field2631).id + 305419896;
   }

   static {
      field2629 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2630 = new NodeCache(260);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "76"
   )
   public void method3986(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2621[var1].length - 1;
            }
         } while(!class177.method3381(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= field2621[var1].length) {
               var3 = 0;
            }
         } while(!class177.method3381(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3977();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "1475500012"
   )
   public void method3991(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3353; ++var6) {
               KitDefinition var7 = XClanMember.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && (var3?7:0) + var5 == var7.bodyPartId) {
                  var1[field2629[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2631 = var4;
      this.method3977();
   }
}
