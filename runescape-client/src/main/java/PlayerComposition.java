import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("i")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("e")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 655898565
   )
   public int field2620;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 6782131206262197779L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -5561555438211075119L
   )
   long field2622;
   @ObfuscatedName("f")
   public static short[] field2623;
   @ObfuscatedName("c")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("a")
   static final int[] field2625;
   @ObfuscatedName("o")
   static NodeCache field2626;
   @ObfuscatedName("x")
   public static short[][] field2627;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "1448907686"
   )
   public void method3936(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3350; ++var6) {
               KitDefinition var7 = class152.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2625[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2620 = var4;
      this.method3956();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1745617934"
   )
   public void method3937(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2625[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3350 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3350) {
                     var3 = 0;
                  }
               }

               var4 = class152.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2625[var1]] = var3 + 256;
            this.method3956();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-889018098"
   )
   public void method3938(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2627[var1].length - 1;
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
            if(var3 >= field2627[var1].length) {
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
      this.method3956();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "665772563"
   )
   public void method3939(boolean var1) {
      if(this.isFemale != var1) {
         this.method3936((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "-39"
   )
   public Model method3942(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2620 != -1) {
         return class220.getNpcDefinition(this.field2620).method4646(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
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

         Model var8 = (Model)field2626.get(var5);
         if(var8 == null) {
            boolean var17 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class152.getKitDefinition(var11 - 256).ready()) {
                  var17 = true;
               }

               if(var11 >= 512 && !Buffer.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var17 = true;
               }
            }

            if(var17) {
               if(this.field2622 != -1L) {
                  var8 = (Model)field2626.get(this.field2622);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var18 = 0; var18 < 12; ++var18) {
                  var13 = var7[var18];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class152.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = Buffer.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2627[var13].length) {
                     var12.method2409(class269.field3676[var13], field2627[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class116.field1703[var13].length) {
                     var12.method2409(field2623[var13], class116.field1703[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var12.method2417(64, 850, -30, -50, -30);
               field2626.put(var8, var5);
               this.field2622 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var9;
            if(var1 != null && var3 != null) {
               var9 = var1.method4692(var8, var2, var3, var4);
            } else if(var1 != null) {
               var9 = var1.method4689(var8, var2);
            } else {
               var9 = var3.method4689(var8, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1198165902"
   )
   ModelData method3943() {
      if(this.field2620 != -1) {
         return class220.getNpcDefinition(this.field2620).method4648();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class152.getKitDefinition(var3 - 256).method4374()) {
               var1 = true;
            }

            if(var3 >= 512 && !Buffer.getItemDefinition(var3 - 512).method4580(this.isFemale)) {
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
                  var6 = class152.getKitDefinition(var5 - 256).method4381();
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = Buffer.getItemDefinition(var5 - 512).method4581(this.isFemale);
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }
            }

            ModelData var7 = new ModelData(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2627[var5].length) {
                  var7.method2409(class269.field3676[var5], field2627[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class116.field1703[var5].length) {
                  var7.method2409(field2623[var5], class116.field1703[var5][this.bodyPartColours[var5]]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3944() {
      return this.field2620 == -1?(this.equipmentIds[11] << 5) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[8] << 10) + this.equipmentIds[1]:class220.getNpcDefinition(this.field2620).id + 305419896;
   }

   static {
      field2625 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2626 = new NodeCache(260);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2093979289"
   )
   void method3956() {
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
         field2626.remove(var1);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "18"
   )
   public void method3961(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2625[var2]];
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
}
