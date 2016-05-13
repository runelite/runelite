import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public abstract class class167 {
   @ObfuscatedName("k")
   int[][] field2677;
   @ObfuscatedName("b")
   int[][] field2678;
   @ObfuscatedName("p")
   int[] field2679;
   @ObfuscatedName("j")
   int[] field2680;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 122955843
   )
   static int field2681 = 0;
   @ObfuscatedName("u")
   int[] field2682;
   @ObfuscatedName("d")
   int[] field2684;
   @ObfuscatedName("x")
   class192 field2685;
   @ObfuscatedName("c")
   class192[] field2686;
   @ObfuscatedName("l")
   Object[] field2687;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1681821311
   )
   int field2688;
   @ObfuscatedName("i")
   static class116 field2689 = new class116();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -907441961
   )
   public int field2690;
   @ObfuscatedName("m")
   boolean field2691;
   @ObfuscatedName("e")
   boolean field2692;
   @ObfuscatedName("t")
   Object[][] field2693;
   @ObfuscatedName("o")
   int[] field2696;
   @ObfuscatedName("ca")
   static class143 field2697;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "8"
   )
   public void method3237(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2685.method3740(class101.method2264(var1));
      if(var2 >= 0) {
         this.vmethod3311(var2);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-114"
   )
   public boolean method3238() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2680.length; ++var2) {
         int var3 = this.field2680[var2];
         if(null == this.field2687[var3]) {
            this.vmethod3324(var3);
            if(null == this.field2687[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-979042513"
   )
   public byte[] method3239(int var1, int var2) {
      return this.method3240(var1, var2, (int[])null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "17"
   )
   public byte[] method3240(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2693.length && this.field2693[var1] != null && var2 >= 0 && var2 < this.field2693[var1].length) {
         if(null == this.field2693[var1][var2]) {
            boolean var4 = this.method3242(var1, var3);
            if(!var4) {
               this.vmethod3324(var1);
               var4 = this.method3242(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class4.method39(this.field2693[var1][var2], false);
         if(this.field2692) {
            this.field2693[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "-87"
   )
   boolean method3242(int var1, int[] var2) {
      if(this.field2687[var1] == null) {
         return false;
      } else {
         int var3 = this.field2696[var1];
         int[] var4 = this.field2678[var1];
         Object[] var5 = this.field2693[var1];
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
            if(null == var2 || var2[0] == 0 && 0 == var2[1] && 0 == var2[2] && 0 == var2[3]) {
               var18 = class4.method39(this.field2687[var1], false);
            } else {
               var18 = class4.method39(this.field2687[var1], true);
               class119 var8 = new class119(var18);
               var8.method2581(var2, 5, var8.field2007.length);
            }

            byte[] var19 = class17.method205(var18);
            if(this.field2691) {
               this.field2687[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= 4 * var10 * var3;
               class119 var11 = new class119(var19);
               int[] var12 = new int[var3];
               var11.field2005 = var9;

               int var13;
               int var14;
               for(int var15 = 0; var15 < var10; ++var15) {
                  var13 = 0;

                  for(var14 = 0; var14 < var3; ++var14) {
                     var13 += var11.method2497();
                     var12[var14] += var13;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var13 = 0; var13 < var3; ++var13) {
                  var20[var13] = new byte[var12[var13]];
                  var12[var13] = 0;
               }

               var11.field2005 = var9;
               var13 = 0;

               for(var14 = 0; var14 < var10; ++var14) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2497();
                     System.arraycopy(var19, var13, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var13 += var16;
                  }
               }

               for(var14 = 0; var14 < var3; ++var14) {
                  if(!this.field2692) {
                     var5[var4[var14]] = class148.method3115(var20[var14], false);
                  } else {
                     var5[var4[var14]] = var20[var14];
                  }
               }
            } else if(!this.field2692) {
               var5[var4[0]] = class148.method3115(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-493742797"
   )
   public byte[] method3244(int var1) {
      if(1 == this.field2693.length) {
         return this.method3239(0, var1);
      } else if(1 == this.field2693[var1].length) {
         return this.method3239(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2125267106"
   )
   void vmethod3311(int var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2088874602"
   )
   public int method3249(int var1) {
      return this.field2693[var1].length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-54"
   )
   public int method3250() {
      return this.field2693.length;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1480596243"
   )
   public void method3252() {
      for(int var1 = 0; var1 < this.field2693.length; ++var1) {
         if(null != this.field2693[var1]) {
            for(int var2 = 0; var2 < this.field2693[var1].length; ++var2) {
               this.field2693[var1][var2] = null;
            }
         }
      }

   }

   class167(boolean var1, boolean var2) {
      this.field2691 = var1;
      this.field2692 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-14"
   )
   public int method3253(String var1) {
      var1 = var1.toLowerCase();
      return this.field2685.method3740(class101.method2264(var1));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1136681799"
   )
   public int method3254(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2686[var1].method3740(class101.method2264(var2));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "2119889601"
   )
   public byte[] method3255(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2685.method3740(class101.method2264(var1));
      int var4 = this.field2686[var3].method3740(class101.method2264(var2));
      return this.method3239(var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "207"
   )
   void vmethod3324(int var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-2020608505"
   )
   public boolean method3257(String var1) {
      int var2 = this.method3253("");
      return -1 != var2?this.method3293("", var1):this.method3293(var1, "");
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1385232458"
   )
   static final void method3266(class173 var0, int var1, int var2) {
      if(1 == var0.field2837) {
         class14.method175(var0.field2882, "", 24, 0, 0, var0.field2826);
      }

      String var3;
      int var4;
      int var5;
      if(2 == var0.field2837 && !client.field432) {
         var5 = class48.method962(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var3 = null;
         } else if(null != var0.field2844 && var0.field2844.trim().length() != 0) {
            var3 = var0.field2844;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class14.method175(var3, class12.method163('\uff00') + var0.field2881, 25, 0, -1, var0.field2826);
         }
      }

      if(3 == var0.field2837) {
         class14.method175("Close", "", 26, 0, 0, var0.field2826);
      }

      if(4 == var0.field2837) {
         class14.method175(var0.field2882, "", 28, 0, 0, var0.field2826);
      }

      if(5 == var0.field2837) {
         class14.method175(var0.field2882, "", 29, 0, 0, var0.field2826);
      }

      if(var0.field2837 == 6 && client.field441 == null) {
         class14.method175(var0.field2882, "", 30, 0, -1, var0.field2826);
      }

      int var6;
      int var7;
      if(2 == var0.field2767) {
         var7 = 0;

         for(var4 = 0; var4 < var0.field2781; ++var4) {
            for(var5 = 0; var5 < var0.field2886; ++var5) {
               var6 = (32 + var0.field2831) * var5;
               int var8 = (32 + var0.field2832) * var4;
               if(var7 < 20) {
                  var6 += var0.field2835[var7];
                  var8 += var0.field2876[var7];
               }

               if(var1 >= var6 && var2 >= var8 && var1 < 32 + var6 && var2 < 32 + var8) {
                  client.field296 = var7;
                  class25.field642 = var0;
                  if(var0.field2883[var7] > 0) {
                     label318: {
                        class51 var9 = class9.method128(var0.field2883[var7] - 1);
                        boolean var10;
                        int var11;
                        if(1 == client.field430) {
                           var11 = class48.method962(var0);
                           var10 = 0 != (var11 >> 30 & 1);
                           if(var10) {
                              if(class209.field3127 != var0.field2826 || var7 != class162.field2657) {
                                 class14.method175("Use", client.field431 + " " + "->" + " " + class12.method163(16748608) + var9.field1128, 31, var9.field1114, var7, var0.field2826);
                              }
                              break label318;
                           }
                        }

                        if(client.field432) {
                           var11 = class48.method962(var0);
                           var10 = (var11 >> 30 & 1) != 0;
                           if(var10) {
                              if(16 == (class89.field1555 & 16)) {
                                 class14.method175(client.field435, client.field436 + " " + "->" + " " + class12.method163(16748608) + var9.field1128, 32, var9.field1114, var7, var0.field2826);
                              }
                              break label318;
                           }
                        }

                        String[] var12 = var9.field1124;
                        if(client.field448) {
                           var12 = class49.method976(var12);
                        }

                        int var13 = class48.method962(var0);
                        boolean var14 = (var13 >> 30 & 1) != 0;
                        int var15;
                        if(var14) {
                           for(var15 = 4; var15 >= 3; --var15) {
                              if(var12 != null && var12[var15] != null) {
                                 byte var16;
                                 if(var15 == 3) {
                                    var16 = 36;
                                 } else {
                                    var16 = 37;
                                 }

                                 class14.method175(var12[var15], class12.method163(16748608) + var9.field1128, var16, var9.field1114, var7, var0.field2826);
                              } else if(var15 == 4) {
                                 class14.method175("Drop", class12.method163(16748608) + var9.field1128, 37, var9.field1114, var7, var0.field2826);
                              }
                           }
                        }

                        var15 = class48.method962(var0);
                        boolean var23 = 0 != (var15 >> 31 & 1);
                        if(var23) {
                           class14.method175("Use", class12.method163(16748608) + var9.field1128, 38, var9.field1114, var7, var0.field2826);
                        }

                        int var17 = class48.method962(var0);
                        boolean var18 = 0 != (var17 >> 30 & 1);
                        int var19;
                        byte var20;
                        if(var18 && null != var12) {
                           for(var19 = 2; var19 >= 0; --var19) {
                              if(null != var12[var19]) {
                                 var20 = 0;
                                 if(0 == var19) {
                                    var20 = 33;
                                 }

                                 if(1 == var19) {
                                    var20 = 34;
                                 }

                                 if(2 == var19) {
                                    var20 = 35;
                                 }

                                 class14.method175(var12[var19], class12.method163(16748608) + var9.field1128, var20, var9.field1114, var7, var0.field2826);
                              }
                           }
                        }

                        var12 = var0.field2836;
                        if(client.field448) {
                           var12 = class49.method976(var12);
                        }

                        if(null != var12) {
                           for(var19 = 4; var19 >= 0; --var19) {
                              if(null != var12[var19]) {
                                 var20 = 0;
                                 if(0 == var19) {
                                    var20 = 39;
                                 }

                                 if(1 == var19) {
                                    var20 = 40;
                                 }

                                 if(var19 == 2) {
                                    var20 = 41;
                                 }

                                 if(var19 == 3) {
                                    var20 = 42;
                                 }

                                 if(4 == var19) {
                                    var20 = 43;
                                 }

                                 class14.method175(var12[var19], class12.method163(16748608) + var9.field1128, var20, var9.field1114, var7, var0.field2826);
                              }
                           }
                        }

                        class14.method175("Examine", class12.method163(16748608) + var9.field1128, 1005, var9.field1114, var7, var0.field2826);
                     }
                  }
               }

               ++var7;
            }
         }
      }

      if(var0.field2764) {
         boolean var21;
         if(client.field432) {
            var4 = class48.method962(var0);
            var21 = 0 != (var4 >> 21 & 1);
            if(var21 && 32 == (class89.field1555 & 32)) {
               class14.method175(client.field435, client.field436 + " " + "->" + " " + var0.field2789, 58, 0, var0.field2766, var0.field2826);
            }
         } else {
            String var22;
            for(var7 = 9; var7 >= 5; --var7) {
               var22 = class15.method192(var0, var7);
               if(null != var22) {
                  class14.method175(var22, var0.field2789, 1007, 1 + var7, var0.field2766, var0.field2826);
               }
            }

            var5 = class48.method962(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var3 = null;
            } else if(null != var0.field2844 && var0.field2844.trim().length() != 0) {
               var3 = var0.field2844;
            } else {
               var3 = null;
            }

            for(var5 = 4; var5 >= 0; --var5) {
               var22 = class15.method192(var0, var5);
               if(var22 != null) {
                  class14.method175(var22, var0.field2789, 57, 1 + var5, var0.field2766, var0.field2826);
               }
            }

            var6 = class48.method962(var0);
            var21 = 0 != (var6 & 1);
            if(var21) {
               class14.method175("Continue", "", 30, 0, var0.field2766, var0.field2826);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   public boolean method3272(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2693.length && null != this.field2693[var1] && var2 >= 0 && var2 < this.field2693[var1].length) {
         if(null != this.field2693[var1][var2]) {
            return true;
         } else if(null != this.field2687[var1]) {
            return true;
         } else {
            this.vmethod3324(var1);
            return this.field2687[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-259425493"
   )
   void method3279(byte[] var1) {
      int var2 = var1.length;
      int var3 = class14.method176(var1, 0, var2);
      this.field2690 = var3;
      class119 var4 = new class119(class17.method205(var1));
      int var5 = var4.method2492();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2497();
         }

         int var6 = var4.method2492();
         if(var5 >= 7) {
            this.field2688 = var4.method2506();
         } else {
            this.field2688 = var4.method2584();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2680 = new int[this.field2688];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2688; ++var9) {
               this.field2680[var9] = var7 += var4.method2506();
               if(this.field2680[var9] > var8) {
                  var8 = this.field2680[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2688; ++var9) {
               this.field2680[var9] = var7 += var4.method2584();
               if(this.field2680[var9] > var8) {
                  var8 = this.field2680[var9];
               }
            }
         }

         this.field2684 = new int[1 + var8];
         this.field2682 = new int[1 + var8];
         this.field2696 = new int[1 + var8];
         this.field2678 = new int[var8 + 1][];
         this.field2687 = new Object[1 + var8];
         this.field2693 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2679 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2688; ++var9) {
               this.field2679[this.field2680[var9]] = var4.method2497();
            }

            this.field2685 = new class192(this.field2679);
         }

         for(var9 = 0; var9 < this.field2688; ++var9) {
            this.field2684[this.field2680[var9]] = var4.method2497();
         }

         for(var9 = 0; var9 < this.field2688; ++var9) {
            this.field2682[this.field2680[var9]] = var4.method2497();
         }

         for(var9 = 0; var9 < this.field2688; ++var9) {
            this.field2696[this.field2680[var9]] = var4.method2584();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2688; ++var9) {
               var10 = this.field2680[var9];
               var11 = this.field2696[var10];
               var7 = 0;
               var12 = -1;
               this.field2678[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2678[var10][var13] = var7 += var4.method2506();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2693[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2688; ++var9) {
               var10 = this.field2680[var9];
               var11 = this.field2696[var10];
               var7 = 0;
               var12 = -1;
               this.field2678[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2678[var10][var13] = var7 += var4.method2584();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2693[var10] = new Object[var12 + 1];
            }
         }

         if(0 != var6) {
            this.field2677 = new int[var8 + 1][];
            this.field2686 = new class192[1 + var8];

            for(var9 = 0; var9 < this.field2688; ++var9) {
               var10 = this.field2680[var9];
               var11 = this.field2696[var10];
               this.field2677[var10] = new int[this.field2693[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2677[var10][this.field2678[var10][var12]] = var4.method2497();
               }

               this.field2686[var10] = new class192(this.field2677[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1621056055"
   )
   public int[] method3281(int var1) {
      return this.field2678[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "30"
   )
   public byte[] method3283(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2693.length && this.field2693[var1] != null && var2 >= 0 && var2 < this.field2693[var1].length) {
         if(null == this.field2693[var1][var2]) {
            boolean var3 = this.method3242(var1, (int[])null);
            if(!var3) {
               this.vmethod3324(var1);
               var3 = this.method3242(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class4.method39(this.field2693[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2062249563"
   )
   public byte[] method3290(int var1) {
      if(1 == this.field2693.length) {
         return this.method3283(0, var1);
      } else if(this.field2693[var1].length == 1) {
         return this.method3283(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1578417081"
   )
   public boolean method3293(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2685.method3740(class101.method2264(var1));
      int var4 = this.field2686[var3].method3740(class101.method2264(var2));
      return this.method3272(var3, var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2132971358"
   )
   public boolean method3294(int var1) {
      if(this.field2687[var1] != null) {
         return true;
      } else {
         this.vmethod3324(var1);
         return null != this.field2687[var1];
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-5300"
   )
   public void method3309(int var1) {
      for(int var2 = 0; var2 < this.field2693[var1].length; ++var2) {
         this.field2693[var1][var2] = null;
      }

   }
}
