import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("k")
   public static short[] field2969;
   @ObfuscatedName("as")
   static int[] field2970;
   @ObfuscatedName("r")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 218582835
   )
   public int field2972;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6499637505182612365L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("g")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 1454066421934414707L
   )
   long field2975;
   @ObfuscatedName("n")
   public static short[] field2976;
   @ObfuscatedName("m")
   static final int[] field2977 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("q")
   static NodeCache field2978 = new NodeCache(260);
   @ObfuscatedName("l")
   @Export("bodyParts")
   int[] bodyParts;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-99"
   )
   public void method3634(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field1054; ++var6) {
               KitDefinition var7 = FrameMap.getKitDefinition(var6);
               if(null != var7 && !var7.field1053 && var7.field1056 == (var3?7:0) + var5) {
                  var1[field2977[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2972 = var4;
      this.method3639();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1083371902"
   )
   public void method3635(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2977[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               do {
                  do {
                     if(!var2) {
                        --var3;
                        if(var3 < 0) {
                           var3 = KitDefinition.field1054 - 1;
                        }
                     } else {
                        ++var3;
                        if(var3 >= KitDefinition.field1054) {
                           var3 = 0;
                        }
                     }

                     var4 = FrameMap.getKitDefinition(var3);
                  } while(null == var4);
               } while(var4.field1053);
            } while((this.isFemale?7:0) + var1 != var4.field1056);

            this.bodyParts[field2977[var1]] = var3 + 256;
            this.method3639();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1427355202"
   )
   public void method3636(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class175.field2794[var1].length - 1;
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
            if(var3 >= class175.field2794[var1].length) {
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
      this.method3639();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1533187066"
   )
   public void method3637(boolean var1) {
      if(this.isFemale != var1) {
         this.method3634((int[])null, this.bodyPartColours, var1, -1);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "204185956"
   )
   public void method3638(Buffer var1) {
      var1.method2783(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2977[var2]];
         if(var3 == 0) {
            var1.method2783(-1);
         } else {
            var1.method2783(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2783(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   void method3639() {
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
      if(var1 != 0L && var1 != this.hash) {
         field2978.remove(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "2041125131"
   )
   ModelData method3641() {
      if(this.field2972 != -1) {
         return class16.getNpcDefinition(this.field2972).method819();
      } else {
         boolean var1 = false;

         int var2;
         for(int var3 = 0; var3 < 12; ++var3) {
            var2 = this.bodyParts[var3];
            if(var2 >= 256 && var2 < 512 && !FrameMap.getKitDefinition(var2 - 256).method991()) {
               var1 = true;
            }

            if(var2 >= 512 && !class1.getItemDefinition(var2 - 512).method1232(this.isFemale)) {
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
               var4 = this.bodyParts[var5];
               ModelData var6;
               if(var4 >= 256 && var4 < 512) {
                  var6 = FrameMap.getKitDefinition(var4 - 256).method974();
                  if(null != var6) {
                     var7[var2++] = var6;
                  }
               }

               if(var4 >= 512) {
                  var6 = class1.getItemDefinition(var4 - 512).method1183(this.isFemale);
                  if(var6 != null) {
                     var7[var2++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var2);

            for(var4 = 0; var4 < 5; ++var4) {
               if(this.bodyPartColours[var4] < class175.field2794[var4].length) {
                  var8.method2305(field2969[var4], class175.field2794[var4][this.bodyPartColours[var4]]);
               }

               if(this.bodyPartColours[var4] < FrameMap.field1840[var4].length) {
                  var8.method2305(field2976[var4], FrameMap.field1840[var4][this.bodyPartColours[var4]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "760818026"
   )
   public int method3642() {
      return this.field2972 == -1?this.bodyParts[1] + (this.bodyParts[11] << 5) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.bodyParts[0] << 15) + (this.bodyParts[8] << 10):305419896 + class16.getNpcDefinition(this.field2972).id;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-2059410991"
   )
   public Model method3667(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2972 != -1) {
         return class16.getNpcDefinition(this.field2972).method818(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(null != var1 && (var1.field1024 >= 0 || var1.field1025 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.bodyParts[var8];
            }

            if(var1.field1024 >= 0) {
               var5 += (long)(var1.field1024 - this.bodyParts[5] << 40);
               var7[5] = var1.field1024;
            }

            if(var1.field1025 >= 0) {
               var5 += (long)(var1.field1025 - this.bodyParts[3] << 48);
               var7[3] = var1.field1025;
            }
         }

         Model var15 = (Model)field2978.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var10;
            for(int var11 = 0; var11 < 12; ++var11) {
               var10 = var7[var11];
               if(var10 >= 256 && var10 < 512 && !FrameMap.getKitDefinition(var10 - 256).ready()) {
                  var9 = true;
               }

               if(var10 >= 512 && !class1.getItemDefinition(var10 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2975 != -1L) {
                  var15 = (Model)field2978.get(this.field2975);
               }

               if(null == var15) {
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
                     var14 = FrameMap.getKitDefinition(var12 - 256).getModelData();
                     if(null != var14) {
                        var17[var10++] = var14;
                     }
                  }

                  if(var12 >= 512) {
                     var14 = class1.getItemDefinition(var12 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var10);

               for(var12 = 0; var12 < 5; ++var12) {
                  if(this.bodyPartColours[var12] < class175.field2794[var12].length) {
                     var18.method2305(field2969[var12], class175.field2794[var12][this.bodyPartColours[var12]]);
                  }

                  if(this.bodyPartColours[var12] < FrameMap.field1840[var12].length) {
                     var18.method2305(field2976[var12], FrameMap.field1840[var12][this.bodyPartColours[var12]]);
                  }
               }

               var15 = var18.method2321(64, 850, -30, -50, -30);
               field2978.put(var15, var5);
               this.field2975 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var15;
         } else {
            Model var16;
            if(null != var1 && null != var3) {
               var16 = var1.method914(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method943(var15, var2);
            } else {
               var16 = var3.method943(var15, var4);
            }

            return var16;
         }
      }
   }
}
