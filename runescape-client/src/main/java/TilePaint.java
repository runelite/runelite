import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("TilePaint")
public final class TilePaint {
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("__eb_ah")
   static Bounds __eb_ah;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 181759449
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1875844515
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1668262341
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1057776035
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 463308567
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("u")
   @Export("isFlat")
   boolean isFlat;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2097947337
   )
   @Export("rgb")
   int rgb;

   TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.isFlat = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.isFlat = var7;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   static final void method3061(int var0, int var1) {
      NodeDeque var2 = Client.groundItems[SoundSystem.plane][var0][var1];
      if(var2 == null) {
         class65.scene.removeGroundItemPile(SoundSystem.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         GroundItem var5 = null;

         GroundItem var6;
         for(var6 = (GroundItem)var2.last(); var6 != null; var6 = (GroundItem)var2.previous()) {
            ItemDefinition var7 = Skills.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class65.scene.removeGroundItemPile(SoundSystem.plane, var0, var1);
         } else {
            var2.addLast(var5);
            GroundItem var11 = null;
            GroundItem var12 = null;

            for(var6 = (GroundItem)var2.last(); var6 != null; var6 = (GroundItem)var2.previous()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var12 == null) {
                     var12 = var6;
                  }
               }
            }

            long var9 = FontName.method5637(var0, var1, 3, false, 0);
            class65.scene.newGroundItemPile(SoundSystem.plane, var0, var1, class32.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, SoundSystem.plane), var5, var9, var11, var12);
         }
      }

   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2025682764"
   )
   static void method3060(int var0, int var1) {
      PacketBufferNode var2 = Interpreter.method1915(ClientPacket.__gs_bg, Client.packetWriter.isaacCipher);
      var2.packetBuffer.writeIntLE16(var0);
      var2.packetBuffer.__bo_322(var1);
      Client.packetWriter.__q_167(var2);
   }
}
