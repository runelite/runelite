import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public abstract class class182 {
   @ObfuscatedName("c")
   int[] field2711;
   @ObfuscatedName("k")
   int[] field2712;
   @ObfuscatedName("f")
   int[] field2713;
   @ObfuscatedName("h")
   class122 field2714;
   @ObfuscatedName("a")
   int[] field2715;
   @ObfuscatedName("g")
   int[] field2716;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 798565143
   )
   public int field2717;
   @ObfuscatedName("u")
   int[][] field2718;
   @ObfuscatedName("b")
   int[][] field2719;
   @ObfuscatedName("x")
   class122[] field2720;
   @ObfuscatedName("r")
   Object[] field2721;
   @ObfuscatedName("m")
   static class146 field2723 = new class146();
   @ObfuscatedName("p")
   boolean field2724;
   @ObfuscatedName("w")
   boolean field2725;
   @ObfuscatedName("n")
   Object[][] field2726;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1491639197
   )
   int field2727;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1327898269
   )
   static int field2728 = 0;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   public void method3179(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2714.method2255(FileOnDisk.method1397(var1));
      if(var2 >= 0) {
         this.vmethod3271(var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-27"
   )
   void vmethod3271(int var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1934026985"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-820191958"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2726.length && null != this.field2726[var1] && var2 >= 0 && var2 < this.field2726[var1].length) {
         if(this.field2726[var1][var2] == null) {
            boolean var4 = this.method3196(var1, var3);
            if(!var4) {
               this.vmethod3269(var1);
               var4 = this.method3196(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = PlayerComposition.method3053(this.field2726[var1][var2], false);
         if(this.field2724) {
            this.field2726[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1474830503"
   )
   public boolean method3184(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2726.length && null != this.field2726[var1] && var2 >= 0 && var2 < this.field2726[var1].length) {
         if(null != this.field2726[var1][var2]) {
            return true;
         } else if(null != this.field2721[var1]) {
            return true;
         } else {
            this.vmethod3269(var1);
            return this.field2721[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-633932139"
   )
   public boolean method3185(int var1) {
      if(this.field2721[var1] != null) {
         return true;
      } else {
         this.vmethod3269(var1);
         return null != this.field2721[var1];
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1212544079"
   )
   public boolean method3186() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2711.length; ++var2) {
         int var3 = this.field2711[var2];
         if(null == this.field2721[var3]) {
            this.vmethod3269(var3);
            if(null == this.field2721[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1138215116"
   )
   public byte[] method3187(int var1) {
      if(this.field2726.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2726[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "4"
   )
   public byte[] method3189(int var1) {
      if(this.field2726.length == 1) {
         return this.method3237(0, var1);
      } else if(this.field2726[var1].length == 1) {
         return this.method3237(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "800597698"
   )
   public int[] method3191(int var1) {
      return this.field2718[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "8"
   )
   public int method3192(int var1) {
      return this.field2726[var1].length;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "761683379"
   )
   public void method3194(int var1) {
      for(int var2 = 0; var2 < this.field2726[var1].length; ++var2) {
         this.field2726[var1][var2] = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-351073061"
   )
   public void method3195() {
      for(int var1 = 0; var1 < this.field2726.length; ++var1) {
         if(null != this.field2726[var1]) {
            for(int var2 = 0; var2 < this.field2726[var1].length; ++var2) {
               this.field2726[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1913299915"
   )
   boolean method3196(int var1, int[] var2) {
      if(null == this.field2721[var1]) {
         return false;
      } else {
         int var3 = this.field2712[var1];
         int[] var4 = this.field2718[var1];
         Object[] var5 = this.field2726[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = PlayerComposition.method3053(this.field2721[var1], false);
            } else {
               var18 = PlayerComposition.method3053(this.field2721[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2742(var2, 5, var8.payload.length);
            }

            byte[] var20 = class49.method856(var18);
            if(this.field2725) {
               this.field2721[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2727();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2727();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2724) {
                     var5[var4[var15]] = class6.method73(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2724) {
               var5[var4[0]] = class6.method73(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "1"
   )
   public int method3197(String var1) {
      var1 = var1.toLowerCase();
      return this.field2714.method2255(FileOnDisk.method1397(var1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "5"
   )
   public int method3198(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2720[var1].method2255(FileOnDisk.method1397(var2));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-1854273157"
   )
   public byte[] method3199(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2714.method2255(FileOnDisk.method1397(var1));
      int var4 = this.field2720[var3].method2255(FileOnDisk.method1397(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1805661896"
   )
   public int method3205() {
      return this.field2726.length;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "96"
   )
   void vmethod3269(int var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "174581746"
   )
   static void method3224() {
      Object var0 = class183.field2732;
      synchronized(class183.field2732) {
         if(class183.field2731 == 0) {
            class22.field252.method1912(new class183(), 5);
         }

         class183.field2731 = 600;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1579640688"
   )
   public byte[] method3237(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2726.length && null != this.field2726[var1] && var2 >= 0 && var2 < this.field2726[var1].length) {
         if(this.field2726[var1][var2] == null) {
            boolean var3 = this.method3196(var1, (int[])null);
            if(!var3) {
               this.vmethod3269(var1);
               var3 = this.method3196(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = PlayerComposition.method3053(this.field2726[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "971890005"
   )
   public boolean method3238(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2714.method2255(FileOnDisk.method1397(var1));
      int var4 = this.field2720[var3].method2255(FileOnDisk.method1397(var2));
      return this.method3184(var3, var4);
   }

   class182(boolean var1, boolean var2) {
      this.field2725 = var1;
      this.field2724 = var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "103"
   )
   public boolean method3248(String var1) {
      int var2 = this.method3197("");
      return var2 != -1?this.method3238("", var1):this.method3238(var1, "");
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1219703292"
   )
   void method3253(byte[] var1) {
      this.field2717 = class25.method568(var1, var1.length);
      Buffer var2 = new Buffer(class49.method856(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2727();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.field2727 = var2.method2736();
         } else {
            this.field2727 = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2711 = new int[this.field2727];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               this.field2711[var7] = var5 += var2.method2736();
               if(this.field2711[var7] > var6) {
                  var6 = this.field2711[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               this.field2711[var7] = var5 += var2.readUnsignedShort();
               if(this.field2711[var7] > var6) {
                  var6 = this.field2711[var7];
               }
            }
         }

         this.field2715 = new int[1 + var6];
         this.field2716 = new int[1 + var6];
         this.field2712 = new int[var6 + 1];
         this.field2718 = new int[1 + var6][];
         this.field2721 = new Object[var6 + 1];
         this.field2726 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2713 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2727; ++var7) {
               this.field2713[this.field2711[var7]] = var2.method2727();
            }

            this.field2714 = new class122(this.field2713);
         }

         for(var7 = 0; var7 < this.field2727; ++var7) {
            this.field2715[this.field2711[var7]] = var2.method2727();
         }

         for(var7 = 0; var7 < this.field2727; ++var7) {
            this.field2716[this.field2711[var7]] = var2.method2727();
         }

         for(var7 = 0; var7 < this.field2727; ++var7) {
            this.field2712[this.field2711[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               var8 = this.field2711[var7];
               var9 = this.field2712[var8];
               var5 = 0;
               var10 = -1;
               this.field2718[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2718[var8][var11] = var5 += var2.method2736();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2726[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               var8 = this.field2711[var7];
               var9 = this.field2712[var8];
               var5 = 0;
               var10 = -1;
               this.field2718[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2718[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2726[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2719 = new int[var6 + 1][];
            this.field2720 = new class122[1 + var6];

            for(var7 = 0; var7 < this.field2727; ++var7) {
               var8 = this.field2711[var7];
               var9 = this.field2712[var8];
               this.field2719[var8] = new int[this.field2726[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2719[var8][this.field2718[var8][var10]] = var2.method2727();
               }

               this.field2720[var8] = new class122(this.field2719[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }
}
