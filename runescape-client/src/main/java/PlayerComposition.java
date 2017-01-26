import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("m")
   static NodeCache field2166 = new NodeCache(260);
   @ObfuscatedName("x")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("p")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -7463031937049149969L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 6159493106318064037L
   )
   long field2170;
   @ObfuscatedName("s")
   public static short[][] field2171;
   @ObfuscatedName("o")
   public static short[] field2172;
   @ObfuscatedName("c")
   static final int[] field2173 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2093652123
   )
   public int field2174;
   @ObfuscatedName("g")
   @Export("bodyPartColours")
   int[] bodyPartColours;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-1912844282"
   )
   public static String method3120(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1572788854"
   )
   public void method3121(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2173[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2814 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2814) {
                     var3 = 0;
                  }
               }

               var4 = class185.getKitDefinition(var3);
            } while(null == var4 || var4.field2818 || (this.isFemale?7:0) + var1 != var4.field2816);

            this.equipmentIds[field2173[var1]] = var3 + 256;
            this.method3125();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "0"
   )
   public void method3122(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(var2) {
         do {
            ++var3;
            if(var3 >= field2171[var1].length) {
               var3 = 0;
            }
         } while(!GameObject.method1916(var1, var3));
      } else {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2171[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.bodyPartColours[var1] = var3;
      this.method3125();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "34"
   )
   public void method3123(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3156((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1392938203"
   )
   public void method3124(Buffer var1) {
      var1.method2799(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2173[var2]];
         if(var3 == 0) {
            var1.method2799(-1);
         } else {
            var1.method2799(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2799(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3125() {
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
      if(0L != var1 && this.hash != var1) {
         field2166.remove(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "863881100"
   )
   public Model method3126(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2174 != -1) {
         return Tile.getNpcDefinition(this.field2174).method3707(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(null != var1 && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.equipmentIds[var15];
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

         Model var8 = (Model)field2166.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class185.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class36.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2170 != -1L) {
                  var8 = (Model)field2166.get(this.field2170);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class185.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class36.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2171[var13].length) {
                     var18.method1471(class227.field3229[var13], field2171[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < World.field683[var13].length) {
                     var18.method1471(field2172[var13], World.field683[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.method1479(64, 850, -30, -50, -30);
               field2166.put(var8, var5);
               this.field2170 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var8;
         } else {
            Model var16;
            if(null != var1 && var3 != null) {
               var16 = var1.method3753(var8, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method3775(var8, var2);
            } else {
               var16 = var3.method3775(var8, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-550498032"
   )
   ModelData method3127() {
      if(this.field2174 != -1) {
         return Tile.getNpcDefinition(this.field2174).method3702();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class185.getKitDefinition(var3 - 256).method3487()) {
               var1 = true;
            }

            if(var3 >= 512 && !class36.getItemDefinition(var3 - 512).method3676(this.isFemale)) {
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
               var5 = this.equipmentIds[var8];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class185.getKitDefinition(var5 - 256).method3496();
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class36.getItemDefinition(var5 - 512).method3656(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2171[var5].length) {
                  var4.method1471(class227.field3229[var5], field2171[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < World.field683[var5].length) {
                  var4.method1471(field2172[var5], World.field683[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1988607183"
   )
   public int method3128() {
      return this.field2174 == -1?(this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[11] << 5) + this.equipmentIds[1]:305419896 + Tile.getNpcDefinition(this.field2174).id;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Lclass142;",
      garbageValue = "1864917723"
   )
   static class142 method3144(class182 var0, int var1) {
      byte[] var2 = var0.method3292(var1);
      return null == var2?null:new class142(var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1924966973"
   )
   static final int method3146(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-137234364"
   )
   public static boolean method3153(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-2013781302"
   )
   static final void method3155(class68 var0) {
      var0.field1141 = false;
      if(var0.field1143 != null) {
         var0.field1143.field1175 = 0;
      }

      for(class68 var1 = var0.vmethod2701(); null != var1; var1 = var0.vmethod2702()) {
         method3155(var1);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1954768902"
   )
   public void method3156(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2814; ++var6) {
               KitDefinition var7 = class185.getKitDefinition(var6);
               if(null != var7 && !var7.field2818 && (var3?7:0) + var5 == var7.field2816) {
                  var1[field2173[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2174 = var4;
      this.method3125();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass221;",
      garbageValue = "-1613412389"
   )
   public static class221[] method3157() {
      return new class221[]{class221.field3190, class221.field3185, class221.field3187, class221.field3188, class221.field3186};
   }
}
