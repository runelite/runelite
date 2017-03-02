import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public final class class176 {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "4"
   )
   static int method3329(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class140.method2681(class32.field729[--class101.field1648]);
      } else {
         var3 = var2?class32.field719:class185.field2760;
      }

      String var4 = class32.scriptStringStack[--World.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class32.field729[--class101.field1648];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class32.field729[--class101.field1648]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class32.scriptStringStack[--World.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class32.field729[--class101.field1648]);
         }
      }

      var7 = class32.field729[--class101.field1648];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2186 = var6;
      } else if(var0 == 1401) {
         var3.field2330 = var6;
      } else if(var0 == 1402) {
         var3.field2327 = var6;
      } else if(var0 == 1403) {
         var3.field2282 = var6;
      } else if(var0 == 1404) {
         var3.field2241 = var6;
      } else if(var0 == 1405) {
         var3.field2285 = var6;
      } else if(var0 == 1406) {
         var3.field2263 = var6;
      } else if(var0 == 1407) {
         var3.field2289 = var6;
         var3.field2290 = var5;
      } else if(var0 == 1408) {
         var3.field2295 = var6;
      } else if(var0 == 1409) {
         var3.field2288 = var6;
      } else if(var0 == 1410) {
         var3.field2314 = var6;
      } else if(var0 == 1411) {
         var3.field2279 = var6;
      } else if(var0 == 1412) {
         var3.field2267 = var6;
      } else if(var0 == 1414) {
         var3.field2291 = var6;
         var3.field2292 = var5;
      } else if(var0 == 1415) {
         var3.field2293 = var6;
         var3.field2294 = var5;
      } else if(var0 == 1416) {
         var3.field2253 = var6;
      } else if(var0 == 1417) {
         var3.field2258 = var6;
      } else if(var0 == 1418) {
         var3.field2296 = var6;
      } else if(var0 == 1419) {
         var3.field2299 = var6;
      } else if(var0 == 1420) {
         var3.field2265 = var6;
      } else if(var0 == 1421) {
         var3.field2301 = var6;
      } else if(var0 == 1422) {
         var3.field2302 = var6;
      } else if(var0 == 1423) {
         var3.field2197 = var6;
      } else if(var0 == 1424) {
         var3.field2304 = var6;
      } else if(var0 == 1425) {
         var3.field2306 = var6;
      } else if(var0 == 1426) {
         var3.field2307 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2305 = var6;
      }

      var3.field2276 = true;
      return 1;
   }

   class176() throws Throwable {
      throw new Error();
   }
}
