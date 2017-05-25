import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class43 {
   @ObfuscatedName("cm")
   static IndexData field559;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -605964265
   )
   int field561;
   @ObfuscatedName("q")
   int[][] field562;
   @ObfuscatedName("g")
   int[][] field563;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1756126691
   )
   int field564;
   @ObfuscatedName("u")
   int[][] field568;
   @ObfuscatedName("v")
   int[][] field569;

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "28"
   )
   static int method626(Widget var0) {
      class198 var1 = (class198)Client.widgetFlags.method3615(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.field2480:var0.field2714;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILFloorUnderlayDefinition;I)V",
      garbageValue = "1254078216"
   )
   void method627(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var2 + var3 >= 0) {
            if(var1 - var3 <= this.field561 && var2 - var3 <= this.field564) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field561, var1 + var3);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field564, var2 + var3);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field568[var9][var10] += var4.field3332 * 256 / var4.field3333;
                     this.field562[var9][var10] += var4.field3329;
                     this.field563[var9][var10] += var4.field3330;
                     ++this.field569[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1995372739"
   )
   int method628(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field561 && var2 < this.field564) {
         if(this.field563[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field568[var1][var2] / this.field569[var1][var2];
            int var4 = this.field562[var1][var2] / this.field569[var1][var2];
            int var5 = this.field563[var1][var2] / this.field569[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(0.0D != var9) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (var9 + 1.0D);
               } else {
                  var19 = var11 + var9 - var9 * var11;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = var7 + 0.3333333333333333D;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + var23 * 6.0D * (var19 - var21);
               } else if(var23 * 2.0D < 1.0D) {
                  var13 = var19;
               } else if(3.0D * var23 < 2.0D) {
                  var13 = (0.6666666666666666D - var23) * (var19 - var21) * 6.0D + var21;
               } else {
                  var13 = var21;
               }

               if(var7 * 6.0D < 1.0D) {
                  var15 = 6.0D * (var19 - var21) * var7 + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = var21 + 6.0D * (var19 - var21) * (0.6666666666666666D - var7);
               } else {
                  var15 = var21;
               }

               if(var27 * 6.0D < 1.0D) {
                  var17 = var21 + var27 * (var19 - var21) * 6.0D;
               } else if(var27 * 2.0D < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(256.0D * var13);
            int var20 = (int)(var15 * 256.0D);
            int var30 = (int)(256.0D * var17);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64"
   )
   class43(int var1, int var2) {
      this.field561 = var1;
      this.field564 = var2;
      this.field568 = new int[var1][var2];
      this.field562 = new int[var1][var2];
      this.field563 = new int[var1][var2];
      this.field569 = new int[var1][var2];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-1509025350"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field3431.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field3429.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field3436 = var0;
         if(var2 != null) {
            var1.method4580(new Buffer(var2));
         }

         var1.method4579();
         if(var1.isSolid) {
            var1.field3446 = 0;
            var1.field3447 = false;
         }

         ObjectComposition.field3431.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;I)V",
      garbageValue = "1395501540"
   )
   static void method637(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3226;
      synchronized(class236.field3226) {
         for(class233 var5 = (class233)class236.field3226.method3660(); var5 != null; var5 = (class233)class236.field3226.method3661()) {
            if((long)var0 == var5.hash && var5.field3192 == var1 && var5.field3190 == 0) {
               var3 = var5.field3191;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4297(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3058(var0);
         var2.method4297(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-168801939"
   )
   public static void method638(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3786 = var1.readUnsignedShort();
      class286.field3785 = new int[class286.field3786];
      class286.field3783 = new int[class286.field3786];
      class252.field3387 = new int[class286.field3786];
      class267.field3667 = new int[class286.field3786];
      MessageNode.field843 = new byte[class286.field3786][];
      var1.offset = var0.length - 7 - class286.field3786 * 8;
      class286.field3784 = var1.readUnsignedShort();
      class286.field3787 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3786; ++var3) {
         class286.field3785[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3786; ++var3) {
         class286.field3783[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3786; ++var3) {
         class252.field3387[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3786; ++var3) {
         class267.field3667[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3786 * 8 - (var2 - 1) * 3;
      class87.field1355 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class87.field1355[var3] = var1.read24BitInt();
         if(class87.field1355[var3] == 0) {
            class87.field1355[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3786; ++var3) {
         int var4 = class252.field3387[var3];
         int var5 = class267.field3667[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         MessageNode.field843[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
