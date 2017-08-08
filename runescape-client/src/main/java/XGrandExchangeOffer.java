import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("e")
   @Export("progress")
   byte progress;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 394747299
   )
   @Export("price")
   public int price;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1700802879
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2084348071
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1886030031
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 202944531
   )
   @Export("spent")
   public int spent;

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfh;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1717507815"
   )
   void method99(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2025105294"
   )
   void method104(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "77"
   )
   public int method101() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "24687608"
   )
   public int method97() {
      return this.progress & 7;
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-26771948"
   )
   static void method113() {
      Client.secretPacketBuffer1.putOpcode(30);
      Client.secretPacketBuffer1.putByte(Tile.method2512());
      Client.secretPacketBuffer1.putShort(NPC.canvasWidth);
      Client.secretPacketBuffer1.putShort(InvType.canvasHeight);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-437517477"
   )
   static final void method98(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1157 - Client.field1183) * var5 / 100 + Client.field1183;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1162) {
         var15 = Client.field1162;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1161) {
            var6 = Client.field1161;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4973(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4973(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1163) {
         var15 = Client.field1163;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field964) {
            var6 = Client.field964;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4973(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4973(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1062 - Client.field1158) * var5 / 100 + Client.field1158;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = 600 + var11 * 3;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2846(var14, 500, 800, var2, var3);
      }

      Client.field1164 = var0;
      Client.field1165 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "922096685"
   )
   public static void method114(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class212.field2583[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class212.widgetSettings[var4] = class212.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Lhg;IB)Ljava/lang/String;",
      garbageValue = "8"
   )
   static String method115(Widget var0, int var1) {
      return !Signlink.method2963(class15.getWidgetConfig(var0), var1) && var0.field2723 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
