import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -567107321
   )
   public int field967 = -1;
   @ObfuscatedName("h")
   public static class167 field968;
   @ObfuscatedName("m")
   public static class167 field969;
   @ObfuscatedName("z")
   static class193 field970 = new class193(64);
   @ObfuscatedName("x")
   static class193 field971 = new class193(100);
   @ObfuscatedName("e")
   public int[] field972;
   @ObfuscatedName("i")
   int[] field973;
   @ObfuscatedName("c")
   public int[] field974;
   @ObfuscatedName("n")
   public int[] field975;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1301518311
   )
   public int field976 = -1;
   @ObfuscatedName("u")
   @Export("interleaveLeave")
   int[] field977;
   @ObfuscatedName("r")
   @Export("stretches")
   public boolean field978 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -751911851
   )
   public int field979 = -1;
   @ObfuscatedName("j")
   public static class167 field980;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1278745115
   )
   public int field981 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1650407447
   )
   @Export("maxLoops")
   public int field982 = 99;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -449703513
   )
   @Export("precedenceAnimating")
   public int field983 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1265557979
   )
   public int field984 = 5;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 539499465
   )
   @Export("replyMode")
   public int field985 = 2;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1286609341"
   )
   void method850(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method851(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "930594221"
   )
   void method851(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2502();
         this.field974 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field974[var4] = var1.method2502();
         }

         this.field972 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field972[var4] = var1.method2502();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field972[var4] += var1.method2502() << 16;
         }
      } else if(var2 == 2) {
         this.field967 = var1.method2502();
      } else if(var2 == 3) {
         var3 = var1.method2500();
         this.field977 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field977[var4] = var1.method2500();
         }

         this.field977[var3] = 9999999;
      } else if(var2 == 4) {
         this.field978 = true;
      } else if(5 == var2) {
         this.field984 = var1.method2500();
      } else if(var2 == 6) {
         this.field981 = var1.method2502();
      } else if(var2 == 7) {
         this.field979 = var1.method2502();
      } else if(8 == var2) {
         this.field982 = var1.method2500();
      } else if(9 == var2) {
         this.field983 = var1.method2500();
      } else if(var2 == 10) {
         this.field976 = var1.method2500();
      } else if(var2 == 11) {
         this.field985 = var1.method2500();
      } else if(12 == var2) {
         var3 = var1.method2500();
         this.field973 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] = var1.method2502();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] += var1.method2502() << 16;
         }
      } else if(13 == var2) {
         var3 = var1.method2500();
         this.field975 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field975[var4] = var1.method2662();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1952301534"
   )
   void method852() {
      if(-1 == this.field983) {
         if(this.field977 != null) {
            this.field983 = 2;
         } else {
            this.field983 = 0;
         }
      }

      if(this.field976 == -1) {
         if(null != this.field977) {
            this.field976 = 2;
         } else {
            this.field976 = 0;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "1034229274"
   )
   class105 method853(class105 var1, int var2) {
      var2 = this.field972[var2];
      class103 var3 = class84.method1893(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2287(true);
      } else {
         class105 var4 = var1.method2287(!var3.method2277(var2));
         var4.method2290(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass105;III)Lclass105;",
      garbageValue = "2014223051"
   )
   class105 method854(class105 var1, int var2, int var3) {
      var2 = this.field972[var2];
      class103 var4 = class84.method1893(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2286(true);
      } else {
         class105 var5 = var1.method2286(!var4.method2277(var2));
         var3 &= 3;
         if(1 == var3) {
            var5.method2295();
         } else if(var3 == 2) {
            var5.method2310();
         } else if(3 == var3) {
            var5.method2293();
         }

         var5.method2290(var4, var2);
         if(var3 == 1) {
            var5.method2293();
         } else if(var3 == 2) {
            var5.method2310();
         } else if(3 == var3) {
            var5.method2295();
         }

         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass105;ILclass42;II)Lclass105;",
      garbageValue = "-826180308"
   )
   public class105 method856(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field972[var2];
      class103 var5 = class84.method1893(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method858(var1, var4);
      } else {
         var4 = var3.field972[var4];
         class103 var6 = class84.method1893(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(null == var6) {
            var7 = var1.method2286(!var5.method2277(var2));
            var7.method2290(var5, var2);
            return var7;
         } else {
            var7 = var1.method2286(!var5.method2277(var2) & !var6.method2277(var4));
            var7.method2291(var5, var2, var6, var4, this.field977);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "1155354667"
   )
   public class105 method857(class105 var1, int var2) {
      int var3 = this.field972[var2];
      class103 var4 = class84.method1893(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2286(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(this.field973 != null && var2 < this.field973.length) {
            var6 = this.field973[var2];
            var5 = class84.method1893(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(var5 != null && '\uffff' != var6) {
            var7 = var1.method2286(!var4.method2277(var3) & !var5.method2277(var6));
            var7.method2290(var4, var3);
            var7.method2290(var5, var6);
            return var7;
         } else {
            var7 = var1.method2286(!var4.method2277(var3));
            var7.method2290(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "1732529612"
   )
   public class105 method858(class105 var1, int var2) {
      var2 = this.field972[var2];
      class103 var3 = class84.method1893(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2286(true);
      } else {
         class105 var4 = var1.method2286(!var3.method2277(var2));
         var4.method2290(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIII)V",
      garbageValue = "-1835366643"
   )
   static final void method880(class2 var0, int var1, int var2, int var3) {
      if(class47.field1053 != var0) {
         if(client.field415 < 400) {
            String var4;
            int var7;
            if(0 == var0.field39) {
               String var5 = var0.field61[0] + var0.field58 + var0.field61[1];
               var7 = var0.field41;
               int var8 = class47.field1053.field41;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class219.method3968(16711680);
               } else if(var9 < -6) {
                  var6 = class219.method3968(16723968);
               } else if(var9 < -3) {
                  var6 = class219.method3968(16740352);
               } else if(var9 < 0) {
                  var6 = class219.method3968(16756736);
               } else if(var9 > 9) {
                  var6 = class219.method3968('\uff00');
               } else if(var9 > 6) {
                  var6 = class219.method3968(4259584);
               } else if(var9 > 3) {
                  var6 = class219.method3968(8453888);
               } else if(var9 > 0) {
                  var6 = class219.method3968(12648192);
               } else {
                  var6 = class219.method3968(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.field41 + ")" + var0.field61[2];
            } else {
               var4 = var0.field61[0] + var0.field58 + var0.field61[1] + " " + " (" + "skill-" + var0.field39 + ")" + var0.field61[2];
            }

            int var10;
            if(1 == client.field280) {
               class125.method2769("Use", client.field427 + " " + "->" + " " + class219.method3968(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field511) {
               if((class11.field174 & 8) == 8) {
                  class125.method2769(client.field362, client.field313 + " " + "->" + " " + class219.method3968(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(null != client.field402[var10]) {
                     short var12 = 0;
                     if(client.field402[var10].equalsIgnoreCase("Attack")) {
                        if(client.field301 == class20.field565) {
                           continue;
                        }

                        if(client.field301 == class20.field559 || class20.field563 == client.field301 && var0.field41 > class47.field1053.field41) {
                           var12 = 2000;
                        }

                        if(class47.field1053.field55 != 0 && var0.field55 != 0) {
                           if(class47.field1053.field55 == var0.field55) {
                              var12 = 2000;
                           } else {
                              var12 = 0;
                           }
                        }
                     } else if(client.field403[var10]) {
                        var12 = 2000;
                     }

                     boolean var11 = false;
                     var7 = client.field510[var10] + var12;
                     class125.method2769(client.field402[var10], class219.method3968(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < client.field415; ++var10) {
               if(23 == client.field418[var10]) {
                  client.field290[var10] = class219.method3968(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
