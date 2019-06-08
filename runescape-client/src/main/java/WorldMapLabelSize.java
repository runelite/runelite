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
   @Export("__s_dq")
   static IndexCache __s_dq;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1577759565
   )
   @Export("__s_fi")
   static int __s_fi;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1252293513
   )
   @Export("__w")
   final int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 707828941
   )
   @Export("__o")
   final int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -422937451
   )
   @Export("__u")
   final int __u;

   static {
      WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);
      WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
      WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
   }

   WorldMapLabelSize(int var1, int var2, int var3) {
      this.__w = var1;
      this.__o = var2;
      this.__u = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "2107231705"
   )
   @Export("__f_14")
   boolean __f_14(float var1) {
      return var1 >= (float)this.__u;
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

      for(int var2 = 0; var2 < var1.length; ++var2) {
         WorldMapLabelSize var3 = var1[var2];
         if(var0 == var3.__o) {
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
      PacketBufferNode var0 = Interpreter.method1915(ClientPacket.__gs_h, Client.packetWriter.isaacCipher);
      Client.packetWriter.__q_167(var0);

      for(WidgetGroupParent var1 = (WidgetGroupParent)Client.widgetGroupParents.first(); var1 != null; var1 = (WidgetGroupParent)Client.widgetGroupParents.next()) {
         if(var1.type == 0 || var1.type == 3) {
            MenuAction.closeWidgetGroup(var1, true);
         }
      }

      if(Client.__client_mo != null) {
         class22.method295(Client.__client_mo);
         Client.__client_mo = null;
      }

   }
}
