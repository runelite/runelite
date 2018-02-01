import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("o")
   static final int[] field2707;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field2708;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1087382289
   )
   static int field2701;
   @ObfuscatedName("p")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("i")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("w")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1316379247
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 2722986729666450697L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 4866283925544380027L
   )
   long field2709;

   static {
      field2707 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2708 = new NodeCache(260);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1836588487"
   )
   public void method4208(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3406; ++var6) {
               KitDefinition var7 = class43.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2707[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.transformedNpcId = var4;
      this.setHash();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2094828569"
   )
   public void method4209(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2707[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3406 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3406) {
                     var3 = 0;
                  }
               }

               var4 = class43.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || (this.isFemale?7:0) + var1 != var4.bodyPartId);

            this.equipmentIds[field2707[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZS)V",
      garbageValue = "285"
   )
   public void method4222(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class70.colorsToReplace[var1].length - 1;
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
            if(var3 >= class70.colorsToReplace[var1].length) {
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
      this.setHash();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "6510"
   )
   public void method4211(boolean var1) {
      if(this.isFemale != var1) {
         this.method4208((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgj;S)V",
      garbageValue = "-19043"
   )
   public void method4212(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2707[var2]];
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1156510573"
   )
   @Export("setHash")
   void setHash() {
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
      if(0L != var1 && var1 != this.hash) {
         field2708.remove(var1);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljm;ILjm;II)Len;",
      garbageValue = "448992457"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class230.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var8 = (Model)field2708.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class43.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !CombatInfo1.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2709) {
                  var8 = (Model)field2708.get(this.field2709);
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
                     var14 = class43.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = CombatInfo1.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class70.colorsToReplace[var13].length) {
                     var18.recolor(class31.colorsToFind[var13], class70.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class310.field3890[var13].length) {
                     var18.recolor(BoundingBox3D.field245[var13], class310.field3890[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2708.put(var8, var5);
               this.field2709 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method4954(var8, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method4958(var8, var2);
            } else {
               var16 = var3.method4958(var8, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ldy;",
      garbageValue = "-24"
   )
   ModelData method4241() {
      if(this.transformedNpcId != -1) {
         return class230.getNpcDefinition(this.transformedNpcId).method4929();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class43.getKitDefinition(var3 - 256).method4633()) {
               var1 = true;
            }

            if(var3 >= 512 && !CombatInfo1.getItemDefinition(var3 - 512).method4837(this.isFemale)) {
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
                  var6 = class43.getKitDefinition(var5 - 256).method4644();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = CombatInfo1.getItemDefinition(var5 - 512).method4860(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class70.colorsToReplace[var5].length) {
                  var8.recolor(class31.colorsToFind[var5], class70.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class310.field3890[var5].length) {
                  var8.recolor(BoundingBox3D.field245[var5], class310.field3890[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "492843983"
   )
   public int method4216() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class230.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILee;[Lfg;I)V",
      garbageValue = "753742761"
   )
   static final void method4210(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = TextureProvider.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.width;
               int var28 = var21.length;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.width;
               int var36 = var21.length;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var3 + var31;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class61.tileSettings[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  CollisionData var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  class22.addObject(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1555536430"
   )
   public static String method4246(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-646837428"
   )
   public static boolean method4245(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
