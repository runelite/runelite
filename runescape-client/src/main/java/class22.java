import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("l")
public class class22 extends class28 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;Lfg;I)V",
      garbageValue = "1738092484"
   )
   void method153(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field522.field523) {
         throw new IllegalStateException("");
      } else {
         super.field425 = var2.readUnsignedByte();
         super.field419 = var2.readUnsignedByte();
         super.field418 = var2.readUnsignedShort();
         super.field426 = var2.readUnsignedShort();
         super.field416 = var2.readUnsignedShort();
         super.field417 = var2.readUnsignedShort();
         super.field419 = Math.min(super.field419, 4);
         super.field420 = new short[1][64][64];
         super.field421 = new short[super.field419][64][64];
         super.field422 = new byte[super.field419][64][64];
         super.field423 = new byte[super.field419][64][64];
         super.field424 = new class31[super.field419][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field515.field513) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field416 && var5 == super.field417) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method228(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field416 | super.field417 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field416 == super.field416 && super.field417 == var2.field417;
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(Lhj;III)V",
      garbageValue = "-795578561"
   )
   static final void method161(Widget var0, int var1, int var2) {
      if(Client.field1183 == 0 || Client.field1183 == 3) {
         if(MouseInput.field741 == 1 || !class110.field1650 && MouseInput.field741 == 4) {
            class210 var3 = var0.method4117(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field752 - var1;
            int var5 = MouseInput.field753 - var2;
            if(var3.method4042(var4, var5)) {
               var4 -= var3.field2615 / 2;
               var5 -= var3.field2611 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var5 * var7 + var8 * var4 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + AbstractByteBuffer.localPlayer.x >> 7;
               int var12 = AbstractByteBuffer.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_MINIMAP_WALK);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(18);
               } else {
                  Client.secretPacketBuffer1.putByte(18);
               }

               Client.secretPacketBuffer1.method3261(KeyFocusListener.field655[82]?(KeyFocusListener.field655[81]?2:1):0);
               Client.secretPacketBuffer1.putShortLE(var11 + WallObject.baseX);
               Client.secretPacketBuffer1.putShort(var12 + Varcs.baseY);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(AbstractByteBuffer.localPlayer.x);
               Client.secretPacketBuffer1.putShort(AbstractByteBuffer.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lhj;IIIIIII)V",
      garbageValue = "1793645415"
   )
   static final void method154(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field993) {
         Client.field994 = 32;
      } else {
         Client.field994 = 0;
      }

      Client.field993 = false;
      int var7;
      if(MouseInput.field738 == 1 || !class110.field1650 && MouseInput.field738 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class25.method172(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class25.method172(var0);
         } else if(var5 >= var1 - Client.field994 && var5 < Client.field994 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class25.method172(var0);
            Client.field993 = true;
         }
      }

      if(Client.field1111 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field1111 * 45;
            class25.method172(var0);
         }
      }

   }
}
