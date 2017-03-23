import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class2 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -8957303264739180699L
   )
   public final long field18;
   @ObfuscatedName("u")
   public final XGrandExchangeOffer field19;
   @ObfuscatedName("r")
   String field21;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1465916163
   )
   public final int field22;
   @ObfuscatedName("nq")
   static class57 field23;
   @ObfuscatedName("h")
   String field26;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1719204386"
   )
   static final void method9(Widget var0, int var1, int var2) {
      if(Client.field539 == 0 || Client.field539 == 3) {
         if(class115.field1823 == 1 || !class177.field2687 && class115.field1823 == 4) {
            class164 var3 = var0.method3288(true);
            if(null == var3) {
               return;
            }

            int var4 = class115.field1825 - var1;
            int var5 = class115.field1813 - var2;
            if(var3.method3189(var4, var5)) {
               var4 -= var3.field2174 / 2;
               var5 -= var3.field2172 / 2;
               int var6 = Client.mapAngle + Client.mapScale & 2047;
               int var7 = class84.field1475[var6];
               int var8 = class84.field1469[var6];
               var7 = (256 + Client.mapScaleDelta) * var7 >> 8;
               var8 = (256 + Client.mapScaleDelta) * var8 >> 8;
               int var9 = var5 * var7 + var8 * var4 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = Projectile.localPlayer.x + var9 >> 7;
               int var12 = Projectile.localPlayer.y - var10 >> 7;
               Client.secretCipherBuffer1.putOpcode(229);
               Client.secretCipherBuffer1.putByte(18);
               Client.secretCipherBuffer1.method2893(class105.field1734[82]?(class105.field1734[81]?2:1):0);
               Client.secretCipherBuffer1.method2900(class187.baseY + var12);
               Client.secretCipherBuffer1.method2895(var11 + class119.baseX);
               Client.secretCipherBuffer1.putByte(var4);
               Client.secretCipherBuffer1.putByte(var5);
               Client.secretCipherBuffer1.putShort(Client.mapAngle);
               Client.secretCipherBuffer1.putByte(57);
               Client.secretCipherBuffer1.putByte(Client.mapScale);
               Client.secretCipherBuffer1.putByte(Client.mapScaleDelta);
               Client.secretCipherBuffer1.putByte(89);
               Client.secretCipherBuffer1.putShort(Projectile.localPlayer.x);
               Client.secretCipherBuffer1.putShort(Projectile.localPlayer.y);
               Client.secretCipherBuffer1.putByte(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "199023248"
   )
   public String method10() {
      return this.field26;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field26 = var1.readString();
      this.field21 = var1.readString();
      this.field22 = var1.readUnsignedShort();
      this.field18 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field19 = new XGrandExchangeOffer();
      this.field19.method33(2);
      this.field19.method34(var2);
      this.field19.price = var4;
      this.field19.totalQuantity = var5;
      this.field19.quantitySold = 0;
      this.field19.spent = 0;
      this.field19.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "31447"
   )
   public String method15() {
      return this.field21;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-1922995505"
   )
   static void method16(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class65.method1205(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class65.method1205(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2417((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(Ignore.method178(var6)) {
            class65.method1205(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "-799896479"
   )
   static World method17() {
      World.field697 = 0;
      return TextureProvider.method1482();
   }
}
