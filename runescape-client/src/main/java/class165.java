import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class165 {
   @ObfuscatedName("i")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("u")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("f")
   public static int[] field2182 = new int[32];
   @ObfuscatedName("c")
   static int[] field2183;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2182[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "855451975"
   )
   public static boolean method3195() {
      long var0 = class45.method867();
      int var2 = (int)(var0 - class185.field2778);
      class185.field2778 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2763 += var2;
      if(class185.field2769 == 0 && class185.field2766 == 0 && class185.field2771 == 0 && class185.field2774 == 0) {
         return true;
      } else if(null == class185.field2770) {
         return false;
      } else {
         try {
            if(class185.field2763 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2766 < 20 && class185.field2774 > 0) {
                  var3 = (class181)class185.field2765.method2420();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class185.field2770.method2105(var4.payload, 0, 4);
                  class185.field2767.method2418(var3, var3.hash);
                  --class185.field2774;
                  ++class185.field2766;
               }

               while(class185.field2769 < 20 && class185.field2771 > 0) {
                  var3 = (class181)class185.field2768.method2369();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class185.field2770.method2105(var4.payload, 0, 4);
                  var3.method2495();
                  class185.field2772.method2418(var3, var3.hash);
                  --class185.field2771;
                  ++class185.field2769;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2770.method2108();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2763 = 0;
                  byte var5 = 0;
                  if(class1.field14 == null) {
                     var5 = 8;
                  } else if(class185.field2776 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2773.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2770.method2104(class185.field2773.payload, class185.field2773.offset, var6);
                     if(class185.field2780 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2773.payload[class185.field2773.offset + var7] ^= class185.field2780;
                        }
                     }

                     class185.field2773.offset += var6;
                     if(class185.field2773.offset < var5) {
                        break;
                     }

                     if(class1.field14 == null) {
                        class185.field2773.offset = 0;
                        var7 = class185.field2773.readUnsignedByte();
                        var8 = class185.field2773.readUnsignedShort();
                        int var9 = class185.field2773.readUnsignedByte();
                        var10 = class185.field2773.readInt();
                        long var11 = (long)((var7 << 16) + var8);
                        class181 var13 = (class181)class185.field2767.method2417(var11);
                        class26.field609 = true;
                        if(var13 == null) {
                           var13 = (class181)class185.field2772.method2417(var11);
                           class26.field609 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class1.field14 = var13;
                        class185.field2775 = new Buffer(var14 + var10 + class1.field14.field2721);
                        class185.field2775.putByte(var9);
                        class185.field2775.putInt(var10);
                        class185.field2776 = 8;
                        class185.field2773.offset = 0;
                     } else if(class185.field2776 == 0) {
                        if(class185.field2773.payload[0] == -1) {
                           class185.field2776 = 1;
                           class185.field2773.offset = 0;
                        } else {
                           class1.field14 = null;
                        }
                     }
                  } else {
                     var6 = class185.field2775.payload.length - class1.field14.field2721;
                     var7 = 512 - class185.field2776;
                     if(var7 > var6 - class185.field2775.offset) {
                        var7 = var6 - class185.field2775.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2770.method2104(class185.field2775.payload, class185.field2775.offset, var7);
                     if(class185.field2780 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class185.field2775.payload[var8 + class185.field2775.offset] ^= class185.field2780;
                        }
                     }

                     class185.field2775.offset += var7;
                     class185.field2776 += var7;
                     if(class185.field2775.offset == var6) {
                        if(class1.field14.hash == 16711935L) {
                           class149.field2064 = class185.field2775;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2779[var8];
                              if(var17 != null) {
                                 class149.field2064.offset = var8 * 8 + 5;
                                 var10 = class149.field2064.readInt();
                                 int var18 = class149.field2064.readInt();
                                 var17.method3420(var10, var18);
                              }
                           }
                        } else {
                           class185.field2764.reset();
                           class185.field2764.update(class185.field2775.payload, 0, var6);
                           var8 = (int)class185.field2764.getValue();
                           if(var8 != class1.field14.field2722) {
                              try {
                                 class185.field2770.method2113();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class185.field2781;
                              class185.field2770 = null;
                              class185.field2780 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2781 = 0;
                           class185.field2782 = 0;
                           class1.field14.field2723.method3448((int)(class1.field14.hash & 65535L), class185.field2775.payload, (class1.field14.hash & 16711680L) == 16711680L, class26.field609);
                        }

                        class1.field14.unlink();
                        if(class26.field609) {
                           --class185.field2766;
                        } else {
                           --class185.field2769;
                        }

                        class185.field2776 = 0;
                        class1.field14 = null;
                        class185.field2775 = null;
                     } else {
                        if(class185.field2776 != 512) {
                           break;
                        }

                        class185.field2776 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class185.field2770.method2113();
            } catch (Exception var19) {
               ;
            }

            ++class185.field2782;
            class185.field2770 = null;
            return false;
         }
      }
   }

   class165() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "-55"
   )
   public static String method3197(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "841932396"
   )
   static void method3198() {
      if(class41.field860) {
         class41.field836 = null;
         class88.field1561 = null;
         class41.field837 = null;
         class41.field838 = null;
         class1.field7 = null;
         class41.field839 = null;
         class41.field840 = null;
         class172.field2373 = null;
         class47.field951 = null;
         class8.field73 = null;
         class30.field718 = null;
         class36.field789 = null;
         XGrandExchangeOffer.field45 = null;
         CollisionData.field1858 = null;
         class63.field1122 = null;
         Friend.field158 = null;
         class41.field867 = null;
         class137.field1933 = null;
         Friend.field159 = null;
         class9.field83 = null;
         class25.field603 = null;
         MessageNode.field249 = null;
         CollisionData.method2347(2);
         class3.method19(true);
         class41.field860 = false;
      }
   }
}
