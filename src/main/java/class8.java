import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class8 {
   @ObfuscatedName("bi")
   static class168 field151;
   @ObfuscatedName("bn")
   static class168 field152;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1764035609
   )
   static int field153 = 4;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2038174869
   )
   int field155 = 1;
   @ObfuscatedName("y")
   LinkedHashMap field156 = new LinkedHashMap();
   @ObfuscatedName("p")
   boolean field157;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -48211671
   )
   static int field158;
   @ObfuscatedName("kq")
   static class131 field159;
   @ObfuscatedName("mn")
   @Export("clanMembers")
   static class24[] field162;
   @ObfuscatedName("d")
   static String field163;
   @ObfuscatedName("t")
   boolean field164;

   @ObfuscatedName("w")
   void method102() {
   }

   class8(class119 var1) {
      if(var1 != null && var1.field2012 != null) {
         int var2 = var1.method2506();
         if(var2 >= 0 && var2 <= field153) {
            if(var1.method2506() == 1) {
               this.field164 = true;
            }

            if(var2 > 1) {
               this.field157 = var1.method2506() == 1;
            }

            if(var2 > 3) {
               this.field155 = var1.method2506();
            }

            if(var2 > 2) {
               int var3 = var1.method2506();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2511();
                  int var6 = var1.method2511();
                  this.field156.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method102();
         }
      } else {
         this.method102();
      }

   }

   @ObfuscatedName("x")
   class119 method104() {
      class119 var1 = new class119(100);
      var1.method2573(field153);
      var1.method2573(this.field164?1:0);
      var1.method2573(this.field157?1:0);
      var1.method2573(this.field155);
      var1.method2573(this.field156.size());
      Iterator var2 = this.field156.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2494(((Integer)var3.getKey()).intValue());
         var1.method2494(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIII)V",
      garbageValue = "-2088033197"
   )
   static final void method105(class173 var0, int var1, int var2, int var3) {
      class59.method1272();
      class175 var4 = var0.method3424(false);
      if(var4 != null) {
         class79.method1773(var1, var2, var1 + var4.field2911, var4.field2912 + var2);
         if(2 != client.field334 && client.field334 != 5) {
            int var5 = client.field365 + client.field388 & 2047;
            int var6 = class167.field2692.field849 / 32 + 48;
            int var7 = 464 - class167.field2692.field819 / 32;
            class7.field143.method1710(var1, var2, var4.field2911, var4.field2912, var6, var7, var5, 256 + client.field367, var4.field2909, var4.field2914);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < client.field390; ++var8) {
               var9 = 2 + client.field525[var8] * 4 - class167.field2692.field849 / 32;
               var10 = client.field526[var8] * 4 + 2 - class167.field2692.field819 / 32;
               class28.method660(var1, var2, var9, var10, client.field487[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  class199 var19 = client.field425[class82.field1437][var8][var9];
                  if(null != var19) {
                     var11 = var8 * 4 + 2 - class167.field2692.field849 / 32;
                     var12 = 4 * var9 + 2 - class167.field2692.field819 / 32;
                     class28.method660(var1, var2, var11, var12, class7.field142[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field332; ++var8) {
               class34 var17 = client.field331[client.field333[var8]];
               if(null != var17 && var17.vmethod781()) {
                  class39 var20 = var17.field781;
                  if(var20 != null && null != var20.field915) {
                     var20 = var20.method793();
                  }

                  if(null != var20 && var20.field906 && var20.field896) {
                     var11 = var17.field849 / 32 - class167.field2692.field849 / 32;
                     var12 = var17.field819 / 32 - class167.field2692.field819 / 32;
                     class28.method660(var1, var2, var11, var12, class7.field142[1], var4);
                  }
               }
            }

            var8 = class32.field751;
            int[] var18 = class32.field757;

            for(var10 = 0; var10 < var8; ++var10) {
               class2 var21 = client.field415[var18[var10]];
               if(var21 != null && var21.vmethod781() && !var21.field43 && class167.field2692 != var21) {
                  var12 = var21.field849 / 32 - class167.field2692.field849 / 32;
                  int var13 = var21.field819 / 32 - class167.field2692.field819 / 32;
                  boolean var14 = false;
                  if(class130.method2834(var21.field59, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class11.field189; ++var16) {
                     if(var21.field59.equals(field162[var16].field634)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var24 = false;
                  if(class167.field2692.field66 != 0 && 0 != var21.field66 && var21.field66 == class167.field2692.field66) {
                     var24 = true;
                  }

                  if(var14) {
                     class28.method660(var1, var2, var12, var13, class7.field142[3], var4);
                  } else if(var24) {
                     class28.method660(var1, var2, var12, var13, class7.field142[4], var4);
                  } else if(var15) {
                     class28.method660(var1, var2, var12, var13, class7.field142[5], var4);
                  } else {
                     class28.method660(var1, var2, var12, var13, class7.field142[2], var4);
                  }
               }
            }

            if(0 != client.field313 && client.field305 % 20 < 10) {
               if(client.field313 == 1 && client.field447 >= 0 && client.field447 < client.field331.length) {
                  class34 var22 = client.field331[client.field447];
                  if(null != var22) {
                     var11 = var22.field849 / 32 - class167.field2692.field849 / 32;
                     var12 = var22.field819 / 32 - class167.field2692.field819 / 32;
                     class82.method1880(var1, var2, var11, var12, class7.field144[1], var4);
                  }
               }

               if(client.field313 == 2) {
                  var10 = 2 + (client.field316 * 4 - class41.field990 * 4) - class167.field2692.field849 / 32;
                  var11 = 2 + (client.field317 * 4 - class2.field37 * 4) - class167.field2692.field819 / 32;
                  class82.method1880(var1, var2, var10, var11, class7.field144[1], var4);
               }

               if(10 == client.field313 && client.field406 >= 0 && client.field406 < client.field415.length) {
                  class2 var23 = client.field415[client.field406];
                  if(var23 != null) {
                     var11 = var23.field849 / 32 - class167.field2692.field849 / 32;
                     var12 = var23.field819 / 32 - class167.field2692.field819 / 32;
                     class82.method1880(var1, var2, var11, var12, class7.field144[1], var4);
                  }
               }
            }

            if(client.field533 != 0) {
               var10 = 2 + client.field533 * 4 - class167.field2692.field849 / 32;
               var11 = 2 + client.field529 * 4 - class167.field2692.field819 / 32;
               class28.method660(var1, var2, var10, var11, class7.field144[0], var4);
            }

            if(!class167.field2692.field43) {
               class79.method1800(var1 + var4.field2911 / 2 - 1, var2 + var4.field2912 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            class79.method1792(var1, var2, 0, var4.field2909, var4.field2914);
         }

         client.field500[var3] = true;
      }
   }

   class8() {
      this.method102();
   }

   @ObfuscatedName("w")
   public static class130[] method110() {
      return new class130[]{class130.field2066, class130.field2064, class130.field2065};
   }

   @ObfuscatedName("p")
   public static int method111() {
      return ++class140.field2169 - 1;
   }

   @ObfuscatedName("w")
   public static boolean method112() {
      long var0 = class14.method165();
      int var2 = (int)(var0 - class142.field2198);
      class142.field2198 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class171.field2735 += var2;
      if(class171.field2736 == 0 && class171.field2737 == 0 && 0 == class171.field2740 && 0 == class171.field2739) {
         return true;
      } else if(null == class171.field2742) {
         return false;
      } else {
         try {
            if(class171.field2735 > 30000) {
               throw new IOException();
            } else {
               class172 var3;
               class119 var4;
               while(class171.field2737 < 20 && class171.field2739 > 0) {
                  var3 = (class172)class171.field2752.method3805();
                  var4 = new class119(4);
                  var4.method2573(1);
                  var4.method2653((int)var3.field3123);
                  class171.field2742.method3002(var4.field2012, 0, 4);
                  class171.field2749.method3807(var3, var3.field3123);
                  --class171.field2739;
                  ++class171.field2737;
               }

               while(class171.field2736 < 20 && class171.field2740 > 0) {
                  var3 = (class172)class171.field2741.method3896();
                  var4 = new class119(4);
                  var4.method2573(0);
                  var4.method2653((int)var3.field3123);
                  class171.field2742.method3002(var4.field2012, 0, 4);
                  var3.method3909();
                  class171.field2734.method3807(var3, var3.field3123);
                  --class171.field2740;
                  ++class171.field2736;
               }

               for(int var18 = 0; var18 < 100; ++var18) {
                  int var19 = class171.field2742.method3000();
                  if(var19 < 0) {
                     throw new IOException();
                  }

                  if(0 == var19) {
                     break;
                  }

                  class171.field2735 = 0;
                  byte var5 = 0;
                  if(class21.field590 == null) {
                     var5 = 8;
                  } else if(0 == class171.field2745) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class171.field2733.field2011;
                     if(var6 > var19) {
                        var6 = var19;
                     }

                     class171.field2742.method3001(class171.field2733.field2012, class171.field2733.field2011, var6);
                     if(class171.field2748 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class171.field2733.field2012[class171.field2733.field2011 + var7] ^= class171.field2748;
                        }
                     }

                     class171.field2733.field2011 += var6;
                     if(class171.field2733.field2011 < var5) {
                        break;
                     }

                     if(null == class21.field590) {
                        class171.field2733.field2011 = 0;
                        var7 = class171.field2733.method2506();
                        var8 = class171.field2733.method2508();
                        int var9 = class171.field2733.method2506();
                        var10 = class171.field2733.method2511();
                        long var11 = (long)((var7 << 16) + var8);
                        class172 var13 = (class172)class171.field2749.method3806(var11);
                        class171.field2743 = true;
                        if(var13 == null) {
                           var13 = (class172)class171.field2734.method3806(var11);
                           class171.field2743 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class21.field590 = var13;
                        class13.field213 = new class119(var14 + var10 + class21.field590.field2756);
                        class13.field213.method2573(var9);
                        class13.field213.method2494(var10);
                        class171.field2745 = 8;
                        class171.field2733.field2011 = 0;
                     } else if(class171.field2745 == 0) {
                        if(-1 == class171.field2733.field2012[0]) {
                           class171.field2745 = 1;
                           class171.field2733.field2011 = 0;
                        } else {
                           class21.field590 = null;
                        }
                     }
                  } else {
                     var6 = class13.field213.field2012.length - class21.field590.field2756;
                     var7 = 512 - class171.field2745;
                     if(var7 > var6 - class13.field213.field2011) {
                        var7 = var6 - class13.field213.field2011;
                     }

                     if(var7 > var19) {
                        var7 = var19;
                     }

                     class171.field2742.method3001(class13.field213.field2012, class13.field213.field2011, var7);
                     if(class171.field2748 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class13.field213.field2012[class13.field213.field2011 + var8] ^= class171.field2748;
                        }
                     }

                     class13.field213.field2011 += var7;
                     class171.field2745 += var7;
                     if(var6 == class13.field213.field2011) {
                        if(class21.field590.field3123 == 16711935L) {
                           class10.field181 = class13.field213;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class168 var20 = class171.field2747[var8];
                              if(null != var20) {
                                 class10.field181.field2011 = var8 * 8 + 5;
                                 var10 = class10.field181.method2511();
                                 int var21 = class10.field181.method2511();
                                 var20.method3364(var10, var21);
                              }
                           }
                        } else {
                           class171.field2746.reset();
                           class171.field2746.update(class13.field213.field2012, 0, var6);
                           var8 = (int)class171.field2746.getValue();
                           if(var8 != class21.field590.field2757) {
                              try {
                                 class171.field2742.method3005();
                              } catch (Exception var16) {
                                 ;
                              }

                              ++class171.field2753;
                              class171.field2742 = null;
                              class171.field2748 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class171.field2753 = 0;
                           class171.field2750 = 0;
                           class21.field590.field2755.method3365((int)(class21.field590.field3123 & 65535L), class13.field213.field2012, (class21.field590.field3123 & 16711680L) == 16711680L, class171.field2743);
                        }

                        class21.field590.method3935();
                        if(class171.field2743) {
                           --class171.field2737;
                        } else {
                           --class171.field2736;
                        }

                        class171.field2745 = 0;
                        class21.field590 = null;
                        class13.field213 = null;
                     } else {
                        if(class171.field2745 != 512) {
                           break;
                        }

                        class171.field2745 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var17) {
            try {
               class171.field2742.method3005();
            } catch (Exception var15) {
               ;
            }

            ++class171.field2750;
            class171.field2742 = null;
            return false;
         }
      }
   }
}
