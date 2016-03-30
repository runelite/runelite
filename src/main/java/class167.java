import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public abstract class class167 {
   @ObfuscatedName("x")
   int[] field2688;
   @ObfuscatedName("a")
   boolean field2689;
   @ObfuscatedName("t")
   int[] field2690;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1875387725
   )
   int field2691;
   @ObfuscatedName("hs")
   @Export("localPlayer")
   static class2 field2692;
   @ObfuscatedName("p")
   class192 field2694;
   @ObfuscatedName("c")
   int[][] field2695;
   @ObfuscatedName("v")
   int[][] field2696;
   @ObfuscatedName("l")
   class192[] field2697;
   @ObfuscatedName("z")
   Object[] field2698;
   @ObfuscatedName("y")
   int[] field2699;
   @ObfuscatedName("m")
   int[] field2700;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -482919013
   )
   public int field2701;
   @ObfuscatedName("j")
   static class116 field2702 = new class116();
   @ObfuscatedName("d")
   boolean field2703;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -42949105
   )
   static int field2704 = 0;
   @ObfuscatedName("s")
   Object[][] field2705;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -1495402379
   )
   static int field2706;
   @ObfuscatedName("e")
   int[] field2707;

   @ObfuscatedName("x")
   void vmethod3362(int var1) {
   }

   @ObfuscatedName("o")
   public int method3289(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2697[var1].method3768(class127.method2829(var2));
   }

   class167(boolean var1, boolean var2) {
      this.field2689 = var1;
      this.field2703 = var2;
   }

   @ObfuscatedName("e")
   public boolean method3290(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2705.length && this.field2705[var1] != null && var2 >= 0 && var2 < this.field2705[var1].length) {
         if(null != this.field2705[var1][var2]) {
            return true;
         } else if(this.field2698[var1] != null) {
            return true;
         } else {
            this.vmethod3389(var1);
            return null != this.field2698[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("y")
   public boolean method3291(int var1) {
      if(null != this.field2698[var1]) {
         return true;
      } else {
         this.vmethod3389(var1);
         return this.field2698[var1] != null;
      }
   }

   @ObfuscatedName("c")
   public byte[] method3293(int var1) {
      if(1 == this.field2705.length) {
         return this.method3335(0, var1);
      } else if(1 == this.field2705[var1].length) {
         return this.method3335(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("v")
   public byte[] method3294(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2705.length && null != this.field2705[var1] && var2 >= 0 && var2 < this.field2705[var1].length) {
         if(this.field2705[var1][var2] == null) {
            boolean var3 = this.method3302(var1, (int[])null);
            if(!var3) {
               this.vmethod3389(var1);
               var3 = this.method3302(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class142.method2995(this.field2705[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   public byte[] method3295(int var1) {
      if(1 == this.field2705.length) {
         return this.method3294(0, var1);
      } else if(this.field2705[var1].length == 1) {
         return this.method3294(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   void vmethod3389(int var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "5"
   )
   public void method3297(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2694.method3768(class127.method2829(var1));
      if(var2 >= 0) {
         this.vmethod3362(var2);
      }
   }

   @ObfuscatedName("d")
   public void method3298() {
      for(int var1 = 0; var1 < this.field2705.length; ++var1) {
         if(null != this.field2705[var1]) {
            for(int var2 = 0; var2 < this.field2705[var1].length; ++var2) {
               this.field2705[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("q")
   public int method3299() {
      return this.field2705.length;
   }

   @ObfuscatedName("a")
   public void method3300(int var1) {
      for(int var2 = 0; var2 < this.field2705[var1].length; ++var2) {
         this.field2705[var1][var2] = null;
      }

   }

   @ObfuscatedName("u")
   boolean method3302(int var1, int[] var2) {
      if(this.field2698[var1] == null) {
         return false;
      } else {
         int var3 = this.field2700[var1];
         int[] var4 = this.field2695[var1];
         Object[] var5 = this.field2705[var1];
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
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && 0 == var2[2] && 0 == var2[3]) {
               var18 = class142.method2995(this.field2698[var1], false);
            } else {
               var18 = class142.method2995(this.field2698[var1], true);
               class119 var8 = new class119(var18);
               var8.method2525(var2, 5, var8.field2012.length);
            }

            byte[] var19 = class89.method2077(var18);
            if(this.field2689) {
               this.field2698[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= 4 * var10 * var3;
               class119 var11 = new class119(var19);
               int[] var12 = new int[var3];
               var11.field2011 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2511();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field2011 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2511();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2703) {
                     var5[var4[var15]] = class111.method2434(var20[var15]);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2703) {
               var5[var4[0]] = class111.method2434(var19);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("i")
   public int method3303(String var1) {
      var1 = var1.toLowerCase();
      return this.field2694.method3768(class127.method2829(var1));
   }

   @ObfuscatedName("p")
   public byte[] method3305(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2705.length && this.field2705[var1] != null && var2 >= 0 && var2 < this.field2705[var1].length) {
         if(null == this.field2705[var1][var2]) {
            boolean var4 = this.method3302(var1, var3);
            if(!var4) {
               this.vmethod3389(var1);
               var4 = this.method3302(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class142.method2995(this.field2705[var1][var2], false);
         if(this.field2703) {
            this.field2705[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "96"
   )
   void method3308(byte[] var1) {
      this.field2701 = class39.method818(var1, var1.length);
      class119 var2 = new class119(class89.method2077(var1));
      int var3 = var2.method2506();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2511();
         }

         int var4 = var2.method2506();
         if(var3 >= 7) {
            this.field2691 = var2.method2520();
         } else {
            this.field2691 = var2.method2508();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2688 = new int[this.field2691];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2691; ++var7) {
               this.field2688[var7] = var5 += var2.method2520();
               if(this.field2688[var7] > var6) {
                  var6 = this.field2688[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2691; ++var7) {
               this.field2688[var7] = var5 += var2.method2508();
               if(this.field2688[var7] > var6) {
                  var6 = this.field2688[var7];
               }
            }
         }

         this.field2707 = new int[1 + var6];
         this.field2699 = new int[var6 + 1];
         this.field2700 = new int[1 + var6];
         this.field2695 = new int[1 + var6][];
         this.field2698 = new Object[1 + var6];
         this.field2705 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2690 = new int[1 + var6];

            for(var7 = 0; var7 < this.field2691; ++var7) {
               this.field2690[this.field2688[var7]] = var2.method2511();
            }

            this.field2694 = new class192(this.field2690);
         }

         for(var7 = 0; var7 < this.field2691; ++var7) {
            this.field2707[this.field2688[var7]] = var2.method2511();
         }

         for(var7 = 0; var7 < this.field2691; ++var7) {
            this.field2699[this.field2688[var7]] = var2.method2511();
         }

         for(var7 = 0; var7 < this.field2691; ++var7) {
            this.field2700[this.field2688[var7]] = var2.method2508();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2691; ++var7) {
               var8 = this.field2688[var7];
               var9 = this.field2700[var8];
               var5 = 0;
               var10 = -1;
               this.field2695[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2695[var8][var11] = var5 += var2.method2520();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2705[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2691; ++var7) {
               var8 = this.field2688[var7];
               var9 = this.field2700[var8];
               var5 = 0;
               var10 = -1;
               this.field2695[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2695[var8][var11] = var5 += var2.method2508();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2705[var8] = new Object[1 + var10];
            }
         }

         if(var4 != 0) {
            this.field2696 = new int[var6 + 1][];
            this.field2697 = new class192[1 + var6];

            for(var7 = 0; var7 < this.field2691; ++var7) {
               var8 = this.field2688[var7];
               var9 = this.field2700[var8];
               this.field2696[var8] = new int[this.field2705[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2696[var8][this.field2695[var8][var10]] = var2.method2511();
               }

               this.field2697[var8] = new class192(this.field2696[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("k")
   public boolean method3312(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2694.method3768(class127.method2829(var1));
      int var4 = this.field2697[var3].method3768(class127.method2829(var2));
      return this.method3290(var3, var4);
   }

   @ObfuscatedName("j")
   public int method3330(int var1) {
      return this.field2705[var1].length;
   }

   @ObfuscatedName("f")
   public boolean method3331(String var1) {
      int var2 = this.method3303("");
      return var2 != -1?this.method3312("", var1):this.method3312(var1, "");
   }

   @ObfuscatedName("s")
   public int[] method3332(int var1) {
      return this.field2695[var1];
   }

   @ObfuscatedName("t")
   public byte[] method3335(int var1, int var2) {
      return this.method3305(var1, var2, (int[])null);
   }

   @ObfuscatedName("m")
   public boolean method3346() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2688.length; ++var2) {
         int var3 = this.field2688[var2];
         if(null == this.field2698[var3]) {
            this.vmethod3389(var3);
            if(this.field2698[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   public static boolean method3349() {
      class210 var0 = (class210)class211.field3139.method3879();
      return var0 != null;
   }

   @ObfuscatedName("h")
   public byte[] method3352(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2694.method3768(class127.method2829(var1));
      int var4 = this.field2697[var3].method3768(class127.method2829(var2));
      return this.method3335(var3, var4);
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1397784644"
   )
   static final void method3358() {
      class134.method2877(client.field353);
      ++field2706;
      if(client.field475 && client.field382) {
         int var0 = class140.field2168;
         int var1 = class140.field2182;
         var0 -= client.field469;
         var1 -= client.field470;
         if(var0 < client.field473) {
            var0 = client.field473;
         }

         if(client.field353.field2767 + var0 > client.field473 + client.field468.field2767) {
            var0 = client.field468.field2767 + client.field473 - client.field353.field2767;
         }

         if(var1 < client.field335) {
            var1 = client.field335;
         }

         if(var1 + client.field353.field2783 > client.field335 + client.field468.field2783) {
            var1 = client.field468.field2783 + client.field335 - client.field353.field2783;
         }

         int var2 = var0 - client.field476;
         int var3 = var1 - client.field477;
         int var4 = client.field353.field2792;
         if(field2706 > client.field353.field2844 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field423 = true;
         }

         int var5 = var0 - client.field473 + client.field468.field2788;
         int var6 = var1 - client.field335 + client.field468.field2882;
         class0 var7;
         if(null != client.field353.field2856 && client.field423) {
            var7 = new class0();
            var7.field2 = client.field353;
            var7.field3 = var5;
            var7.field0 = var6;
            var7.field7 = client.field353.field2856;
            class3.method48(var7);
         }

         if(class140.field2184 == 0) {
            if(client.field423) {
               if(null != client.field353.field2795) {
                  var7 = new class0();
                  var7.field2 = client.field353;
                  var7.field3 = var5;
                  var7.field0 = var6;
                  var7.field6 = client.field352;
                  var7.field7 = client.field353.field2795;
                  class3.method48(var7);
               }

               if(null != client.field352 && class90.method2079(client.field353) != null) {
                  client.field318.method2757(202);
                  client.field318.method2492(client.field353.field2802);
                  client.field318.method2538(client.field352.field2802);
                  client.field318.method2492(client.field353.field2883);
                  client.field318.method2492(client.field352.field2883);
                  client.field318.method2549(client.field353.field2838);
                  client.field318.method2549(client.field352.field2838);
               }
            } else if((1 == client.field432 || class170.method3396(client.field435 - 1)) && client.field435 > 2) {
               class116.method2456(client.field476 + client.field469, client.field477 + client.field470);
            } else if(client.field435 > 0) {
               class17.method187(client.field476 + client.field469, client.field477 + client.field470);
            }

            client.field353 = null;
         }

      } else {
         if(field2706 > 1) {
            client.field353 = null;
         }

      }
   }
}
