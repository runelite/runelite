import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class85 implements class115 {
   @ObfuscatedName("e")
   public static final class85 field1493 = new class85(0, 0);
   @ObfuscatedName("c")
   public static final class85 field1495 = new class85(2, 2);
   @ObfuscatedName("l")
   public static final class85 field1496 = new class85(1, 1);
   @ObfuscatedName("r")
   public static final class85 field1497 = new class85(4, 4);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1997071289
   )
   public final int field1498;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -209637091
   )
   final int field1499;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1130103051
   )
   @Export("cameraX")
   static int field1500;
   @ObfuscatedName("h")
   public static final class85 field1504 = new class85(3, 3);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1498 = var1;
      this.field1499 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2010364784"
   )
   public int vmethod3262() {
      return this.field1499;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;S)[Lclass81;",
      garbageValue = "11053"
   )
   public static class81[] method1983(class170 var0, String var1, String var2) {
      int var3 = var0.method3342(var1);
      int var4 = var0.method3357(var3, var2);
      return class33.method720(var0, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZI)V",
      garbageValue = "629385719"
   )
   static void method1984(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class175 var8 = (class175)class174.field2759.method3864(var6);
      if(null == var8) {
         var8 = (class175)class174.field2768.method3864(var6);
         if(var8 == null) {
            var8 = (class175)class174.field2772.method3864(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3978();
                  class174.field2759.method3865(var8, var6);
                  --class174.field2765;
                  ++class174.field2761;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2766.method3864(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2777 = var0;
               var8.field2778 = var3;
               var8.field2779 = var4;
               if(var5) {
                  class174.field2759.method3865(var8, var6);
                  ++class174.field2761;
               } else {
                  class174.field2764.method3963(var8);
                  class174.field2772.method3865(var8, var6);
                  ++class174.field2765;
               }

            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "534401513"
   )
   public static void method1985(int var0) {
      if(class186.field2993 != 0) {
         class28.field695 = var0;
      } else {
         class186.field2996.method3683(var0);
      }

   }
}
