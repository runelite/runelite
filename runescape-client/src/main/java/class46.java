import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class46 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -135220785
   )
   int field599;
   @ObfuscatedName("m")
   byte[][][] field600;
   @ObfuscatedName("ra")
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("n")
   public static class112 field604;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "18"
   )
   void method634(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field599 != 0 && this.field600 != null) {
         var8 = this.method648(var8, var7);
         var7 = this.method659(var7);
         Rasterizer2D.method4831(var1, var2, var5, var6, var3, var4, this.field600[var7 - 1][var8], this.field599);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1930226757"
   )
   void method637() {
      if(this.field600 == null) {
         this.field600 = new byte[8][4][];
         this.method638();
         this.method639();
         this.method640();
         this.method641();
         this.method642();
         this.method647();
         this.method644();
         this.method650();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "106136096"
   )
   void method638() {
      byte[] var1 = new byte[this.field599 * this.field599];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[0][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[0][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[0][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[0][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "79"
   )
   void method639() {
      byte[] var1 = new byte[this.field599 * this.field599];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[1][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field600[1][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[1][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[1][3] = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113783"
   )
   void method640() {
      byte[] var1 = new byte[this.field599 * this.field599];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[2][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[2][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[2][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[2][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   void method641() {
      byte[] var1 = new byte[this.field599 * this.field599];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[3][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[3][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[3][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[3][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "879761389"
   )
   void method642() {
      byte[] var1 = new byte[this.field599 * this.field599];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[4][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[4][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[4][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var2 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field600[4][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1730766949"
   )
   void method644() {
      byte[] var1 = new byte[this.field599 * this.field599];
      boolean var2 = false;
      var1 = new byte[this.field599 * this.field599];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var5 <= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[6][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = this.field599 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var5 <= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[6][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = this.field599 - 1; var4 >= 0; --var4) {
         for(var5 = this.field599 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[6][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = this.field599 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[6][3] = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   void method647() {
      byte[] var1 = new byte[this.field599 * this.field599];
      boolean var2 = false;
      var1 = new byte[this.field599 * this.field599];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var5 <= this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[5][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var4 <= this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[5][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var5 >= this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[5][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var4 >= this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[5][3] = var1;
   }

   class46(int var1) {
      this.field599 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "571196019"
   )
   int method648(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797887123"
   )
   void method650() {
      byte[] var1 = new byte[this.field599 * this.field599];
      boolean var2 = false;
      var1 = new byte[this.field599 * this.field599];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var5 >= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[7][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = this.field599 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field599; ++var5) {
            if(var5 >= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[7][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = this.field599 - 1; var4 >= 0; --var4) {
         for(var5 = this.field599 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[7][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var3 = 0;

      for(var4 = 0; var4 < this.field599; ++var4) {
         for(var5 = this.field599 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 - this.field599 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field600[7][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "8"
   )
   int method659(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-911717658"
   )
   public static int method670(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "-1073866990"
   )
   static void method671(class69 var0, int var1) {
      Object[] var2 = var0.field821;
      class219 var3 = var0.field831;
      boolean var4 = class219.field2796 == var3 || var3 == class219.field2797 || var3 == class219.field2798 || var3 == class219.field2799 || class219.field2800 == var3 || class219.field2803 == var3 || class219.field2802 == var3 || class219.field2806 == var3;
      Script var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      String var12;
      int var13;
      if(var4) {
         class175.field2423 = (class47)var2[0];
         Area var14 = Area.field3304[class175.field2423.field612];
         class219 var15 = var0.field831;
         var6 = var14.field3301;
         var7 = var14.field3306;
         var8 = class17.method140(var6, var15);
         Script var16 = (Script)Script.field1533.get((long)(var8 << 16));
         Script var17;
         if(var16 != null) {
            var17 = var16;
         } else {
            var12 = String.valueOf(var8);
            var13 = class69.indexScripts.method4055(var12);
            if(var13 == -1) {
               var17 = null;
            } else {
               label521: {
                  byte[] var18 = class69.indexScripts.method4001(var13);
                  if(var18 != null) {
                     if(var18.length <= 1) {
                        var17 = null;
                        break label521;
                     }

                     var16 = class47.method673(var18);
                     if(var16 != null) {
                        Script.field1533.put(var16, (long)(var8 << 16));
                        var17 = var16;
                        break label521;
                     }
                  }

                  var17 = null;
               }
            }
         }

         Script var29;
         if(var17 != null) {
            var29 = var17;
         } else {
            var9 = var15.field2804 + (var7 + '鱀' << 8);
            Script var19 = (Script)Script.field1533.get((long)(var9 << 16));
            Script var20;
            if(var19 != null) {
               var20 = var19;
            } else {
               String var21 = String.valueOf(var9);
               var10 = class69.indexScripts.method4055(var21);
               if(var10 == -1) {
                  var20 = null;
               } else {
                  label455: {
                     byte[] var22 = class69.indexScripts.method4001(var10);
                     if(var22 != null) {
                        if(var22.length <= 1) {
                           var20 = null;
                           break label455;
                        }

                        var19 = class47.method673(var22);
                        if(var19 != null) {
                           Script.field1533.put(var19, (long)(var9 << 16));
                           var20 = var19;
                           break label455;
                        }
                     }

                     var20 = null;
                  }
               }
            }

            if(var20 != null) {
               var29 = var20;
            } else {
               var29 = null;
            }
         }

         var5 = var29;
      } else {
         var11 = ((Integer)var2[0]).intValue();
         var5 = class45.method630(var11);
      }

      if(var5 != null) {
         class83.intStackSize = 0;
         class24.scriptStringStackSize = 0;
         var11 = -1;
         int[] var26 = var5.instructions;
         int[] var27 = var5.intOperands;
         byte var28 = -1;
         class83.scriptStackCount = 0;

         int var30;
         try {
            class83.scriptLocalInts = new int[var5.localIntCount];
            var7 = 0;
            class83.scriptLocalStrings = new String[var5.localStringCount];
            var8 = 0;

            int var32;
            String var33;
            for(var30 = 1; var30 < var2.length; ++var30) {
               if(var2[var30] instanceof Integer) {
                  var32 = ((Integer)var2[var30]).intValue();
                  if(var32 == -2147483647) {
                     var32 = var0.field823;
                  }

                  if(var32 == -2147483646) {
                     var32 = var0.field835;
                  }

                  if(var32 == -2147483645) {
                     var32 = var0.field822 != null?var0.field822.id:-1;
                  }

                  if(var32 == -2147483644) {
                     var32 = var0.field825;
                  }

                  if(var32 == -2147483643) {
                     var32 = var0.field822 != null?var0.field822.index:-1;
                  }

                  if(var32 == -2147483642) {
                     var32 = var0.field829 != null?var0.field829.id:-1;
                  }

                  if(var32 == -2147483641) {
                     var32 = var0.field829 != null?var0.field829.index:-1;
                  }

                  if(var32 == -2147483640) {
                     var32 = var0.field827;
                  }

                  if(var32 == -2147483639) {
                     var32 = var0.field828;
                  }

                  class83.scriptLocalInts[var7++] = var32;
               } else if(var2[var30] instanceof String) {
                  var33 = (String)var2[var30];
                  if(var33.equals("event_opbase")) {
                     var33 = var0.field833;
                  }

                  class83.scriptLocalStrings[var8++] = var33;
               }
            }

            var30 = 0;
            class83.field1336 = var0.field830;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label274:
                                                                                       while(true) {
                                                                                          ++var30;
                                                                                          if(var30 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var11;
                                                                                          var6 = var26[var11];
                                                                                          if(var6 < 100) {
                                                                                             if(var6 != 0) {
                                                                                                if(var6 != 1) {
                                                                                                   if(var6 != 2) {
                                                                                                      if(var6 != 3) {
                                                                                                         if(var6 != 6) {
                                                                                                            if(var6 != 7) {
                                                                                                               if(var6 != 8) {
                                                                                                                  if(var6 != 9) {
                                                                                                                     if(var6 != 10) {
                                                                                                                        if(var6 != 21) {
                                                                                                                           if(var6 != 25) {
                                                                                                                              int var41;
                                                                                                                              if(var6 != 27) {
                                                                                                                                 if(var6 != 31) {
                                                                                                                                    if(var6 != 32) {
                                                                                                                                       if(var6 != 33) {
                                                                                                                                          if(var6 != 34) {
                                                                                                                                             if(var6 != 35) {
                                                                                                                                                if(var6 != 36) {
                                                                                                                                                   if(var6 != 37) {
                                                                                                                                                      if(var6 != 38) {
                                                                                                                                                         if(var6 != 39) {
                                                                                                                                                            if(var6 != 40) {
                                                                                                                                                               if(var6 != 42) {
                                                                                                                                                                  if(var6 != 43) {
                                                                                                                                                                     if(var6 == 44) {
                                                                                                                                                                        var32 = var27[var11] >> 16;
                                                                                                                                                                        var9 = var27[var11] & '\uffff';
                                                                                                                                                                        var13 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var13 >= 0 && var13 <= 5000) {
                                                                                                                                                                           class83.field1327[var32] = var13;
                                                                                                                                                                           byte var39 = -1;
                                                                                                                                                                           if(var9 == 105) {
                                                                                                                                                                              var39 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var41 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var41 >= var13) {
                                                                                                                                                                                 continue label274;
                                                                                                                                                                              }

                                                                                                                                                                              class83.field1334[var32][var41] = var39;
                                                                                                                                                                              ++var41;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var6 == 45) {
                                                                                                                                                                        var32 = var27[var11];
                                                                                                                                                                        var9 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var9 < 0 || var9 >= class83.field1327[var32]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class83.field1334[var32][var9];
                                                                                                                                                                     } else if(var6 == 46) {
                                                                                                                                                                        var32 = var27[var11];
                                                                                                                                                                        class83.intStackSize -= 2;
                                                                                                                                                                        var9 = class83.intStack[class83.intStackSize];
                                                                                                                                                                        if(var9 < 0 || var9 >= class83.field1327[var32]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.field1334[var32][var9] = class83.intStack[class83.intStackSize + 1];
                                                                                                                                                                     } else if(var6 == 47) {
                                                                                                                                                                        var33 = class66.chatMessages.method1731(var27[var11]);
                                                                                                                                                                        if(var33 == null) {
                                                                                                                                                                           var33 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var33;
                                                                                                                                                                     } else if(var6 == 48) {
                                                                                                                                                                        class66.chatMessages.method1703(var27[var11], class83.scriptStringStack[--class24.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var6 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var38 = var5.switches[var27[var11]];
                                                                                                                                                                        class198 var45 = (class198)var38.method3389((long)class83.intStack[--class83.intStackSize]);
                                                                                                                                                                        if(var45 != null) {
                                                                                                                                                                           var11 += var45.field2496;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class66.chatMessages.method1728(var27[var11], class83.intStack[--class83.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class66.chatMessages.method1722(var27[var11]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var32 = var27[var11];
                                                                                                                                                               Script var36 = class45.method630(var32);
                                                                                                                                                               int[] var43 = new int[var36.localIntCount];
                                                                                                                                                               String[] var44 = new String[var36.localStringCount];

                                                                                                                                                               for(var41 = 0; var41 < var36.intStackCount; ++var41) {
                                                                                                                                                                  var43[var41] = class83.intStack[class83.intStackSize - var36.intStackCount + var41];
                                                                                                                                                               }

                                                                                                                                                               for(var41 = 0; var41 < var36.stringStackCount; ++var41) {
                                                                                                                                                                  var44[var41] = class83.scriptStringStack[var41 + (class24.scriptStringStackSize - var36.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class83.intStackSize -= var36.intStackCount;
                                                                                                                                                               class24.scriptStringStackSize -= var36.stringStackCount;
                                                                                                                                                               ScriptState var46 = new ScriptState();
                                                                                                                                                               var46.invokedFromScript = var5;
                                                                                                                                                               var46.invokedFromPc = var11;
                                                                                                                                                               var46.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var46.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var46;
                                                                                                                                                               var5 = var36;
                                                                                                                                                               var26 = var36.instructions;
                                                                                                                                                               var27 = var36.intOperands;
                                                                                                                                                               var11 = -1;
                                                                                                                                                               class83.scriptLocalInts = var43;
                                                                                                                                                               class83.scriptLocalStrings = var44;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class24.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class83.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var32 = var27[var11];
                                                                                                                                                      class24.scriptStringStackSize -= var32;
                                                                                                                                                      var12 = class203.method3571(class83.scriptStringStack, class24.scriptStringStackSize, var32);
                                                                                                                                                      class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var12;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var27[var11]] = class83.scriptStringStack[--class24.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class83.scriptLocalStrings[var27[var11]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var27[var11]] = class83.intStack[--class83.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = class83.scriptLocalInts[var27[var11]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class83.intStackSize] >= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                          var11 += var27[var11];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class83.intStackSize] <= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                       var11 += var27[var11];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var32 = var27[var11];
                                                                                                                                 var9 = class83.intStack[--class83.intStackSize];
                                                                                                                                 Varbit var34 = (Varbit)Varbit.field3389.get((long)var32);
                                                                                                                                 Varbit var37;
                                                                                                                                 if(var34 != null) {
                                                                                                                                    var37 = var34;
                                                                                                                                 } else {
                                                                                                                                    byte[] var23 = Varbit.field3390.getConfigData(14, var32);
                                                                                                                                    var34 = new Varbit();
                                                                                                                                    if(var23 != null) {
                                                                                                                                       var34.method4296(new Buffer(var23));
                                                                                                                                    }

                                                                                                                                    Varbit.field3389.put(var34, (long)var32);
                                                                                                                                    var37 = var34;
                                                                                                                                 }

                                                                                                                                 var41 = var37.configId;
                                                                                                                                 var10 = var37.leastSignificantBit;
                                                                                                                                 int var42 = var37.mostSignificantBit;
                                                                                                                                 int var24 = class211.field2614[var42 - var10];
                                                                                                                                 if(var9 < 0 || var9 > var24) {
                                                                                                                                    var9 = 0;
                                                                                                                                 }

                                                                                                                                 var24 <<= var10;
                                                                                                                                 class211.widgetSettings[var41] = class211.widgetSettings[var41] & ~var24 | var9 << var10 & var24;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var32 = var27[var11];
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class50.method728(var32);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var40 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var5 = var40.invokedFromScript;
                                                                                                                           var26 = var5.instructions;
                                                                                                                           var27 = var5.intOperands;
                                                                                                                           var11 = var40.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var40.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var40.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class83.intStackSize] > class83.intStack[class83.intStackSize + 1]) {
                                                                                                                           var11 += var27[var11];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class83.intStackSize] < class83.intStack[class83.intStackSize + 1]) {
                                                                                                                        var11 += var27[var11];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class83.intStackSize + 1] == class83.intStack[class83.intStackSize]) {
                                                                                                                     var11 += var27[var11];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               if(class83.intStack[class83.intStackSize] != class83.intStack[class83.intStackSize + 1]) {
                                                                                                                  var11 += var27[var11];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var11 += var27[var11];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var5.stringOperands[var11];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var32 = var27[var11];
                                                                                                      class211.widgetSettings[var32] = class83.intStack[--class83.intStackSize];
                                                                                                      class36.method483(var32);
                                                                                                   }
                                                                                                } else {
                                                                                                   var32 = var27[var11];
                                                                                                   class83.intStack[++class83.intStackSize - 1] = class211.widgetSettings[var32];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class83.intStackSize - 1] = var27[var11];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var35;
                                                                                             if(var5.intOperands[var11] == 1) {
                                                                                                var35 = true;
                                                                                             } else {
                                                                                                var35 = false;
                                                                                             }

                                                                                             var9 = class90.method1619(var6, var5, var35);
                                                                                             switch(var9) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var25) {
            StringBuilder var31 = new StringBuilder(30);
            var31.append("").append(var5.hash).append(" ");

            for(var30 = class83.scriptStackCount - 1; var30 >= 0; --var30) {
               var31.append("").append(class83.scriptStack[var30].invokedFromScript.hash).append(" ");
            }

            var31.append("").append(var28);
            class8.method43(var31.toString(), var25);
         }
      }

   }
}
