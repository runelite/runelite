import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("af")
public class class47 extends class203 {
   @ObfuscatedName("r")
   static class192 field1062 = new class192(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -298597243
   )
   public int field1063;
   @ObfuscatedName("a")
   static class166 field1064;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 547662923
   )
   public int field1065;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1174161195
   )
   public int field1066;

   @ObfuscatedName("s")
   void method992(class118 var1, int var2) {
      if(1 == var2) {
         this.field1063 = var1.method2514();
         this.field1065 = var1.method2579();
         this.field1066 = var1.method2579();
      }

   }

   @ObfuscatedName("f")
   void method995(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method992(var1, var2);
      }
   }

   @ObfuscatedName("do")
   static final void method1000(int var0, int var1, int var2, int var3, class78 var4, class174 var5) {
      if(var4 != null) {
         int var6 = client.field495 + client.field546 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class90.field1572[var6];
            int var9 = class90.field1578[var6];
            var8 = var8 * 256 / (256 + client.field365);
            var9 = 256 * var9 / (256 + client.field365);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1750(var10 + var5.field2884 / 2 - var4.field1402 / 2, var5.field2883 / 2 - var11 - var4.field1403 / 2, var0, var1, var5.field2884, var5.field2883, var5.field2886, var5.field2885);
            } else {
               var4.method1805(var10 + var0 + var5.field2884 / 2 - var4.field1402 / 2, var1 + var5.field2883 / 2 - var11 - var4.field1403 / 2);
            }

         }
      }
   }

   @ObfuscatedName("a")
   public static class46 method1007(int var0) {
      class46 var1 = (class46)class46.field1058.method3792((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class46.field1059.method3263(4, var0);
         var1 = new class46();
         if(var2 != null) {
            var1.method967(new class118(var2));
         }

         var1.method979();
         class46.field1058.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1392593907"
   )
   static void method1008(int var0, String var1) {
      int var2 = class32.field774;
      int[] var3 = class32.field759;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field415[var3[var5]];
         if(null != var6 && class151.field2253 != var6 && null != var6.field40 && var6.field40.equalsIgnoreCase(var1)) {
            if(1 == var0) {
               client.field301.method2753(165);
               client.field301.method2498(var3[var5]);
               client.field301.method2536(0);
            } else if(4 == var0) {
               client.field301.method2753(248);
               client.field301.method2648(0);
               client.field301.method2545(var3[var5]);
            } else if(6 == var0) {
               client.field301.method2753(234);
               client.field301.method2666(var3[var5]);
               client.field301.method2535(0);
            } else if(7 == var0) {
               client.field301.method2753(40);
               client.field301.method2666(var3[var5]);
               client.field301.method2497(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class137.method2943(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("y")
   public static String method1009(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(0 != var6) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class164.field2650[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("am")
   static void method1010() {
      int var0 = class6.field107;
      int var1 = class31.field749;
      if(class218.field3161 < var0) {
         var0 = class218.field3161;
      }

      if(class42.field1005 < var1) {
         var1 = class42.field1005;
      }

      if(null != class89.field1548) {
         try {
            client var2 = client.field540;
            int var3 = client.field508?2:1;
            Object[] var4 = new Object[]{Integer.valueOf(var3)};
            JSObject.getWindow(var2).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }
}
