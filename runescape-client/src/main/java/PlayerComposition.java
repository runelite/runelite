import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("w")
   public static NodeCache field2958 = new NodeCache(260);
   @ObfuscatedName("z")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("t")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 5900441896781681831L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 647299657
   )
   public int field2963;
   @ObfuscatedName("f")
   public static short[][] field2964;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4555842736614433455L
   )
   long field2965;
   @ObfuscatedName("r")
   static final int[] field2966 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("s")
   @Export("bodyParts")
   int[] bodyParts;
   @ObfuscatedName("k")
   public static short[] field2968;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-363782390"
   )
   public void method3474(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field1005; ++var6) {
               KitDefinition var7 = class23.getKitDefinition(var6);
               if(var7 != null && !var7.field1014 && var7.field1008 == (var3?7:0) + var5) {
                  var1[field2966[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2963 = var4;
      this.method3480();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-783531913"
   )
   public void method3477(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2964[var1].length - 1;
            }
         } while(!class79.method1679(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= field2964[var1].length) {
               var3 = 0;
            }
         } while(!class79.method1679(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3480();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "17"
   )
   public void method3478(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3474((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-55014525"
   )
   public void method3479(Buffer var1) {
      var1.method2467(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2966[var2]];
         if(var3 == 0) {
            var1.method2467(-1);
         } else {
            var1.method2467(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2467(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1503613307"
   )
   void method3480() {
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
         field2958.remove(var1);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "290152894"
   )
   ModelData method3482() {
      if(this.field2963 != -1) {
         return class127.getNpcDefinition(this.field2963).method784();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.bodyParts[var7];
            if(var3 >= 256 && var3 < 512 && !class23.getKitDefinition(var3 - 256).method924()) {
               var1 = true;
            }

            if(var3 >= 512 && !class174.getItemDefinition(var3 - 512).method1089(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var8 = 0; var8 < 12; ++var8) {
               var5 = this.bodyParts[var8];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class23.getKitDefinition(var5 - 256).method930();
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class174.getItemDefinition(var5 - 512).method1085(this.isFemale);
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2964[var5].length) {
                  var4.method2197(class137.field2121[var5], field2964[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class112.field1942[var5].length) {
                  var4.method2197(field2968[var5], class112.field1942[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1002471125"
   )
   public void method3491(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2966[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field1005 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field1005) {
                     var3 = 0;
                  }
               }

               var4 = class23.getKitDefinition(var3);
            } while(var4 == null || var4.field1014 || var4.field1008 != var1 + (this.isFemale?7:0));

            this.bodyParts[field2966[var1]] = 256 + var3;
            this.method3480();
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3495() {
      return this.field2963 == -1?(this.bodyParts[11] << 5) + (this.bodyParts[0] << 15) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.bodyParts[8] << 10) + this.bodyParts[1]:305419896 + class127.getNpcDefinition(this.field2963).id;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "787711651"
   )
   public Model method3497(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2963 != -1) {
         return class127.getNpcDefinition(this.field2963).method788(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(var1 != null && (var1.field977 >= 0 || var1.field978 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.bodyParts[var8];
            }

            if(var1.field977 >= 0) {
               var5 += (long)(var1.field977 - this.bodyParts[5] << 40);
               var7[5] = var1.field977;
            }

            if(var1.field978 >= 0) {
               var5 += (long)(var1.field978 - this.bodyParts[3] << 48);
               var7[3] = var1.field978;
            }
         }

         Model var15 = (Model)field2958.get(var5);
         if(null == var15) {
            boolean var16 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class23.getKitDefinition(var11 - 256).ready()) {
                  var16 = true;
               }

               if(var11 >= 512 && !class174.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(this.field2965 != -1L) {
                  var15 = (Model)field2958.get(this.field2965);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(null == var15) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class23.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class174.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2964[var13].length) {
                     var18.method2197(class137.field2121[var13], field2964[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class112.field1942[var13].length) {
                     var18.method2197(field2968[var13], class112.field1942[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.method2203(64, 850, -30, -50, -30);
               field2958.put(var15, var5);
               this.field2965 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var15;
         } else {
            Model var9;
            if(null != var1 && var3 != null) {
               var9 = var1.method884(var15, var2, var3, var4);
            } else if(null != var1) {
               var9 = var1.method908(var15, var2);
            } else {
               var9 = var3.method908(var15, var4);
            }

            return var9;
         }
      }
   }
}
