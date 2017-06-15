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
   static RenderOverview field601;
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
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[6][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[6][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[6][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
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
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 <= this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[5][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var3 <= this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[5][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[5][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var3 >= this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
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
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[7][0] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field599; ++var4) {
            if(var4 >= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[7][1] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = this.field599 - 1; var3 >= 0; --var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field600[7][2] = var1;
      var1 = new byte[this.field599 * this.field599];
      var5 = 0;

      for(var3 = 0; var3 < this.field599; ++var3) {
         for(var4 = this.field599 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field599 / 2) {
               var1[var5] = -1;
            }

            ++var5;
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
      class219 var5 = var0.field831;
      boolean var4 = class219.field2796 == var5 || var5 == class219.field2797 || var5 == class219.field2798 || var5 == class219.field2799 || class219.field2800 == var5 || class219.field2803 == var5 || class219.field2802 == var5 || class219.field2806 == var5;
      Script var3;
      int var9;
      int var10;
      int var11;
      int var14;
      int var18;
      int var21;
      String var25;
      int var26;
      if(var4) {
         class175.field2423 = (class47)var2[0];
         Area var6 = Area.field3304[class175.field2423.field612];
         class219 var8 = var0.field831;
         var9 = var6.field3301;
         var10 = var6.field3306;
         var11 = class17.method140(var9, var8);
         Script var13 = (Script)Script.field1533.get((long)(var11 << 16));
         Script var12;
         if(var13 != null) {
            var12 = var13;
         } else {
            var25 = String.valueOf(var11);
            var26 = class69.indexScripts.method4055(var25);
            if(var26 == -1) {
               var12 = null;
            } else {
               label597: {
                  byte[] var16 = class69.indexScripts.method4001(var26);
                  if(var16 != null) {
                     if(var16.length <= 1) {
                        var12 = null;
                        break label597;
                     }

                     var13 = class47.method673(var16);
                     if(var13 != null) {
                        Script.field1533.put(var13, (long)(var11 << 16));
                        var12 = var13;
                        break label597;
                     }
                  }

                  var12 = null;
               }
            }
         }

         Script var7;
         if(var12 != null) {
            var7 = var12;
         } else {
            var14 = var8.field2804 + (var10 + '鱀' << 8);
            Script var38 = (Script)Script.field1533.get((long)(var14 << 16));
            Script var15;
            if(var38 != null) {
               var15 = var38;
            } else {
               String var24 = String.valueOf(var14);
               var18 = class69.indexScripts.method4055(var24);
               if(var18 == -1) {
                  var15 = null;
               } else {
                  label531: {
                     byte[] var28 = class69.indexScripts.method4001(var18);
                     if(var28 != null) {
                        if(var28.length <= 1) {
                           var15 = null;
                           break label531;
                        }

                        var38 = class47.method673(var28);
                        if(var38 != null) {
                           Script.field1533.put(var38, (long)(var14 << 16));
                           var15 = var38;
                           break label531;
                        }
                     }

                     var15 = null;
                  }
               }
            }

            if(var15 != null) {
               var7 = var15;
            } else {
               var7 = null;
            }
         }

         var3 = var7;
      } else {
         var21 = ((Integer)var2[0]).intValue();
         var3 = class45.method630(var21);
      }

      if(var3 != null) {
         class83.intStackSize = 0;
         class24.scriptStringStackSize = 0;
         var21 = -1;
         int[] var32 = var3.instructions;
         int[] var33 = var3.intOperands;
         byte var34 = -1;
         class83.scriptStackCount = 0;

         int var22;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            var10 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            var11 = 0;

            int var23;
            String var35;
            for(var22 = 1; var22 < var2.length; ++var22) {
               if(var2[var22] instanceof Integer) {
                  var23 = ((Integer)var2[var22]).intValue();
                  if(var23 == -2147483647) {
                     var23 = var0.field823;
                  }

                  if(var23 == -2147483646) {
                     var23 = var0.field835;
                  }

                  if(var23 == -2147483645) {
                     var23 = var0.field822 != null?var0.field822.id:-1;
                  }

                  if(var23 == -2147483644) {
                     var23 = var0.field825;
                  }

                  if(var23 == -2147483643) {
                     var23 = var0.field822 != null?var0.field822.index:-1;
                  }

                  if(var23 == -2147483642) {
                     var23 = var0.field829 != null?var0.field829.id:-1;
                  }

                  if(var23 == -2147483641) {
                     var23 = var0.field829 != null?var0.field829.index:-1;
                  }

                  if(var23 == -2147483640) {
                     var23 = var0.field827;
                  }

                  if(var23 == -2147483639) {
                     var23 = var0.field828;
                  }

                  class83.scriptLocalInts[var10++] = var23;
               } else if(var2[var22] instanceof String) {
                  var35 = (String)var2[var22];
                  if(var35.equals("event_opbase")) {
                     var35 = var0.field833;
                  }

                  class83.scriptLocalStrings[var11++] = var35;
               }
            }

            var22 = 0;
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
                                                                                       label352:
                                                                                       while(true) {
                                                                                          ++var22;
                                                                                          if(var22 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var21;
                                                                                          var9 = var32[var21];
                                                                                          if(var9 < 100) {
                                                                                             if(var9 != 0) {
                                                                                                if(var9 != 1) {
                                                                                                   if(var9 != 2) {
                                                                                                      if(var9 != 3) {
                                                                                                         if(var9 != 6) {
                                                                                                            if(var9 != 7) {
                                                                                                               if(var9 != 8) {
                                                                                                                  if(var9 != 9) {
                                                                                                                     if(var9 != 10) {
                                                                                                                        if(var9 != 21) {
                                                                                                                           if(var9 != 25) {
                                                                                                                              int var17;
                                                                                                                              if(var9 != 27) {
                                                                                                                                 if(var9 != 31) {
                                                                                                                                    if(var9 != 32) {
                                                                                                                                       if(var9 != 33) {
                                                                                                                                          if(var9 != 34) {
                                                                                                                                             if(var9 != 35) {
                                                                                                                                                if(var9 != 36) {
                                                                                                                                                   if(var9 != 37) {
                                                                                                                                                      if(var9 != 38) {
                                                                                                                                                         if(var9 != 39) {
                                                                                                                                                            if(var9 != 40) {
                                                                                                                                                               if(var9 != 42) {
                                                                                                                                                                  if(var9 != 43) {
                                                                                                                                                                     if(var9 == 44) {
                                                                                                                                                                        var23 = var33[var21] >> 16;
                                                                                                                                                                        var14 = var33[var21] & '\uffff';
                                                                                                                                                                        var26 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var26 >= 0 && var26 <= 5000) {
                                                                                                                                                                           class83.field1327[var23] = var26;
                                                                                                                                                                           byte var27 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var27 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var17 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var17 >= var26) {
                                                                                                                                                                                 continue label352;
                                                                                                                                                                              }

                                                                                                                                                                              class83.field1334[var23][var17] = var27;
                                                                                                                                                                              ++var17;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var9 == 45) {
                                                                                                                                                                        var23 = var33[var21];
                                                                                                                                                                        var14 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1327[var23]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class83.field1334[var23][var14];
                                                                                                                                                                     } else if(var9 == 46) {
                                                                                                                                                                        var23 = var33[var21];
                                                                                                                                                                        class83.intStackSize -= 2;
                                                                                                                                                                        var14 = class83.intStack[class83.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1327[var23]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.field1334[var23][var14] = class83.intStack[class83.intStackSize + 1];
                                                                                                                                                                     } else if(var9 == 47) {
                                                                                                                                                                        var35 = class66.chatMessages.method1731(var33[var21]);
                                                                                                                                                                        if(var35 == null) {
                                                                                                                                                                           var35 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var35;
                                                                                                                                                                     } else if(var9 == 48) {
                                                                                                                                                                        class66.chatMessages.method1703(var33[var21], class83.scriptStringStack[--class24.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var9 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var37 = var3.switches[var33[var21]];
                                                                                                                                                                        class198 var46 = (class198)var37.method3389((long)class83.intStack[--class83.intStackSize]);
                                                                                                                                                                        if(var46 != null) {
                                                                                                                                                                           var21 += var46.field2496;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class66.chatMessages.method1728(var33[var21], class83.intStack[--class83.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class66.chatMessages.method1722(var33[var21]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var23 = var33[var21];
                                                                                                                                                               Script var45 = class45.method630(var23);
                                                                                                                                                               int[] var42 = new int[var45.localIntCount];
                                                                                                                                                               String[] var41 = new String[var45.localStringCount];

                                                                                                                                                               for(var17 = 0; var17 < var45.intStackCount; ++var17) {
                                                                                                                                                                  var42[var17] = class83.intStack[class83.intStackSize - var45.intStackCount + var17];
                                                                                                                                                               }

                                                                                                                                                               for(var17 = 0; var17 < var45.stringStackCount; ++var17) {
                                                                                                                                                                  var41[var17] = class83.scriptStringStack[var17 + (class24.scriptStringStackSize - var45.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class83.intStackSize -= var45.intStackCount;
                                                                                                                                                               class24.scriptStringStackSize -= var45.stringStackCount;
                                                                                                                                                               ScriptState var44 = new ScriptState();
                                                                                                                                                               var44.invokedFromScript = var3;
                                                                                                                                                               var44.invokedFromPc = var21;
                                                                                                                                                               var44.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var44.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var44;
                                                                                                                                                               var3 = var45;
                                                                                                                                                               var32 = var45.instructions;
                                                                                                                                                               var33 = var45.intOperands;
                                                                                                                                                               var21 = -1;
                                                                                                                                                               class83.scriptLocalInts = var42;
                                                                                                                                                               class83.scriptLocalStrings = var41;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class24.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class83.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var23 = var33[var21];
                                                                                                                                                      class24.scriptStringStackSize -= var23;
                                                                                                                                                      var25 = class203.method3571(class83.scriptStringStack, class24.scriptStringStackSize, var23);
                                                                                                                                                      class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var25;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var33[var21]] = class83.scriptStringStack[--class24.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class83.scriptLocalStrings[var33[var21]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var33[var21]] = class83.intStack[--class83.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = class83.scriptLocalInts[var33[var21]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class83.intStackSize] >= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                          var21 += var33[var21];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class83.intStackSize] <= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                       var21 += var33[var21];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var23 = var33[var21];
                                                                                                                                 var14 = class83.intStack[--class83.intStackSize];
                                                                                                                                 Varbit var39 = (Varbit)Varbit.field3389.get((long)var23);
                                                                                                                                 Varbit var40;
                                                                                                                                 if(var39 != null) {
                                                                                                                                    var40 = var39;
                                                                                                                                 } else {
                                                                                                                                    byte[] var43 = Varbit.field3390.getConfigData(14, var23);
                                                                                                                                    var39 = new Varbit();
                                                                                                                                    if(var43 != null) {
                                                                                                                                       var39.method4296(new Buffer(var43));
                                                                                                                                    }

                                                                                                                                    Varbit.field3389.put(var39, (long)var23);
                                                                                                                                    var40 = var39;
                                                                                                                                 }

                                                                                                                                 var17 = var40.configId;
                                                                                                                                 var18 = var40.leastSignificantBit;
                                                                                                                                 int var19 = var40.mostSignificantBit;
                                                                                                                                 int var20 = class211.field2614[var19 - var18];
                                                                                                                                 if(var14 < 0 || var14 > var20) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var18;
                                                                                                                                 class211.widgetSettings[var17] = class211.widgetSettings[var17] & ~var20 | var14 << var18 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var23 = var33[var21];
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class50.method728(var23);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var36 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var36.invokedFromScript;
                                                                                                                           var32 = var3.instructions;
                                                                                                                           var33 = var3.intOperands;
                                                                                                                           var21 = var36.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var36.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var36.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class83.intStackSize] > class83.intStack[class83.intStackSize + 1]) {
                                                                                                                           var21 += var33[var21];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class83.intStackSize] < class83.intStack[class83.intStackSize + 1]) {
                                                                                                                        var21 += var33[var21];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class83.intStackSize + 1] == class83.intStack[class83.intStackSize]) {
                                                                                                                     var21 += var33[var21];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               if(class83.intStack[class83.intStackSize] != class83.intStack[class83.intStackSize + 1]) {
                                                                                                                  var21 += var33[var21];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var21 += var33[var21];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var3.stringOperands[var21];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var23 = var33[var21];
                                                                                                      class211.widgetSettings[var23] = class83.intStack[--class83.intStackSize];
                                                                                                      class36.method483(var23);
                                                                                                   }
                                                                                                } else {
                                                                                                   var23 = var33[var21];
                                                                                                   class83.intStack[++class83.intStackSize - 1] = class211.widgetSettings[var23];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class83.intStackSize - 1] = var33[var21];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var47;
                                                                                             if(var3.intOperands[var21] == 1) {
                                                                                                var47 = true;
                                                                                             } else {
                                                                                                var47 = false;
                                                                                             }

                                                                                             var14 = class90.method1619(var9, var3, var47);
                                                                                             switch(var14) {
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
         } catch (Exception var31) {
            StringBuilder var30 = new StringBuilder(30);
            var30.append("").append(var3.hash).append(" ");

            for(var22 = class83.scriptStackCount - 1; var22 >= 0; --var22) {
               var30.append("").append(class83.scriptStack[var22].invokedFromScript.hash).append(" ");
            }

            var30.append("").append(var34);
            class8.method43(var30.toString(), var31);
         }
      }
   }
}
