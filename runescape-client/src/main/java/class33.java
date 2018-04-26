import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public final class class33 {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      longValue = -191987490526068109L
   )
   static long field455;
   @ObfuscatedName("aj")
   static int[] field459;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 234736069
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("e")
   final int[] field458;

   class33() {
      this.field458 = new int[4096];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "825478831"
   )
   final void method371(class44 var1) {
      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field458[var2 * 64 + var3] = var1.method664(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1399500455"
   )
   final int method367(int var1, int var2) {
      return this.field458[var2 + var1 * 64];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-137050603"
   )
   static void method366(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class171.worldList[var6];
         class171.worldList[var6] = class171.worldList[var1];
         class171.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class322.method5750(class171.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = class171.worldList[var9];
               class171.worldList[var9] = class171.worldList[var7];
               class171.worldList[var7++] = var10;
            }
         }

         class171.worldList[var1] = class171.worldList[var7];
         class171.worldList[var7] = var8;
         method366(var0, var7 - 1, var2, var3, var4, var5);
         method366(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "([Liz;Liz;ZB)V",
      garbageValue = "103"
   )
   static void method372(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class45.method680(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class45.method680(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         PendingSpawn.method1698(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
