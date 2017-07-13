import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class90 {
   @ObfuscatedName("a")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("j")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("l")
   public static int[] field1405;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("825649aa824de60c70aa32c2f141f480b739f93dff2fffea0664442f7199c7cccbabef97b9940429d8116315a9abf23279c01f0da47379b3eee833e70666f19988401174eeda0d80722c68dd0036e1f5a2455c5409efaa92ad0ef4975fdf7cce843cf5bde49fed8265728ab71ed4ddbac26d094d026a76243b678f968352944d", 16);
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "631404057"
   )
   static boolean method1690(Widget var0) {
      if(Client.field1076) {
         if(class46.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1183583722"
   )
   public static void method1691() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field635 = KeyFocusListener.field637;
         KeyFocusListener.field634 = 0;
         int var1;
         if(KeyFocusListener.field625 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field626[var1] = false;
            }

            KeyFocusListener.field625 = KeyFocusListener.field629;
         } else {
            while(KeyFocusListener.field629 != KeyFocusListener.field625) {
               var1 = KeyFocusListener.field639[KeyFocusListener.field629];
               KeyFocusListener.field629 = KeyFocusListener.field629 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field626[~var1] = false;
               } else {
                  if(!KeyFocusListener.field626[var1] && KeyFocusListener.field634 < KeyFocusListener.field633.length - 1) {
                     KeyFocusListener.field633[++KeyFocusListener.field634 - 1] = var1;
                  }

                  KeyFocusListener.field626[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field634 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field637 = KeyFocusListener.field620;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;B)V",
      garbageValue = "66"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = Script.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field870 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class163.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class10.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class45.plane = var2.field889 = var4;
      if(class96.field1490[var1] != null) {
         var2.decodeApperance(class96.field1490[var1]);
      }

      class96.field1499 = 0;
      class96.field1492[++class96.field1499 - 1] = var1;
      class96.field1491[var1] = 0;
      class96.field1489 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1495[var7] = var11 + (var10 << 14) + (var9 << 28);
            class96.field1496[var7] = 0;
            class96.field1497[var7] = -1;
            class96.field1494[++class96.field1489 - 1] = var7;
            class96.field1491[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "138484909"
   )
   static void method1693() {
      if(class11.renderOverview != null) {
         class11.renderOverview.method5115(class45.plane, (Script.localPlayer.x >> 7) + class163.baseX, (Script.localPlayer.y >> 7) + class10.baseY, false);
         class11.renderOverview.method5166();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2135553567"
   )
   public static boolean method1692(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
