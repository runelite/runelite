import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("f")
   @Export("bodyParts")
   int[] bodyParts;
   @ObfuscatedName("e")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("n")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 2786598385232168719L
   )
   long field2957;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -8027583909669137801L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("w")
   public static short[][] field2960;
   @ObfuscatedName("l")
   static final int[] field2961 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("h")
   public static NodeCache field2962 = new NodeCache(260);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 362616763
   )
   public int field2964;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "596088588"
   )
   public void method3541(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2961[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field1032 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field1032) {
                     var3 = 0;
                  }
               }

               var4 = ItemComposition.getKitDefinition(var3);
            } while(var4 == null || var4.field1031 || var4.field1033 != var1 + (this.isFemale?7:0));

            this.bodyParts[field2961[var1]] = var3 + 256;
            this.method3561();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-735055874"
   )
   public void method3542(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class134.field2120[var1].length - 1;
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
            if(var3 >= class134.field2120[var1].length) {
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
      this.method3561();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-59473801"
   )
   public void method3543(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3571((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "120"
   )
   public void method3544(Buffer var1) {
      var1.method2518(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2961[var2]];
         if(var3 == 0) {
            var1.method2518(-1);
         } else {
            var1.method2518(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2518(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1855559901"
   )
   public Model method3545(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2964 != -1) {
         return World.getNpcDefinition(this.field2964).method796(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(var1 != null && (var1.field1000 >= 0 || var1.field1001 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.bodyParts[var8];
            }

            if(var1.field1000 >= 0) {
               var5 += (long)(var1.field1000 - this.bodyParts[5] << 40);
               var7[5] = var1.field1000;
            }

            if(var1.field1001 >= 0) {
               var5 += (long)(var1.field1001 - this.bodyParts[3] << 48);
               var7[3] = var1.field1001;
            }
         }

         Model var15 = (Model)field2962.get(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !ItemComposition.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class45.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2957 != -1L) {
                  var15 = (Model)field2962.get(this.field2957);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(null == var15) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var18 = 0; var18 < 12; ++var18) {
                  var13 = var7[var18];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = ItemComposition.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class45.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class134.field2120[var13].length) {
                     var12.method2248(class169.field2701[var13], class134.field2120[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2960[var13].length) {
                     var12.method2248(FrameMap.field1824[var13], field2960[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var12.method2256(64, 850, -30, -50, -30);
               field2962.put(var15, var5);
               this.field2957 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var15;
         } else {
            Model var16;
            if(null != var1 && null != var3) {
               var16 = var1.method885(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method882(var15, var2);
            } else {
               var16 = var3.method882(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)LModelData;",
      garbageValue = "4460"
   )
   ModelData method3546() {
      if(this.field2964 != -1) {
         return World.getNpcDefinition(this.field2964).method810();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.bodyParts[var7];
            if(var3 >= 256 && var3 < 512 && !ItemComposition.getKitDefinition(var3 - 256).method940()) {
               var1 = true;
            }

            if(var3 >= 512 && !class45.getItemDefinition(var3 - 512).method1114(this.isFemale)) {
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
                  var6 = ItemComposition.getKitDefinition(var5 - 256).method949();
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class45.getItemDefinition(var5 - 512).method1115(this.isFemale);
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class134.field2120[var5].length) {
                  var4.method2248(class169.field2701[var5], class134.field2120[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2960[var5].length) {
                  var4.method2248(FrameMap.field1824[var5], field2960[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1845614834"
   )
   public int method3547() {
      return this.field2964 == -1?this.bodyParts[1] + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.bodyParts[0] << 15) + (this.bodyParts[8] << 10) + (this.bodyParts[11] << 5):305419896 + World.getNpcDefinition(this.field2964).id;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-652779178"
   )
   void method3561() {
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
      if(var1 != 0L && this.hash != var1) {
         field2962.remove(var1);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([I[IZIS)V",
      garbageValue = "-30978"
   )
   public void method3571(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field1032; ++var6) {
               KitDefinition var7 = ItemComposition.getKitDefinition(var6);
               if(var7 != null && !var7.field1031 && var7.field1033 == var5 + (var3?7:0)) {
                  var1[field2961[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2964 = var4;
      this.method3561();
   }
}
