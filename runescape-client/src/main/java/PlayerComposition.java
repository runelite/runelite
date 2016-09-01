import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("d")
   static final int[] field2969 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1896598109
   )
   public int field2970;
   @ObfuscatedName("j")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("r")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 7882427779661274625L
   )
   long field2974;
   @ObfuscatedName("l")
   public static short[] field2975;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 7036417319745581489L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("v")
   static NodeCache field2977 = new NodeCache(260);
   @ObfuscatedName("x")
   @Export("bodyParts")
   int[] bodyParts;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-124954627"
   )
   public void method3499(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.bodyParts[field2969[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field1034 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field1034) {
                     var3 = 0;
                  }
               }

               var4 = class13.getKitDefinition(var3);
            } while(null == var4 || var4.field1043 || var4.field1033 != var1 + (this.isFemale?7:0));

            this.bodyParts[field2969[var1]] = var3 + 256;
            this.method3524();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "97"
   )
   public void method3500(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = XClanMember.field624[var1].length - 1;
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
            if(var3 >= XClanMember.field624[var1].length) {
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
      this.method3524();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "314229132"
   )
   public void method3501(boolean var1) {
      if(this.isFemale != var1) {
         this.method3514((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "268576836"
   )
   public void method3502(Buffer var1) {
      var1.method2715(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.bodyParts[field2969[var2]];
         if(var3 == 0) {
            var1.method2715(-1);
         } else {
            var1.method2715(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2715(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1072277075"
   )
   public Model method3503(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2970 != -1) {
         return GroundObject.getNpcDefinition(this.field2970).method777(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.bodyParts;
         if(null != var1 && (var1.field1005 >= 0 || var1.field993 >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.bodyParts[var15];
            }

            if(var1.field1005 >= 0) {
               var5 += (long)(var1.field1005 - this.bodyParts[5] << 40);
               var7[5] = var1.field1005;
            }

            if(var1.field993 >= 0) {
               var5 += (long)(var1.field993 - this.bodyParts[3] << 48);
               var7[3] = var1.field993;
            }
         }

         Model var8 = (Model)field2977.get(var5);
         if(null == var8) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class13.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !MessageNode.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2974) {
                  var8 = (Model)field2977.get(this.field2974);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(null == var8) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var17 = 0; var17 < 12; ++var17) {
                  var13 = var7[var17];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class13.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = MessageNode.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var12 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < XClanMember.field624[var13].length) {
                     var12.method2337(field2975[var13], XClanMember.field624[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class12.field185[var13].length) {
                     var12.method2337(class165.field2712[var13], class12.field185[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var12.method2290(64, 850, -30, -50, -30);
               field2977.put(var8, var5);
               this.field2974 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var8;
         } else {
            Model var18;
            if(var1 != null && null != var3) {
               var18 = var1.method880(var8, var2, var3, var4);
            } else if(var1 != null) {
               var18 = var1.method864(var8, var2);
            } else {
               var18 = var3.method864(var8, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "5"
   )
   ModelData method3504() {
      if(this.field2970 != -1) {
         return GroundObject.getNpcDefinition(this.field2970).method778();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.bodyParts[var2];
            if(var3 >= 256 && var3 < 512 && !class13.getKitDefinition(var3 - 256).method927()) {
               var1 = true;
            }

            if(var3 >= 512 && !MessageNode.getItemDefinition(var3 - 512).method1110(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var8 = 0; var8 < 12; ++var8) {
               var5 = this.bodyParts[var8];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class13.getKitDefinition(var5 - 256).method932();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = MessageNode.getItemDefinition(var5 - 512).method1111(this.isFemale);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var4 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < XClanMember.field624[var5].length) {
                  var4.method2337(field2975[var5], XClanMember.field624[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class12.field185[var5].length) {
                  var4.method2337(class165.field2712[var5], class12.field185[var5][this.bodyPartColours[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "658171440"
   )
   public int method3505() {
      return this.field2970 == -1?(this.bodyParts[8] << 10) + (this.bodyParts[0] << 15) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.bodyParts[11] << 5) + this.bodyParts[1]:305419896 + GroundObject.getNpcDefinition(this.field2970).id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "1345956294"
   )
   public void method3514(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field1034; ++var6) {
               KitDefinition var7 = class13.getKitDefinition(var6);
               if(null != var7 && !var7.field1043 && var7.field1033 == var5 + (var3?7:0)) {
                  var1[field2969[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.bodyParts = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2970 = var4;
      this.method3524();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2140184019"
   )
   void method3524() {
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
      if(var1 != 0L && var1 != this.hash) {
         field2977.remove(var1);
      }

   }
}
