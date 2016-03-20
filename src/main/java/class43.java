import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class43 extends class203 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -402590627
   )
   int field1006;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 953125663
   )
   int field1007 = 128;
   @ObfuscatedName("f")
   public static class192 field1008 = new class192(64);
   @ObfuscatedName("l")
   short[] field1009;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2049301033
   )
   int field1010;
   @ObfuscatedName("a")
   static class166 field1011;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 675365139
   )
   public int field1012 = -1;
   @ObfuscatedName("m")
   short[] field1013;
   @ObfuscatedName("r")
   static class166 field1014;
   @ObfuscatedName("n")
   short[] field1015;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 298029163
   )
   int field1016 = 0;
   @ObfuscatedName("j")
   short[] field1017;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1411573477
   )
   int field1018 = 128;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1252325611
   )
   int field1019 = 0;
   @ObfuscatedName("s")
   public static class192 field1020 = new class192(30);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -555448093
   )
   int field1021 = 0;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1223483229
   )
   static int field1022;

   @ObfuscatedName("f")
   void method907(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method908(var1, var2);
      }
   }

   @ObfuscatedName("s")
   void method908(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1006 = var1.method2514();
      } else if(var2 == 2) {
         this.field1012 = var1.method2514();
      } else if(var2 == 4) {
         this.field1007 = var1.method2514();
      } else if(var2 == 5) {
         this.field1018 = var1.method2514();
      } else if(6 == var2) {
         this.field1016 = var1.method2514();
      } else if(var2 == 7) {
         this.field1019 = var1.method2579();
      } else if(var2 == 8) {
         this.field1021 = var1.method2579();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2579();
            this.field1013 = new short[var3];
            this.field1017 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1013[var4] = (short)var1.method2514();
               this.field1017[var4] = (short)var1.method2514();
            }
         } else if(var2 == 41) {
            var3 = var1.method2579();
            this.field1015 = new short[var3];
            this.field1009 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1015[var4] = (short)var1.method2514();
               this.field1009[var4] = (short)var1.method2514();
            }
         }
      }

   }

   @ObfuscatedName("y")
   public final class104 method909(int var1) {
      class104 var2 = (class104)field1020.method3792((long)this.field1010);
      if(null == var2) {
         class99 var3 = class99.method2219(field1014, this.field1006, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field1013 != null) {
            for(var4 = 0; var4 < this.field1013.length; ++var4) {
               var3.method2254(this.field1013[var4], this.field1017[var4]);
            }
         }

         if(this.field1015 != null) {
            for(var4 = 0; var4 < this.field1015.length; ++var4) {
               var3.method2274(this.field1015[var4], this.field1009[var4]);
            }
         }

         var2 = var3.method2239(64 + this.field1019, 850 + this.field1021, -30, -50, -30);
         field1020.method3794(var2, (long)this.field1010);
      }

      class104 var5;
      if(-1 != this.field1012 && -1 != var1) {
         var5 = class134.method2875(this.field1012).method875(var2, var1);
      } else {
         var5 = var2.method2308(true);
      }

      if(this.field1007 != 128 || this.field1018 != 128) {
         var5.method2321(this.field1007, this.field1018, this.field1007);
      }

      if(this.field1016 != 0) {
         if(90 == this.field1016) {
            var5.method2316();
         }

         if(180 == this.field1016) {
            var5.method2316();
            var5.method2316();
         }

         if(this.field1016 == 270) {
            var5.method2316();
            var5.method2316();
            var5.method2316();
         }
      }

      return var5;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "-1144944302"
   )
   static final void method927(class39 var0, int var1, int var2, int var3) {
      if(client.field435 < 400) {
         if(var0.field909 != null) {
            var0 = var0.method774();
         }

         if(var0 != null) {
            if(var0.field889) {
               if(!var0.field920 || var1 == client.field461) {
                  String var4 = var0.field886;
                  if(0 != var0.field918) {
                     var4 = var4 + class141.method2997(var0.field918, class151.field2253.field31) + " " + " (" + "level-" + var0.field918 + ")";
                  }

                  if(1 == client.field446) {
                     class212.method3983("Use", client.field447 + " " + "->" + " " + class51.method1090(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field448) {
                     if((class15.field218 & 2) == 2) {
                        class212.method3983(client.field451, client.field452 + " " + "->" + " " + class51.method1090(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field901;
                     if(client.field464) {
                        var5 = client.method553(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(1 == var6) {
                                 var7 = 10;
                              }

                              if(2 == var6) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(4 == var6) {
                                 var7 = 13;
                              }

                              class212.method3983(var5[var6], class51.method1090(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class20.field589 != client.field332) {
                                 if(class20.field580 == client.field332 || client.field332 == class20.field583 && var0.field918 > class151.field2253.field31) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(0 == var6) {
                                    var8 = var9 + 9;
                                 }

                                 if(1 == var6) {
                                    var8 = var9 + 10;
                                 }

                                 if(2 == var6) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class212.method3983(var5[var6], class51.method1090(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class212.method3983("Examine", class51.method1090(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
