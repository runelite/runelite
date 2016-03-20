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

@ObfuscatedName("dv")
public class class120 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -224307711
   )
   static int field1990 = 0;
   @ObfuscatedName("s")
   static byte[][] field1991 = new byte[1000][];
   @ObfuscatedName("y")
   static byte[][] field1992 = new byte[250][];
   @ObfuscatedName("e")
   static byte[][] field1993 = new byte[50][];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -333306719
   )
   static int field1995 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1994745551
   )
   static int field1996 = 0;

   @ObfuscatedName("a")
   static synchronized byte[] method2745(int var0) {
      byte[] var1;
      if(100 == var0 && field1996 > 0) {
         var1 = field1991[--field1996];
         field1991[field1996] = null;
         return var1;
      } else if(var0 == 5000 && field1995 > 0) {
         var1 = field1992[--field1995];
         field1992[field1995] = null;
         return var1;
      } else if(30000 == var0 && field1990 > 0) {
         var1 = field1993[--field1990];
         field1993[field1990] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass121;I)V",
      garbageValue = "1663375347"
   )
   public static void method2747(class121 var0) {
      class209 var1 = (class209)class210.field3125.method3893();
      if(var1 != null) {
         int var2 = var0.field1979;
         var0.method2663(var1.field3121);

         for(int var3 = 0; var3 < var1.field3117; ++var3) {
            if(0 != var1.field3116[var3]) {
               var0.method2497(var1.field3116[var3]);
            } else {
               try {
                  int var4 = var1.field3124[var3];
                  Field var5;
                  int var6;
                  if(0 == var4) {
                     var5 = var1.field3120[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2497(0);
                     var0.method2663(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3120[var3];
                     var5.setInt((Object)null, var1.field3118[var3]);
                     var0.method2497(0);
                  } else if(2 == var4) {
                     var5 = var1.field3120[var3];
                     var6 = var5.getModifiers();
                     var0.method2497(0);
                     var0.method2663(var6);
                  }

                  Method var22;
                  if(3 != var4) {
                     if(4 == var4) {
                        var22 = var1.field3122[var3];
                        var6 = var22.getModifiers();
                        var0.method2497(0);
                        var0.method2663(var6);
                     }
                  } else {
                     var22 = var1.field3122[var3];
                     byte[][] var23 = var1.field3123[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(null == var24) {
                        var0.method2497(0);
                     } else if(var24 instanceof Number) {
                        var0.method2497(1);
                        var0.method2670(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2497(2);
                        var0.method2503((String)var24);
                     } else {
                        var0.method2497(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2497(-10);
               } catch (InvalidClassException var11) {
                  var0.method2497(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2497(-12);
               } catch (OptionalDataException var13) {
                  var0.method2497(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2497(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2497(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2497(-16);
               } catch (SecurityException var17) {
                  var0.method2497(-17);
               } catch (IOException var18) {
                  var0.method2497(-18);
               } catch (NullPointerException var19) {
                  var0.method2497(-19);
               } catch (Exception var20) {
                  var0.method2497(-20);
               } catch (Throwable var21) {
                  var0.method2497(-21);
               }
            }
         }

         var0.method2600(var2);
         var1.method3946();
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1447551858"
   )
   static final void method2748() {
      int var0;
      if(client.field453 != -1) {
         var0 = client.field453;
         if(class103.method2303(var0)) {
            class74.method1636(class172.field2850[var0], -1);
         }
      }

      for(var0 = 0; var0 < client.field497; ++var0) {
         if(client.field499[var0]) {
            client.field500[var0] = true;
         }

         client.field501[var0] = client.field499[var0];
         client.field499[var0] = false;
      }

      client.field322 = client.field303;
      client.field442 = -1;
      client.field443 = -1;
      class14.field204 = null;
      if(client.field453 != -1) {
         client.field497 = 0;
         class48.method1018(client.field453, 0, 0, class6.field107, class31.field749, 0, 0, -1);
      }

      class79.method1873();
      if(!client.field470) {
         if(client.field442 != -1) {
            class14.method185(client.field442, client.field443);
         }
      } else {
         var0 = class13.field192;
         int var1 = class30.field709;
         int var2 = class180.field2925;
         int var3 = class118.field1987;
         int var4 = 6116423;
         class79.method1830(var0, var1, var2, var3, var4);
         class79.method1830(var0 + 1, var1 + 1, var2 - 2, 16, 0);
         class79.method1853(var0 + 1, 18 + var1, var2 - 2, var3 - 19, 0);
         class38.field876.method4057("Choose Option", 3 + var0, 14 + var1, var4, -1);
         int var5 = class139.field2140;
         int var6 = class139.field2135;

         for(int var7 = 0; var7 < client.field435; ++var7) {
            int var8 = 15 * (client.field435 - 1 - var7) + 31 + var1;
            int var9 = 16777215;
            if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
               var9 = 16776960;
            }

            class223 var10 = class38.field876;
            String var11;
            if(client.field445[var7].length() > 0) {
               var11 = client.field440[var7] + " " + client.field445[var7];
            } else {
               var11 = client.field440[var7];
            }

            var10.method4057(var11, 3 + var0, var8, var9, 0);
         }

         class0.method4(class13.field192, class30.field709, class180.field2925, class118.field1987);
      }

      if(client.field522 == 3) {
         for(var0 = 0; var0 < client.field497; ++var0) {
            if(client.field501[var0]) {
               class79.method1829(client.field502[var0], client.field515[var0], client.field504[var0], client.field505[var0], 16711935, 128);
            } else if(client.field500[var0]) {
               class79.method1829(client.field502[var0], client.field515[var0], client.field504[var0], client.field505[var0], 16711680, 128);
            }
         }
      }

      class12.method171(class48.field1078, class151.field2253.field870, class151.field2253.field813, client.field409);
      client.field409 = 0;
   }

   @ObfuscatedName("a")
   public static byte method2749(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
            var1 = -128;
         } else if(8218 == var0) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(8230 == var0) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(8225 == var0) {
            var1 = -121;
         } else if(710 == var0) {
            var1 = -120;
         } else if(8240 == var0) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(var0 == 338) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(8216 == var0) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(8220 == var0) {
            var1 = -109;
         } else if(8221 == var0) {
            var1 = -108;
         } else if(8226 == var0) {
            var1 = -107;
         } else if(var0 == 8211) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(732 == var0) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(353 == var0) {
            var1 = -102;
         } else if(8250 == var0) {
            var1 = -101;
         } else if(339 == var0) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(376 == var0) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }
}
