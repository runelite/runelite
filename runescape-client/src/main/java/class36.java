import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class36 {
   @ObfuscatedName("j")
   static final class36 field488;
   @ObfuscatedName("a")
   static final class36 field489;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 518549289
   )
   final int field490;

   static {
      field489 = new class36(0);
      field488 = new class36(1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class36(int var1) {
      this.field490 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1420387406"
   )
   @Export("decodeSprite")
   public static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3794 = var1.readUnsignedShort();
      class286.field3795 = new int[class286.field3794];
      class31.offsetsY = new int[class286.field3794];
      class286.field3797 = new int[class286.field3794];
      class90.field1405 = new int[class286.field3794];
      class177.spritePixels = new byte[class286.field3794][];
      var1.offset = var0.length - 7 - class286.field3794 * 8;
      class286.field3793 = var1.readUnsignedShort();
      class286.field3792 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3794; ++var3) {
         class286.field3795[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3794; ++var3) {
         class31.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3794; ++var3) {
         class286.field3797[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3794; ++var3) {
         class90.field1405[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3794 * 8 - (var2 - 1) * 3;
      class286.field3796 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class286.field3796[var3] = var1.read24BitInt();
         if(class286.field3796[var3] == 0) {
            class286.field3796[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3794; ++var3) {
         int var4 = class286.field3797[var3];
         int var5 = class90.field1405[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class177.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "657691016"
   )
   static void method487(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class17.method120(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class17.method120(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class33.loadWidget(var6)) {
            class17.method120(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "435319405"
   )
   static void method486() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(FaceNormal.method2866(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "-50"
   )
   public static void method485(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field667.startsWith("win")) {
            NPC.method1664(var0, 0, "openjs");
         } else if(class56.field667.startsWith("mac")) {
            NPC.method1664(var0, 1, "openjs");
         } else {
            NPC.method1664(var0, 2, "openjs");
         }
      } else {
         NPC.method1664(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2009731891"
   )
   static int method488(int var0, Script var1, boolean var2) {
      Widget var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class83.intStack;
         int var5 = ++WorldMapType2.intStackSize - 1;
         int var7 = class46.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class83.intStack[--WorldMapType2.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
