import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class22 extends class28 {
   @ObfuscatedName("q")
   @Export("userHome")
   public static String userHome;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;Lgp;I)V",
      garbageValue = "-1880953807"
   )
   void method176(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field481.field483) {
         throw new IllegalStateException("");
      } else {
         super.field392 = var2.readUnsignedByte();
         super.field391 = var2.readUnsignedByte();
         super.field390 = var2.readUnsignedShort();
         super.field387 = var2.readUnsignedShort();
         super.field386 = var2.readUnsignedShort();
         super.field389 = var2.readUnsignedShort();
         super.field391 = Math.min(super.field391, 4);
         super.field388 = new short[1][64][64];
         super.field393 = new short[super.field391][64][64];
         super.field394 = new byte[super.field391][64][64];
         super.field395 = new byte[super.field391][64][64];
         super.decorations = new WorldMapDecoration[super.field391][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field477.field474) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field386 && var5 == super.field389) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method241(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field386 == var2.field386 && var2.field389 == super.field389;
      }
   }

   public int hashCode() {
      return super.field386 | super.field389 << 8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method186(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "609703079"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class44.getSmoothNoise2D(var3, var5);
      int var8 = class44.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class44.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class44.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
      return var15;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "26"
   )
   static int method185(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class336.field4073:class61.field713;
      if(var0 == 1700) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "583198239"
   )
   static final void method187(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         Player.worldToScreen((Client.hintArrowX - PacketNode.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - BaseVarType.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            class47.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }
}
