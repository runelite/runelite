import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class176 {
   @ObfuscatedName("t")
   @Export("widgetSettings")
   public static int[] field2916;
   @ObfuscatedName("x")
   @Export("settings")
   public static int[] field2917;
   @ObfuscatedName("w")
   public static int[] field2918 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2918[var1] = var0 - 1;
         var0 += var0;
      }

      field2917 = new int[2000];
      field2916 = new int[2000];
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-434462163"
   )
   static final void method3480(class173 var0) {
      int var1 = var0.field2890;
      if(324 == var1) {
         if(-1 == client.field320) {
            client.field320 = var0.field2806;
            client.field426 = var0.field2887;
         }

         if(client.field309.field2927) {
            var0.field2806 = client.field320;
         } else {
            var0.field2806 = client.field426;
         }

      } else if(var1 == 325) {
         if(client.field320 == -1) {
            client.field320 = var0.field2806;
            client.field426 = var0.field2887;
         }

         if(client.field309.field2927) {
            var0.field2806 = client.field426;
         } else {
            var0.field2806 = client.field320;
         }

      } else if(var1 == 327) {
         var0.field2763 = 150;
         var0.field2819 = (int)(Math.sin((double)client.field305 / 40.0D) * 256.0D) & 2047;
         var0.field2810 = 5;
         var0.field2811 = 0;
      } else if(var1 == 328) {
         var0.field2763 = 150;
         var0.field2819 = (int)(Math.sin((double)client.field305 / 40.0D) * 256.0D) & 2047;
         var0.field2810 = 5;
         var0.field2811 = 1;
      }
   }
}
