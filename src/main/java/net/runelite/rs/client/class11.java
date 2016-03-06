package net.runelite.rs.client;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("b")
public class class11 {
   @ObfuscatedName("l")
   static final class197 field172 = new class197(1024);
   @ObfuscatedName("a")
   static final class199 field173 = new class199();
   @ObfuscatedName("j")
   static final Map field174 = new HashMap();
   @ObfuscatedName("i")
   static int field176 = 0;
   @ObfuscatedName("y")
   static class118 field179;
   @ObfuscatedName("ig")
   static class30 field180;
   @ObfuscatedName("r")
   public static boolean field182;

   @ObfuscatedName("j")
   public static void method135(String[] var0, short[] var1) {
      class122.method2721(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("j")
   static final void method145(class121 var0) {
      var0.method2688();
      int var1 = client.field477;
      class2 var2 = class148.field2249 = client.field410[var1] = new class2();
      var2.field56 = var1;
      int var3 = var0.method2689(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field864[0] = var5 - class98.field1683;
      var2.field839 = (var2.field864[0] << 7) + (var2.method31() << 6);
      var2.field817[0] = var6 - class92.field1598;
      var2.field848 = (var2.field817[0] << 7) + (var2.method31() << 6);
      class75.field1386 = var2.field55 = var4;
      if(null != class32.field745[var1]) {
         var2.method11(class32.field745[var1]);
      }

      class32.field749 = 0;
      class32.field755[++class32.field749 - 1] = var1;
      class32.field746[var1] = 0;
      class32.field750 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2689(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field752[var7] = (var10 << 14) + (var9 << 28) + var11;
            class32.field754[var7] = 0;
            class32.field753[var7] = -1;
            class32.field751[++class32.field750 - 1] = var7;
            class32.field746[var7] = 0;
         }
      }

      var0.method2690();
   }

   @ObfuscatedName("j")
   public static void method147() {
      if(class135.field2091.toLowerCase().indexOf("microsoft") != -1) {
         class136.field2133[186] = 57;
         class136.field2133[187] = 27;
         class136.field2133[188] = 71;
         class136.field2133[189] = 26;
         class136.field2133[190] = 72;
         class136.field2133[191] = 73;
         class136.field2133[192] = 58;
         class136.field2133[219] = 42;
         class136.field2133[220] = 74;
         class136.field2133[221] = 43;
         class136.field2133[222] = 59;
         class136.field2133[223] = 28;
      } else {
         class136.field2133[44] = 71;
         class136.field2133[45] = 26;
         class136.field2133[46] = 72;
         class136.field2133[47] = 73;
         class136.field2133[59] = 57;
         class136.field2133[61] = 27;
         class136.field2133[91] = 42;
         class136.field2133[92] = 74;
         class136.field2133[93] = 43;
         class136.field2133[192] = 28;
         class136.field2133[222] = 58;
         class136.field2133[520] = 59;
      }

   }

   @ObfuscatedName("k")
   public static boolean method148(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3214(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class51.method1036(var3);
         return true;
      }
   }
}
