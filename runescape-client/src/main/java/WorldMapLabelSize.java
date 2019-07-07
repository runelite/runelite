import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
   @ObfuscatedName("st")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   @Export("platformInfo")
   static PlatformInfo platformInfo;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   @Export("WorldMapLabelSize_small")
   public static final WorldMapLabelSize WorldMapLabelSize_small;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   @Export("WorldMapLabelSize_medium")
   public static final WorldMapLabelSize WorldMapLabelSize_medium;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   @Export("WorldMapLabelSize_large")
   public static final WorldMapLabelSize WorldMapLabelSize_large;
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static Archive field1040;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1577759565
   )
   static int field1041;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1252293513
   )
   final int field1042;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 707828941
   )
   final int field1043;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -422937451
   )
   final int field1044;

   WorldMapLabelSize(int var1, int var2, int var3) {
      this.field1042 = var1;
      this.field1043 = var2;
      this.field1044 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "2107231705"
   )
   boolean method400(float var1) {
      return var1 >= (float)this.field1044;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Ls;",
      garbageValue = "1579674051"
   )
   static WorldMapLabelSize[] method192() {
      return new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_medium, WorldMapLabelSize_large};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ls;",
      garbageValue = "-67"
   )
   static WorldMapLabelSize method195(int var0) {
      WorldMapLabelSize[] var1 = method192();

      for (int var2 = 0; var2 < var1.length; ++var2) {
         WorldMapLabelSize var3 = var1[var2];
         if (var0 == var3.field1043) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-187598326"
   )
   static final void method198() {
      PacketBufferNode var0 = Interpreter.method1915(ClientPacket.field242, Client.packetWriter.isaacCipher);
      Client.packetWriter.method241(var0);

      for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
         if (var1.type == 0 || var1.type == 3) {
            MenuAction.closeInterface(var1, true);
         }
      }

      if (Client.field127 != null) {
         class22.method295(Client.field127);
         Client.field127 = null;
      }

   }

   static {
      WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);
      WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
      WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
   }
}
