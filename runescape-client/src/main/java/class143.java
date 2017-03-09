import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("eq")
public class class143 extends class68 {
   @ObfuscatedName("c")
   class51 field2007 = new class51();
   @ObfuscatedName("j")
   Deque field2008 = new Deque();
   @ObfuscatedName("x")
   class139 field2009;

   @ObfuscatedName("u")
   protected class68 vmethod2723() {
      class140 var1 = (class140)this.field2008.method2448();
      return (class68)(var1 == null?null:(null != var1.field1974?var1.field1974:this.vmethod2724()));
   }

   @ObfuscatedName("y")
   protected class68 vmethod2724() {
      class140 var1;
      do {
         var1 = (class140)this.field2008.method2445();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field1974);

      return var1.field1974;
   }

   @ObfuscatedName("e")
   protected int vmethod2725() {
      return 0;
   }

   @ObfuscatedName("q")
   protected void vmethod2726(int[] var1, int var2, int var3) {
      this.field2007.vmethod2726(var1, var2, var3);

      for(class140 var6 = (class140)this.field2008.method2448(); var6 != null; var6 = (class140)this.field2008.method2445()) {
         if(!this.field2009.method2563(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1975) {
                  this.method2728(var6, var1, var4, var5, var5 + var4);
                  var6.field1975 -= var5;
                  break;
               }

               this.method2728(var6, var1, var4, var6.field1975, var4 + var5);
               var4 += var6.field1975;
               var5 -= var6.field1975;
            } while(!this.field2009.method2637(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "2125214202"
   )
   void method2728(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2009.field1938[var1.field1957] & 4) != 0 && var1.field1970 < 0) {
         int var6 = this.field2009.field1943[var1.field1957] / class148.field2033;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1969) / var6;
            if(var7 > var4) {
               var1.field1969 += var6 * var4;
               break;
            }

            var1.field1974.vmethod2726(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1969 += var7 * var6 - 1048576;
            int var8 = class148.field2033 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1974;
            if(this.field2009.field1941[var1.field1957] == 0) {
               var1.field1974 = class66.method1252(var1.field1958, var10.method1267(), var10.method1258(), var10.method1259());
            } else {
               var1.field1974 = class66.method1252(var1.field1958, var10.method1267(), 0, var10.method1259());
               this.field2009.method2592(var1, var1.field1971.field1996[var1.field1961] < 0);
               var1.field1974.method1263(var8, var10.method1258());
            }

            if(var1.field1971.field1996[var1.field1961] < 0) {
               var1.field1974.method1339(-1);
            }

            var10.method1265(var8);
            var10.vmethod2726(var2, var3, var5 - var3);
            if(var10.method1269()) {
               this.field2007.method1001(var10);
            }
         }
      }

      var1.field1974.vmethod2726(var2, var3, var4);
   }

   class143(class139 var1) {
      this.field2009 = var1;
   }

   @ObfuscatedName("l")
   protected void vmethod2729(int var1) {
      this.field2007.vmethod2729(var1);

      for(class140 var3 = (class140)this.field2008.method2448(); null != var3; var3 = (class140)this.field2008.method2445()) {
         if(!this.field2009.method2563(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1975) {
                  this.method2734(var3, var2);
                  var3.field1975 -= var2;
                  break;
               }

               this.method2734(var3, var3.field1975);
               var2 -= var3.field1975;
            } while(!this.field2009.method2637(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass140;IB)V",
      garbageValue = "52"
   )
   void method2734(class140 var1, int var2) {
      if((this.field2009.field1938[var1.field1957] & 4) != 0 && var1.field1970 < 0) {
         int var3 = this.field2009.field1943[var1.field1957] / class148.field2033;
         int var4 = (1048575 + var3 - var1.field1969) / var3;
         var1.field1969 = var2 * var3 + var1.field1969 & 1048575;
         if(var4 <= var2) {
            if(this.field2009.field1941[var1.field1957] == 0) {
               var1.field1974 = class66.method1252(var1.field1958, var1.field1974.method1267(), var1.field1974.method1258(), var1.field1974.method1259());
            } else {
               var1.field1974 = class66.method1252(var1.field1958, var1.field1974.method1267(), 0, var1.field1974.method1259());
               this.field2009.method2592(var1, var1.field1971.field1996[var1.field1961] < 0);
            }

            if(var1.field1971.field1996[var1.field1961] < 0) {
               var1.field1974.method1339(-1);
            }

            var2 = var1.field1969 / var3;
         }
      }

      var1.field1974.vmethod2729(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;I)Z",
      garbageValue = "-202968059"
   )
   static final boolean method2747(int var0, int var1, int var2, class119 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class118.field1852[var7][var8] = 99;
      class118.field1849[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class118.field1846[var11] = var0;
      int var20 = var11 + 1;
      class118.field1853[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label353:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label330:
                     do {
                        if(var20 == var12) {
                           class118.field1850 = var5;
                           class180.field2689 = var6;
                           return false;
                        }

                        var5 = class118.field1846[var12];
                        var6 = class118.field1853[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2329(var2, var5, var6, var4)) {
                           class118.field1850 = var5;
                           class180.field2689 = var6;
                           return true;
                        }

                        var16 = class118.field1849[var18][var19] + 1;
                        if(var18 > 0 && class118.field1852[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var2 + var15 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1846[var20] = var5 - 1;
                                 class118.field1853[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1852[var18 - 1][var19] = 2;
                                 class118.field1849[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class118.field1852[1 + var18][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1846[var20] = var5 + 1;
                                 class118.field1853[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1852[var18 + 1][var19] = 8;
                                 class118.field1849[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class118.field1852[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1846[var20] = var5;
                                 class118.field1853[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1852[var18][var19 - 1] = 1;
                                 class118.field1849[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class118.field1852[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1846[var20] = var5;
                                 class118.field1853[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1852[var18][var19 + 1] = 4;
                                 class118.field1849[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class118.field1852[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class118.field1846[var20] = var5 - 1;
                                 class118.field1853[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1852[var18 - 1][var19 - 1] = 3;
                                 class118.field1849[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class118.field1852[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class118.field1846[var20] = var5 + 1;
                                 class118.field1853[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1852[1 + var18][var19 - 1] = 9;
                                 class118.field1849[1 + var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 - 1 + var17] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class118.field1852[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var2 + var15] & 19137016) != 0) {
                                 continue label330;
                              }
                           }

                           class118.field1846[var20] = var5 - 1;
                           class118.field1853[var20] = 1 + var6;
                           var20 = 1 + var20 & 4095;
                           class118.field1852[var18 - 1][1 + var19] = 6;
                           class118.field1849[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class118.field1852[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label353;
               }
            }

            class118.field1846[var20] = 1 + var5;
            class118.field1853[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class118.field1852[1 + var18][var19 + 1] = 12;
            class118.field1849[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "38"
   )
   public static Class method2748(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
