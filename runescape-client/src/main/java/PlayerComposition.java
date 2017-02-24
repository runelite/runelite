import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 7511691731450553709L
   )
   long field2168;
   @ObfuscatedName("h")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 5667231854547990941L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("q")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("d")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("m")
   static final int[] field2175 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("s")
   static NodeCache field2176 = new NodeCache(260);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1487266133
   )
   public int field2177;
   @ObfuscatedName("i")
   public static short[] field2180;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1962189972"
   )
   public void method3170(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class215.field3174; ++var6) {
               KitDefinition var7 = class97.getKitDefinition(var6);
               if(var7 != null && !var7.field2828 && (var3?7:0) + var5 == var7.field2821) {
                  var1[field2175[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2177 = var4;
      this.method3175();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2125917701"
   )
   public void method3172(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class114.field1788[var1].length - 1;
            }
         } while(!class175.method3277(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class114.field1788[var1].length) {
               var3 = 0;
            }
         } while(!class175.method3277(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method3175();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1588754085"
   )
   public void method3173(boolean var1) {
      if(this.isFemale != var1) {
         this.method3170((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1488156146"
   )
   void method3175() {
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
         field2176.remove(var1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "85642499"
   )
   ModelData method3177() {
      if(this.field2177 != -1) {
         return class13.getNpcDefinition(this.field2177).method3740();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class97.getKitDefinition(var3 - 256).method3501()) {
               var1 = true;
            }

            if(var3 >= 512 && !class103.getItemDefinition(var3 - 512).method3673(this.isFemale)) {
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
                  var6 = class97.getKitDefinition(var5 - 256).method3502();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class103.getItemDefinition(var5 - 512).method3685(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class114.field1788[var5].length) {
                  var8.method1526(CombatInfoListHolder.field782[var5], class114.field1788[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class47.field952[var5].length) {
                  var8.method1526(field2180[var5], class47.field952[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-735394367"
   )
   public int method3178() {
      return this.field2177 == -1?(this.equipmentIds[0] << 15) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[8] << 10) + (this.equipmentIds[11] << 5) + this.equipmentIds[1]:305419896 + class13.getNpcDefinition(this.field2177).id;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1654714825"
   )
   public void method3183(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2175[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class215.field3174 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class215.field3174) {
                     var3 = 0;
                  }
               }

               var4 = class97.getKitDefinition(var3);
            } while(var4 == null || var4.field2828 || var4.field2821 != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2175[var1]] = var3 + 256;
            this.method3175();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1564483775"
   )
   public Model method3189(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2177 != -1) {
         return class13.getNpcDefinition(this.field2177).method3741(var1, var2, var3, var4);
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
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class97.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class103.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2168 != -1L) {
                  var15 = (Model)field2176.get(this.field2168);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class97.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class103.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var16 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class114.field1788[var13].length) {
                     var16.method1526(CombatInfoListHolder.field782[var13], class114.field1788[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class47.field952[var13].length) {
                     var16.method1526(field2180[var13], class47.field952[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var16.method1534(64, 850, -30, -50, -30);
               field2176.put(var15, var5);
               this.field2168 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var18;
            if(var1 != null && null != var3) {
               var18 = var1.method3782(var15, var2, var3, var4);
            } else if(null != var1) {
               var18 = var1.method3793(var15, var2);
            } else {
               var18 = var3.method3793(var15, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-358428329"
   )
   public void method3190(Buffer var1) {
      var1.method2918(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2175[var2]];
         if(var3 == 0) {
            var1.method2918(-1);
         } else {
            var1.method2918(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2918(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-486859166"
   )
   static final void method3192(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field458 != 0 || Client.field511) {
         int var2 = Buffer.method2893();
         String var3;
         if(Client.field458 == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.field459 + " " + "->";
         } else if(Client.field511 && Client.menuOptionCount < 2) {
            var3 = Client.field463 + " " + Client.field380 + " " + "->";
         } else {
            String var4;
            if(var2 < 0) {
               var4 = "";
            } else if(Client.menuTargets[var2].length() > 0) {
               var4 = Client.menuOptions[var2] + " " + Client.menuTargets[var2];
            } else {
               var4 = Client.menuOptions[var2];
            }

            var3 = var4;
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + class18.method199(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         NPC.field786.method3906(var3, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass195;",
      garbageValue = "-2145090385"
   )
   public static class195 method3198(int var0) {
      class195 var1 = (class195)class195.field2855.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class195.field2859.getConfigData(8, var0);
         var1 = new class195();
         if(var2 != null) {
            var1.method3569(new Buffer(var2));
         }

         class195.field2855.put(var1, (long)var0);
         return var1;
      }
   }
}
