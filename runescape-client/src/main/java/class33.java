import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ar")
public final class class33 extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1296018267
   )
   int field730;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1379602061
   )
   int field731;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -828871153
   )
   int field732 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -45524281
   )
   int field733;
   @ObfuscatedName("j")
   Sequence field734;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2051285365
   )
   int field735;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2143686711
   )
   int field736;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 208456343
   )
   int field737 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1358891581
   )
   int field738;
   @ObfuscatedName("a")
   boolean field739 = false;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1815660611
   )
   protected static int field740;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "887511535"
   )
   final void method674(int var1) {
      if(!this.field739) {
         this.field732 += var1;

         while(this.field732 > this.field734.frameLenghts[this.field737]) {
            this.field732 -= this.field734.frameLenghts[this.field737];
            ++this.field737;
            if(this.field737 >= this.field734.frameIDs.length) {
               this.field739 = true;
               break;
            }
         }

      }
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field731 = var1;
      this.field736 = var2;
      this.field733 = var3;
      this.field738 = var4;
      this.field735 = var5;
      this.field730 = var7 + var6;
      int var8 = TextureProvider.method1452(this.field731).field2792;
      if(var8 != -1) {
         this.field739 = false;
         this.field734 = class146.getAnimation(var8);
      } else {
         this.field739 = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "427362345"
   )
   public static byte[] method676(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "18"
   )
   public static void method680(String var0, String var1, int var2, int var3) throws IOException {
      class104.field1681 = var3;
      class104.field1691 = var2;

      try {
         class104.field1687 = System.getProperty("os.name");
      } catch (Exception var12) {
         class104.field1687 = "Unknown";
      }

      class88.field1534 = class104.field1687.toLowerCase();

      try {
         ChatLineBuffer.field971 = System.getProperty("user.home");
         if(ChatLineBuffer.field971 != null) {
            ChatLineBuffer.field971 = ChatLineBuffer.field971 + "/";
         }
      } catch (Exception var11) {
         ;
      }

      try {
         if(class88.field1534.startsWith("win")) {
            if(ChatLineBuffer.field971 == null) {
               ChatLineBuffer.field971 = System.getenv("USERPROFILE");
            }
         } else if(ChatLineBuffer.field971 == null) {
            ChatLineBuffer.field971 = System.getenv("HOME");
         }

         if(ChatLineBuffer.field971 != null) {
            ChatLineBuffer.field971 = ChatLineBuffer.field971 + "/";
         }
      } catch (Exception var10) {
         ;
      }

      if(ChatLineBuffer.field971 == null) {
         ChatLineBuffer.field971 = "~/";
      }

      class60.field1084 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", ChatLineBuffer.field971, "/tmp/", ""};
      class174.field2633 = new String[]{".jagex_cache_" + class104.field1691, ".file_store_" + class104.field1691};
      int var9 = 0;

      label89:
      while(var9 < 4) {
         Widget.field2332 = class203.method3795(var0, var1, var9);
         if(!Widget.field2332.exists()) {
            Widget.field2332.mkdirs();
         }

         File[] var5 = Widget.field2332.listFiles();
         if(null == var5) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label89;
            }

            File var8 = var6[var7];
            if(!class22.method216(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      XClanMember.method251(Widget.field2332);
      class11.method159();
      class104.field1688 = new class72(new FileOnDisk(class11.method158("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class104.field1689 = new class72(new FileOnDisk(class11.method158("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      Friend.field151 = new class72[class104.field1681];

      for(var9 = 0; var9 < class104.field1681; ++var9) {
         Friend.field151[var9] = new class72(new FileOnDisk(class11.method158("main_file_cache.idx" + var9), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   protected final Model getModel() {
      Spotanim var1 = TextureProvider.method1452(this.field731);
      Model var2;
      if(!this.field739) {
         var2 = var1.method3456(this.field737);
      } else {
         var2 = var1.method3456(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1724160691"
   )
   static void method682(Widget var0) {
      if(var0.field2328 == Client.field481) {
         Client.field482[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "421494437"
   )
   static final void method683(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field559 == 0) {
         var1 = Renderable.region.method1778(var0.field565, var0.field560, var0.field562);
      }

      if(var0.field559 == 1) {
         var1 = Renderable.region.method1726(var0.field565, var0.field560, var0.field562);
      }

      if(var0.field559 == 2) {
         var1 = Renderable.region.method1727(var0.field565, var0.field560, var0.field562);
      }

      if(var0.field559 == 3) {
         var1 = Renderable.region.method1741(var0.field565, var0.field560, var0.field562);
      }

      if(var1 != 0) {
         int var5 = Renderable.region.method1729(var0.field565, var0.field560, var0.field562, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field563 = var2;
      var0.field571 = var3;
      var0.field564 = var4;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "61"
   )
   static final void method684(int var0, int var1, int var2, int var3, int var4) {
      class26.field583[0].method4083(var0, var1);
      class26.field583[1].method4083(var0, var3 + var1 - 16);
      Rasterizer2D.method4020(var0, var1 + 16, 16, var3 - 32, Client.field537);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4020(var0, var1 + 16 + var6, 16, var5, Client.field357);
      Rasterizer2D.method4016(var0, var6 + var1 + 16, var5, Client.field359);
      Rasterizer2D.method4016(var0 + 1, var6 + var1 + 16, var5, Client.field359);
      Rasterizer2D.method3999(var0, var6 + var1 + 16, 16, Client.field359);
      Rasterizer2D.method3999(var0, var6 + var1 + 17, 16, Client.field359);
      Rasterizer2D.method4016(15 + var0, var6 + 16 + var1, var5, Client.field358);
      Rasterizer2D.method4016(var0 + 14, var6 + 17 + var1, var5 - 1, Client.field358);
      Rasterizer2D.method3999(var0, var1 + 15 + var6 + var5, 16, Client.field358);
      Rasterizer2D.method3999(var0 + 1, var6 + var1 + 14 + var5, 15, Client.field358);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1180396875"
   )
   static void method685() {
      int var0 = class26.field577;
      int var1 = class187.field2776;
      if(class40.field813 < var0) {
         var0 = class40.field813;
      }

      if(class8.field75 < var1) {
         var1 = class8.field75;
      }

      if(class107.field1733 != null) {
         try {
            Client var2 = class88.field1536;
            int var3 = Client.isResized?2:1;
            Object[] var4 = new Object[]{Integer.valueOf(var3)};
            JSObject.getWindow(var2).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }
}
