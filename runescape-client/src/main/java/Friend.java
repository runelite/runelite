import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -962935221
   )
   @Export("world")
   int world;
   @ObfuscatedName("d")
   boolean field146;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1808119225
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("k")
   boolean field148;
   @ObfuscatedName("mb")
   static byte field149;
   @ObfuscatedName("r")
   public static class72[] field151;
   @ObfuscatedName("cc")
   static class110 field152;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   public static void method178() {
      CombatInfo2.field2838.reset();
      CombatInfo2.field2827.reset();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-1741649751"
   )
   public static final class57 method179(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1047 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1045 = new int[(class57.field1042?2:1) * 256];
            var4.field1040 = var3;
            var4.vmethod1086(var1);
            var4.field1049 = (var3 & -1024) + 1024;
            if(var4.field1049 > 16384) {
               var4.field1049 = 16384;
            }

            var4.vmethod1088(var4.field1049);
            if(class211.field3122 > 0 && null == class57.field1056) {
               class57.field1056 = new class63();
               class57.field1056.field1093 = var0;
               var0.method1968(class57.field1056, class211.field3122);
            }

            if(class57.field1056 != null) {
               if(class57.field1056.field1092[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class57.field1056.field1092[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-46"
   )
   static final int method180(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "2073151908"
   )
   static final byte[] method181(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2819();
      if(var3 >= 0 && (class182.field2701 == 0 || var3 <= class182.field2701)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2824(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2819();
            if(var4 < 0 || class182.field2701 != 0 && var4 > class182.field2701) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class147.method2756(var5, var4, var0, var3, 9);
               } else {
                  class182.field2711.method2749(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IIB)LFont;",
      garbageValue = "3"
   )
   public static Font method182(class182 var0, class182 var1, int var2, int var3) {
      if(!class196.method3575(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(null == var5) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class225.field3216, class225.field3215, class22.field231, class225.field3218, class183.field2719, class48.field949);
            class225.field3216 = null;
            class225.field3215 = null;
            class22.field231 = null;
            class225.field3218 = null;
            class183.field2719 = null;
            class48.field949 = null;
            var4 = var6;
         }

         return var4;
      }
   }
}
