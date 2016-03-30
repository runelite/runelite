import java.awt.datatransfer.Clipboard;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1927194101
   )
   @Export("baseY")
   static int field37;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2062269465
   )
   int field38;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 227970017
   )
   int field39 = -1;
   @ObfuscatedName("ek")
   static class78[] field40;
   @ObfuscatedName("y")
   String[] field42 = new String[3];
   @ObfuscatedName("f")
   boolean field43;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -504519123
   )
   int field44;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 973404025
   )
   int field45;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -629569211
   )
   @Export("totalLevel")
   int field46;
   @ObfuscatedName("x")
   @Export("composition")
   class179 field47;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1177336515
   )
   int field48;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1450235573
   )
   int field49;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 990629507
   )
   @Export("combatLevel")
   int field50;
   @ObfuscatedName("a")
   @Export("model")
   class105 field51;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1083564081
   )
   int field52;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1849367441
   )
   int field53;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1030679699
   )
   int field54;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 983757383
   )
   int field55 = -1;
   @ObfuscatedName("h")
   boolean field56;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1556165309
   )
   int field57;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 568278429
   )
   int field58;
   @ObfuscatedName("w")
   @Export("name")
   String field59;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1704118051
   )
   int field60;
   @ObfuscatedName("g")
   boolean field61;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -584538403
   )
   int field62;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 744152189
   )
   int field63;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1954678581
   )
   static int field64;
   @ObfuscatedName("po")
   static Clipboard field65;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1033341921
   )
   @Export("team")
   int field66;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 833950983
   )
   int field67;

   @ObfuscatedName("x")
   int method15() {
      return this.field47 != null && this.field47.field2928 != -1?class36.method759(this.field47.field2928).field885:1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "8"
   )
   final void method16(int var1, int var2, byte var3) {
      if(super.field821 != -1 && class96.method2187(super.field821).field1004 == 1) {
         super.field821 = -1;
      }

      super.field876 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field872[0] >= 0 && super.field872[0] < 104 && super.field873[0] >= 0 && super.field873[0] < 104) {
            if(2 == var3) {
               class104.method2292(this, var1, var2, (byte)2);
            }

            this.method18(var1, var2, var3);
         } else {
            this.method17(var1, var2);
         }
      } else {
         this.method17(var1, var2);
      }

   }

   @ObfuscatedName("e")
   void method17(int var1, int var2) {
      super.field818 = 0;
      super.field875 = 0;
      super.field845 = 0;
      super.field872[0] = var1;
      super.field873[0] = var2;
      int var3 = this.method15();
      super.field849 = super.field872[0] * 128 + 64 * var3;
      super.field819 = super.field873[0] * 128 + 64 * var3;
   }

   @ObfuscatedName("y")
   final void method18(int var1, int var2, byte var3) {
      if(super.field818 < 9) {
         ++super.field818;
      }

      for(int var4 = super.field818; var4 > 0; --var4) {
         super.field872[var4] = super.field872[var4 - 1];
         super.field873[var4] = super.field873[var4 - 1];
         super.field874[var4] = super.field874[var4 - 1];
      }

      super.field872[0] = var1;
      super.field873[0] = var2;
      super.field874[0] = var3;
   }

   @ObfuscatedName("m")
   final boolean vmethod781() {
      return null != this.field47;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "14"
   )
   final void method22(class119 var1) {
      var1.field2011 = 0;
      int var2 = var1.method2506();
      this.field39 = var1.method2524();
      this.field55 = var1.method2524();
      int var3 = -1;
      this.field66 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2506();
         if(0 == var6) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2506();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && '\uffff' == var4[0]) {
               var3 = var1.method2508();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class50.method1055(var4[var5] - 512).field1159;
               if(var8 != 0) {
                  this.field66 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2506();
         if(var7 < 0 || var7 >= class20.field584[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field823 = var1.method2508();
      if(super.field823 == '\uffff') {
         super.field823 = -1;
      }

      super.field824 = var1.method2508();
      if('\uffff' == super.field824) {
         super.field824 = -1;
      }

      super.field825 = super.field824;
      super.field826 = var1.method2508();
      if('\uffff' == super.field826) {
         super.field826 = -1;
      }

      super.field827 = var1.method2508();
      if(super.field827 == '\uffff') {
         super.field827 = -1;
      }

      super.field828 = var1.method2508();
      if(super.field828 == '\uffff') {
         super.field828 = -1;
      }

      super.field829 = var1.method2508();
      if(super.field829 == '\uffff') {
         super.field829 = -1;
      }

      super.field868 = var1.method2508();
      if('\uffff' == super.field868) {
         super.field868 = -1;
      }

      if(class167.field2692 == this) {
         class148.field2242 = this.field59;
      }

      this.field50 = var1.method2506();
      this.field44 = var1.method2508();
      this.field43 = var1.method2506() == 1;
      if(client.field299 == 0 && client.field461 >= 2) {
         this.field43 = false;
      }

      if(this.field47 == null) {
         this.field47 = new class179();
      }

      this.field47.method3491(var4, var9, 1 == var2, var3);
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field42[var1] = "";
      }

      this.field50 = 0;
      this.field44 = 0;
      this.field46 = 0;
      this.field57 = 0;
      this.field56 = false;
      this.field66 = 0;
      this.field43 = false;
      this.field61 = false;
   }

   @ObfuscatedName("t")
   protected final class105 vmethod1901() {
      if(null == this.field47) {
         return null;
      } else {
         class42 var1 = -1 != super.field821 && super.field852 == 0?class96.method2187(super.field821):null;
         class42 var2 = super.field846 == -1 || this.field56 || super.field823 == super.field846 && var1 != null?null:class96.method2187(super.field846);
         class105 var3 = this.field47.method3497(var1, super.field850, var2, super.field837);
         if(null == var3) {
            return null;
         } else {
            var3.method2323();
            super.field867 = var3.field1467;
            class105 var4;
            class105[] var5;
            if(!this.field56 && -1 != super.field854 && super.field869 != -1) {
               var4 = class29.method669(super.field854).method937(super.field869);
               if(null != var4) {
                  var4.method2341(0, -super.field858, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field56 && this.field51 != null) {
               if(client.field305 >= this.field57) {
                  this.field51 = null;
               }

               if(client.field305 >= this.field46 && client.field305 < this.field57) {
                  var4 = this.field51;
                  var4.method2341(this.field48 - super.field849, this.field49 - this.field45, this.field38 - super.field819);
                  if(super.field847 == 512) {
                     var4.method2310();
                     var4.method2310();
                     var4.method2310();
                  } else if(1024 == super.field847) {
                     var4.method2310();
                     var4.method2310();
                  } else if(1536 == super.field847) {
                     var4.method2310();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(512 == super.field847) {
                     var4.method2310();
                  } else if(1024 == super.field847) {
                     var4.method2310();
                     var4.method2310();
                  } else if(1536 == super.field847) {
                     var4.method2310();
                     var4.method2310();
                     var4.method2310();
                  }

                  var4.method2341(super.field849 - this.field48, this.field45 - this.field49, super.field819 - this.field38);
               }
            }

            var3.field1870 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIB)V",
      garbageValue = "-69"
   )
   static final void method40(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(var9 != null && (!var9.field2766 || 0 == var9.field2814 || var9.field2847 || class169.method3395(var9) != 0 || var9 == client.field468 || 1338 == var9.field2890) && var1 == var9.field2786 && (!var9.field2766 || !class102.method2282(var9))) {
            int var10 = var9.field2780 + var6;
            int var11 = var9.field2892 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2814 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2814 == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2767 + var10;
               var19 = var11 + var9.field2783;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.field2767 + var10;
               var17 = var9.field2783 + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field353) {
               client.field475 = true;
               client.field476 = var10;
               client.field477 = var11;
            }

            if(!var9.field2766 || var12 < var14 && var13 < var15) {
               var16 = class140.field2168;
               var17 = class140.field2182;
               if(class140.field2177 != 0) {
                  var16 = class140.field2176;
                  var17 = class140.field2167;
               }

               int var21;
               int var22;
               int var23;
               int var24;
               int var27;
               int var29;
               int var34;
               int var46;
               int var54;
               if(1337 == var9.field2890) {
                  if(!client.field295 && !client.field433 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(client.field381 == 0 && !client.field573) {
                        class75.method1625("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var34 = 0; var34 < class105.field1852; ++var34) {
                        var21 = class105.field1859[var34];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        var46 = var21 >> 14 & 32767;
                        if(var19 != var21) {
                           var19 = var21;
                           if(2 == var24 && class3.field75.method1938(class82.field1437, var22, var23, var21) >= 0) {
                              class40 var53 = class22.method592(var46);
                              if(null != var53.field943) {
                                 var53 = var53.method842();
                              }

                              if(var53 == null) {
                                 continue;
                              }

                              if(1 == client.field381) {
                                 class75.method1625("Use", client.field366 + " " + "->" + " " + class72.method1574('\uffff') + var53.field970, 1, var21, var22, var23);
                              } else if(client.field573) {
                                 if((class1.field20 & 4) == 4) {
                                    class75.method1625(client.field315, client.field453 + " " + "->" + " " + class72.method1574('\uffff') + var53.field970, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var52 = var53.field953;
                                 if(client.field465) {
                                    var52 = class137.method2910(var52);
                                 }

                                 if(var52 != null) {
                                    for(var54 = 4; var54 >= 0; --var54) {
                                       if(null != var52[var54]) {
                                          short var60 = 0;
                                          if(0 == var54) {
                                             var60 = 3;
                                          }

                                          if(1 == var54) {
                                             var60 = 4;
                                          }

                                          if(2 == var54) {
                                             var60 = 5;
                                          }

                                          if(var54 == 3) {
                                             var60 = 6;
                                          }

                                          if(4 == var54) {
                                             var60 = 1001;
                                          }

                                          class75.method1625(var52[var54], class72.method1574('\uffff') + var53.field970, var60, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class75.method1625("Examine", class72.method1574('\uffff') + var53.field970, 1002, var53.field936 << 14, var22, var23);
                              }
                           }

                           class34 var57;
                           int[] var59;
                           class2 var63;
                           if(1 == var24) {
                              class34 var55 = client.field331[var46];
                              if(var55 == null) {
                                 continue;
                              }

                              if(1 == var55.field781.field885 && 64 == (var55.field849 & 127) && 64 == (var55.field819 & 127)) {
                                 for(var27 = 0; var27 < client.field332; ++var27) {
                                    var57 = client.field331[client.field333[var27]];
                                    if(var57 != null && var55 != var57 && var57.field781.field885 == 1 && var55.field849 == var57.field849 && var57.field819 == var55.field819) {
                                       class137.method2924(var57.field781, client.field333[var27], var22, var23);
                                    }
                                 }

                                 var27 = class32.field751;
                                 var59 = class32.field757;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var63 = client.field415[var59[var29]];
                                    if(var63 != null && var63.field849 == var55.field849 && var55.field819 == var63.field819) {
                                       class19.method231(var63, var59[var29], var22, var23);
                                    }
                                 }
                              }

                              class137.method2924(var55.field781, var46, var22, var23);
                           }

                           if(0 == var24) {
                              class2 var56 = client.field415[var46];
                              if(null == var56) {
                                 continue;
                              }

                              if((var56.field849 & 127) == 64 && (var56.field819 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field332; ++var27) {
                                    var57 = client.field331[client.field333[var27]];
                                    if(var57 != null && var57.field781.field885 == 1 && var57.field849 == var56.field849 && var57.field819 == var56.field819) {
                                       class137.method2924(var57.field781, client.field333[var27], var22, var23);
                                    }
                                 }

                                 var27 = class32.field751;
                                 var59 = class32.field757;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var63 = client.field415[var59[var29]];
                                    if(null != var63 && var56 != var63 && var63.field849 == var56.field849 && var56.field819 == var63.field819) {
                                       class19.method231(var63, var59[var29], var22, var23);
                                    }
                                 }
                              }

                              if(client.field424 != var46) {
                                 class19.method231(var56, var46, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var24 == 3) {
                              class199 var58 = client.field425[class82.field1437][var22][var23];
                              if(null != var58) {
                                 for(class28 var61 = (class28)var58.method3840(); var61 != null; var61 = (class28)var58.method3842()) {
                                    class51 var62 = class50.method1055(var61.field686);
                                    if(1 == client.field381) {
                                       class75.method1625("Use", client.field366 + " " + "->" + " " + class72.method1574(16748608) + var62.field1122, 16, var61.field686, var22, var23);
                                    } else if(client.field573) {
                                       if((class1.field20 & 1) == 1) {
                                          class75.method1625(client.field315, client.field453 + " " + "->" + " " + class72.method1574(16748608) + var62.field1122, 17, var61.field686, var22, var23);
                                       }
                                    } else {
                                       String[] var64 = var62.field1136;
                                       if(client.field465) {
                                          var64 = class137.method2910(var64);
                                       }

                                       for(int var65 = 4; var65 >= 0; --var65) {
                                          if(null != var64 && var64[var65] != null) {
                                             byte var31 = 0;
                                             if(0 == var65) {
                                                var31 = 18;
                                             }

                                             if(var65 == 1) {
                                                var31 = 19;
                                             }

                                             if(var65 == 2) {
                                                var31 = 20;
                                             }

                                             if(var65 == 3) {
                                                var31 = 21;
                                             }

                                             if(var65 == 4) {
                                                var31 = 22;
                                             }

                                             class75.method1625(var64[var65], class72.method1574(16748608) + var62.field1122, var31, var61.field686, var22, var23);
                                          } else if(var65 == 2) {
                                             class75.method1625("Take", class72.method1574(16748608) + var62.field1122, 20, var61.field686, var22, var23);
                                          }
                                       }

                                       class75.method1625("Examine", class72.method1574(16748608) + var62.field1122, 1004, var61.field686, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var34 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        class2 var49 = client.field415[client.field424];
                        class19.method231(var49, client.field424, var34, var21);
                     }
                  }
               } else if(var9.field2890 == 1338) {
                  if((client.field334 == 0 || 3 == client.field334) && (class140.field2177 == 1 || !class39.field922 && 4 == class140.field2177)) {
                     class175 var44 = var9.method3424(true);
                     if(var44 != null) {
                        var19 = class140.field2176 - var10;
                        var34 = class140.field2167 - var11;
                        if(var44.method3475(var19, var34)) {
                           var19 -= var44.field2911 / 2;
                           var34 -= var44.field2912 / 2;
                           var21 = client.field365 + client.field388 & 2047;
                           var22 = class91.field1573[var21];
                           var23 = class91.field1595[var21];
                           var22 = (256 + client.field367) * var22 >> 8;
                           var23 = (client.field367 + 256) * var23 >> 8;
                           var24 = var23 * var19 + var34 * var22 >> 11;
                           var46 = var34 * var23 - var19 * var22 >> 11;
                           int var51 = class167.field2692.field849 + var24 >> 7;
                           var27 = class167.field2692.field819 - var46 >> 7;
                           client.field318.method2757(99);
                           client.field318.method2573(18);
                           client.field318.method2573(class137.field2135[82]?(class137.field2135[81]?2:1):0);
                           client.field318.method2538(var27 + field37);
                           client.field318.method2540(var51 + class41.field990);
                           client.field318.method2573(var19);
                           client.field318.method2573(var34);
                           client.field318.method2492(client.field388);
                           client.field318.method2573(57);
                           client.field318.method2573(client.field365);
                           client.field318.method2573(client.field367);
                           client.field318.method2573(89);
                           client.field318.method2492(class167.field2692.field849);
                           client.field318.method2492(class167.field2692.field819);
                           client.field318.method2573(63);
                           client.field533 = var51;
                           client.field529 = var27;
                        }
                     }
                  }
               } else {
                  if(!client.field433 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(1 == var9.field2777) {
                        class75.method1625(var9.field2782, "", 24, 0, 0, var9.field2838);
                     }

                     String var20;
                     if(var9.field2777 == 2 && !client.field573) {
                        var20 = class10.method134(var9);
                        if(var20 != null) {
                           class75.method1625(var20, class72.method1574('\uff00') + var9.field2818, 25, 0, -1, var9.field2838);
                        }
                     }

                     if(3 == var9.field2777) {
                        class75.method1625("Close", "", 26, 0, 0, var9.field2838);
                     }

                     if(var9.field2777 == 4) {
                        class75.method1625(var9.field2782, "", 28, 0, 0, var9.field2838);
                     }

                     if(var9.field2777 == 5) {
                        class75.method1625(var9.field2782, "", 29, 0, 0, var9.field2838);
                     }

                     if(var9.field2777 == 6 && null == client.field458) {
                        class75.method1625(var9.field2782, "", 30, 0, -1, var9.field2838);
                     }

                     if(var9.field2814 == 2) {
                        var34 = 0;

                        for(var21 = 0; var21 < var9.field2783; ++var21) {
                           for(var22 = 0; var22 < var9.field2767; ++var22) {
                              var23 = var22 * (var9.field2833 + 32);
                              var24 = (32 + var9.field2834) * var21;
                              if(var34 < 20) {
                                 var23 += var9.field2835[var34];
                                 var24 += var9.field2848[var34];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < var23 + 32 && var19 < var24 + 32) {
                                 client.field541 = var34;
                                 class35.field790 = var9;
                                 if(var9.field2885[var34] > 0) {
                                    class51 var25 = class50.method1055(var9.field2885[var34] - 1);
                                    if(1 == client.field381 && class59.method1280(class169.method3395(var9))) {
                                       if(var9.field2838 != class41.field980 || var34 != class59.field1224) {
                                          class75.method1625("Use", client.field366 + " " + "->" + " " + class72.method1574(16748608) + var25.field1122, 31, var25.field1127, var34, var9.field2838);
                                       }
                                    } else if(client.field573 && class59.method1280(class169.method3395(var9))) {
                                       if((class1.field20 & 16) == 16) {
                                          class75.method1625(client.field315, client.field453 + " " + "->" + " " + class72.method1574(16748608) + var25.field1122, 32, var25.field1127, var34, var9.field2838);
                                       }
                                    } else {
                                       String[] var26 = var25.field1112;
                                       if(client.field465) {
                                          var26 = class137.method2910(var26);
                                       }

                                       if(class59.method1280(class169.method3395(var9))) {
                                          for(var27 = 4; var27 >= 3; --var27) {
                                             if(null != var26 && null != var26[var27]) {
                                                byte var28;
                                                if(var27 == 3) {
                                                   var28 = 36;
                                                } else {
                                                   var28 = 37;
                                                }

                                                class75.method1625(var26[var27], class72.method1574(16748608) + var25.field1122, var28, var25.field1127, var34, var9.field2838);
                                             } else if(4 == var27) {
                                                class75.method1625("Drop", class72.method1574(16748608) + var25.field1122, 37, var25.field1127, var34, var9.field2838);
                                             }
                                          }
                                       }

                                       var54 = class169.method3395(var9);
                                       boolean var50 = (var54 >> 31 & 1) != 0;
                                       if(var50) {
                                          class75.method1625("Use", class72.method1574(16748608) + var25.field1122, 38, var25.field1127, var34, var9.field2838);
                                       }

                                       class178 var10000 = (class178)null;
                                       byte var30;
                                       if(class59.method1280(class169.method3395(var9)) && var26 != null) {
                                          for(var29 = 2; var29 >= 0; --var29) {
                                             if(var26[var29] != null) {
                                                var30 = 0;
                                                if(var29 == 0) {
                                                   var30 = 33;
                                                }

                                                if(var29 == 1) {
                                                   var30 = 34;
                                                }

                                                if(2 == var29) {
                                                   var30 = 35;
                                                }

                                                class75.method1625(var26[var29], class72.method1574(16748608) + var25.field1122, var30, var25.field1127, var34, var9.field2838);
                                             }
                                          }
                                       }

                                       var26 = var9.field2871;
                                       if(client.field465) {
                                          var26 = class137.method2910(var26);
                                       }

                                       if(var26 != null) {
                                          for(var29 = 4; var29 >= 0; --var29) {
                                             if(var26[var29] != null) {
                                                var30 = 0;
                                                if(0 == var29) {
                                                   var30 = 39;
                                                }

                                                if(var29 == 1) {
                                                   var30 = 40;
                                                }

                                                if(2 == var29) {
                                                   var30 = 41;
                                                }

                                                if(var29 == 3) {
                                                   var30 = 42;
                                                }

                                                if(var29 == 4) {
                                                   var30 = 43;
                                                }

                                                class75.method1625(var26[var29], class72.method1574(16748608) + var25.field1122, var30, var25.field1127, var34, var9.field2838);
                                             }
                                          }
                                       }

                                       class75.method1625("Examine", class72.method1574(16748608) + var25.field1122, 1005, var25.field1127, var34, var9.field2838);
                                    }
                                 }
                              }

                              ++var34;
                           }
                        }
                     }

                     if(var9.field2766) {
                        if(client.field573) {
                           if(class131.method2845(class169.method3395(var9)) && (class1.field20 & 32) == 32) {
                              class75.method1625(client.field315, client.field453 + " " + "->" + " " + var9.field2870, 58, 0, var9.field2802, var9.field2838);
                           }
                        } else {
                           for(var34 = 9; var34 >= 5; --var34) {
                              var23 = class169.method3395(var9);
                              boolean var40 = (var23 >> var34 + 1 & 1) != 0;
                              String var38;
                              if(!var40 && var9.field2867 == null) {
                                 var38 = null;
                              } else if(null != var9.field2842 && var9.field2842.length > var34 && var9.field2842[var34] != null && var9.field2842[var34].trim().length() != 0) {
                                 var38 = var9.field2842[var34];
                              } else {
                                 var38 = null;
                              }

                              if(var38 != null) {
                                 class75.method1625(var38, var9.field2870, 1007, 1 + var34, var9.field2802, var9.field2838);
                              }
                           }

                           var20 = class10.method134(var9);
                           if(var20 != null) {
                              class75.method1625(var20, var9.field2870, 25, 0, var9.field2802, var9.field2838);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              var24 = class169.method3395(var9);
                              boolean var45 = (var24 >> var21 + 1 & 1) != 0;
                              String var41;
                              if(!var45 && null == var9.field2867) {
                                 var41 = null;
                              } else if(null != var9.field2842 && var9.field2842.length > var21 && var9.field2842[var21] != null && var9.field2842[var21].trim().length() != 0) {
                                 var41 = var9.field2842[var21];
                              } else {
                                 var41 = null;
                              }

                              if(var41 != null) {
                                 class75.method1625(var41, var9.field2870, 57, 1 + var21, var9.field2802, var9.field2838);
                              }
                           }

                           var22 = class169.method3395(var9);
                           boolean var42 = 0 != (var22 & 1);
                           if(var42) {
                              class75.method1625("Continue", "", 30, 0, var9.field2802, var9.field2838);
                           }
                        }
                     }
                  }

                  if(0 == var9.field2814) {
                     if(!var9.field2766 && class102.method2282(var9) && class99.field1693 != var9) {
                        continue;
                     }

                     method40(var0, var9.field2838, var12, var13, var14, var15, var10 - var9.field2788, var11 - var9.field2882);
                     if(null != var9.field2891) {
                        method40(var9.field2891, var9.field2838, var12, var13, var14, var15, var10 - var9.field2788, var11 - var9.field2882);
                     }

                     class3 var32 = (class3)client.field455.method3806((long)var9.field2838);
                     if(var32 != null) {
                        if(0 == var32.field79 && class140.field2168 >= var12 && class140.field2182 >= var13 && class140.field2168 < var14 && class140.field2182 < var15 && !client.field433 && !client.field521) {
                           for(class0 var35 = (class0)client.field493.method3836(); null != var35; var35 = (class0)client.field493.method3841()) {
                              if(var35.field1) {
                                 var35.method3935();
                                 var35.field2.field2803 = false;
                              }
                           }

                           if(0 == class167.field2706) {
                              client.field353 = null;
                              client.field468 = null;
                           }

                           if(!client.field433) {
                              client.field440[0] = "Cancel";
                              client.field441[0] = "";
                              client.field448[0] = 1006;
                              client.field435 = 1;
                           }
                        }

                        var19 = var32.field74;
                        if(class39.method817(var19)) {
                           method40(class173.field2830[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2766) {
                     class0 var33;
                     if(!var9.field2900) {
                        if(var9.field2901 && class140.field2168 >= var12 && class140.field2182 >= var13 && class140.field2168 < var14 && class140.field2182 < var15) {
                           for(var33 = (class0)client.field493.method3836(); null != var33; var33 = (class0)client.field493.method3841()) {
                              if(var33.field1 && var33.field7 == var33.field2.field2773) {
                                 var33.method3935();
                              }
                           }
                        }
                     } else if(class140.field2168 >= var12 && class140.field2182 >= var13 && class140.field2168 < var14 && class140.field2182 < var15) {
                        for(var33 = (class0)client.field493.method3836(); null != var33; var33 = (class0)client.field493.method3841()) {
                           if(var33.field1) {
                              var33.method3935();
                              var33.field2.field2803 = false;
                           }
                        }

                        if(class167.field2706 == 0) {
                           client.field353 = null;
                           client.field468 = null;
                        }

                        if(!client.field433) {
                           client.field440[0] = "Cancel";
                           client.field441[0] = "";
                           client.field448[0] = 1006;
                           client.field435 = 1;
                        }
                     }

                     boolean var36;
                     if(class140.field2168 >= var12 && class140.field2182 >= var13 && class140.field2168 < var14 && class140.field2182 < var15) {
                        var36 = true;
                     } else {
                        var36 = false;
                     }

                     boolean var37 = false;
                     if((1 == class140.field2184 || !class39.field922 && class140.field2184 == 4) && var36) {
                        var37 = true;
                     }

                     boolean var39 = false;
                     if((1 == class140.field2177 || !class39.field922 && class140.field2177 == 4) && class140.field2176 >= var12 && class140.field2167 >= var13 && class140.field2176 < var14 && class140.field2167 < var15) {
                        var39 = true;
                     }

                     if(var39) {
                        class10.method128(var9, class140.field2176 - var10, class140.field2167 - var11);
                     }

                     if(null != client.field353 && client.field353 != var9 && var36 && class155.method3192(class169.method3395(var9))) {
                        client.field352 = var9;
                     }

                     if(client.field468 == var9) {
                        client.field382 = true;
                        client.field473 = var10;
                        client.field335 = var11;
                     }

                     if(var9.field2847) {
                        class0 var43;
                        if(var36 && client.field492 != 0 && var9.field2773 != null) {
                           var43 = new class0();
                           var43.field1 = true;
                           var43.field2 = var9;
                           var43.field0 = client.field492;
                           var43.field7 = var9.field2773;
                           client.field493.method3834(var43);
                        }

                        if(client.field353 != null || null != class9.field175 || client.field433) {
                           var39 = false;
                           var37 = false;
                           var36 = false;
                        }

                        if(!var9.field2893 && var39) {
                           var9.field2893 = true;
                           if(var9.field2849 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field3 = class140.field2176 - var10;
                              var43.field0 = class140.field2167 - var11;
                              var43.field7 = var9.field2849;
                              client.field493.method3834(var43);
                           }
                        }

                        if(var9.field2893 && var37 && var9.field2850 != null) {
                           var43 = new class0();
                           var43.field1 = true;
                           var43.field2 = var9;
                           var43.field3 = class140.field2168 - var10;
                           var43.field0 = class140.field2182 - var11;
                           var43.field7 = var9.field2850;
                           client.field493.method3834(var43);
                        }

                        if(var9.field2893 && !var37) {
                           var9.field2893 = false;
                           if(null != var9.field2896) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field3 = class140.field2168 - var10;
                              var43.field0 = class140.field2182 - var11;
                              var43.field7 = var9.field2896;
                              client.field489.method3834(var43);
                           }
                        }

                        if(var37 && var9.field2852 != null) {
                           var43 = new class0();
                           var43.field1 = true;
                           var43.field2 = var9;
                           var43.field3 = class140.field2168 - var10;
                           var43.field0 = class140.field2182 - var11;
                           var43.field7 = var9.field2852;
                           client.field493.method3834(var43);
                        }

                        if(!var9.field2803 && var36) {
                           var9.field2803 = true;
                           if(var9.field2781 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field3 = class140.field2168 - var10;
                              var43.field0 = class140.field2182 - var11;
                              var43.field7 = var9.field2781;
                              client.field493.method3834(var43);
                           }
                        }

                        if(var9.field2803 && var36 && var9.field2762 != null) {
                           var43 = new class0();
                           var43.field1 = true;
                           var43.field2 = var9;
                           var43.field3 = class140.field2168 - var10;
                           var43.field0 = class140.field2182 - var11;
                           var43.field7 = var9.field2762;
                           client.field493.method3834(var43);
                        }

                        if(var9.field2803 && !var36) {
                           var9.field2803 = false;
                           if(null != var9.field2855) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field3 = class140.field2168 - var10;
                              var43.field0 = class140.field2182 - var11;
                              var43.field7 = var9.field2855;
                              client.field489.method3834(var43);
                           }
                        }

                        if(var9.field2866 != null) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2866;
                           client.field359.method3834(var43);
                        }

                        class0 var47;
                        if(null != var9.field2860 && client.field481 > var9.field2895) {
                           if(null != var9.field2861 && client.field481 - var9.field2895 <= 32) {
                              label1427:
                              for(var21 = var9.field2895; var21 < client.field481; ++var21) {
                                 var22 = client.field480[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2861.length; ++var23) {
                                    if(var9.field2861[var23] == var22) {
                                       var47 = new class0();
                                       var47.field2 = var9;
                                       var47.field7 = var9.field2860;
                                       client.field493.method3834(var47);
                                       break label1427;
                                    }
                                 }
                              }
                           } else {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field7 = var9.field2860;
                              client.field493.method3834(var43);
                           }

                           var9.field2895 = client.field481;
                        }

                        if(null != var9.field2862 && client.field483 > var9.field2801) {
                           if(var9.field2775 != null && client.field483 - var9.field2801 <= 32) {
                              label1403:
                              for(var21 = var9.field2801; var21 < client.field483; ++var21) {
                                 var22 = client.field554[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2775.length; ++var23) {
                                    if(var22 == var9.field2775[var23]) {
                                       var47 = new class0();
                                       var47.field2 = var9;
                                       var47.field7 = var9.field2862;
                                       client.field493.method3834(var47);
                                       break label1403;
                                    }
                                 }
                              }
                           } else {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field7 = var9.field2862;
                              client.field493.method3834(var43);
                           }

                           var9.field2801 = client.field483;
                        }

                        if(var9.field2864 != null && client.field410 > var9.field2897) {
                           if(var9.field2865 != null && client.field410 - var9.field2897 <= 32) {
                              label1379:
                              for(var21 = var9.field2897; var21 < client.field410; ++var21) {
                                 var22 = client.field484[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2865.length; ++var23) {
                                    if(var22 == var9.field2865[var23]) {
                                       var47 = new class0();
                                       var47.field2 = var9;
                                       var47.field7 = var9.field2864;
                                       client.field493.method3834(var47);
                                       break label1379;
                                    }
                                 }
                              }
                           } else {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field7 = var9.field2864;
                              client.field493.method3834(var43);
                           }

                           var9.field2897 = client.field410;
                        }

                        if(client.field457 > var9.field2894 && var9.field2869 != null) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2869;
                           client.field493.method3834(var43);
                        }

                        if(client.field572 > var9.field2894 && var9.field2829 != null) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2829;
                           client.field493.method3834(var43);
                        }

                        if(client.field472 > var9.field2894 && null != var9.field2872) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2872;
                           client.field493.method3834(var43);
                        }

                        if(client.field314 > var9.field2894 && null != var9.field2877) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2877;
                           client.field493.method3834(var43);
                        }

                        if(client.field490 > var9.field2894 && null != var9.field2878) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2878;
                           client.field493.method3834(var43);
                        }

                        if(client.field495 > var9.field2894 && null != var9.field2809) {
                           var43 = new class0();
                           var43.field2 = var9;
                           var43.field7 = var9.field2809;
                           client.field493.method3834(var43);
                        }

                        var9.field2894 = client.field491;
                        if(var9.field2863 != null) {
                           for(var21 = 0; var21 < client.field517; ++var21) {
                              class0 var48 = new class0();
                              var48.field2 = var9;
                              var48.field19 = client.field519[var21];
                              var48.field8 = client.field399[var21];
                              var48.field7 = var9.field2863;
                              client.field493.method3834(var48);
                           }
                        }
                     }
                  }

                  if(!var9.field2766 && null == client.field353 && null == class9.field175 && !client.field433) {
                     if((var9.field2761 >= 0 || var9.field2794 != 0) && class140.field2168 >= var12 && class140.field2182 >= var13 && class140.field2168 < var14 && class140.field2182 < var15) {
                        if(var9.field2761 >= 0) {
                           class99.field1693 = var0[var9.field2761];
                        } else {
                           class99.field1693 = var9;
                        }
                     }

                     if(var9.field2814 == 8 && class140.field2168 >= var12 && class140.field2182 >= var13 && class140.field2168 < var14 && class140.field2182 < var15) {
                        class0.field12 = var9;
                     }

                     if(var9.field2791 > var9.field2783) {
                        class151.method3172(var9, var10 + var9.field2767, var11, var9.field2783, var9.field2791, class140.field2168, class140.field2182);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   public static void method41(class122 var0) {
      class210 var1 = (class210)class211.field3139.method3879();
      if(var1 != null) {
         int var2 = var0.field2011;
         var0.method2494(var1.field3131);

         for(int var3 = 0; var3 < var1.field3133; ++var3) {
            if(0 != var1.field3130[var3]) {
               var0.method2573(var1.field3130[var3]);
            } else {
               try {
                  int var4 = var1.field3137[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3134[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2573(0);
                     var0.method2494(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3134[var3];
                     var5.setInt((Object)null, var1.field3135[var3]);
                     var0.method2573(0);
                  } else if(2 == var4) {
                     var5 = var1.field3134[var3];
                     var6 = var5.getModifiers();
                     var0.method2573(0);
                     var0.method2494(var6);
                  }

                  Method var22;
                  if(3 != var4) {
                     if(4 == var4) {
                        var22 = var1.field3136[var3];
                        var6 = var22.getModifiers();
                        var0.method2573(0);
                        var0.method2494(var6);
                     }
                  } else {
                     var22 = var1.field3136[var3];
                     byte[][] var23 = var1.field3132[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(var24 == null) {
                        var0.method2573(0);
                     } else if(var24 instanceof Number) {
                        var0.method2573(1);
                        var0.method2496(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2573(2);
                        var0.method2661((String)var24);
                     } else {
                        var0.method2573(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2573(-10);
               } catch (InvalidClassException var11) {
                  var0.method2573(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2573(-12);
               } catch (OptionalDataException var13) {
                  var0.method2573(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2573(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2573(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2573(-16);
               } catch (SecurityException var17) {
                  var0.method2573(-17);
               } catch (IOException var18) {
                  var0.method2573(-18);
               } catch (NullPointerException var19) {
                  var0.method2573(-19);
               } catch (Exception var20) {
                  var0.method2573(-20);
               } catch (Throwable var21) {
                  var0.method2573(-21);
               }
            }
         }

         var0.method2527(var2);
         var1.method3935();
      }
   }
}
