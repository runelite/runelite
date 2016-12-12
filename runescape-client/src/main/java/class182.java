import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public abstract class class182 {
   @ObfuscatedName("q")
   int[][] field2706;
   @ObfuscatedName("w")
   int[][] field2707;
   @ObfuscatedName("f")
   int[] field2708;
   @ObfuscatedName("k")
   class122 field2709;
   @ObfuscatedName("g")
   int[] field2710;
   @ObfuscatedName("v")
   class122[] field2711;
   @ObfuscatedName("a")
   int[] field2712;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -783461067
   )
   static int field2713 = 0;
   @ObfuscatedName("e")
   int[] field2715;
   @ObfuscatedName("n")
   int[] field2716;
   @ObfuscatedName("p")
   Object[][] field2717;
   @ObfuscatedName("h")
   Object[] field2718;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 155936937
   )
   public int field2719;
   @ObfuscatedName("m")
   boolean field2720;
   @ObfuscatedName("r")
   boolean field2721;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1852575197
   )
   int field2722;
   @ObfuscatedName("l")
   static class146 field2723 = new class146();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1893466822"
   )
   public boolean method3208(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2709.method2287(ItemLayer.method1450(var1));
      int var4 = this.field2711[var3].method2287(ItemLayer.method1450(var2));
      return this.method3213(var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "947685438"
   )
   void method3209(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.field2091[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.field2719 = var5;
      Buffer var15 = new Buffer(class116.method2200(var1));
      var5 = var15.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var15.method2844();
         }

         var6 = var15.readUnsignedByte();
         if(var5 >= 7) {
            this.field2722 = var15.method2773();
         } else {
            this.field2722 = var15.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2715 = new int[this.field2722];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               this.field2715[var9] = var7 += var15.method2773();
               if(this.field2715[var9] > var8) {
                  var8 = this.field2715[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               this.field2715[var9] = var7 += var15.readUnsignedShort();
               if(this.field2715[var9] > var8) {
                  var8 = this.field2715[var9];
               }
            }
         }

         this.field2710 = new int[1 + var8];
         this.field2716 = new int[1 + var8];
         this.field2712 = new int[1 + var8];
         this.field2706 = new int[var8 + 1][];
         this.field2718 = new Object[var8 + 1];
         this.field2717 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2708 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2722; ++var9) {
               this.field2708[this.field2715[var9]] = var15.method2844();
            }

            this.field2709 = new class122(this.field2708);
         }

         for(var9 = 0; var9 < this.field2722; ++var9) {
            this.field2710[this.field2715[var9]] = var15.method2844();
         }

         for(var9 = 0; var9 < this.field2722; ++var9) {
            this.field2716[this.field2715[var9]] = var15.method2844();
         }

         for(var9 = 0; var9 < this.field2722; ++var9) {
            this.field2712[this.field2715[var9]] = var15.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               var10 = this.field2715[var9];
               var11 = this.field2712[var10];
               var7 = 0;
               var12 = -1;
               this.field2706[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2706[var10][var13] = var7 += var15.method2773();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2717[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               var10 = this.field2715[var9];
               var11 = this.field2712[var10];
               var7 = 0;
               var12 = -1;
               this.field2706[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2706[var10][var13] = var7 += var15.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2717[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2707 = new int[1 + var8][];
            this.field2711 = new class122[var8 + 1];

            for(var9 = 0; var9 < this.field2722; ++var9) {
               var10 = this.field2715[var9];
               var11 = this.field2712[var10];
               this.field2707[var10] = new int[this.field2717[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2707[var10][this.field2706[var10][var12]] = var15.method2844();
               }

               this.field2711[var10] = new class122(this.field2707[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "116"
   )
   void vmethod3316(int var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1767952179"
   )
   public byte[] method3211(int var1, int var2) {
      return this.method3219(var1, var2, (int[])null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1108297494"
   )
   public byte[] method3212(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2717.length && null != this.field2717[var1] && var2 >= 0 && var2 < this.field2717[var1].length) {
         if(this.field2717[var1][var2] == null) {
            boolean var3 = this.method3224(var1, (int[])null);
            if(!var3) {
               this.vmethod3350(var1);
               var3 = this.method3224(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = BufferProvider.method3959(this.field2717[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "322821501"
   )
   public boolean method3213(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2717.length && null != this.field2717[var1] && var2 >= 0 && var2 < this.field2717[var1].length) {
         if(null != this.field2717[var1][var2]) {
            return true;
         } else if(this.field2718[var1] != null) {
            return true;
         } else {
            this.vmethod3350(var1);
            return this.field2718[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2091672991"
   )
   public boolean method3215() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2715.length; ++var2) {
         int var3 = this.field2715[var2];
         if(null == this.field2718[var3]) {
            this.vmethod3350(var3);
            if(null == this.field2718[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "4"
   )
   public byte[] method3216(int var1) {
      if(this.field2717.length == 1) {
         return this.method3211(0, var1);
      } else if(this.field2717[var1].length == 1) {
         return this.method3211(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   class182(boolean var1, boolean var2) {
      this.field2720 = var1;
      this.field2721 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "543917427"
   )
   public byte[] method3219(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2717.length && null != this.field2717[var1] && var2 >= 0 && var2 < this.field2717[var1].length) {
         if(null == this.field2717[var1][var2]) {
            boolean var4 = this.method3224(var1, var3);
            if(!var4) {
               this.vmethod3350(var1);
               var4 = this.method3224(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = BufferProvider.method3959(this.field2717[var1][var2], false);
         if(this.field2721) {
            this.field2717[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1761030392"
   )
   public int method3220(int var1) {
      return this.field2717[var1].length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1591380134"
   )
   public int method3221() {
      return this.field2717.length;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1689015031"
   )
   public void method3222(int var1) {
      for(int var2 = 0; var2 < this.field2717[var1].length; ++var2) {
         this.field2717[var1][var2] = null;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1122751447"
   )
   public void method3223() {
      for(int var1 = 0; var1 < this.field2717.length; ++var1) {
         if(null != this.field2717[var1]) {
            for(int var2 = 0; var2 < this.field2717[var1].length; ++var2) {
               this.field2717[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1001461605"
   )
   boolean method3224(int var1, int[] var2) {
      if(this.field2718[var1] == null) {
         return false;
      } else {
         int var3 = this.field2712[var1];
         int[] var4 = this.field2706[var1];
         Object[] var5 = this.field2717[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(null == var5[var4[var7]]) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = BufferProvider.method3959(this.field2718[var1], false);
            } else {
               var18 = BufferProvider.method3959(this.field2718[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2913(var2, 5, var8.payload.length);
            }

            byte[] var20 = class116.method2200(var18);
            if(this.field2720) {
               this.field2718[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= 4 * var10 * var3;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2844();
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
                     var16 += var11.method2844();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2721) {
                     var5[var4[var15]] = XItemContainer.method162(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2721) {
               var5[var4[0]] = XItemContainer.method162(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1868154600"
   )
   public int method3225(String var1) {
      var1 = var1.toLowerCase();
      return this.field2709.method2287(ItemLayer.method1450(var1));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-917970534"
   )
   public int method3226(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2711[var1].method2287(ItemLayer.method1450(var2));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-1669223984"
   )
   public byte[] method3228(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2709.method2287(ItemLayer.method1450(var1));
      int var4 = this.field2711[var3].method2287(ItemLayer.method1450(var2));
      return this.method3211(var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1873525972"
   )
   public boolean method3229(String var1) {
      int var2 = this.method3225("");
      return var2 != -1?this.method3208("", var1):this.method3208(var1, "");
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1118835249"
   )
   public void method3230(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2709.method2287(ItemLayer.method1450(var1));
      if(var2 >= 0) {
         this.vmethod3316(var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1709440151"
   )
   public byte[] method3282(int var1) {
      if(this.field2717.length == 1) {
         return this.method3212(0, var1);
      } else if(this.field2717[var1].length == 1) {
         return this.method3212(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "26636443"
   )
   public boolean method3284(int var1) {
      if(this.field2718[var1] != null) {
         return true;
      } else {
         this.vmethod3350(var1);
         return null != this.field2718[var1];
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-105"
   )
   void vmethod3350(int var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "120"
   )
   public int[] method3289(int var1) {
      return this.field2706[var1];
   }
}
