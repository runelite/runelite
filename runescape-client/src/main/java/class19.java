import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("j")
   boolean[] field272;
   @ObfuscatedName("x")
   int[] field276;
   @ObfuscatedName("y")
   @Export("messages")
   String[] field277;
   @ObfuscatedName("r")
   boolean field278 = false;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -2856141507610956037L
   )
   long field279;
   @ObfuscatedName("d")
   boolean[] field282;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass227;",
      garbageValue = "1523142093"
   )
   class227 method191(boolean var1) {
      return class139.method2974("2", client.field570.field2274, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1375513992"
   )
   void method192(int var1, String var2) {
      this.field277[var1] = var2;
      if(this.field282[var1]) {
         this.field278 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2090145204"
   )
   String method193(int var1) {
      return this.field277[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "2184"
   )
   int method195(int var1) {
      return this.field276[var1];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-101"
   )
   void method196() {
      class227 var1 = this.method191(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field276.length; ++var4) {
            if(this.field272[var4] && this.field276[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field277.length; ++var5) {
            if(this.field282[var5] && this.field277[var5] != null) {
               var2 += 2 + class4.method41(this.field277[var5]);
               ++var4;
            }
         }

         class119 var9 = new class119(var2);
         var9.method2650(1);
         var9.method2695(var3);

         int var6;
         for(var6 = 0; var6 < this.field276.length; ++var6) {
            if(this.field272[var6] && this.field276[var6] != -1) {
               var9.method2695(var6);
               var9.method2502(this.field276[var6]);
            }
         }

         var9.method2695(var4);

         for(var6 = 0; var6 < this.field277.length; ++var6) {
            if(this.field282[var6] && null != this.field277[var6]) {
               var9.method2695(var6);
               var9.method2505(this.field277[var6]);
            }
         }

         var1.method4127(var9.field1982, 0, var9.field1976);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4116();
         } catch (Exception var16) {
            ;
         }

      }

      this.field278 = false;
      this.field279 = class90.method2090();
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIIB)V",
      garbageValue = "42"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method197(class2 var0, int var1, int var2, int var3) {
      if(class153.field2262 != var0) {
         if(client.field429 < 400) {
            String var4;
            int var7;
            if(var0.field43 == 0) {
               String var5 = var0.field30[0] + var0.field26 + var0.field30[1];
               var7 = var0.field31;
               int var8 = class153.field2262.field31;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class158.method3184(16711680);
               } else if(var9 < -6) {
                  var6 = class158.method3184(16723968);
               } else if(var9 < -3) {
                  var6 = class158.method3184(16740352);
               } else if(var9 < 0) {
                  var6 = class158.method3184(16756736);
               } else if(var9 > 9) {
                  var6 = class158.method3184('\uff00');
               } else if(var9 > 6) {
                  var6 = class158.method3184(4259584);
               } else if(var9 > 3) {
                  var6 = class158.method3184(8453888);
               } else if(var9 > 0) {
                  var6 = class158.method3184(12648192);
               } else {
                  var6 = class158.method3184(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.field31 + ")" + var0.field30[2];
            } else {
               var4 = var0.field30[0] + var0.field26 + var0.field30[1] + " " + " (" + "skill-" + var0.field43 + ")" + var0.field30[2];
            }

            int var10;
            if(client.field352 == 1) {
               class217.method3974("Use", client.field349 + " " + "->" + " " + class158.method3184(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field442) {
               if((class138.field2115 & 8) == 8) {
                  class217.method3974(client.field445, client.field446 + " " + "->" + " " + class158.method3184(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(client.field416[var10] != null) {
                     short var11 = 0;
                     if(client.field416[var10].equalsIgnoreCase("Attack")) {
                        if(class20.field574 == client.field312) {
                           continue;
                        }

                        if(client.field312 == class20.field576 || class20.field575 == client.field312 && var0.field31 > class153.field2262.field31) {
                           var11 = 2000;
                        }

                        if(class153.field2262.field45 != 0 && var0.field45 != 0) {
                           if(class153.field2262.field45 == var0.field45) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(client.field417[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = var11 + client.field415[var10];
                     class217.method3974(client.field416[var10], class158.method3184(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < client.field429; ++var10) {
               if(client.field432[var10] == 23) {
                  client.field396[var10] = class158.method3184(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-21"
   )
   void method198() {
      if(this.field278 && this.field279 < class90.method2090() - 60000L) {
         this.method196();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-500250696"
   )
   boolean method199() {
      return this.field278;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2137437174"
   )
   void method200() {
      int var1;
      for(var1 = 0; var1 < this.field276.length; ++var1) {
         if(!this.field272[var1]) {
            this.field276[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field277.length; ++var1) {
         if(!this.field282[var1]) {
            this.field277[var1] = null;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   void method212() {
      class227 var1 = this.method191(false);

      try {
         byte[] var2 = new byte[(int)var1.method4113()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method4118(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new EOFException();
            }
         }

         class119 var13 = new class119(var2);
         if(var13.field1982.length - var13.field1976 < 1) {
            return;
         }

         int var14 = var13.method2514();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.method2516();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.method2516();
            var9 = var13.method2519();
            if(this.field272[var8]) {
               this.field276[var8] = var9;
            }
         }

         var7 = var13.method2516();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.method2516();
            String var10 = var13.method2522();
            if(this.field282[var9]) {
               this.field277[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.method4116();
         } catch (Exception var23) {
            ;
         }

      }

      this.field278 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "264685601"
   )
   void method219(int var1, int var2) {
      this.field276[var1] = var2;
      if(this.field272[var1]) {
         this.field278 = true;
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-38"
   )
   static final void method220(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class84.method1909(var0)) {
         class1.method4(class173.field2750[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   class19() {
      this.field276 = new int[class144.field2185.method3276(19)];
      this.field277 = new String[class144.field2185.method3276(15)];
      this.field272 = new boolean[this.field276.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field276.length; ++var1) {
         class45 var3 = (class45)class45.field1025.method3764((long)var1);
         class45 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class21.field584.method3266(19, var1);
            var3 = new class45();
            if(var4 != null) {
               var3.method949(new class119(var4));
            }

            class45.field1025.method3759(var3, (long)var1);
            var2 = var3;
         }

         this.field272[var1] = var2.field1024;
      }

      this.field282 = new boolean[this.field277.length];

      for(var1 = 0; var1 < this.field277.length; ++var1) {
         class49 var6 = (class49)class49.field1061.method3764((long)var1);
         class49 var5;
         if(null != var6) {
            var5 = var6;
         } else {
            var4 = class49.field1066.method3266(15, var1);
            var6 = new class49();
            if(null != var4) {
               var6.method997(new class119(var4));
            }

            class49.field1061.method3759(var6, (long)var1);
            var5 = var6;
         }

         this.field282[var1] = var5.field1062;
      }

      for(var1 = 0; var1 < this.field276.length; ++var1) {
         this.field276[var1] = -1;
      }

      this.method212();
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-394789834"
   )
   static void method222(int var0, String var1) {
      int var2 = class32.field738;
      int[] var3 = class32.field739;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field410[var3[var5]];
         if(var6 != null && class153.field2262 != var6 && var6.field26 != null && var6.field26.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               client.field331.method2781(25);
               client.field331.method2539(0);
               client.field331.method2545(var3[var5]);
            } else if(var0 == 4) {
               client.field331.method2781(250);
               client.field331.method2547(var3[var5]);
               client.field331.method2539(0);
            } else if(var0 == 6) {
               client.field331.method2781(162);
               client.field331.method2538(0);
               client.field331.method2545(var3[var5]);
            } else if(var0 == 7) {
               client.field331.method2781(228);
               client.field331.method2539(0);
               client.field331.method2695(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class45.method955(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1008290915"
   )
   static final int method224() {
      if(class162.field2637.field132) {
         return class144.field2193;
      } else {
         int var0 = 3;
         if(class156.field2286 < 310) {
            int var1 = class28.field670 >> 7;
            int var2 = client.field478 >> 7;
            int var3 = class153.field2262.field813 >> 7;
            int var4 = class153.field2262.field791 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class144.field2193;
            }

            if((class5.field69[class144.field2193][var1][var2] & 4) != 0) {
               var0 = class144.field2193;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.field69[class144.field2193][var1][var2] & 4) != 0) {
                     var0 = class144.field2193;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.field69[class144.field2193][var1][var2] & 4) != 0) {
                        var0 = class144.field2193;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class5.field69[class144.field2193][var1][var2] & 4) != 0) {
                     var0 = class144.field2193;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.field69[class144.field2193][var1][var2] & 4) != 0) {
                        var0 = class144.field2193;
                     }
                  }
               }
            }
         }

         if(class153.field2262.field813 >= 0 && class153.field2262.field791 >= 0 && class153.field2262.field813 < 13312 && class153.field2262.field791 < 13312) {
            if((class5.field69[class144.field2193][class153.field2262.field813 >> 7][class153.field2262.field791 >> 7] & 4) != 0) {
               var0 = class144.field2193;
            }

            return var0;
         } else {
            return class144.field2193;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "87"
   )
   static final int method225(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (789221 + var2 * var2 * 15731) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
