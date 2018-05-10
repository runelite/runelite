import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class148 implements class147 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1724878657
   )
   static int field1936;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljf;",
      garbageValue = "-1080549342"
   )
   @Export("getOverlayDefinition")
   public static Overlay getOverlayDefinition(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-1986129501"
   )
   public static byte[] method3203(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1019027474"
   )
   public static boolean method3206(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Laa;I)V",
      garbageValue = "-24501572"
   )
   static void method3205(GameEngine var0) {
      if(MouseInput.mouseLastButton == 1 || !class8.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
         int var1 = class78.field1104 + 280;
         if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(0, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(0, 1);
            return;
         }

         int var2 = class78.field1104 + 390;
         if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(1, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(1, 1);
            return;
         }

         int var3 = class78.field1104 + 500;
         if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(2, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(2, 1);
            return;
         }

         int var4 = class78.field1104 + 610;
         if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(3, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            MapLabel.method307(3, 1);
            return;
         }

         if(MouseInput.mouseLastPressedX >= class78.field1104 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class78.field1104 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
            class78.worldSelectShown = false;
            class78.field1107.method5893(class78.field1104, 0);
            class24.field224.method5893(class78.field1104 + 382, 0);
            class78.logoSprite.method5873(class78.field1104 + 382 - class78.logoSprite.width / 2, 18);
            return;
         }

         if(class78.field1137 != -1) {
            World var5 = class143.worldList[class78.field1137];
            Friend.changeWorld(var5);
            class78.worldSelectShown = false;
            class78.field1107.method5893(class78.field1104, 0);
            class24.field224.method5893(class78.field1104 + 382, 0);
            class78.logoSprite.method5873(class78.field1104 + 382 - class78.logoSprite.width / 2, 18);
            return;
         }
      }

   }
}
