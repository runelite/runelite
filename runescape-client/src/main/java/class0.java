import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class0 implements Comparator {
   @ObfuscatedName("be")
   static class184 field0;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 21322501
   )
   static int field5;
   @ObfuscatedName("d")
   public static class182 field6;
   @ObfuscatedName("gh")
   static Widget field7;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2022673844"
   )
   static void method1(int var0, int var1, int var2, int var3) {
      for(class31 var4 = (class31)class31.field733.method2458(); null != var4; var4 = (class31)class31.field733.method2472()) {
         if(var4.field736 != -1 || var4.field732 != null) {
            int var5 = 0;
            if(var1 > var4.field725) {
               var5 += var1 - var4.field725;
            } else if(var1 < var4.field723) {
               var5 += var4.field723 - var1;
            }

            if(var2 > var4.field730) {
               var5 += var2 - var4.field730;
            } else if(var2 < var4.field737) {
               var5 += var4.field737 - var2;
            }

            if(var5 - 64 <= var4.field724 && Client.field546 != 0 && var0 == var4.field727) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = Client.field546 * (var4.field724 - var5) / var4.field724;
               if(null == var4.field729) {
                  if(var4.field736 >= 0) {
                     class53 var7 = class53.method1039(Client.field336, var4.field736, 0);
                     if(null != var7) {
                        class55 var8 = var7.method1040().method1084(World.field706);
                        class66 var9 = class66.method1235(var8, 100, var6);
                        var9.method1243(-1);
                        class16.field184.method985(var9);
                        var4.field729 = var9;
                     }
                  }
               } else {
                  var4.field729.method1237(var6);
               }

               if(var4.field734 == null) {
                  if(null != var4.field732 && (var4.field721 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field732.length);
                     class53 var12 = class53.method1039(Client.field336, var4.field732[var11], 0);
                     if(var12 != null) {
                        class55 var13 = var12.method1040().method1084(World.field706);
                        class66 var10 = class66.method1235(var13, 100, var6);
                        var10.method1243(0);
                        class16.field184.method985(var10);
                        var4.field734 = var10;
                        var4.field721 = var4.field728 + (int)(Math.random() * (double)(var4.field731 - var4.field728));
                     }
                  }
               } else {
                  var4.field734.method1237(var6);
                  if(!var4.field734.linked()) {
                     var4.field734 = null;
                  }
               }
            } else {
               if(var4.field729 != null) {
                  class16.field184.method990(var4.field729);
                  var4.field729 = null;
               }

               if(null != var4.field734) {
                  class16.field184.method990(var4.field734);
                  var4.field734 = null;
               }
            }
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method8((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "1507671869"
   )
   static int method2(int var0, class48 var1, boolean var2) {
      Widget var3 = class179.method3296(class32.field747[--class103.field1686]);
      if(var0 == 2500) {
         class32.field747[++class103.field1686 - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class32.field747[++class103.field1686 - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class32.field747[++class103.field1686 - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class32.field747[++class103.field1686 - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class32.field747[++class103.field1686 - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class32.field747[++class103.field1686 - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1706346803"
   )
   int method8(class2 var1, class2 var2) {
      return var1.field30 < var2.field30?-1:(var2.field30 == var1.field30?0:1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-331092581"
   )
   static final int method10(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2918(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2821(var3.nextInt());
      }

      var4.method2821(var6[0]);
      var4.method2821(var6[1]);
      var4.method2993(var0);
      var4.method2993(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2821(var3.nextInt());
      }

      var4.method2828(class36.field802, class36.field794);
      var5.method2918(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2821(var3.nextInt());
      }

      var5.method2993(var3.nextLong());
      var5.method2820(var3.nextLong());
      byte[] var20 = new byte[24];

      try {
         class104.field1692.method1453(0L);
         class104.field1692.method1446(var20);

         int var8;
         for(var8 = 0; var8 < 24 && var20[var8] == 0; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var29) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var20[var9] = -1;
         }
      }

      var5.method2827(var20, 0, 24);
      var5.method2993(var3.nextLong());
      var5.method2828(class36.field802, class36.field794);
      var7 = class119.method2340(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var21 = new Buffer(var7);
      var21.method2824(var2);
      var21.offset = var7;
      var21.method2981(var6);
      Buffer var22 = new Buffer(var21.offset + var4.offset + 5 + var5.offset);
      var22.method2918(2);
      var22.method2918(var4.offset);
      var22.method2827(var4.payload, 0, var4.offset);
      var22.method2918(var5.offset);
      var22.method2827(var5.payload, 0, var5.offset);
      var22.method2831(var21.offset);
      var22.method2827(var21.payload, 0, var21.offset);
      byte[] var11 = var22.payload;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < var13 + 0; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class206.field3090[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[1 + var15] & 255;
            var14.append(class206.field3090[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[2 + var15] & 255;
               var14.append(class206.field3090[(var17 & 15) << 2 | var18 >>> 6]).append(class206.field3090[var18 & 63]);
            } else {
               var14.append(class206.field3090[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class206.field3090[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var23 = new URL(Item.method876("services", false) + "m=accountappeal/login.ws");
         URLConnection var30 = var23.openConnection();
         var30.setDoInput(true);
         var30.setDoOutput(true);
         var30.setConnectTimeout(5000);
         OutputStreamWriter var24 = new OutputStreamWriter(var30.getOutputStream());
         var24.write("data2=" + class170.method3271(var12) + "&dest=" + class170.method3271("passwordchoice.ws"));
         var24.flush();
         InputStream var25 = var30.getInputStream();
         var22 = new Buffer(new byte[1000]);

         do {
            var17 = var25.read(var22.payload, var22.offset, 1000 - var22.offset);
            if(var17 == -1) {
               var24.close();
               var25.close();
               String var26 = new String(var22.payload);
               if(var26.startsWith("OFFLINE")) {
                  return 4;
               } else if(var26.startsWith("WRONG")) {
                  return 7;
               } else if(var26.startsWith("RELOAD")) {
                  return 3;
               } else if(var26.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var22.method2851(var6);

                  while(var22.offset > 0 && var22.payload[var22.offset - 1] == 0) {
                     --var22.offset;
                  }

                  var26 = new String(var22.payload, 0, var22.offset);
                  boolean var31;
                  if(null == var26) {
                     var31 = false;
                  } else {
                     label117: {
                        try {
                           new URL(var26);
                        } catch (MalformedURLException var27) {
                           var31 = false;
                           break label117;
                        }

                        var31 = true;
                     }
                  }

                  if(var31) {
                     TextureProvider.method1507(var26, true, "openjs", false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var22.offset += var17;
         } while(var22.offset < 1000);

         return 5;
      } catch (Throwable var28) {
         var28.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "99"
   )
   public static synchronized long method11() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2112) {
         class155.field2113 += class155.field2112 - var0;
      }

      class155.field2112 = var0;
      return class155.field2113 + var0;
   }
}
