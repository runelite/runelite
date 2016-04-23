import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public abstract class class167 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1476978515
   )
   static int field2661 = 0;
   @ObfuscatedName("h")
   int[] field2662;
   @ObfuscatedName("m")
   int[] field2663;
   @ObfuscatedName("a")
   static class116 field2664 = new class116();
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -51115
   )
   static int field2665;
   @ObfuscatedName("r")
   Object[][] field2666;
   @ObfuscatedName("i")
   int[] field2667;
   @ObfuscatedName("c")
   int[][] field2668;
   @ObfuscatedName("n")
   int[][] field2669;
   @ObfuscatedName("l")
   class192[] field2670;
   @ObfuscatedName("u")
   Object[] field2671;
   @ObfuscatedName("z")
   class192 field2672;
   @ObfuscatedName("x")
   int[] field2673;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1736375657
   )
   public int field2674;
   @ObfuscatedName("p")
   boolean field2675;
   @ObfuscatedName("q")
   boolean field2676;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1579706807
   )
   int field2679;
   @ObfuscatedName("e")
   int[] field2681;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-82"
   )
   public byte[] method3217(int var1, int var2) {
      return this.method3265(var1, var2, (int[])null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1129427368"
   )
   public boolean method3220(int var1) {
      if(this.field2671[var1] != null) {
         return true;
      } else {
         this.vmethod3314(var1);
         return null != this.field2671[var1];
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1442078568"
   )
   public byte[] method3223(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2666.length && null != this.field2666[var1] && var2 >= 0 && var2 < this.field2666[var1].length) {
         if(this.field2666[var1][var2] == null) {
            boolean var3 = this.method3231(var1, (int[])null);
            if(!var3) {
               this.vmethod3314(var1);
               var3 = this.method3231(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class27.method641(this.field2666[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1580053138"
   )
   public byte[] method3224(int var1) {
      if(this.field2666.length == 1) {
         return this.method3223(0, var1);
      } else if(this.field2666[var1].length == 1) {
         return this.method3223(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   void vmethod3314(int var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-2085515271"
   )
   public int[] method3226(int var1) {
      return this.field2668[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1858503795"
   )
   public int method3227(int var1) {
      return this.field2666[var1].length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1137151672"
   )
   boolean method3231(int var1, int[] var2) {
      if(this.field2671[var1] == null) {
         return false;
      } else {
         int var3 = this.field2667[var1];
         int[] var4 = this.field2668[var1];
         Object[] var5 = this.field2666[var1];
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
            if(null == var2 || 0 == var2[0] && 0 == var2[1] && var2[2] == 0 && 0 == var2[3]) {
               var18 = class27.method641(this.field2671[var1], false);
            } else {
               var18 = class27.method641(this.field2671[var1], true);
               class119 var8 = new class119(var18);
               var8.method2672(var2, 5, var8.field1973.length);
            }

            byte[] var19 = class10.method133(var18);
            if(this.field2675) {
               this.field2671[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= 4 * var3 * var10;
               class119 var11 = new class119(var19);
               int[] var12 = new int[var3];
               var11.field1971 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2505();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1971 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2505();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2676) {
                     var5[var4[var15]] = class16.method185(var20[var15], false);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2676) {
               var5[var4[0]] = class16.method185(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1537732864"
   )
   public int method3232(String var1) {
      var1 = var1.toLowerCase();
      return this.field2672.method3700(class108.method2399(var1));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "581738869"
   )
   public int method3233(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2670[var1].method3700(class108.method2399(var2));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)[B",
      garbageValue = "22168"
   )
   public byte[] method3234(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2672.method3700(class108.method2399(var1));
      int var4 = this.field2670[var3].method3700(class108.method2399(var2));
      return this.method3217(var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-78"
   )
   public boolean method3236(String var1) {
      int var2 = this.method3232("");
      return var2 != -1?this.method3247("", var1):this.method3247(var1, "");
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "4882"
   )
   public void method3237(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2672.method3700(class108.method2399(var1));
      if(var2 >= 0) {
         this.vmethod3315(var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1365690987"
   )
   public void method3238() {
      for(int var1 = 0; var1 < this.field2666.length; ++var1) {
         if(this.field2666[var1] != null) {
            for(int var2 = 0; var2 < this.field2666[var1].length; ++var2) {
               this.field2666[var1][var2] = null;
            }
         }
      }

   }

   class167(boolean var1, boolean var2) {
      this.field2675 = var1;
      this.field2676 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1479120725"
   )
   void vmethod3315(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "91"
   )
   public boolean method3247(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2672.method3700(class108.method2399(var1));
      int var4 = this.field2670[var3].method3700(class108.method2399(var2));
      return this.method3294(var3, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1968259202"
   )
   public int method3250() {
      return this.field2666.length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "621777923"
   )
   public boolean method3254() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2662.length; ++var2) {
         int var3 = this.field2662[var2];
         if(null == this.field2671[var3]) {
            this.vmethod3314(var3);
            if(null == this.field2671[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1699778415"
   )
   void method3256(byte[] var1) {
      this.field2674 = class7.method105(var1, var1.length);
      class119 var2 = new class119(class10.method133(var1));
      int var3 = var2.method2500();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2505();
         }

         int var4 = var2.method2500();
         if(var3 >= 7) {
            this.field2679 = var2.method2513();
         } else {
            this.field2679 = var2.method2502();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2662 = new int[this.field2679];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2679; ++var7) {
               this.field2662[var7] = var5 += var2.method2513();
               if(this.field2662[var7] > var6) {
                  var6 = this.field2662[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2679; ++var7) {
               this.field2662[var7] = var5 += var2.method2502();
               if(this.field2662[var7] > var6) {
                  var6 = this.field2662[var7];
               }
            }
         }

         this.field2673 = new int[1 + var6];
         this.field2681 = new int[1 + var6];
         this.field2667 = new int[var6 + 1];
         this.field2668 = new int[var6 + 1][];
         this.field2671 = new Object[var6 + 1];
         this.field2666 = new Object[var6 + 1][];
         if(0 != var4) {
            this.field2663 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2679; ++var7) {
               this.field2663[this.field2662[var7]] = var2.method2505();
            }

            this.field2672 = new class192(this.field2663);
         }

         for(var7 = 0; var7 < this.field2679; ++var7) {
            this.field2673[this.field2662[var7]] = var2.method2505();
         }

         for(var7 = 0; var7 < this.field2679; ++var7) {
            this.field2681[this.field2662[var7]] = var2.method2505();
         }

         for(var7 = 0; var7 < this.field2679; ++var7) {
            this.field2667[this.field2662[var7]] = var2.method2502();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2679; ++var7) {
               var8 = this.field2662[var7];
               var9 = this.field2667[var8];
               var5 = 0;
               var10 = -1;
               this.field2668[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2668[var8][var11] = var5 += var2.method2513();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2666[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2679; ++var7) {
               var8 = this.field2662[var7];
               var9 = this.field2667[var8];
               var5 = 0;
               var10 = -1;
               this.field2668[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2668[var8][var11] = var5 += var2.method2502();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2666[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2669 = new int[1 + var6][];
            this.field2670 = new class192[1 + var6];

            for(var7 = 0; var7 < this.field2679; ++var7) {
               var8 = this.field2662[var7];
               var9 = this.field2667[var8];
               this.field2669[var8] = new int[this.field2666[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2669[var8][this.field2668[var8][var10]] = var2.method2505();
               }

               this.field2670[var8] = new class192(this.field2669[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1686443311"
   )
   public void method3260(int var1) {
      for(int var2 = 0; var2 < this.field2666[var1].length; ++var2) {
         this.field2666[var1][var2] = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "751352029"
   )
   public byte[] method3265(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2666.length && null != this.field2666[var1] && var2 >= 0 && var2 < this.field2666[var1].length) {
         if(this.field2666[var1][var2] == null) {
            boolean var4 = this.method3231(var1, var3);
            if(!var4) {
               this.vmethod3314(var1);
               var4 = this.method3231(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class27.method641(this.field2666[var1][var2], false);
         if(this.field2676) {
            this.field2666[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1395252839"
   )
   public byte[] method3272(int var1) {
      if(this.field2666.length == 1) {
         return this.method3217(0, var1);
      } else if(1 == this.field2666[var1].length) {
         return this.method3217(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "926812436"
   )
   static final int method3280(int var0, int var1) {
      if(-2 == var0) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-56"
   )
   static String method3293() {
      String var0 = "";

      class35 var2;
      for(Iterator var1 = class11.field171.iterator(); var1.hasNext(); var0 = var0 + var2.field764 + ':' + var2.field768 + '\n') {
         var2 = (class35)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "41"
   )
   public boolean method3294(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2666.length && null != this.field2666[var1] && var2 >= 0 && var2 < this.field2666[var1].length) {
         if(this.field2666[var1][var2] != null) {
            return true;
         } else if(null != this.field2671[var1]) {
            return true;
         } else {
            this.vmethod3314(var1);
            return this.field2671[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)Lclass78;",
      garbageValue = "-1968816813"
   )
   public static class78 method3295(class167 var0, String var1, String var2) {
      int var3 = var0.method3232(var1);
      int var4 = var0.method3233(var3, var2);
      return class13.method167(var0, var3, var4);
   }
}
