import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 6280462864088275417L
   )
   long field2177;
   @ObfuscatedName("c")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("n")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 630891746039338035L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("ew")
   static SpritePixels[] field2181;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -728199495
   )
   public int field2182;
   @ObfuscatedName("v")
   public static short[][] field2183;
   @ObfuscatedName("g")
   static final int[] field2184;
   @ObfuscatedName("w")
   public static NodeCache field2185;
   @ObfuscatedName("d")
   @Export("equipmentIds")
   int[] equipmentIds;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1405475911"
   )
   public void method3146(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2840; ++var6) {
               KitDefinition var7 = ScriptState.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2184[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2182 = var4;
      this.method3151();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-348776435"
   )
   public void method3147(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2184[var2]];
         if(var3 == 0) {
            var1.putByte(-1);
         } else {
            var1.putByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.putByte(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "-10060"
   )
   public void method3149(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3146((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-356794397"
   )
   void method3151() {
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
         field2185.remove(var1);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-2030641854"
   )
   ModelData method3155() {
      if(this.field2182 != -1) {
         return Widget.getNpcDefinition(this.field2182).method3832();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !ScriptState.getKitDefinition(var3 - 256).method3533()) {
               var1 = true;
            }

            if(var3 >= 512 && !class47.getItemDefinition(var3 - 512).method3747(this.isFemale)) {
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
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = ScriptState.getKitDefinition(var5 - 256).method3539();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class47.getItemDefinition(var5 - 512).method3748(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class112.field1761[var5].length) {
                  var8.method1491(Friend.field155[var5], class112.field1761[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2183[var5].length) {
                  var8.method1491(class114.field1794[var5], field2183[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1506301171"
   )
   public void method3158(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class112.field1761[var1].length - 1;
            }
         } while(!class107.method2050(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class112.field1761[var1].length) {
               var3 = 0;
            }
         } while(!class107.method2050(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3151();
   }

   static {
      field2184 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2185 = new NodeCache(260);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1277075698"
   )
   public void method3166(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2184[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2840 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2840) {
                     var3 = 0;
                  }
               }

               var4 = ScriptState.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2184[var1]] = var3 + 256;
            this.method3151();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1846557786"
   )
   public int method3170() {
      return this.field2182 == -1?(this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[11] << 5) + this.equipmentIds[1]:Widget.getNpcDefinition(this.field2182).id + 305419896;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "256784371"
   )
   public Model method3172(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2182 != -1) {
         return Widget.getNpcDefinition(this.field2182).method3813(var1, var2, var3, var4);
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

         Model var16 = (Model)field2185.get(var5);
         if(var16 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !ScriptState.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class47.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2177) {
                  var16 = (Model)field2185.get(this.field2177);
               }

               if(var16 == null) {
                  return null;
               }
            }

            if(var16 == null) {
               ModelData[] var18 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = ScriptState.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var18[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class47.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var18[var11++] = var14;
                     }
                  }
               }

               ModelData var15 = new ModelData(var18, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class112.field1761[var13].length) {
                     var15.method1491(Friend.field155[var13], class112.field1761[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2183[var13].length) {
                     var15.method1491(class114.field1794[var13], field2183[var13][this.bodyPartColours[var13]]);
                  }
               }

               var16 = var15.method1502(64, 850, -30, -50, -30);
               field2185.put(var16, var5);
               this.field2177 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var16;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method3875(var16, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method3862(var16, var2);
            } else {
               var17 = var3.method3862(var16, var4);
            }

            return var17;
         }
      }
   }
}
