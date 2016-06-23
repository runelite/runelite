import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class14 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1107455317
   )
   int field207 = -1;
   @ObfuscatedName("x")
   int[] field208;
   @ObfuscatedName("b")
   String[] field209;
   @ObfuscatedName("em")
   static class80[] field211;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1207919055
   )
   @Export("plane")
   static int field212;
   @ObfuscatedName("f")
   class22 field213;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1025151319
   )
   static int field220;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Lclass82;",
      garbageValue = "-450314120"
   )
   public static class82[] method175() {
      return new class82[]{class82.field1439, class82.field1435, class82.field1438, class82.field1443, class82.field1441};
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass30;III)V",
      garbageValue = "1955548543"
   )
   static final void method176(class30 var0, int var1, int var2) {
      class34.method761(var0.field712, var0.field704, var0.field705, var0.field703, var0.field707, var0.field707, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lclass112;II)Lclass112;",
      garbageValue = "1439573328"
   )
   public static class112 method177(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3194()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "804302351"
   )
   static final void method178() {
      int var0 = class37.field881;
      int var1 = class19.field284;
      int var2 = class39.field931;
      int var3 = class33.field774;
      int var4 = 6116423;
      class79.method1854(var0, var1, var2, var3, var4);
      class79.method1854(1 + var0, 1 + var1, var2 - 2, 16, 0);
      class79.method1860(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class32.field758.method4066("Choose Option", var0 + 3, 14 + var1, var4, -1);
      int var5 = class140.field2146;
      int var6 = class140.field2151;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < client.field429; ++var7) {
         var8 = 15 * (client.field429 - 1 - var7) + 31 + var1;
         var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class224 var10 = class32.field758;
         String var12;
         if(client.field435[var7].length() > 0) {
            var12 = client.field459[var7] + " " + client.field435[var7];
         } else {
            var12 = client.field459[var7];
         }

         var10.method4066(var12, var0 + 3, var8, var9, 0);
      }

      var7 = class37.field881;
      var8 = class19.field284;
      var9 = class39.field931;
      int var13 = class33.field774;

      for(int var11 = 0; var11 < client.field490; ++var11) {
         if(client.field497[var11] + client.field495[var11] > var7 && client.field495[var11] < var9 + var7 && client.field498[var11] + client.field496[var11] > var8 && client.field496[var11] < var13 + var8) {
            client.field493[var11] = true;
         }
      }

   }
}
