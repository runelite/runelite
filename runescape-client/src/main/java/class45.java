import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class45 extends WorldMapData {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1980402669
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("e")
   HashSet field557;
   @ObfuscatedName("f")
   HashSet field554;
   @ObfuscatedName("l")
   List field555;

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(Lgp;Lgp;Lgp;IZI)V",
      garbageValue = "891609718"
   )
   void method663(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field557 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method176(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field557.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field554 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class46 var9 = new class46();

         try {
            var9.method673(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field554.add(var9);
      }

      this.method664(var2, var5);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lgp;ZI)V",
      garbageValue = "1505623943"
   )
   void method664(Buffer var1, boolean var2) {
      this.field555 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3603();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field555.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-865429005"
   )
   static void method670() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "(Lib;I)I",
      garbageValue = "2084232661"
   )
   @Export("getWidgetClickMask")
   static int getWidgetClickMask(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.clickMask;
   }
}
