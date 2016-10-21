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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class13 implements Runnable {
   @ObfuscatedName("v")
   int[] field189 = new int[500];
   @ObfuscatedName("w")
   @Export("worldServersDownload")
   static class18 worldServersDownload;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1933228577
   )
   int field191 = 0;
   @ObfuscatedName("f")
   boolean field192 = true;
   @ObfuscatedName("pe")
   static class224 field193;
   @ObfuscatedName("t")
   int[] field194 = new int[500];
   @ObfuscatedName("pf")
   static short[] field195;
   @ObfuscatedName("u")
   static String field196;
   @ObfuscatedName("e")
   Object field199 = new Object();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "1971984301"
   )
   public static void method148(class125 var0) {
      ClassInfo var1 = (ClassInfo)class214.field3177.method3932();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2521(var1.field3175);

         for(int var3 = 0; var3 < var1.field3169; ++var3) {
            if(var1.field3168[var3] != 0) {
               var0.method2518(var1.field3168[var3]);
            } else {
               try {
                  int var4 = var1.field3170[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2518(0);
                     var0.method2521(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3173[var3]);
                     var0.method2518(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2518(0);
                     var0.method2521(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2518(0);
                        var0.method2521(var6);
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
                        var0.method2518(0);
                     } else if(var11 instanceof Number) {
                        var0.method2518(1);
                        var0.method2523(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2518(2);
                        var0.method2524((String)var11);
                     } else {
                        var0.method2518(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2518(-10);
               } catch (InvalidClassException var14) {
                  var0.method2518(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2518(-12);
               } catch (OptionalDataException var16) {
                  var0.method2518(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2518(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2518(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2518(-16);
               } catch (SecurityException var20) {
                  var0.method2518(-17);
               } catch (IOException var21) {
                  var0.method2518(-18);
               } catch (NullPointerException var22) {
                  var0.method2518(-19);
               } catch (Exception var23) {
                  var0.method2518(-20);
               } catch (Throwable var24) {
                  var0.method2518(-21);
               }
            }
         }

         var0.method2555(var2);
         var1.unlink();
      }
   }

   public void run() {
      for(; this.field192; class110.method2407(50L)) {
         Object var1 = this.field199;
         synchronized(this.field199) {
            if(this.field191 < 500) {
               this.field194[this.field191] = class143.field2192;
               this.field189[this.field191] = class143.field2199;
               ++this.field191;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)Lclass52;",
      garbageValue = "-14087"
   )
   public static class52 method150(int var0) {
      class52 var1 = (class52)class52.field1127.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1131.method3304(8, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1071(new Buffer(var2));
         }

         class52.field1127.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1040918070"
   )
   static final void method152(int var0, int var1) {
      if(class171.method3404(var0)) {
         class141.method2960(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2045584819"
   )
   static void method154(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class79.field1429 = var1.method2535();
      class189.field3050 = new int[class79.field1429];
      class79.field1431 = new int[class79.field1429];
      class79.field1432 = new int[class79.field1429];
      XItemContainer.field221 = new int[class79.field1429];
      BufferProvider.field1450 = new byte[class79.field1429][];
      var1.offset = var0.length - 7 - class79.field1429 * 8;
      class79.field1430 = var1.method2535();
      class79.field1437 = var1.method2535();
      int var2 = (var1.method2656() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1429; ++var3) {
         class189.field3050[var3] = var1.method2535();
      }

      for(var3 = 0; var3 < class79.field1429; ++var3) {
         class79.field1431[var3] = var1.method2535();
      }

      for(var3 = 0; var3 < class79.field1429; ++var3) {
         class79.field1432[var3] = var1.method2535();
      }

      for(var3 = 0; var3 < class79.field1429; ++var3) {
         XItemContainer.field221[var3] = var1.method2535();
      }

      var1.offset = var0.length - 7 - class79.field1429 * 8 - (var2 - 1) * 3;
      class137.field2130 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class137.field2130[var3] = var1.method2537();
         if(class137.field2130[var3] == 0) {
            class137.field2130[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class79.field1429; ++var3) {
         int var4 = class79.field1432[var3];
         int var5 = XItemContainer.field221[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         BufferProvider.field1450[var3] = var7;
         int var8 = var1.method2656();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2534();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.method2534();
               }
            }
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1789739040"
   )
   static final void method155(int var0, int var1) {
      if(var0 != ItemLayer.field1737 || var1 != class4.field72) {
         ItemLayer.field1737 = var0;
         class4.field72 = var1;
         KitDefinition.setGameState(25);
         class12.method145("Loading - please wait.", true);
         int var2 = class32.baseX;
         int var3 = class8.baseY;
         class32.baseX = (var0 - 6) * 8;
         class8.baseY = (var1 - 6) * 8;
         int var4 = class32.baseX - var2;
         int var5 = class8.baseY - var3;
         var2 = class32.baseX;
         var3 = class8.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var18 != var17; var17 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var17 + var4;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)Client.field413.method3890(); var12 != null; var12 = (class16)Client.field413.method3892()) {
            var12.field229 -= var4;
            var12.field230 -= var5;
            if(var12.field229 < 0 || var12.field230 < 0 || var12.field229 >= 104 || var12.field230 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field363 = 0;
         Client.field562 = false;
         Client.field430 = -1;
         Client.field415.method3885();
         Client.projectiles.method3885();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2432();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass170;IB)Z",
      garbageValue = "110"
   )
   static boolean method156(class170 var0, int var1) {
      byte[] var2 = var0.method3289(var1);
      if(null == var2) {
         return false;
      } else {
         method154(var2);
         return true;
      }
   }
}
