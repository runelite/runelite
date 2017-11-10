import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class218 {
   @ObfuscatedName("m")
   static int[] field2689;
   @ObfuscatedName("p")
   @Export("settings")
   @Hook("varbitChanged")
   public static int[] settings;
   @ObfuscatedName("i")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("b")
   static int[][] field2686;

   static {
      field2689 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2689[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1127975138"
   )
   static final void method4088() {
      short var0 = 256;
      int var1;
      if(class91.field1331 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1331 > 768) {
               Overlay.field3653[var1] = class115.method2211(ClanMember.field867[var1], ChatLineBuffer.field1458[var1], 1024 - class91.field1331);
            } else if(class91.field1331 > 256) {
               Overlay.field3653[var1] = ChatLineBuffer.field1458[var1];
            } else {
               Overlay.field3653[var1] = class115.method2211(ChatLineBuffer.field1458[var1], ClanMember.field867[var1], 256 - class91.field1331);
            }
         }
      } else if(class91.field1343 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1343 > 768) {
               Overlay.field3653[var1] = class115.method2211(ClanMember.field867[var1], MessageNode.field821[var1], 1024 - class91.field1343);
            } else if(class91.field1343 > 256) {
               Overlay.field3653[var1] = MessageNode.field821[var1];
            } else {
               Overlay.field3653[var1] = class115.method2211(MessageNode.field821[var1], ClanMember.field867[var1], 256 - class91.field1343);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            Overlay.field3653[var1] = ClanMember.field867[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class91.field1332, 9, class91.field1332 + 128, var0 + 7);
      class91.field1336.method5276(class91.field1332, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class66.field779.width * 9 + class91.field1332;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1369[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = CombatInfoListHolder.field1288[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Overlay.field3653[var7];
               var10 = class66.field779.pixels[var2];
               class66.field779.pixels[var2++] = (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class66.field779.width - 128;
      }

      Rasterizer2D.setDrawRegion(class91.field1332 + 765 - 128, 9, class91.field1332 + 765, var0 + 7);
      class91.field1368.method5276(class91.field1332 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class66.field779.width * 9 + class91.field1332 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1369[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = CombatInfoListHolder.field1288[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Overlay.field3653[var7];
               var10 = class66.field779.pixels[var2];
               class66.field779.pixels[var2++] = (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class66.field779.width - var5 - var4;
      }

   }
}
