import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("y")
   static final int[] field2634;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field2628;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 338030201
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("k")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -244748151199456281L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("e")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("d")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -3665140426561815963L
   )
   long field2633;

   static {
      field2634 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2628 = new NodeCache(260);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "1"
   )
   public void method4096(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3350; ++var6) {
               KitDefinition var7 = class215.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var5 + (var3?7:0) == var7.bodyPartId) {
                  var1[field2634[var5]] = var6 + 256;
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "315045581"
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
      if(0L != var1 && this.hash != var1) {
         field2628.remove(var1);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljl;ILjl;II)Leb;",
      garbageValue = "1325816838"
   )
   public Model method4072(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class72.getNpcDefinition(this.transformedNpcId).method4727(var1, var2, var3, var4);
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

         Model var15 = (Model)field2628.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class215.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class46.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2633 != -1L) {
                  var15 = (Model)field2628.get(this.field2633);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class215.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class46.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class208.colorsToReplace[var13].length) {
                     var18.recolor(class152.colorsToFind[var13], class208.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < SoundTask.field1648[var13].length) {
                     var18.recolor(TextureProvider.field1767[var13], SoundTask.field1648[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2628.put(var15, var5);
               this.field2633 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4779(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4799(var15, var2);
            } else {
               var17 = var3.method4799(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ldl;",
      garbageValue = "8"
   )
   ModelData method4086() {
      if(this.transformedNpcId != -1) {
         return class72.getNpcDefinition(this.transformedNpcId).method4744();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class215.getKitDefinition(var3 - 256).method4462()) {
               var1 = true;
            }

            if(var3 >= 512 && !class46.getItemDefinition(var3 - 512).method4687(this.isFemale)) {
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
                  var6 = class215.getKitDefinition(var5 - 256).method4476();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class46.getItemDefinition(var5 - 512).method4671(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class208.colorsToReplace[var5].length) {
                  var8.recolor(class152.colorsToFind[var5], class208.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < SoundTask.field1648[var5].length) {
                  var8.recolor(TextureProvider.field1767[var5], SoundTask.field1648[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "28"
   )
   public int method4070() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class72.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "124"
   )
   public void method4078(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2634[var1]];
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

               var4 = class215.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2634[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-942097395"
   )
   public void method4073(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(var2) {
         do {
            ++var3;
            if(var3 >= class208.colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!class96.method1913(var1, var3));
      } else {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class208.colorsToReplace[var1].length - 1;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "287586615"
   )
   public void method4077(boolean var1) {
      if(this.isFemale != var1) {
         this.method4096((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-1359656989"
   )
   public void method4074(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2634[var2]];
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "42"
   )
   public static byte method4079(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }
}
