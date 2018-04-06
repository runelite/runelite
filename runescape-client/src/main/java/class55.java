import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class55 {
   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("x")
   @Export("floorHues")
   static int[] floorHues;
   @ObfuscatedName("bj")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 1122519331
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 1562770555
   )
   static int field660;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldd;I)V",
      garbageValue = "1460268401"
   )
   static final void method837(TaskDataNode var0) {
      var0.field1660 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4330(); var1 != null; var1 = var0.vmethod4321()) {
         method837(var1);
      }

   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-708022895"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      BoundingBox2D.method36();
      ++Client.field957.field1485;
      if(Client.field957.field1485 >= 50 || var0) {
         Client.field957.field1485 = 0;
         if(!Client.socketError && Client.field957.getSocket() != null) {
            PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2452, Client.field957.field1484);
            Client.field957.method2052(var1);

            try {
               Client.field957.method2039();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1935759111"
   )
   static void method834(int var0, int var1, int var2, int var3) {
      Widget var4 = FontName.getWidgetChild(var0, var1);
      if(var4 != null && var4.onTargetEnterListener != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.objs = var4.onTargetEnterListener;
         AbstractSoundSystem.method2256(var5);
      }

      Client.field893 = var3;
      Client.spellSelected = true;
      class234.field2768 = var0;
      Client.field1025 = var1;
      class110.field1607 = var2;
      FontName.method5490(var4);
   }
}
