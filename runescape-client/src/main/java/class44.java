import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class44 extends WorldMapData {
   @ObfuscatedName("t")
   List field578;
   @ObfuscatedName("v")
   HashSet field577;
   @ObfuscatedName("h")
   HashSet field580;

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lfp;ZB)V",
      garbageValue = "-43"
   )
   void method605(Buffer var1, boolean var2) {
      this.field578 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3266();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field578.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;Lfp;IZI)V",
      garbageValue = "1723924712"
   )
   void method596(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field577 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method166(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field577.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field580 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method617(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field580.add(var9);
      }

      this.method605(var2, var5);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-938211540"
   )
   public static void method601() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field638 = KeyFocusListener.field646;
         KeyFocusListener.field627 = 0;
         int var1;
         if(KeyFocusListener.field639 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field636[var1] = false;
            }

            KeyFocusListener.field639 = KeyFocusListener.field644;
         } else {
            while(KeyFocusListener.field644 != KeyFocusListener.field639) {
               var1 = KeyFocusListener.field643[KeyFocusListener.field644];
               KeyFocusListener.field644 = KeyFocusListener.field644 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field636[~var1] = false;
               } else {
                  if(!KeyFocusListener.field636[var1] && KeyFocusListener.field627 < KeyFocusListener.field642.length - 1) {
                     KeyFocusListener.field642[++KeyFocusListener.field627 - 1] = var1;
                  }

                  KeyFocusListener.field636[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field627 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field646 = KeyFocusListener.field645;
      }
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1197168638"
   )
   static final void method599(int var0) {
      if(class9.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2739 = 0;
               var3.field2676 = 0;
            }
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1063642197"
   )
   static void method604() {
      class96.field1469 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class96.field1475[var0] = null;
         class96.field1467[var0] = 1;
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "697205755"
   )
   static void method595(int var0, int var1) {
      class89 var2 = class54.field669;
      class162.menuAction(var2.field1379, var2.field1377, var2.field1378, var2.field1380, var2.field1381, var2.field1381, var0, var1);
      class54.field669 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-527311285"
   )
   static final int method603(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
