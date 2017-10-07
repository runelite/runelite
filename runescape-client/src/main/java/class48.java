import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("aq")
   static Image field637;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -14835633
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -505955231
   )
   static int field638;
   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field635;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -394725093
   )
   int field629;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1460566617
   )
   int field627;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1642685645
   )
   int field633;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 295314389
   )
   int field626;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1226316719
   )
   int field641;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1666073531
   )
   int field631;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1929585057
   )
   int field636;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -939002973
   )
   int field625;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1227818661
   )
   int field628;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1704313553
   )
   int field630;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1359106856"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >= (this.field627 << 6) + (this.field633 << 3) && var1 <= (this.field627 << 6) + (this.field633 << 3) + 7 && var2 >= (this.field636 << 6) + (this.field625 << 3) && var2 <= (this.field636 << 6) + (this.field625 << 3) + 7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1997246299"
   )
   public boolean vmethod725(int var1, int var2, int var3) {
      return var1 >= this.field629 && var1 < this.field626 + this.field629?var2 >= (this.field641 << 6) + (this.field631 << 3) && var2 <= (this.field641 << 6) + (this.field631 << 3) + 7 && var3 >= (this.field628 << 6) + (this.field630 << 3) && var3 <= (this.field628 << 6) + (this.field630 << 3) + 7:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Las;B)V",
      garbageValue = "125"
   )
   public void vmethod723(WorldMapData var1) {
      if(var1.field473 > this.field627) {
         var1.field473 = this.field627;
      }

      if(var1.field474 < this.field627) {
         var1.field474 = this.field627;
      }

      if(var1.field475 > this.field636) {
         var1.field475 = this.field636;
      }

      if(var1.field476 < this.field636) {
         var1.field476 = this.field636;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Lhl;",
      garbageValue = "-58"
   )
   public Coordinates vmethod727(int var1, int var2) {
      if(!this.vmethod722(var1, var2)) {
         return null;
      } else {
         int var3 = this.field641 * 64 - this.field627 * 64 + var1 + (this.field631 * 8 - this.field633 * 8);
         int var4 = this.field628 * 64 - this.field636 * 64 + var2 + (this.field630 * 8 - this.field625 * 8);
         return new Coordinates(this.field629, var3, var4);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-170036108"
   )
   public int[] vmethod741(int var1, int var2, int var3) {
      if(!this.vmethod725(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field627 * 64 - this.field641 * 64) + (this.field633 * 8 - this.field631 * 8), this.field625 * 8 - this.field630 * 8 + var3 + (this.field636 * 64 - this.field628 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "88"
   )
   public void vmethod728(Buffer var1) {
      this.field629 = var1.readUnsignedByte();
      this.field626 = var1.readUnsignedByte();
      this.field641 = var1.readUnsignedShort();
      this.field631 = var1.readUnsignedByte();
      this.field628 = var1.readUnsignedShort();
      this.field630 = var1.readUnsignedByte();
      this.field627 = var1.readUnsignedShort();
      this.field633 = var1.readUnsignedByte();
      this.field636 = var1.readUnsignedShort();
      this.field625 = var1.readUnsignedByte();
      this.method733();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1836073854"
   )
   void method733() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Lfx;IB)Lfx;",
      garbageValue = "3"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "-1"
   )
   static int method735(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class81.field1341:class81.field1340;
      }

      if(var0 == 1927) {
         if(class81.field1344 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2767 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field846 = var3.field2767;
            var4.field854 = class81.field1344 + 1;
            Client.field1112.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
