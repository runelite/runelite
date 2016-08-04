import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class1 {
   @ObfuscatedName("qc")
   static Font field18;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass111;I)V",
      garbageValue = "1137072140"
   )
   static final void method5(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class111[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].field1969[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      class122 var21 = new class122(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var15 = var2 + class48.method1034(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  class96.method2252(var21, var1, var15, var17 + var3, 0, 0, var7);
               } else {
                  class96.method2252(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1916039858"
   )
   static final void method13(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field427.method3980(); null != var10; var10 = (class16)client.field427.method3970()) {
         if(var10.field239 == var0 && var10.field238 == var1 && var10.field231 == var2 && var10.field229 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field239 = var0;
         var9.field229 = var3;
         var9.field238 = var1;
         var9.field231 = var2;
         class19.method253(var9);
         client.field427.method3963(var9);
      }

      var9.field235 = var4;
      var9.field230 = var5;
      var9.field236 = var6;
      var9.field241 = var7;
      var9.field237 = var8;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass55;",
      garbageValue = "-520865922"
   )
   @Export("getItemDefinition")
   public static class55 method14(int var0) {
      class55 var1 = (class55)class55.field1186.method3905((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class55.field1187.method3411(10, var0);
         var1 = new class55();
         var1.field1184 = var0;
         if(var2 != null) {
            var1.method1225(new class122(var2));
         }

         var1.method1172();
         if(var1.field1178 != -1) {
            var1.method1174(method14(var1.field1178), method14(var1.field1216));
         }

         if(var1.field1226 != -1) {
            var1.method1175(method14(var1.field1226), method14(var1.field1225));
         }

         if(var1.field1213 != -1) {
            var1.method1176(method14(var1.field1213), method14(var1.field1227));
         }

         if(!class55.field1198 && var1.field1199) {
            var1.field1183 = "Members object";
            var1.field1224 = false;
            var1.field1200 = null;
            var1.field1181 = null;
            var1.field1189 = 0;
         }

         class55.field1186.method3907(var1, (long)var0);
         return var1;
      }
   }
}
