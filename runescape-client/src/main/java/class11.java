import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class11 {
   @ObfuscatedName("j")
   static final class200 field164 = new class200();
   @ObfuscatedName("a")
   static int[] field165;
   @ObfuscatedName("b")
   @Export("chatLineMap")
   static final Map field166 = new HashMap();
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -734414221
   )
   static int field167;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1910237133
   )
   static int field168 = 0;
   @ObfuscatedName("g")
   static final class198 field169 = new class198(1024);

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-1195224577"
   )
   static final void method146(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field360 + client.field322 & 2047;
         int var8 = class91.field1563[var7];
         int var9 = class91.field1564[var7];
         var8 = 256 * var8 / (client.field558 + 256);
         var9 = var9 * 256 / (256 + client.field558);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class165.field2656.method1707(4 + var14 + 94 + var0 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class126.method2848(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "0"
   )
   static boolean method147(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class39.method796(var0, client.field289);

         for(int var3 = 0; var3 < client.field340; ++var3) {
            if(var2.equalsIgnoreCase(class39.method796(client.field556[var3].field243, client.field289))) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class39.method796(class153.field2262.field26, client.field289))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "19"
   )
   static final void method148(int var0, int var1) {
      int var2 = class162.field2636.method4028("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field429; ++var3) {
         class224 var7 = class162.field2636;
         String var5;
         if(client.field396[var3].length() > 0) {
            var5 = client.field434[var3] + " " + client.field396[var3];
         } else {
            var5 = client.field434[var3];
         }

         int var6 = var7.method4028(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + client.field429 * 15;
      int var4 = var0 - var2 / 2;
      if(var4 + var2 > class45.field1026) {
         var4 = class45.field1026 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var8 = var1;
      if(var1 + var3 > class143.field2169) {
         var8 = class143.field2169 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      client.field428 = true;
      class16.field234 = var4;
      class12.field194 = var8;
      class156.field2288 = var2;
      class20.field573 = client.field429 * 15 + 22;
   }
}
