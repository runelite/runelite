import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -5418384415936130295L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("h")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1840714693
   )
   public int field2971;
   @ObfuscatedName("i")
   @Export("bodyParts")
   int[] bodyParts;
   @ObfuscatedName("e")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 1364456254774596847L
   )
   long field2974;
   @ObfuscatedName("d")
   public static short[] field2975;
   @ObfuscatedName("m")
   public static short[] field2976;
   @ObfuscatedName("j")
   public static short[][] field2977;
   @ObfuscatedName("y")
   static final int[] field2978 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("s")
   static NodeCache field2979 = new NodeCache(260);

   @ObfuscatedName("i")
   public static final void method3511(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            VertexNormal.method2241(var0 - 1L);
            VertexNormal.method2241(1L);
         } else {
            VertexNormal.method2241(var0);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "845677654"
   )
   public void method3512(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class169.field2712; ++var6) {
               KitDefinition var7 = class1.getKitDefinition(var6);
               if(var7 != null && !var7.field1060 && (var3?7:0) + var5 == var7.field1048) {
                  var1[field2978[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2971 = var4;
      this.method3517();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-292202641"
   )
   public void method3514(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = Friend.field272[var1].length - 1;
            }
         } while(!ChatLineBuffer.method651(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= Friend.field272[var1].length) {
               var3 = 0;
            }
         } while(!ChatLineBuffer.method651(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3517();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-9680081"
   )
   public void method3515(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3512((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1399511546"
   )
   public int method3516() {
      return this.field2971 == -1?(this.bodyParts[11] << 5) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.bodyParts[0] << 15) + (this.bodyParts[8] << 10) + this.bodyParts[1]:305419896 + Friend.getNpcDefinition(this.field2971).id;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-161166554"
   )
   void method3517() {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1432679905"
   )
   public Model method3518(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2971 != -1) {
         return Friend.getNpcDefinition(this.field2971).method814(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(var1 != null && (var1.field1022 >= 0 || var1.field1020 >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.bodyParts[var15];
            }

            if(var1.field1022 >= 0) {
               var5 += (long)(var1.field1022 - this.bodyParts[5] << 40);
               var7[5] = var1.field1022;
            }

            if(var1.field1020 >= 0) {
               var5 += (long)(var1.field1020 - this.bodyParts[3] << 48);
               var7[3] = var1.field1020;
            }
         }

         Model var8 = (Model)field2979.get(var5);
         if(var8 == null) {
            boolean var16 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class1.getKitDefinition(var11 - 256).ready()) {
                  var16 = true;
               }

               if(var11 >= 512 && !class92.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(this.field2974 != -1L) {
                  var8 = (Model)field2979.get(this.field2974);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(null == var8) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var18 = 0; var18 < 12; ++var18) {
                  var13 = var7[var18];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class1.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class92.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < Friend.field272[var13].length) {
                     var12.method2315(field2975[var13], Friend.field272[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2977[var13].length) {
                     var12.method2315(field2976[var13], field2977[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var12.method2265(64, 850, -30, -50, -30);
               field2979.put(var8, var5);
               this.field2974 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var8;
         } else {
            Model var9;
            if(var1 != null && var3 != null) {
               var9 = var1.method921(var8, var2, var3, var4);
            } else if(null != var1) {
               var9 = var1.method900(var8, var2);
            } else {
               var9 = var3.method900(var8, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1852726456"
   )
   ModelData method3519() {
      if(this.field2971 != -1) {
         return Friend.getNpcDefinition(this.field2971).method808();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.bodyParts[var2];
            if(var3 >= 256 && var3 < 512 && !class1.getKitDefinition(var3 - 256).method968()) {
               var1 = true;
            }

            if(var3 >= 512 && !class92.getItemDefinition(var3 - 512).method1145(this.isFemale)) {
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
                  var6 = class1.getKitDefinition(var5 - 256).method953();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class92.getItemDefinition(var5 - 512).method1135(this.isFemale);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < Friend.field272[var5].length) {
                  var8.method2315(field2975[var5], Friend.field272[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2977[var5].length) {
                  var8.method2315(field2976[var5], field2977[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1696860481"
   )
   public void method3525(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2978[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class169.field2712 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class169.field2712) {
                     var3 = 0;
                  }
               }

               var4 = class1.getKitDefinition(var3);
            } while(null == var4 || var4.field1060 || (this.isFemale?7:0) + var1 != var4.field1048);

            this.bodyParts[field2978[var1]] = var3 + 256;
            this.method3517();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1454290515"
   )
   public void method3532(Buffer var1) {
      var1.method2529(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2978[var2]];
         if(var3 == 0) {
            var1.method2529(-1);
         } else {
            var1.method2529(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2529(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "119"
   )
   static final void method3540(int var0, int var1, int var2, int var3) {
      if(Client.field413 == 1) {
         class24.field639[Client.field412 / 100].method1810(Client.field499 - 8, Client.field411 - 8);
      }

      if(Client.field413 == 2) {
         class24.field639[Client.field412 / 100 + 4].method1810(Client.field499 - 8, Client.field411 - 8);
      }

      Client.field442 = 0;
      int var4 = (class138.localPlayer.x >> 7) + class193.baseX;
      int var5 = DecorativeObject.baseY + (class138.localPlayer.y >> 7);
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field442 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field442 = 1;
      }

      if(Client.field442 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field442 = 0;
      }

   }
}
