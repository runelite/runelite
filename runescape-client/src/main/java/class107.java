import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class107 {
   @ObfuscatedName("x")
   static File field1715;
   @ObfuscatedName("u")
   static boolean field1717 = false;
   @ObfuscatedName("i")
   static Hashtable field1718 = new Hashtable(16);
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 999971689
   )
   static int field1719;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1150856305
   )
   static int field1721;
   @ObfuscatedName("q")
   public static class60 field1725;

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "1486473399"
   )
   static final void method1996(String var0, int var1) {
      Client.field326.method3029(184);
      Client.field326.method2760(class148.method2740(var0) + 1);
      Client.field326.method2760(var1);
      Client.field326.method2811(var0);
   }

   @ObfuscatedName("x")
   public static String method2000(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var6 = new StringBuilder(var2);

            while(0L != var0) {
               long var4 = var0;
               var0 /= 37L;
               var6.append(class205.field3069[(int)(var4 - 37L * var0)]);
            }

            return var6.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "572918143"
   )
   public static void method2001(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1900 = 1;
      class138.field1903 = var0;
      class47.field920 = var1;
      class0.field2 = var2;
      FrameMap.field1466 = var3;
      ChatMessages.field916 = var4;
      class138.field1904 = 10000;
   }
}
