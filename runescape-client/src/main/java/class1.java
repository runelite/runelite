import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.OutputStreamWriter;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class1 {
   @ObfuscatedName("jn")
   static class173[] field18;
   @ObfuscatedName("cq")
   static class224 field26;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 857958483
   )
   static int field28;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -670401153
   )
   static int field33;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "-1112995641"
   )
   static void method2(class2 var0, int var1, int var2) {
      if(var0.field834 == var1 && var1 != -1) {
         int var3 = class18.method177(var1).field986;
         if(var3 == 1) {
            var0.field819 = 0;
            var0.field818 = 0;
            var0.field824 = var2;
            var0.field838 = 0;
         }

         if(var3 == 2) {
            var0.field838 = 0;
         }
      } else if(var1 == -1 || var0.field834 == -1 || class18.method177(var1).field983 >= class18.method177(var0.field834).field983) {
         var0.field834 = var1;
         var0.field819 = 0;
         var0.field818 = 0;
         var0.field824 = var2;
         var0.field838 = 0;
         var0.field861 = var0.field856;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "722345398"
   )
   public static long method3(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "44"
   )
   public static void method4(class122 var0) {
      class210 var1 = (class210)class211.field3141.method3819();
      if(var1 != null) {
         int var2 = var0.field2000;
         var0.method2456(var1.field3131);

         for(int var3 = 0; var3 < var1.field3135; ++var3) {
            if(var1.field3134[var3] != 0) {
               var0.method2453(var1.field3134[var3]);
            } else {
               try {
                  int var4 = var1.field3130[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3133[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2453(0);
                     var0.method2456(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3133[var3];
                     var5.setInt((Object)null, var1.field3132[var3]);
                     var0.method2453(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3133[var3];
                     var6 = var5.getModifiers();
                     var0.method2453(0);
                     var0.method2456(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.field3136[var3];
                        var6 = var25.getModifiers();
                        var0.method2453(0);
                        var0.method2456(var6);
                     }
                  } else {
                     var25 = var1.field3136[var3];
                     byte[][] var10 = var1.field3137[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2453(0);
                     } else if(var11 instanceof Number) {
                        var0.method2453(1);
                        var0.method2463(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2453(2);
                        var0.method2586((String)var11);
                     } else {
                        var0.method2453(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2453(-10);
               } catch (InvalidClassException var14) {
                  var0.method2453(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2453(-12);
               } catch (OptionalDataException var16) {
                  var0.method2453(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2453(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2453(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2453(-16);
               } catch (SecurityException var20) {
                  var0.method2453(-17);
               } catch (IOException var21) {
                  var0.method2453(-18);
               } catch (NullPointerException var22) {
                  var0.method2453(-19);
               } catch (Exception var23) {
                  var0.method2453(-20);
               } catch (Throwable var24) {
                  var0.method2453(-21);
               }
            }
         }

         var0.method2489(var2);
         var1.method3870();
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method5(boolean var0) {
      for(int var1 = 0; var1 < client.field293; ++var1) {
         class34 var2 = client.field320[client.field322[var1]];
         int var3 = (client.field322[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod735() && var0 == var2.field772.field902 && var2.field772.method766()) {
            int var4 = var2.field809 >> 7;
            int var5 = var2.field804 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field807 == 1 && (var2.field809 & 127) == 64 && (var2.field804 & 127) == 64) {
                  if(client.field388 == client.field387[var4][var5]) {
                     continue;
                  }

                  client.field387[var4][var5] = client.field388;
               }

               if(!var2.field772.field910) {
                  var3 -= Integer.MIN_VALUE;
               }

               class214.field3161.method1903(class32.field754, var2.field809, var2.field804, class14.method147(var2.field807 * 64 - 64 + var2.field809, var2.field804 + (var2.field807 * 64 - 64), class32.field754), var2.field807 * 64 - 64 + 60, var2, var2.field805, var3, var2.field806);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1660389806"
   )
   static void method6() {
      class31.field722 = class31.field722.trim();
      if(class31.field722.length() == 0) {
         class50.method987("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class17.method167("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            class119 var7 = new class119(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.field2001, var7.field2000, 1000 - var7.field2000);
               if(var8 == -1) {
                  var7.field2000 = 0;
                  long var12 = var7.method2474();
                  var1 = var12;
                  break;
               }

               var7.field2000 += var8;
               if(var7.field2000 >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var11) {
            var1 = 0L;
         }

         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = class96.method2151(var1, class31.field722);
         }

         switch(var0) {
         case 2:
            class50.method987("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field717 = 6;
            break;
         case 3:
            class50.method987("", "Error connecting to server.", "");
            break;
         case 4:
            class50.method987("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class50.method987("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class50.method987("", "Error connecting to server.", "");
            break;
         case 7:
            class50.method987("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
