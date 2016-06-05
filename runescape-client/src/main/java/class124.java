import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class124 {
   @ObfuscatedName("q")
   public static String field2040;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-128944158"
   )
   public static synchronized long method2746() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1979) {
         class115.field1978 += class115.field1979 - var0;
      }

      class115.field1979 = var0;
      return class115.field1978 + var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "4"
   )
   static final int method2748(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class8.method97(var3, var5);
      int var8 = class8.method97(1 + var3, var5);
      int var9 = class8.method97(var3, 1 + var5);
      int var10 = class8.method97(var3 + 1, 1 + var5);
      int var11 = class25.method615(var7, var8, var4, var2);
      int var12 = class25.method615(var9, var10, var4, var2);
      return class25.method615(var11, var12, var6, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZI)V",
      garbageValue = "2"
   )
   static void method2749(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class172 var8 = (class172)class171.field2753.method3748(var6);
      if(var8 == null) {
         var8 = (class172)class171.field2745.method3748(var6);
         if(null == var8) {
            var8 = (class172)class171.field2748.method3748(var6);
            if(null != var8) {
               if(var5) {
                  var8.method3844();
                  class171.field2753.method3749(var8, var6);
                  --class171.field2749;
                  ++class171.field2750;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2754.method3748(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2762 = var0;
               var8.field2764 = var3;
               var8.field2763 = var4;
               if(var5) {
                  class171.field2753.method3749(var8, var6);
                  ++class171.field2750;
               } else {
                  class171.field2747.method3837(var8);
                  class171.field2748.method3749(var8, var6);
                  ++class171.field2749;
               }

            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "774960583"
   )
   public static void method2751(class167 var0, class167 var1) {
      class177.field2928 = var0;
      class43.field1018 = var1;
   }
}
