import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("e")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("x")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("g")
   public static short[][] field2789;
   @ObfuscatedName("n")
   static final int[] field2790;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field2791;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -261578625
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("t")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("q")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("i")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1341775355
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -7727744615269833707L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 5581079581294420075L
   )
   long field2787;

   static {
      field2790 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2791 = new NodeCache(260);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "76"
   )
   public void method4424(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3513; ++var6) {
               KitDefinition var7 = class38.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2790[var5]] = var6 + 256;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1438480701"
   )
   public void method4423(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2790[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3513 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3513) {
                     var3 = 0;
                  }
               }

               var4 = class38.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var1 + (this.isFemale?7:0) != var4.bodyPartId);

            this.equipmentIds[field2790[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "2"
   )
   public void method4415(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = colorsToReplace[var1].length - 1;
            }
         } while(!class191.method3509(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!class191.method3509(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-356060356"
   )
   public void method4414(boolean var1) {
      if(this.isFemale != var1) {
         this.method4424((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-160176570"
   )
   public void method4417(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2790[var2]];
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
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
         field2791.remove(var1);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lkf;ILkf;IB)Lek;",
      garbageValue = "-52"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class233.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var8 = (Model)field2791.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class38.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class81.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2787) {
                  var8 = (Model)field2791.get(this.field2787);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class38.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class81.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var18.recolor(colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2789[var13].length) {
                     var18.recolor(WorldComparator.field260[var13], field2789[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2791.put(var8, var5);
               this.field2787 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method5171(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method5168(var8, var2);
            } else {
               var17 = var3.method5168(var8, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ldi;",
      garbageValue = "1273363506"
   )
   ModelData method4420() {
      if(this.transformedNpcId != -1) {
         return class233.getNpcDefinition(this.transformedNpcId).method5113();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class38.getKitDefinition(var3 - 256).method4837()) {
               var1 = true;
            }

            if(var3 >= 512 && !class81.getItemDefinition(var3 - 512).method5045(this.isFemale)) {
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
                  var6 = class38.getKitDefinition(var5 - 256).method4836();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class81.getItemDefinition(var5 - 512).method5050(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < colorsToReplace[var5].length) {
                  var8.recolor(colorsToFind[var5], colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2789[var5].length) {
                  var8.recolor(WorldComparator.field260[var5], field2789[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1530929267"
   )
   public int method4421() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + class233.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;Ljava/lang/String;I)I",
      garbageValue = "128715431"
   )
   public static int method4446(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var5[var6] = -128;
            } else if(var7 == 8218) {
               var5[var6] = -126;
            } else if(var7 == 402) {
               var5[var6] = -125;
            } else if(var7 == 8222) {
               var5[var6] = -124;
            } else if(var7 == 8230) {
               var5[var6] = -123;
            } else if(var7 == 8224) {
               var5[var6] = -122;
            } else if(var7 == 8225) {
               var5[var6] = -121;
            } else if(var7 == 710) {
               var5[var6] = -120;
            } else if(var7 == 8240) {
               var5[var6] = -119;
            } else if(var7 == 352) {
               var5[var6] = -118;
            } else if(var7 == 8249) {
               var5[var6] = -117;
            } else if(var7 == 338) {
               var5[var6] = -116;
            } else if(var7 == 381) {
               var5[var6] = -114;
            } else if(var7 == 8216) {
               var5[var6] = -111;
            } else if(var7 == 8217) {
               var5[var6] = -110;
            } else if(var7 == 8220) {
               var5[var6] = -109;
            } else if(var7 == 8221) {
               var5[var6] = -108;
            } else if(var7 == 8226) {
               var5[var6] = -107;
            } else if(var7 == 8211) {
               var5[var6] = -106;
            } else if(var7 == 8212) {
               var5[var6] = -105;
            } else if(var7 == 732) {
               var5[var6] = -104;
            } else if(var7 == 8482) {
               var5[var6] = -103;
            } else if(var7 == 353) {
               var5[var6] = -102;
            } else if(var7 == 8250) {
               var5[var6] = -101;
            } else if(var7 == 339) {
               var5[var6] = -100;
            } else if(var7 == 382) {
               var5[var6] = -98;
            } else if(var7 == 376) {
               var5[var6] = -97;
            } else {
               var5[var6] = 63;
            }
         } else {
            var5[var6] = (byte)var7;
         }
      }

      var0.putShortSmart(var5.length);
      var0.offset += class313.huffman.compress(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-686874085"
   )
   static void method4433(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgz;IB)V",
      garbageValue = "61"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class93.field1404[++class93.field1395 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field820 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class93.Players_regions[var1] = (var4.field836 << 28) + (class38.baseX + var4.pathX[0] >> 13 << 14) + (baseY + var4.pathY[0] >> 13);
            if(var4.field1142 != -1) {
               class93.Players_orientations[var1] = var4.field1142;
            } else {
               class93.Players_orientations[var1] = var4.orientation;
            }

            class93.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class163.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1214(var6, var7);
               var4.field820 = false;
            } else if(var2) {
               var4.field820 = true;
               var4.field821 = var6;
               var4.field831 = var7;
            } else {
               var4.field820 = false;
               var4.method1210(var6, var7, class93.field1393[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1214(var6, var7);
               var4.field820 = false;
            } else if(var2) {
               var4.field820 = true;
               var4.field821 = var6;
               var4.field831 = var7;
            } else {
               var4.field820 = false;
               var4.method1210(var6, var7, class93.field1393[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field820 = true;
                     var4.field821 = var10;
                     var4.field831 = var11;
                  } else {
                     var4.field820 = false;
                     var4.method1210(var10, var11, class93.field1393[var1]);
                  }
               } else {
                  var4.method1214(var10, var11);
                  var4.field820 = false;
               }

               var4.field836 = (byte)(var7 + var4.field836 & 3);
               if(Client.localInteractingIndex == var1) {
                  Ignore.plane = var4.field836;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class38.baseX + var4.pathX[0] & 16383) - class38.baseX;
               var11 = (var9 + baseY + var4.pathY[0] & 16383) - baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1214(var10, var11);
                  var4.field820 = false;
               } else if(var2) {
                  var4.field820 = true;
                  var4.field821 = var10;
                  var4.field831 = var11;
               } else {
                  var4.field820 = false;
                  var4.method1210(var10, var11, class93.field1393[var1]);
               }

               var4.field836 = (byte)(var7 + var4.field836 & 3);
               if(Client.localInteractingIndex == var1) {
                  Ignore.plane = var4.field836;
               }

            }
         }
      }
   }
}
