import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("f")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("j")
   public static short[][] field2735;
   @ObfuscatedName("x")
   static final int[] field2736;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static NodeCache field2737;
   @ObfuscatedName("am")
   static GarbageCollectorMXBean field2738;
   @ObfuscatedName("a")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("w")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("e")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -938568641
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -5429717739818962937L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 3828649192499257485L
   )
   long field2733;

   static {
      field2736 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2737 = new NodeCache(260);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1475058852"
   )
   public void method4104(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < WorldComparator.field265; ++var6) {
               KitDefinition var7 = class193.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && (var3?7:0) + var5 == var7.bodyPartId) {
                  var1[field2736[var5]] = var6 + 256;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "111"
   )
   public void method4093(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2736[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = WorldComparator.field265 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= WorldComparator.field265) {
                     var3 = 0;
                  }
               }

               var4 = class193.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2736[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-65"
   )
   public void method4094(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = colorsToReplace[var1].length - 1;
            }
         } while(!ClanMember.method1118(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!ClanMember.method1118(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1225917413"
   )
   public void method4092(boolean var1) {
      if(this.isFemale != var1) {
         this.method4104((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "-1839751134"
   )
   public void method4096(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2736[var2]];
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-649684444"
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
         field2737.remove(var1);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljj;ILjj;II)Lef;",
      garbageValue = "-2054383603"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return Client.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
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

         Model var8 = (Model)field2737.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class193.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !KitDefinition.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2733 != -1L) {
                  var8 = (Model)field2737.get(this.field2733);
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
                     var14 = class193.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = KitDefinition.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var18.recolor(FrameMap.colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2735[var13].length) {
                     var18.recolor(BoundingBox3D.field245[var13], field2735[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2737.put(var8, var5);
               this.field2733 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4847(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4837(var8, var2);
            } else {
               var17 = var3.method4837(var8, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ldm;",
      garbageValue = "1703011005"
   )
   ModelData method4114() {
      if(this.transformedNpcId != -1) {
         return Client.getNpcDefinition(this.transformedNpcId).method4775();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class193.getKitDefinition(var3 - 256).method4514()) {
               var1 = true;
            }

            if(var3 >= 512 && !KitDefinition.getItemDefinition(var3 - 512).method4723(this.isFemale)) {
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
                  var6 = class193.getKitDefinition(var5 - 256).method4511();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = KitDefinition.getItemDefinition(var5 - 512).method4720(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < colorsToReplace[var5].length) {
                  var8.recolor(FrameMap.colorsToFind[var5], colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2735[var5].length) {
                  var8.recolor(BoundingBox3D.field245[var5], field2735[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "561841876"
   )
   public int method4100() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + Client.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1334582769"
   )
   public static boolean method4105() {
      try {
         if(class214.field2620 == 2) {
            if(class214.field2622 == null) {
               class214.field2622 = Track1.getMusicFile(class214.field2623, class61.field692, class282.field3754);
               if(class214.field2622 == null) {
                  return false;
               }
            }

            if(class214.field2627 == null) {
               class214.field2627 = new class111(class214.field2624, class214.field2621);
            }

            if(class282.field3753.method3845(class214.field2622, class214.field2626, class214.field2627, 22050)) {
               class282.field3753.method3846();
               class282.field3753.method3843(class214.field2625);
               class282.field3753.method3848(class214.field2622, IndexFile.field2181);
               class214.field2620 = 0;
               class214.field2622 = null;
               class214.field2627 = null;
               class214.field2623 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class282.field3753.method3849();
         class214.field2620 = 0;
         class214.field2622 = null;
         class214.field2627 = null;
         class214.field2623 = null;
      }

      return false;
   }
}
