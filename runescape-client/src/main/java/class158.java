import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public abstract class class158 {
   @ObfuscatedName("gc")
   static SpritePixels field2277;

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "21"
   )
   static final void method2866(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class59.method961(var0)) {
         class64.field790 = null;
         class29.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class64.field790 != null) {
            class29.gameDraw(class64.field790, -1412584499, var1, var2, var3, var4, class15.field303, class71.field847, var7);
            class64.field790 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1111[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1111[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-121"
   )
   public static String method2867(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1409293417"
   )
   public abstract int vmethod2868(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-1190529545"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3585.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3584.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4534(new Buffer(var2));
         }

         var1.method4511();
         NPCComposition.field3585.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1057188703"
   )
   public abstract void vmethod2872();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1145609465"
   )
   public static int method2874(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "685131402"
   )
   static final void method2877(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = WallObject.font_p12full.method4629(var0, 250);
      int var6 = WallObject.font_p12full.method4630(var0, 250) * 13;
      Rasterizer2D.method4826(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.method4888(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 16777215);
      WallObject.font_p12full.method4636(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      ChatLineBuffer.method1777(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);
      if(var1) {
         World.field1296.vmethod4897(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field1109; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var7 && Client.widgetPositionX[var11] < var7 + var9 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field1112[var11] = true;
            }
         }
      }

   }
}
