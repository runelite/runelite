import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("r")
   static final int[] field2177 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("c")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("f")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -15207541
   )
   public int field2180;
   @ObfuscatedName("s")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -8418505052830266077L
   )
   long field2182;
   @ObfuscatedName("b")
   public static short[] field2183;
   @ObfuscatedName("n")
   static NodeCache field2184 = new NodeCache(260);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -4645062334292115009L
   )
   @Export("hash")
   long hash;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "40740961"
   )
   public void method3040(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2823; ++var6) {
               KitDefinition var7 = class186.getKitDefinition(var6);
               if(var7 != null && !var7.field2832 && var7.field2827 == var5 + (var3?7:0)) {
                  var1[field2177[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2180 = var4;
      this.method3045();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1051872948"
   )
   public void method3041(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2177[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2823 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2823) {
                     var3 = 0;
                  }
               }

               var4 = class186.getKitDefinition(var3);
            } while(null == var4 || var4.field2832 || var4.field2827 != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2177[var1]] = var3 + 256;
            this.method3045();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "345629733"
   )
   public void method3042(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class116.field1816[var1].length - 1;
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
            if(var3 >= class116.field1816[var1].length) {
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
      this.method3045();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1206582445"
   )
   public void method3043(boolean var1) {
      if(var1 != this.isFemale) {
         this.method3040((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-378215886"
   )
   public void method3044(Buffer var1) {
      var1.method2708(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2177[var2]];
         if(var3 == 0) {
            var1.method2708(-1);
         } else {
            var1.method2708(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2708(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   void method3045() {
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
         field2184.remove(var1);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "-62"
   )
   public Model method3046(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2180 != -1) {
         return Buffer.getNpcDefinition(this.field2180).method3591(var1, var2, var3, var4);
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

         Model var15 = (Model)field2184.get(var5);
         if(var15 == null) {
            boolean var16 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class186.getKitDefinition(var11 - 256).ready()) {
                  var16 = true;
               }

               if(var11 >= 512 && !NPC.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(-1L != this.field2182) {
                  var15 = (Model)field2184.get(this.field2182);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(null == var15) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class186.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = NPC.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class116.field1816[var13].length) {
                     var18.method1439(ChatLineBuffer.field963[var13], class116.field1816[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class38.field793[var13].length) {
                     var18.method1439(field2183[var13], class38.field793[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.method1446(64, 850, -30, -50, -30);
               field2184.put(var15, var5);
               this.field2182 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var15;
         } else {
            Model var9;
            if(null != var1 && var3 != null) {
               var9 = var1.method3638(var15, var2, var3, var4);
            } else if(null != var1) {
               var9 = var1.method3611(var15, var2);
            } else {
               var9 = var3.method3611(var15, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1533302192"
   )
   public int method3049() {
      return this.field2180 == -1?this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[0] << 15):305419896 + Buffer.getNpcDefinition(this.field2180).id;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-473159092"
   )
   public static byte[] method3053(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class143.method2634(var3):var3;
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod2931();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1505346501"
   )
   static void method3057() {
      FileOnDisk var0 = null;

      try {
         var0 = class32.method667("", class183.field2729.field2688, true);
         Buffer var1 = class38.field794.method641();
         var0.method1396(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1378();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-16"
   )
   ModelData method3063() {
      if(this.field2180 != -1) {
         return Buffer.getNpcDefinition(this.field2180).method3574();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.equipmentIds[var7];
            if(var3 >= 256 && var3 < 512 && !class186.getKitDefinition(var3 - 256).method3388()) {
               var1 = true;
            }

            if(var3 >= 512 && !NPC.getItemDefinition(var3 - 512).method3559(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var8 = 0; var8 < 12; ++var8) {
               var5 = this.equipmentIds[var8];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class186.getKitDefinition(var5 - 256).method3404();
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = NPC.getItemDefinition(var5 - 512).method3537(this.isFemale);
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class116.field1816[var5].length) {
                  var4.method1439(ChatLineBuffer.field963[var5], class116.field1816[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class38.field793[var5].length) {
                  var4.method1439(field2183[var5], class38.field793[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1102960876"
   )
   public static char method3079(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }
}
