import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 713765757
   )
   static int field31;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2023683977
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 868779171
   )
   @Export("price")
   public int price;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1704640093
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("u")
   @Export("progress")
   byte progress;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1126911337
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -532628905
   )
   @Export("quantitySold")
   public int quantitySold;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "816027962"
   )
   static final void method41(Actor var0) {
      if(var0.field646 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field633 > CombatInfo2.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field646 - var0.field610;
         int var2 = Client.gameCycle - var0.field610;
         int var3 = var0.field641 * 128 + var0.field603 * 64;
         int var4 = var0.field643 * 128 + var0.field603 * 64;
         int var5 = var0.field603 * 64 + var0.field618 * 128;
         int var6 = var0.field642 * 128 + var0.field603 * 64;
         var0.x = (var3 * (var1 - var2) + var5 * var2) / var1;
         var0.y = (var4 * (var1 - var2) + var2 * var6) / var1;
      }

      var0.field657 = 0;
      var0.field650 = var0.field647;
      var0.angle = var0.field650;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "125"
   )
   public int method44() {
      return this.progress & 7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1368165861"
   )
   void method47(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2025856550"
   )
   public int method51() {
      return (this.progress & 8) == 8?1:0;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2780();
      this.totalQuantity = var1.method2780();
      this.quantitySold = var1.method2780();
      this.spent = var1.method2780();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIS)Z",
      garbageValue = "256"
   )
   static boolean method60(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3272(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class164.method3116(var3);
         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "268318859"
   )
   void method62(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-2070852983"
   )
   static boolean method63(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1900964742"
   )
   static final void method64(int var0, int var1, int var2, boolean var3) {
      if(class94.method1870(var0)) {
         class189.method3445(Widget.widgets[var0], -1, var1, var2, var3);
      }

   }
}
