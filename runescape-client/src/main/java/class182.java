import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public abstract class class182 {
   @ObfuscatedName("x")
   int[] field2683;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1451783767
   )
   int field2684;
   @ObfuscatedName("a")
   class122 field2685;
   @ObfuscatedName("f")
   int[] field2686;
   @ObfuscatedName("c")
   int[] field2687;
   @ObfuscatedName("d")
   int[] field2688;
   @ObfuscatedName("l")
   int[][] field2689;
   @ObfuscatedName("g")
   int[][] field2690;
   @ObfuscatedName("z")
   class122[] field2691;
   @ObfuscatedName("m")
   Object[][] field2693;
   @ObfuscatedName("q")
   static class146 field2694 = new class146();
   @ObfuscatedName("i")
   int[] field2695;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1894487035
   )
   static int field2696 = 0;
   @ObfuscatedName("j")
   boolean field2697;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1305594321
   )
   public int field2698;
   @ObfuscatedName("t")
   Object[] field2699;
   @ObfuscatedName("v")
   boolean field2702;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-15"
   )
   void method3260(byte[] var1) {
      int var2 = var1.length;
      int var3 = -1;

      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2073[(var3 ^ var1[var4]) & 255];
      }

      var3 = ~var3;
      this.field2698 = var3;
      Buffer var5 = new Buffer(class8.method113(var1));
      var3 = var5.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var5.method2780();
         }

         var4 = var5.readUnsignedByte();
         if(var3 >= 7) {
            this.field2684 = var5.method2758();
         } else {
            this.field2684 = var5.readUnsignedShort();
         }

         int var6 = 0;
         int var7 = -1;
         this.field2683 = new int[this.field2684];
         int var8;
         if(var3 >= 7) {
            for(var8 = 0; var8 < this.field2684; ++var8) {
               this.field2683[var8] = var6 += var5.method2758();
               if(this.field2683[var8] > var7) {
                  var7 = this.field2683[var8];
               }
            }
         } else {
            for(var8 = 0; var8 < this.field2684; ++var8) {
               this.field2683[var8] = var6 += var5.readUnsignedShort();
               if(this.field2683[var8] > var7) {
                  var7 = this.field2683[var8];
               }
            }
         }

         this.field2686 = new int[1 + var7];
         this.field2687 = new int[1 + var7];
         this.field2688 = new int[1 + var7];
         this.field2689 = new int[1 + var7][];
         this.field2699 = new Object[var7 + 1];
         this.field2693 = new Object[var7 + 1][];
         if(var4 != 0) {
            this.field2695 = new int[1 + var7];

            for(var8 = 0; var8 < this.field2684; ++var8) {
               this.field2695[this.field2683[var8]] = var5.method2780();
            }

            this.field2685 = new class122(this.field2695);
         }

         for(var8 = 0; var8 < this.field2684; ++var8) {
            this.field2686[this.field2683[var8]] = var5.method2780();
         }

         for(var8 = 0; var8 < this.field2684; ++var8) {
            this.field2687[this.field2683[var8]] = var5.method2780();
         }

         for(var8 = 0; var8 < this.field2684; ++var8) {
            this.field2688[this.field2683[var8]] = var5.readUnsignedShort();
         }

         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(var3 >= 7) {
            for(var8 = 0; var8 < this.field2684; ++var8) {
               var9 = this.field2683[var8];
               var10 = this.field2688[var9];
               var6 = 0;
               var11 = -1;
               this.field2689[var9] = new int[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var13 = this.field2689[var9][var12] = var6 += var5.method2758();
                  if(var13 > var11) {
                     var11 = var13;
                  }
               }

               this.field2693[var9] = new Object[var11 + 1];
            }
         } else {
            for(var8 = 0; var8 < this.field2684; ++var8) {
               var9 = this.field2683[var8];
               var10 = this.field2688[var9];
               var6 = 0;
               var11 = -1;
               this.field2689[var9] = new int[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var13 = this.field2689[var9][var12] = var6 += var5.readUnsignedShort();
                  if(var13 > var11) {
                     var11 = var13;
                  }
               }

               this.field2693[var9] = new Object[1 + var11];
            }
         }

         if(var4 != 0) {
            this.field2690 = new int[var7 + 1][];
            this.field2691 = new class122[1 + var7];

            for(var8 = 0; var8 < this.field2684; ++var8) {
               var9 = this.field2683[var8];
               var10 = this.field2688[var9];
               this.field2690[var9] = new int[this.field2693[var9].length];

               for(var11 = 0; var11 < var10; ++var11) {
                  this.field2690[var9][this.field2689[var9][var11]] = var5.method2780();
               }

               this.field2691[var9] = new class122(this.field2690[var9]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "50383799"
   )
   void vmethod3370(int var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "9"
   )
   public boolean method3263(String var1) {
      int var2 = this.method3277("");
      return var2 != -1?this.method3280("", var1):this.method3280(var1, "");
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-278856524"
   )
   public boolean method3264(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2693.length && null != this.field2693[var1] && var2 >= 0 && var2 < this.field2693[var1].length) {
         if(this.field2693[var1][var2] != null) {
            return true;
         } else if(null != this.field2699[var1]) {
            return true;
         } else {
            this.vmethod3358(var1);
            return null != this.field2699[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1898425318"
   )
   public byte[] method3267(int var1) {
      if(this.field2693.length == 1) {
         return this.method3272(0, var1);
      } else if(this.field2693[var1].length == 1) {
         return this.method3272(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-799308531"
   )
   public byte[] method3268(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2693.length && null != this.field2693[var1] && var2 >= 0 && var2 < this.field2693[var1].length) {
         if(null == this.field2693[var1][var2]) {
            boolean var3 = this.method3276(var1, (int[])null);
            if(!var3) {
               this.vmethod3358(var1);
               var3 = this.method3276(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class137.method2461(this.field2693[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1441724796"
   )
   void vmethod3358(int var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1892393787"
   )
   public byte[] method3272(int var1, int var2) {
      return this.method3332(var1, var2, (int[])null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1296116450"
   )
   public void method3274(int var1) {
      for(int var2 = 0; var2 < this.field2693[var1].length; ++var2) {
         this.field2693[var1][var2] = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2070880692"
   )
   public void method3275() {
      for(int var1 = 0; var1 < this.field2693.length; ++var1) {
         if(null != this.field2693[var1]) {
            for(int var2 = 0; var2 < this.field2693[var1].length; ++var2) {
               this.field2693[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[IS)Z",
      garbageValue = "20175"
   )
   boolean method3276(int var1, int[] var2) {
      if(this.field2699[var1] == null) {
         return false;
      } else {
         int var3 = this.field2688[var1];
         int[] var4 = this.field2689[var1];
         Object[] var5 = this.field2693[var1];
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
            if(null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class137.method2461(this.field2699[var1], false);
            } else {
               var18 = class137.method2461(this.field2699[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2795(var2, 5, var8.payload.length);
            }

            byte[] var19 = class8.method113(var18);
            if(this.field2702) {
               this.field2699[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= 4 * var10 * var3;
               Buffer var11 = new Buffer(var19);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var13;
               int var14;
               for(int var15 = 0; var15 < var10; ++var15) {
                  var13 = 0;

                  for(var14 = 0; var14 < var3; ++var14) {
                     var13 += var11.method2780();
                     var12[var14] += var13;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var13 = 0; var13 < var3; ++var13) {
                  var20[var13] = new byte[var12[var13]];
                  var12[var13] = 0;
               }

               var11.offset = var9;
               var13 = 0;

               for(var14 = 0; var14 < var10; ++var14) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2780();
                     System.arraycopy(var19, var13, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var13 += var16;
                  }
               }

               for(var14 = 0; var14 < var3; ++var14) {
                  if(!this.field2697) {
                     var5[var4[var14]] = class116.method2221(var20[var14], false);
                  } else {
                     var5[var4[var14]] = var20[var14];
                  }
               }
            } else if(!this.field2697) {
               var5[var4[0]] = class116.method2221(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1749805767"
   )
   public int method3277(String var1) {
      var1 = var1.toLowerCase();
      return this.field2685.method2315(class177.method3249(var1));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "-38"
   )
   public int method3278(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2691[var1].method2315(class177.method3249(var2));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "1830273411"
   )
   public byte[] method3279(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2685.method2315(class177.method3249(var1));
      int var4 = this.field2691[var3].method2315(class177.method3249(var2));
      return this.method3272(var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "43"
   )
   public boolean method3280(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2685.method2315(class177.method3249(var1));
      int var4 = this.field2691[var3].method2315(class177.method3249(var2));
      return this.method3264(var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1198877465"
   )
   public void method3281(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2685.method2315(class177.method3249(var1));
      if(var2 >= 0) {
         this.vmethod3370(var2);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1296485196"
   )
   public boolean method3282() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2683.length; ++var2) {
         int var3 = this.field2683[var2];
         if(this.field2699[var3] == null) {
            this.vmethod3358(var3);
            if(this.field2699[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2070569552"
   )
   public boolean method3290(int var1) {
      if(null != this.field2699[var1]) {
         return true;
      } else {
         this.vmethod3358(var1);
         return this.field2699[var1] != null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1687114700"
   )
   public int method3291() {
      return this.field2693.length;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1894223592"
   )
   public byte[] method3311(int var1) {
      if(this.field2693.length == 1) {
         return this.method3268(0, var1);
      } else if(this.field2693[var1].length == 1) {
         return this.method3268(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   class182(boolean var1, boolean var2) {
      this.field2702 = var1;
      this.field2697 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-32"
   )
   public int[] method3314(int var1) {
      return this.field2689[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "4032"
   )
   public int method3323(int var1) {
      return this.field2693[var1].length;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "1125560376"
   )
   public byte[] method3332(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2693.length && this.field2693[var1] != null && var2 >= 0 && var2 < this.field2693[var1].length) {
         if(this.field2693[var1][var2] == null) {
            boolean var4 = this.method3276(var1, var3);
            if(!var4) {
               this.vmethod3358(var1);
               var4 = this.method3276(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class137.method2461(this.field2693[var1][var2], false);
         if(this.field2697) {
            this.field2693[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "1447"
   )
   static int method3335() {
      return Client.isResized?2:1;
   }
}
