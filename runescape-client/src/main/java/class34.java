import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class34 extends class16 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1700730667
   )
   int field295;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -171551537
   )
   int field296;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1855937493
   )
   int field297;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1557370597
   )
   int field298;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;I)V",
      garbageValue = "48186777"
   )
   void method611(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class25.field233.field228) {
         throw new IllegalStateException("");
      } else {
         super.field133 = var2.readUnsignedByte();
         super.field134 = var2.readUnsignedByte();
         super.field131 = var2.readUnsignedShort();
         super.field135 = var2.readUnsignedShort();
         this.field295 = var2.readUnsignedByte();
         this.field296 = var2.readUnsignedByte();
         super.field141 = var2.readUnsignedShort();
         super.field132 = var2.readUnsignedShort();
         this.field297 = var2.readUnsignedByte();
         this.field298 = var2.readUnsignedByte();
         super.field134 = Math.min(super.field134, 4);
         super.field129 = new short[1][64][64];
         super.field130 = new short[super.field134][64][64];
         super.field137 = new byte[super.field134][64][64];
         super.field138 = new byte[super.field134][64][64];
         super.decorations = new WorldMapDecoration[super.field134][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class24.field217.field219) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field141 && var5 == super.field132 && var6 == this.field297 && var7 == this.field298) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method165(var8 + this.field297 * 8, var9 + this.field298 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1449699656"
   )
   boolean method610(int var1, int var2) {
      return var1 < this.field297 * 8?false:(var2 < this.field298 * 8?false:(var1 >= this.field297 * 8 + 8?false:var2 < this.field298 * 8 + 8));
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1684567155"
   )
   int method609() {
      return this.field295;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-853896279"
   )
   int method617() {
      return this.field296;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "43"
   )
   int method614() {
      return this.field297;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-970207843"
   )
   int method615() {
      return this.field298;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class34)) {
         return false;
      } else {
         class34 var2 = (class34)var1;
         return var2.field141 == super.field141 && var2.field132 == super.field132?var2.field297 == this.field297 && this.field298 == var2.field298:false;
      }
   }

   public int hashCode() {
      return super.field141 | super.field132 << 8 | this.field297 << 16 | this.field298 << 24;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-591826488"
   )
   public static void method635() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-47"
   )
   static final void method626(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field795[var4] = true;
         }
      }

   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2064352901"
   )
   static final void method633(String var0) {
      if(!var0.equals("")) {
         PacketNode var1 = DecorativeObject.method3115(ClientPacket.field2176, Client.field739.field1250);
         var1.packetBuffer.putByte(Size.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field739.method2019(var1);
      }
   }
}
