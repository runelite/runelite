import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class106 {
   @ObfuscatedName("g")
   static int[] field1869 = new int[4096];
   @ObfuscatedName("x")
   static int[][] field1871 = new int[128][128];
   @ObfuscatedName("b")
   static int[][] field1872 = new int[128][128];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -520046083
   )
   static int field1873;
   @ObfuscatedName("pa")
   static short[] field1874;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1359472743
   )
   static int field1875;
   @ObfuscatedName("m")
   static int[] field1876 = new int[4096];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "-490144910"
   )
   public static void method2420(class167 var0, class167 var1) {
      class39.field893 = var0;
      class39.field904 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass103;",
      garbageValue = "-235012791"
   )
   @Export("getFrames")
   static class103 method2421(int var0) {
      class103 var1 = (class103)class42.field1001.method3797((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class167 var3 = class42.field998;
         class167 var4 = class42.field1000;
         boolean var5 = true;
         int[] var6 = var3.method3342(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3295(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3295(var9, 0);
               if(null == var10) {
                  var5 = false;
               }
            }
         }

         class103 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class103(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         Object var10000 = null;
         return var2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-829458136"
   )
   static int method2423(int var0) {
      class35 var1 = (class35)class11.field182.method3840((long)var0);
      return var1 == null?-1:(var1.field3106 == class11.field179.field3101?-1:((class35)var1.field3106).field793);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lclass133;",
      garbageValue = "-633192291"
   )
   static class133 method2424() {
      try {
         return new class147();
      } catch (Throwable var1) {
         return new class141();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   static void method2425() {
      client.field460 = -1L;
      client.field306 = -1;
      client.field473.field200 = 0;
      class30.field709 = true;
      client.field307 = true;
      client.field513 = -1L;
      class7.method113();
      client.field333.field1998 = 0;
      client.field335.field1998 = 0;
      client.field325 = -1;
      client.field304 = 1;
      client.field483 = -1;
      client.field417 = -1;
      client.field338 = 0;
      client.field309 = 0;
      client.field343 = 0;
      client.field457 = 0;
      client.field429 = 0;
      client.field310 = false;
      class140.field2145 = 0;
      class1.method10();
      client.field353 = 0;
      client.field442 = false;
      client.field554 = 0;
      client.field382 = (int)(Math.random() * 100.0D) - 50;
      client.field356 = (int)(Math.random() * 110.0D) - 55;
      client.field358 = (int)(Math.random() * 80.0D) - 40;
      client.field500 = (int)(Math.random() * 120.0D) - 60;
      client.field363 = (int)(Math.random() * 30.0D) - 20;
      client.field374 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field523 = 0;
      client.field422 = -1;
      client.field482 = 0;
      client.field522 = 0;
      client.field318 = class20.field575;
      client.field319 = class20.field575;
      client.field494 = 0;
      class32.field753 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class32.field756[var0] = null;
         class32.field767[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         client.field302[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field328[var0] = null;
      }

      client.field464 = -1;
      client.field549.method3849();
      client.field423.method3849();

      int var1;
      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               client.field572[var0][var1][var2] = null;
            }
         }
      }

      client.field421 = new class199();
      client.field397 = 0;
      client.field555 = 0;
      client.field559 = 0;

      for(var0 = 0; var0 < class129.field2054; ++var0) {
         class52 var4 = class158.method3191(var0);
         if(null != var4) {
            class176.field2903[var0] = 0;
            class176.field2905[var0] = 0;
         }
      }

      class3.field65.method210();
      client.field332 = -1;
      if(client.field391 != -1) {
         var0 = client.field391;
         if(var0 != -1 && class173.field2744[var0]) {
            class173.field2802.method3297(var0);
            if(class173.field2770[var0] != null) {
               boolean var5 = true;

               for(var2 = 0; var2 < class173.field2770[var0].length; ++var2) {
                  if(class173.field2770[var0][var2] != null) {
                     if(class173.field2770[var0][var2].field2798 != 2) {
                        class173.field2770[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  class173.field2770[var0] = null;
               }

               class173.field2744[var0] = false;
            }
         }
      }

      for(class3 var3 = (class3)client.field448.method3825(); null != var3; var3 = (class3)client.field448.method3823()) {
         class23.method628(var3, true);
      }

      client.field391 = -1;
      client.field448 = new class196(8);
      client.field312 = null;
      client.field310 = false;
      client.field429 = 0;
      client.field561.method3508((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field416[var0] = null;
         client.field376[var0] = false;
      }

      class3.method47();
      client.field300 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field516[var0] = true;
      }

      client.field333.method2773(81);
      class122 var6 = client.field333;
      var1 = client.field501?2:1;
      var6.method2654(var1);
      client.field333.method2540(class30.field708);
      client.field333.method2540(class153.field2274);
      client.field514 = null;
      class96.field1636 = 0;
      class35.field792 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field564[var0] = new class220();
      }

      class136.field2098 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "129563307"
   )
   static char method2426(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }
}
