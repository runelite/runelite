import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1161259234"
   )
   static void method68(int var0) {
      ChatLineBuffer.topContextMenuRow = new ContextMenuRow();
      ChatLineBuffer.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      ChatLineBuffer.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      ChatLineBuffer.topContextMenuRow.type = Client.menuTypes[var0];
      ChatLineBuffer.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      ChatLineBuffer.topContextMenuRow.option = Client.menuOptions[var0];
   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1220365681"
   )
   static void method67(int var0) {
      Client.field930 = var0;
   }
}
