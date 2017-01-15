import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 374791507
   )
   public int field2151;
   @ObfuscatedName("i")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 6452289501738991719L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 5418964381536270009L
   )
   long field2156;
   @ObfuscatedName("u")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("t")
   static final int[] field2158 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("m")
   static NodeCache field2159 = new NodeCache(260);
   @ObfuscatedName("x")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("g")
   public static short[] field2161;
   @ObfuscatedName("ga")
   static Widget field2164;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "59154497"
   )
   public void method3119(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class155.field2093; ++var6) {
               KitDefinition var7 = getKitDefinition(var6);
               if(var7 != null && !var7.field2807 && var5 + (var3?7:0) == var7.field2803) {
                  var1[field2158[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2151 = var4;
      this.method3124();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1888004036"
   )
   public void method3120(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2158[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               do {
                  do {
                     if(!var2) {
                        --var3;
                        if(var3 < 0) {
                           var3 = class155.field2093 - 1;
                        }
                     } else {
                        ++var3;
                        if(var3 >= class155.field2093) {
                           var3 = 0;
                        }
                     }

                     var4 = getKitDefinition(var3);
                  } while(null == var4);
               } while(var4.field2807);
            } while(var4.field2803 != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2158[var1]] = var3 + 256;
            this.method3124();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-762761239"
   )
   public void method3121(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class227.field3229[var1].length - 1;
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
            if(var3 >= class227.field3229[var1].length) {
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
      this.method3124();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1551077998"
   )
   public void method3123(Buffer var1) {
      var1.method2760(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2158[var2]];
         if(var3 == 0) {
            var1.method2760(-1);
         } else {
            var1.method2760(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2760(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   void method3124() {
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
         field2159.remove(var1);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "975675569"
   )
   public int method3125() {
      return this.field2151 == -1?(this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.equipmentIds[0] << 15) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + this.equipmentIds[1]:305419896 + Actor.getNpcDefinition(this.field2151).id;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "673352773"
   )
   ModelData method3126() {
      if(this.field2151 != -1) {
         return Actor.getNpcDefinition(this.field2151).method3704();
      } else {
         boolean var1 = false;

         int var2;
         for(int var3 = 0; var3 < 12; ++var3) {
            var2 = this.equipmentIds[var3];
            if(var2 >= 256 && var2 < 512 && !getKitDefinition(var2 - 256).method3485()) {
               var1 = true;
            }

            if(var2 >= 512 && !class88.getItemDefinition(var2 - 512).method3644(this.isFemale)) {
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
                  var6 = getKitDefinition(var4 - 256).method3486();
                  if(null != var6) {
                     var7[var2++] = var6;
                  }
               }

               if(var4 >= 512) {
                  var6 = class88.getItemDefinition(var4 - 512).method3690(this.isFemale);
                  if(var6 != null) {
                     var7[var2++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var2);

            for(var4 = 0; var4 < 5; ++var4) {
               if(this.bodyPartColours[var4] < class227.field3229[var4].length) {
                  var8.method1427(class156.field2098[var4], class227.field3229[var4][this.bodyPartColours[var4]]);
               }

               if(this.bodyPartColours[var4] < CombatInfo1.field665[var4].length) {
                  var8.method1427(field2161[var4], CombatInfo1.field665[var4][this.bodyPartColours[var4]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1755595187"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2799.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2800.method3272(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3481(new Buffer(var2));
         }

         KitDefinition.field2799.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "14"
   )
   public Model method3152(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2151 != -1) {
         return Actor.getNpcDefinition(this.field2151).method3701(var1, var2, var3, var4);
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

         Model var15 = (Model)field2159.get(var5);
         if(null == var15) {
            boolean var9 = false;

            int var10;
            for(int var11 = 0; var11 < 12; ++var11) {
               var10 = var7[var11];
               if(var10 >= 256 && var10 < 512 && !getKitDefinition(var10 - 256).ready()) {
                  var9 = true;
               }

               if(var10 >= 512 && !class88.getItemDefinition(var10 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2156 != -1L) {
                  var15 = (Model)field2159.get(this.field2156);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(null == var15) {
               ModelData[] var17 = new ModelData[12];
               var10 = 0;

               int var12;
               for(int var13 = 0; var13 < 12; ++var13) {
                  var12 = var7[var13];
                  ModelData var14;
                  if(var12 >= 256 && var12 < 512) {
                     var14 = getKitDefinition(var12 - 256).getModelData();
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }

                  if(var12 >= 512) {
                     var14 = class88.getItemDefinition(var12 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var10);

               for(var12 = 0; var12 < 5; ++var12) {
                  if(this.bodyPartColours[var12] < class227.field3229[var12].length) {
                     var18.method1427(class156.field2098[var12], class227.field3229[var12][this.bodyPartColours[var12]]);
                  }

                  if(this.bodyPartColours[var12] < CombatInfo1.field665[var12].length) {
                     var18.method1427(field2161[var12], CombatInfo1.field665[var12][this.bodyPartColours[var12]]);
                  }
               }

               var15 = var18.method1486(64, 850, -30, -50, -30);
               field2159.put(var15, var5);
               this.field2156 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var16;
            if(null != var1 && null != var3) {
               var16 = var1.method3755(var15, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method3764(var15, var2);
            } else {
               var16 = var3.method3764(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-297733556"
   )
   public void method3155(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3119((int[])null, this.bodyPartColours, var1, -1);
      }

   }
}
