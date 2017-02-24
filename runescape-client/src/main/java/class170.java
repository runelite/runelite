import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class170 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "85"
   )
   public static void method3259(String var0, String var1, int var2, int var3) throws IOException {
      class88.field1552 = var3;
      class116.field1815 = var2;

      try {
         class210.field3125 = System.getProperty("os.name");
      } catch (Exception var28) {
         class210.field3125 = "Unknown";
      }

      TextureProvider.field1212 = class210.field3125.toLowerCase();

      try {
         class104.field1699 = System.getProperty("user.home");
         if(class104.field1699 != null) {
            class104.field1699 = class104.field1699 + "/";
         }
      } catch (Exception var27) {
         ;
      }

      try {
         if(TextureProvider.field1212.startsWith("win")) {
            if(class104.field1699 == null) {
               class104.field1699 = System.getenv("USERPROFILE");
            }
         } else if(class104.field1699 == null) {
            class104.field1699 = System.getenv("HOME");
         }

         if(class104.field1699 != null) {
            class104.field1699 = class104.field1699 + "/";
         }
      } catch (Exception var26) {
         ;
      }

      if(null == class104.field1699) {
         class104.field1699 = "~/";
      }

      class72.field1191 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class104.field1699, "/tmp/", ""};
      class104.field1697 = new String[]{".jagex_cache_" + class116.field1815, ".file_store_" + class116.field1815};
      int var18 = 0;

      label249:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class104.field1687 = new File(class104.field1699, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var33;
         if(class104.field1687.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class104.field1687, "rw", 10000L);

               int var12;
               for(var11 = new Buffer((int)var10.method1477()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method1472(var11.payload, var11.offset, var11.payload.length - var11.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.readUnsignedByte();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.readUnsignedByte();
               }

               if(var12 <= 2) {
                  var7 = var11.method2842();
                  if(var13 == 1) {
                     var8 = var11.method2842();
                  }
               } else {
                  var7 = var11.method2843();
                  if(var13 == 1) {
                     var8 = var11.method2843();
                  }
               }

               var10.method1475();
            } catch (IOException var30) {
               var30.printStackTrace();
            }

            if(null != var7) {
               var33 = new File(var7);
               if(!var33.exists()) {
                  var7 = null;
               }
            }

            if(null != var7) {
               var33 = new File(var7, "test.dat");
               if(!class7.method84(var33, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label224:
            for(int var19 = 0; var19 < class104.field1697.length; ++var19) {
               for(int var20 = 0; var20 < class72.field1191.length; ++var20) {
                  File var21 = new File(class72.field1191[var20] + class104.field1697[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && class7.method84(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label224;
                  }
               }
            }
         }

         if(null == var7) {
            var7 = class104.field1699 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var32;
         if(var8 != null) {
            var32 = new File(var8);
            var33 = new File(var7);

            try {
               File[] var35 = var32.listFiles();
               File[] var22 = var35;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var33, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var29) {
               var29.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var32 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var36 = new FileOnDisk(class104.field1687, "rw", 10000L);
               Buffer var37 = new Buffer(500);
               var37.method2918(3);
               var37.method2918(null != var11?1:0);
               var37.method2826(var32.getPath());
               if(var11 != null) {
                  var37.method2826("");
               }

               var36.method1469(var37.payload, 0, var37.offset);
               var36.method1475();
            } catch (IOException var25) {
               var25.printStackTrace();
            }
         }

         File var5 = new File(var7);
         class104.field1691 = var5;
         if(!class104.field1691.exists()) {
            class104.field1691.mkdirs();
         }

         File[] var31 = class104.field1691.listFiles();
         if(var31 != null) {
            File[] var34 = var31;

            for(int var23 = 0; var23 < var34.length; ++var23) {
               File var24 = var34[var23];
               if(!class7.method84(var24, false)) {
                  ++var18;
                  continue label249;
               }
            }
         }
         break;
      }

      WidgetNode.method189(class104.field1691);
      class25.method605();
      class104.field1695 = new class72(new FileOnDisk(class22.method222("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class104.field1696 = new class72(new FileOnDisk(class22.method222("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      TextureProvider.field1222 = new class72[class88.field1552];

      for(var18 = 0; var18 < class88.field1552; ++var18) {
         TextureProvider.field1222[var18] = new class72(new FileOnDisk(class22.method222("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   static final void method3267() {
      class174.method3276(Client.field523);
      ++class45.field922;
      if(Client.field455 && Client.field516) {
         int var0 = class115.field1792;
         int var1 = class115.field1799;
         var0 -= Client.field480;
         var1 -= Client.field369;
         if(var0 < Client.field319) {
            var0 = Client.field319;
         }

         if(Client.field523.width + var0 > Client.field319 + Client.field530.width) {
            var0 = Client.field530.width + Client.field319 - Client.field523.width;
         }

         if(var1 < Client.field485) {
            var1 = Client.field485;
         }

         if(Client.field523.height + var1 > Client.field485 + Client.field530.height) {
            var1 = Client.field485 + Client.field530.height - Client.field523.height;
         }

         int var2 = var0 - Client.field531;
         int var3 = var1 - Client.field488;
         int var4 = Client.field523.field2281;
         if(class45.field922 > Client.field523.field2236 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field492 = true;
         }

         int var5 = var0 - Client.field319 + Client.field530.scrollX;
         int var6 = Client.field530.scrollY + (var1 - Client.field485);
         class18 var7;
         if(Client.field523.field2282 != null && Client.field492) {
            var7 = new class18();
            var7.field198 = Client.field523;
            var7.field205 = var5;
            var7.field200 = var6;
            var7.field209 = Client.field523.field2282;
            FloorUnderlayDefinition.method3491(var7);
         }

         if(class115.field1794 == 0) {
            if(Client.field492) {
               if(null != Client.field523.field2295) {
                  var7 = new class18();
                  var7.field198 = Client.field523;
                  var7.field205 = var5;
                  var7.field200 = var6;
                  var7.field210 = Client.field343;
                  var7.field209 = Client.field523.field2295;
                  class174.method3275(var7, 200000);
               }

               if(Client.field343 != null && FrameMap.method1746(Client.field523) != null) {
                  Client.field348.method3073(252);
                  Client.field348.method2865(Client.field523.item);
                  Client.field348.method2821(Client.field343.id);
                  Client.field348.method2862(Client.field343.item);
                  Client.field348.method2862(Client.field343.index);
                  Client.field348.method2821(Client.field523.id);
                  Client.field348.method2862(Client.field523.index);
               }
            } else {
               int var10 = Buffer.method2893();
               if(Client.menuOptionCount > 2 && (Client.field442 == 1 && !WidgetNode.method192() || class149.method2801(var10))) {
                  WidgetNode.method190(Client.field531 + Client.field480, Client.field369 + Client.field488);
               } else if(Client.menuOptionCount > 0) {
                  int var8 = Client.field480 + Client.field531;
                  int var9 = Client.field369 + Client.field488;
                  ObjectComposition.method3659(class9.field90, var8, var9);
                  class9.field90 = null;
               }
            }

            Client.field523 = null;
         }

      } else {
         if(class45.field922 > 1) {
            Client.field523 = null;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-415520252"
   )
   public static void method3269(class182 var0) {
      class187.field2777 = var0;
      class187.field2782 = class187.field2777.method3313(16);
   }

   class170() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "11"
   )
   public static String method3271(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class3.method39(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
