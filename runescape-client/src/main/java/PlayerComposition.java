import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("i")
   public static short[][] field2975;
   @ObfuscatedName("d")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -3358635228339316243L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 326192107
   )
   public int field2978;
   @ObfuscatedName("x")
   static NodeCache field2979 = new NodeCache(260);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 4350363767459557825L
   )
   long field2980;
   @ObfuscatedName("a")
   @Export("bodyParts")
   int[] bodyParts;
   @ObfuscatedName("g")
   public static short[] field2982;
   @ObfuscatedName("k")
   static final int[] field2983 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("v")
   @Export("isFemale")
   public boolean isFemale;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lclass56;",
      garbageValue = "79"
   )
   public static class56 method3517(int var0) {
      class56 var1 = (class56)class56.field1235.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1233.method3309(16, var0);
         var1 = new class56();
         if(null != var2) {
            var1.method1177(new Buffer(var2));
         }

         class56.field1235.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1380598376"
   )
   public void method3519(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2983[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field1050 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field1050) {
                     var3 = 0;
                  }
               }

               var4 = class127.getKitDefinition(var3);
            } while(var4 == null || var4.field1048 || var1 + (this.isFemale?7:0) != var4.field1057);

            this.bodyParts[field2983[var1]] = 256 + var3;
            this.method3523();
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "1607242963"
   )
   public void method3521(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field1050; ++var6) {
               KitDefinition var7 = class127.getKitDefinition(var6);
               if(null != var7 && !var7.field1048 && var7.field1057 == var5 + (var3?7:0)) {
                  var1[field2983[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2978 = var4;
      this.method3523();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "-21138"
   )
   public void method3522(Buffer var1) {
      var1.method2513(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2983[var2]];
         if(var3 == 0) {
            var1.method2513(-1);
         } else {
            var1.method2513(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2513(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1297577791"
   )
   void method3523() {
      long var1 = this.hash;
      int var3 = this.bodyParts[5];
      int var4 = this.bodyParts[9];
      this.bodyParts[5] = var4;
      this.bodyParts[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.bodyParts[var5] >= 256) {
            this.hash += (long)(this.bodyParts[var5] - 256);
         }
      }

      if(this.bodyParts[0] >= 256) {
         this.hash += (long)(this.bodyParts[0] - 256 >> 4);
      }

      if(this.bodyParts[1] >= 256) {
         this.hash += (long)(this.bodyParts[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.bodyParts[5] = var3;
      this.bodyParts[9] = var4;
      if(0L != var1 && var1 != this.hash) {
         field2979.remove(var1);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1620343504"
   )
   public Model method3524(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2978 != -1) {
         return ObjectComposition.getNpcDefinition(this.field2978).method822(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(null != var1 && (var1.field1021 >= 0 || var1.field1022 >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.bodyParts[var15];
            }

            if(var1.field1021 >= 0) {
               var5 += (long)(var1.field1021 - this.bodyParts[5] << 40);
               var7[5] = var1.field1021;
            }

            if(var1.field1022 >= 0) {
               var5 += (long)(var1.field1022 - this.bodyParts[3] << 48);
               var7[3] = var1.field1022;
            }
         }

         Model var8 = (Model)field2979.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var16 = 0; var16 < 12; ++var16) {
               var11 = var7[var16];
               if(var11 >= 256 && var11 < 512 && !class127.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !MessageNode.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2980) {
                  var8 = (Model)field2979.get(this.field2980);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var10 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var18 = 0; var18 < 12; ++var18) {
                  var13 = var7[var18];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class127.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var10[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = MessageNode.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var10[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var10, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2975[var13].length) {
                     var12.method2239(FileOnDisk.field3260[var13], field2975[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class127.field2112[var13].length) {
                     var12.method2239(field2982[var13], class127.field2112[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var12.method2247(64, 850, -30, -50, -30);
               field2979.put(var8, var5);
               this.field2980 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(var1 != null && null != var3) {
               var17 = var1.method906(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method903(var8, var2);
            } else {
               var17 = var3.method903(var8, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-2"
   )
   ModelData method3525() {
      if(this.field2978 != -1) {
         return ObjectComposition.getNpcDefinition(this.field2978).method809();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.bodyParts[var2];
            if(var3 >= 256 && var3 < 512 && !class127.getKitDefinition(var3 - 256).method970()) {
               var1 = true;
            }

            if(var3 >= 512 && !MessageNode.getItemDefinition(var3 - 512).method1175(this.isFemale)) {
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
               var5 = this.bodyParts[var8];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class127.getKitDefinition(var5 - 256).method972();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = MessageNode.getItemDefinition(var5 - 512).method1131(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2975[var5].length) {
                  var4.method2239(FileOnDisk.field3260[var5], field2975[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class127.field2112[var5].length) {
                  var4.method2239(field2982[var5], class127.field2112[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3526() {
      return this.field2978 == -1?this.bodyParts[1] + (this.bodyParts[0] << 15) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.bodyParts[8] << 10) + (this.bodyParts[11] << 5):305419896 + ObjectComposition.getNpcDefinition(this.field2978).id;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "5"
   )
   public void method3528(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2975[var1].length - 1;
            }
         } while(!GameObject.method2223(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= field2975[var1].length) {
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
      this.method3523();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1120706043"
   )
   public void method3530(boolean var1) {
      if(this.isFemale != var1) {
         this.method3521((int[])null, this.bodyPartColours, var1, -1);
      }
   }
}
