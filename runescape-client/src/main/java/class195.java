import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class195 extends CacheableNode {
   @ObfuscatedName("g")
   public char field2853;
   @ObfuscatedName("m")
   public static NodeCache field2854 = new NodeCache(64);
   @ObfuscatedName("o")
   public static class182 field2855;
   @ObfuscatedName("b")
   public char field2856;
   @ObfuscatedName("h")
   public String field2857 = "null";
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 106434531
   )
   public int field2858;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1210335465
   )
   public int field2859 = 0;
   @ObfuscatedName("c")
   public int[] field2860;
   @ObfuscatedName("u")
   public int[] field2861;
   @ObfuscatedName("k")
   public String[] field2862;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;B)V",
      garbageValue = "-39"
   )
   static final void method3463(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field314 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field94) {
            class10.field94 = var0;
         }

         ObjectComposition var8 = class143.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field2905;
            var10 = var8.field2938;
         } else {
            var9 = var8.field2938;
            var10 = var8.field2905;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var11][var13] + var15[var12][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + (var3 << 14) + (var2 << 7) + var1;
         if(var8.field2909 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2930 == 1) {
            var20 += 256;
         }

         if(var8.method3523()) {
            class85.method1662(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field314 || var8.field2909 != 0 || var8.field2907 == 1 || var8.field2928) {
               if(var8.field2906 == -1 && null == var8.impostorIds) {
                  var21 = var8.method3518(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2907 == 1 && null != var7) {
                  var7.method2203(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field2906 == -1 && null == var8.impostorIds) {
                     var21 = var8.method3518(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                  }

                  var6.method1807(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     DecorativeObject.field1596[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2907 != 0 && var7 != null) {
                     var7.method2198(var1, var2, var9, var10, var8.field2918);
                  }

               } else if(var5 == 0) {
                  if(var8.field2906 == -1 && var8.impostorIds == null) {
                     var21 = var8.method3518(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                  }

                  var6.method1820(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field92[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2921) {
                        class10.field80[var0][var1][var2] = 50;
                        class10.field80[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field2890) {
                        DecorativeObject.field1596[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2921) {
                        class10.field80[var0][var1][1 + var2] = 50;
                        class10.field80[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field2890) {
                        DecorativeObject.field1596[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2921) {
                        class10.field80[var0][1 + var1][var2] = 50;
                        class10.field80[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field2890) {
                        DecorativeObject.field1596[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2921) {
                        class10.field80[var0][var1][var2] = 50;
                        class10.field80[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2890) {
                        DecorativeObject.field1596[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2907 != 0 && null != var7) {
                     var7.method2200(var1, var2, var5, var4, var8.field2918);
                  }

                  if(var8.field2914 != 16) {
                     var6.method1682(var0, var1, var2, var8.field2914);
                  }

               } else if(var5 == 1) {
                  if(var8.field2906 == -1 && null == var8.impostorIds) {
                     var21 = var8.method3518(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                  }

                  var6.method1820(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field87[var4], 0, var19, var20);
                  if(var8.field2921) {
                     if(var4 == 0) {
                        class10.field80[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class10.field80[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class10.field80[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class10.field80[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2907 != 0 && null != var7) {
                     var7.method2200(var1, var2, var5, var4, var8.field2918);
                  }

               } else {
                  int var26;
                  Object var27;
                  if(var5 == 2) {
                     var26 = 1 + var4 & 3;
                     Object var28;
                     if(var8.field2906 == -1 && var8.impostorIds == null) {
                        var28 = var8.method3518(2, var4 + 4, var15, var17, var16, var18);
                        var27 = var8.method3518(2, var26, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                        var27 = new class49(var3, 2, var26, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1820(var0, var1, var2, var16, (Renderable)var28, (Renderable)var27, class10.field92[var4], class10.field92[var26], var19, var20);
                     if(var8.field2890) {
                        if(var4 == 0) {
                           DecorativeObject.field1596[var0][var1][var2] |= 585;
                           DecorativeObject.field1596[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           DecorativeObject.field1596[var0][var1][1 + var2] |= 1170;
                           DecorativeObject.field1596[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           DecorativeObject.field1596[var0][var1 + 1][var2] |= 585;
                           DecorativeObject.field1596[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           DecorativeObject.field1596[var0][var1][var2] |= 1170;
                           DecorativeObject.field1596[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2907 != 0 && null != var7) {
                        var7.method2200(var1, var2, var5, var4, var8.field2918);
                     }

                     if(var8.field2914 != 16) {
                        var6.method1682(var0, var1, var2, var8.field2914);
                     }

                  } else if(var5 == 3) {
                     if(var8.field2906 == -1 && var8.impostorIds == null) {
                        var21 = var8.method3518(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1820(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field87[var4], 0, var19, var20);
                     if(var8.field2921) {
                        if(var4 == 0) {
                           class10.field80[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class10.field80[var0][1 + var1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class10.field80[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           class10.field80[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2907 != 0 && var7 != null) {
                        var7.method2200(var1, var2, var5, var4, var8.field2918);
                     }

                  } else if(var5 == 9) {
                     if(var8.field2906 == -1 && var8.impostorIds == null) {
                        var21 = var8.method3518(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1807(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2907 != 0 && null != var7) {
                        var7.method2198(var1, var2, var9, var10, var8.field2918);
                     }

                     if(var8.field2914 != 16) {
                        var6.method1682(var0, var1, var2, var8.field2914);
                     }

                  } else if(var5 == 4) {
                     if(var8.field2906 == -1 && var8.impostorIds == null) {
                        var21 = var8.method3518(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1675(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field92[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method1823(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class143.getObjectDefinition(var22 >> 14 & 32767).field2914;
                     }

                     if(var8.field2906 == -1 && null == var8.impostorIds) {
                        var27 = var8.method3518(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1675(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field92[var4], 0, class10.field89[var4] * var26, class10.field95[var4] * var26, var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method1823(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class143.getObjectDefinition(var22 >> 14 & 32767).field2914 / 2;
                     }

                     if(var8.field2906 == -1 && var8.impostorIds == null) {
                        var27 = var8.method3518(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1675(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var4, class10.field100[var4] * var26, var26 * class10.field97[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field2906 == -1 && null == var8.impostorIds) {
                        var21 = var8.method3518(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, 4 + var22, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1675(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.method1823(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class143.getObjectDefinition(var22 >> 14 & 32767).field2914 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.field2906 == -1 && null == var8.impostorIds) {
                        var27 = var8.method3518(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method3518(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                        var29 = new class49(var3, 4, var25 + 4, var0, var1, var2, var8.field2906, true, (Renderable)null);
                     }

                     var6.method1675(var0, var1, var2, var16, (Renderable)var27, (Renderable)var29, 256, var4, class10.field100[var4] * var26, var26 * class10.field97[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field2906 == -1 && null == var8.impostorIds) {
                  var21 = var8.method3518(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.field2906, true, (Renderable)null);
               }

               if(var21 != null && var6.method1807(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2921) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1528() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class10.field80[var0][var23 + var1][var24 + var2]) {
                           class10.field80[var0][var1 + var23][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2907 != 0 && var7 != null) {
                  var7.method2198(var1, var2, var9, var10, var8.field2918);
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-420876677"
   )
   void method3465(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2856 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2853 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2857 = var1.method2780();
      } else if(var2 == 4) {
         this.field2858 = var1.method2731();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2859 = var1.readUnsignedShort();
            this.field2860 = new int[this.field2859];
            this.field2862 = new String[this.field2859];

            for(var3 = 0; var3 < this.field2859; ++var3) {
               this.field2860[var3] = var1.method2731();
               this.field2862[var3] = var1.method2780();
            }
         } else if(var2 == 6) {
            this.field2859 = var1.readUnsignedShort();
            this.field2860 = new int[this.field2859];
            this.field2861 = new int[this.field2859];

            for(var3 = 0; var3 < this.field2859; ++var3) {
               this.field2860[var3] = var1.method2731();
               this.field2861[var3] = var1.method2731();
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "122"
   )
   public static void method3468(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3220 = var0.readUnsignedByte();
      var2.field3222 = var0.method2731();
      var2.field3221 = new int[var2.field3220];
      var2.field3223 = new int[var2.field3220];
      var2.fields = new Field[var2.field3220];
      var2.field3225 = new int[var2.field3220];
      var2.methods = new Method[var2.field3220];
      var2.args = new byte[var2.field3220][][];

      for(int var3 = 0; var3 < var2.field3220; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2780();
                  var6 = var0.method2780();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2780();
                  }

                  String var20 = var0.method2780();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2731();
                        var10[var11] = new byte[var12];
                        var0.method2796(var10[var11], 0, var12);
                     }
                  }

                  var2.field3221[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class181.method3199(var8[var12]);
                  }

                  Class var22 = class181.method3199(var20);
                  if(class181.method3199(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class181.method3199(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.method2780();
               var6 = var0.method2780();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2731();
               }

               var2.field3221[var3] = var4;
               var2.field3225[var3] = var7;
               if(class181.method3199(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = class181.method3199(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3223[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3223[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3223[var3] = -3;
         } catch (Exception var27) {
            var2.field3223[var3] = -4;
         } catch (Throwable var28) {
            var2.field3223[var3] = -5;
         }
      }

      class227.field3228.method2329(var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-86"
   )
   public void method3469(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3465(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1518120878"
   )
   static void method3470() {
      class45.field900 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field917[var0] = null;
         class45.field916[var0] = 1;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "-1253792469"
   )
   public static void method3471(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3228.method2311();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2714(var1.field3222);

         for(int var3 = 0; var3 < var1.field3220; ++var3) {
            if(var1.field3223[var3] != 0) {
               var0.method2815(var1.field3223[var3]);
            } else {
               try {
                  int var4 = var1.field3221[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2815(0);
                     var0.method2714(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3225[var3]);
                     var0.method2815(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2815(0);
                     var0.method2714(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2815(0);
                        var0.method2714(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(null == var11) {
                        var0.method2815(0);
                     } else if(var11 instanceof Number) {
                        var0.method2815(1);
                        var0.method2716(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2815(2);
                        var0.method2717((String)var11);
                     } else {
                        var0.method2815(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2815(-10);
               } catch (InvalidClassException var14) {
                  var0.method2815(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2815(-12);
               } catch (OptionalDataException var16) {
                  var0.method2815(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2815(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2815(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2815(-16);
               } catch (SecurityException var20) {
                  var0.method2815(-17);
               } catch (IOException var21) {
                  var0.method2815(-18);
               } catch (NullPointerException var22) {
                  var0.method2815(-19);
               } catch (Exception var23) {
                  var0.method2815(-20);
               } catch (Throwable var24) {
                  var0.method2815(-21);
               }
            }
         }

         var0.method2748(var2);
         var1.unlink();
      }
   }
}
