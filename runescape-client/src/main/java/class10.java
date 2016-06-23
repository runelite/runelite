import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class10 extends class107 {
   @ObfuscatedName("c")
   static int[] field174;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILclass108;B)Z",
      garbageValue = "-45"
   )
   protected boolean vmethod2428(int var1, int var2, int var3, class108 var4) {
      return var2 == super.field1886 && var3 == super.field1881;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1888984592"
   )
   static final void method138(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class20.field580.field140 = !class20.field580.field140;
         class21.method613();
         if(class20.field580.field140) {
            class52.method1147(99, "", "Roofs are now all hidden");
         } else {
            class52.method1147(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         client.field355 = !client.field355;
      }

      if(client.field454 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            client.field355 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            client.field355 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(client.field343 > 0) {
               class5.method71();
            } else {
               class11.method156(40);
               class9.field158 = class172.field2742;
               class172.field2742 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && client.field293 == 2) {
            throw new RuntimeException();
         }
      }

      client.field333.method2773(227);
      client.field333.method2654(var0.length() + 1);
      client.field333.method2545(var0);
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-200779038"
   )
   static final void method139(int var0, int var1, int var2, int var3) {
      if(client.field353 == 0 && !client.field442) {
         class154.method3182("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class105.field1861; ++var6) {
         var7 = class105.field1862[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class129.field2056.method2094(class14.field212, var8, var9, var7) >= 0) {
               class40 var12 = class150.method3166(var11);
               if(var12.field947 != null) {
                  var12 = var12.method850();
               }

               if(var12 == null) {
                  continue;
               }

               if(client.field353 == 1) {
                  class154.method3182("Use", client.field441 + " " + "->" + " " + class164.method3251('\uffff') + var12.field962, 1, var7, var8, var9);
               } else if(client.field442) {
                  if((class84.field1465 & 4) == 4) {
                     class154.method3182(client.field445, client.field446 + " " + "->" + " " + class164.method3251('\uffff') + var12.field962, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.field963;
                  if(client.field458) {
                     var13 = class18.method207(var13);
                  }

                  if(null != var13) {
                     for(int var19 = 4; var19 >= 0; --var19) {
                        if(null != var13[var19]) {
                           short var15 = 0;
                           if(var19 == 0) {
                              var15 = 3;
                           }

                           if(var19 == 1) {
                              var15 = 4;
                           }

                           if(var19 == 2) {
                              var15 = 5;
                           }

                           if(var19 == 3) {
                              var15 = 6;
                           }

                           if(var19 == 4) {
                              var15 = 1001;
                           }

                           class154.method3182(var13[var19], class164.method3251('\uffff') + var12.field962, var15, var7, var8, var9);
                        }
                     }
                  }

                  class154.method3182("Examine", class164.method3251('\uffff') + var12.field962, 1002, var12.field943 << 14, var8, var9);
               }
            }

            class34 var14;
            class2 var18;
            int var20;
            int[] var27;
            int var29;
            if(var10 == 1) {
               class34 var23 = client.field328[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.field782.field907 == 1 && (var23.field837 & 127) == 64 && (var23.field880 & 127) == 64) {
                  for(var20 = 0; var20 < client.field494; ++var20) {
                     var14 = client.field328[client.field330[var20]];
                     if(var14 != null && var23 != var14 && var14.field782.field907 == 1 && var14.field837 == var23.field837 && var23.field880 == var14.field880) {
                        class87.method2138(var14.field782, client.field330[var20], var8, var9);
                     }
                  }

                  var20 = class32.field753;
                  var27 = class32.field761;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var18 = client.field302[var27[var29]];
                     if(null != var18 && var18.field837 == var23.field837 && var23.field880 == var18.field880) {
                        class107.method2427(var18, var27[var29], var8, var9);
                     }
                  }
               }

               class87.method2138(var23.field782, var11, var8, var9);
            }

            if(var10 == 0) {
               class2 var24 = client.field302[var11];
               if(null == var24) {
                  continue;
               }

               if((var24.field837 & 127) == 64 && (var24.field880 & 127) == 64) {
                  for(var20 = 0; var20 < client.field494; ++var20) {
                     var14 = client.field328[client.field330[var20]];
                     if(var14 != null && var14.field782.field907 == 1 && var14.field837 == var24.field837 && var24.field880 == var14.field880) {
                        class87.method2138(var14.field782, client.field330[var20], var8, var9);
                     }
                  }

                  var20 = class32.field753;
                  var27 = class32.field761;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var18 = client.field302[var27[var29]];
                     if(var18 != null && var24 != var18 && var24.field837 == var18.field837 && var18.field880 == var24.field880) {
                        class107.method2427(var18, var27[var29], var8, var9);
                     }
                  }
               }

               if(var11 != client.field464) {
                  class107.method2427(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               class199 var25 = client.field572[class14.field212][var8][var9];
               if(null != var25) {
                  for(class28 var26 = (class28)var25.method3856(); var26 != null; var26 = (class28)var25.method3858()) {
                     class51 var28 = class141.method3001(var26.field682);
                     if(client.field353 == 1) {
                        class154.method3182("Use", client.field441 + " " + "->" + " " + class164.method3251(16748608) + var28.field1128, 16, var26.field682, var8, var9);
                     } else if(client.field442) {
                        if((class84.field1465 & 1) == 1) {
                           class154.method3182(client.field445, client.field446 + " " + "->" + " " + class164.method3251(16748608) + var28.field1128, 17, var26.field682, var8, var9);
                        }
                     } else {
                        String[] var22 = var28.field1136;
                        if(client.field458) {
                           var22 = class18.method207(var22);
                        }

                        for(int var16 = 4; var16 >= 0; --var16) {
                           if(null != var22 && var22[var16] != null) {
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

                              class154.method3182(var22[var16], class164.method3251(16748608) + var28.field1128, var17, var26.field682, var8, var9);
                           } else if(var16 == 2) {
                              class154.method3182("Take", class164.method3251(16748608) + var28.field1128, 20, var26.field682, var8, var9);
                           }
                        }

                        class154.method3182("Examine", class164.method3251(16748608) + var28.field1128, 1004, var26.field682, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var21 = client.field302[client.field464];
         class107.method2427(var21, client.field464, var6, var7);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "113"
   )
   public static void method140(class122 var0) {
      class210 var1 = (class210)class211.field3128.method3891();
      if(var1 != null) {
         int var2 = var0.field1998;
         var0.method2539(var1.field3119);

         for(int var3 = 0; var3 < var1.field3118; ++var3) {
            if(var1.field3126[var3] != 0) {
               var0.method2654(var1.field3126[var3]);
            } else {
               try {
                  int var4 = var1.field3120[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3121[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2654(0);
                     var0.method2539(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3121[var3];
                     var5.setInt((Object)null, var1.field3123[var3]);
                     var0.method2654(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3121[var3];
                     var6 = var5.getModifiers();
                     var0.method2654(0);
                     var0.method2539(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.field3124[var3];
                        var6 = var25.getModifiers();
                        var0.method2654(0);
                        var0.method2539(var6);
                     }
                  } else {
                     var25 = var1.field3124[var3];
                     byte[][] var10 = var1.field3125[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2654(0);
                     } else if(var11 instanceof Number) {
                        var0.method2654(1);
                        var0.method2626(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2654(2);
                        var0.method2545((String)var11);
                     } else {
                        var0.method2654(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2654(-10);
               } catch (InvalidClassException var14) {
                  var0.method2654(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2654(-12);
               } catch (OptionalDataException var16) {
                  var0.method2654(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2654(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2654(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2654(-16);
               } catch (SecurityException var20) {
                  var0.method2654(-17);
               } catch (IOException var21) {
                  var0.method2654(-18);
               } catch (NullPointerException var22) {
                  var0.method2654(-19);
               } catch (Exception var23) {
                  var0.method2654(-20);
               } catch (Throwable var24) {
                  var0.method2654(-21);
               }
            }
         }

         var0.method2662(var2);
         var1.method3946();
      }
   }
}
