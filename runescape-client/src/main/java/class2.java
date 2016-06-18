import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("k")
   @Export("model")
   class105 field25;
   @ObfuscatedName("b")
   @Export("name")
   String field26;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1336130399
   )
   int field27;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 693995303
   )
   int field28 = -1;
   @ObfuscatedName("i")
   boolean field29;
   @ObfuscatedName("y")
   @Export("actions")
   String[] field30 = new String[3];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1561114499
   )
   @Export("combatLevel")
   int field31;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 156232315
   )
   int field33;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1439046977
   )
   @Export("totalLevel")
   int field34;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 46191959
   )
   int field35 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1674069093
   )
   int field36;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 547708699
   )
   int field37;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -726922457
   )
   int field38;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -129276329
   )
   int field39;
   @ObfuscatedName("q")
   boolean field40;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1947053057
   )
   int field41;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -256668805
   )
   int field42;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1771154413
   )
   int field43;
   @ObfuscatedName("a")
   boolean field44;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1224008187
   )
   @Export("team")
   int field45;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -732817551
   )
   int field46;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1669445819
   )
   int field47;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1010816179
   )
   int field48;
   @ObfuscatedName("g")
   @Export("composition")
   class179 field49;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1874750333
   )
   int field50;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1490492503
   )
   int field51;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1161111898"
   )
   final void method13(class119 var1) {
      var1.field1976 = 0;
      int var2 = var1.method2514();
      this.field35 = var1.method2515();
      this.field28 = var1.method2515();
      int var3 = -1;
      this.field45 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2514();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2514();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2516();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class35.method741(var4[var5] - 512).field1122;
               if(var8 != 0) {
                  this.field45 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2514();
         if(var7 < 0 || var7 >= class34.field760[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field795 = var1.method2516();
      if(super.field795 == '\uffff') {
         super.field795 = -1;
      }

      super.field796 = var1.method2516();
      if(super.field796 == '\uffff') {
         super.field796 = -1;
      }

      super.field797 = super.field796;
      super.field798 = var1.method2516();
      if(super.field798 == '\uffff') {
         super.field798 = -1;
      }

      super.field821 = var1.method2516();
      if(super.field821 == '\uffff') {
         super.field821 = -1;
      }

      super.field800 = var1.method2516();
      if(super.field800 == '\uffff') {
         super.field800 = -1;
      }

      super.field848 = var1.method2516();
      if(super.field848 == '\uffff') {
         super.field848 = -1;
      }

      super.field802 = var1.method2516();
      if(super.field802 == '\uffff') {
         super.field802 = -1;
      }

      this.field26 = var1.method2522();
      if(this == class153.field2262) {
         class148.field2207 = this.field26;
      }

      this.field31 = var1.method2514();
      this.field43 = var1.method2516();
      this.field40 = var1.method2514() == 1;
      if(client.field548 == 0 && client.field354 >= 2) {
         this.field40 = false;
      }

      if(null == this.field49) {
         this.field49 = new class179();
      }

      this.field49.method3516(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "89"
   )
   int method14() {
      return this.field49 != null && this.field49.field2911 != -1?class176.method3460(this.field49.field2911).field865:1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   protected final class105 vmethod1913() {
      if(null == this.field49) {
         return null;
      } else {
         class42 var1 = super.field801 != -1 && super.field827 == 0?class17.method178(super.field801):null;
         class42 var2 = super.field818 == -1 || this.field44 || super.field818 == super.field795 && var1 != null?null:class17.method178(super.field818);
         class105 var3 = this.field49.method3519(var1, super.field822, var2, super.field819);
         if(null == var3) {
            return null;
         } else {
            var3.method2323();
            super.field839 = var3.field1436;
            class105 var4;
            class105[] var5;
            if(!this.field44 && super.field835 != -1 && super.field811 != -1) {
               var4 = class32.method708(super.field835).method908(super.field811);
               if(var4 != null) {
                  var4.method2315(0, -super.field834, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field44 && null != this.field25) {
               if(client.field296 >= this.field39) {
                  this.field25 = null;
               }

               if(client.field296 >= this.field34 && client.field296 < this.field39) {
                  var4 = this.field25;
                  var4.method2315(this.field36 - super.field813, this.field37 - this.field33, this.field38 - super.field791);
                  if(super.field840 == 512) {
                     var4.method2305();
                     var4.method2305();
                     var4.method2305();
                  } else if(super.field840 == 1024) {
                     var4.method2305();
                     var4.method2305();
                  } else if(super.field840 == 1536) {
                     var4.method2305();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(super.field840 == 512) {
                     var4.method2305();
                  } else if(super.field840 == 1024) {
                     var4.method2305();
                     var4.method2305();
                  } else if(super.field840 == 1536) {
                     var4.method2305();
                     var4.method2305();
                     var4.method2305();
                  }

                  var4.method2315(super.field813 - this.field36, this.field33 - this.field37, super.field791 - this.field38);
               }
            }

            var3.field1811 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "0"
   )
   final void method16(int var1, int var2, byte var3) {
      if(super.field801 != -1 && class17.method178(super.field801).field978 == 1) {
         super.field801 = -1;
      }

      super.field817 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field844[0] >= 0 && super.field844[0] < 104 && super.field831[0] >= 0 && super.field831[0] < 104) {
            if(var3 == 2) {
               class41.method861(this, var1, var2, (byte)2);
            }

            this.method18(var1, var2, var3);
         } else {
            this.method17(var1, var2);
         }
      } else {
         this.method17(var1, var2);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "14"
   )
   void method17(int var1, int var2) {
      super.field808 = 0;
      super.field836 = 0;
      super.field847 = 0;
      super.field844[0] = var1;
      super.field831[0] = var2;
      int var3 = this.method14();
      super.field813 = super.field844[0] * 128 + 64 * var3;
      super.field791 = super.field831[0] * 128 + 64 * var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "-24562"
   )
   final void method18(int var1, int var2, byte var3) {
      if(super.field808 < 9) {
         ++super.field808;
      }

      for(int var4 = super.field808; var4 > 0; --var4) {
         super.field844[var4] = super.field844[var4 - 1];
         super.field831[var4] = super.field831[var4 - 1];
         super.field846[var4] = super.field846[var4 - 1];
      }

      super.field844[0] = var1;
      super.field831[0] = var2;
      super.field846[0] = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "9"
   )
   final boolean vmethod760() {
      return this.field49 != null;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1213214241"
   )
   static final String method21(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class158.method3184('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class158.method3184(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class158.method3184(16776960) + var1 + "</col>");
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field30[var1] = "";
      }

      this.field31 = 0;
      this.field43 = 0;
      this.field34 = 0;
      this.field39 = 0;
      this.field44 = false;
      this.field45 = 0;
      this.field40 = false;
      this.field29 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-669595725"
   )
   public static void method35(String var0, String var1, int var2, int var3) throws IOException {
      class149.field2216 = var3;
      class124.field2021 = var2;

      try {
         class139.field2125 = System.getProperty("os.name");
      } catch (Exception var14) {
         class139.field2125 = "Unknown";
      }

      class111.field1938 = class139.field2125.toLowerCase();

      try {
         class119.field1985 = System.getProperty("user.home");
         if(null != class119.field1985) {
            class119.field1985 = class119.field1985 + "/";
         }
      } catch (Exception var13) {
         ;
      }

      try {
         if(class111.field1938.startsWith("win")) {
            if(class119.field1985 == null) {
               class119.field1985 = System.getenv("USERPROFILE");
            }
         } else if(class119.field1985 == null) {
            class119.field1985 = System.getenv("HOME");
         }

         if(null != class119.field1985) {
            class119.field1985 = class119.field1985 + "/";
         }
      } catch (Exception var12) {
         ;
      }

      if(class119.field1985 == null) {
         class119.field1985 = "~/";
      }

      class149.field2222 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class119.field1985, "/tmp/", ""};
      class121.field1993 = new String[]{".jagex_cache_" + class124.field2021, ".file_store_" + class124.field2021};
      int var9 = 0;

      int var7;
      File var8;
      label135:
      while(var9 < 4) {
         class103.field1759 = class36.method751(var0, var1, var9);
         if(!class103.field1759.exists()) {
            class103.field1759.mkdirs();
         }

         File[] var5 = class103.field1759.listFiles();
         if(null == var5) {
            break;
         }

         File[] var6 = var5;
         var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label135;
            }

            var8 = var6[var7];
            if(!class125.method2830(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      File var4 = class103.field1759;
      class135.field2062 = var4;
      if(!class135.field2062.exists()) {
         throw new RuntimeException("");
      } else {
         class135.field2071 = true;

         try {
            File var16 = new File(class119.field1985, "random.dat");
            if(var16.exists()) {
               class149.field2219 = new class228(new class227(var16, "rw", 25L), 24, 0);
            } else {
               label115:
               for(int var10 = 0; var10 < class121.field1993.length; ++var10) {
                  for(var7 = 0; var7 < class149.field2222.length; ++var7) {
                     var8 = new File(class149.field2222[var7] + class121.field1993[var10] + File.separatorChar + "random.dat");
                     if(var8.exists()) {
                        class149.field2219 = new class228(new class227(var8, "rw", 25L), 24, 0);
                        break label115;
                     }
                  }
               }
            }

            if(null == class149.field2219) {
               RandomAccessFile var17 = new RandomAccessFile(var16, "rw");
               var7 = var17.read();
               var17.seek(0L);
               var17.write(var7);
               var17.seek(0L);
               var17.close();
               class149.field2219 = new class228(new class227(var16, "rw", 25L), 24, 0);
            }
         } catch (IOException var15) {
            ;
         }

         class149.field2220 = new class228(new class227(class114.method2452("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class149.field2221 = new class228(new class227(class114.method2452("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         class24.field621 = new class228[class149.field2216];

         for(int var11 = 0; var11 < class149.field2216; ++var11) {
            class24.field621[var11] = new class228(new class227(class114.method2452("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
         }

      }
   }
}
