import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class45 extends class28 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1570898051
   )
   int field552;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 309855229
   )
   int field547;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -776422321
   )
   int field548;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 868238763
   )
   int field546;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;Lgh;I)V",
      garbageValue = "894697687"
   )
   void method630(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field471.field472) {
         throw new IllegalStateException("");
      } else {
         super.field377 = var2.readUnsignedByte();
         super.field378 = var2.readUnsignedByte();
         super.field383 = var2.readUnsignedShort();
         super.field374 = var2.readUnsignedShort();
         this.field552 = var2.readUnsignedByte();
         this.field547 = var2.readUnsignedByte();
         super.field380 = var2.readUnsignedShort();
         super.field376 = var2.readUnsignedShort();
         this.field548 = var2.readUnsignedByte();
         this.field546 = var2.readUnsignedByte();
         super.field378 = Math.min(super.field378, 4);
         super.field379 = new short[1][64][64];
         super.field375 = new short[super.field378][64][64];
         super.field381 = new byte[super.field378][64][64];
         super.field382 = new byte[super.field378][64][64];
         super.field384 = new class31[super.field378][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field468.field463) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field380 && var5 == super.field376 && var6 == this.field548 && var7 == this.field546) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method241(var8 + this.field548 * 8, var9 + this.field546 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1008844569"
   )
   boolean method631(int var1, int var2) {
      return var1 < this.field548 * 8?false:(var2 < this.field546 * 8?false:(var1 >= this.field548 * 8 + 8?false:var2 < this.field546 * 8 + 8));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "20"
   )
   int method629() {
      return this.field552;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1987420654"
   )
   int method653() {
      return this.field547;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1200785878"
   )
   int method634() {
      return this.field548;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "31531005"
   )
   int method635() {
      return this.field546;
   }

   public int hashCode() {
      return super.field380 | super.field376 << 8 | this.field548 << 16 | this.field546 << 24;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field380 == var2.field380 && var2.field376 == super.field376?this.field548 == var2.field548 && var2.field546 == this.field546:false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "769176139"
   )
   static byte[] method658(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(ZLgy;B)V",
      garbageValue = "-50"
   )
   @Hook("onNpcUpdate")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field888.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5;
               if(var0) {
                  var5 = var1.getBits(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = var1.getBits(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = var1.getBits(1);
               int var7;
               if(var0) {
                  var7 = var1.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = var1.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               var4.composition = Client.getNpcDefinition(var1.getBits(14));
               int var8 = Client.field956[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var8;
               }

               int var9 = var1.getBits(1);
               if(var9 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               var4.field1126 = var4.composition.field3620;
               var4.field1175 = var4.composition.field3648;
               if(var4.field1175 == 0) {
                  var4.angle = 0;
               }

               var4.field1139 = var4.composition.field3631;
               var4.field1131 = var4.composition.field3632;
               var4.field1132 = var4.composition.field3633;
               var4.field1123 = var4.composition.field3634;
               var4.idlePoseAnimation = var4.composition.field3628;
               var4.field1128 = var4.composition.field3644;
               var4.field1176 = var4.composition.field3630;
               var4.method1646(UrlRequest.localPlayer.pathX[0] + var7, UrlRequest.localPlayer.pathY[0] + var5, var6 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
