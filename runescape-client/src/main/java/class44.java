import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class44 extends WorldMapData {
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1087500159
   )
   static int field596;
   @ObfuscatedName("u")
   HashSet field600;
   @ObfuscatedName("t")
   HashSet field599;
   @ObfuscatedName("a")
   List field598;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lfz;Lfz;Lfz;IZI)V",
      garbageValue = "-1029921073"
   )
   void method616(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field600 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method167(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field600.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field599 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method626(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field599.add(var9);
      }

      this.method622(var2, var5);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(Lfz;ZB)V",
      garbageValue = "51"
   )
   void method622(Buffer var1, boolean var2) {
      this.field598 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3264();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field598.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1151899359"
   )
   public static int method623(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   static void method621() {
      class29.method249(class66.localPlayer, false);
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-358019367"
   )
   static void method615() {
      class148.method2940();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.field1161[0] = false;
      Client.menuOptionCount = 1;
   }
}
