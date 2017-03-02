import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("b")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("l")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1132830809
   )
   public int field2163;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 3219411268119319439L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -5152531739609825563L
   )
   long field2165;
   @ObfuscatedName("a")
   public static short[] field2166;
   @ObfuscatedName("r")
   public static short[][] field2167;
   @ObfuscatedName("i")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("z")
   static NodeCache field2169 = new NodeCache(260);
   @ObfuscatedName("x")
   static final int[] field2170 = new int[]{8, 11, 4, 6, 9, 7, 10};

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-2134660167"
   )
   public void method3223(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2820; ++var6) {
               KitDefinition var7 = GroundObject.getKitDefinition(var6);
               if(var7 != null && !var7.field2829 && var5 + (var3?7:0) == var7.field2822) {
                  var1[field2170[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2163 = var4;
      this.method3238();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "0"
   )
   public void method3225(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = Friend.field151[var1].length - 1;
            }
         } while(!class94.method1976(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= Friend.field151[var1].length) {
               var3 = 0;
            }
         } while(!class94.method1976(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3238();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1864515640"
   )
   public void method3226(boolean var1) {
      if(this.isFemale != var1) {
         this.method3223((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2032180326"
   )
   public void method3227(Buffer var1) {
      var1.method3010(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2170[var2]];
         if(var3 == 0) {
            var1.method3010(-1);
         } else {
            var1.method3010(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method3010(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "0"
   )
   ModelData method3230() {
      if(this.field2163 != -1) {
         return ChatLineBuffer.getNpcDefinition(this.field2163).method3813();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !GroundObject.getKitDefinition(var3 - 256).method3574()) {
               var1 = true;
            }

            if(var3 >= 512 && !class168.getItemDefinition(var3 - 512).method3735(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var8 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = GroundObject.getKitDefinition(var5 - 256).method3575();
                  if(null != var6) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class168.getItemDefinition(var5 - 512).method3773(this.isFemale);
                  if(null != var6) {
                     var8[var3++] = var6;
                  }
               }
            }

            ModelData var7 = new ModelData(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < Friend.field151[var5].length) {
                  var7.method1579(SecondaryBufferProvider.field3212[var5], Friend.field151[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2167[var5].length) {
                  var7.method1579(field2166[var5], field2167[var5][this.bodyPartColours[var5]]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1111052655"
   )
   public int method3231() {
      return this.field2163 == -1?(this.equipmentIds[8] << 10) + (this.equipmentIds[0] << 15) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[11] << 5) + this.equipmentIds[1]:305419896 + ChatLineBuffer.getNpcDefinition(this.field2163).id;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-369020873"
   )
   public void method3235(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2170[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2820 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2820) {
                     var3 = 0;
                  }
               }

               var4 = GroundObject.getKitDefinition(var3);
            } while(null == var4 || var4.field2829 || (this.isFemale?7:0) + var1 != var4.field2822);

            this.equipmentIds[field2170[var1]] = 256 + var3;
            this.method3238();
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "-84"
   )
   public Model method3236(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2163 != -1) {
         return ChatLineBuffer.getNpcDefinition(this.field2163).method3805(var1, var2, var3, var4);
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

         Model var16 = (Model)field2169.get(var5);
         if(var16 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !GroundObject.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class168.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2165) {
                  var16 = (Model)field2169.get(this.field2165);
               }

               if(null == var16) {
                  return null;
               }
            }

            if(var16 == null) {
               ModelData[] var15 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = GroundObject.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var15[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class168.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var15[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var15, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < Friend.field151[var13].length) {
                     var18.method1579(SecondaryBufferProvider.field3212[var13], Friend.field151[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2167[var13].length) {
                     var18.method1579(field2166[var13], field2167[var13][this.bodyPartColours[var13]]);
                  }
               }

               var16 = var18.method1544(64, 850, -30, -50, -30);
               field2169.put(var16, var5);
               this.field2165 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var16;
         } else {
            Model var17;
            if(var1 != null && null != var3) {
               var17 = var1.method3881(var16, var2, var3, var4);
            } else if(null != var1) {
               var17 = var1.method3858(var16, var2);
            } else {
               var17 = var3.method3858(var16, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-550523092"
   )
   void method3238() {
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
         field2169.remove(var1);
      }

   }
}
