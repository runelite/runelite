import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public final class class31 extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 841343597
   )
   int field708;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1163995645
   )
   int field709;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 996643301
   )
   int field710;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1169138271
   )
   int field711;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1667515947
   )
   int field712;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 573683333
   )
   int field713;
   @ObfuscatedName("f")
   class66 field714;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1960942669
   )
   int field715;
   @ObfuscatedName("u")
   class66 field716;
   @ObfuscatedName("a")
   static int[] field717;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 345590233
   )
   int field718;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 121152683
   )
   int field720;
   @ObfuscatedName("y")
   int[] field721;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1570524627
   )
   int field722;
   @ObfuscatedName("o")
   static Deque field723 = new Deque();
   @ObfuscatedName("p")
   ObjectComposition field725;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "86"
   )
   public static int method647(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var4 + var6] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var4 + var6] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var4 + var6] = -117;
         } else if(var7 == 338) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var4 + var6] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var4 + var6] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var4 + var6] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "402701072"
   )
   public static void method649() {
      class190.field2793.reset();
      class190.field2794.reset();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   void method651() {
      int var1 = this.field715;
      ObjectComposition var2 = this.field725.getImpostor();
      if(var2 != null) {
         this.field715 = var2.field2934;
         this.field718 = var2.field2898 * 128;
         this.field722 = var2.field2936;
         this.field708 = var2.field2893;
         this.field721 = var2.field2923;
      } else {
         this.field715 = -1;
         this.field718 = 0;
         this.field722 = 0;
         this.field708 = 0;
         this.field721 = null;
      }

      if(var1 != this.field715 && null != this.field716) {
         FaceNormal.field1554.method923(this.field716);
         this.field716 = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1690608100"
   )
   public static boolean method655() {
      return class138.field1929 != 0?true:class138.field1926.method2454();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "1763790336"
   )
   static class184 method657(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1688) {
         var4 = new class116(var0, class104.field1688, class104.field1690[var0], 1000000);
      }

      return new class184(var4, GroundObject.field1294, var0, var1, var2, var3);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1734230145"
   )
   static final void method658(int var0, int var1, int var2, int var3) {
      if(Client.field437 == 0 && !Client.field439) {
         class48.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1406; ++var6) {
         var7 = Model.field1407[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class159.region.method1696(class63.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class143.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field437 == 1) {
                  class48.addMenuEntry("Use", Client.field438 + " " + "->" + " " + class16.method182('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field439) {
                  if((class116.field1837 & 4) == 4) {
                     class48.addMenuEntry(Client.field562, Client.field443 + " " + "->" + " " + class16.method182('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field434) {
                     var13 = class38.method726(var13);
                  }

                  if(null != var13) {
                     for(int var22 = 4; var22 >= 0; --var22) {
                        if(var13[var22] != null) {
                           short var19 = 0;
                           if(var22 == 0) {
                              var19 = 3;
                           }

                           if(var22 == 1) {
                              var19 = 4;
                           }

                           if(var22 == 2) {
                              var19 = 5;
                           }

                           if(var22 == 3) {
                              var19 = 6;
                           }

                           if(var22 == 4) {
                              var19 = 1001;
                           }

                           class48.addMenuEntry(var13[var22], class16.method182('\uffff') + var12.name, var19, var7, var8, var9);
                        }
                     }
                  }

                  class48.addMenuEntry("Examine", class16.method182('\uffff') + var12.name, 1002, var12.field2897 << 14, var8, var9);
               }
            }

            NPC var14;
            Player var18;
            int var21;
            int[] var27;
            int var29;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field2999 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var21 = 0; var21 < Client.field492; ++var21) {
                     var14 = Client.cachedNPCs[Client.field327[var21]];
                     if(null != var14 && var23 != var14 && var14.composition.field2999 == 1 && var14.x == var23.x && var14.y == var23.y) {
                        class118.method2232(var14.composition, Client.field327[var21], var8, var9);
                     }
                  }

                  var21 = class45.field900;
                  var27 = class45.field902;

                  for(var29 = 0; var29 < var21; ++var29) {
                     var18 = Client.cachedPlayers[var27[var29]];
                     if(var18 != null && var18.x == var23.x && var18.y == var23.y) {
                        class94.method1872(var18, var27[var29], var8, var9);
                     }
                  }
               }

               class118.method2232(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var21 = 0; var21 < Client.field492; ++var21) {
                     var14 = Client.cachedNPCs[Client.field327[var21]];
                     if(var14 != null && var14.composition.field2999 == 1 && var24.x == var14.x && var14.y == var24.y) {
                        class118.method2232(var14.composition, Client.field327[var21], var8, var9);
                     }
                  }

                  var21 = class45.field900;
                  var27 = class45.field902;

                  for(var29 = 0; var29 < var21; ++var29) {
                     var18 = Client.cachedPlayers[var27[var29]];
                     if(null != var18 && var24 != var18 && var24.x == var18.x && var18.y == var24.y) {
                        class94.method1872(var18, var27[var29], var8, var9);
                     }
                  }
               }

               if(Client.field416 != var11) {
                  class94.method1872(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class63.plane][var8][var9];
               if(null != var25) {
                  for(Item var26 = (Item)var25.method2372(); null != var26; var26 = (Item)var25.method2362()) {
                     ItemComposition var28 = class137.getItemDefinition(var26.id);
                     if(Client.field437 == 1) {
                        class48.addMenuEntry("Use", Client.field438 + " " + "->" + " " + class16.method182(16748608) + var28.name, 16, var26.id, var8, var9);
                     } else if(Client.field439) {
                        if((class116.field1837 & 1) == 1) {
                           class48.addMenuEntry(Client.field562, Client.field443 + " " + "->" + " " + class16.method182(16748608) + var28.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var15 = var28.groundActions;
                        if(Client.field434) {
                           var15 = class38.method726(var15);
                        }

                        for(int var16 = 4; var16 >= 0; --var16) {
                           if(var15 != null && var15[var16] != null) {
                              byte var17 = 0;
                              if(var16 == 0) {
                                 var17 = 18;
                              }

                              if(var16 == 1) {
                                 var17 = 19;
                              }

                              if(var16 == 2) {
                                 var17 = 20;
                              }

                              if(var16 == 3) {
                                 var17 = 21;
                              }

                              if(var16 == 4) {
                                 var17 = 22;
                              }

                              class48.addMenuEntry(var15[var16], class16.method182(16748608) + var28.name, var17, var26.id, var8, var9);
                           } else if(var16 == 2) {
                              class48.addMenuEntry("Take", class16.method182(16748608) + var28.name, 20, var26.id, var8, var9);
                           }
                        }

                        class48.addMenuEntry("Examine", class16.method182(16748608) + var28.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var20 = Client.cachedPlayers[Client.field416];
         class94.method1872(var20, Client.field416, var6, var7);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-1893955153"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3048.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3051.method3203(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method3698(new Buffer(var2));
         }

         var1.method3668();
         Sequence.field3048.put(var1, (long)var0);
         return var1;
      }
   }
}
