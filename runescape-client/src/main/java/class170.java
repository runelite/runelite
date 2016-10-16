import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public abstract class class170 {
   @ObfuscatedName("z")
   int[] field2718;
   @ObfuscatedName("t")
   int[] field2719;
   @ObfuscatedName("g")
   int[] field2720;
   @ObfuscatedName("y")
   class195 field2721;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1174312769
   )
   int field2722;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1854547083
   )
   static int field2723 = 0;
   @ObfuscatedName("m")
   int[] field2724;
   @ObfuscatedName("p")
   int[] field2725;
   @ObfuscatedName("k")
   int[][] field2726;
   @ObfuscatedName("h")
   class195[] field2727;
   @ObfuscatedName("f")
   int[][] field2728;
   @ObfuscatedName("w")
   Object[][] field2729;
   @ObfuscatedName("u")
   static class119 field2730 = new class119();
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2131986463
   )
   public int field2731;
   @ObfuscatedName("d")
   boolean field2732;
   @ObfuscatedName("r")
   Object[] field2733;
   @ObfuscatedName("a")
   boolean field2734;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "28"
   )
   void method3249(byte[] var1) {
      this.field2731 = Frames.method2267(var1, var1.length);
      Buffer var2 = new Buffer(class155.method3145(var1));
      int var3 = var2.method2481();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2526();
         }

         int var4 = var2.method2481();
         if(var3 >= 7) {
            this.field2722 = var2.method2495();
         } else {
            this.field2722 = var2.method2668();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2718 = new int[this.field2722];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2722; ++var7) {
               this.field2718[var7] = var5 += var2.method2495();
               if(this.field2718[var7] > var6) {
                  var6 = this.field2718[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2722; ++var7) {
               this.field2718[var7] = var5 += var2.method2668();
               if(this.field2718[var7] > var6) {
                  var6 = this.field2718[var7];
               }
            }
         }

         this.field2725 = new int[var6 + 1];
         this.field2720 = new int[var6 + 1];
         this.field2724 = new int[var6 + 1];
         this.field2728 = new int[1 + var6][];
         this.field2733 = new Object[1 + var6];
         this.field2729 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2719 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2722; ++var7) {
               this.field2719[this.field2718[var7]] = var2.method2526();
            }

            this.field2721 = new class195(this.field2719);
         }

         for(var7 = 0; var7 < this.field2722; ++var7) {
            this.field2725[this.field2718[var7]] = var2.method2526();
         }

         for(var7 = 0; var7 < this.field2722; ++var7) {
            this.field2720[this.field2718[var7]] = var2.method2526();
         }

         for(var7 = 0; var7 < this.field2722; ++var7) {
            this.field2724[this.field2718[var7]] = var2.method2668();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2722; ++var7) {
               var8 = this.field2718[var7];
               var9 = this.field2724[var8];
               var5 = 0;
               var10 = -1;
               this.field2728[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2728[var8][var11] = var5 += var2.method2495();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2729[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2722; ++var7) {
               var8 = this.field2718[var7];
               var9 = this.field2724[var8];
               var5 = 0;
               var10 = -1;
               this.field2728[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2728[var8][var11] = var5 += var2.method2668();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2729[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2726 = new int[var6 + 1][];
            this.field2727 = new class195[1 + var6];

            for(var7 = 0; var7 < this.field2722; ++var7) {
               var8 = this.field2718[var7];
               var9 = this.field2724[var8];
               this.field2726[var8] = new int[this.field2729[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2726[var8][this.field2728[var8][var10]] = var2.method2526();
               }

               this.field2727[var8] = new class195(this.field2726[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1822115260"
   )
   void vmethod3335(int var1) {
   }

   class170(boolean var1, boolean var2) {
      this.field2732 = var1;
      this.field2734 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "3"
   )
   public boolean method3252(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2729.length && null != this.field2729[var1] && var2 >= 0 && var2 < this.field2729[var1].length) {
         if(null != this.field2729[var1][var2]) {
            return true;
         } else if(null != this.field2733[var1]) {
            return true;
         } else {
            this.vmethod3355(var1);
            return null != this.field2733[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-758691452"
   )
   public boolean method3253(int var1) {
      if(this.field2733[var1] != null) {
         return true;
      } else {
         this.vmethod3355(var1);
         return this.field2733[var1] != null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-882297217"
   )
   public boolean method3254() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2718.length; ++var2) {
         int var3 = this.field2718[var2];
         if(this.field2733[var3] == null) {
            this.vmethod3355(var3);
            if(this.field2733[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "84204158"
   )
   public byte[] method3255(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2729.length && null != this.field2729[var1] && var2 >= 0 && var2 < this.field2729[var1].length) {
         if(this.field2729[var1][var2] == null) {
            boolean var3 = this.method3267(var1, (int[])null);
            if(!var3) {
               this.vmethod3355(var1);
               var3 = this.method3267(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = BufferProvider.method1696(this.field2729[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1804524597"
   )
   public byte[] method3257(int var1) {
      if(this.field2729.length == 1) {
         return this.method3255(0, var1);
      } else if(this.field2729[var1].length == 1) {
         return this.method3255(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "31902"
   )
   void vmethod3355(int var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-40541862"
   )
   public int method3260(int var1) {
      return this.field2729[var1].length;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1741237256"
   )
   public void method3262(int var1) {
      for(int var2 = 0; var2 < this.field2729[var1].length; ++var2) {
         this.field2729[var1][var2] = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "29892"
   )
   public void method3263() {
      for(int var1 = 0; var1 < this.field2729.length; ++var1) {
         if(this.field2729[var1] != null) {
            for(int var2 = 0; var2 < this.field2729[var1].length; ++var2) {
               this.field2729[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "1024"
   )
   public int method3265(String var1) {
      var1 = var1.toLowerCase();
      return this.field2721.method3735(class31.method682(var1));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)I",
      garbageValue = "18848"
   )
   public int method3266(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2727[var1].method3735(class31.method682(var2));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "2134193461"
   )
   boolean method3267(int var1, int[] var2) {
      if(null == this.field2733[var1]) {
         return false;
      } else {
         int var3 = this.field2724[var1];
         int[] var4 = this.field2728[var1];
         Object[] var5 = this.field2729[var1];
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
               var18 = BufferProvider.method1696(this.field2733[var1], false);
            } else {
               var18 = BufferProvider.method1696(this.field2733[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2501(var2, 5, var8.payload.length);
            }

            byte[] var20 = class155.method3145(var18);
            if(this.field2732) {
               this.field2733[var1] = null;
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
                     var14 += var11.method2526();
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
                     var16 += var11.method2526();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2734) {
                     var5[var4[var15]] = class134.method2841(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2734) {
               var5[var4[0]] = class134.method2841(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-672769021"
   )
   public boolean method3268(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2721.method3735(class31.method682(var1));
      int var4 = this.field2727[var3].method3735(class31.method682(var2));
      return this.method3252(var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-53"
   )
   public boolean method3269(String var1) {
      int var2 = this.method3265("");
      return var2 != -1?this.method3268("", var1):this.method3268(var1, "");
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   public void method3270(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2721.method3735(class31.method682(var1));
      if(var2 >= 0) {
         this.vmethod3335(var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-55"
   )
   public byte[] method3272(int var1, int var2) {
      return this.method3309(var1, var2, (int[])null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)[B",
      garbageValue = "480"
   )
   public byte[] method3273(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2721.method3735(class31.method682(var1));
      int var4 = this.field2727[var3].method3735(class31.method682(var2));
      return this.method3272(var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "2010779095"
   )
   public int[] method3282(int var1) {
      return this.field2728[var1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "926188007"
   )
   public byte[] method3302(int var1) {
      if(this.field2729.length == 1) {
         return this.method3272(0, var1);
      } else if(this.field2729[var1].length == 1) {
         return this.method3272(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1796880275"
   )
   public byte[] method3309(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2729.length && this.field2729[var1] != null && var2 >= 0 && var2 < this.field2729[var1].length) {
         if(this.field2729[var1][var2] == null) {
            boolean var5 = this.method3267(var1, var3);
            if(!var5) {
               this.vmethod3355(var1);
               var5 = this.method3267(var1, var3);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var4 = BufferProvider.method1696(this.field2729[var1][var2], false);
         if(this.field2734) {
            this.field2729[var1][var2] = null;
         }

         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "87"
   )
   public int method3327() {
      return this.field2729.length;
   }
}
