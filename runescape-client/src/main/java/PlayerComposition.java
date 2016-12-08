import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("m")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -427210661
   )
   public int field2181;
   @ObfuscatedName("o")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -2880305018867013761L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -6892167101026696601L
   )
   long field2184;
   @ObfuscatedName("u")
   public static short[] field2185;
   @ObfuscatedName("z")
   static final int[] field2186 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("y")
   public static NodeCache field2187 = new NodeCache(260);
   @ObfuscatedName("b")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 495427239
   )
   static int field2190;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "2146707755"
   )
   public void method3060(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2819; ++var6) {
               KitDefinition var7 = class114.getKitDefinition(var6);
               if(null != var7 && !var7.field2826 && var7.field2821 == var5 + (var3?7:0)) {
                  var1[field2186[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2181 = var4;
      this.method3064();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2079502466"
   )
   public int method3061() {
      return this.field2181 == -1?(this.equipmentIds[8] << 10) + (this.equipmentIds[0] << 15) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[11] << 5) + this.equipmentIds[1]:305419896 + class30.getNpcDefinition(this.field2181).id;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-750656138"
   )
   public void method3062(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3060((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "398342774"
   )
   ModelData method3063() {
      if(this.field2181 != -1) {
         return class30.getNpcDefinition(this.field2181).method3614();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class114.getKitDefinition(var3 - 256).method3405()) {
               var1 = true;
            }

            if(var3 >= 512 && !class137.getItemDefinition(var3 - 512).method3560(this.isFemale)) {
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
                  var6 = class114.getKitDefinition(var5 - 256).method3406();
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class137.getItemDefinition(var5 - 512).method3569(this.isFemale);
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }
            }

            ModelData var7 = new ModelData(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class119.field1867[var5].length) {
                  var7.method1448(class164.field2166[var5], class119.field1867[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < FrameMap.field1461[var5].length) {
                  var7.method1448(field2185[var5], FrameMap.field1461[var5][this.bodyPartColours[var5]]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   void method3064() {
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
         field2187.remove(var1);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1915421345"
   )
   public void method3065(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class119.field1867[var1].length - 1;
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
            if(var3 >= class119.field1867[var1].length) {
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
      this.method3064();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "63"
   )
   public Model method3067(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2181 != -1) {
         return class30.getNpcDefinition(this.field2181).method3619(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(null != var1 && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
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

         Model var15 = (Model)field2187.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class114.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class137.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2184) {
                  var15 = (Model)field2187.get(this.field2184);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var18 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class114.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var18[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class137.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var18[var11++] = var14;
                     }
                  }
               }

               ModelData var16 = new ModelData(var18, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class119.field1867[var13].length) {
                     var16.method1448(class164.field2166[var13], class119.field1867[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < FrameMap.field1461[var13].length) {
                     var16.method1448(field2185[var13], FrameMap.field1461[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var16.method1465(64, 850, -30, -50, -30);
               field2187.put(var15, var5);
               this.field2184 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var15;
         } else {
            Model var17;
            if(null != var1 && null != var3) {
               var17 = var1.method3676(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method3665(var15, var2);
            } else {
               var17 = var3.method3665(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2047622845"
   )
   public void method3070(Buffer var1) {
      var1.method2815(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2186[var2]];
         if(var3 == 0) {
            var1.method2815(-1);
         } else {
            var1.method2815(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2815(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "2"
   )
   public void method3071(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2186[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2819 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2819) {
                     var3 = 0;
                  }
               }

               var4 = class114.getKitDefinition(var3);
            } while(var4 == null || var4.field2826 || var4.field2821 != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2186[var1]] = 256 + var3;
            this.method3064();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "128"
   )
   public static boolean method3094() {
      ClassInfo var0 = (ClassInfo)class227.field3228.method2311();
      return var0 != null;
   }
}
