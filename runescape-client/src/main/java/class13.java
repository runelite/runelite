import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class13 {
   @ObfuscatedName("s")
   public static Comparator field259;
   @ObfuscatedName("r")
   public static Comparator field265;
   @ObfuscatedName("g")
   public static Comparator field261;
   @ObfuscatedName("x")
   public static Comparator field262;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -1985650879
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field264;
   @ObfuscatedName("b")
   public final List field260;

   static {
      field259 = new class19();
      new class12();
      field265 = new class17();
      field261 = new class18();
      field262 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfs;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field260 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field260.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1391181194"
   )
   public void method78(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field260, var1);
      } else {
         Collections.sort(this.field260, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILfp;Lfy;Z[I[II)I",
      garbageValue = "164826509"
   )
   public static int method82(int var0, int var1, int var2, class164 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class163.field2206[var8][var9] = 0;
            class163.field2203[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class163.field2206[var12][var13] = 99;
         class163.field2203[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class163.field2201[var16] = var0;
         var33 = var16 + 1;
         class163.field2202[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class163.field2204 = var10;
               class96.field1423 = var11;
               var29 = false;
               break;
            }

            var10 = class163.field2201[var17];
            var11 = class163.field2202[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3088(1, var10, var11, var4)) {
               class163.field2204 = var10;
               class96.field1423 = var11;
               var29 = true;
               break;
            }

            var21 = class163.field2203[var30][var31] + 1;
            if(var30 > 0 && class163.field2206[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class163.field2201[var33] = var10 - 1;
               class163.field2202[var33] = var11;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 - 1][var31] = 2;
               class163.field2203[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class163.field2206[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class163.field2201[var33] = var10 + 1;
               class163.field2202[var33] = var11;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 + 1][var31] = 8;
               class163.field2203[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class163.field2206[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class163.field2201[var33] = var10;
               class163.field2202[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30][var31 - 1] = 1;
               class163.field2203[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class163.field2206[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class163.field2201[var33] = var10;
               class163.field2202[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30][var31 + 1] = 4;
               class163.field2203[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class163.field2206[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class163.field2201[var33] = var10 - 1;
               class163.field2202[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 - 1][var31 - 1] = 3;
               class163.field2203[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class163.field2206[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class163.field2201[var33] = var10 + 1;
               class163.field2202[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 + 1][var31 - 1] = 9;
               class163.field2203[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class163.field2206[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class163.field2201[var33] = var10 - 1;
               class163.field2202[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 - 1][var31 + 1] = 6;
               class163.field2203[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class163.field2206[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class163.field2201[var33] = var10 + 1;
               class163.field2202[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 + 1][var31 + 1] = 12;
               class163.field2203[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = class31.method244(var0, var1, var3, var4);
      } else {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class163.field2206[var12][var13] = 99;
         class163.field2203[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class163.field2201[var16] = var0;
         var33 = var16 + 1;
         class163.field2202[var16] = var1;
         var18 = var4.flags;

         label647:
         while(true) {
            label645:
            while(true) {
               do {
                  do {
                     do {
                        label622:
                        do {
                           if(var17 == var33) {
                              class163.field2204 = var10;
                              class96.field1423 = var11;
                              var29 = false;
                              break label647;
                           }

                           var10 = class163.field2201[var17];
                           var11 = class163.field2202[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod3088(var2, var10, var11, var4)) {
                              class163.field2204 = var10;
                              class96.field1423 = var11;
                              var29 = true;
                              break label647;
                           }

                           var21 = class163.field2203[var30][var31] + 1;
                           if(var30 > 0 && class163.field2206[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2201[var33] = var10 - 1;
                                    class163.field2202[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2206[var30 - 1][var31] = 2;
                                    class163.field2203[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class163.field2206[var30 + 1][var31] == 0 && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2201[var33] = var10 + 1;
                                    class163.field2202[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2206[var30 + 1][var31] = 8;
                                    class163.field2203[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class163.field2206[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2201[var33] = var10;
                                    class163.field2202[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2206[var30][var31 - 1] = 1;
                                    class163.field2203[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class163.field2206[var30][var31 + 1] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var19 + var2 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2201[var33] = var10;
                                    class163.field2202[var33] = var11 + 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2206[var30][var31 + 1] = 4;
                                    class163.field2203[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 + var2] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class163.field2206[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class163.field2201[var33] = var10 - 1;
                                    class163.field2202[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2206[var30 - 1][var31 - 1] = 3;
                                    class163.field2203[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class163.field2206[var30 + 1][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class163.field2201[var33] = var10 + 1;
                                    class163.field2202[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2206[var30 + 1][var31 - 1] = 9;
                                    class163.field2203[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + (var20 - 1)] & 19136995) != 0 || (var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class163.field2206[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label622;
                                 }
                              }

                              class163.field2201[var33] = var10 - 1;
                              class163.field2202[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class163.field2206[var30 - 1][var31 + 1] = 6;
                              class163.field2203[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class163.field2206[var30 + 1][var31 + 1] != 0);
               } while((var18[var19 + var2][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var22 + var19][var20 + var2] & 19137016) != 0 || (var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                     continue label645;
                  }
               }

               class163.field2201[var33] = var10 + 1;
               class163.field2202[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2206[var30 + 1][var31 + 1] = 12;
               class163.field2203[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class163.field2204;
      var30 = class96.field1423;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2210;
         var17 = var3.field2209;
         int var27 = var3.field2213;
         var19 = var3.field2211;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class163.field2203[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class163.field2203[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class163.field2203[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class163.field2201[var13] = var11;
         var31 = var13 + 1;
         class163.field2202[var13] = var30;

         for(var14 = var15 = class163.field2206[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class163.field2206[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class163.field2201[var31] = var11;
               class163.field2202[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class163.field2201[var31];
            var7[var33++] = class163.field2202[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfx;ZI)V",
      garbageValue = "1707989729"
   )
   public static void method74(RSSocket var0, boolean var1) {
      if(class19.field299 != null) {
         try {
            class19.field299.close();
         } catch (Exception var6) {
            ;
         }

         class19.field299 = null;
      }

      class19.field299 = var0;
      class3.sendConInfo(var1);
      class245.field3317.offset = 0;
      TextureProvider.currentRequest = null;
      SoundTask.field1574 = null;
      class245.field3311 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class245.field3309.method3592();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class245.field3314.method3592();
               if(var2 == null) {
                  if(class245.field3320 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class245.field3320);
                        var7.putShort(0);
                        class19.field299.queueForWrite(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class19.field299.close();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class245.field3324;
                        class19.field299 = null;
                     }
                  }

                  class245.field3307 = 0;
                  class245.field3306 = ChatLineBuffer.currentTimeMs();
                  return;
               }

               class245.field3305.setHead(var2);
               class245.field3313.put(var2, var2.hash);
               ++class245.field3322;
               --class245.field3315;
            }
         }

         class245.field3318.put(var2, var2.hash);
         ++class245.field3308;
         --class245.field3310;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-22"
   )
   public static final void method79(int var0, int var1, int var2, int var3, int var4) {
      class7.field220.method3618(new class8(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1894271462"
   )
   static final void method80() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class148.method2910(var2, var2.composition.field3606);
         }
      }

   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-6"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class226.method4078(var0, class189.field2529);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class226.method4078(var3.name, class189.field2529))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class226.method4078(var3.previousName, class189.field2529))) {
               return true;
            }
         }

         return false;
      }
   }
}
