import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 4771388128559774409L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("b")
   static NodeCache field2965 = new NodeCache(260);
   @ObfuscatedName("l")
   static final int[] field2967 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("y")
   public static short[][] field2968;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -1658536306076960475L
   )
   long field2969;
   @ObfuscatedName("f")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("q")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("k")
   @Export("bodyParts")
   int[] bodyParts;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1800478553
   )
   public int field2975;
   @ObfuscatedName("ct")
   static class227 field2977;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-2104639370"
   )
   public void method3508(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class28.field670; ++var6) {
               KitDefinition var7 = ChatLineBuffer.getKitDefinition(var6);
               if(var7 != null && !var7.field1058 && var7.field1053 == (var3?7:0) + var5) {
                  var1[field2967[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2975 = var4;
      this.method3513();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1029575216"
   )
   public void method3509(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2967[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class28.field670 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class28.field670) {
                     var3 = 0;
                  }
               }

               var4 = ChatLineBuffer.getKitDefinition(var3);
            } while(null == var4 || var4.field1058 || var4.field1053 != var1 + (this.isFemale?7:0));

            this.bodyParts[field2967[var1]] = var3 + 256;
            this.method3513();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-369404832"
   )
   public void method3512(boolean var1) {
      if(this.isFemale != var1) {
         this.method3508((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1753218118"
   )
   void method3513() {
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
         field2965.remove(var1);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1992979800"
   )
   public Model method3514(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2975 != -1) {
         return class110.getNpcDefinition(this.field2975).method808(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(var1 != null && (var1.field1014 >= 0 || var1.field1015 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.bodyParts[var8];
            }

            if(var1.field1014 >= 0) {
               var5 += (long)(var1.field1014 - this.bodyParts[5] << 40);
               var7[5] = var1.field1014;
            }

            if(var1.field1015 >= 0) {
               var5 += (long)(var1.field1015 - this.bodyParts[3] << 48);
               var7[3] = var1.field1015;
            }
         }

         Model var15 = (Model)field2965.get(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !ChatLineBuffer.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class22.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2969) {
                  var15 = (Model)field2965.get(this.field2969);
               }

               if(var15 == null) {
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
                     var14 = ChatLineBuffer.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class22.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var16 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2968[var13].length) {
                     var16.method2285(class109.field1925[var13], field2968[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class4.field72[var13].length) {
                     var16.method2285(class112.field1966[var13], class4.field72[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var16.method2293(64, 850, -30, -50, -30);
               field2965.put(var15, var5);
               this.field2969 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var15;
         } else {
            Model var18;
            if(var1 != null && var3 != null) {
               var18 = var1.method917(var15, var2, var3, var4);
            } else if(var1 != null) {
               var18 = var1.method898(var15, var2);
            } else {
               var18 = var3.method898(var15, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "809576943"
   )
   ModelData method3515() {
      if(this.field2975 != -1) {
         return class110.getNpcDefinition(this.field2975).method800();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.bodyParts[var2];
            if(var3 >= 256 && var3 < 512 && !ChatLineBuffer.getKitDefinition(var3 - 256).method956()) {
               var1 = true;
            }

            if(var3 >= 512 && !class22.getItemDefinition(var3 - 512).method1124(this.isFemale)) {
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
               var5 = this.bodyParts[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = ChatLineBuffer.getKitDefinition(var5 - 256).method957();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class22.getItemDefinition(var5 - 512).method1125(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2968[var5].length) {
                  var8.method2285(class109.field1925[var5], field2968[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class4.field72[var5].length) {
                  var8.method2285(class112.field1966[var5], class4.field72[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1073636039"
   )
   public int method3516() {
      return this.field2975 == -1?(this.bodyParts[8] << 10) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.bodyParts[0] << 15) + (this.bodyParts[11] << 5) + this.bodyParts[1]:305419896 + class110.getNpcDefinition(this.field2975).id;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-711564847"
   )
   public void method3530(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2968[var1].length - 1;
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
            if(var3 >= field2968[var1].length) {
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
      this.method3513();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1943463766"
   )
   public void method3537(Buffer var1) {
      var1.method2556(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2967[var2]];
         if(var3 == 0) {
            var1.method2556(-1);
         } else {
            var1.method2556(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2556(this.bodyPartColours[var2]);
      }

   }
}
