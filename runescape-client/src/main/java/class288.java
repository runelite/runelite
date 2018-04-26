import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
public class class288 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgl;II)V",
      garbageValue = "-306789499"
   )
   static final void method5266(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class93.field1414 = 0;
      BoundingBox3DDrawMode.method60(var0);

      for(int var3 = 0; var3 < class93.field1414; ++var3) {
         int var4 = class93.field1413[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 32) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         NameableContainer.method5440(var0, var4, var5, var6);
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
