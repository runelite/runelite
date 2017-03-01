import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("s")
   static final int[] field2168 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -271876109
   )
   public int field2171;
   @ObfuscatedName("n")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -2070339198387842111L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("j")
   public static short[] field2174;
   @ObfuscatedName("g")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("k")
   public static NodeCache field2176 = new NodeCache(260);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 8319880254668805227L
   )
   long field2177;
   @ObfuscatedName("e")
   static int[] field2178;
   @ObfuscatedName("x")
   @Export("equipmentIds")
   int[] equipmentIds;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-536270106"
   )
   public void method3235(Buffer var1) {
      var1.method2873(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2168[var2]];
         if(var3 == 0) {
            var1.method2873(-1);
         } else {
            var1.method2873(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2873(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1450966020"
   )
   public void method3237(boolean var1) {
      if(this.isFemale != var1) {
         this.method3270((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-891601376"
   )
   public static int method3238() {
      return class105.keyboardIdleTicks;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "389116505"
   )
   void method3241() {
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
      if(var1 != 0L && this.hash != var1) {
         field2176.remove(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "664447815"
   )
   public Model method3242(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2171 != -1) {
         return class159.getNpcDefinition(this.field2171).method3777(var1, var2, var3, var4);
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

         Model var15 = (Model)field2176.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var16 = 0; var16 < 12; ++var16) {
               var11 = var7[var16];
               if(var11 >= 256 && var11 < 512 && !class165.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !ChatLineBuffer.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2177 != -1L) {
                  var15 = (Model)field2176.get(this.field2177);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var10 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class165.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var10[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = ChatLineBuffer.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var10[var11++] = var14;
                     }
                  }
               }

               ModelData var17 = new ModelData(var10, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class164.field2159[var13].length) {
                     var17.method1617(field2174[var13], class164.field2159[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class65.field1124[var13].length) {
                     var17.method1617(class149.field2033[var13], class65.field1124[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var17.method1624(64, 850, -30, -50, -30);
               field2176.put(var15, var5);
               this.field2177 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var15;
         } else {
            Model var18;
            if(null != var1 && var3 != null) {
               var18 = var1.method3831(var15, var2, var3, var4);
            } else if(null != var1) {
               var18 = var1.method3818(var15, var2);
            } else {
               var18 = var3.method3818(var15, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1628361420"
   )
   ModelData method3243() {
      if(this.field2171 != -1) {
         return class159.getNpcDefinition(this.field2171).method3795();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class165.getKitDefinition(var3 - 256).method3563()) {
               var1 = true;
            }

            if(var3 >= 512 && !ChatLineBuffer.getItemDefinition(var3 - 512).method3709(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var8 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var7 = 0; var7 < 12; ++var7) {
               var5 = this.equipmentIds[var7];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class165.getKitDefinition(var5 - 256).method3586();
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = ChatLineBuffer.getItemDefinition(var5 - 512).method3724(this.isFemale);
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class164.field2159[var5].length) {
                  var4.method1617(field2174[var5], class164.field2159[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class65.field1124[var5].length) {
                  var4.method1617(class149.field2033[var5], class65.field1124[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "689844440"
   )
   public int method3244() {
      return this.field2171 == -1?this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15):305419896 + class159.getNpcDefinition(this.field2171).id;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2143531690"
   )
   static int method3255(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.field726[--class32.field735];
         var4 = ChatLineBuffer.method993(var3);
      } else {
         var4 = var2?class32.field731:class108.field1738;
      }

      if(var0 == 1000) {
         class32.field735 -= 4;
         var4.originalX = class32.field726[class32.field735];
         var4.originalY = class32.field726[class32.field735 + 1];
         var4.field2211 = class32.field726[2 + class32.field735];
         var4.field2212 = class32.field726[class32.field735 + 3];
         ChatLineBuffer.method996(var4);
         class175.method3332(var4);
         if(var3 != -1 && var4.type == 0) {
            Script.method973(class231.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class32.field735 -= 4;
         var4.originalWidth = class32.field726[class32.field735];
         var4.field2199 = class32.field726[1 + class32.field735];
         var4.field2213 = class32.field726[class32.field735 + 2];
         var4.field2214 = class32.field726[class32.field735 + 3];
         ChatLineBuffer.method996(var4);
         class175.method3332(var4);
         if(var3 != -1 && var4.type == 0) {
            Script.method973(class231.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class32.field726[--class32.field735] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            ChatLineBuffer.method996(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2235 = class32.field726[--class32.field735] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2340 = class32.field726[--class32.field735] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1594808153"
   )
   public void method3263(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class164.field2159[var1].length - 1;
            }
         } while(!class40.method827(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class164.field2159[var1].length) {
               var3 = 0;
            }
         } while(!class40.method827(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3241();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-673065224"
   )
   public void method3266(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2168[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2831 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2831) {
                     var3 = 0;
                  }
               }

               var4 = class165.getKitDefinition(var3);
            } while(var4 == null || var4.field2824 || var4.field2825 != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2168[var1]] = var3 + 256;
            this.method3241();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "858214945"
   )
   public void method3270(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2831; ++var6) {
               KitDefinition var7 = class165.getKitDefinition(var6);
               if(null != var7 && !var7.field2824 && var7.field2825 == var5 + (var3?7:0)) {
                  var1[field2168[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2171 = var4;
      this.method3241();
   }
}
