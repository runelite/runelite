import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class8 {
   @ObfuscatedName("bl")
   static class184 field68;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "-387156625"
   )
   static void method103(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2731;
      synchronized(class183.field2731) {
         for(class180 var5 = (class180)class183.field2731.method2503(); null != var5; var5 = (class180)class183.field2731.method2492()) {
            if((long)var0 == var5.hash && var5.field2691 == var1 && var5.field2695 == 0) {
               var3 = var5.field2690;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3448(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2332(var0);
         var2.method3448(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "69"
   )
   static int method104(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
         class32.field726[++class32.field735 - 1] = var3.item;
         return 1;
      } else if(var0 == 2701) {
         var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
         if(var3.item != -1) {
            class32.field726[++class32.field735 - 1] = var3.stackSize;
         } else {
            class32.field726[++class32.field735 - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class32.field726[--class32.field735];
         WidgetNode var4 = (WidgetNode)Client.componentTable.method2437((long)var5);
         if(var4 != null) {
            class32.field726[++class32.field735 - 1] = 1;
         } else {
            class32.field726[++class32.field735 - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class32.field726[++class32.field735 - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)Z",
      garbageValue = "0"
   )
   static boolean method105(class159 var0, int var1) {
      int var2 = var0.method3147(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3147(1) != 0) {
            method105(var0, var1);
         }

         var3 = var0.method3147(13);
         var4 = var0.method3147(13);
         boolean var12 = var0.method3147(1) == 1;
         if(var12) {
            class45.field920[++class45.field919 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field250 = var1;
            if(class45.field911[var1] != null) {
               var6.method228(class45.field911[var1]);
            }

            var6.field654 = class45.field917[var1];
            var6.interacting = class45.field910[var1];
            var7 = class45.field912[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field609[0] = class45.field928[var1];
            var6.field261 = (byte)var8;
            var6.method233(var3 + (var9 << 13) - Player.baseX, (var10 << 13) + var4 - SecondaryBufferProvider.baseY);
            var6.field242 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3147(2);
         var4 = class45.field912[var1];
         class45.field912[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3147(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field912[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field912[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method3147(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field912[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class45.field912[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   class8() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-72821990"
   )
   static int method107(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
      } else {
         var3 = var2?class32.field731:class108.field1738;
      }

      String var4 = class32.scriptStringStack[--class30.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class32.field726[--class32.field735];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class32.field726[--class32.field735]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class32.scriptStringStack[--class30.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class32.field726[--class32.field735]);
         }
      }

      var7 = class32.field726[--class32.field735];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2288 = var6;
      } else if(var0 == 1401) {
         var3.field2203 = var6;
      } else if(var0 == 1402) {
         var3.field2274 = var6;
      } else if(var0 == 1403) {
         var3.field2292 = var6;
      } else if(var0 == 1404) {
         var3.field2294 = var6;
      } else if(var0 == 1405) {
         var3.field2311 = var6;
      } else if(var0 == 1406) {
         var3.field2298 = var6;
      } else if(var0 == 1407) {
         var3.field2299 = var6;
         var3.field2253 = var5;
      } else if(var0 == 1408) {
         var3.field2305 = var6;
      } else if(var0 == 1409) {
         var3.field2306 = var6;
      } else if(var0 == 1410) {
         var3.field2296 = var6;
      } else if(var0 == 1411) {
         var3.field2207 = var6;
      } else if(var0 == 1412) {
         var3.field2293 = var6;
      } else if(var0 == 1414) {
         var3.field2301 = var6;
         var3.field2302 = var5;
      } else if(var0 == 1415) {
         var3.field2303 = var6;
         var3.field2304 = var5;
      } else if(var0 == 1416) {
         var3.field2252 = var6;
      } else if(var0 == 1417) {
         var3.field2307 = var6;
      } else if(var0 == 1418) {
         var3.field2308 = var6;
      } else if(var0 == 1419) {
         var3.field2309 = var6;
      } else if(var0 == 1420) {
         var3.field2286 = var6;
      } else if(var0 == 1421) {
         var3.field2322 = var6;
      } else if(var0 == 1422) {
         var3.field2312 = var6;
      } else if(var0 == 1423) {
         var3.field2313 = var6;
      } else if(var0 == 1424) {
         var3.field2314 = var6;
      } else if(var0 == 1425) {
         var3.field2276 = var6;
      } else if(var0 == 1426) {
         var3.field2317 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2315 = var6;
      }

      var3.field2221 = true;
      return 1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1072937652"
   )
   public static void method108() {
      Object var0 = class183.field2727;
      synchronized(class183.field2727) {
         if(class183.field2729 != 0) {
            class183.field2729 = 1;

            try {
               class183.field2727.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "1299248033"
   )
   public static int method109(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var4 + var6] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var4 + var6] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var4 + var6] = -107;
         } else if(var7 == 8211) {
            var3[var4 + var6] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var4 + var6] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var4 + var6] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }
}
