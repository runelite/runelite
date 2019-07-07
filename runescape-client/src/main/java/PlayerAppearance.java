import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("PlayerAppearance")
public class PlayerAppearance {
   @ObfuscatedName("g")
   public static short[] field726;
   @ObfuscatedName("d")
   static final int[] field727;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("PlayerAppearance_cachedModels")
   public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
   @ObfuscatedName("m")
   @Export("equipment")
   int[] equipment;
   @ObfuscatedName("f")
   @Export("bodyColors")
   int[] bodyColors;
   @ObfuscatedName("q")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1676934923
   )
   @Export("npcTransformId")
   public int npcTransformId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -3506189412688081513L
   )
   long field728;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 8217880921734028425L
   )
   long field729;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "727056871"
   )
   public void method256(int[] var1, int[] var2, boolean var3, int var4) {
      if (var1 == null) {
         var1 = new int[12];

         for (int var5 = 0; var5 < 7; ++var5) {
            for (int var6 = 0; var6 < KitDefinition.field457; ++var6) {
               KitDefinition var7 = WorldMapSection1.getKitDefinition(var6);
               if (var7 != null && !var7.nonSelectable && var5 + (var3 ? 7 : 0) == var7.bodypartID) {
                  var1[field727[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipment = var1;
      this.bodyColors = var2;
      this.isFemale = var3;
      this.npcTransformId = var4;
      this.setHash();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-581016899"
   )
   public void method257(int var1, boolean var2) {
      if (var1 != 1 || !this.isFemale) {
         int var3 = this.equipment[field727[var1]];
         if (var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               do {
                  do {
                     if (!var2) {
                        --var3;
                        if (var3 < 0) {
                           var3 = KitDefinition.field457 - 1;
                        }
                     } else {
                        ++var3;
                        if (var3 >= KitDefinition.field457) {
                           var3 = 0;
                        }
                     }

                     var4 = WorldMapSection1.getKitDefinition(var3);
                  } while(var4 == null);
               } while(var4.nonSelectable);
            } while(var1 + (this.isFemale ? 7 : 0) != var4.bodypartID);

            this.equipment[field727[var1]] = var3 + 256;
            this.setHash();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1416503110"
   )
   public void method258(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      if (!var2) {
         do {
            --var3;
            if (var3 < 0) {
               var3 = class229.field1137[var1].length - 1;
            }
         } while(!PacketBuffer.method4062(var1, var3));
      } else {
         do {
            ++var3;
            if (var3 >= class229.field1137[var1].length) {
               var3 = 0;
            }
         } while(!PacketBuffer.method4062(var1, var3));
      }

      this.bodyColors[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-90"
   )
   public void method259(boolean var1) {
      if (this.isFemale != var1) {
         this.method256((int[])null, this.bodyColors, var1, -1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "779254645"
   )
   public void method260(Buffer var1) {
      var1.writeByte(this.isFemale ? 1 : 0);

      int var2;
      for (var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipment[field727[var2]];
         if (var3 == 0) {
            var1.writeByte(-1);
         } else {
            var1.writeByte(var3 - 256);
         }
      }

      for (var2 = 0; var2 < 5; ++var2) {
         var1.writeByte(this.bodyColors[var2]);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   @Export("setHash")
   void setHash() {
      long var1 = this.field728;
      int var3 = this.equipment[5];
      int var4 = this.equipment[9];
      this.equipment[5] = var4;
      this.equipment[9] = var3;
      this.field728 = 0L;

      int var5;
      for (var5 = 0; var5 < 12; ++var5) {
         this.field728 <<= 4;
         if (this.equipment[var5] >= 256) {
            this.field728 += (long)(this.equipment[var5] - 256);
         }
      }

      if (this.equipment[0] >= 256) {
         this.field728 += (long)(this.equipment[0] - 256 >> 4);
      }

      if (this.equipment[1] >= 256) {
         this.field728 += (long)(this.equipment[1] - 256 >> 8);
      }

      for (var5 = 0; var5 < 5; ++var5) {
         this.field728 <<= 3;
         this.field728 += (long)this.bodyColors[var5];
      }

      this.field728 <<= 1;
      this.field728 += (long)(this.isFemale ? 1 : 0);
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if (var1 != 0L && this.field728 != var1) {
         PlayerAppearance_cachedModels.remove(var1);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljh;ILjh;II)Ldu;",
      garbageValue = "-735725541"
   )
   @Export("getModel")
   public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if (this.npcTransformId != -1) {
         return ObjectDefinition.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
      } else {
         long var5 = this.field728;
         int[] var7 = this.equipment;
         if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
            var7 = new int[12];

            for (int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.equipment[var8];
            }

            if (var1.shield >= 0) {
               var5 += (long)(var1.shield - this.equipment[5] << 40);
               var7[5] = var1.shield;
            }

            if (var1.weapon >= 0) {
               var5 += (long)(var1.weapon - this.equipment[3] << 48);
               var7[3] = var1.weapon;
            }
         }

         Model var15 = (Model)PlayerAppearance_cachedModels.get(var5);
         if (var15 == null) {
            boolean var9 = false;

            int var10;
            for (int var11 = 0; var11 < 12; ++var11) {
               var10 = var7[var11];
               if (var10 >= 256 && var10 < 512 && !WorldMapSection1.getKitDefinition(var10 - 256).ready()) {
                  var9 = true;
               }

               if (var10 >= 512 && !Skills.getItemDefinition(var10 - 512).method145(this.isFemale)) {
                  var9 = true;
               }
            }

            if (var9) {
               if (this.field729 != -1L) {
                  var15 = (Model)PlayerAppearance_cachedModels.get(this.field729);
               }

               if (var15 == null) {
                  return null;
               }
            }

            if (var15 == null) {
               ModelData[] var17 = new ModelData[12];
               var10 = 0;

               int var12;
               for (int var13 = 0; var13 < 12; ++var13) {
                  var12 = var7[var13];
                  ModelData var14;
                  if (var12 >= 256 && var12 < 512) {
                     var14 = WorldMapSection1.getKitDefinition(var12 - 256).getModelData();
                     if (var14 != null) {
                        var17[var10++] = var14;
                     }
                  }

                  if (var12 >= 512) {
                     var14 = Skills.getItemDefinition(var12 - 512).method146(this.isFemale);
                     if (var14 != null) {
                        var17[var10++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var10);

               for (var12 = 0; var12 < 5; ++var12) {
                  if (this.bodyColors[var12] < class229.field1137[var12].length) {
                     var18.recolor(field726[var12], class229.field1137[var12][this.bodyColors[var12]]);
                  }

                  if (this.bodyColors[var12] < ArchiveLoader.field406[var12].length) {
                     var18.recolor(class227.field1136[var12], ArchiveLoader.field406[var12][this.bodyColors[var12]]);
                  }
               }

               var15 = var18.toModel(64, 850, -30, -50, -30);
               PlayerAppearance_cachedModels.put(var15, var5);
               this.field729 = var5;
            }
         }

         if (var1 == null && var3 == null) {
            return var15;
         } else {
            Model var16;
            if (var1 != null && var3 != null) {
               var16 = var1.animateSequence2(var15, var2, var3, var4);
            } else if (var1 != null) {
               var16 = var1.animateSequence(var15, var2);
            } else {
               var16 = var3.animateSequence(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "1807737418"
   )
   @Export("getModelData")
   ModelData getModelData() {
      if (this.npcTransformId != -1) {
         return ObjectDefinition.getNpcDefinition(this.npcTransformId).getModelData();
      } else {
         boolean var1 = false;

         int var2;
         for (int var3 = 0; var3 < 12; ++var3) {
            var2 = this.equipment[var3];
            if (var2 >= 256 && var2 < 512 && !WorldMapSection1.getKitDefinition(var2 - 256).method161()) {
               var1 = true;
            }

            if (var2 >= 512 && !Skills.getItemDefinition(var2 - 512).method147(this.isFemale)) {
               var1 = true;
            }
         }

         if (var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var2 = 0;

            int var4;
            for (int var5 = 0; var5 < 12; ++var5) {
               var4 = this.equipment[var5];
               ModelData var6;
               if (var4 >= 256 && var4 < 512) {
                  var6 = WorldMapSection1.getKitDefinition(var4 - 256).method162();
                  if (var6 != null) {
                     var7[var2++] = var6;
                  }
               }

               if (var4 >= 512) {
                  var6 = Skills.getItemDefinition(var4 - 512).method148(this.isFemale);
                  if (var6 != null) {
                     var7[var2++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var2);

            for (var4 = 0; var4 < 5; ++var4) {
               if (this.bodyColors[var4] < class229.field1137[var4].length) {
                  var8.recolor(field726[var4], class229.field1137[var4][this.bodyColors[var4]]);
               }

               if (this.bodyColors[var4] < ArchiveLoader.field406[var4].length) {
                  var8.recolor(class227.field1136[var4], ArchiveLoader.field406[var4][this.bodyColors[var4]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "123"
   )
   @Export("getChatHeadId")
   public int getChatHeadId() {
      return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + ObjectDefinition.getNpcDefinition(this.npcTransformId).id;
   }

   static {
      field727 = new int[]{8, 11, 4, 6, 9, 7, 10};
      PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
   }
}
