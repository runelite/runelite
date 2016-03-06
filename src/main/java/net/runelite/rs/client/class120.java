import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public class class120 {
   @ObfuscatedName("m")
   static byte[][] field2001 = new byte[50][];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1434686779
   )
   static int field2002 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 181994543
   )
   static int field2003 = 0;
   @ObfuscatedName("i")
   static byte[][] field2004 = new byte[1000][];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -601787489
   )
   static int field2005 = 0;
   @ObfuscatedName("f")
   static byte[][] field2007 = new byte[250][];

   @ObfuscatedName("j")
   static synchronized byte[] method2678(int var0) {
      byte[] var1;
      if(100 == var0 && field2003 > 0) {
         var1 = field2004[--field2003];
         field2004[field2003] = null;
         return var1;
      } else if(5000 == var0 && field2002 > 0) {
         var1 = field2007[--field2002];
         field2007[field2002] = null;
         return var1;
      } else if(var0 == 30000 && field2005 > 0) {
         var1 = field2001[--field2005];
         field2001[field2005] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("f")
   static void method2679() {
      class31.field731 = class31.field731.trim();
      if(class31.field731.length() == 0) {
         class3.method32("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class0.method0();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = class16.method185(var1, class31.field731);
         }

         switch(var0) {
         case 2:
            class3.method32("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field722 = 6;
            break;
         case 3:
            class3.method32("", "Error connecting to server.", "");
            break;
         case 4:
            class3.method32("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class3.method32("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class3.method32("", "Error connecting to server.", "");
            break;
         case 7:
            class3.method32("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("bv")
   static final void method2681(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field409.method3773(); null != var10; var10 = (class16)client.field409.method3772()) {
         if(var0 == var10.field242 && var1 == var10.field230 && var2 == var10.field235 && var10.field231 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field242 = var0;
         var9.field231 = var3;
         var9.field230 = var1;
         var9.field235 = var2;
         class169.method3327(var9);
         client.field409.method3768(var9);
      }

      var9.field237 = var4;
      var9.field239 = var5;
      var9.field238 = var6;
      var9.field240 = var7;
      var9.field244 = var8;
   }

   @ObfuscatedName("j")
   public static boolean method2682() {
      long var0 = class109.method2381();
      int var2 = (int)(var0 - class170.field2722);
      class170.field2722 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class170.field2724 += var2;
      if(class170.field2736 == 0 && 0 == class170.field2726 && class170.field2729 == 0 && class170.field2741 == 0) {
         return true;
      } else if(class216.field3155 == null) {
         return false;
      } else {
         try {
            if(class170.field2724 > 30000) {
               throw new IOException();
            } else {
               class171 var3;
               class118 var4;
               while(class170.field2726 < 20 && class170.field2741 > 0) {
                  var3 = (class171)class170.field2723.method3748();
                  var4 = new class118(4);
                  var4.method2438(1);
                  var4.method2457((int)var3.field3112);
                  class216.field3155.method2932(var4.field1995, 0, 4);
                  class170.field2735.method3746(var3, var3.field3112);
                  --class170.field2741;
                  ++class170.field2726;
               }

               while(class170.field2736 < 20 && class170.field2729 > 0) {
                  var3 = (class171)class170.field2727.method3817();
                  var4 = new class118(4);
                  var4.method2438(0);
                  var4.method2457((int)var3.field3112);
                  class216.field3155.method2932(var4.field1995, 0, 4);
                  var3.method3835();
                  class170.field2730.method3746(var3, var3.field3112);
                  --class170.field2729;
                  ++class170.field2736;
               }

               for(int var18 = 0; var18 < 100; ++var18) {
                  int var19 = class216.field3155.method2940();
                  if(var19 < 0) {
                     throw new IOException();
                  }

                  if(var19 == 0) {
                     break;
                  }

                  class170.field2724 = 0;
                  byte var5 = 0;
                  if(null == class170.field2732) {
                     var5 = 8;
                  } else if(0 == class170.field2734) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class170.field2733.field1998;
                     if(var6 > var19) {
                        var6 = var19;
                     }

                     class216.field3155.method2931(class170.field2733.field1995, class170.field2733.field1998, var6);
                     if(class170.field2737 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class170.field2733.field1995[class170.field2733.field1998 + var7] ^= class170.field2737;
                        }
                     }

                     class170.field2733.field1998 += var6;
                     if(class170.field2733.field1998 < var5) {
                        break;
                     }

                     if(class170.field2732 == null) {
                        class170.field2733.field1998 = 0;
                        var7 = class170.field2733.method2453();
                        var8 = class170.field2733.method2455();
                        int var9 = class170.field2733.method2453();
                        var10 = class170.field2733.method2458();
                        long var11 = (long)((var7 << 16) + var8);
                        class171 var13 = (class171)class170.field2735.method3744(var11);
                        class150.field2267 = true;
                        if(null == var13) {
                           var13 = (class171)class170.field2730.method3744(var11);
                           class150.field2267 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = 0 == var9?5:9;
                        class170.field2732 = var13;
                        class11.field179 = new class118(class170.field2732.field2745 + var10 + var14);
                        class11.field179.method2438(var9);
                        class11.field179.method2441(var10);
                        class170.field2734 = 8;
                        class170.field2733.field1998 = 0;
                     } else if(0 == class170.field2734) {
                        if(-1 == class170.field2733.field1995[0]) {
                           class170.field2734 = 1;
                           class170.field2733.field1998 = 0;
                        } else {
                           class170.field2732 = null;
                        }
                     }
                  } else {
                     var6 = class11.field179.field1995.length - class170.field2732.field2745;
                     var7 = 512 - class170.field2734;
                     if(var7 > var6 - class11.field179.field1998) {
                        var7 = var6 - class11.field179.field1998;
                     }

                     if(var7 > var19) {
                        var7 = var19;
                     }

                     class216.field3155.method2931(class11.field179.field1995, class11.field179.field1998, var7);
                     if(class170.field2737 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class11.field179.field1995[class11.field179.field1998 + var8] ^= class170.field2737;
                        }
                     }

                     class11.field179.field1998 += var7;
                     class170.field2734 += var7;
                     if(class11.field179.field1998 == var6) {
                        if(class170.field2732.field3112 == 16711935L) {
                           class15.field228 = class11.field179;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class167 var20 = class170.field2721[var8];
                              if(var20 != null) {
                                 class15.field228.field1998 = 5 + var8 * 8;
                                 var10 = class15.field228.method2458();
                                 int var21 = class15.field228.method2458();
                                 var20.method3294(var10, var21);
                              }
                           }
                        } else {
                           class170.field2731.reset();
                           class170.field2731.update(class11.field179.field1995, 0, var6);
                           var8 = (int)class170.field2731.getValue();
                           if(var8 != class170.field2732.field2743) {
                              try {
                                 class216.field3155.method2948();
                              } catch (Exception var16) {
                                 ;
                              }

                              ++class170.field2738;
                              class216.field3155 = null;
                              class170.field2737 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class170.field2738 = 0;
                           class170.field2739 = 0;
                           class170.field2732.field2748.method3291((int)(class170.field2732.field3112 & 65535L), class11.field179.field1995, (class170.field2732.field3112 & 16711680L) == 16711680L, class150.field2267);
                        }

                        class170.field2732.method3853();
                        if(class150.field2267) {
                           --class170.field2726;
                        } else {
                           --class170.field2736;
                        }

                        class170.field2734 = 0;
                        class170.field2732 = null;
                        class11.field179 = null;
                     } else {
                        if(class170.field2734 != 512) {
                           break;
                        }

                        class170.field2734 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var17) {
            try {
               class216.field3155.method2948();
            } catch (Exception var15) {
               ;
            }

            ++class170.field2739;
            class216.field3155 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   public static void method2683(class118 var0, int var1) {
      if(null != class148.field2241) {
         try {
            class148.field2241.method4084(0L);
            class148.field2241.method4087(var0.field1995, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("k")
   public static int method2684(String var0) {
      return var0.length() + 2;
   }
}
