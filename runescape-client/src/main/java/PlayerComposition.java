import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -33944471
   )
   public int field2035;
   @ObfuscatedName("bt")
   static class184 field2036;
   @ObfuscatedName("m")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("l")
   static NodeCache field2038 = new NodeCache(260);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 3891548641002172093L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("d")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("c")
   public static short[] field2041;
   @ObfuscatedName("q")
   static final int[] field2042 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("n")
   @Export("equipmentIds")
   int[] bodyParts;
   @ObfuscatedName("db")
   static int[] field2044;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -1999442801755686815L
   )
   long field2045;
   @ObfuscatedName("f")
   public static Buffer field2046;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-1178119315"
   )
   public void method2794(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field2818; ++var6) {
               KitDefinition var7 = class41.getKitDefinition(var6);
               if(var7 != null && !var7.field2828 && var7.field2822 == var5 + (var3?7:0)) {
                  var1[field2042[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2035 = var4;
      this.method2798();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZS)V",
      garbageValue = "2835"
   )
   public void method2795(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2042[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field2818 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field2818) {
                     var3 = 0;
                  }
               }

               var4 = class41.getKitDefinition(var3);
            } while(var4 == null || var4.field2828 || var4.field2822 != var1 + (this.isFemale?7:0));

            this.bodyParts[field2042[var1]] = var3 + 256;
            this.method2798();
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1444823004"
   )
   public void method2796(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class116.field1823[var1].length - 1;
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
            if(var3 >= class116.field1823[var1].length) {
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
      this.method2798();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "28769"
   )
   public void method2797(boolean var1) {
      if(var1 != this.isFemale) {
         this.method2794((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1212855025"
   )
   void method2798() {
      long var1 = this.hash;
      int var3 = this.bodyParts[5];
      int var4 = this.bodyParts[9];
      this.bodyParts[5] = var4;
      this.bodyParts[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.bodyParts[var5] >= 256) {
            this.hash += (long)(this.bodyParts[var5] - 256);
         }
      }

      if(this.bodyParts[0] >= 256) {
         this.hash += (long)(this.bodyParts[0] - 256 >> 4);
      }

      if(this.bodyParts[1] >= 256) {
         this.hash += (long)(this.bodyParts[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.bodyParts[5] = var3;
      this.bodyParts[9] = var4;
      if(0L != var1 && this.hash != var1) {
         field2038.remove(var1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-349319956"
   )
   public Model method2799(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2035 != -1) {
         return class152.getNpcDefinition(this.field2035).method3756(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(null != var1 && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.bodyParts[var8];
            }

            if(var1.leftHandItem >= 0) {
               var5 += (long)(var1.leftHandItem - this.bodyParts[5] << 40);
               var7[5] = var1.leftHandItem;
            }

            if(var1.rightHandItem >= 0) {
               var5 += (long)(var1.rightHandItem - this.bodyParts[3] << 48);
               var7[3] = var1.rightHandItem;
            }
         }

         Model var16 = (Model)field2038.get(var5);
         if(null == var16) {
            boolean var9 = false;

            int var11;
            for(int var17 = 0; var17 < 12; ++var17) {
               var11 = var7[var17];
               if(var11 >= 256 && var11 < 512 && !class41.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class18.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2045 != -1L) {
                  var16 = (Model)field2038.get(this.field2045);
               }

               if(null == var16) {
                  return null;
               }
            }

            if(var16 == null) {
               ModelData[] var10 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class41.getKitDefinition(var13 - 256).getModelData();
                     if(null != var14) {
                        var10[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class18.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(null != var14) {
                        var10[var11++] = var14;
                     }
                  }
               }

               ModelData var15 = new ModelData(var10, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class116.field1823[var13].length) {
                     var15.method1490(field2041[var13], class116.field1823[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class137.field1908[var13].length) {
                     var15.method1490(MessageNode.field235[var13], class137.field1908[var13][this.bodyPartColours[var13]]);
                  }
               }

               var16 = var15.method1512(64, 850, -30, -50, -30);
               field2038.put(var16, var5);
               this.field2045 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var16;
         } else {
            Model var18;
            if(null != var1 && var3 != null) {
               var18 = var1.method3807(var16, var2, var3, var4);
            } else if(null != var1) {
               var18 = var1.method3801(var16, var2);
            } else {
               var18 = var3.method3801(var16, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1492424410"
   )
   ModelData method2800() {
      if(this.field2035 != -1) {
         return class152.getNpcDefinition(this.field2035).method3748();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.bodyParts[var7];
            if(var3 >= 256 && var3 < 512 && !class41.getKitDefinition(var3 - 256).method3560()) {
               var1 = true;
            }

            if(var3 >= 512 && !class18.getItemDefinition(var3 - 512).method3710(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.bodyParts[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class41.getKitDefinition(var5 - 256).method3553();
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class18.getItemDefinition(var5 - 512).method3703(this.isFemale);
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class116.field1823[var5].length) {
                  var8.method1490(field2041[var5], class116.field1823[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class137.field1908[var5].length) {
                  var8.method1490(MessageNode.field235[var5], class137.field1908[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1423070896"
   )
   public int method2801() {
      return this.field2035 == -1?(this.bodyParts[0] << 15) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.bodyParts[8] << 10) + (this.bodyParts[11] << 5) + this.bodyParts[1]:305419896 + class152.getNpcDefinition(this.field2035).id;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1624870085"
   )
   static int method2822(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-991960101"
   )
   public static String method2823(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-728792676"
   )
   public void method2825(Buffer var1) {
      var1.method2975(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2042[var2]];
         if(var3 == 0) {
            var1.method2975(-1);
         } else {
            var1.method2975(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2975(this.bodyPartColours[var2]);
      }

   }
}
