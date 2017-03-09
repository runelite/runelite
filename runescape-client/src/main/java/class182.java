import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public abstract class class182 {
   @ObfuscatedName("q")
   Object[][] field2697;
   @ObfuscatedName("j")
   int[] field2698;
   @ObfuscatedName("c")
   int[] field2699;
   @ObfuscatedName("d")
   class122 field2700;
   @ObfuscatedName("w")
   int[] field2701;
   @ObfuscatedName("k")
   int[][] field2702;
   @ObfuscatedName("u")
   int[] field2703;
   @ObfuscatedName("s")
   boolean field2704;
   @ObfuscatedName("g")
   int[][] field2705;
   @ObfuscatedName("y")
   class122[] field2706;
   @ObfuscatedName("e")
   Object[] field2707;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 537197027
   )
   static int field2708 = 0;
   @ObfuscatedName("v")
   static class146 field2709 = new class146();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1572855595
   )
   int field2710;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1212991875
   )
   public int field2711;
   @ObfuscatedName("r")
   boolean field2712;
   @ObfuscatedName("h")
   int[] field2713;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-795450219"
   )
   public void method3303(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2700.method2367(FrameMap.method1752(var1));
      if(var2 >= 0) {
         this.vmethod3407(var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1660977226"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2697.length && null != this.field2697[var1] && var2 >= 0 && var2 < this.field2697[var1].length) {
         if(this.field2697[var1][var2] == null) {
            boolean var5 = this.method3320(var1, var3);
            if(!var5) {
               this.vmethod3408(var1);
               var5 = this.method3320(var1, var3);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var4 = class85.method1750(this.field2697[var1][var2], false);
         if(this.field2712) {
            this.field2697[var1][var2] = null;
         }

         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2132467277"
   )
   void vmethod3407(int var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2027580240"
   )
   public boolean method3309(int var1) {
      if(this.field2707[var1] != null) {
         return true;
      } else {
         this.vmethod3408(var1);
         return null != this.field2707[var1];
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public boolean method3310() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2698.length; ++var2) {
         int var3 = this.field2698[var2];
         if(this.field2707[var3] == null) {
            this.vmethod3408(var3);
            if(this.field2707[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2062230571"
   )
   public byte[] method3311(int var1) {
      if(this.field2697.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2697[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1934300580"
   )
   public byte[] method3312(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2697.length && this.field2697[var1] != null && var2 >= 0 && var2 < this.field2697[var1].length) {
         if(this.field2697[var1][var2] == null) {
            boolean var3 = this.method3320(var1, (int[])null);
            if(!var3) {
               this.vmethod3408(var1);
               var3 = this.method3320(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class85.method1750(this.field2697[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1469150491"
   )
   public int[] method3313(int var1) {
      return this.field2702[var1];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1394759447"
   )
   public int method3316(int var1) {
      return this.field2697[var1].length;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-59"
   )
   public int method3317() {
      return this.field2697.length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1683784821"
   )
   public void method3318(int var1) {
      for(int var2 = 0; var2 < this.field2697[var1].length; ++var2) {
         this.field2697[var1][var2] = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1648875657"
   )
   boolean method3320(int var1, int[] var2) {
      if(this.field2707[var1] == null) {
         return false;
      } else {
         int var3 = this.field2703[var1];
         int[] var4 = this.field2702[var1];
         Object[] var5 = this.field2697[var1];
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
            if(null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class85.method1750(this.field2707[var1], false);
            } else {
               var18 = class85.method1750(this.field2707[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method3020(var2, 5, var8.payload.length);
            }

            byte[] var20 = class7.method93(var18);
            if(this.field2704) {
               this.field2707[var1] = null;
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
                     var14 += var11.readInt();
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
                     var16 += var11.readInt();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2712) {
                     var5[var4[var15]] = class38.method813(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2712) {
               var5[var4[0]] = class38.method813(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1206020006"
   )
   public int method3321(String var1) {
      var1 = var1.toLowerCase();
      return this.field2700.method2367(FrameMap.method1752(var1));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1901416159"
   )
   public int method3322(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2706[var1].method2367(FrameMap.method1752(var2));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "-16"
   )
   public byte[] method3323(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2700.method2367(FrameMap.method1752(var1));
      int var4 = this.field2706[var3].method2367(FrameMap.method1752(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "0"
   )
   public boolean method3324(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2700.method2367(FrameMap.method1752(var1));
      int var4 = this.field2706[var3].method2367(FrameMap.method1752(var2));
      return this.method3374(var3, var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "41"
   )
   public boolean method3325(String var1) {
      int var2 = this.method3321("");
      return var2 != -1?this.method3324("", var1):this.method3324(var1, "");
   }

   class182(boolean var1, boolean var2) {
      this.field2704 = var1;
      this.field2712 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1536173052"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1247222709"
   )
   public void method3340() {
      for(int var1 = 0; var1 < this.field2697.length; ++var1) {
         if(null != this.field2697[var1]) {
            for(int var2 = 0; var2 < this.field2697[var1].length; ++var2) {
               this.field2697[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1973735698"
   )
   public byte[] method3351(int var1) {
      if(this.field2697.length == 1) {
         return this.method3312(0, var1);
      } else if(this.field2697[var1].length == 1) {
         return this.method3312(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   void method3358(byte[] var1) {
      this.field2711 = class37.method808(var1, var1.length);
      Buffer var2 = new Buffer(class7.method93(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.field2710 = var2.method2845();
         } else {
            this.field2710 = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2698 = new int[this.field2710];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2710; ++var7) {
               this.field2698[var7] = var5 += var2.method2845();
               if(this.field2698[var7] > var6) {
                  var6 = this.field2698[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2710; ++var7) {
               this.field2698[var7] = var5 += var2.readUnsignedShort();
               if(this.field2698[var7] > var6) {
                  var6 = this.field2698[var7];
               }
            }
         }

         this.field2701 = new int[1 + var6];
         this.field2713 = new int[var6 + 1];
         this.field2703 = new int[1 + var6];
         this.field2702 = new int[var6 + 1][];
         this.field2707 = new Object[var6 + 1];
         this.field2697 = new Object[1 + var6][];
         if(var4 != 0) {
            this.field2699 = new int[1 + var6];

            for(var7 = 0; var7 < this.field2710; ++var7) {
               this.field2699[this.field2698[var7]] = var2.readInt();
            }

            this.field2700 = new class122(this.field2699);
         }

         for(var7 = 0; var7 < this.field2710; ++var7) {
            this.field2701[this.field2698[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field2710; ++var7) {
            this.field2713[this.field2698[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field2710; ++var7) {
            this.field2703[this.field2698[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2710; ++var7) {
               var8 = this.field2698[var7];
               var9 = this.field2703[var8];
               var5 = 0;
               var10 = -1;
               this.field2702[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2702[var8][var11] = var5 += var2.method2845();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2697[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2710; ++var7) {
               var8 = this.field2698[var7];
               var9 = this.field2703[var8];
               var5 = 0;
               var10 = -1;
               this.field2702[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2702[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2697[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2705 = new int[var6 + 1][];
            this.field2706 = new class122[1 + var6];

            for(var7 = 0; var7 < this.field2710; ++var7) {
               var8 = this.field2698[var7];
               var9 = this.field2703[var8];
               this.field2705[var8] = new int[this.field2697[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2705[var8][this.field2702[var8][var10]] = var2.readInt();
               }

               this.field2706[var8] = new class122(this.field2705[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "505541502"
   )
   void vmethod3408(int var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1234704736"
   )
   public boolean method3374(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2697.length && null != this.field2697[var1] && var2 >= 0 && var2 < this.field2697[var1].length) {
         if(this.field2697[var1][var2] != null) {
            return true;
         } else if(this.field2707[var1] != null) {
            return true;
         } else {
            this.vmethod3408(var1);
            return null != this.field2707[var1];
         }
      } else {
         return false;
      }
   }
}
