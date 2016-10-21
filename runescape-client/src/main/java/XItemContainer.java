import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("n")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("e")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("d")
   static String field219;
   @ObfuscatedName("f")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("m")
   static int[] field221;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -624243485
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("ba")
   static class171 field223;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1159513985
   )
   static int field224;
   @ObfuscatedName("cc")
   static class227 field225;
   @ObfuscatedName("bo")
   static class171 field226;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "9"
   )
   public static void method174(boolean var0) {
      if(class174.field2755 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2518(var0?2:3);
            var1.method2520(0);
            class174.field2755.method3009(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2755.method3010();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2766;
            class174.field2755 = null;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1533706523"
   )
   public static void method180() {
      Sequence.field990.reset();
      Sequence.field991.reset();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1011203830"
   )
   static final void method181(Widget var0, int var1, int var2) {
      if(Client.field369 == 0 || Client.field369 == 3) {
         if(class143.field2198 == 1 || !ChatMessages.field276 && class143.field2198 == 4) {
            class178 var3 = var0.method3474(true);
            if(null == var3) {
               return;
            }

            int var4 = class143.field2197 - var1;
            int var5 = class143.field2207 - var2;
            if(var3.method3498(var4, var5)) {
               var4 -= var3.field2930 / 2;
               var5 -= var3.field2931 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class94.field1635[var6];
               int var8 = class94.field1646[var6];
               var7 = (256 + Client.mapScaleDelta) * var7 >> 8;
               var8 = var8 * (256 + Client.mapScaleDelta) >> 8;
               int var9 = var5 * var7 + var8 * var4 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = class34.localPlayer.x + var9 >> 7;
               int var12 = class34.localPlayer.y - var10 >> 7;
               Client.field397.method2768(50);
               Client.field397.method2518(18);
               Client.field397.method2559(class140.field2153[82]?(class140.field2153[81]?2:1):0);
               Client.field397.method2567(class32.baseX + var11);
               Client.field397.method2516(var12 + class8.baseY);
               Client.field397.method2518(var4);
               Client.field397.method2518(var5);
               Client.field397.method2519(Client.mapAngle);
               Client.field397.method2518(57);
               Client.field397.method2518(Client.mapScale);
               Client.field397.method2518(Client.mapScaleDelta);
               Client.field397.method2518(89);
               Client.field397.method2519(class34.localPlayer.x);
               Client.field397.method2519(class34.localPlayer.y);
               Client.field397.method2518(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1376426915"
   )
   public static int method183(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-37"
   )
   static final int method184(int var0, int var1, int var2) {
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

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }
}
