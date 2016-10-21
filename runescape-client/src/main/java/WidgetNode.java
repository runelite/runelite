import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 143055417
   )
   int field58;
   @ObfuscatedName("nt")
   static class58 field59;
   @ObfuscatedName("n")
   boolean field61 = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2109454873
   )
   @Export("id")
   int id;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)Z",
      garbageValue = "90"
   )
   static boolean method45(class125 var0, int var1) {
      int var2 = var0.method2771(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2771(1) != 0) {
            method45(var0, var1);
         }

         var3 = var0.method2771(6);
         var4 = var0.method2771(6);
         boolean var12 = var0.method2771(1) == 1;
         if(var12) {
            class34.field775[++class34.field771 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field57 = var1;
            if(null != class34.field761[var1]) {
               var6.method18(class34.field761[var1]);
            }

            var6.field873 = class34.field767[var1];
            var6.interacting = class34.field768[var1];
            var7 = class34.field769[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field857[0] = class34.field760[var1];
            var6.field41 = (byte)var8;
            var6.method22((var9 << 6) + var3 - class32.baseX, var4 + (var10 << 6) - class8.baseY);
            var6.field54 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2771(2);
         var4 = class34.field769[var1];
         class34.field769[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2771(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class34.field769[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field769[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method2771(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class34.field769[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var11 + var7 & 255;
            class34.field769[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   static final void method46() {
      int var0 = class34.field763;
      int[] var1 = class34.field758;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            class129.method2835(var3, 1);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-984468999"
   )
   public static ModIcon method47(class170 var0, String var1, String var2) {
      int var3 = var0.method3299(var1);
      int var4 = var0.method3361(var3, var2);
      return Frames.method2315(var0, var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   public static void method48() {
      class214.field3177 = new class205();
   }
}
