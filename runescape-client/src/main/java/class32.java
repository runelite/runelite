import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class32 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1083530513
   )
   int field713;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 357091021
   )
   int field714;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -280650009
   )
   int field715;
   @ObfuscatedName("i")
   String field716;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -392759549
   )
   int field717;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;IIB)Lclass59;",
      garbageValue = "-68"
   )
   public static final class59 method668(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1228 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1225 = new int[(class59.field1229?2:1) * 256];
            var4.field1230 = var3;
            var4.vmethod1532(var1);
            var4.field1226 = (var3 & -1024) + 1024;
            if(var4.field1226 > 16384) {
               var4.field1226 = 16384;
            }

            var4.vmethod1533(var4.field1226);
            if(class59.field1224 > 0 && class180.field2963 == null) {
               class180.field2963 = new class75();
               class180.field2963.field1396 = var0;
               var0.method2927(class180.field2963, class59.field1224);
            }

            if(class180.field2963 != null) {
               if(null != class180.field2963.field1392[var2]) {
                  throw new IllegalArgumentException();
               }

               class180.field2963.field1392[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
      garbageValue = "8"
   )
   public static String method669(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return null == var3?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var9 = var1; var9 < var8; ++var9) {
            CharSequence var6 = var0[var9];
            if(null == var6) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(null == var7) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }
}
